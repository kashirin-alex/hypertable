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


if (APPLE)
  set(Fmemopen_SRCS fmemopen.c)
endif ()

set(Common_SRCS
Base64.cc
Checksum.cc
ClusterDefinition.cc
ClusterDefinitionFile/Compiler.cc
ClusterDefinitionFile/ToJson.cc
ClusterDefinitionFile/Token.cc
ClusterDefinitionFile/Tokenizer.cc
ClusterDefinitionFile/TokenizerTools.cc
ClusterDefinitionFile/TranslatorCode.cc
ClusterDefinitionFile/TranslatorRole.cc
ClusterDefinitionFile/TranslatorTask.cc
ClusterDefinitionFile/TranslatorVariable.cc
Config.cc
ConsoleOutputSquelcher.cc
Cronolog.cc
Crontab.cc
Crypto.cc
DiscreteRandomGenerator.cc
DiscreteRandomGeneratorFactory.cc
DiscreteRandomGeneratorZipf.cc
Error.cc
Escaper.cc
FailureInducer.cc
fast_clock.cc
FileUtils.cc
Filesystem.cc
HostSpecification.cc
InetAddr.cc
InteractiveCommand.cc
Logger.cc
MetricsCollectorGanglia.cc
MetricsProcess.cc
MurmurHash.cc
Property.cc
PropertyValueEnumExt.cc
PropertiesParser.cc
Properties.cc
Random.cc
Regex.cc
Serializable.cc
SleepWakeNotifier.cc
Status.cc
StatusPersister.cc
String.cc
System.cc
SystemInfo.cc
StatsSerializable.cc
StatsSystem.cc
Time.cc
TimeWindow.cc
Usage.cc
Version.cc
WordStream.cc
XmlParser.cc
md5.cc
)

if (${CMAKE_SYSTEM_NAME} MATCHES "SunOS")
  link_libraries(socket)
endif (${CMAKE_SYSTEM_NAME} MATCHES "SunOS")

ADD_LIB_TARGET(
	NAME HyperCommon 
	SRCS ${Common_SRCS} ${Fmemopen_SRCS}
	TARGETS HyperThirdParty
	SHARED ${MATH_LIBRARIES_SHARED} ${THREAD_LIBRARIES_SHARED}
				 ${MALLOC_LIBRARY_SHARED} ${BOOST_LIBRARIES_SHARED} 
				 ${ZLIB_LIBRARIES_SHARED} ${BZIP2_LIBRARIES_SHARED} ${LZMA_LIBRARIES_SHARED}
				 ${TINFOW_LIBRARIES_SHARED} 
				 ${RE2_LIBRARIES_SHARED} ${EXPAT_LIBRARIES_SHARED}
				 ${SSL_LIBRARIES_SHARED}
				 ${ZSTD_LIBRARIES_SHARED}
	STATIC ${MATH_LIBRARIES_STATIC} ${THREAD_LIBRARIES_STATIC}
				 ${MALLOC_LIBRARY_STATIC} ${BOOST_LIBRARIES_STATIC} 
				 ${ZLIB_LIBRARIES_STATIC} ${BZIP2_LIBRARIES_STATIC} ${LZMA_LIBRARIES_STATIC}
				 ${TINFOW_LIBRARIES_STATIC} 
				 ${RE2_LIBRARIES_STATIC} ${EXPAT_LIBRARIES_STATIC}
				 ${SSL_LIBRARIES_STATIC}
				 ${ZSTD_LIBRARIES_STATIC}
)


ADD_UTIL_TARGET(
	NAME ht_system_info
	SRCS system_info.cc
	TARGETS HyperCommon
)

ADD_TEST_EXEC(
	NAME ht_wordstream
	SRCS ht_wordstream.cc
	TARGETS HyperCommon 
)

configure_file(${HYPERTABLE_SOURCE_DIR}/tests/data/words.gz
               ${HYPERTABLE_BINARY_DIR}/src/cc/Common/words.gz COPYONLY)

