package io.pivotal.pal.tracker.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.TimeZone;


@EnableEurekaClient
@SpringBootApplication
@ComponentScan({
    "io.pivotal.pal.tracker.accounts",
    "io.pivotal.pal.tracker.restsupport",
    "io.pivotal.pal.tracker.projects",
    "io.pivotal.pal.tracker.users"
})
public class App  extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(App.class, args);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**");
    }
}
