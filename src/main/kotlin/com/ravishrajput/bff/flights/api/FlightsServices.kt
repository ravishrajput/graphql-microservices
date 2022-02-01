package com.ravishrajput.bff.flights.api

import com.ravishrajput.bff.flights.models.Airline
import com.ravishrajput.bff.flights.models.AirlineDetails
import com.ravishrajput.bff.flights.models.City
import com.ravishrajput.bff.flights.models.FareDetails
import com.ravishrajput.bff.flights.models.Flight
import jakarta.inject.Singleton

@Singleton
class FlightsServices(private val flightsApi: FlightsApi) {

    fun searchFlights(from: String, to: String, month: String, date: String): List<Flight> =
        flightsApi.searchFlights(from, to, month, date)

    fun getAllFlights(): List<Flight> = flightsApi.getAllFlights()

    fun getFareDetails(id: String): FareDetails? {
        val response = flightsApi.getFareDetails(id) as Map<*, *>
        return if (response.containsKey("id")) {
            FareDetails(
                response["id"].toString(),
                response["airlinesCharges"] as Int,
                response["fuelCharges"] as Int,
                response["airportTaxes"] as Int
            )
        } else null
    }

    fun getAirlineDetails(id: String): AirlineDetails? {
        return try {
            flightsApi.getAirlineDetails(id)
        } catch (e: Exception) {
            null
        }
    }

    fun getAllAirlines(): List<Airline> = flightsApi.getAllAirlines()

    fun getAllCities(): List<City> = flightsApi.getAllCities()
}