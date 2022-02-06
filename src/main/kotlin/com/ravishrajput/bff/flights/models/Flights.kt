package com.ravishrajput.bff.flights.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Flight(
    @JsonProperty("id") val id: String,
    @JsonProperty("from") val from: String,
    @JsonProperty("to") val to: String,
    @JsonProperty("departure") val departure: String,
    @JsonProperty("arrival") val arrival: String,
    @JsonProperty("airlinesName") val airlinesName: String,
    @JsonProperty("airlinesId") val airlinesId: String,
    @JsonProperty("totalFare") val totalFare: Int,
    @JsonProperty("fareDetailsId") val fareDetailsId: String
)

data class FareDetails(
    @JsonProperty("id") val id: String,
    @JsonProperty("airlinesCharges") val airlinesCharges: Int,
    @JsonProperty("fuelCharges") val fuelCharges: Int,
    @JsonProperty("airportTaxes") val airportTaxes: Int
)

data class FlightDetails(
    @JsonProperty("flight") val flight: Flight,
    @JsonProperty("airlineDetails") var airlineDetails: AirlineDetails? = null
)