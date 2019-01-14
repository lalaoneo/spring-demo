 ## spring bean 初始化顺序

- 构造beanFactoryPostProcessor

- 调用构造beanFactoryPostProcessor.postProcessorBeanFactory方法

- 构造beanPostProcessor

- 构造instantiationAwareBeanPostProcessor

- 调用instantiationAwareBeanPostProcessor.postProcessorBeforeInstantiation方法

- 构造Person类

- 调用instantiationAwareBeanPostProcessor.postProcessPropertyValues方法

- 设置Person的属性

- 调用BeanNameAware.setBeanName方法;

- 调用BeanFactoryAware.setBeanFactory方法

- 调用BeanPostProcessor.postProcessBeforeInitialization方法,进行初始化之前的操作

- 调用InitializingBean.afterPropertiesSet方法,设置完属性后,进行操作

- 调用自定义的初始化方法

- 调用BeanPostProcessor.postProcessAfterInitialization方法,初始化完成后进行的操作;

- 调用InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInitialization方法,实例化完后的一些操作


## spring bean 销毁顺序

- 调用DisposableBean.destroy方法,进行销毁操作

- 调用自定义的销毁方法进行操作;