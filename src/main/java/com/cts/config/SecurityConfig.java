/**
 * 
 */
package com.cts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.cts.services.MyUserDetailsService;

/**
 * @author HP
 *
 */
@Configuration
//@Profile("prod")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailsService userDetailService;
	
	
	/*
	 * @Bean public SecurityWebFilterChain securityWebFilterChain(
	 * ServerHttpSecurity http) { return http.authorizeExchange()
	 * .pathMatchers("/actuator/**").permitAll() .anyExchange().authenticated()
	 * .and().build(); }
	 */
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        
//                .csrf().disabl
		//to avoid CSRF Cross site Request Forgery Valunerabiity..
		//It will generate token once user us authenticated and send it to browser response header!!
		//.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		http.csrf().disable().authorizeRequests() 
                .antMatchers("/v1").hasRole("MANAGER")
                .antMatchers("/v1").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Meraj")
                .password("{noop}12345678")
                .roles("MANAGER")
                .and()
                .withUser("Harish")
                .password("{noop}87654321")
                .roles("USER");
//    	System.out.println("#####################Authentication the user######################################");
//    	auth.authenticationProvider(daoAuthenticationProvider(passwordEncoder(),userDetailService));
    }
    
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder, UserDetailsService userDetailService) {
//    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
//    	daoAuthenticationProvider.setUserDetailsService(userDetailService);
//		return daoAuthenticationProvider;
//    }

}
