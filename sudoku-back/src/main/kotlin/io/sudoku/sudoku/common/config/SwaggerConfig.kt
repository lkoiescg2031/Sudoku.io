package io.sudoku.sudoku.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@Configuration
class SwaggerConfig {

    companion object {
        private val API_TITLE = "sudoku.io api"
        private val API_VERSION = "1.0"
        private val API_DESCRIPTION = "Sudoku io API Document"
        private val API_LICENSE = "The MIT License"
    }

    @Bean
    fun api() : Docket = Docket(DocumentationType.SWAGGER_2).run {
        apiInfo(apiInfo())
        select()
    }.run {
        apis(RequestHandlerSelectors.any())
        paths(PathSelectors.any())
        build()
    }

    fun apiInfo() : ApiInfo = ApiInfoBuilder().run {
        title(API_TITLE)
        version(API_VERSION)
        description(API_DESCRIPTION)
        license(API_LICENSE)
        build()
    }

}