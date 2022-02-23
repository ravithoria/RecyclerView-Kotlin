package com.ravindra.recyclerviewdemo.response.user

import com.google.gson.annotations.SerializedName

data class UserResponseNew(

	@field:SerializedName("results")
	val results: List<ResultsItem>? = null,

	@field:SerializedName("info")
	val info: Info? = null
)