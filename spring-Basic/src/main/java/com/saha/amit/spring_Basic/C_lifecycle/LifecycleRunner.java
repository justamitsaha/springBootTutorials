package com.saha.amit.spring_Basic.C_lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * RUNNER: Bean Scopes, Lifecycle Hooks, and Aware Interfaces.
 */
@SpringBootApplication
public class LifecycleRunner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LifecycleRunner.class, args);
        
        System.out.println("--------------------------------------------------");
        System.out.println("1. Bean Scopes (Singleton vs Prototype)");
        // Singleton: Same instance returned twice
        System.out.println("Singleton Bean 1: " + context.getBean(SingletonBean.class));
        System.out.println("Singleton Bean 2: " + context.getBean(SingletonBean.class));

        // Prototype: Different instance every time
        System.out.println("Prototype Bean 1: " + context.getBean(PrototypeBean.class));
        System.out.println("Prototype Bean 2: " + context.getBean(PrototypeBean.class));

        System.out.println("--------------------------------------------------");
        System.out.println("2. Lazy Loading (@Lazy)");
        System.out.println("Lazy bean hasn't been created yet. Requesting it now...");
        Object lazyBean = context.getBean(LazyBean.class);
        System.out.println("Lazy Bean is now: " + lazyBean);

        System.out.println("--------------------------------------------------");
        System.out.println("3. Aware Interfaces (How beans see the container)");
        context.getBean(AwareBean.class);

        System.out.println("--------------------------------------------------");
        System.out.println("Spring Boot Application up and running.");
        System.out.println("--------------------------------------------------");
    }

    /**
     * SINGLETON SCOPE (Default)
     * Best Practice: Use for stateless services (most of your Spring beans).
     */
    @Component
    static class SingletonBean {
        public SingletonBean() { System.out.println("Singleton Bean created!"); }
    }

    /**
     * PROTOTYPE SCOPE
     * Best Practice: Use for stateful objects that are NOT thread-safe.
     */
    @Component
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    static class PrototypeBean {
        public PrototypeBean() { System.out.println("Prototype Bean created!"); }
    }

    /**
     * LAZY INITIALIZATION
     * Best Practice: Use sparingly; eager loading at startup is usually better 
     * to catch configuration issues early.
     */
    @Component
    @Lazy
    static class LazyBean {
        public LazyBean() { System.out.println("Lazy Bean created (only now!)"); }
    }

    /**
     * LIFECYCLE HOOKS
     * Best Practice: Use @PostConstruct for setup logic that needs dependencies,
     * and @PreDestroy for closing resources.
     */
    @Component
    static class LifecycleBean {
        @PostConstruct
        public void init() { System.out.println("Lifecycle: Initializing after DI..."); }

        @PreDestroy
        public void cleanup() { System.out.println("Lifecycle: Cleaning up before destroy..."); }
    }

    /**
     * AWARE INTERFACES
     * Best Practice: Only use when you absolutely need to interact with the framework's 
     * infrastructure (e.g., manually looking up beans from ApplicationContext).
     */
    @Component
    static class AwareBean implements BeanNameAware, ApplicationContextAware {
        @Override
        public void setBeanName(String name) {
            System.out.println("Aware: My bean name is: " + name);
        }

        @Override
        public void setApplicationContext(ApplicationContext context) {
            System.out.println("Aware: Access to context ID: " + context.getId());
        }
    }
}
