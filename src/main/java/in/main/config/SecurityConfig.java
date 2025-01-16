package in.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF protection for APIs
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/api/createHost").permitAll()  // Allow public access to createHost
                .anyRequest().authenticated()  // Require authentication for other requests
            )
            .formLogin()  // Default form login enabled  deperecated
            .permitAll()  // Allow everyone to access the login page
            .and()
            .logout()  // Default logout enabled deperecated
            .permitAll();  // Allow everyone to access logout

        return http.build();
    }

}
