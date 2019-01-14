package com.lori.springdemo.bean.lifecycle;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

@Component
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;

    private String address;

    private int phone;

    private BeanFactory beanFactory;

    private String beanName;

    public Person(){
        System.out.println("[lori]【构造器】调用Person的构造器实例化");
    }

    /**
     * BeanFactoryAware重载的方法
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out .println("[lori]【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    /**
     * BeanNameAware重载的方法
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println("[lori]【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = s;
    }

    /**
     * InitializingBean重载的方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[lori]【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    /**
     * DisposableBean重载的方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("[lori]【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    public void myInit(){
        System.out.println("[lori]【init-method】调用的init-method属性指定的初始化方法");
    }

    public void myDestory(){
        System.out.println("[lori]【destroy-method】调用的destroy-method属性指定的初始化方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("[lori]【注入属性】注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("[lori]【注入属性】注入属性address");
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        System.out.println("[lori]【注入属性】注入属性phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
