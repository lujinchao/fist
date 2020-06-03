package com.baidu.personal.fist.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *定义服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: sync_msg.proto")
public final class SyncServiceGrpc {

  private SyncServiceGrpc() {}

  public static final String SERVICE_NAME = "com.baidu.personal.fist.grpc.SyncService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<SyncMsg.SyncRequest,
      SyncMsg.SyncResponse> getProcessFileCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processFileCreate",
      requestType = SyncMsg.SyncRequest.class,
      responseType = SyncMsg.SyncResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SyncMsg.SyncRequest,
      SyncMsg.SyncResponse> getProcessFileCreateMethod() {
    io.grpc.MethodDescriptor<SyncMsg.SyncRequest, SyncMsg.SyncResponse> getProcessFileCreateMethod;
    if ((getProcessFileCreateMethod = SyncServiceGrpc.getProcessFileCreateMethod) == null) {
      synchronized (SyncServiceGrpc.class) {
        if ((getProcessFileCreateMethod = SyncServiceGrpc.getProcessFileCreateMethod) == null) {
          SyncServiceGrpc.getProcessFileCreateMethod = getProcessFileCreateMethod = 
              io.grpc.MethodDescriptor.<SyncMsg.SyncRequest, SyncMsg.SyncResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.baidu.personal.fist.grpc.SyncService", "processFileCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SyncMsg.SyncRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SyncMsg.SyncResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SyncServiceMethodDescriptorSupplier("processFileCreate"))
                  .build();
          }
        }
     }
     return getProcessFileCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SyncMsg.SyncRequest,
      SyncMsg.SyncResponse> getProcessFileModifyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processFileModify",
      requestType = SyncMsg.SyncRequest.class,
      responseType = SyncMsg.SyncResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SyncMsg.SyncRequest,
      SyncMsg.SyncResponse> getProcessFileModifyMethod() {
    io.grpc.MethodDescriptor<SyncMsg.SyncRequest, SyncMsg.SyncResponse> getProcessFileModifyMethod;
    if ((getProcessFileModifyMethod = SyncServiceGrpc.getProcessFileModifyMethod) == null) {
      synchronized (SyncServiceGrpc.class) {
        if ((getProcessFileModifyMethod = SyncServiceGrpc.getProcessFileModifyMethod) == null) {
          SyncServiceGrpc.getProcessFileModifyMethod = getProcessFileModifyMethod = 
              io.grpc.MethodDescriptor.<SyncMsg.SyncRequest, SyncMsg.SyncResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.baidu.personal.fist.grpc.SyncService", "processFileModify"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SyncMsg.SyncRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SyncMsg.SyncResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SyncServiceMethodDescriptorSupplier("processFileModify"))
                  .build();
          }
        }
     }
     return getProcessFileModifyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SyncMsg.SyncRequest,
      SyncMsg.SyncResponse> getProcessFileDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processFileDelete",
      requestType = SyncMsg.SyncRequest.class,
      responseType = SyncMsg.SyncResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SyncMsg.SyncRequest,
      SyncMsg.SyncResponse> getProcessFileDeleteMethod() {
    io.grpc.MethodDescriptor<SyncMsg.SyncRequest, SyncMsg.SyncResponse> getProcessFileDeleteMethod;
    if ((getProcessFileDeleteMethod = SyncServiceGrpc.getProcessFileDeleteMethod) == null) {
      synchronized (SyncServiceGrpc.class) {
        if ((getProcessFileDeleteMethod = SyncServiceGrpc.getProcessFileDeleteMethod) == null) {
          SyncServiceGrpc.getProcessFileDeleteMethod = getProcessFileDeleteMethod = 
              io.grpc.MethodDescriptor.<SyncMsg.SyncRequest, SyncMsg.SyncResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.baidu.personal.fist.grpc.SyncService", "processFileDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SyncMsg.SyncRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SyncMsg.SyncResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SyncServiceMethodDescriptorSupplier("processFileDelete"))
                  .build();
          }
        }
     }
     return getProcessFileDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SyncMsg.SyncRequest,
      SyncMsg.SyncResponse> getProcessDirectoryCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processDirectoryCreate",
      requestType = SyncMsg.SyncRequest.class,
      responseType = SyncMsg.SyncResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SyncMsg.SyncRequest,
      SyncMsg.SyncResponse> getProcessDirectoryCreateMethod() {
    io.grpc.MethodDescriptor<SyncMsg.SyncRequest, SyncMsg.SyncResponse> getProcessDirectoryCreateMethod;
    if ((getProcessDirectoryCreateMethod = SyncServiceGrpc.getProcessDirectoryCreateMethod) == null) {
      synchronized (SyncServiceGrpc.class) {
        if ((getProcessDirectoryCreateMethod = SyncServiceGrpc.getProcessDirectoryCreateMethod) == null) {
          SyncServiceGrpc.getProcessDirectoryCreateMethod = getProcessDirectoryCreateMethod = 
              io.grpc.MethodDescriptor.<SyncMsg.SyncRequest, SyncMsg.SyncResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.baidu.personal.fist.grpc.SyncService", "processDirectoryCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SyncMsg.SyncRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SyncMsg.SyncResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SyncServiceMethodDescriptorSupplier("processDirectoryCreate"))
                  .build();
          }
        }
     }
     return getProcessDirectoryCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SyncMsg.SyncRequest,
      SyncMsg.SyncResponse> getProcessDirectoryDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processDirectoryDelete",
      requestType = SyncMsg.SyncRequest.class,
      responseType = SyncMsg.SyncResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SyncMsg.SyncRequest,
      SyncMsg.SyncResponse> getProcessDirectoryDeleteMethod() {
    io.grpc.MethodDescriptor<SyncMsg.SyncRequest, SyncMsg.SyncResponse> getProcessDirectoryDeleteMethod;
    if ((getProcessDirectoryDeleteMethod = SyncServiceGrpc.getProcessDirectoryDeleteMethod) == null) {
      synchronized (SyncServiceGrpc.class) {
        if ((getProcessDirectoryDeleteMethod = SyncServiceGrpc.getProcessDirectoryDeleteMethod) == null) {
          SyncServiceGrpc.getProcessDirectoryDeleteMethod = getProcessDirectoryDeleteMethod = 
              io.grpc.MethodDescriptor.<SyncMsg.SyncRequest, SyncMsg.SyncResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.baidu.personal.fist.grpc.SyncService", "processDirectoryDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SyncMsg.SyncRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SyncMsg.SyncResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SyncServiceMethodDescriptorSupplier("processDirectoryDelete"))
                  .build();
          }
        }
     }
     return getProcessDirectoryDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SyncServiceStub newStub(io.grpc.Channel channel) {
    return new SyncServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SyncServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SyncServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SyncServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SyncServiceFutureStub(channel);
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static abstract class SyncServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void processFileCreate(SyncMsg.SyncRequest request,
                                  io.grpc.stub.StreamObserver<SyncMsg.SyncResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessFileCreateMethod(), responseObserver);
    }

    /**
     */
    public void processFileModify(SyncMsg.SyncRequest request,
                                  io.grpc.stub.StreamObserver<SyncMsg.SyncResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessFileModifyMethod(), responseObserver);
    }

