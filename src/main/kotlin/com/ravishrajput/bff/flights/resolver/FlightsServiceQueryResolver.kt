package com.ravishrajput.bff.flights.resolver

import com.ravishrajput.bff.flights.api.FlightsServices
import com.ravishrajput.bff.flights.models.Airline
import com.ravishrajput.bff.flights.models.AirlineDetails
import com.ravishrajput.bff.flights.models.City
import com.ravishrajput.bff.flights.models.FareDetails
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

    fun fareDetails(id: String): CompletableFuture<FareDetails> =
        CompletableFuture.supplyAsync {
            flightsServices.getFareDetails(id)
        }

    fun airlineDetails(id: String): CompletableFuture<AirlineDetails> =
        CompletableFuture.supplyAsync {
            flightsServices.getAirlineDetails(id)
        }

    fun getAllAirlines(): CompletableFuture<List<Airline>> =
        CompletableFuture.supplyAsync {
            flightsServices.getAllAirlines()
        }

    fun getAllCities(): CompletableFuture<List<City>> =
        CompletableFuture.supplyAsync {
            flightsServices.getAllCities()
        }
}