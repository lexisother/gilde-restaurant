package dev.alyxia.portal_app.rest.dto

import dev.alyxia.portal_app.lib.DateSerializer
import kotlinx.serialization.Serializable
import java.util.*

typealias UserList = List<ApiUser>

@Serializable
data class ApiUser(
    @Serializable(with = DateSerializer::class)
    val created_at: Date,
    @Serializable(with = DateSerializer::class)
    val updated_at: Date,

    val id: Int,
    val name: String,
    val email: String,
    val password: String
)