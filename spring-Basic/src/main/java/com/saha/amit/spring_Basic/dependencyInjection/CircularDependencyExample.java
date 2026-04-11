package com.saha.amit.spring_Basic.dependencyInjection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * CIRCULAR DEPENDENCY: Component A needs B, and B needs A.
 * In Spring Boot 2.6+, this will cause a BeanCurrentlyInCreationException.
 * The best fix is to use constructor injection to prevent this at design time.
 * Or use @Lazy to break the cycle.
 */
@Component
class ComponentA {
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
class ComponentB {
    private final ComponentA componentA;

    public ComponentB(ComponentA componentA) {
        this.componentA = componentA;
    }

    public void talk() {
        System.out.println("B talking back to A...");
    }
}
