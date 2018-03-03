# Copyright (C) 2007-2016 Hypertable, Inc.
#
# This file is part of Hypertable.
#
# Hypertable is free software; you can redistribute it and/or
# modify it under the terms of the GNU General Public License
# as published by the Free Software Foundation; either version 3
# of the License, or any later version.
#
# Hypertable is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with Hypertable. If not, see <http://www.gnu.org/licenses/>
#

# This is used by many thrift targets to guard against make clean
macro(HT_GLOB var)
  file(GLOB_RECURSE ${var} ${ARGN})
  if (NOT ${var}) # make clean would remove generated files
    # add a dummy target here
    set(${var} "${var}_DUMMY")
  endif ()
  #message(STATUS "${var}: ${${var}}")
endmacro()

if (PACKAGE_THRIFTBROKER)
  set(HT_COMPONENT_INSTALL true)
  message(STATUS "Prepare for ThriftBroker only installation")
endif ()



macro(HT_GET_SONAME var fpath)
  exec_program(${CMAKE_SOURCE_DIR}/bin/src-utils/soname.sh ARGS ${fpath}
               OUTPUT_VARIABLE SONAME_OUT RETURN_VALUE SONAME_RETURN)
  set(${var})

  if (SONAME_RETURN STREQUAL "0")
    set(${var} ${SONAME_OUT})
  endif ()

  if (NOT ${var})
    get_filename_component(${var} ${fpath} NAME)
  endif ()

  if (HT_CMAKE_DEBUG)
    message("SONAME: ${fpath} -> ${${var}}")
  endif ()

  # check if the library is prelinked, if so, warn
  exec_program(env ARGS objdump -h ${fpath} OUTPUT_VARIABLE ODH_OUT
               RETURN_VALUE ODH_RETURN)
  if (ODH_RETURN STREQUAL "0")
    string(REGEX MATCH "prelink_undo" match ${ODH_OUT})
    if (match)
      message("WARNING: ${fpath} is prelinked, RPMs may require --nomd5")
    endif ()
  endif ()
endmacro()

# This is a workaround for install() which always preserves symlinks
macro(HT_INSTALL_LIBS dest)
 if (NOT HT_COMPONENT_INSTALL)
  if (INSTALL_EXCLUDE_DEPENDENT_LIBS)
    message(STATUS "       Not installing dependent libraries")
  else ()
    foreach(fpath ${ARGN})
      if (NOT ${fpath} MATCHES "(NOTFOUND|\\.a)$")
        if (HT_CMAKE_DEBUG)
          message(STATUS "install copy: ${fpath}")
        endif ()
        HT_GET_SONAME(soname ${fpath})
        configure_file(${fpath} "${dest}/${soname}" COPYONLY)
        install(FILES "${CMAKE_BINARY_DIR}/${dest}/${soname}" DESTINATION ${dest})
      elseif (${fpath} MATCHES "\\.a$")
         message(STATUS "       Not installing static library: ${fpath}")
      endif ()
    endforeach()
  endif ()
 endif ()
endmacro()


##### HT_FASTLIB_SET
	# HT_FASTLIB_SET(
	#	NAME 	  	CAP.NAME
	#	REQUIRED  	BOOL
	#	LIB_PATHS  	SEARCH_PATHS
	#	INC_PATHS  	SEARCH_PATHS
	#	STATIC 		STATIC_LIBS
	#	SHARED 		SHARED_LIBS
	#	INCLUDE 	HEADER FILES
	# )
