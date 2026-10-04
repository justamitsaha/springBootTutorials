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

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CircularDependencyRunner.class, args);

        System.out.println("--------------------------------------------------");
        System.out.println("Circular Dependency Demo");
        ComponentA a = context.getBean(ComponentA.class);
        a.talk();
        System.out.println("--------------------------------------------------");
    }


}
/*Important Notes:
1. Circular Dependency: ComponentA depends on ComponentB, and ComponentB depends on ComponentA. This creates a circular dependency that Spring cannot resolve by default.
2. @Lazy: By annotating the ComponentB parameter in ComponentA's constructor with @Lazy, we tell Spring to inject a proxy that will only initialize ComponentB when it's actually needed (when talk() is called). This allows Spring to break the circular dependency and successfully create both beans.
3. Best Practice: While @Lazy can resolve circular dependencies, it's generally better to refactor your design to avoid them in the first place. Circular dependencies can make your code harder to understand and maintain. Consider using interfaces, event-driven design, or other patterns to decouple your components if you find yourself needing circular dependencies.


Resolving a circular dependency depends on whether you want to maintain constructor injection or switch to setter injection. Both methods effectively break the cycle by delaying the full initialization of one bean

Recommended Approaches
@Lazy Annotation (Best for Constructor Injection): Use this if you want to keep using constructor injection. By annotating the dependent bean in the constructor, Spring injects a proxy instead of the actual bean. The real bean is only initialized when a method is first called on that proxy.
Setter Injection: This is a standard alternative where Spring first creates the bean using its default constructor and then injects dependencies afterward via setter methods. This avoids the "deadlock" of two beans waiting for each other to be fully constructed before either can exist
 */
