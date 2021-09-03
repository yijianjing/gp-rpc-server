package com.gupaoedu.ssivp.server;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

//@Component
public class ReferenceINvokeProxy implements BeanPostProcessor {

    @Autowired
    RemoteInvocationHandler remoteInvocationHandler;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for(Field filed:declaredFields){
            if(filed.isAnnotationPresent(GpReference.class)){
                filed.setAccessible(true);

                Object proxy = Proxy.newProxyInstance(filed.getType().getClassLoader(), new Class<?>[]{filed.getType()}, remoteInvocationHandler);

                try {
                    filed.set(bean,proxy);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}
