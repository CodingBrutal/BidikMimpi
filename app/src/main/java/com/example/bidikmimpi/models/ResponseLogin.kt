package com.example.bidikmimpi.models

import com.google.gson.annotations.SerializedName

data class ResponseLogin(

	@field:SerializedName("tokens")
	val tokens: Tokens? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("status")
	val status: Boolean? = null,

	@field:SerializedName("applicant")
	val applicant: Applicant? = null,

	@field:SerializedName("error")
	val error: String? = null
)

data class Applicant(

	@field:SerializedName("average_score")
	val averageScore: Float? = null,

	@field:SerializedName("parent_income")
	val parentIncome: Float? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("decent_house")
	val decentHouse: String? = null,

	@field:SerializedName("dependents")
	val dependents: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class Tokens(

	@field:SerializedName("access")
	val access: String? = null,

	@field:SerializedName("refresh")
	val refresh: String? = null
)

data class User(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)
