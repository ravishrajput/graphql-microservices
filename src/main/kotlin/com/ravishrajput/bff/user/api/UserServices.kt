package com.ravishrajput.bff.user.api

import com.ravishrajput.bff.user.models.UsersListResponse
import jakarta.inject.Singleton

@Singleton
class UserServices(private val userApi: UserApi) {

    fun getAllUsers(): UsersListResponse = userApi.getUsersList()

}