/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef HqlService_H
#define HqlService_H

#include <thrift/TDispatchProcessor.h>
#include <thrift/async/TConcurrentClientSyncInfo.h>
#include <memory>
#include "Hql_types.h"
#include "ClientService.h"

namespace Hypertable { namespace ThriftGen {

#ifdef _MSC_VER
  #pragma warning( push )
  #pragma warning (disable : 4250 ) //inheriting methods via dominance 
#endif

class HqlServiceIf : virtual public  ::Hypertable::ThriftGen::ClientServiceIf {
 public:
  virtual ~HqlServiceIf() {}

  /**
   * Execute an HQL command
   * 
   * @param ns - Namespace id
   * 
   * @param command - HQL command
   * 
   * @param noflush - Do not auto commit any modifications (return a mutator)
   * 
   * @param unbuffered - return a scanner instead of buffered results
   * 
   * @param ns
   * @param command
   * @param noflush
   * @param unbuffered
   */
  virtual void hql_exec(HqlResult& _return, const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered) = 0;

  /**
   * Convenience method for executing an buffered and flushed query
   * 
   * because thrift doesn't (and probably won't) support default argument values
   * 
   * @param ns - Namespace
   * 
   * @param command - HQL command
   * 
   * @param ns
   * @param command
   */
  virtual void hql_query(HqlResult& _return, const int64_t ns, const std::string& command) = 0;

  /**
   * @see hql_exec
   * 
   * @param ns
   * @param command
   * @param noflush
   * @param unbuffered
   */
  virtual void hql_exec_as_arrays(HqlResultAsArrays& _return, const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered) = 0;
  virtual void hql_exec2(HqlResult2& _return, const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered) = 0;

  /**
   * @see hql_query
   * 
   * @param ns
   * @param command
   */
  virtual void hql_query_as_arrays(HqlResultAsArrays& _return, const int64_t ns, const std::string& command) = 0;
  virtual void hql_query2(HqlResult2& _return, const int64_t ns, const std::string& command) = 0;
};

class HqlServiceIfFactory : virtual public  ::Hypertable::ThriftGen::ClientServiceIfFactory {
 public:
  typedef HqlServiceIf Handler;

  virtual ~HqlServiceIfFactory() {}

  virtual HqlServiceIf* getHandler(const ::apache::thrift::TConnectionInfo& connInfo) = 0;
  virtual void releaseHandler( ::Hypertable::ThriftGen::ClientServiceIf* /* handler */) = 0;
};

class HqlServiceIfSingletonFactory : virtual public HqlServiceIfFactory {
 public:
  HqlServiceIfSingletonFactory(const ::std::shared_ptr<HqlServiceIf>& iface) : iface_(iface) {}
  virtual ~HqlServiceIfSingletonFactory() {}

  virtual HqlServiceIf* getHandler(const ::apache::thrift::TConnectionInfo&) {
    return iface_.get();
  }
  virtual void releaseHandler( ::Hypertable::ThriftGen::ClientServiceIf* /* handler */) {}

 protected:
  ::std::shared_ptr<HqlServiceIf> iface_;
};

class HqlServiceNull : virtual public HqlServiceIf , virtual public  ::Hypertable::ThriftGen::ClientServiceNull {
 public:
  virtual ~HqlServiceNull() {}
  void hql_exec(HqlResult& /* _return */, const int64_t /* ns */, const std::string& /* command */, const bool /* noflush */, const bool /* unbuffered */) {
    return;
  }
  void hql_query(HqlResult& /* _return */, const int64_t /* ns */, const std::string& /* command */) {
    return;
  }
  void hql_exec_as_arrays(HqlResultAsArrays& /* _return */, const int64_t /* ns */, const std::string& /* command */, const bool /* noflush */, const bool /* unbuffered */) {
    return;
  }
  void hql_exec2(HqlResult2& /* _return */, const int64_t /* ns */, const std::string& /* command */, const bool /* noflush */, const bool /* unbuffered */) {
    return;
  }
  void hql_query_as_arrays(HqlResultAsArrays& /* _return */, const int64_t /* ns */, const std::string& /* command */) {
    return;
  }
  void hql_query2(HqlResult2& /* _return */, const int64_t /* ns */, const std::string& /* command */) {
    return;
  }
};

typedef struct _HqlService_hql_exec_args__isset {
  _HqlService_hql_exec_args__isset() : ns(false), command(false), noflush(true), unbuffered(true) {}
  bool ns :1;
  bool command :1;
  bool noflush :1;
  bool unbuffered :1;
} _HqlService_hql_exec_args__isset;

class HqlService_hql_exec_args {
 public:

