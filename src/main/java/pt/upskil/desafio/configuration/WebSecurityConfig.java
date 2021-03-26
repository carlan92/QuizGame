package pt.upskil.desafio.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll();
                /*.antMatchers("/*.css", "/fonts/**", "/imagens/**", "*.html" , "*.ico").permitAll()
                .anyRequest().authenticated()

                // Login
                .and()
                .formLogin()
                .loginPage("/public/login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/public/login?error=true")

                // Logout
                .and()
                .logout()
                .logoutUrl("/logout")       // Este método faz logout do user
                .logoutSuccessUrl("/public/main")
                .deleteCookies("JSESSIONID");*/
    }
}
