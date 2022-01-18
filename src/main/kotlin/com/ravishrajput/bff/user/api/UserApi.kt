package com.ravishrajput.bff.user.api

import com.ravishrajput.bff.user.models.UsersListResponse
import com.ravishrajput.bff.user.api.UserApi.Companion.HOST
import io.micronaut.http.HttpHeaders
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Produces
import io.micronaut.http.client.annotation.Client

@Client(HOST)
@Produces(value = [MediaType.APPLICATION_JSON])
@Consumes(value = [MediaType.APPLICATION_JSON])
interface UserApi {

    @Get(value = ENDPOINT_LIST)
    @Header(name = HttpHeaders.AUTHORIZATION, value = AUTHORIZATION)
    fun getUsersList(): UsersListResponse

    companion object {
        const val HOST = "\${micronaut.http.services.api-client.url}"
        const val ENDPOINT_LIST = "\${micronaut.http.services.api-client.endpoint}"

        const val AUTHORIZATION = "\${micronaut.http.services.api-client.api-auth}"
    }
}