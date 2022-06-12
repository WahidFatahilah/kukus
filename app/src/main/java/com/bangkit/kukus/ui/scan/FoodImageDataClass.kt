package com.bangkit.kukus.ui.scan

import com.google.gson.annotations.SerializedName

data class FoodImageDataClass(
    @field:SerializedName("error")
    val error: Boolean,
    @field:SerializedName("nama")
    val foodName: String,
    @field:SerializedName("kalori")
    val foodCalorie: String

)