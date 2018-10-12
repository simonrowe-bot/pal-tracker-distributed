package io.pivotal.pal.tracker.registration;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ActuatorSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/health").httpBasic().and().authorizeRequests().anyRequest().authenticated()
                .and().antMatcher("/health").httpBasic().and().authorizeRequests().anyRequest().authenticated()
                .and().antMatcher("/actuator/**").httpBasic().and().authorizeRequests().anyRequest().authenticated()
        ;
    }
}