    /**
     */
    public void processFileDelete(SyncMsg.SyncRequest request,
                                  io.grpc.stub.StreamObserver<SyncMsg.SyncResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessFileDeleteMethod(), responseObserver);
    }

    /**
     */
    public void processDirectoryCreate(SyncMsg.SyncRequest request,
                                       io.grpc.stub.StreamObserver<SyncMsg.SyncResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessDirectoryCreateMethod(), responseObserver);
    }

    /**
     */
    public void processDirectoryDelete(SyncMsg.SyncRequest request,
                                       io.grpc.stub.StreamObserver<SyncMsg.SyncResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessDirectoryDeleteMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProcessFileCreateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                SyncMsg.SyncRequest,
                SyncMsg.SyncResponse>(
                  this, METHODID_PROCESS_FILE_CREATE)))
          .addMethod(
            getProcessFileModifyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                SyncMsg.SyncRequest,
                SyncMsg.SyncResponse>(
                  this, METHODID_PROCESS_FILE_MODIFY)))
          .addMethod(
            getProcessFileDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                SyncMsg.SyncRequest,
                SyncMsg.SyncResponse>(
                  this, METHODID_PROCESS_FILE_DELETE)))
          .addMethod(
            getProcessDirectoryCreateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                SyncMsg.SyncRequest,
                SyncMsg.SyncResponse>(
                  this, METHODID_PROCESS_DIRECTORY_CREATE)))
          .addMethod(
            getProcessDirectoryDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                SyncMsg.SyncRequest,
                SyncMsg.SyncResponse>(
                  this, METHODID_PROCESS_DIRECTORY_DELETE)))
          .build();
    }
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static final class SyncServiceStub extends io.grpc.stub.AbstractStub<SyncServiceStub> {
    private SyncServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SyncServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SyncServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SyncServiceStub(channel, callOptions);
    }

    /**
     */
    public void processFileCreate(SyncMsg.SyncRequest request,
                                  io.grpc.stub.StreamObserver<SyncMsg.SyncResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessFileCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void processFileModify(SyncMsg.SyncRequest request,
                                  io.grpc.stub.StreamObserver<SyncMsg.SyncResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessFileModifyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void processFileDelete(SyncMsg.SyncRequest request,
                                  io.grpc.stub.StreamObserver<SyncMsg.SyncResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessFileDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void processDirectoryCreate(SyncMsg.SyncRequest request,
                                       io.grpc.stub.StreamObserver<SyncMsg.SyncResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessDirectoryCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void processDirectoryDelete(SyncMsg.SyncRequest request,
                                       io.grpc.stub.StreamObserver<SyncMsg.SyncResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessDirectoryDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static final class SyncServiceBlockingStub extends io.grpc.stub.AbstractStub<SyncServiceBlockingStub> {
    private SyncServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SyncServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SyncServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SyncServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public SyncMsg.SyncResponse processFileCreate(SyncMsg.SyncRequest request) {
      return blockingUnaryCall(
          getChannel(), getProcessFileCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public SyncMsg.SyncResponse processFileModify(SyncMsg.SyncRequest request) {
      return blockingUnaryCall(
          getChannel(), getProcessFileModifyMethod(), getCallOptions(), request);
    }

    /**
     */
    public SyncMsg.SyncResponse processFileDelete(SyncMsg.SyncRequest request) {
      return blockingUnaryCall(
          getChannel(), getProcessFileDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public SyncMsg.SyncResponse processDirectoryCreate(SyncMsg.SyncRequest request) {
      return blockingUnaryCall(
          getChannel(), getProcessDirectoryCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public SyncMsg.SyncResponse processDirectoryDelete(SyncMsg.SyncRequest request) {
      return blockingUnaryCall(
          getChannel(), getProcessDirectoryDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static final class SyncServiceFutureStub extends io.grpc.stub.AbstractStub<SyncServiceFutureStub> {
    private SyncServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SyncServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SyncServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SyncServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SyncMsg.SyncResponse> processFileCreate(
        SyncMsg.SyncRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProcessFileCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SyncMsg.SyncResponse> processFileModify(
        SyncMsg.SyncRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProcessFileModifyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SyncMsg.SyncResponse> processFileDelete(
        SyncMsg.SyncRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProcessFileDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SyncMsg.SyncResponse> processDirectoryCreate(
        SyncMsg.SyncRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProcessDirectoryCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SyncMsg.SyncResponse> processDirectoryDelete(
        SyncMsg.SyncRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProcessDirectoryDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_FILE_CREATE = 0;
  private static final int METHODID_PROCESS_FILE_MODIFY = 1;
  private static final int METHODID_PROCESS_FILE_DELETE = 2;
  private static final int METHODID_PROCESS_DIRECTORY_CREATE = 3;
  private static final int METHODID_PROCESS_DIRECTORY_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SyncServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SyncServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_FILE_CREATE:
          serviceImpl.processFileCreate((SyncMsg.SyncRequest) request,
              (io.grpc.stub.StreamObserver<SyncMsg.SyncResponse>) responseObserver);
          break;
        case METHODID_PROCESS_FILE_MODIFY:
          serviceImpl.processFileModify((SyncMsg.SyncRequest) request,
              (io.grpc.stub.StreamObserver<SyncMsg.SyncResponse>) responseObserver);
          break;
        case METHODID_PROCESS_FILE_DELETE:
          serviceImpl.processFileDelete((SyncMsg.SyncRequest) request,
              (io.grpc.stub.StreamObserver<SyncMsg.SyncResponse>) responseObserver);
          break;
        case METHODID_PROCESS_DIRECTORY_CREATE:
          serviceImpl.processDirectoryCreate((SyncMsg.SyncRequest) request,
              (io.grpc.stub.StreamObserver<SyncMsg.SyncResponse>) responseObserver);
          break;
        case METHODID_PROCESS_DIRECTORY_DELETE:
          serviceImpl.processDirectoryDelete((SyncMsg.SyncRequest) request,
              (io.grpc.stub.StreamObserver<SyncMsg.SyncResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SyncServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SyncServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return SyncMsg.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SyncService");
    }
  }

  private static final class SyncServiceFileDescriptorSupplier
      extends SyncServiceBaseDescriptorSupplier {
    SyncServiceFileDescriptorSupplier() {}
  }

  private static final class SyncServiceMethodDescriptorSupplier
      extends SyncServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SyncServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SyncServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SyncServiceFileDescriptorSupplier())
              .addMethod(getProcessFileCreateMethod())
              .addMethod(getProcessFileModifyMethod())
              .addMethod(getProcessFileDeleteMethod())
              .addMethod(getProcessDirectoryCreateMethod())
              .addMethod(getProcessDirectoryDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
