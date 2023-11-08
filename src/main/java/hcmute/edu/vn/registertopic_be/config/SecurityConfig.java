package hcmute.edu.vn.registertopic_be.config;

import hcmute.edu.vn.registertopic_be.service.CustomOAuth2UserService;
import hcmute.edu.vn.registertopic_be.service.PersonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private CustomOAuth2UserService oauthUserService;
    @Autowired
    private PersonService personService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(ahr -> ahr
                        .requestMatchers(new AntPathRequestMatcher("/","/login")).permitAll()
                        .anyRequest().authenticated())
                .formLogin(AbstractHttpConfigurer::disable)
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(oauthUserService))
                        .successHandler(new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                                DefaultOidcUser oauthUser = (DefaultOidcUser) authentication.getPrincipal();
                                String email = oauthUser.getAttribute("email");

                                try {
                                    personService.processOAuthPostLogin(email);
                                    String redirectUrl = personService.processOAuthPostLogin(email);
                                    response.sendRedirect("/api"+redirectUrl);
                                } catch (UsernameNotFoundException e) {
                                    String errorMessage = "User not found. Please try again.";
                                    response.setContentType("text/plain");
                                    response.getWriter().write(errorMessage);
                                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                                }
                            }
                        }));
        return http.build();
    }

}