  HqlService_hql_exec_args(const HqlService_hql_exec_args&);
  HqlService_hql_exec_args& operator=(const HqlService_hql_exec_args&);
  HqlService_hql_exec_args() : ns(0), command(), noflush(false), unbuffered(false) {
  }

  virtual ~HqlService_hql_exec_args() noexcept;
  int64_t ns;
  std::string command;
  bool noflush;
  bool unbuffered;

  _HqlService_hql_exec_args__isset __isset;

  void __set_ns(const int64_t val);

  void __set_command(const std::string& val);

  void __set_noflush(const bool val);

  void __set_unbuffered(const bool val);

  bool operator == (const HqlService_hql_exec_args & rhs) const
  {
    if (!(ns == rhs.ns))
      return false;
    if (!(command == rhs.command))
      return false;
    if (!(noflush == rhs.noflush))
      return false;
    if (!(unbuffered == rhs.unbuffered))
      return false;
    return true;
  }
  bool operator != (const HqlService_hql_exec_args &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HqlService_hql_exec_args & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};


class HqlService_hql_exec_pargs {
 public:


  virtual ~HqlService_hql_exec_pargs() noexcept;
  const int64_t* ns;
  const std::string* command;
  const bool* noflush;
  const bool* unbuffered;

  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HqlService_hql_exec_result__isset {
  _HqlService_hql_exec_result__isset() : success(false), e(false) {}
  bool success :1;
  bool e :1;
} _HqlService_hql_exec_result__isset;

class HqlService_hql_exec_result {
 public:

  HqlService_hql_exec_result(const HqlService_hql_exec_result&);
  HqlService_hql_exec_result& operator=(const HqlService_hql_exec_result&);
  HqlService_hql_exec_result() {
  }

  virtual ~HqlService_hql_exec_result() noexcept;
  HqlResult success;
   ::Hypertable::ThriftGen::ClientException e;

  _HqlService_hql_exec_result__isset __isset;

  void __set_success(const HqlResult& val);

  void __set_e(const  ::Hypertable::ThriftGen::ClientException& val);

  bool operator == (const HqlService_hql_exec_result & rhs) const
  {
    if (!(success == rhs.success))
      return false;
    if (!(e == rhs.e))
      return false;
    return true;
  }
  bool operator != (const HqlService_hql_exec_result &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HqlService_hql_exec_result & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HqlService_hql_exec_presult__isset {
  _HqlService_hql_exec_presult__isset() : success(false), e(false) {}
  bool success :1;
  bool e :1;
} _HqlService_hql_exec_presult__isset;

class HqlService_hql_exec_presult {
 public:


  virtual ~HqlService_hql_exec_presult() noexcept;
  HqlResult* success;
   ::Hypertable::ThriftGen::ClientException e;

  _HqlService_hql_exec_presult__isset __isset;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);

};

typedef struct _HqlService_hql_query_args__isset {
  _HqlService_hql_query_args__isset() : ns(false), command(false) {}
  bool ns :1;
  bool command :1;
} _HqlService_hql_query_args__isset;

class HqlService_hql_query_args {
 public:

  HqlService_hql_query_args(const HqlService_hql_query_args&);
  HqlService_hql_query_args& operator=(const HqlService_hql_query_args&);
  HqlService_hql_query_args() : ns(0), command() {
  }

  virtual ~HqlService_hql_query_args() noexcept;
  int64_t ns;
  std::string command;

  _HqlService_hql_query_args__isset __isset;

  void __set_ns(const int64_t val);

  void __set_command(const std::string& val);

  bool operator == (const HqlService_hql_query_args & rhs) const
  {
    if (!(ns == rhs.ns))
      return false;
    if (!(command == rhs.command))
      return false;
    return true;
  }
  bool operator != (const HqlService_hql_query_args &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HqlService_hql_query_args & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};


class HqlService_hql_query_pargs {
 public:


