package com.lori.springdemo.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    // 增加打印日志标志,只打印一次
    private AtomicBoolean beanPostProcessorLogFlag = new AtomicBoolean(true);

    private AtomicBoolean postProcessBeforeInstantiationLogFlag = new AtomicBoolean(true);

    private AtomicBoolean postProcessAfterInitializationLogFlag = new AtomicBoolean(true);

    private AtomicBoolean postProcessPropertyValuesLogFlag = new AtomicBoolean(true);

    public MyInstantiationAwareBeanPostProcessor(){
        super();
        if (beanPostProcessorLogFlag.getAndSet(false)){
            System.out.println("[lori：step_4] 这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
        }
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (postProcessBeforeInstantiationLogFlag.getAndSet(false)){
            System.out.println("[lori：step_5] InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (postProcessAfterInitializationLogFlag.getAndSet(false)){
            System.out.println("[lori：step_10] InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法");
        }
        return bean;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (postProcessPropertyValuesLogFlag.getAndSet(false)){
            System.out.println("[lori：step_7] InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
        }
        return pvs;
    }
}
