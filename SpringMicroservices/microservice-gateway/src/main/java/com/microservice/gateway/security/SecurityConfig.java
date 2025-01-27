package com.microservice.gateway.security;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebFluxSecurity
@Slf4j
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
		serverHttpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable)
        .cors(cors -> cors.configurationSource(request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.addAllowedOriginPattern("*");
            config.addAllowedMethod("*"); 
            config.addAllowedHeader("*");
            config.setAllowCredentials(true);
            return config;
        }))
		.authorizeExchange(exchange-> exchange
				.pathMatchers("/eureka/**").permitAll().anyExchange()
				.authenticated()
	           /*.pathMatchers("/usuarioEmpresa/**", "/empresa/**").hasAnyRole("SUPER", "ADMIN")
	            .pathMatchers("/file/**", "/login/**").permitAll()
	            */
				)
		.oauth2ResourceServer(oauth2->oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));
		
		return serverHttpSecurity.build();	
	}
	
	
	private ReactiveJwtAuthenticationConverterAdapter jwtAuthenticationConverter() {
	    JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
	    converter.setJwtGrantedAuthoritiesConverter(jwt -> {
	        if (jwt.getClaim("realm_access") == null) {
	            return List.of();
	        }

	        Map<String, Object> realmAccess = jwt.getClaim("realm_access");

	        if (realmAccess == null || realmAccess.get("roles") == null) {
	            return List.of();
	        }

	        Collection<String> realmRoles = (Collection<String>) realmAccess.get("roles");

	        return realmRoles.stream()
	                .filter(role -> role.startsWith("ROLE_"))
	                .map(SimpleGrantedAuthority::new)
	                .collect(Collectors.toList());
	        }
	    );

	    return new ReactiveJwtAuthenticationConverterAdapter(converter);
	}

	
}