  virtual ~HqlService_hql_query_pargs() noexcept;
  const int64_t* ns;
  const std::string* command;

  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HqlService_hql_query_result__isset {
  _HqlService_hql_query_result__isset() : success(false), e(false) {}
  bool success :1;
  bool e :1;
} _HqlService_hql_query_result__isset;

class HqlService_hql_query_result {
 public:

  HqlService_hql_query_result(const HqlService_hql_query_result&);
  HqlService_hql_query_result& operator=(const HqlService_hql_query_result&);
  HqlService_hql_query_result() {
  }

  virtual ~HqlService_hql_query_result() noexcept;
  HqlResult success;
   ::Hypertable::ThriftGen::ClientException e;

  _HqlService_hql_query_result__isset __isset;

  void __set_success(const HqlResult& val);

  void __set_e(const  ::Hypertable::ThriftGen::ClientException& val);

  bool operator == (const HqlService_hql_query_result & rhs) const
  {
    if (!(success == rhs.success))
      return false;
    if (!(e == rhs.e))
      return false;
    return true;
  }
  bool operator != (const HqlService_hql_query_result &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HqlService_hql_query_result & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HqlService_hql_query_presult__isset {
  _HqlService_hql_query_presult__isset() : success(false), e(false) {}
  bool success :1;
  bool e :1;
} _HqlService_hql_query_presult__isset;

class HqlService_hql_query_presult {
 public:


  virtual ~HqlService_hql_query_presult() noexcept;
  HqlResult* success;
   ::Hypertable::ThriftGen::ClientException e;

  _HqlService_hql_query_presult__isset __isset;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);

};

typedef struct _HqlService_hql_exec_as_arrays_args__isset {
  _HqlService_hql_exec_as_arrays_args__isset() : ns(false), command(false), noflush(true), unbuffered(true) {}
  bool ns :1;
  bool command :1;
  bool noflush :1;
  bool unbuffered :1;
} _HqlService_hql_exec_as_arrays_args__isset;

class HqlService_hql_exec_as_arrays_args {
 public:

  HqlService_hql_exec_as_arrays_args(const HqlService_hql_exec_as_arrays_args&);
  HqlService_hql_exec_as_arrays_args& operator=(const HqlService_hql_exec_as_arrays_args&);
  HqlService_hql_exec_as_arrays_args() : ns(0), command(), noflush(false), unbuffered(false) {
  }

  virtual ~HqlService_hql_exec_as_arrays_args() noexcept;
  int64_t ns;
  std::string command;
  bool noflush;
  bool unbuffered;

  _HqlService_hql_exec_as_arrays_args__isset __isset;

  void __set_ns(const int64_t val);

  void __set_command(const std::string& val);

  void __set_noflush(const bool val);

  void __set_unbuffered(const bool val);

  bool operator == (const HqlService_hql_exec_as_arrays_args & rhs) const
  {
    if (!(ns == rhs.ns))
      return false;
    if (!(command == rhs.command))
      return false;
    if (!(noflush == rhs.noflush))
      return false;
    if (!(unbuffered == rhs.unbuffered))
      return false;
    return true;
  }
  bool operator != (const HqlService_hql_exec_as_arrays_args &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HqlService_hql_exec_as_arrays_args & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};


class HqlService_hql_exec_as_arrays_pargs {
 public:


  virtual ~HqlService_hql_exec_as_arrays_pargs() noexcept;
  const int64_t* ns;
  const std::string* command;
  const bool* noflush;
  const bool* unbuffered;

  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HqlService_hql_exec_as_arrays_result__isset {
  _HqlService_hql_exec_as_arrays_result__isset() : success(false), e(false) {}
  bool success :1;
  bool e :1;
} _HqlService_hql_exec_as_arrays_result__isset;

class HqlService_hql_exec_as_arrays_result {
 public:

  HqlService_hql_exec_as_arrays_result(const HqlService_hql_exec_as_arrays_result&);
  HqlService_hql_exec_as_arrays_result& operator=(const HqlService_hql_exec_as_arrays_result&);
  HqlService_hql_exec_as_arrays_result() {
  }

  virtual ~HqlService_hql_exec_as_arrays_result() noexcept;
  HqlResultAsArrays success;
   ::Hypertable::ThriftGen::ClientException e;

  _HqlService_hql_exec_as_arrays_result__isset __isset;

  void __set_success(const HqlResultAsArrays& val);

