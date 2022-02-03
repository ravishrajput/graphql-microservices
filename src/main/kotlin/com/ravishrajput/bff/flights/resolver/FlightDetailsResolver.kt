package com.ravishrajput.bff.flights.resolver

import com.ravishrajput.bff.flights.api.FlightsServices
import com.ravishrajput.bff.flights.models.Airline
import com.ravishrajput.bff.flights.models.AirlineDetails
import com.ravishrajput.bff.flights.models.BaggageDetails
import com.ravishrajput.bff.flights.models.City
import com.ravishrajput.bff.flights.models.FlightDetails
import com.ravishrajput.bff.flights.models.Stop
import graphql.kickstart.tools.GraphQLResolver
import graphql.schema.DataFetchingEnvironment
import java.util.concurrent.CompletableFuture

class FlightDetailsResolver(private val flightsServices: FlightsServices) : GraphQLResolver<AirlineDetails> {

    fun airlineDetails(
        getFlightDetails: List<FlightDetails>,
        dfe: DataFetchingEnvironment
    ): CompletableFuture<AirlineDetails> = CompletableFuture.supplyAsync {
        AirlineDetails(
            Airline("meg", "Meego"),
            BaggageDetails(true, 2450, true),
            "jksbvjhdf",
            45,
            listOf(
                Stop("12th dec", City("del", "Delhi"), "13th dec")
            )
        )
    }
}