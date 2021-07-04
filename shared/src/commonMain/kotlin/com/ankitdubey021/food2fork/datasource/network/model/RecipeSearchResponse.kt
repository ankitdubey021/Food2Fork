package com.ankitdubey021.food2fork.datasource.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeSearchResponse(

    var count  : Int,

    @SerialName("results")
    val result : List<RecipeDto>
)