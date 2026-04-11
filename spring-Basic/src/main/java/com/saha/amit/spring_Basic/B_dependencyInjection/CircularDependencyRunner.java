package com.saha.amit.spring_Basic.B_dependencyInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * RUNNER: Circular Dependency Demonstration and Resolution.
 */
@SpringBootApplication
public class CircularDependencyRunner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CircularDependencyRunner.class, args);
        
        System.out.println("--------------------------------------------------");
        System.out.println("Circular Dependency Demo");
        ComponentA a = context.getBean(ComponentA.class);
        a.talk();
        System.out.println("--------------------------------------------------");
    }

    /**
     * CIRCULAR DEPENDENCY: Best Practice: Avoid circular dependencies by refactoring 
     * your design. If impossible, use @Lazy to break the cycle.
     */
    @Component
    static class ComponentA {
        private final ComponentB componentB;

        public ComponentA(@Lazy ComponentB componentB) {
            this.componentB = componentB;
        }

        public void talk() {
            System.out.println("A talking to B...");
            componentB.talk();
        }
    }

    @Component
    static class ComponentB {
        private final ComponentA componentA;

        public ComponentB(ComponentA componentA) {
            this.componentA = componentA;
        }

        public void talk() {
            System.out.println("B talking back to A...");
        }
    }
}
