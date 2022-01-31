package com.ravishrajput.bff.flights.api

import com.ravishrajput.bff.flights.models.Flight
import jakarta.inject.Singleton

@Singleton
class FlightsServices(private val flightsApi: FlightsApi) {

    fun searchFlights(from: String, to: String, month: String, date: String): List<Flight> =
        flightsApi.searchFlights(from, to, month, date)

    fun getAllFlights(): List<Flight> = flightsApi.getAllFlights()
}