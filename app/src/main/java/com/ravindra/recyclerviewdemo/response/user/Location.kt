package com.ravindra.recyclerviewdemo.response.user

import com.google.gson.annotations.SerializedName

data class Location(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("street")
	val street: Street? = null,

	@field:SerializedName("timezone")
	val timezone: Timezone? = null,

	@field:SerializedName("postcode")
	val postcode: Int? = null,

	@field:SerializedName("coordinates")
	val coordinates: Coordinates? = null,

	@field:SerializedName("state")
	val state: String? = null
)