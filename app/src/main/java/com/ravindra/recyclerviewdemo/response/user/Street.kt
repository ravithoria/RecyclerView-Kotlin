package com.ravindra.recyclerviewdemo.response.user

import com.google.gson.annotations.SerializedName

data class Street(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("name")
	val name: String? = null
)