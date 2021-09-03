package com.gupaoedu.ssivp.server;

import java.io.Serializable;

public class RpcRequest implements Serializable {
    private static final long serialVersionUID = 9193062684059635565L;

    private String className;// 类名称
    private String methodName;// 方法名称
    private Object[] args;// 参数
    private Class[] types;// 参数类型

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
