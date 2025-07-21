package husjp.api.asignacionCamasMicroservicio.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests.requestMatchers(AUTH_WHITLIST).permitAll();
                    //ejemplo para proteger un endpoint
                    authorizeRequests.requestMatchers(HttpMethod.GET, "ejemplo/prueba").hasAnyRole("ADMINISTRADOR");
                    authorizeRequests.requestMatchers(HttpMethod.GET, "ejemplo/fecha").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION");
                    // Solicitud Cama
                    authorizeRequests.requestMatchers(HttpMethod.PUT, "solicitudCama/cancelar/{idSolicitudCama}").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION");
                    //version Solicitud Cama
                    authorizeRequests.requestMatchers(HttpMethod.GET, "versionSolicitudCama/active").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION","CAMAS_ENFERMERO_INTERNACION","CAMAS_ENFERMERO_URGENCIAS","CAMAS_FACTURACION","CAMAS_MEDICO_ESPECIALISTA");
                    authorizeRequests.requestMatchers(HttpMethod.POST, "versionSolicitudCama").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION","CAMAS_ENFERMERO_INTERNACION","CAMAS_MEDICO_ESPECIALISTA");
                    authorizeRequests.requestMatchers(HttpMethod.PUT, "versionSolicitudCama/{id}").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION");
                    authorizeRequests.requestMatchers(HttpMethod.PUT, "versionSolicitudCama/{id}/estadoSolicitudCancelada").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION");
                    authorizeRequests.requestMatchers(HttpMethod.PUT,"versionSolicitudCama/{id}/estadoAutorizacionFacturacion").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION","CAMAS_FACTURACION");
                    //Asignacion Cama
                    authorizeRequests.requestMatchers(HttpMethod.PUT,"asignacionSolicitudCama/{id}/estadoFinalizado").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION");
                    authorizeRequests.requestMatchers(HttpMethod.PUT,"asignacionSolicitudCama/{id}/cancelar/motivo/{idVersionAsignacionCama}").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION");
                    //Version Asignacion Solicitud Cama
                    authorizeRequests.requestMatchers(HttpMethod.GET, "asignacionVersionSolicitudCama/active/{idBloqueServicio}").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION","CAMAS_ENFERMERO_INTERNACION","CAMAS_ENFERMERO_URGENCIAS");
                    authorizeRequests.requestMatchers(HttpMethod.PUT,"asignacionVersionSolicitudCama").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION");
                    authorizeRequests.requestMatchers(HttpMethod.POST, "asignacionVersionSolicitudCama").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION","CAMAS_ENFERMERO_INTERNACION");
                    //
                    authorizeRequests.requestMatchers(HttpMethod.GET, "titulosFormacionAcademica/especialidad").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION","CAMAS_ENFERMERO_INTERNACION","CAMAS_ENFERMERO_URGENCIAS","CAMAS_FACTURACION","CAMAS_MEDICO_ESPECIALISTA");;
                    authorizeRequests.requestMatchers(HttpMethod.GET, "medidasAislamiento").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION","CAMAS_ENFERMERO_INTERNACION","CAMAS_ENFERMERO_URGENCIAS","CAMAS_FACTURACION","CAMAS_MEDICO_ESPECIALISTA");;
                    authorizeRequests.requestMatchers(HttpMethod.GET, "diagnostico/{idOrName}").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION","CAMAS_ENFERMERO_INTERNACION","CAMAS_ENFERMERO_URGENCIAS","CAMAS_FACTURACION","CAMAS_MEDICO_ESPECIALISTA");;
                    authorizeRequests.requestMatchers(HttpMethod.GET, "bloque-servicio").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION","CAMAS_ENFERMERO_INTERNACION","CAMAS_ENFERMERO_URGENCIAS","CAMAS_FACTURACION","CAMAS_MEDICO_ESPECIALISTA");;
                    authorizeRequests.requestMatchers(HttpMethod.GET, "bloque-servicio/servicios/{idBloque}").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION","CAMAS_ENFERMERO_INTERNACION","CAMAS_ENFERMERO_URGENCIAS","CAMAS_FACTURACION","CAMAS_MEDICO_ESPECIALISTA");;
                    authorizeRequests.requestMatchers(HttpMethod.GET, "cama/{idServicio}").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION","CAMAS_ENFERMERO_INTERNACION","CAMAS_ENFERMERO_URGENCIAS","CAMAS_FACTURACION","CAMAS_MEDICO_ESPECIALISTA");;
                    authorizeRequests.requestMatchers(HttpMethod.GET, "servicio/{idBloqueServicio}").hasAnyRole("ADMINISTRADOR","CAMAS_COORD_INTERNACION","CAMAS_ENFERMERO_INTERNACION","CAMAS_ENFERMERO_URGENCIAS","CAMAS_FACTURACION","CAMAS_MEDICO_ESPECIALISTA");;
                    authorizeRequests.anyRequest().authenticated();
                    }
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    private static final String[] AUTH_WHITLIST = {
            "/api/v1/auth/**",
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",
            "/swagger-ui/**",
            "/swagger-ui.html"
    };

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> null; // Esto desactiva el UserDetailsService por defecto
    }

}