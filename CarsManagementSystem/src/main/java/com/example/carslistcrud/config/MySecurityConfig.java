package com.example.carslistcrud.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration //аннотация
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override //перезапись
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll() //разрешить всем
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //путь к страничке логина
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/login?error=true")
                .permitAll().and()
                .logout().permitAll();

    }

    @Bean//аннотация
    public UserDetailsService userDetailsService() {
        return username -> {
            return User.builder()
                    .username("admin")
                    .password("admin")
                    .roles("ADMIN")
                    .passwordEncoder(passwordEncoder()::encode)
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() { //зашифровывает пароль
        return new PasswordEncoder() {
            @Override //метод для шифровки
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override //метод для проверки пароля
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.equals(encodedPassword);
            }
        };
    }


}
