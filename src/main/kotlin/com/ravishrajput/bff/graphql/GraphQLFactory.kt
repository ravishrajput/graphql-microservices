package com.ravishrajput.bff.graphql

import io.micronaut.context.annotation.Bean
import io.micronaut.core.io.ResourceResolver
import jakarta.inject.Singleton

class GraphQLFactory {

    @Bean
    @Singleton
    fun graphQL(resourceResolver: ResourceResolver) {

    }

}