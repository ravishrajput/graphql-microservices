package com.ravishrajput.bff.flights.resolver

import com.ravishrajput.bff.flights.api.FlightsServices
import com.ravishrajput.bff.flights.models.Flight
import graphql.kickstart.tools.GraphQLQueryResolver
import jakarta.inject.Singleton
import java.util.concurrent.CompletableFuture

@Singleton
class FlightsServiceQueryResolver(private val flightsServices: FlightsServices) : GraphQLQueryResolver {
    fun searchFlights(from: String, to: String, month: String, date: String): CompletableFuture<List<Flight>> =
        CompletableFuture.supplyAsync {
            flightsServices.searchFlights(from, to, month, date)
        }

    fun getAllFlights(): CompletableFuture<List<Flight>> =
        CompletableFuture.supplyAsync {
            flightsServices.getAllFlights()
        }
}