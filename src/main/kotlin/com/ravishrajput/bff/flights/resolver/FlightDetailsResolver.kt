package com.ravishrajput.bff.flights.resolver

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
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

class FlightDetailsResolver(private val flightsServices: FlightsServices) : GraphQLResolver<FlightDetails> {

    fun airlineDetails(
        getFlightDetails: List<FlightDetails>,
        dfe: DataFetchingEnvironment
    ): CompletableFuture<AirlineDetails> = CompletableFuture.supplyAsync {
        val airlineDetailsList = mutableListOf<AirlineDetails>()
        var airlinesIds = getFlightDetails.map { it.flight.airlinesId }
        var inputParama = ObjectMapper().registerKotlinModule()
            .convertValue(dfe.executionStepInfo.parent.arguments["from"], String::class.java)

        AirlineDetails(
            Airline("meg", "Meego"),
            BaggageDetails(true, 2450, true),
            "MEEpunmaa",
            45,
            listOf(
                Stop("12th dec", City("del", "Delhi"), "13th dec")
            )
        )
    }
}