package com.ravishrajput.bff.user.models

import com.fasterxml.jackson.annotation.JsonProperty

data class UsersListResponse(
    @JsonProperty("users") val users: List<User>
)

data class User(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("username") val username: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("imageUrl") val imageUrl: String
)

data class GenericResponse(
    @JsonProperty("code") val code: Int,
    @JsonProperty("message") val message: String
)