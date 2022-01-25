package com.ravishrajput.bff.user.api

import com.ravishrajput.bff.user.models.GenericResponse
import com.ravishrajput.bff.user.models.User
import com.ravishrajput.bff.user.models.UsersListResponse
import jakarta.inject.Singleton

@Singleton
class UserServices(private val userApi: UserApi) {

    fun getAllUsers(): UsersListResponse = userApi.getUsersList()
    fun getUserById(id: Int): User? {
        val response = userApi.getUserById(id) as Map<*, *>
        return if (response.containsKey("id")) {
            User(
                response["id"] as Int,
                response["name"].toString(),
                response["username"].toString(),
                response["email"].toString(),
                response["imageUrl"].toString()
            )
        } else null
    }

    fun addNewUser(user: User): GenericResponse? {
        val response = userApi.addNewUser(user.name, user.username, user.email, user.imageUrl)
        return response as? GenericResponse
    }
}