  void __set_e(const  ::Hypertable::ThriftGen::ClientException& val);

  bool operator == (const HqlService_hql_exec_as_arrays_result & rhs) const
  {
    if (!(success == rhs.success))
      return false;
    if (!(e == rhs.e))
      return false;
    return true;
  }
  bool operator != (const HqlService_hql_exec_as_arrays_result &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HqlService_hql_exec_as_arrays_result & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HqlService_hql_exec_as_arrays_presult__isset {
  _HqlService_hql_exec_as_arrays_presult__isset() : success(false), e(false) {}
  bool success :1;
  bool e :1;
} _HqlService_hql_exec_as_arrays_presult__isset;

class HqlService_hql_exec_as_arrays_presult {
 public:


  virtual ~HqlService_hql_exec_as_arrays_presult() noexcept;
  HqlResultAsArrays* success;
   ::Hypertable::ThriftGen::ClientException e;

  _HqlService_hql_exec_as_arrays_presult__isset __isset;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);

};

typedef struct _HqlService_hql_exec2_args__isset {
  _HqlService_hql_exec2_args__isset() : ns(false), command(false), noflush(true), unbuffered(true) {}
  bool ns :1;
  bool command :1;
  bool noflush :1;
  bool unbuffered :1;
} _HqlService_hql_exec2_args__isset;

class HqlService_hql_exec2_args {
 public:

  HqlService_hql_exec2_args(const HqlService_hql_exec2_args&);
  HqlService_hql_exec2_args& operator=(const HqlService_hql_exec2_args&);
  HqlService_hql_exec2_args() : ns(0), command(), noflush(false), unbuffered(false) {
  }

  virtual ~HqlService_hql_exec2_args() noexcept;
  int64_t ns;
  std::string command;
  bool noflush;
  bool unbuffered;

  _HqlService_hql_exec2_args__isset __isset;

  void __set_ns(const int64_t val);

  void __set_command(const std::string& val);

  void __set_noflush(const bool val);

  void __set_unbuffered(const bool val);

  bool operator == (const HqlService_hql_exec2_args & rhs) const
  {
    if (!(ns == rhs.ns))
      return false;
    if (!(command == rhs.command))
      return false;
    if (!(noflush == rhs.noflush))
      return false;
    if (!(unbuffered == rhs.unbuffered))
      return false;
    return true;
  }
  bool operator != (const HqlService_hql_exec2_args &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HqlService_hql_exec2_args & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};


class HqlService_hql_exec2_pargs {
 public:


  virtual ~HqlService_hql_exec2_pargs() noexcept;
  const int64_t* ns;
  const std::string* command;
  const bool* noflush;
  const bool* unbuffered;

  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HqlService_hql_exec2_result__isset {
  _HqlService_hql_exec2_result__isset() : success(false), e(false) {}
  bool success :1;
  bool e :1;
} _HqlService_hql_exec2_result__isset;

class HqlService_hql_exec2_result {
 public:

  HqlService_hql_exec2_result(const HqlService_hql_exec2_result&);
  HqlService_hql_exec2_result& operator=(const HqlService_hql_exec2_result&);
  HqlService_hql_exec2_result() {
  }

  virtual ~HqlService_hql_exec2_result() noexcept;
  HqlResult2 success;
   ::Hypertable::ThriftGen::ClientException e;

  _HqlService_hql_exec2_result__isset __isset;

  void __set_success(const HqlResult2& val);

  void __set_e(const  ::Hypertable::ThriftGen::ClientException& val);

  bool operator == (const HqlService_hql_exec2_result & rhs) const
  {
    if (!(success == rhs.success))
      return false;
    if (!(e == rhs.e))
      return false;
    return true;
  }
  bool operator != (const HqlService_hql_exec2_result &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HqlService_hql_exec2_result & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HqlService_hql_exec2_presult__isset {
  _HqlService_hql_exec2_presult__isset() : success(false), e(false) {}
  bool success :1;
  bool e :1;
} _HqlService_hql_exec2_presult__isset;

class HqlService_hql_exec2_presult {
 public:


  virtual ~HqlService_hql_exec2_presult() noexcept;
  HqlResult2* success;
   ::Hypertable::ThriftGen::ClientException e;

  _HqlService_hql_exec2_presult__isset __isset;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);

};

typedef struct _HqlService_hql_query_as_arrays_args__isset {
  _HqlService_hql_query_as_arrays_args__isset() : ns(false), command(false) {}
  bool ns :1;
  bool command :1;
} _HqlService_hql_query_as_arrays_args__isset;

class HqlService_hql_query_as_arrays_args {
 public:

