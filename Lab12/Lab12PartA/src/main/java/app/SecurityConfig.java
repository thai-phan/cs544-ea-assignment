package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails bob = User.builder()
        .username("bob")
        .password(passwordEncoder().encode("password"))
        .roles("EMPLOYEE") // Spring adds "ROLE_" prefix
        .authorities("DEPT_SALES")
        .build();

    UserDetails mary = User.builder()
        .username("mary")
        .password(passwordEncoder().encode("password"))
        .roles("EMPLOYEE")
        .authorities("DEPT_FINANCE")
        .build();

    return new InMemoryUserDetailsManager(bob, mary);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests( authConfig -> {
          authConfig
              .requestMatchers("/shop").permitAll()
              .requestMatchers("/employee").hasRole("EMPLOYEE")
              .requestMatchers("/orders").hasRole("EMPLOYEE")
              .requestMatchers("/payments").hasAuthority("DEPT_FINANCE");
        })
        .httpBasic(Customizer.withDefaults());
    return http.build();
  }
}
