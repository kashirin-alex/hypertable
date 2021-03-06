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
 * The "operation" for a ColumnPredicate
 * 
 * EXACT_MATCH: compares the cell value for identity
 *     (... WHERE column = "value")
 * PREFIX_MATCH: compares the cell value for a prefix match
 *     (... WHERE column =^ "prefix")
 */
final class ColumnPredicateOperation
{
    const EXACT_MATCH = 1;

    const PREFIX_MATCH = 2;

    const REGEX_MATCH = 4;

    const VALUE_MATCH = 7;

    const QUALIFIER_EXACT_MATCH = 256;

    const QUALIFIER_PREFIX_MATCH = 512;

    const QUALIFIER_REGEX_MATCH = 1024;

    const QUALIFIER_MATCH = 1792;

    static public $__names = array(
        1 => 'EXACT_MATCH',
        2 => 'PREFIX_MATCH',
        4 => 'REGEX_MATCH',
        7 => 'VALUE_MATCH',
        256 => 'QUALIFIER_EXACT_MATCH',
        512 => 'QUALIFIER_PREFIX_MATCH',
        1024 => 'QUALIFIER_REGEX_MATCH',
        1792 => 'QUALIFIER_MATCH',
    );
}

