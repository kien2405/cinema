package com.example.ThucTapLTS.config;

import com.example.ThucTapLTS.filter.JwtFilter;
import com.example.ThucTapLTS.provider.CustomAuthenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //  Khai báo chuẩn mã hóa Bcrypt và lưu trữ trên IOC
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private CustomAuthenProvider authenticationProvider;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider)
                .build();
    }

    //  Đây là filter dùng để custom rule liên quan tới link hoặc cấu hình security
    //  Java 8,11 : antMatchers
    //  Java 17~ : requestAntmatchers
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors().and().csrf().disable()
                // Tắt cấu hình liên quan tới tấn công CSRF
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //  Khai báo không sử dụng session trong project
                .and()
                .authorizeHttpRequests()   // Quy định lại các role liên quan tới chứng thực cho link được gọi
                .requestMatchers("/signin", "/signup", "/user/forgetPassword", "/user/activeUser", "/mail/**", "/payment").permitAll() // Cho phép tất cả mọi người truy cập các URL này mà không cần chứng thực
                .requestMatchers("/cinema/crud/**").hasRole("ADMIN")
                .requestMatchers("/food/get/foodSalesLast7Days").hasRole("ADMIN")
                .requestMatchers("/cinema/get/cinemaSalesStatistics").hasRole("ADMIN")
                .requestMatchers("/room/crud/**").hasRole("ADMIN")
                .requestMatchers("/seat/crud/**").hasRole("ADMIN")
                .requestMatchers("/food/crud/**").hasRole("ADMIN")
                .requestMatchers("/movie/crud/**").hasRole("ADMIN")
                .requestMatchers("/schedule/crud/**").hasRole("ADMIN")
                .requestMatchers("/ticket/crud/**").hasRole("USER")
                .requestMatchers("/bill/crud/**").hasRole("USER")
                .requestMatchers("/api/user/UpdateUser").hasRole("USER")
                .requestMatchers("/movie/get/**", "/schedule/get/**").hasAnyRole("USER", "ADMIN") // Cho phép người dùng có quyền USER hoặc ADMIN truy cập các URL bắt đầu bằng /user/
                .anyRequest().authenticated() // Tất cả các request còn lại đều phải được chứng thực
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
