package com.saha.amit.spring_Basic.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * SINGLETON SCOPE: One instance for the entire container (default).
 */
@Component
class SingletonBean {
    public SingletonBean() {
        System.out.println("Singleton Bean created!");
    }
}

/**
 * PROTOTYPE SCOPE: A new instance created every time it's requested.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeBean {
    public PrototypeBean() {
        System.out.println("Prototype Bean created!");
    }
}

/**
 * BEAN LIFECYCLE HOOKS: PostConstruct and PreDestroy.
 */
@Component
class LifecycleBean {
    public LifecycleBean() {
        System.out.println("Lifecycle Bean instantiated.");
    }

    @PostConstruct
    public void init() {
        System.out.println("Lifecycle Bean initialized (PostConstruct).");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Lifecycle Bean cleaning up before destroy (PreDestroy).");
    }
}
