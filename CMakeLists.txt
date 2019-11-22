#
# Copyright (C) 2007-2016 Hypertable, Inc.
#
# This program is free software; you can redistribute it and/or
# modify it under the terms of the GNU General Public License
# as published by the Free Software Foundation; either version 3
# of the License, or any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program; if not, write to the Free Software
# Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
# 02110-1301, USA.
#

project(HYPERTABLE)

# Hypertable version components
set(VERSION_MAJOR "0")
set(VERSION_MINOR "9")
set(VERSION_MICRO "8")
set(VERSION_PATCH "17")
#set(VERSION_MISC_SUFFIX  "pre12")

# cmake behavior compatibility
cmake_minimum_required(VERSION 3.10)
mark_as_advanced(CMAKE_BACKWARDS_COMPATIBILITY)

# saner control structure syntax
set(CMAKE_ALLOW_LOOSE_LOOP_CONSTRUCTS true)

if (COMMAND cmake_policy)
  # we prefer the more strict behavior, to find out more:
  # cmake --help-policy CMP0003
  cmake_policy(SET CMP0003 NEW)
endif ()


# C++ flags
SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -D_REENTRANT")
SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -D_LARGEFILE_SOURCE")
SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -D_FILE_OFFSET_BITS=64")
SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -m64")
# SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fPIC") it is set at target object
SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17 -U__STRICT_ANSI__")

SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -pedantic")

SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -Wno-terminate")
SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -Wall -Wno-unknown-pragmas")


# -----------------  OPTIMIZATIONS and BUILD TYPE

# Something nice for GUI like ccmake
if (NOT CMAKE_BUILD_TYPE)
  set(CMAKE_BUILD_TYPE Debug CACHE STRING
      "Options: None Debug Release RelWithDebInfo MinSizeRel." FORCE)
endif ()

message(STATUS "Optimization Level: " ${HT_O_LEVEL})
if(NOT HT_O_LEVEL)
  SET (CMAKE_CXX_FLAGS_RELEASE        "-O3 -DNDEBUG")

else()
  SET (CMAKE_CXX_FLAGS_RELEASE        "-DNDEBUG")
  SET (CMAKE_CXX_FLAGS_DEBUG          "")

  if(HT_O_LEVEL MATCHES "[1-2]")
    SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O2")
    
    if (HT_O_LEVEL STREQUAL "2")
  	  SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -flto -fuse-linker-plugin -ffat-lto-objects")
      SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -floop-interchange")
    endif ()

  elseif(HT_O_LEVEL MATCHES "[3-7]")
    SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3")
    
    if(HT_O_LEVEL MATCHES "[4-7]")
  	  SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -flto -fuse-linker-plugin -ffat-lto-objects")
      # SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fsection-anchors")
    
      if(HT_O_LEVEL MATCHES "[5-7]")
        set(BUILD_LINKING "STATIC")
        set(TEST_LINKING "DUAL")
      endif ()

      if(HT_O_LEVEL MATCHES "[6-7]")
        set(BUILD_LINKING_CORE "STATIC")
      endif ()

      if(HT_O_LEVEL MATCHES "[7-7]")
        set(LIBS_SHARED_LINKING "STATIC")
      endif ()
    endif ()
      
  endif ()

endif ()


# -----------------  COMPILERS SPECIFIC

#uname -p says i386, but we know better when its x86 apple
if (APPLE AND "${CMAKE_SYSTEM_PROCESSOR}" STREQUAL "i386")
    SET(CMAKE_SYSTEM_PROCESSOR "x86_64")
endif ()
#detect 32 or 64 bit compiler
if (CMAKE_SYSTEM_PROCESSOR MATCHES "^(i.86|x86|x86_64)$")
    include(CheckTypeSize)
    check_type_size("void*" SIZEOF_VOID_P BUILTIN_TYPES_ONLY)
    if (${SIZEOF_VOID_P} EQUAL 8)
        set(CMAKE_SYSTEM_PROCESSOR_x86 64)
    else ()
        set(CMAKE_SYSTEM_PROCESSOR_x86 32)
    endif ()
endif ()

if (NOT LLVM AND (CMAKE_COMPILER_IS_GNUCC OR CMAKE_COMPILER_IS_GNUCXX))

	# gcc warning settings
  if (${CMAKE_SYSTEM_NAME} MATCHES "SunOS")
    SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -Wno-long-long -pthreads")
  else (${CMAKE_SYSTEM_NAME} MATCHES "SunOS")
    SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -Wno-long-long")
	endif (${CMAKE_SYSTEM_NAME} MATCHES "SunOS")
	
	if (GCC_VERSION MATCHES "^([4-9]|[1-9][0-9]+)\\.")
		SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -Wno-variadic-macros")
		# turn off deprecated feature warnings for gcc 4.3+
		if (GCC_VERSION MATCHES "^([4-9]|[1-9][0-9]+)\\.([3-9]|[1-9][0-9]+)")
			# SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -Wno-deprecated")
		endif ()
	elseif (GCC_VERSION MATCHES "^([4-9]|[1-9][0-9]+)\\.")
		message(STATUS "Ancient gcc detected, hope it finishes despite warnings...")
	endif ()
endif ()






