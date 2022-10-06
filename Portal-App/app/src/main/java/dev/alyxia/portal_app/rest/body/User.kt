package dev.alyxia.portal_app.rest.body

import kotlinx.serialization.Serializable

@Serializable
data class UserAuthBody(
    val email: String,
    val password: String
)