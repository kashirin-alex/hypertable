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

class ClientService_future_get_result_serialized_args
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'ff',
            'isRequired' => false,
            'type' => TType::I64,
        ),
        2 => array(
            'var' => 'timeout_millis',
            'isRequired' => false,
            'type' => TType::I32,
        ),
    );

    /**
     * @var int
     */
    public $ff = null;
    /**
     * @var int
     */
    public $timeout_millis = 0;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['ff'])) {
                $this->ff = $vals['ff'];
            }
            if (isset($vals['timeout_millis'])) {
                $this->timeout_millis = $vals['timeout_millis'];
            }
        }
    }

    public function getName()
    {
        return 'ClientService_future_get_result_serialized_args';
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
                    if ($ftype == TType::I64) {
                        $xfer += $input->readI64($this->ff);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::I32) {
                        $xfer += $input->readI32($this->timeout_millis);
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
        $xfer += $output->writeStructBegin('ClientService_future_get_result_serialized_args');
        if ($this->ff !== null) {
            $xfer += $output->writeFieldBegin('ff', TType::I64, 1);
            $xfer += $output->writeI64($this->ff);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->timeout_millis !== null) {
            $xfer += $output->writeFieldBegin('timeout_millis', TType::I32, 2);
            $xfer += $output->writeI32($this->timeout_millis);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
