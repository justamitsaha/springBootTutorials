package com.saha.amit.spring_Basic.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * LAZY BEAN: Not initialized at startup.
 * Created only when requested from the context.
 */
@Component
@Lazy
class LazyBean {
    public LazyBean() {
        System.out.println("Lazy Bean created (only now!)");
    }
}

/**
 * AWARE INTERFACES: Allow a bean to interact with the container.
 */
@Component
class AwareBean implements BeanNameAware, ApplicationContextAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("AwareBean's name in context is: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        System.out.println("AwareBean has access to ApplicationContext: " + context.getId());
    }
}
