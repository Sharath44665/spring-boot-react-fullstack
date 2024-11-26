package com.sharath.car_database.config;

import com.sharath.car_database.AuthEntryPoint;
import com.sharath.car_database.AuthenticationFilter;
import com.sharath.car_database.service.UserDetailsServiceImpl;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationFilter authenticationFilter;
    private final AuthEntryPoint exceptionHandler;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService, AuthenticationFilter authenticationFilter, AuthEntryPoint exceptionHandler) {
        this.userDetailsService = userDetailsService;
        this.authenticationFilter = authenticationFilter;
		this.exceptionHandler = exceptionHandler;
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

// following code is for in memory authentication
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder().encode("password") )
//                .roles("USER").build();
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf( (csrf) -> {
            csrf.disable();

        })
        .cors(withDefaults())
                .sessionManagement((sessionManagement) -> {sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);})
                .authorizeHttpRequests((authorizeHttpReq) -> authorizeHttpReq.requestMatchers(HttpMethod.POST, "/login").permitAll().anyRequest().authenticated())
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling((exeptionHandling) -> exeptionHandling.authenticationEntryPoint(exceptionHandler));
        return http.build();

    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	CorsConfiguration config = new CorsConfiguration();
    	
    	config.setAllowedOrigins(Arrays.asList("*"));
    	
    	// only localhost:3000 is allowed
//    	config.setAllowedOrigins(Arrays.asList ("http://localhost:3000"));
    	config.setAllowedMethods(Arrays.asList("*"));
    	config.setAllowedHeaders(Arrays.asList("*"));
    	config.setAllowCredentials(false);
    	config.applyPermitDefaultValues();
    	
    	source.registerCorsConfiguration("/**", config);
    	return (CorsConfigurationSource) source;
    	
    }

}