# tests
set(SRC_DIR "${HYPERTABLE_SOURCE_DIR}/src/cc/Common")
set(DST_DIR "${HYPERTABLE_BINARY_DIR}/src/cc/Common")

ADD_TEST_TARGET(
	NAME Common-Base64
	SRCS tests/Base64_test.cc
	TARGETS HyperCommon
)
ADD_TEST_TARGET(
	NAME Common-Crypto
	SRCS tests/Crypto_test.cc
	TARGETS HyperCommon 
)
ADD_TEST_TARGET(
	NAME Common-Exception
	SRCS tests/exception_test.cc
	TARGETS HyperCommon 
)
ADD_TEST_TARGET(
	NAME Common-directory
	SRCS tests/directory_test.cc
	TARGETS HyperCommon 
	ARGS ${CMAKE_CURRENT_SOURCE_DIR}/tests/directory_test.golden
)
ADD_TEST_TARGET(
	NAME Common-Escaper
	SRCS tests/escaper_test.cc
	TARGETS HyperCommon 
)
configure_file(${SRC_DIR}/tests/HostSpecification_test.golden
               ${DST_DIR}/HostSpecification_test.golden)
ADD_TEST_TARGET(
	NAME Common-HostSpecification
	SRCS tests/HostSpecification_test.cc
	TARGETS HyperCommon 
)


# ClusterDefinition tests
configure_file(${SRC_DIR}/tests/ClusterDefinition_test.golden
               ${DST_DIR}/ClusterDefinition_test.golden)
ADD_TEST_TARGET(
	NAME Common-ClusterDefinition
	SRCS tests/ClusterDefinition_test.cc
	TARGETS HyperCommon 
)
add_subdirectory(ClusterDefinitionFile)

ADD_TEST_TARGET(
	NAME Common-Logging
	SRCS tests/logging_test.cc
	TARGETS HyperCommon 
)
# serialization tests
ADD_TEST_TARGET(
	NAME Common-Serializable
	SRCS tests/Serializable_test.cc
	TARGETS HyperCommon 
	ARGS ${CMAKE_CURRENT_SOURCE_DIR}/tests/Serializable_test.golden
)
ADD_TEST_TARGET(
	NAME Common-Serialization
	SRCS tests/sertest.cc
	TARGETS HyperCommon 
)
# scope guard tests
ADD_TEST_TARGET(
	NAME Common-ScopeGuard
	SRCS tests/scope_guard_test.cc
	TARGETS HyperCommon 
)

# inetaddr tests
set(ext_deps )
if (${CMAKE_SYSTEM_NAME} MATCHES "SunOS")
  set(ext_deps nsl resolv)
endif ()
ADD_TEST_TARGET(
	NAME Common-InetAddr
	SRCS tests/inetaddr_test.cc
	TARGETS HyperCommon 
	SHARED ${ext_deps}
)

# pagearena tests
ADD_TEST_TARGET(
	NAME Common-PageArena
	SRCS tests/pagearena_test.cc
	TARGETS HyperCommon 
)
# config tests
#ADD_TEST_TARGET(
#	NAME Common-Config
#	SRCS tests/config_test.cc
#	TARGETS HyperCommon 
#)

# crontab tests
ADD_TEST_EXEC(
	NAME crontab_test
	SRCS tests/crontab_test.cc
	TARGETS HyperCommon 
)
add_test(Common-Crontab env 
		 bash -c "${CMAKE_CURRENT_BINARY_DIR}/crontab_test > crontab_test.output; diff crontab_test.output ${CMAKE_CURRENT_SOURCE_DIR}/tests/crontab_test.golden")

# properties tests
ADD_TEST_EXEC(
	NAME properties_test
	SRCS tests/properties_test.cc
	TARGETS HyperCommon 
)
add_test(Common-Properties ${TEST_DIFF}
  ${CMAKE_CURRENT_SOURCE_DIR}/tests/properties_test.golden ./properties_test)
  
