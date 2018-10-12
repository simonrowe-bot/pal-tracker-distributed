package io.pivotal.pal.tracker.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@EnableWebSecurity
@EnableResourceServer
@EnableEurekaClient
@SpringBootApplication
@ComponentScan({
        "io.pivotal.pal.tracker.accounts",
        "io.pivotal.pal.tracker.restsupport",
        "io.pivotal.pal.tracker.projects",
        "io.pivotal.pal.tracker.users",
        "io.pivotal.pal.tracker.registration"
})
@RestController
public class App {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/health")
    public Map<String, Object> health() {
        HashMap<String, Object> healthMap = new HashMap<>();
        healthMap.put("hystrix", Health.status(Status.UP).build());
        healthMap.put("status", "UP");
        return healthMap;
    }
}
