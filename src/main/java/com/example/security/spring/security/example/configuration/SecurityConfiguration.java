package com.example.security.spring.security.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> {
            // + All the endpoints should be protected.
            requests.requestMatchers("/user")
                    .hasAnyRole("USER","ADMIN")
                    .requestMatchers("/admin")
                    .hasAnyRole("ADMIN")
                    .requestMatchers("/home")
                    .permitAll()
                    .anyRequest().authenticated();
        }).formLogin(form -> {
            // + Permit everyone to view the login page.
            form.permitAll();
        }).logout(logout -> {
            // + Permit everyone to view the logout page.
            logout.permitAll();
        });
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = users
                .username("admin")
                .password("admin_password")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
}
