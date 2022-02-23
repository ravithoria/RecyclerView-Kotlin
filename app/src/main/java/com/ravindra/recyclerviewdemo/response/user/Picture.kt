package com.ravindra.recyclerviewdemo.response.user

import com.google.gson.annotations.SerializedName

data class Picture(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("large")
	val large: String? = null,

	@field:SerializedName("medium")
	val medium: String? = null
)