function(HT_FASTLIB_SET)
	set(oneValueArgs NAME REQUIRED)
	set(multiValueArgs LIB_PATHS INC_PATHS STATIC SHARED INCLUDE)
	cmake_parse_arguments(HT_FASTLIB_SET "${options}" "${oneValueArgs}" "${multiValueArgs}" ${ARGN} )
	
	# message(STATUS "HT_FASTLIB_SET: 
	#					${HT_FASTLIB_SET_NAME}
	#					${HT_FASTLIB_SET_REQUIRED} 
	#					${HT_FASTLIB_SET_LIB_PATHS} 
	#					${HT_FASTLIB_SET_INC_PATHS} 
	#					${HT_FASTLIB_SET_STATIC} 
	#					${HT_FASTLIB_SET_SHARED}
	#					${HT_FASTLIB_SET_INCLUDE}")
	
	# explicit lookup
	foreach(path ${HT_FASTLIB_SET_INC_PATHS}  ${HT_DEPENDENCY_INCLUDE_DIR} 
				 /opt/local/include  /usr/local/include  /usr/include)
				
		foreach(inc_h ${HT_FASTLIB_SET_INCLUDE})
			if(EXISTS ${path}/${inc_h} AND NOT INCLUDE_DIR${inc_h})
				set(INCLUDE_DIR${inc_h} ${path})	
			endif ()
		endforeach()
		
		set(INCLUDE_DIRS)
		foreach(inc_h ${HT_FASTLIB_SET_INCLUDE})
			if(INCLUDE_DIR${inc_h})
				set(INCLUDE_DIRS ${INCLUDE_DIRS} ${INCLUDE_DIR${inc_h}})
			else()
				set(INCLUDE_DIRS)
				break()
			endif ()	
		endforeach()	
		if(INCLUDE_DIRS)
			break()
		endif ()
	endforeach()

	HT_FIND_LIB(
		OUTPUT LIBRARY
		PATHS  ${HT_FASTLIB_SET_LIB_PATHS}
		STATIC ${HT_FASTLIB_SET_STATIC}
		SHARED ${HT_FASTLIB_SET_SHARED}
	)
	if (INCLUDE_DIRS AND LIBRARY)
		include_directories(${INCLUDE_DIRS})
		set("${HT_FASTLIB_SET_NAME}_FOUND" TRUE)
		set("${HT_FASTLIB_SET_NAME}_LIBRARIES" ${LIBRARY})
		
		message(STATUS "Found lib ${HT_FASTLIB_SET_NAME}: ${${HT_FASTLIB_SET_NAME}_LIBRARIES}")
		message(STATUS "       Include path: ${INCLUDE_DIRS}")
		
		HT_INSTALL_LIBS(lib ${${HT_FASTLIB_SET_NAME}_LIBRARIES})
	else ()
		set("${HT_FASTLIB_SET_NAME}_FOUND" FALSE)
		set("${HT_FASTLIB_SET_NAME}_LIBRARIES")
		message(STATUS "Not Found lib ${HT_FASTLIB_SET_NAME}: ${HT_FASTLIB_SET_SHARED} ${HT_FASTLIB_SET_STATIC}")
		if (${HT_FASTLIB_SET_REQUIRED})
			message(FATAL_ERROR "Could NOT find ${HT_FASTLIB_SET_NAME} library")
		endif ()
	endif ()
		
	set("${HT_FASTLIB_SET_NAME}_FOUND"  ${${HT_FASTLIB_SET_NAME}_FOUND} PARENT_SCOPE)
	set("${HT_FASTLIB_SET_NAME}_LIBRARIES" ${${HT_FASTLIB_SET_NAME}_LIBRARIES} PARENT_SCOPE)
	set("${HT_FASTLIB_SET_NAME}_INCLUDE_DIR" ${INCLUDE_DIRS} PARENT_SCOPE)
	
endfunction()

##### HT_FIND_LIB
	# HT_FIND_LIB(
	#	OUTPUT VAR_NAME
	#	PATHS  SEARCH_PATHS
	#	STATIC STATIC_LIBS
	#	SHARED SHARED_LIBS
	# )
function(HT_FIND_LIB)
	set(oneValueArgs OUTPUT)
	set(multiValueArgs PATHS STATIC SHARED)
	cmake_parse_arguments(HT_FIND_LIB "${options}" "${oneValueArgs}" "${multiValueArgs}" ${ARGN} )
	
	if(BUILD_WITH_STATIC AND HT_FIND_LIB_STATIC)
		set(HT_FIND_LIB_LIBS ${HT_FIND_LIB_STATIC})
	else()
		set(HT_FIND_LIB_LIBS ${HT_FIND_LIB_SHARED})
	endif ()
	
	# message(STATUS "HT_FIND_LIB: ${HT_FIND_LIB_OUTPUT} ${HT_FIND_LIB_PATHS} ${HT_FIND_LIB_STATIC} ${HT_FIND_LIB_SHARED}")
	set("${HT_FIND_LIB_OUTPUT}" "")
	foreach(lib ${HT_FIND_LIB_LIBS})
		# message(STATUS "looking for: ${lib}")
		find_library(
			HT_FOUND_${lib} 
			NAMES ${lib}
			PATHS ${HT_FIND_LIB_PATHS} 
				  ${HT_DEPENDENCY_LIB_DIR} 
				  /opt/local/lib 
				  /usr/local/lib  
				  /usr/lib  
				  /lib 
		)
		set("${HT_FIND_LIB_OUTPUT}" ${${HT_FIND_LIB_OUTPUT}} ${HT_FOUND_${lib}})
    endforeach()
	set("${HT_FIND_LIB_OUTPUT}" ${${HT_FIND_LIB_OUTPUT}} PARENT_SCOPE)
	# message(STATUS "HT_FOUND_LIB: ${HT_FIND_LIB_OUTPUT} ${${HT_FIND_LIB_OUTPUT}}")
endfunction()


##### Buld static and Shared libs or as requested, default both
	# HT_ADD_LIBS(
	#	TARGET libNameTarget 
	#	SRCS   sourceToCompile
	#	TARGETS   targets-dependant
	#	DEPENDENCIES dependenciesOfTheTarget
	# )
