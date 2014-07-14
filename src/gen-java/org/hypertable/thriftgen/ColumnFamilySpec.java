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
 * Describes a ColumnFamily
 * <dl>
 *   <dt>name</dt>
 *   <dd>Name of the column family</dd>
 * 
 *   <dt>ag</dt>
 *   <dd>Name of the access group for this CF</dd>
 * 
 *   <dt>max_versions</dt>
 *   <dd>Max versions of the same cell to be stored</dd>
 * 
 *   <dt>ttl</dt>
 *   <dd>Time to live for cells in the CF (ie delete cells older than this time)</dd>
 * </dl>
 */
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2014-6-17")
public class ColumnFamilySpec implements org.apache.thrift.TBase<ColumnFamilySpec, ColumnFamilySpec._Fields>, java.io.Serializable, Cloneable, Comparable<ColumnFamilySpec> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ColumnFamilySpec");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ACCESS_GROUP_FIELD_DESC = new org.apache.thrift.protocol.TField("access_group", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DELETED_FIELD_DESC = new org.apache.thrift.protocol.TField("deleted", org.apache.thrift.protocol.TType.BOOL, (short)3);
  private static final org.apache.thrift.protocol.TField GENERATION_FIELD_DESC = new org.apache.thrift.protocol.TField("generation", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField VALUE_INDEX_FIELD_DESC = new org.apache.thrift.protocol.TField("value_index", org.apache.thrift.protocol.TType.BOOL, (short)6);
  private static final org.apache.thrift.protocol.TField QUALIFIER_INDEX_FIELD_DESC = new org.apache.thrift.protocol.TField("qualifier_index", org.apache.thrift.protocol.TType.BOOL, (short)7);
  private static final org.apache.thrift.protocol.TField OPTIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("options", org.apache.thrift.protocol.TType.STRUCT, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ColumnFamilySpecStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ColumnFamilySpecTupleSchemeFactory());
  }

  public String name; // required
  public String access_group; // required
  public boolean deleted; // required
  public long generation; // optional
  public int id; // optional
  public boolean value_index; // required
  public boolean qualifier_index; // required
  public ColumnFamilyOptions options; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    ACCESS_GROUP((short)2, "access_group"),
    DELETED((short)3, "deleted"),
    GENERATION((short)4, "generation"),
    ID((short)5, "id"),
    VALUE_INDEX((short)6, "value_index"),
    QUALIFIER_INDEX((short)7, "qualifier_index"),
    OPTIONS((short)8, "options");

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
        case 1: // NAME
          return NAME;
        case 2: // ACCESS_GROUP
          return ACCESS_GROUP;
        case 3: // DELETED
          return DELETED;
        case 4: // GENERATION
          return GENERATION;
        case 5: // ID
          return ID;
        case 6: // VALUE_INDEX
          return VALUE_INDEX;
        case 7: // QUALIFIER_INDEX
          return QUALIFIER_INDEX;
        case 8: // OPTIONS
          return OPTIONS;
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
  private static final int __DELETED_ISSET_ID = 0;
  private static final int __GENERATION_ISSET_ID = 1;
  private static final int __ID_ISSET_ID = 2;
  private static final int __VALUE_INDEX_ISSET_ID = 3;
  private static final int __QUALIFIER_INDEX_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.GENERATION,_Fields.ID,_Fields.OPTIONS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ACCESS_GROUP, new org.apache.thrift.meta_data.FieldMetaData("access_group", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DELETED, new org.apache.thrift.meta_data.FieldMetaData("deleted", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.GENERATION, new org.apache.thrift.meta_data.FieldMetaData("generation", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.VALUE_INDEX, new org.apache.thrift.meta_data.FieldMetaData("value_index", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.QUALIFIER_INDEX, new org.apache.thrift.meta_data.FieldMetaData("qualifier_index", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.OPTIONS, new org.apache.thrift.meta_data.FieldMetaData("options", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ColumnFamilyOptions.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ColumnFamilySpec.class, metaDataMap);
  }

  public ColumnFamilySpec() {
  }

  public ColumnFamilySpec(
    String name,
    String access_group,
    boolean deleted,
    boolean value_index,
    boolean qualifier_index)
  {
    this();
    this.name = name;
    this.access_group = access_group;
    this.deleted = deleted;
    setDeletedIsSet(true);
    this.value_index = value_index;
    setValue_indexIsSet(true);
    this.qualifier_index = qualifier_index;
    setQualifier_indexIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ColumnFamilySpec(ColumnFamilySpec other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetAccess_group()) {
      this.access_group = other.access_group;
    }
    this.deleted = other.deleted;
    this.generation = other.generation;
    this.id = other.id;
    this.value_index = other.value_index;
    this.qualifier_index = other.qualifier_index;
    if (other.isSetOptions()) {
      this.options = new ColumnFamilyOptions(other.options);
    }
  }

  public ColumnFamilySpec deepCopy() {
    return new ColumnFamilySpec(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.access_group = null;
    setDeletedIsSet(false);
    this.deleted = false;
    setGenerationIsSet(false);
    this.generation = 0;
    setIdIsSet(false);
    this.id = 0;
    setValue_indexIsSet(false);
    this.value_index = false;
    setQualifier_indexIsSet(false);
    this.qualifier_index = false;
    this.options = null;
  }

  public String getName() {
    return this.name;
  }

  public ColumnFamilySpec setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getAccess_group() {
    return this.access_group;
  }

  public ColumnFamilySpec setAccess_group(String access_group) {
    this.access_group = access_group;
    return this;
  }

  public void unsetAccess_group() {
    this.access_group = null;
  }

  /** Returns true if field access_group is set (has been assigned a value) and false otherwise */
  public boolean isSetAccess_group() {
    return this.access_group != null;
  }

  public void setAccess_groupIsSet(boolean value) {
    if (!value) {
      this.access_group = null;
    }
  }

  public boolean isDeleted() {
    return this.deleted;
  }

  public ColumnFamilySpec setDeleted(boolean deleted) {
    this.deleted = deleted;
    setDeletedIsSet(true);
    return this;
  }

  public void unsetDeleted() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DELETED_ISSET_ID);
  }

  /** Returns true if field deleted is set (has been assigned a value) and false otherwise */
  public boolean isSetDeleted() {
    return EncodingUtils.testBit(__isset_bitfield, __DELETED_ISSET_ID);
  }

  public void setDeletedIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DELETED_ISSET_ID, value);
  }

  public long getGeneration() {
    return this.generation;
  }

  public ColumnFamilySpec setGeneration(long generation) {
    this.generation = generation;
    setGenerationIsSet(true);
    return this;
  }

  public void unsetGeneration() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __GENERATION_ISSET_ID);
  }

  /** Returns true if field generation is set (has been assigned a value) and false otherwise */
  public boolean isSetGeneration() {
    return EncodingUtils.testBit(__isset_bitfield, __GENERATION_ISSET_ID);
  }

  public void setGenerationIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __GENERATION_ISSET_ID, value);
  }

  public int getId() {
    return this.id;
  }

  public ColumnFamilySpec setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public boolean isValue_index() {
    return this.value_index;
  }

  public ColumnFamilySpec setValue_index(boolean value_index) {
    this.value_index = value_index;
    setValue_indexIsSet(true);
    return this;
  }

  public void unsetValue_index() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __VALUE_INDEX_ISSET_ID);
  }

  /** Returns true if field value_index is set (has been assigned a value) and false otherwise */
  public boolean isSetValue_index() {
    return EncodingUtils.testBit(__isset_bitfield, __VALUE_INDEX_ISSET_ID);
  }

  public void setValue_indexIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __VALUE_INDEX_ISSET_ID, value);
  }

  public boolean isQualifier_index() {
    return this.qualifier_index;
  }

  public ColumnFamilySpec setQualifier_index(boolean qualifier_index) {
    this.qualifier_index = qualifier_index;
    setQualifier_indexIsSet(true);
    return this;
  }

  public void unsetQualifier_index() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __QUALIFIER_INDEX_ISSET_ID);
  }

  /** Returns true if field qualifier_index is set (has been assigned a value) and false otherwise */
  public boolean isSetQualifier_index() {
    return EncodingUtils.testBit(__isset_bitfield, __QUALIFIER_INDEX_ISSET_ID);
  }

  public void setQualifier_indexIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __QUALIFIER_INDEX_ISSET_ID, value);
  }

  public ColumnFamilyOptions getOptions() {
    return this.options;
  }

  public ColumnFamilySpec setOptions(ColumnFamilyOptions options) {
    this.options = options;
    return this;
  }

  public void unsetOptions() {
    this.options = null;
  }

  /** Returns true if field options is set (has been assigned a value) and false otherwise */
  public boolean isSetOptions() {
    return this.options != null;
  }

  public void setOptionsIsSet(boolean value) {
    if (!value) {
      this.options = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case ACCESS_GROUP:
      if (value == null) {
        unsetAccess_group();
      } else {
        setAccess_group((String)value);
      }
      break;

    case DELETED:
      if (value == null) {
        unsetDeleted();
      } else {
        setDeleted((Boolean)value);
      }
      break;

    case GENERATION:
      if (value == null) {
        unsetGeneration();
      } else {
        setGeneration((Long)value);
      }
      break;

    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Integer)value);
      }
      break;

    case VALUE_INDEX:
      if (value == null) {
        unsetValue_index();
      } else {
        setValue_index((Boolean)value);
      }
      break;

    case QUALIFIER_INDEX:
      if (value == null) {
        unsetQualifier_index();
      } else {
        setQualifier_index((Boolean)value);
      }
      break;

    case OPTIONS:
      if (value == null) {
        unsetOptions();
      } else {
        setOptions((ColumnFamilyOptions)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case ACCESS_GROUP:
      return getAccess_group();

    case DELETED:
      return Boolean.valueOf(isDeleted());

    case GENERATION:
      return Long.valueOf(getGeneration());

    case ID:
      return Integer.valueOf(getId());

    case VALUE_INDEX:
      return Boolean.valueOf(isValue_index());

    case QUALIFIER_INDEX:
      return Boolean.valueOf(isQualifier_index());

    case OPTIONS:
      return getOptions();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case ACCESS_GROUP:
      return isSetAccess_group();
    case DELETED:
      return isSetDeleted();
    case GENERATION:
      return isSetGeneration();
    case ID:
      return isSetId();
    case VALUE_INDEX:
      return isSetValue_index();
    case QUALIFIER_INDEX:
      return isSetQualifier_index();
    case OPTIONS:
      return isSetOptions();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ColumnFamilySpec)
      return this.equals((ColumnFamilySpec)that);
    return false;
  }

  public boolean equals(ColumnFamilySpec that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_access_group = true && this.isSetAccess_group();
    boolean that_present_access_group = true && that.isSetAccess_group();
    if (this_present_access_group || that_present_access_group) {
      if (!(this_present_access_group && that_present_access_group))
        return false;
      if (!this.access_group.equals(that.access_group))
        return false;
    }

    boolean this_present_deleted = true;
    boolean that_present_deleted = true;
    if (this_present_deleted || that_present_deleted) {
      if (!(this_present_deleted && that_present_deleted))
        return false;
      if (this.deleted != that.deleted)
        return false;
    }

    boolean this_present_generation = true && this.isSetGeneration();
    boolean that_present_generation = true && that.isSetGeneration();
    if (this_present_generation || that_present_generation) {
      if (!(this_present_generation && that_present_generation))
        return false;
      if (this.generation != that.generation)
        return false;
    }

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_value_index = true;
    boolean that_present_value_index = true;
    if (this_present_value_index || that_present_value_index) {
      if (!(this_present_value_index && that_present_value_index))
        return false;
      if (this.value_index != that.value_index)
        return false;
    }

    boolean this_present_qualifier_index = true;
    boolean that_present_qualifier_index = true;
    if (this_present_qualifier_index || that_present_qualifier_index) {
      if (!(this_present_qualifier_index && that_present_qualifier_index))
        return false;
      if (this.qualifier_index != that.qualifier_index)
        return false;
    }

    boolean this_present_options = true && this.isSetOptions();
    boolean that_present_options = true && that.isSetOptions();
    if (this_present_options || that_present_options) {
      if (!(this_present_options && that_present_options))
        return false;
      if (!this.options.equals(that.options))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_access_group = true && (isSetAccess_group());
    list.add(present_access_group);
    if (present_access_group)
      list.add(access_group);

    boolean present_deleted = true;
    list.add(present_deleted);
    if (present_deleted)
      list.add(deleted);

    boolean present_generation = true && (isSetGeneration());
    list.add(present_generation);
    if (present_generation)
      list.add(generation);

    boolean present_id = true && (isSetId());
    list.add(present_id);
    if (present_id)
      list.add(id);

    boolean present_value_index = true;
    list.add(present_value_index);
    if (present_value_index)
      list.add(value_index);

    boolean present_qualifier_index = true;
    list.add(present_qualifier_index);
    if (present_qualifier_index)
      list.add(qualifier_index);

    boolean present_options = true && (isSetOptions());
    list.add(present_options);
    if (present_options)
      list.add(options);

    return list.hashCode();
  }

  @Override
  public int compareTo(ColumnFamilySpec other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAccess_group()).compareTo(other.isSetAccess_group());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAccess_group()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.access_group, other.access_group);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDeleted()).compareTo(other.isSetDeleted());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeleted()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deleted, other.deleted);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGeneration()).compareTo(other.isSetGeneration());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGeneration()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.generation, other.generation);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetValue_index()).compareTo(other.isSetValue_index());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValue_index()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.value_index, other.value_index);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQualifier_index()).compareTo(other.isSetQualifier_index());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQualifier_index()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.qualifier_index, other.qualifier_index);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOptions()).compareTo(other.isSetOptions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOptions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.options, other.options);
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
    StringBuilder sb = new StringBuilder("ColumnFamilySpec(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("access_group:");
    if (this.access_group == null) {
      sb.append("null");
    } else {
      sb.append(this.access_group);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("deleted:");
    sb.append(this.deleted);
    first = false;
    if (isSetGeneration()) {
      if (!first) sb.append(", ");
      sb.append("generation:");
      sb.append(this.generation);
      first = false;
    }
    if (isSetId()) {
      if (!first) sb.append(", ");
      sb.append("id:");
      sb.append(this.id);
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("value_index:");
    sb.append(this.value_index);
    first = false;
    if (!first) sb.append(", ");
    sb.append("qualifier_index:");
    sb.append(this.qualifier_index);
    first = false;
    if (isSetOptions()) {
      if (!first) sb.append(", ");
      sb.append("options:");
      if (this.options == null) {
        sb.append("null");
      } else {
        sb.append(this.options);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (options != null) {
      options.validate();
    }
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

  private static class ColumnFamilySpecStandardSchemeFactory implements SchemeFactory {
    public ColumnFamilySpecStandardScheme getScheme() {
      return new ColumnFamilySpecStandardScheme();
    }
  }

  private static class ColumnFamilySpecStandardScheme extends StandardScheme<ColumnFamilySpec> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ColumnFamilySpec struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ACCESS_GROUP
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.access_group = iprot.readString();
              struct.setAccess_groupIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DELETED
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.deleted = iprot.readBool();
              struct.setDeletedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // GENERATION
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.generation = iprot.readI64();
              struct.setGenerationIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // VALUE_INDEX
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.value_index = iprot.readBool();
              struct.setValue_indexIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // QUALIFIER_INDEX
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.qualifier_index = iprot.readBool();
              struct.setQualifier_indexIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // OPTIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.options = new ColumnFamilyOptions();
              struct.options.read(iprot);
              struct.setOptionsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ColumnFamilySpec struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.access_group != null) {
        oprot.writeFieldBegin(ACCESS_GROUP_FIELD_DESC);
        oprot.writeString(struct.access_group);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(DELETED_FIELD_DESC);
      oprot.writeBool(struct.deleted);
      oprot.writeFieldEnd();
      if (struct.isSetGeneration()) {
        oprot.writeFieldBegin(GENERATION_FIELD_DESC);
        oprot.writeI64(struct.generation);
        oprot.writeFieldEnd();
      }
      if (struct.isSetId()) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeI32(struct.id);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(VALUE_INDEX_FIELD_DESC);
      oprot.writeBool(struct.value_index);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(QUALIFIER_INDEX_FIELD_DESC);
      oprot.writeBool(struct.qualifier_index);
      oprot.writeFieldEnd();
      if (struct.options != null) {
        if (struct.isSetOptions()) {
          oprot.writeFieldBegin(OPTIONS_FIELD_DESC);
          struct.options.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ColumnFamilySpecTupleSchemeFactory implements SchemeFactory {
    public ColumnFamilySpecTupleScheme getScheme() {
      return new ColumnFamilySpecTupleScheme();
    }
  }

  private static class ColumnFamilySpecTupleScheme extends TupleScheme<ColumnFamilySpec> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ColumnFamilySpec struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetAccess_group()) {
        optionals.set(1);
      }
      if (struct.isSetDeleted()) {
        optionals.set(2);
      }
      if (struct.isSetGeneration()) {
        optionals.set(3);
      }
      if (struct.isSetId()) {
        optionals.set(4);
      }
      if (struct.isSetValue_index()) {
        optionals.set(5);
      }
      if (struct.isSetQualifier_index()) {
        optionals.set(6);
      }
      if (struct.isSetOptions()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetAccess_group()) {
        oprot.writeString(struct.access_group);
      }
      if (struct.isSetDeleted()) {
        oprot.writeBool(struct.deleted);
      }
      if (struct.isSetGeneration()) {
        oprot.writeI64(struct.generation);
      }
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetValue_index()) {
        oprot.writeBool(struct.value_index);
      }
      if (struct.isSetQualifier_index()) {
        oprot.writeBool(struct.qualifier_index);
      }
      if (struct.isSetOptions()) {
        struct.options.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ColumnFamilySpec struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.access_group = iprot.readString();
        struct.setAccess_groupIsSet(true);
      }
      if (incoming.get(2)) {
        struct.deleted = iprot.readBool();
        struct.setDeletedIsSet(true);
      }
      if (incoming.get(3)) {
        struct.generation = iprot.readI64();
        struct.setGenerationIsSet(true);
      }
      if (incoming.get(4)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(5)) {
        struct.value_index = iprot.readBool();
        struct.setValue_indexIsSet(true);
      }
      if (incoming.get(6)) {
        struct.qualifier_index = iprot.readBool();
        struct.setQualifier_indexIsSet(true);
      }
      if (incoming.get(7)) {
        struct.options = new ColumnFamilyOptions();
        struct.options.read(iprot);
        struct.setOptionsIsSet(true);
      }
    }
  }

}
