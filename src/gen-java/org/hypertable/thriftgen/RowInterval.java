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
/**
 * Specifies a range of rows
 * 
 * <dl>
 *   <dt>start_row</dt>
 *   <dd>The row to start scan with. Must not contain nulls (0x00)</dd>
 * 
 *   <dt>start_inclusive</dt>
 *   <dd>Whether the start row is included in the result (default: true)</dd>
 * 
 *   <dt>end_row</dt>
 *   <dd>The row to end scan with. Must not contain nulls</dd>
 * 
 *   <dt>end_inclusive</dt>
 *   <dd>Whether the end row is included in the result (default: true)</dd>
 * </dl>
 */
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2014-6-15")
public class RowInterval implements org.apache.thrift.TBase<RowInterval, RowInterval._Fields>, java.io.Serializable, Cloneable, Comparable<RowInterval> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RowInterval");

  private static final org.apache.thrift.protocol.TField START_ROW_FIELD_DESC = new org.apache.thrift.protocol.TField("start_row", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField START_INCLUSIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("start_inclusive", org.apache.thrift.protocol.TType.BOOL, (short)2);
  private static final org.apache.thrift.protocol.TField END_ROW_FIELD_DESC = new org.apache.thrift.protocol.TField("end_row", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField END_INCLUSIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("end_inclusive", org.apache.thrift.protocol.TType.BOOL, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RowIntervalStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RowIntervalTupleSchemeFactory());
  }

  public String start_row; // optional
  public boolean start_inclusive; // optional
  public String end_row; // optional
  public boolean end_inclusive; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    START_ROW((short)1, "start_row"),
    START_INCLUSIVE((short)2, "start_inclusive"),
    END_ROW((short)3, "end_row"),
    END_INCLUSIVE((short)4, "end_inclusive");

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
        case 1: // START_ROW
          return START_ROW;
        case 2: // START_INCLUSIVE
          return START_INCLUSIVE;
        case 3: // END_ROW
          return END_ROW;
        case 4: // END_INCLUSIVE
          return END_INCLUSIVE;
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
  private static final int __START_INCLUSIVE_ISSET_ID = 0;
  private static final int __END_INCLUSIVE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.START_ROW,_Fields.START_INCLUSIVE,_Fields.END_ROW,_Fields.END_INCLUSIVE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.START_ROW, new org.apache.thrift.meta_data.FieldMetaData("start_row", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.START_INCLUSIVE, new org.apache.thrift.meta_data.FieldMetaData("start_inclusive", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.END_ROW, new org.apache.thrift.meta_data.FieldMetaData("end_row", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.END_INCLUSIVE, new org.apache.thrift.meta_data.FieldMetaData("end_inclusive", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RowInterval.class, metaDataMap);
  }

  public RowInterval() {
    this.start_inclusive = true;

    this.end_inclusive = true;

  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RowInterval(RowInterval other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetStart_row()) {
      this.start_row = other.start_row;
    }
    this.start_inclusive = other.start_inclusive;
    if (other.isSetEnd_row()) {
      this.end_row = other.end_row;
    }
    this.end_inclusive = other.end_inclusive;
  }

  public RowInterval deepCopy() {
    return new RowInterval(this);
  }

  @Override
  public void clear() {
    this.start_row = null;
    this.start_inclusive = true;

    this.end_row = null;
    this.end_inclusive = true;

  }

  public String getStart_row() {
    return this.start_row;
  }

  public RowInterval setStart_row(String start_row) {
    this.start_row = start_row;
    return this;
  }

  public void unsetStart_row() {
    this.start_row = null;
  }

  /** Returns true if field start_row is set (has been assigned a value) and false otherwise */
  public boolean isSetStart_row() {
    return this.start_row != null;
  }

  public void setStart_rowIsSet(boolean value) {
    if (!value) {
      this.start_row = null;
    }
  }

  public boolean isStart_inclusive() {
    return this.start_inclusive;
  }

  public RowInterval setStart_inclusive(boolean start_inclusive) {
    this.start_inclusive = start_inclusive;
    setStart_inclusiveIsSet(true);
    return this;
  }

  public void unsetStart_inclusive() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __START_INCLUSIVE_ISSET_ID);
  }

  /** Returns true if field start_inclusive is set (has been assigned a value) and false otherwise */
  public boolean isSetStart_inclusive() {
    return EncodingUtils.testBit(__isset_bitfield, __START_INCLUSIVE_ISSET_ID);
  }

  public void setStart_inclusiveIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __START_INCLUSIVE_ISSET_ID, value);
  }

  public String getEnd_row() {
    return this.end_row;
  }

  public RowInterval setEnd_row(String end_row) {
    this.end_row = end_row;
    return this;
  }

  public void unsetEnd_row() {
    this.end_row = null;
  }

  /** Returns true if field end_row is set (has been assigned a value) and false otherwise */
  public boolean isSetEnd_row() {
    return this.end_row != null;
  }

  public void setEnd_rowIsSet(boolean value) {
    if (!value) {
      this.end_row = null;
    }
  }

  public boolean isEnd_inclusive() {
    return this.end_inclusive;
  }

  public RowInterval setEnd_inclusive(boolean end_inclusive) {
    this.end_inclusive = end_inclusive;
    setEnd_inclusiveIsSet(true);
    return this;
  }

  public void unsetEnd_inclusive() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __END_INCLUSIVE_ISSET_ID);
  }

  /** Returns true if field end_inclusive is set (has been assigned a value) and false otherwise */
  public boolean isSetEnd_inclusive() {
    return EncodingUtils.testBit(__isset_bitfield, __END_INCLUSIVE_ISSET_ID);
  }

  public void setEnd_inclusiveIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __END_INCLUSIVE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case START_ROW:
      if (value == null) {
        unsetStart_row();
      } else {
        setStart_row((String)value);
      }
      break;

    case START_INCLUSIVE:
      if (value == null) {
        unsetStart_inclusive();
      } else {
        setStart_inclusive((Boolean)value);
      }
      break;

    case END_ROW:
      if (value == null) {
        unsetEnd_row();
      } else {
        setEnd_row((String)value);
      }
      break;

    case END_INCLUSIVE:
      if (value == null) {
        unsetEnd_inclusive();
      } else {
        setEnd_inclusive((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case START_ROW:
      return getStart_row();

    case START_INCLUSIVE:
      return Boolean.valueOf(isStart_inclusive());

    case END_ROW:
      return getEnd_row();

    case END_INCLUSIVE:
      return Boolean.valueOf(isEnd_inclusive());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case START_ROW:
      return isSetStart_row();
    case START_INCLUSIVE:
      return isSetStart_inclusive();
    case END_ROW:
      return isSetEnd_row();
    case END_INCLUSIVE:
      return isSetEnd_inclusive();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RowInterval)
      return this.equals((RowInterval)that);
    return false;
  }

  public boolean equals(RowInterval that) {
    if (that == null)
      return false;

    boolean this_present_start_row = true && this.isSetStart_row();
    boolean that_present_start_row = true && that.isSetStart_row();
    if (this_present_start_row || that_present_start_row) {
      if (!(this_present_start_row && that_present_start_row))
        return false;
      if (!this.start_row.equals(that.start_row))
        return false;
    }

    boolean this_present_start_inclusive = true && this.isSetStart_inclusive();
    boolean that_present_start_inclusive = true && that.isSetStart_inclusive();
    if (this_present_start_inclusive || that_present_start_inclusive) {
      if (!(this_present_start_inclusive && that_present_start_inclusive))
        return false;
      if (this.start_inclusive != that.start_inclusive)
        return false;
    }

    boolean this_present_end_row = true && this.isSetEnd_row();
    boolean that_present_end_row = true && that.isSetEnd_row();
    if (this_present_end_row || that_present_end_row) {
      if (!(this_present_end_row && that_present_end_row))
        return false;
      if (!this.end_row.equals(that.end_row))
        return false;
    }

    boolean this_present_end_inclusive = true && this.isSetEnd_inclusive();
    boolean that_present_end_inclusive = true && that.isSetEnd_inclusive();
    if (this_present_end_inclusive || that_present_end_inclusive) {
      if (!(this_present_end_inclusive && that_present_end_inclusive))
        return false;
      if (this.end_inclusive != that.end_inclusive)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_start_row = true && (isSetStart_row());
    list.add(present_start_row);
    if (present_start_row)
      list.add(start_row);

    boolean present_start_inclusive = true && (isSetStart_inclusive());
    list.add(present_start_inclusive);
    if (present_start_inclusive)
      list.add(start_inclusive);

    boolean present_end_row = true && (isSetEnd_row());
    list.add(present_end_row);
    if (present_end_row)
      list.add(end_row);

    boolean present_end_inclusive = true && (isSetEnd_inclusive());
    list.add(present_end_inclusive);
    if (present_end_inclusive)
      list.add(end_inclusive);

    return list.hashCode();
  }

  @Override
  public int compareTo(RowInterval other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetStart_row()).compareTo(other.isSetStart_row());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStart_row()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.start_row, other.start_row);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStart_inclusive()).compareTo(other.isSetStart_inclusive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStart_inclusive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.start_inclusive, other.start_inclusive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEnd_row()).compareTo(other.isSetEnd_row());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEnd_row()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.end_row, other.end_row);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEnd_inclusive()).compareTo(other.isSetEnd_inclusive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEnd_inclusive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.end_inclusive, other.end_inclusive);
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
    StringBuilder sb = new StringBuilder("RowInterval(");
    boolean first = true;

    if (isSetStart_row()) {
      sb.append("start_row:");
      if (this.start_row == null) {
        sb.append("null");
      } else {
        sb.append(this.start_row);
      }
      first = false;
    }
    if (isSetStart_inclusive()) {
      if (!first) sb.append(", ");
      sb.append("start_inclusive:");
      sb.append(this.start_inclusive);
      first = false;
    }
    if (isSetEnd_row()) {
      if (!first) sb.append(", ");
      sb.append("end_row:");
      if (this.end_row == null) {
        sb.append("null");
      } else {
        sb.append(this.end_row);
      }
      first = false;
    }
    if (isSetEnd_inclusive()) {
      if (!first) sb.append(", ");
      sb.append("end_inclusive:");
      sb.append(this.end_inclusive);
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

  private static class RowIntervalStandardSchemeFactory implements SchemeFactory {
    public RowIntervalStandardScheme getScheme() {
      return new RowIntervalStandardScheme();
    }
  }

  private static class RowIntervalStandardScheme extends StandardScheme<RowInterval> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RowInterval struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // START_ROW
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.start_row = iprot.readString();
              struct.setStart_rowIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // START_INCLUSIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.start_inclusive = iprot.readBool();
              struct.setStart_inclusiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // END_ROW
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.end_row = iprot.readString();
              struct.setEnd_rowIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // END_INCLUSIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.end_inclusive = iprot.readBool();
              struct.setEnd_inclusiveIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, RowInterval struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.start_row != null) {
        if (struct.isSetStart_row()) {
          oprot.writeFieldBegin(START_ROW_FIELD_DESC);
          oprot.writeString(struct.start_row);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetStart_inclusive()) {
        oprot.writeFieldBegin(START_INCLUSIVE_FIELD_DESC);
        oprot.writeBool(struct.start_inclusive);
        oprot.writeFieldEnd();
      }
      if (struct.end_row != null) {
        if (struct.isSetEnd_row()) {
          oprot.writeFieldBegin(END_ROW_FIELD_DESC);
          oprot.writeString(struct.end_row);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetEnd_inclusive()) {
        oprot.writeFieldBegin(END_INCLUSIVE_FIELD_DESC);
        oprot.writeBool(struct.end_inclusive);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RowIntervalTupleSchemeFactory implements SchemeFactory {
    public RowIntervalTupleScheme getScheme() {
      return new RowIntervalTupleScheme();
    }
  }

  private static class RowIntervalTupleScheme extends TupleScheme<RowInterval> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RowInterval struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetStart_row()) {
        optionals.set(0);
      }
      if (struct.isSetStart_inclusive()) {
        optionals.set(1);
      }
      if (struct.isSetEnd_row()) {
        optionals.set(2);
      }
      if (struct.isSetEnd_inclusive()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetStart_row()) {
        oprot.writeString(struct.start_row);
      }
      if (struct.isSetStart_inclusive()) {
        oprot.writeBool(struct.start_inclusive);
      }
      if (struct.isSetEnd_row()) {
        oprot.writeString(struct.end_row);
      }
      if (struct.isSetEnd_inclusive()) {
        oprot.writeBool(struct.end_inclusive);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RowInterval struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.start_row = iprot.readString();
        struct.setStart_rowIsSet(true);
      }
      if (incoming.get(1)) {
        struct.start_inclusive = iprot.readBool();
        struct.setStart_inclusiveIsSet(true);
      }
      if (incoming.get(2)) {
        struct.end_row = iprot.readString();
        struct.setEnd_rowIsSet(true);
      }
      if (incoming.get(3)) {
        struct.end_inclusive = iprot.readBool();
        struct.setEnd_inclusiveIsSet(true);
      }
    }
  }

}

