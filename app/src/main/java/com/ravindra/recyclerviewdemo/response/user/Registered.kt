package com.ravindra.recyclerviewdemo.response.user

import com.google.gson.annotations.SerializedName

data class Registered(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("age")
	val age: Int? = null
)