package com.spaghettiteam.hotelapi.config.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final RequestMatcher PUBLIC_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher("/api/")
    );
    private static final RequestMatcher PROTECTED_URLS =
            new AndRequestMatcher(new AntPathRequestMatcher("/api/logged"));

    private static final RequestMatcher ADMIN_URLS = new OrRequestMatcher(new AntPathRequestMatcher("api/admin"));

    @Autowired
    @Qualifier("ownProvider")
    TokenAuthenticationProvider provider;

    SecurityConfig(final TokenAuthenticationProvider provider) {
        super();
        this.provider = provider;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(provider);
    }

    @Override
    public void configure(final WebSecurity web) {
        web.ignoring().requestMatchers(PUBLIC_URLS);
    }

//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http
//                .sessionManagement()
//                .sessionCreationPolicy(STATELESS)
//                .and()
//                .exceptionHandling()
//                // this entry point handles when you request a protected page and you are not yet
//                // authenticated
//                .defaultAuthenticationEntryPointFor(forbiddenEntryPoint(), PROTECTED_URLS)
//                .and()
//                .authenticationProvider(provider)
//                .addFilterBefore(restAuthenticationFilter(), AnonymousAuthenticationFilter.class)
//                .authorizeRequests()
//                .requestMatchers(PROTECTED_URLS)
//                .authenticated()
//                .and()
//                .authorizeRequests()
//                .requestMatchers(PUBLIC_URLS)
//                .permitAll()
//                .and()
//                .authorizeRequests()
//                .requestMatchers(ADMIN_URLS)
//                .hasAuthority("admin")
////                .antMatchers(HttpMethod.POST, "/register", "/login")
////                .permitAll()
////                .and()
////                .authorizeRequests()
////                .antMatchers("/**")
////                .hasAuthority("admin")
//                .and()
//                .csrf().disable()
//                .formLogin().disable()
//                .httpBasic().disable()
//                .logout().disable()
//                .authorizeRequests();
//    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(STATELESS)
                .and()
                .exceptionHandling()
                // this entry point handles when you request a protected page and you are not yet
                // authenticated
                .defaultAuthenticationEntryPointFor(forbiddenEntryPoint(), PROTECTED_URLS)
                .and()
                .authenticationProvider(provider)
                .addFilterBefore(restAuthenticationFilter(), AnonymousAuthenticationFilter.class)
                .authorizeRequests()
                .requestMatchers(PROTECTED_URLS)
                .authenticated()
                .and()
                .authenticationProvider(provider)
                .addFilterBefore(restAuthenticationFilter(), AnonymousAuthenticationFilter.class)
                .authorizeRequests()
                .requestMatchers(ADMIN_URLS)
                .hasAuthority("admin")
                .and()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .logout().disable();
    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.headers().frameOptions().sameOrigin();
//        JwtWebSecurityConfigurer
//                .forRS256(apiAudience, issuer)
//                .configure(http)
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/logged").authenticated()
//                .antMatchers(HttpMethod.GET, "/api/admin").hasAuthority("admin");
//    }

    @Bean
    TokenAuthenticationFilter restAuthenticationFilter() throws Exception {
        final TokenAuthenticationFilter filter = new TokenAuthenticationFilter(PROTECTED_URLS);
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(successHandler());
        return filter;
    }

    @Bean
    SimpleUrlAuthenticationSuccessHandler successHandler() {
        final SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
        successHandler.setRedirectStrategy(new NoRedirectStrategy());
        return successHandler;
    }

    /**
     * Disable Spring boot automatic filter registration.
     */
    @Bean
    FilterRegistrationBean disableAutoRegistration(final TokenAuthenticationFilter filter) {
        final FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    AuthenticationEntryPoint forbiddenEntryPoint() {
        return new HttpStatusEntryPoint(FORBIDDEN);
    }
}