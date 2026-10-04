package com.saha.amit.spring_aop_internals.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BEST PRACTICE: Use BeanPostProcessor to add custom logic to EVERY bean 
 * during the initialization phase.
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // System.out.println("[Internals] Before Initialization: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.contains("Service")) {
            System.out.println("[Internals] Service Bean Initialized: " + beanName);
        }
        return bean;
    }
}
