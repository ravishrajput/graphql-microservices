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