  HqlService_hql_query_as_arrays_args(const HqlService_hql_query_as_arrays_args&);
  HqlService_hql_query_as_arrays_args& operator=(const HqlService_hql_query_as_arrays_args&);
  HqlService_hql_query_as_arrays_args() : ns(0), command() {
  }

  virtual ~HqlService_hql_query_as_arrays_args() noexcept;
  int64_t ns;
  std::string command;

  _HqlService_hql_query_as_arrays_args__isset __isset;

  void __set_ns(const int64_t val);

  void __set_command(const std::string& val);

  bool operator == (const HqlService_hql_query_as_arrays_args & rhs) const
  {
    if (!(ns == rhs.ns))
      return false;
    if (!(command == rhs.command))
      return false;
    return true;
  }
  bool operator != (const HqlService_hql_query_as_arrays_args &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HqlService_hql_query_as_arrays_args & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};


class HqlService_hql_query_as_arrays_pargs {
 public:


  virtual ~HqlService_hql_query_as_arrays_pargs() noexcept;
  const int64_t* ns;
  const std::string* command;

  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HqlService_hql_query_as_arrays_result__isset {
  _HqlService_hql_query_as_arrays_result__isset() : success(false), e(false) {}
  bool success :1;
  bool e :1;
} _HqlService_hql_query_as_arrays_result__isset;

class HqlService_hql_query_as_arrays_result {
 public:

  HqlService_hql_query_as_arrays_result(const HqlService_hql_query_as_arrays_result&);
  HqlService_hql_query_as_arrays_result& operator=(const HqlService_hql_query_as_arrays_result&);
  HqlService_hql_query_as_arrays_result() {
  }

  virtual ~HqlService_hql_query_as_arrays_result() noexcept;
  HqlResultAsArrays success;
   ::Hypertable::ThriftGen::ClientException e;

  _HqlService_hql_query_as_arrays_result__isset __isset;

  void __set_success(const HqlResultAsArrays& val);

  void __set_e(const  ::Hypertable::ThriftGen::ClientException& val);

  bool operator == (const HqlService_hql_query_as_arrays_result & rhs) const
  {
    if (!(success == rhs.success))
      return false;
    if (!(e == rhs.e))
      return false;
    return true;
  }
  bool operator != (const HqlService_hql_query_as_arrays_result &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HqlService_hql_query_as_arrays_result & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HqlService_hql_query_as_arrays_presult__isset {
  _HqlService_hql_query_as_arrays_presult__isset() : success(false), e(false) {}
  bool success :1;
  bool e :1;
} _HqlService_hql_query_as_arrays_presult__isset;

class HqlService_hql_query_as_arrays_presult {
 public:


  virtual ~HqlService_hql_query_as_arrays_presult() noexcept;
  HqlResultAsArrays* success;
   ::Hypertable::ThriftGen::ClientException e;

  _HqlService_hql_query_as_arrays_presult__isset __isset;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);

};

typedef struct _HqlService_hql_query2_args__isset {
  _HqlService_hql_query2_args__isset() : ns(false), command(false) {}
  bool ns :1;
  bool command :1;
} _HqlService_hql_query2_args__isset;

class HqlService_hql_query2_args {
 public:

  HqlService_hql_query2_args(const HqlService_hql_query2_args&);
  HqlService_hql_query2_args& operator=(const HqlService_hql_query2_args&);
  HqlService_hql_query2_args() : ns(0), command() {
  }

  virtual ~HqlService_hql_query2_args() noexcept;
  int64_t ns;
  std::string command;

  _HqlService_hql_query2_args__isset __isset;

  void __set_ns(const int64_t val);

  void __set_command(const std::string& val);

  bool operator == (const HqlService_hql_query2_args & rhs) const
  {
    if (!(ns == rhs.ns))
      return false;
    if (!(command == rhs.command))
      return false;
    return true;
  }
  bool operator != (const HqlService_hql_query2_args &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HqlService_hql_query2_args & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};


class HqlService_hql_query2_pargs {
 public:


