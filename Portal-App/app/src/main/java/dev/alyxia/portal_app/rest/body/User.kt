package dev.alyxia.portal_app.rest.body

import kotlinx.serialization.Serializable

@Serializable
data class UserBody(
    val email: String,
    val password: String
)