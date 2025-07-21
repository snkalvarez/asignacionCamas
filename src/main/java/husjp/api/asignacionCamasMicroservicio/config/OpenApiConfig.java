package husjp.api.asignacionCamasMicroservicio.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Value("${app.version}")
    private String appVersion;

    @Value("${swagger.server.local}")
    String local;

    @Value("${swagger.server.api}")
    private String apiGateway;

    @Value("${swagger.server.prod}")
    String prod;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("Bearer Authentication", // Nombre de tu esquema de seguridad (puedes llamarlo como quieras)
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer") // Especifica el esquema como "bearer"
                                        .bearerFormat("JWT") // Indica que el formato del token es JWT
                                        .in(SecurityScheme.In.HEADER) // Opcional, el token se envía en el encabezado
                                        .name("Authorization") // Opcional, el nombre del encabezado
                                        .description("Introduce el token JWT (Bearer Token)"))); // Descripción para el usuario
    }

    @Bean
    public GroupedOpenApi diagnosticoOpenApi(@Value("2.3.0") String appVersion){
        String [] paths = {"/diagnostico/**"};
        return GroupedOpenApi.builder()
                .group("diagnosticos")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("diagnosticos")
                            .version(appVersion)
                            .description("diagnostico cie10 ")
                    );
                    openApi.addServersItem(new Server()
                            .url(local)
                            .description("Servidor local"));
                    openApi.addServersItem(new Server()
                        .url(prod)
                            .description("Servidor de produccion"));
                    openApi.addServersItem(new Server()
                            .url(apiGateway)
                            .description("Servidor API Gateway"));
                    })
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi versionSolilcitudCamaOpenApi(@Value("2.3.0") String appVersion){
        String [] paths = {"/versionSolicitudCama/**"};
        return GroupedOpenApi.builder()
                .group("versionSolicitudCama")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("Version Solicitud")
                            .version(appVersion)
                            .description("crea una nueva version de una solicitud URG ADU-1-V1 A URG ADU-1-V2")
                    );
                    openApi.addServersItem(new Server()
                            .url(local)
                            .description("Servidor local"));
                    openApi.addServersItem(new Server()
                        .url(prod)
                            .description("Servidor de produccion"));
                    openApi.addServersItem(new Server()
                            .url(apiGateway)
                            .description("Servidor API Gateway"));
                    })
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi solilcitudCamaOpenApi(@Value("2.3.0") String appVersion){
        String [] paths = {"/solicitudCama/**"};
        return GroupedOpenApi.builder()
                .group("solicitudCama")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("EJEMPLO microservicio")
                            .version(appVersion)
                            .description("Ejemplo de como se debe documentar el microservicio")
                    );
                    openApi.addServersItem(new Server()
                            .url(local)
                            .description("Servidor local"));
                    openApi.addServersItem(new Server()
                        .url(prod)
                            .description("Servidor de produccion"));
                    openApi.addServersItem(new Server()
                            .url(apiGateway)
                            .description("Servidor API Gateway"));
                    })
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi camaOpenApi(@Value("2.3.0") String appVersion){
        String [] paths = {"/cama/**"};
        return GroupedOpenApi.builder()
                .group("cama")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("EJEMPLO microservicio")
                            .version(appVersion)
                            .description("Ejemplo de como se debe documentar el microservicio")
                    );
                    openApi.addServersItem(new Server()
                            .url(local)
                            .description("Servidor local"));
                    openApi.addServersItem(new Server()
                        .url(prod)
                            .description("Servidor de produccion"));
                    openApi.addServersItem(new Server()
                            .url(apiGateway)
                            .description("Servidor API Gateway"));
                    })
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi bloqueServicioOpenApi(@Value("2.3.0") String appVersion){
        String [] paths = {"/bloque-servicio/**"};
        return GroupedOpenApi.builder()
                .group("bloque-servicio")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("MICROSERVICIO CAMAS")
                            .version(appVersion)
                            .description("TRABAJA CON BLOQUES, UN BLOQUE ES UN CONJUNTO DE SERVICIOS QUE PERTENECEN A ESE BLOQUE, UN SERVICIO SOLO PUEDE PERTENECER A UN BLOQUE")
                    );
                    openApi.addServersItem(new Server()
                            .url(local)
                            .description("Servidor local"));
                    openApi.addServersItem(new Server()
                        .url(prod)
                            .description("Servidor de produccion"));
                    openApi.addServersItem(new Server()
                            .url(apiGateway)
                            .description("Servidor API Gateway"));
                    })
                .pathsToMatch(paths)
                .build();
    }
    @Bean
    public GroupedOpenApi servicioOpenApi(@Value("2.3.0") String appVersion){
        String [] paths = {"/servicio/**"};
        return GroupedOpenApi.builder()
                .group("servicio").displayName("SERVICIO")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("EJEMPLO microservicio")
                            .version(appVersion)
                            .description("Ejemplo de como se debe documentar el microservicio")
                    );
                    openApi.addServersItem(new Server()
                            .url(local)
                            .description("Servidor local"));
                    openApi.addServersItem(new Server()
                        .url(prod)
                            .description("Servidor de produccion"));
                    openApi.addServersItem(new Server()
                            .url(apiGateway)
                            .description("Servidor API Gateway"));
                    })
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi titulosFormacionAcademicaOpenApi(@Value("2.3.0") String appVersion){
        String [] paths = {"/titulosFormacionAcademica/**"};
        return GroupedOpenApi.builder()
                .group("titulosFormacionAcademica")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("EJEMPLO microservicio")
                            .version(appVersion)
                            .description("Ejemplo de como se debe documentar el microservicio")
                    );
                    openApi.addServersItem(new Server()
                            .url(local)
                            .description("Servidor local"));
                    openApi.addServersItem(new Server()
                        .url(prod)
                            .description("Servidor de produccion"));
                    openApi.addServersItem(new Server()
                            .url(apiGateway)
                            .description("Servidor API Gateway"));
                    })
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi medidasDeAislamientoOpenApi(@Value("2.3.0") String appVersion){
        String [] paths = {"/medidasAislamiento/**"};
        return GroupedOpenApi.builder()
                .group("medidasAislamiento")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("medidasAislamiento microservicio")
                            .version(appVersion)
                            .description("Ejemplo de como se debe documentar el microservicio")
                    );
                    openApi.addServersItem(new Server()
                            .url(local)
                            .description("Servidor local"));
                    openApi.addServersItem(new Server()
                        .url(prod)
                            .description("Servidor de produccion"));
                    openApi.addServersItem(new Server()
                            .url(apiGateway)
                            .description("Servidor API Gateway"));
                    })
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi respuestaVersionSolicitudCamaOpenApi(@Value("2.3.0") String appVersion){
        String [] paths = {"/asignacionVersionSolicitudCama/**"};
        return GroupedOpenApi.builder()
                .group("asignacionVersionSolicitudCama")
                .displayName("Version Asignacion Solicitud Cama")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("medidasAislamiento microservicio")
                            .version(appVersion)
                            .description("Crea una nueva version de la solicitud si esta fue modificada ")
                    );
                    openApi.addServersItem(new Server()
                            .url(local)
                            .description("Servidor local"));
                    openApi.addServersItem(new Server()
                        .url(prod)
                            .description("Servidor de produccion"));
                    openApi.addServersItem(new Server()
                            .url(apiGateway)
                            .description("Servidor API Gateway"));
                    })
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi respuestaAsignacionSolicitudCamas(@Value("2.3.0") String appVersion){
        String [] paths = {"/asignacionSolicitudCama/**"};
        return GroupedOpenApi.builder()
                .group("asignacionSolicitudCama")
                .displayName("Asignacion Solicitud Cama")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("medidasAislamiento microservicio")
                            .version(appVersion)
                            .description("Crea una nueva Asignacion  ")
                    );
                    openApi.addServersItem(new Server()
                            .url(local)
                            .description("Servidor local"));
                    openApi.addServersItem(new Server()
                        .url(prod)
                            .description("Servidor de produccion"));
                    openApi.addServersItem(new Server()
                            .url(apiGateway)
                            .description("Servidor API Gateway"));
                    })
                .pathsToMatch(paths)
                .build();
    }


    @Bean
    public GroupedOpenApi ejemploOpenApi(@Value("2.3.0") String appVersion){
        String [] paths = {"/ejemplo/**"};
        return GroupedOpenApi.builder()
                .group("ejemplo")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("EJEMPLO microservicio")
                            .version(appVersion)
                            .description("Ejemplo de como se debe documentar el microservicio")
                    );
                    openApi.addServersItem(new Server()
                            .url(local)
                            .description("Servidor local"));
                    openApi.addServersItem(new Server()
                        .url(prod)
                            .description("Servidor de produccion"));
                    openApi.addServersItem(new Server()
                            .url(apiGateway)
                            .description("Servidor API Gateway"));
                    })
                .pathsToMatch(paths)
                .build();
    }
}