  virtual ~HqlService_hql_query2_pargs() noexcept;
  const int64_t* ns;
  const std::string* command;

  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HqlService_hql_query2_result__isset {
  _HqlService_hql_query2_result__isset() : success(false), e(false) {}
  bool success :1;
  bool e :1;
} _HqlService_hql_query2_result__isset;

class HqlService_hql_query2_result {
 public:

  HqlService_hql_query2_result(const HqlService_hql_query2_result&);
  HqlService_hql_query2_result& operator=(const HqlService_hql_query2_result&);
  HqlService_hql_query2_result() {
  }

  virtual ~HqlService_hql_query2_result() noexcept;
  HqlResult2 success;
   ::Hypertable::ThriftGen::ClientException e;

  _HqlService_hql_query2_result__isset __isset;

  void __set_success(const HqlResult2& val);

  void __set_e(const  ::Hypertable::ThriftGen::ClientException& val);

  bool operator == (const HqlService_hql_query2_result & rhs) const
  {
    if (!(success == rhs.success))
      return false;
    if (!(e == rhs.e))
      return false;
    return true;
  }
  bool operator != (const HqlService_hql_query2_result &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HqlService_hql_query2_result & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HqlService_hql_query2_presult__isset {
  _HqlService_hql_query2_presult__isset() : success(false), e(false) {}
  bool success :1;
  bool e :1;
} _HqlService_hql_query2_presult__isset;

class HqlService_hql_query2_presult {
 public:


  virtual ~HqlService_hql_query2_presult() noexcept;
  HqlResult2* success;
   ::Hypertable::ThriftGen::ClientException e;

  _HqlService_hql_query2_presult__isset __isset;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);

};

class HqlServiceClient : virtual public HqlServiceIf, public  ::Hypertable::ThriftGen::ClientServiceClient {
 public:
  HqlServiceClient(std::shared_ptr< ::apache::thrift::protocol::TProtocol> prot) :
     ::Hypertable::ThriftGen::ClientServiceClient(prot, prot) {}
  HqlServiceClient(std::shared_ptr< ::apache::thrift::protocol::TProtocol> iprot, std::shared_ptr< ::apache::thrift::protocol::TProtocol> oprot) :     ::Hypertable::ThriftGen::ClientServiceClient(iprot, oprot) {}
  std::shared_ptr< ::apache::thrift::protocol::TProtocol> getInputProtocol() {
    return piprot_;
  }
  std::shared_ptr< ::apache::thrift::protocol::TProtocol> getOutputProtocol() {
    return poprot_;
  }
  void hql_exec(HqlResult& _return, const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered);
  void send_hql_exec(const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered);
  void recv_hql_exec(HqlResult& _return);
  void hql_query(HqlResult& _return, const int64_t ns, const std::string& command);
  void send_hql_query(const int64_t ns, const std::string& command);
  void recv_hql_query(HqlResult& _return);
  void hql_exec_as_arrays(HqlResultAsArrays& _return, const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered);
  void send_hql_exec_as_arrays(const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered);
  void recv_hql_exec_as_arrays(HqlResultAsArrays& _return);
  void hql_exec2(HqlResult2& _return, const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered);
  void send_hql_exec2(const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered);
  void recv_hql_exec2(HqlResult2& _return);
  void hql_query_as_arrays(HqlResultAsArrays& _return, const int64_t ns, const std::string& command);
  void send_hql_query_as_arrays(const int64_t ns, const std::string& command);
  void recv_hql_query_as_arrays(HqlResultAsArrays& _return);
  void hql_query2(HqlResult2& _return, const int64_t ns, const std::string& command);
  void send_hql_query2(const int64_t ns, const std::string& command);
  void recv_hql_query2(HqlResult2& _return);
};

class HqlServiceProcessor : public  ::Hypertable::ThriftGen::ClientServiceProcessor {
 protected:
  ::std::shared_ptr<HqlServiceIf> iface_;
  virtual bool dispatchCall(::apache::thrift::protocol::TProtocol* iprot, ::apache::thrift::protocol::TProtocol* oprot, const std::string& fname, int32_t seqid, void* callContext);
 private:
  typedef  void (HqlServiceProcessor::*ProcessFunction)(int32_t, ::apache::thrift::protocol::TProtocol*, ::apache::thrift::protocol::TProtocol*, void*);
  typedef std::map<std::string, ProcessFunction> ProcessMap;
  ProcessMap processMap_;
  void process_hql_exec(int32_t seqid, ::apache::thrift::protocol::TProtocol* iprot, ::apache::thrift::protocol::TProtocol* oprot, void* callContext);
  void process_hql_query(int32_t seqid, ::apache::thrift::protocol::TProtocol* iprot, ::apache::thrift::protocol::TProtocol* oprot, void* callContext);
  void process_hql_exec_as_arrays(int32_t seqid, ::apache::thrift::protocol::TProtocol* iprot, ::apache::thrift::protocol::TProtocol* oprot, void* callContext);
  void process_hql_exec2(int32_t seqid, ::apache::thrift::protocol::TProtocol* iprot, ::apache::thrift::protocol::TProtocol* oprot, void* callContext);
  void process_hql_query_as_arrays(int32_t seqid, ::apache::thrift::protocol::TProtocol* iprot, ::apache::thrift::protocol::TProtocol* oprot, void* callContext);
  void process_hql_query2(int32_t seqid, ::apache::thrift::protocol::TProtocol* iprot, ::apache::thrift::protocol::TProtocol* oprot, void* callContext);
 public:
  HqlServiceProcessor(::std::shared_ptr<HqlServiceIf> iface) :
     ::Hypertable::ThriftGen::ClientServiceProcessor(iface),
    iface_(iface) {
    processMap_["hql_exec"] = &HqlServiceProcessor::process_hql_exec;
    processMap_["hql_query"] = &HqlServiceProcessor::process_hql_query;
    processMap_["hql_exec_as_arrays"] = &HqlServiceProcessor::process_hql_exec_as_arrays;
    processMap_["hql_exec2"] = &HqlServiceProcessor::process_hql_exec2;
    processMap_["hql_query_as_arrays"] = &HqlServiceProcessor::process_hql_query_as_arrays;
    processMap_["hql_query2"] = &HqlServiceProcessor::process_hql_query2;
  }

