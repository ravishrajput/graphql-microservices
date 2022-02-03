package com.ravishrajput.bff.graphql

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.ravishrajput.bff.flights.api.FlightsServices
import com.ravishrajput.bff.flights.resolver.FlightDetailsResolver
import com.ravishrajput.bff.flights.resolver.FlightsServiceQueryResolver
import com.ravishrajput.bff.user.api.UserServices
import com.ravishrajput.bff.user.resolver.UserServiceMutationResolver
import com.ravishrajput.bff.user.resolver.UserServiceQueryResolver
import com.ravishrajput.bff.user.resolver.UsersResolver
import graphql.GraphQL
import graphql.Scalars
import graphql.execution.AsyncExecutionStrategy
import graphql.execution.instrumentation.tracing.TracingInstrumentation
import graphql.kickstart.tools.PerFieldObjectMapperProvider
import graphql.kickstart.tools.SchemaParser
import graphql.kickstart.tools.SchemaParserBuilder
import graphql.kickstart.tools.SchemaParserOptions
import graphql.language.FieldDefinition
import graphql.scalars.ExtendedScalars
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Factory
class GraphQLFactory(private val exceptionHandler: ExceptionHandler) {

    @Bean
    @Singleton
    fun customSchema(schemaParser: SchemaParser): GraphQL {
        val graphQLBuilder = GraphQL.newGraphQL(schemaParser.makeExecutableSchema())
            .queryExecutionStrategy(AsyncExecutionStrategy(exceptionHandler))
        graphQLBuilder.instrumentation(TracingInstrumentation())

        return GraphQL.newGraphQL(schemaParser.makeExecutableSchema())
            .build()
    }

    @Bean
    @Singleton
    @ExperimentalCoroutinesApi
    fun schemaParser(
        userServices: UserServices,
        flightsServices: FlightsServices,
        optionsBuilder: SchemaParserOptions.Builder
    ): SchemaParser {
        return SchemaParserBuilder()
            .options(optionsBuilder.build())
            .files(
                "schema.graphql",
                "user.graphql",
                "flights.graphql"
            )
            .resolvers(
                listOf(
                    UserServiceQueryResolver(userServices),
                    UserServiceMutationResolver(userServices),
                    UsersResolver(userServices),
                    FlightsServiceQueryResolver(flightsServices),
                    FlightDetailsResolver(flightsServices)
                )
            )
            .scalars(ExtendedScalars.Json, Scalars.GraphQLLong)
            .build()
    }

    @Bean
    @Singleton
    fun optionsBuilder(
        perFieldObjectMapperProvider: PerFieldObjectMapperProvider
    ): SchemaParserOptions.Builder {
        return SchemaParserOptions.newOptions()
            .objectMapperProvider(perFieldObjectMapperProvider)
    }

    @Bean
    @Singleton
    fun perFieldObjectMapperProvider(objectMapper: ObjectMapper): PerFieldObjectMapperProvider {
        objectMapper.registerModule(Jdk8Module())
            .registerModule(KotlinModule())
        return object : PerFieldObjectMapperProvider {
            override fun provide(fieldDefinition: FieldDefinition): ObjectMapper {
                return objectMapper
            }
        }
    }

    @Bean
    @Singleton
    fun objectMapper(): ObjectMapper = ObjectMapper().registerModule(Jdk8Module())
        .registerModule(KotlinModule())

}