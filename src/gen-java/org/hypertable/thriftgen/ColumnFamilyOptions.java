/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.hypertable.thriftgen;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2014-6-15")
public class ColumnFamilyOptions implements org.apache.thrift.TBase<ColumnFamilyOptions, ColumnFamilyOptions._Fields>, java.io.Serializable, Cloneable, Comparable<ColumnFamilyOptions> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ColumnFamilyOptions");

  private static final org.apache.thrift.protocol.TField MAX_VERSIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("max_versions", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TTL_FIELD_DESC = new org.apache.thrift.protocol.TField("ttl", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField TIME_ORDER_DESC_FIELD_DESC = new org.apache.thrift.protocol.TField("time_order_desc", org.apache.thrift.protocol.TType.BOOL, (short)3);
  private static final org.apache.thrift.protocol.TField COUNTER_FIELD_DESC = new org.apache.thrift.protocol.TField("counter", org.apache.thrift.protocol.TType.BOOL, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ColumnFamilyOptionsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ColumnFamilyOptionsTupleSchemeFactory());
  }

  public int max_versions; // optional
  public int ttl; // optional
  public boolean time_order_desc; // optional
  public boolean counter; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MAX_VERSIONS((short)1, "max_versions"),
    TTL((short)2, "ttl"),
    TIME_ORDER_DESC((short)3, "time_order_desc"),
    COUNTER((short)4, "counter");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // MAX_VERSIONS
          return MAX_VERSIONS;
        case 2: // TTL
          return TTL;
        case 3: // TIME_ORDER_DESC
          return TIME_ORDER_DESC;
        case 4: // COUNTER
          return COUNTER;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __MAX_VERSIONS_ISSET_ID = 0;
  private static final int __TTL_ISSET_ID = 1;
  private static final int __TIME_ORDER_DESC_ISSET_ID = 2;
  private static final int __COUNTER_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.MAX_VERSIONS,_Fields.TTL,_Fields.TIME_ORDER_DESC,_Fields.COUNTER};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MAX_VERSIONS, new org.apache.thrift.meta_data.FieldMetaData("max_versions", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TTL, new org.apache.thrift.meta_data.FieldMetaData("ttl", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TIME_ORDER_DESC, new org.apache.thrift.meta_data.FieldMetaData("time_order_desc", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.COUNTER, new org.apache.thrift.meta_data.FieldMetaData("counter", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ColumnFamilyOptions.class, metaDataMap);
  }

  public ColumnFamilyOptions() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ColumnFamilyOptions(ColumnFamilyOptions other) {
    __isset_bitfield = other.__isset_bitfield;
    this.max_versions = other.max_versions;
    this.ttl = other.ttl;
    this.time_order_desc = other.time_order_desc;
    this.counter = other.counter;
  }

  public ColumnFamilyOptions deepCopy() {
    return new ColumnFamilyOptions(this);
  }

  @Override
  public void clear() {
    setMax_versionsIsSet(false);
    this.max_versions = 0;
    setTtlIsSet(false);
    this.ttl = 0;
    setTime_order_descIsSet(false);
    this.time_order_desc = false;
    setCounterIsSet(false);
    this.counter = false;
  }

  public int getMax_versions() {
    return this.max_versions;
  }

  public ColumnFamilyOptions setMax_versions(int max_versions) {
    this.max_versions = max_versions;
    setMax_versionsIsSet(true);
    return this;
  }

  public void unsetMax_versions() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MAX_VERSIONS_ISSET_ID);
  }

  /** Returns true if field max_versions is set (has been assigned a value) and false otherwise */
  public boolean isSetMax_versions() {
    return EncodingUtils.testBit(__isset_bitfield, __MAX_VERSIONS_ISSET_ID);
  }

  public void setMax_versionsIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MAX_VERSIONS_ISSET_ID, value);
  }

  public int getTtl() {
    return this.ttl;
  }

  public ColumnFamilyOptions setTtl(int ttl) {
    this.ttl = ttl;
    setTtlIsSet(true);
    return this;
  }

  public void unsetTtl() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TTL_ISSET_ID);
  }

  /** Returns true if field ttl is set (has been assigned a value) and false otherwise */
  public boolean isSetTtl() {
    return EncodingUtils.testBit(__isset_bitfield, __TTL_ISSET_ID);
  }

  public void setTtlIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TTL_ISSET_ID, value);
  }

  public boolean isTime_order_desc() {
    return this.time_order_desc;
  }

  public ColumnFamilyOptions setTime_order_desc(boolean time_order_desc) {
    this.time_order_desc = time_order_desc;
    setTime_order_descIsSet(true);
    return this;
  }

  public void unsetTime_order_desc() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TIME_ORDER_DESC_ISSET_ID);
  }

  /** Returns true if field time_order_desc is set (has been assigned a value) and false otherwise */
  public boolean isSetTime_order_desc() {
    return EncodingUtils.testBit(__isset_bitfield, __TIME_ORDER_DESC_ISSET_ID);
  }

  public void setTime_order_descIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TIME_ORDER_DESC_ISSET_ID, value);
  }

  public boolean isCounter() {
    return this.counter;
  }

  public ColumnFamilyOptions setCounter(boolean counter) {
    this.counter = counter;
    setCounterIsSet(true);
    return this;
  }

  public void unsetCounter() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COUNTER_ISSET_ID);
  }

  /** Returns true if field counter is set (has been assigned a value) and false otherwise */
  public boolean isSetCounter() {
    return EncodingUtils.testBit(__isset_bitfield, __COUNTER_ISSET_ID);
  }

  public void setCounterIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COUNTER_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case MAX_VERSIONS:
      if (value == null) {
        unsetMax_versions();
      } else {
        setMax_versions((Integer)value);
      }
      break;

    case TTL:
      if (value == null) {
        unsetTtl();
      } else {
        setTtl((Integer)value);
      }
      break;

    case TIME_ORDER_DESC:
      if (value == null) {
        unsetTime_order_desc();
      } else {
        setTime_order_desc((Boolean)value);
      }
      break;

    case COUNTER:
      if (value == null) {
        unsetCounter();
      } else {
        setCounter((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case MAX_VERSIONS:
      return Integer.valueOf(getMax_versions());

    case TTL:
      return Integer.valueOf(getTtl());

    case TIME_ORDER_DESC:
      return Boolean.valueOf(isTime_order_desc());

    case COUNTER:
      return Boolean.valueOf(isCounter());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case MAX_VERSIONS:
      return isSetMax_versions();
    case TTL:
      return isSetTtl();
    case TIME_ORDER_DESC:
      return isSetTime_order_desc();
    case COUNTER:
      return isSetCounter();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ColumnFamilyOptions)
      return this.equals((ColumnFamilyOptions)that);
    return false;
  }

  public boolean equals(ColumnFamilyOptions that) {
    if (that == null)
      return false;

    boolean this_present_max_versions = true && this.isSetMax_versions();
    boolean that_present_max_versions = true && that.isSetMax_versions();
    if (this_present_max_versions || that_present_max_versions) {
      if (!(this_present_max_versions && that_present_max_versions))
        return false;
      if (this.max_versions != that.max_versions)
        return false;
    }

    boolean this_present_ttl = true && this.isSetTtl();
    boolean that_present_ttl = true && that.isSetTtl();
    if (this_present_ttl || that_present_ttl) {
      if (!(this_present_ttl && that_present_ttl))
        return false;
      if (this.ttl != that.ttl)
        return false;
    }

    boolean this_present_time_order_desc = true && this.isSetTime_order_desc();
    boolean that_present_time_order_desc = true && that.isSetTime_order_desc();
    if (this_present_time_order_desc || that_present_time_order_desc) {
      if (!(this_present_time_order_desc && that_present_time_order_desc))
        return false;
      if (this.time_order_desc != that.time_order_desc)
        return false;
    }

    boolean this_present_counter = true && this.isSetCounter();
    boolean that_present_counter = true && that.isSetCounter();
    if (this_present_counter || that_present_counter) {
      if (!(this_present_counter && that_present_counter))
        return false;
      if (this.counter != that.counter)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_max_versions = true && (isSetMax_versions());
    list.add(present_max_versions);
    if (present_max_versions)
      list.add(max_versions);

    boolean present_ttl = true && (isSetTtl());
    list.add(present_ttl);
    if (present_ttl)
      list.add(ttl);

    boolean present_time_order_desc = true && (isSetTime_order_desc());
    list.add(present_time_order_desc);
    if (present_time_order_desc)
      list.add(time_order_desc);

    boolean present_counter = true && (isSetCounter());
    list.add(present_counter);
    if (present_counter)
      list.add(counter);

    return list.hashCode();
  }

  @Override
  public int compareTo(ColumnFamilyOptions other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetMax_versions()).compareTo(other.isSetMax_versions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMax_versions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.max_versions, other.max_versions);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTtl()).compareTo(other.isSetTtl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTtl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ttl, other.ttl);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTime_order_desc()).compareTo(other.isSetTime_order_desc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTime_order_desc()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.time_order_desc, other.time_order_desc);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCounter()).compareTo(other.isSetCounter());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCounter()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.counter, other.counter);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ColumnFamilyOptions(");
    boolean first = true;

    if (isSetMax_versions()) {
      sb.append("max_versions:");
      sb.append(this.max_versions);
      first = false;
    }
    if (isSetTtl()) {
      if (!first) sb.append(", ");
      sb.append("ttl:");
      sb.append(this.ttl);
      first = false;
    }
    if (isSetTime_order_desc()) {
      if (!first) sb.append(", ");
      sb.append("time_order_desc:");
      sb.append(this.time_order_desc);
      first = false;
    }
    if (isSetCounter()) {
      if (!first) sb.append(", ");
      sb.append("counter:");
      sb.append(this.counter);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ColumnFamilyOptionsStandardSchemeFactory implements SchemeFactory {
    public ColumnFamilyOptionsStandardScheme getScheme() {
      return new ColumnFamilyOptionsStandardScheme();
    }
  }

  private static class ColumnFamilyOptionsStandardScheme extends StandardScheme<ColumnFamilyOptions> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ColumnFamilyOptions struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MAX_VERSIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.max_versions = iprot.readI32();
              struct.setMax_versionsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TTL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.ttl = iprot.readI32();
              struct.setTtlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TIME_ORDER_DESC
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.time_order_desc = iprot.readBool();
              struct.setTime_order_descIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // COUNTER
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.counter = iprot.readBool();
              struct.setCounterIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ColumnFamilyOptions struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetMax_versions()) {
        oprot.writeFieldBegin(MAX_VERSIONS_FIELD_DESC);
        oprot.writeI32(struct.max_versions);
        oprot.writeFieldEnd();
      }
      if (struct.isSetTtl()) {
        oprot.writeFieldBegin(TTL_FIELD_DESC);
        oprot.writeI32(struct.ttl);
        oprot.writeFieldEnd();
      }
      if (struct.isSetTime_order_desc()) {
        oprot.writeFieldBegin(TIME_ORDER_DESC_FIELD_DESC);
        oprot.writeBool(struct.time_order_desc);
        oprot.writeFieldEnd();
      }
      if (struct.isSetCounter()) {
        oprot.writeFieldBegin(COUNTER_FIELD_DESC);
        oprot.writeBool(struct.counter);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ColumnFamilyOptionsTupleSchemeFactory implements SchemeFactory {
    public ColumnFamilyOptionsTupleScheme getScheme() {
      return new ColumnFamilyOptionsTupleScheme();
    }
  }

  private static class ColumnFamilyOptionsTupleScheme extends TupleScheme<ColumnFamilyOptions> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ColumnFamilyOptions struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetMax_versions()) {
        optionals.set(0);
      }
      if (struct.isSetTtl()) {
        optionals.set(1);
      }
      if (struct.isSetTime_order_desc()) {
        optionals.set(2);
      }
      if (struct.isSetCounter()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetMax_versions()) {
        oprot.writeI32(struct.max_versions);
      }
      if (struct.isSetTtl()) {
        oprot.writeI32(struct.ttl);
      }
      if (struct.isSetTime_order_desc()) {
        oprot.writeBool(struct.time_order_desc);
      }
      if (struct.isSetCounter()) {
        oprot.writeBool(struct.counter);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ColumnFamilyOptions struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.max_versions = iprot.readI32();
        struct.setMax_versionsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.ttl = iprot.readI32();
        struct.setTtlIsSet(true);
      }
      if (incoming.get(2)) {
        struct.time_order_desc = iprot.readBool();
        struct.setTime_order_descIsSet(true);
      }
      if (incoming.get(3)) {
        struct.counter = iprot.readBool();
        struct.setCounterIsSet(true);
      }
    }
  }

}

