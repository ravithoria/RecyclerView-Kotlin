package com.ravindra.recyclerviewdemo

import com.ravindra.recyclerviewdemo.response.user.UserResponseNew
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("?results=5")
    fun fetchUser(): Call<UserResponseNew>

}