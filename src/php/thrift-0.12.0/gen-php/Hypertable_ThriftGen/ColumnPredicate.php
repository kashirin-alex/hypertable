<?php
namespace Hypertable_ThriftGen;

/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
use Thrift\Base\TBase;
use Thrift\Type\TType;
use Thrift\Type\TMessageType;
use Thrift\Exception\TException;
use Thrift\Exception\TProtocolException;
use Thrift\Protocol\TProtocol;
use Thrift\Protocol\TBinaryProtocolAccelerated;
use Thrift\Exception\TApplicationException;

/**
 * Specifies a column predicate
 *     ... WHERE column = "value"
 *   or
 *     ... WHERE column =^ "prefix"
 * 
 * <dl>
 *   <dt>column_family</dt>
 *   <dd>The name of the column family</dd>
 * 
 *   <dt>operation</dt>
 *   <dd>The predicate operation; either EXACT_MATCH or PREFIX_MATCH</dd>
 * 
 *   <dt>value</dt>
 *   <dd>The cell value or cell prefix, depending on the operation</dd>
 * 
 *   <dt>value_len</dt>
 *   <dd>The size of the value</dd>
 * 
 *   <dt>column_qualifier</dt>
 *   <dd>The column qualifier</dd>
 * </dl>
 */
class ColumnPredicate
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'column_family',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
        2 => array(
            'var' => 'column_qualifier',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
        3 => array(
            'var' => 'operation',
            'isRequired' => false,
            'type' => TType::I32,
        ),
        4 => array(
            'var' => 'value',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
    );

    /**
     * @var string
     */
    public $column_family = null;
    /**
     * @var string
     */
    public $column_qualifier = null;
    /**
     * @var int
     */
    public $operation = null;
    /**
     * @var string
     */
    public $value = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['column_family'])) {
                $this->column_family = $vals['column_family'];
            }
            if (isset($vals['column_qualifier'])) {
                $this->column_qualifier = $vals['column_qualifier'];
            }
            if (isset($vals['operation'])) {
                $this->operation = $vals['operation'];
            }
            if (isset($vals['value'])) {
                $this->value = $vals['value'];
            }
        }
    }

    public function getName()
    {
        return 'ColumnPredicate';
    }


    public function read($input)
    {
        $xfer = 0;
        $fname = null;
        $ftype = 0;
        $fid = 0;
        $xfer += $input->readStructBegin($fname);
        while (true) {
            $xfer += $input->readFieldBegin($fname, $ftype, $fid);
            if ($ftype == TType::STOP) {
                break;
            }
            switch ($fid) {
                case 1:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->column_family);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->column_qualifier);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 3:
                    if ($ftype == TType::I32) {
                        $xfer += $input->readI32($this->operation);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 4:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->value);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                default:
                    $xfer += $input->skip($ftype);
                    break;
            }
            $xfer += $input->readFieldEnd();
        }
        $xfer += $input->readStructEnd();
        return $xfer;
    }

    public function write($output)
    {
        $xfer = 0;
        $xfer += $output->writeStructBegin('ColumnPredicate');
        if ($this->column_family !== null) {
            $xfer += $output->writeFieldBegin('column_family', TType::STRING, 1);
            $xfer += $output->writeString($this->column_family);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->column_qualifier !== null) {
            $xfer += $output->writeFieldBegin('column_qualifier', TType::STRING, 2);
            $xfer += $output->writeString($this->column_qualifier);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->operation !== null) {
            $xfer += $output->writeFieldBegin('operation', TType::I32, 3);
            $xfer += $output->writeI32($this->operation);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->value !== null) {
            $xfer += $output->writeFieldBegin('value', TType::STRING, 4);
            $xfer += $output->writeString($this->value);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
