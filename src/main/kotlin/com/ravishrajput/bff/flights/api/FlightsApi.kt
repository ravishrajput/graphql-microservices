package com.ravishrajput.bff.flights.api

import com.ravishrajput.bff.flights.api.FlightsApi.Companion.HOST
import com.ravishrajput.bff.flights.models.Flight
import io.micronaut.http.HttpHeaders
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
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

    companion object {
        const val HOST = "\${micronaut.http.services.api-client.url}"
        const val ENDPOINT_FLIGHTS = "\${micronaut.http.services.api-client.endpoint-flight}{?from}{&to}{&month}{&date}"
        const val ENDPOINT_FLIGHTS_ALL = "\${micronaut.http.services.api-client.endpoint-flight}"

        const val AUTHORIZATION = "\${micronaut.http.services.api-client.api-auth}"
    }
}