package com.ravishrajput.bff.user.api

import com.ravishrajput.bff.user.models.GenericResponse
import com.ravishrajput.bff.user.models.User
import com.ravishrajput.bff.user.models.UsersListResponse
import jakarta.inject.Singleton

@Singleton
class UserServices(private val userApi: UserApi) {

    fun getAllUsers(): UsersListResponse = userApi.getUsersList()
    fun getUserById(id: Int): User? {
        // todo work on multiple object return type
        return userApi.getUserById(id)
    }

    fun addNewUser(user: User): GenericResponse {
        return userApi.addNewUser(user.name, user.username, user.email, user.imageUrl)
    }
}