# init tests
ADD_TEST_EXEC(
	NAME init_test
	SRCS tests/init_test.cc
	TARGETS HyperCommon 
)
add_test(Common-init ${TEST_DIFF}
  ${CMAKE_CURRENT_SOURCE_DIR}/tests/init_test.golden
  ./init_test --i16 1k --i32 64K --i64 1G --boo --enum_ext two)
  
# md5 base 64 test
ADD_TEST_TARGET(
	NAME MD5-Base64
	SRCS tests/md5_base64_test.cc
	TARGETS HyperCommon 
)
# StatsSerializable test
ADD_TEST_TARGET(
	NAME Common-StatsSystem-serialize
	SRCS tests/stats_serialize_test.cc
	TARGETS HyperCommon 
)
# StringCompressor test
ADD_TEST_TARGET(
	NAME Common-StringCompressor
	SRCS tests/string_compressor_test.cc
	TARGETS HyperCommon 
)
# timeinline test
ADD_TEST_TARGET(
	NAME Common-TimeInline
	SRCS tests/timeinline_test.cc
	TARGETS HyperCommon 
)
# FailureInducer test
ADD_TEST_TARGET(
	NAME Common-FailureInducer
	SRCS tests/failure_inducer_test.cc
	TARGETS HyperCommon 
)
configure_file(${SRC_DIR}/tests/failure_inducer_test.golden
               ${DST_DIR}/failure_inducer_test.golden)
# TimeWindow test
ADD_TEST_EXEC(
	NAME TimeWindowTest
	SRCS tests/TimeWindowTest.cc
	TARGETS HyperCommon 
)
add_test(Common-TimeWindow env bash -c "${CMAKE_CURRENT_BINARY_DIR}/TimeWindowTest > TimeWindowTest.output; diff TimeWindowTest.output ${CMAKE_CURRENT_SOURCE_DIR}/tests/TimeWindowTest.golden")

# bloom filter test
ADD_TEST_TARGET(
	NAME Common-BloomFilter
	SRCS tests/bloom_filter_test.cc
	TARGETS HyperCommon 
)
# hash test
ADD_TEST_TARGET(
	NAME Common-Hash
	SRCS tests/hash_test.cc
	TARGETS HyperCommon 
)
# mutex tests
ADD_TEST_TARGET(
	NAME Common-Mutex
	SRCS tests/mutex_test.cc
	TARGETS HyperCommon 
)
# filesystem tests
ADD_TEST_TARGET(
	NAME Common-FileSystem
	SRCS tests/filesystem_test.cc
	TARGETS HyperCommon 
)

# config properties parser tests

ADD_TEST_EXEC(
	NAME properties_parser_test
	SRCS tests/properties_parser_test.cc
	TARGETS HyperCommon 
)
configure_file(${SRC_DIR}/tests/properties_parser_test.cfg ${DST_DIR}/properties_parser_test.cfg)
add_test(Common-Properties-Parser ${TEST_DIFF}
  ${CMAKE_CURRENT_SOURCE_DIR}/tests/properties_parser_test.golden
  ./properties_parser_test argOne --i16 1k --i32 64K --i64 1G --boo true --strs=1 -strs 2 -strs 3 --strs 4 -strs=5 --strs=6 --b=1 --is_true
)
  
# container tests
#ADD_TEST_TARGET(
#	NAME Common-Container
#	SRCS tests/container_test.cc
#	TARGETS HyperCommon 
#)

# macro expanded formatted sertest.cc for easy debugging
# sertest-x.cc is generated by gpp included in toplevel bin/gpp
#add_executable(sertestx tests/sertest-x.cc)
#target_link_libraries(sertestx HyperCommon)


set(VERSION_H ${HYPERTABLE_BINARY_DIR}/src/cc/Common/Version.h)
configure_file(Version.h.in ${VERSION_H})

if (NOT HT_COMPONENT_INSTALL)
  file(GLOB HEADERS *.h metrics)
  install(FILES ${HEADERS} ${VERSION_H} DESTINATION include/Common)


endif ()
