package com.ravishrajput.bff.flights.models

import com.fasterxml.jackson.annotation.JsonProperty

data class AirlineDetails(
    @JsonProperty("airline") val airline: Airline,
    @JsonProperty("baggageDetails") val baggageDetails: BaggageDetails,
    @JsonProperty("id") val id: String,
    @JsonProperty("seatsAvailable") val seatsAvailable: Int,
    @JsonProperty("stops") val stops: List<Stop>
)

data class Airline(
    @JsonProperty("id") val id: String,
    @JsonProperty("name") val name: String
)

data class BaggageDetails(
    @JsonProperty("cabin") val cabin: Boolean,
    @JsonProperty("chargesPerExtraKg") val chargesPerExtraKg: Int,
    @JsonProperty("checkin") val checkin: Boolean
)

data class City(
    @JsonProperty("id") val id: String,
    @JsonProperty("name") val name: String
)

data class Stop(
    @JsonProperty("arrival") val arrival: String,
    @JsonProperty("city") val city: City,
    @JsonProperty("departure") val departure: String
)