package com.ravishrajput.bff.graphql

import graphql.GraphQL
import graphql.kickstart.tools.SchemaParser
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class GraphQLFactory {

    @Bean
    @Singleton
    fun customSchema(schemaParser: SchemaParser): GraphQL {
        return GraphQL.newGraphQL(schemaParser.makeExecutableSchema())
            .build()
    }

}