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



#### PREPARE HYPERTABLE PKG DIR
add_custom_target(ThriftClientPy ALL)
add_custom_command(
  TARGET   ThriftClientPy
  COMMAND  cp 
  ARGS     -r ${HYPERTABLE_SOURCE_DIR}/src/py/ht-package/* ${HYPERTABLE_BINARY_DIR}/src/py/ht-package/pkg
)
configure_file(setup.py.in ${HYPERTABLE_BINARY_DIR}/src/py/ht-package/pkg/setup.py @ONLY)
configure_file(requirements.txt.in ${HYPERTABLE_BINARY_DIR}/src/py/ht-package/pkg/requirements.txt @ONLY)


#### GENERATE HYPERTHRIFT module

if (THRIFT_FOUND)
	add_custom_command(
		TARGET 		ThriftClientPy
		COMMAND   	thrift
		ARGS      	-r --gen py:slots,no_utf8strings -o ${HYPERTABLE_BINARY_DIR}/src/py/ht-package/
					${ThriftBroker_IDL_DIR}/Hql.thrift
		DEPENDS   	${ThriftBroker_IDL_DIR}/Client.thrift
					${ThriftBroker_IDL_DIR}/Hql.thrift
		COMMENT   	"ThriftPyGen"
	)
		
	#### SET HYPERTHRIFT module to HYPERTABLE PKG
	add_custom_command(
		TARGET 	ThriftClientPy
		COMMAND   cp 
		ARGS      -r ${HYPERTABLE_BINARY_DIR}/src/py/ht-package/gen-py/hypertable/thrift_client/hyperthrift ${HYPERTABLE_BINARY_DIR}/src/py/ht-package/pkg/hypertable/thrift_client/
	)
	#### minimize attr access
	add_custom_command(
		TARGET 	 ThriftClientPy

		COMMAND  sed 
		ARGS     -i 's/import hypertable.thrift_client.hyperthrift.gen.ttypes/from hypertable.thrift_client.hyperthrift.gen import ttypes as gen_ttypes/g' ${HYPERTABLE_BINARY_DIR}/src/py/ht-package/pkg/hypertable/thrift_client/hyperthrift/gen2/ttypes.py
	)
	add_custom_command(
		TARGET 	 ThriftClientPy
		COMMAND  sed 
		ARGS     -i 's/hypertable.thrift_client.hyperthrift.gen.ttypes./gen_ttypes./g' ${HYPERTABLE_BINARY_DIR}/src/py/ht-package/pkg/hypertable/thrift_client/hyperthrift/gen2/ttypes.py
	)
	
endif ()


if (NOT HT_COMPONENT_INSTALL OR PACKAGE_THRIFTBROKER)
	if(PYTHONTHRIFT_FOUND)
		install(DIRECTORY ${THIRFT_PY_PATH} DESTINATION lib/py USE_SOURCE_PERMISSIONS)
	endif()

	
  list(GET PYTHON_EXECUTABLES 0 py)
	install( CODE "execute_process(COMMAND  cmake -E chdir ${HYPERTABLE_BINARY_DIR}/src/py/ht-package/pkg ${py} setup.py sdist;)")
	install(FILES "${HYPERTABLE_BINARY_DIR}/src/py/ht-package/pkg/dist/hypertable-${VERSION}.tar.gz" DESTINATION lib/py/)
	
	foreach(py ${PYTHON_EXECUTABLES})

		add_test(ThriftClient-${py} env ${py} ${CMAKE_CURRENT_SOURCE_DIR}/tests/client_test.py)
		add_test(ThriftClient-${py}-scw env ${py} ${CMAKE_CURRENT_SOURCE_DIR}/tests/client_test_scw.py)
		add_test(ThriftClient-${py}-scr env ${py} ${CMAKE_CURRENT_SOURCE_DIR}/tests/client_test_scr.py)
		add_test(HypertableClient-${py} 
							env LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${INSTALL_DIR}/lib HT_HOME=${INSTALL_DIR} 
							${py} ${CMAKE_CURRENT_SOURCE_DIR}/tests/ht_client_test.py)

		install( CODE "execute_process(COMMAND  cmake -E chdir ${HYPERTABLE_BINARY_DIR}/src/py/ht-package/pkg/dist ${py} -m pip install --verbose --upgrade hypertable-${VERSION}.tar.gz;)")
		install( CODE "execute_process(COMMAND  cmake -E chdir ${HYPERTABLE_BINARY_DIR}/src/py/ht-package/pkg ${py} -m pip install --upgrade -r requirements.txt;)")

	endforeach()

endif ()
