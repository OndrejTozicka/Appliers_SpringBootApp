
package cz.appliersdatabase.appliersdatabase.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Tozicka Ondrej
 */

//Class representing configuration file of swagger
@Profile("dev")
@Configuration
//@EnableSwagger2
public class SwaggerConfiguration{

    /**
     *
     * @return Docket bean
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(new ApiInfoBuilder().title("Appliers backend application").build());
    }

    /**
     *
     * @return Configuration of UI swagger
     */
    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder
                .builder()
                .operationsSorter(OperationsSorter.ALPHA)
                .build();
    }
    
}
