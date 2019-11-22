/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#include "Hql_types.h"

#include <algorithm>
#include <ostream>

#include <thrift/TToString.h>

namespace Hypertable { namespace ThriftGen {


HqlResult::~HqlResult() noexcept {
}


void HqlResult::__set_results(const std::vector<std::string> & val) {
  this->results = val;
__isset.results = true;
}

void HqlResult::__set_cells(const std::vector< ::Hypertable::ThriftGen::Cell> & val) {
  this->cells = val;
__isset.cells = true;
}

void HqlResult::__set_scanner(const int64_t val) {
  this->scanner = val;
__isset.scanner = true;
}

void HqlResult::__set_mutator(const int64_t val) {
  this->mutator = val;
__isset.mutator = true;
}
std::ostream& operator<<(std::ostream& out, const HqlResult& obj)
{
  obj.printTo(out);
  return out;
}


uint32_t HqlResult::read(::apache::thrift::protocol::TProtocol* iprot) {

  ::apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->results.clear();
            uint32_t _size0;
            ::apache::thrift::protocol::TType _etype3;
            xfer += iprot->readListBegin(_etype3, _size0);
            this->results.resize(_size0);
            uint32_t _i4;
            for (_i4 = 0; _i4 < _size0; ++_i4)
            {
              xfer += iprot->readString(this->results[_i4]);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.results = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->cells.clear();
            uint32_t _size5;
            ::apache::thrift::protocol::TType _etype8;
            xfer += iprot->readListBegin(_etype8, _size5);
            this->cells.resize(_size5);
            uint32_t _i9;
            for (_i9 = 0; _i9 < _size5; ++_i9)
            {
              xfer += this->cells[_i9].read(iprot);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.cells = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->scanner);
          this->__isset.scanner = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->mutator);
          this->__isset.mutator = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t HqlResult::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  ::apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("HqlResult");

  if (this->__isset.results) {
    xfer += oprot->writeFieldBegin("results", ::apache::thrift::protocol::T_LIST, 1);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRING, static_cast<uint32_t>(this->results.size()));
      std::vector<std::string> ::const_iterator _iter10;
      for (_iter10 = this->results.begin(); _iter10 != this->results.end(); ++_iter10)
      {
        xfer += oprot->writeString((*_iter10));
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.cells) {
    xfer += oprot->writeFieldBegin("cells", ::apache::thrift::protocol::T_LIST, 2);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRUCT, static_cast<uint32_t>(this->cells.size()));
      std::vector< ::Hypertable::ThriftGen::Cell> ::const_iterator _iter11;
      for (_iter11 = this->cells.begin(); _iter11 != this->cells.end(); ++_iter11)
      {
        xfer += (*_iter11).write(oprot);
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.scanner) {
    xfer += oprot->writeFieldBegin("scanner", ::apache::thrift::protocol::T_I64, 3);
    xfer += oprot->writeI64(this->scanner);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.mutator) {
    xfer += oprot->writeFieldBegin("mutator", ::apache::thrift::protocol::T_I64, 4);
    xfer += oprot->writeI64(this->mutator);
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(HqlResult &a, HqlResult &b) {
  using ::std::swap;
  swap(a.results, b.results);
  swap(a.cells, b.cells);
  swap(a.scanner, b.scanner);
  swap(a.mutator, b.mutator);
  swap(a.__isset, b.__isset);
}

HqlResult::HqlResult(const HqlResult& other12) {
  results = other12.results;
  cells = other12.cells;
  scanner = other12.scanner;
  mutator = other12.mutator;
  __isset = other12.__isset;
}
HqlResult& HqlResult::operator=(const HqlResult& other13) {
  results = other13.results;
  cells = other13.cells;
  scanner = other13.scanner;
  mutator = other13.mutator;
  __isset = other13.__isset;
  return *this;
}
void HqlResult::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "HqlResult(";
  out << "results="; (__isset.results ? (out << to_string(results)) : (out << "<null>"));
  out << ", " << "cells="; (__isset.cells ? (out << to_string(cells)) : (out << "<null>"));
  out << ", " << "scanner="; (__isset.scanner ? (out << to_string(scanner)) : (out << "<null>"));
  out << ", " << "mutator="; (__isset.mutator ? (out << to_string(mutator)) : (out << "<null>"));
  out << ")";
}


HqlResult2::~HqlResult2() noexcept {
}


void HqlResult2::__set_results(const std::vector<std::string> & val) {
  this->results = val;
__isset.results = true;
}

void HqlResult2::__set_cells(const std::vector< ::Hypertable::ThriftGen::CellAsArray> & val) {
  this->cells = val;
__isset.cells = true;
}

void HqlResult2::__set_scanner(const int64_t val) {
  this->scanner = val;
__isset.scanner = true;
}

void HqlResult2::__set_mutator(const int64_t val) {
  this->mutator = val;
__isset.mutator = true;
}
std::ostream& operator<<(std::ostream& out, const HqlResult2& obj)
{
  obj.printTo(out);
  return out;
}


uint32_t HqlResult2::read(::apache::thrift::protocol::TProtocol* iprot) {

  ::apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->results.clear();
            uint32_t _size14;
            ::apache::thrift::protocol::TType _etype17;
            xfer += iprot->readListBegin(_etype17, _size14);
            this->results.resize(_size14);
            uint32_t _i18;
            for (_i18 = 0; _i18 < _size14; ++_i18)
            {
              xfer += iprot->readString(this->results[_i18]);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.results = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->cells.clear();
            uint32_t _size19;
            ::apache::thrift::protocol::TType _etype22;
            xfer += iprot->readListBegin(_etype22, _size19);
            this->cells.resize(_size19);
            uint32_t _i23;
            for (_i23 = 0; _i23 < _size19; ++_i23)
            {
              {
                this->cells[_i23].clear();
                uint32_t _size24;
                ::apache::thrift::protocol::TType _etype27;
                xfer += iprot->readListBegin(_etype27, _size24);
                this->cells[_i23].resize(_size24);
                uint32_t _i28;
                for (_i28 = 0; _i28 < _size24; ++_i28)
                {
                  xfer += iprot->readString(this->cells[_i23][_i28]);
                }
                xfer += iprot->readListEnd();
              }
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.cells = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->scanner);
          this->__isset.scanner = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->mutator);
          this->__isset.mutator = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t HqlResult2::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  ::apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("HqlResult2");

  if (this->__isset.results) {
    xfer += oprot->writeFieldBegin("results", ::apache::thrift::protocol::T_LIST, 1);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRING, static_cast<uint32_t>(this->results.size()));
      std::vector<std::string> ::const_iterator _iter29;
      for (_iter29 = this->results.begin(); _iter29 != this->results.end(); ++_iter29)
      {
        xfer += oprot->writeString((*_iter29));
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.cells) {
    xfer += oprot->writeFieldBegin("cells", ::apache::thrift::protocol::T_LIST, 2);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_LIST, static_cast<uint32_t>(this->cells.size()));
      std::vector< ::Hypertable::ThriftGen::CellAsArray> ::const_iterator _iter30;
      for (_iter30 = this->cells.begin(); _iter30 != this->cells.end(); ++_iter30)
      {
        {
          xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRING, static_cast<uint32_t>((*_iter30).size()));
          std::vector<std::string> ::const_iterator _iter31;
          for (_iter31 = (*_iter30).begin(); _iter31 != (*_iter30).end(); ++_iter31)
          {
            xfer += oprot->writeString((*_iter31));
          }
          xfer += oprot->writeListEnd();
        }
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.scanner) {
    xfer += oprot->writeFieldBegin("scanner", ::apache::thrift::protocol::T_I64, 3);
    xfer += oprot->writeI64(this->scanner);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.mutator) {
    xfer += oprot->writeFieldBegin("mutator", ::apache::thrift::protocol::T_I64, 4);
    xfer += oprot->writeI64(this->mutator);
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(HqlResult2 &a, HqlResult2 &b) {
  using ::std::swap;
  swap(a.results, b.results);
  swap(a.cells, b.cells);
  swap(a.scanner, b.scanner);
  swap(a.mutator, b.mutator);
  swap(a.__isset, b.__isset);
}

HqlResult2::HqlResult2(const HqlResult2& other32) {
  results = other32.results;
  cells = other32.cells;
  scanner = other32.scanner;
  mutator = other32.mutator;
  __isset = other32.__isset;
}
HqlResult2& HqlResult2::operator=(const HqlResult2& other33) {
  results = other33.results;
  cells = other33.cells;
  scanner = other33.scanner;
  mutator = other33.mutator;
  __isset = other33.__isset;
  return *this;
}
void HqlResult2::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "HqlResult2(";
  out << "results="; (__isset.results ? (out << to_string(results)) : (out << "<null>"));
  out << ", " << "cells="; (__isset.cells ? (out << to_string(cells)) : (out << "<null>"));
  out << ", " << "scanner="; (__isset.scanner ? (out << to_string(scanner)) : (out << "<null>"));
  out << ", " << "mutator="; (__isset.mutator ? (out << to_string(mutator)) : (out << "<null>"));
  out << ")";
}


HqlResultAsArrays::~HqlResultAsArrays() noexcept {
}


void HqlResultAsArrays::__set_results(const std::vector<std::string> & val) {
  this->results = val;
__isset.results = true;
}

void HqlResultAsArrays::__set_cells(const std::vector< ::Hypertable::ThriftGen::CellAsArray> & val) {
  this->cells = val;
__isset.cells = true;
}

void HqlResultAsArrays::__set_scanner(const int64_t val) {
  this->scanner = val;
__isset.scanner = true;
}

void HqlResultAsArrays::__set_mutator(const int64_t val) {
  this->mutator = val;
__isset.mutator = true;
}
std::ostream& operator<<(std::ostream& out, const HqlResultAsArrays& obj)
{
  obj.printTo(out);
  return out;
}


uint32_t HqlResultAsArrays::read(::apache::thrift::protocol::TProtocol* iprot) {

  ::apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->results.clear();
            uint32_t _size34;
            ::apache::thrift::protocol::TType _etype37;
            xfer += iprot->readListBegin(_etype37, _size34);
            this->results.resize(_size34);
            uint32_t _i38;
            for (_i38 = 0; _i38 < _size34; ++_i38)
            {
              xfer += iprot->readString(this->results[_i38]);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.results = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->cells.clear();
            uint32_t _size39;
            ::apache::thrift::protocol::TType _etype42;
            xfer += iprot->readListBegin(_etype42, _size39);
            this->cells.resize(_size39);
            uint32_t _i43;
            for (_i43 = 0; _i43 < _size39; ++_i43)
            {
              {
                this->cells[_i43].clear();
                uint32_t _size44;
                ::apache::thrift::protocol::TType _etype47;
                xfer += iprot->readListBegin(_etype47, _size44);
                this->cells[_i43].resize(_size44);
                uint32_t _i48;
                for (_i48 = 0; _i48 < _size44; ++_i48)
                {
                  xfer += iprot->readString(this->cells[_i43][_i48]);
                }
                xfer += iprot->readListEnd();
              }
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.cells = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->scanner);
          this->__isset.scanner = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->mutator);
          this->__isset.mutator = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t HqlResultAsArrays::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  ::apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("HqlResultAsArrays");

  if (this->__isset.results) {
    xfer += oprot->writeFieldBegin("results", ::apache::thrift::protocol::T_LIST, 1);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRING, static_cast<uint32_t>(this->results.size()));
      std::vector<std::string> ::const_iterator _iter49;
      for (_iter49 = this->results.begin(); _iter49 != this->results.end(); ++_iter49)
      {
        xfer += oprot->writeString((*_iter49));
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.cells) {
    xfer += oprot->writeFieldBegin("cells", ::apache::thrift::protocol::T_LIST, 2);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_LIST, static_cast<uint32_t>(this->cells.size()));
      std::vector< ::Hypertable::ThriftGen::CellAsArray> ::const_iterator _iter50;
      for (_iter50 = this->cells.begin(); _iter50 != this->cells.end(); ++_iter50)
      {
        {
          xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRING, static_cast<uint32_t>((*_iter50).size()));
          std::vector<std::string> ::const_iterator _iter51;
          for (_iter51 = (*_iter50).begin(); _iter51 != (*_iter50).end(); ++_iter51)
          {
            xfer += oprot->writeString((*_iter51));
          }
          xfer += oprot->writeListEnd();
        }
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.scanner) {
    xfer += oprot->writeFieldBegin("scanner", ::apache::thrift::protocol::T_I64, 3);
    xfer += oprot->writeI64(this->scanner);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.mutator) {
    xfer += oprot->writeFieldBegin("mutator", ::apache::thrift::protocol::T_I64, 4);
    xfer += oprot->writeI64(this->mutator);
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(HqlResultAsArrays &a, HqlResultAsArrays &b) {
  using ::std::swap;
  swap(a.results, b.results);
  swap(a.cells, b.cells);
  swap(a.scanner, b.scanner);
  swap(a.mutator, b.mutator);
  swap(a.__isset, b.__isset);
}

HqlResultAsArrays::HqlResultAsArrays(const HqlResultAsArrays& other52) {
  results = other52.results;
  cells = other52.cells;
  scanner = other52.scanner;
  mutator = other52.mutator;
  __isset = other52.__isset;
}
HqlResultAsArrays& HqlResultAsArrays::operator=(const HqlResultAsArrays& other53) {
  results = other53.results;
  cells = other53.cells;
  scanner = other53.scanner;
  mutator = other53.mutator;
  __isset = other53.__isset;
  return *this;
}
void HqlResultAsArrays::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "HqlResultAsArrays(";
  out << "results="; (__isset.results ? (out << to_string(results)) : (out << "<null>"));
  out << ", " << "cells="; (__isset.cells ? (out << to_string(cells)) : (out << "<null>"));
  out << ", " << "scanner="; (__isset.scanner ? (out << to_string(scanner)) : (out << "<null>"));
  out << ", " << "mutator="; (__isset.mutator ? (out << to_string(mutator)) : (out << "<null>"));
  out << ")";
}

}} // namespace
