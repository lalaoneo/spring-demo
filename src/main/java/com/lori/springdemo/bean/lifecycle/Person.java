package com.lori.springdemo.bean.lifecycle;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;

    private String address;

    private int phone;

    private BeanFactory beanFactory;

    private String beanName;

    public Person(){
        System.out.println("[lori：step_11]【构造器】调用Person的构造器实例化");
    }

    /**
     * BeanFactoryAware重载的方法
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out .println("[lori：step_16]【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    /**
     * BeanNameAware重载的方法
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println("[lori：step_15]【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = s;
    }

    /**
     * InitializingBean重载的方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[lori：step_18]【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    /**
     * DisposableBean重载的方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("[lori：step_19]【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    // 初始化完bean后，执行指定的初始化方法 相当于xml的init-method
    @PostConstruct
    public void myInit(){
        System.out.println("[lori：step_17]【init-method】调用的init-method属性指定的初始化方法");
    }

    // 相当于xml的destory-method
    @PreDestroy
    public void myDestory(){
        System.out.println("[lori：step_18]【destroy-method】调用的destroy-method属性指定的初始化方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("[lori：step_12]【注入属性】注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("[lori：step_13]【注入属性】注入属性address");
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        System.out.println("[lori：step_14]【注入属性】注入属性phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
