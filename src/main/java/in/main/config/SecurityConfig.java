package in.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.main.repo.HostRepo;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private HostRepo hostRepo;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Secure password encoder
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> hostRepo.findByUserName(username)
            .map(user -> User.withUsername(user.getUserName())
                             .password(user.getPassword())
                             .roles("USER")  // Or derive roles from the user object
                             .build())
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/test/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form.permitAll())
            .logout(logout -> logout.permitAll());

        return http.build();
    }
}
