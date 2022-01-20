package com.ravishrajput.bff.user.api

import com.ravishrajput.bff.user.api.UserApi.Companion.HOST
import com.ravishrajput.bff.user.models.GenericResponse
import com.ravishrajput.bff.user.models.User
import com.ravishrajput.bff.user.models.UsersListResponse
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpHeaders
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client

@Client(HOST)
@Produces(value = [MediaType.APPLICATION_JSON])
@Consumes(value = [MediaType.APPLICATION_JSON])
interface UserApi {

    @Get(value = ENDPOINT_USER)
    @Header(name = HttpHeaders.AUTHORIZATION, value = AUTHORIZATION)
    fun getUsersList(): UsersListResponse

    @Get(value = ENDPOINT_USER_DETAILS)
    @Header(name = HttpHeaders.AUTHORIZATION, value = AUTHORIZATION)
    fun getUserById(
        @PathVariable("id") id: Int
    ): User

    @Post(value = ENDPOINT_ADDUSER)
    @Header(name = HttpHeaders.AUTHORIZATION, value = AUTHORIZATION)
    @Consumes(value = [MediaType.APPLICATION_FORM_URLENCODED])
    fun addNewUser(
        @QueryValue name: String,
        @QueryValue username: String,
        @QueryValue email: String,
        @QueryValue imageUrl: String
    ): GenericResponse

    companion object {
        const val HOST = "\${micronaut.http.services.api-client.url}"
        const val ENDPOINT_USER = "\${micronaut.http.services.api-client.endpoint}"
        const val ENDPOINT_USER_DETAILS = "\${micronaut.http.services.api-client.endpoint}{/id}"
        const val ENDPOINT_ADDUSER =
            "\${micronaut.http.services.api-client.endpoint}{&name}{&username}{&email}{&imageUrl}"

        const val AUTHORIZATION = "\${micronaut.http.services.api-client.api-auth}"
    }
}