function(HT_ADD_LIBS)
	set(oneValueArgs TARGET)
	set(multiValueArgs SRCS TARGETS DEPENDENCIES)
	cmake_parse_arguments(HT_ADD_LIBS "${options}" "${oneValueArgs}" "${multiValueArgs}" ${ARGN} )
  
	add_library(obj${HT_ADD_LIBS_TARGET} OBJECT ${HT_ADD_LIBS_SRCS})
	add_library(${HT_ADD_LIBS_TARGET} STATIC $<TARGET_OBJECTS:obj${HT_ADD_LIBS_TARGET}>)
	
	
	set(HT_ADD_LIBS_DEPS )
	foreach(lib ${HT_ADD_LIBS_DEPENDENCIES})
		if ("${lib}" MATCHES "\\.a$")
			set(HT_ADD_LIBS_STATIC_DEPS ${HT_ADD_LIBS_STATIC_DEPS} "${lib}")
		else ()
			set(HT_ADD_LIBS_DEPS ${HT_ADD_LIBS_DEPS} "${lib}")
		endif ()
	endforeach()
	
	if(HT_ADD_LIBS_STATIC_DEPS)
		string(REPLACE ";" " " HT_ADD_LIBS_STATIC_DEPS "${HT_ADD_LIBS_STATIC_DEPS}")
		if (WIN32)
			set(HT_ADD_LIBS_STATIC_DEPS "/WHOLEARCHIVE ${HT_ADD_LIBS_STATIC_DEPS} /NOWHOLEARCHIVE")
		elseif (APPLE)
			set(HT_ADD_LIBS_STATIC_DEPS "-Wl,--all_load ${HT_ADD_LIBS_STATIC_DEPS} -Wl,--no-all_load")
		else ()
			set(HT_ADD_LIBS_STATIC_DEPS "-Wl,--whole-archive ${HT_ADD_LIBS_STATIC_DEPS} -Wl,--no-whole-archive")
		endif ()
	endif ()
	
	set(HT_ADD_LIBS_DEPS ${HT_ADD_LIBS_DEPS} "${HT_ADD_LIBS_STATIC_DEPS}")
	# message(STATUS "shared libs flags: ${HT_ADD_LIBS_DEPS}")

	if (ENABLE_SHARED)
		set(SHARED_TARGETS)
		foreach(lib ${HT_ADD_LIBS_TARGETS})
			set(SHARED_TARGETS ${SHARED_TARGETS} ${lib}-shared)
		endforeach()
		
		set_property(TARGET obj${HT_ADD_LIBS_TARGET} PROPERTY POSITION_INDEPENDENT_CODE 1)
		add_library(${HT_ADD_LIBS_TARGET}-shared SHARED $<TARGET_OBJECTS:obj${HT_ADD_LIBS_TARGET}>)
		SET_TARGET_PROPERTIES(${HT_ADD_LIBS_TARGET}-shared PROPERTIES OUTPUT_NAME ${HT_ADD_LIBS_TARGET} CLEAN_DIRECT_OUTPUT 1)
		# SET_TARGET_PROPERTIES(${HT_ADD_LIBS_TARGET}-shared PROPERTIES VERSION ${VERSION} SOVERSION ${VERSION})
		target_link_libraries(${HT_ADD_LIBS_TARGET}-shared ${HT_ADD_LIBS_DEPS} ${SHARED_TARGETS})

		if (NOT HT_COMPONENT_INSTALL)
			install(TARGETS ${HT_ADD_LIBS_TARGET}-shared LIBRARY DESTINATION lib)
		endif ()
	endif ()
	
	target_link_libraries(${HT_ADD_LIBS_TARGET} ${HT_ADD_LIBS_DEPS} ${HT_ADD_LIBS_TARGETS})
endfunction()


##### Add build test-target for Shared targerts and/or Static targets
	# HT_ADD_TEST(
	#	NAME test-name 
	#	SRCS sourceToCompile
	#	TARGETS  targets
	#	EXT_LIBS external dependencies
	# )
function(HT_ADD_TEST)
	set(oneValueArgs NAME)
	set(multiValueArgs SRCS TARGETS EXT_LIBS)
	cmake_parse_arguments(HT_ADD_TEST "${options}" "${oneValueArgs}" "${multiValueArgs}" ${ARGN} )

	if (ENABLE_SHARED AND (NOT HT_TEST_WITH OR HT_TEST_WITH STREQUAL "SHARED" OR HT_TEST_WITH STREQUAL "BOTH"))
		add_executable(testShared-${HT_ADD_TEST_NAME} ${HT_ADD_TEST_SRCS})
		set(testTargets)
		foreach(target ${HT_ADD_TEST_TARGETS})
			set(testTargets ${testTargets} ${target}-shared)
		endforeach()
		target_link_libraries(testShared-${HT_ADD_TEST_NAME} ${HT_ADD_TEST_EXT_LIBS} ${testTargets})
	endif ()
	if (HT_TEST_WITH STREQUAL "STATIC" OR HT_TEST_WITH STREQUAL "BOTH")
		add_executable(testStatic-${HT_ADD_TEST_NAME} ${HT_ADD_TEST_SRCS})
		set(testTargets)
		foreach(target ${HT_ADD_TEST_TARGETS})
			set(testTargets ${testTargets} ${target})
		endforeach()
		target_link_libraries(testStatic-${HT_ADD_TEST_NAME} ${HT_ADD_TEST_EXT_LIBS} ${testTargets})
	endif ()
	
endfunction()