  virtual ~HqlServiceProcessor() {}
};

class HqlServiceProcessorFactory : public ::apache::thrift::TProcessorFactory {
 public:
  HqlServiceProcessorFactory(const ::std::shared_ptr< HqlServiceIfFactory >& handlerFactory) :
      handlerFactory_(handlerFactory) {}

  ::std::shared_ptr< ::apache::thrift::TProcessor > getProcessor(const ::apache::thrift::TConnectionInfo& connInfo);

 protected:
  ::std::shared_ptr< HqlServiceIfFactory > handlerFactory_;
};

class HqlServiceMultiface : virtual public HqlServiceIf, public  ::Hypertable::ThriftGen::ClientServiceMultiface {
 public:
  HqlServiceMultiface(std::vector<std::shared_ptr<HqlServiceIf> >& ifaces) : ifaces_(ifaces) {
    std::vector<std::shared_ptr<HqlServiceIf> >::iterator iter;
    for (iter = ifaces.begin(); iter != ifaces.end(); ++iter) {
       ::Hypertable::ThriftGen::ClientServiceMultiface::add(*iter);
    }
  }
  virtual ~HqlServiceMultiface() {}
 protected:
  std::vector<std::shared_ptr<HqlServiceIf> > ifaces_;
  HqlServiceMultiface() {}
  void add(::std::shared_ptr<HqlServiceIf> iface) {
     ::Hypertable::ThriftGen::ClientServiceMultiface::add(iface);
    ifaces_.push_back(iface);
  }
 public:
  void hql_exec(HqlResult& _return, const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered) {
    size_t sz = ifaces_.size();
    size_t i = 0;
    for (; i < (sz - 1); ++i) {
      ifaces_[i]->hql_exec(_return, ns, command, noflush, unbuffered);
    }
    ifaces_[i]->hql_exec(_return, ns, command, noflush, unbuffered);
    return;
  }

  void hql_query(HqlResult& _return, const int64_t ns, const std::string& command) {
    size_t sz = ifaces_.size();
    size_t i = 0;
    for (; i < (sz - 1); ++i) {
      ifaces_[i]->hql_query(_return, ns, command);
    }
    ifaces_[i]->hql_query(_return, ns, command);
    return;
  }

