package com.ravishrajput.bff.user.resolver

import com.ravishrajput.bff.user.api.UserServices
import com.ravishrajput.bff.user.models.User
import com.ravishrajput.bff.user.models.UsersListResponse
import graphql.kickstart.tools.GraphQLResolver

class UsersResolver(private val userServices: UserServices) : GraphQLResolver<UsersListResponse> {
    fun usersList(): List<User> {
        return userServices.getAllUsers().users
    }
}