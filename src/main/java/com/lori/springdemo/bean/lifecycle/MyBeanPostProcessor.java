package com.lori.springdemo.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 增加打印日志标志,只打印一次
    private AtomicBoolean myBeanPostProcessorLogFlag = new AtomicBoolean(true);

    private AtomicBoolean postProcessBeforeInitializationLogFlag = new AtomicBoolean(true);

    private AtomicBoolean postProcessAfterInitializationLogFlag = new AtomicBoolean(true);

    public MyBeanPostProcessor(){
        super();
        if (myBeanPostProcessorLogFlag.getAndSet(false)){
            System.out.println("[lori：step_3] 这是BeanPostProcessor实现类构造器！！");
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (postProcessBeforeInitializationLogFlag.getAndSet(false)){
            System.out.println("[lori：step_8] BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (postProcessAfterInitializationLogFlag.getAndSet(false)){
            System.out .println("[lori：step_9] BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        }
        return bean;
    }
}