  void hql_exec_as_arrays(HqlResultAsArrays& _return, const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered) {
    size_t sz = ifaces_.size();
    size_t i = 0;
    for (; i < (sz - 1); ++i) {
      ifaces_[i]->hql_exec_as_arrays(_return, ns, command, noflush, unbuffered);
    }
    ifaces_[i]->hql_exec_as_arrays(_return, ns, command, noflush, unbuffered);
    return;
  }

  void hql_exec2(HqlResult2& _return, const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered) {
    size_t sz = ifaces_.size();
    size_t i = 0;
    for (; i < (sz - 1); ++i) {
      ifaces_[i]->hql_exec2(_return, ns, command, noflush, unbuffered);
    }
    ifaces_[i]->hql_exec2(_return, ns, command, noflush, unbuffered);
    return;
  }

  void hql_query_as_arrays(HqlResultAsArrays& _return, const int64_t ns, const std::string& command) {
    size_t sz = ifaces_.size();
    size_t i = 0;
    for (; i < (sz - 1); ++i) {
      ifaces_[i]->hql_query_as_arrays(_return, ns, command);
    }
    ifaces_[i]->hql_query_as_arrays(_return, ns, command);
    return;
  }

  void hql_query2(HqlResult2& _return, const int64_t ns, const std::string& command) {
    size_t sz = ifaces_.size();
    size_t i = 0;
    for (; i < (sz - 1); ++i) {
      ifaces_[i]->hql_query2(_return, ns, command);
    }
    ifaces_[i]->hql_query2(_return, ns, command);
    return;
  }

};

// The 'concurrent' client is a thread safe client that correctly handles
// out of order responses.  It is slower than the regular client, so should
// only be used when you need to share a connection among multiple threads
class HqlServiceConcurrentClient : virtual public HqlServiceIf, public  ::Hypertable::ThriftGen::ClientServiceConcurrentClient {
 public:
  HqlServiceConcurrentClient(std::shared_ptr< ::apache::thrift::protocol::TProtocol> prot, std::shared_ptr<::apache::thrift::async::TConcurrentClientSyncInfo> sync) :
     ::Hypertable::ThriftGen::ClientServiceConcurrentClient(prot, prot, sync) {}
  HqlServiceConcurrentClient(std::shared_ptr< ::apache::thrift::protocol::TProtocol> iprot, std::shared_ptr< ::apache::thrift::protocol::TProtocol> oprot, std::shared_ptr<::apache::thrift::async::TConcurrentClientSyncInfo> sync) :     ::Hypertable::ThriftGen::ClientServiceConcurrentClient(iprot, oprot, sync) {}
  std::shared_ptr< ::apache::thrift::protocol::TProtocol> getInputProtocol() {
    return piprot_;
  }
  std::shared_ptr< ::apache::thrift::protocol::TProtocol> getOutputProtocol() {
    return poprot_;
  }
  void hql_exec(HqlResult& _return, const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered);
  int32_t send_hql_exec(const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered);
  void recv_hql_exec(HqlResult& _return, const int32_t seqid);
  void hql_query(HqlResult& _return, const int64_t ns, const std::string& command);
  int32_t send_hql_query(const int64_t ns, const std::string& command);
  void recv_hql_query(HqlResult& _return, const int32_t seqid);
  void hql_exec_as_arrays(HqlResultAsArrays& _return, const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered);
  int32_t send_hql_exec_as_arrays(const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered);
  void recv_hql_exec_as_arrays(HqlResultAsArrays& _return, const int32_t seqid);
  void hql_exec2(HqlResult2& _return, const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered);
  int32_t send_hql_exec2(const int64_t ns, const std::string& command, const bool noflush, const bool unbuffered);
  void recv_hql_exec2(HqlResult2& _return, const int32_t seqid);
  void hql_query_as_arrays(HqlResultAsArrays& _return, const int64_t ns, const std::string& command);
  int32_t send_hql_query_as_arrays(const int64_t ns, const std::string& command);
  void recv_hql_query_as_arrays(HqlResultAsArrays& _return, const int32_t seqid);
  void hql_query2(HqlResult2& _return, const int64_t ns, const std::string& command);
  int32_t send_hql_query2(const int64_t ns, const std::string& command);
  void recv_hql_query2(HqlResult2& _return, const int32_t seqid);
};

#ifdef _MSC_VER
  #pragma warning( pop )
#endif

}} // namespace

#endif
