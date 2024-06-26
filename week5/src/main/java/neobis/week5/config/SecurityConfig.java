package neobis.week5.config;
import neobis.week5.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity

public class SecurityConfig  {
    private  JwtAuthFilter jwtAuthFilter;
    private final UserRepository userRepo;

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return (UserDetails) userRepo.findByName(username).orElseThrow(() -> new UsernameNotFoundException("invalid credentials"));
            }
        };
    }

    public SecurityConfig(JwtAuthFilter jwtAuthFilter, UserRepository userRepo) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.userRepo = userRepo;
    }


@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/users/add","/api/v1/users/login").permitAll()
                        .requestMatchers("/api/v1/products/**","/api/v1/orders/**","/api/v1/users/**","/swagger-ui.html/**","v2/api-docs/**").authenticated())
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .authenticationProvider(authenticationProvider()).addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

               return  http.build();
}

@Bean
    public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService());
    provider.setPasswordEncoder(encoder());
    return provider;
}
    @Bean
    public PasswordEncoder encoder() {

        return new BCryptPasswordEncoder();
    }
@Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
    }

