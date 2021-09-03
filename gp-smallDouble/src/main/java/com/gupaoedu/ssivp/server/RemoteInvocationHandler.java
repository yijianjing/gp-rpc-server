package com.gupaoedu.ssivp.server;

import com.gupaoedu.ssivp.server.RpcRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//@Component
public class RemoteInvocationHandler implements InvocationHandler {

    @Value("${gp.host}")
    private String host;
    @Value("${gp.port}")
    private int port;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcNetTransprot rpcNetTransport = new RpcNetTransprot(host, port);
        // 封装数据传输给服务端反射调用
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setArgs(args);
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        return rpcNetTransport.send(rpcRequest);
    }
}
