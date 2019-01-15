package com.lori.springdemo.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    // 增加打印日志标志,只打印一次
    private AtomicBoolean myBeanFactoryPostProcessorLogFlag = new AtomicBoolean(true);

    private AtomicBoolean postProcessBeanFactoryLogFlag = new AtomicBoolean(true);

    public MyBeanFactoryPostProcessor(){
        super();
        if (myBeanFactoryPostProcessorLogFlag.getAndSet(false)){
            System.out.println("[lori：step_1] 这是BeanFactoryPostProcessor实现类构造器！！");
        }
    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        if (postProcessBeanFactoryLogFlag.getAndSet(false)){
            System.out.println("[lori：step_2] BeanFactoryPostProcessor调用postProcessBeanFactory方法");
        }
        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("person");
        bd.getPropertyValues().addPropertyValue("name","神探");
        bd.getPropertyValues().addPropertyValue("address","地球");
        bd.getPropertyValues().addPropertyValue("phone","110");

    }
}
