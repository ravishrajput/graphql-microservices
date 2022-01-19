package com.ravishrajput.bff.user.api

import com.ravishrajput.bff.user.models.User
import graphql.kickstart.tools.GraphQLQueryResolver
import jakarta.inject.Singleton
import java.util.concurrent.CompletableFuture

@Singleton
class UserServiceQueryResolver(private val userServices: UserServices) : GraphQLQueryResolver {

    fun getAllUsers(): CompletableFuture<List<User>> = CompletableFuture.supplyAsync {
        userServices.getAllUsers().users
    }
}