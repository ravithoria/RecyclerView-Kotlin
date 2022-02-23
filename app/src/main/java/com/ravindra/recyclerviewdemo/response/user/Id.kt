package com.ravindra.recyclerviewdemo.response.user

import com.google.gson.annotations.SerializedName

data class Id(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("value")
	val value: String? = null
)