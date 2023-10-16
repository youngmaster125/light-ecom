package org.sid.lightecom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecConfig {
	
	private RsakeysConfig rsakeysConfig;

	public SecConfig(RsakeysConfig rsakeysConfig) {
		super();
		this.rsakeysConfig = rsakeysConfig;
	}
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	        return httpSecurity
	                .csrf(csrf->csrf.disable())
	           .authorizeHttpRequests(auth->auth.requestMatchers("/","/products/**","/swagger-ui/**", "/v3/api-docs/**","/categories/**","/photoProduct/**").permitAll())
				// depraced	.authorizeRequests(auth->auth.requestMatchers("/**").permitAll())
	                .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
	               //depraced .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
	                .oauth2ResourceServer((oauth2)->oauth2.jwt(Customizer.withDefaults()))
	                .build();
	    }
	    @Bean
	    JwtDecoder jwtDecoder(){
	        return NimbusJwtDecoder.withPublicKey(rsakeysConfig.publicKey()).build();
	    }


}
