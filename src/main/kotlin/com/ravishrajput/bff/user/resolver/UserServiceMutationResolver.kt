package com.ravishrajput.bff.user.resolver

import com.ravishrajput.bff.user.api.UserServices
import com.ravishrajput.bff.user.models.GenericResponse
import com.ravishrajput.bff.user.models.User
import graphql.kickstart.tools.GraphQLMutationResolver
import jakarta.inject.Singleton
import java.util.concurrent.CompletableFuture

@Singleton
class UserServiceMutationResolver(
    private val userServices: UserServices
) : GraphQLMutationResolver {
    fun addUser(user: User): CompletableFuture<GenericResponse> = CompletableFuture.supplyAsync {
        userServices.addNewUser(user)
    }
}