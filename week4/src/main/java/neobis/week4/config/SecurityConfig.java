package neobis.week4.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error=true");
//
//        http.logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//                .clearAuthentication(true)
//                .invalidateHttpSession(true);
//
//
//        http.authorizeRequests()
//                .antMatchers("/api/v1/registration", "/api/v1/orders")
//                .authenticated();
//
//        http.authorizeRequests()
//                .anyRequest()
//                .permitAll();
//
//
//
//
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        String fetchUsersQuery = "SELECT email, password, enabled FROM customers WHERE email = ?";
//        String fetchRolesQuery = "SELECT email, role FROM customers WHERE email = ?";
//        auth.jdbcAuthentication()
////                .usersByUsernameQuery(fetchUsersQuery)
////                .authoritiesByUsernameQuery(fetchRolesQuery)
//                .dataSource(dataSource);
// }
    }