# Use llvm instead of gcc
if (LLVM)
  message(STATUS "Using llvm: ${LLVM}")
  SET (CMAKE_C_COMPILER             "${LLVM}/bin/clang")
  SET (CMAKE_C_FLAGS                "-Wall -Wno-unknown-pragmas -std=c99")
  if (ADDRESS_SANITIZER)
    SET (CMAKE_C_FLAGS_DEBUG        "-fsanitize=address -O1 -fno-omit-frame-pointer -g")
  else ()
    SET (CMAKE_C_FLAGS_DEBUG        "-g")
  endif ()
  SET (CMAKE_C_FLAGS_MINSIZEREL     "-Os -DNDEBUG")
  SET (CMAKE_C_FLAGS_RELEASE        "-O3 -DNDEBUG")
  SET (CMAKE_C_FLAGS_RELWITHDEBINFO "-O2 -g")

  SET (CMAKE_CXX_COMPILER             "${LLVM}/bin/clang++")
  SET (CMAKE_CXX_FLAGS                "-Wall -Wno-unknown-pragmas")
  if (ADDRESS_SANITIZER)
    SET (CMAKE_CXX_FLAGS_DEBUG        "-fsanitize=address -O1 -fno-omit-frame-pointer -g")
  else ()
    SET (CMAKE_CXX_FLAGS_DEBUG        "-g")
  endif ()
  SET (CMAKE_CXX_FLAGS_MINSIZEREL     "-Os -DNDEBUG")
  SET (CMAKE_CXX_FLAGS_RELEASE        "-O3 -DNDEBUG")
  SET (CMAKE_CXX_FLAGS_RELWITHDEBINFO "-O2 -g")

  if (NOT APPLE)
    LINK_LIBRARIES(tinfo)
  endif ()

elseif (ADDRESS_SANITIZER)
  MESSAGE (FATAL_ERROR "ADDRESS_SANITIZER can only be used in conjunction with LLVM")
endif ()

if (ASAN)
  SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fsanitize=address")
  SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fno-omit-frame-pointer")
endif ()

if (APPLE)
   SET (CMAKE_EXE_LINKER_FLAGS "-framework IOKit -framework CoreFoundation")
endif ()













# install directory prefix
if (CMAKE_INSTALL_PREFIX_INITIALIZED_TO_DEFAULT)
  set(CMAKE_INSTALL_PREFIX "/opt/hypertable"
      CACHE PATH "installation directory prefix" FORCE)
endif ()

# A simple test helper
set(TEST_DIFF ${HYPERTABLE_SOURCE_DIR}/bin/src-utils/testdiff)


# Locate required packages
set(CMAKE_MODULE_PATH ${CMAKE_SOURCE_DIR}/cmake)


# A more informative hypertable version string
include(VersionHelper)

# Verison install directory
set(CMAKE_INSTALL_PREFIX ${CMAKE_INSTALL_PREFIX}/${VERSION})
set(INSTALL_DIR ${CMAKE_INSTALL_PREFIX})


if (HT_DEPENDENCY_DIR)
  set(HT_DEPENDENCY_LIB_DIR ${HT_DEPENDENCY_DIR}/lib)
	set(HT_DEPENDENCY_INCLUDE_DIR ${HT_DEPENDENCY_DIR}/include)
endif ()

set(LOOKUP_LIB_PATHS 	
	${HT_DEPENDENCY_LIB_DIR}
	/opt/local/lib 
	/usr/local/lib  
	/usr/lib  
	/lib 
)
set(LOOKUP_INCLUDE_PATHS 
	${HT_DEPENDENCY_INCLUDE_DIR}
	/opt/local/include 
	/usr/local/include 
	/usr/include
)		

include(Utils)

include(CommonUtil)





# Packages Core
include(PackagesCore)

# Packages Common
include(PackagesCommon)

# Packages Languages and FileSystems  
include(PackagesLangsFileSystems)




# project include paths
include_directories(
	src/cc
  src/cc/ThirdParty/sigar
  ${HYPERTABLE_BINARY_DIR}/src/cc
)


include(TestHelper)
include(DocHelper)


# project directories
list(REMOVE_DUPLICATES CMAKE_C_FLAGS)
list(REMOVE_DUPLICATES CMAKE_CXX_FLAGS)
add_subdirectory(src)
add_subdirectory(examples)
add_subdirectory(contrib)
add_subdirectory(tests/integration)



# install

configure_file(bin/ht.in ht @ONLY)
configure_file(bin/postinst.in postinst @ONLY)
configure_file(bin/prerm.in prerm @ONLY)

file(GLOB CONFS conf/[^.]*)
install(FILES ${CONFS} DESTINATION conf)
install(PROGRAMS ${HYPERTABLE_BINARY_DIR}/ht DESTINATION bin)

configure_file(conf/hypertable.cfg.in conf/hypertable.cfg @ONLY)
install(FILES ${HYPERTABLE_BINARY_DIR}/conf/hypertable.cfg DESTINATION conf)


if (NOT HT_COMPONENT_INSTALL)
  file(GLOB SCRIPTS bin/*.sh)
  install(PROGRAMS ${SCRIPTS} DESTINATION bin)
  install(DIRECTORY examples/apache_log DESTINATION examples
          USE_SOURCE_PERMISSIONS)
  install(DIRECTORY examples/hql_tutorial DESTINATION examples
          USE_SOURCE_PERMISSIONS)
  install(DIRECTORY examples/freebase DESTINATION examples
          USE_SOURCE_PERMISSIONS)
  include(PackageHelper)
else ()
  install(PROGRAMS bin/ht-env.sh bin/fhsize.sh bin/rpm_pre_install.sh bin/rpm_post_install.sh DESTINATION bin)
endif ()
