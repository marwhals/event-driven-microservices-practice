package reactive.elastic.query.web.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

public class WebSecurityConfig {

    @Bean
    public SecurityWebFilterChain webFluxSecurityConfig(ServerHttpSecurity http) {
        http.authorizeExchange()
                .anyExchange()
                .permitAll();
        http.csrf().disable();
        return http.build();
    }

}
