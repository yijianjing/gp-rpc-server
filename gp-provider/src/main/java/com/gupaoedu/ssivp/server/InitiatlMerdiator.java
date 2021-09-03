package com.gupaoedu.ssivp.server;

import com.gupaoedu.ssivp.server.annotion.GpRemoteService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class InitiatlMerdiator implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(GpRemoteService.class)){
            Method[] declaredMethods = bean.getClass().getDeclaredMethods();
            for(Method method : declaredMethods){
                String key = bean.getClass().getInterfaces()[0].getName()+"."+method.getName();
                BeanMethod beanMethod = new BeanMethod();
                beanMethod.setBean(bean);
                beanMethod.setMethod(method);
                Mediator.map.put(key,beanMethod);

            }
        }
        return bean;
    }
}
