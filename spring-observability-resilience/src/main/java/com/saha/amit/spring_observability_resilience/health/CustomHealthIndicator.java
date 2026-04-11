package com.saha.amit.spring_observability_resilience.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * CUSTOM HEALTH INDICATOR:
 * Best Practice: Expose internal health checks (e.g., disk space, 
 * connectivity to legacy systems) via Actuator.
 */
@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean serviceUp = checkServiceStatus(); 
        if (serviceUp) {
            return Health.up()
                    .withDetail("ExternalAPI", "Available")
                    .withDetail("Latency", "45ms")
                    .build();
        }
        return Health.down()
                .withDetail("ExternalAPI", "Timed Out")
                .build();
    }

    private boolean checkServiceStatus() {
        // Dummy logic: return true/false based on real status
        return true; 
    }
}
