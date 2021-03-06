#!/usr/bin/env bash

HT_HOME=${INSTALL_DIR:-"/opt/hypertable/current"}
SCRIPT_DIR=`dirname $0`

cp ${SCRIPT_DIR}/test.tsv .

echo "======================="
echo "Defect #444"
echo "======================="


# only start servers if they're not yet running
$HT_HOME/bin/ht-check-rangeserver.sh
if [ $? -ne 0 ]; then
    $HT_HOME/bin/ht-start-test-servers.sh --clear
fi

cat ${SCRIPT_DIR}/test.hql | $HT_HOME/bin/ht hypertable \
    --no-prompt --test-mode \
    > test.output

diff test.output ${SCRIPT_DIR}/test.golden
if [ $? -ne "0" ]
then
  echo "FAIL - golden file differs, exiting"
  exit 1
fi

echo "SUCCESS"
