package com.ravishrajput.bff.flights.api

import com.ravishrajput.bff.flights.api.FlightsApi.Companion.HOST
import com.ravishrajput.bff.flights.models.Airline
import com.ravishrajput.bff.flights.models.AirlineDetails
import com.ravishrajput.bff.flights.models.City
import com.ravishrajput.bff.flights.models.Flight
import io.micronaut.http.HttpHeaders
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client

@Client(HOST)
@Produces(value = [MediaType.APPLICATION_JSON])
interface FlightsApi {

    @Get(value = ENDPOINT_FLIGHTS_ALL)
    @Header(name = HttpHeaders.AUTHORIZATION, value = AUTHORIZATION)
    fun getAllFlights(): List<Flight>

    @Get(value = ENDPOINT_FLIGHTS)
    @Header(name = HttpHeaders.AUTHORIZATION, value = AUTHORIZATION)
    fun searchFlights(
        @QueryValue("from") from: String,
        @QueryValue("to") to: String,
        @QueryValue("month") month: String,
        @QueryValue("date") date: String
    ): List<Flight>

    @Get(value = ENDPOINT_FARE_DETAILS)
    @Header(name = HttpHeaders.AUTHORIZATION, value = AUTHORIZATION)
    fun getFareDetails(
        @PathVariable("id") id: String
    ): Any?

    @Get(value = AIRLINES_DETAILS)
    @Header(name = HttpHeaders.AUTHORIZATION, value = AUTHORIZATION)
    fun getAirlineDetails(
        @PathVariable("id") id: String
    ): AirlineDetails

    @Get(value = AIRLINES)
    @Header(name = HttpHeaders.AUTHORIZATION, value = AUTHORIZATION)
    fun getAllAirlines(): List<Airline>

    @Get(value = CITIES)
    @Header(name = HttpHeaders.AUTHORIZATION, value = AUTHORIZATION)
    fun getAllCities(): List<City>

    companion object {
        const val HOST = "\${micronaut.http.services.api-client.url}"
        const val ENDPOINT_FLIGHTS = "\${micronaut.http.services.api-client.endpoint-flight}{?from}{&to}{&month}{&date}"
        const val ENDPOINT_FLIGHTS_ALL = "\${micronaut.http.services.api-client.endpoint-flight}"
        const val ENDPOINT_FARE_DETAILS = "\${micronaut.http.services.api-client.endpoint-fareDetails}{/id}"
        const val AIRLINES_DETAILS = "\${micronaut.http.services.api-client.endpoint-airlines}{/id}"
        const val AIRLINES = "\${micronaut.http.services.api-client.endpoint-airlines}"
        const val CITIES = "\${micronaut.http.services.api-client.endpoint-cities}"

        const val AUTHORIZATION = "\${micronaut.http.services.api-client.api-auth}"
    }
}