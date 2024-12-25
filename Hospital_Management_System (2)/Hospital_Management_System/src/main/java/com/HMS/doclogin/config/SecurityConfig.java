package com.HMS.doclogin.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.cors.CorsConfigurationSource;

// import java.util.Arrays;


//@EnableWebSecurity
public class SecurityConfig {

    //@Bean
    //public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //    http
    //        .csrf().disable()
    //        .cors() // Enable CORS
    //        .and()
    //        .authorizeHttpRequests()
    //            .requestMatchers("/api/v2/register", "/api/v2/authenticate").permitAll()
    //            .anyRequest().authenticated()
    //        .and()
    //        .httpBasic(); // or configure JWT if required

    //    return http.build();
    //}

    //@Bean
    //public PasswordEncoder passwordEncoder() {
    //    return new BCryptPasswordEncoder();
    //}

    //@Bean
    //public CorsConfigurationSource corsConfigurationSource() {
    //    CorsConfiguration configuration = new CorsConfiguration();
    //    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Allow Angular app
    //    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allowed HTTP methods
    //    configuration.setAllowedHeaders(Arrays.asList("*")); // Allow all headers
    //    configuration.setAllowCredentials(true); // Allow credentials
    //    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //    source.registerCorsConfiguration("/**", configuration); // Apply CORS configuration to all endpoints
    //    return source;
    //}
}