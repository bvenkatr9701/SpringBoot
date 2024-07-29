package com.employee.organization.config;



import org.springframework.beans.factory.annotation.Value;
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
public class SecurityConfig {
	
	@Value("${spring.security.user.name}")
	private String userName;
	@Value("${spring.security.user.password}")
	private String password;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity.csrf(crsf -> crsf.disable())
	       
	                .authorizeHttpRequests(auth ->
	                        auth
	                                .requestMatchers("/emp","/department")
	                                
	                                .permitAll().anyRequest()
	                                .authenticated()).httpBasic();     
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
            .username(userName)
            .password("{noop}"+password)
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
