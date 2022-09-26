package dev.alyxia.portal_app.rest.dto

import dev.alyxia.portal_app.lib.DateSerializer
import kotlinx.serialization.Serializable
import java.util.*

typealias ProductList = List<ApiProduct>

@Serializable
data class ApiProduct(
    @Serializable(with = DateSerializer::class)
    val created_at: Date,
    @Serializable(with = DateSerializer::class)
    val updated_at: Date,

    val id: Int,
    val name: String,
    val description: String,
    val price: Int
)