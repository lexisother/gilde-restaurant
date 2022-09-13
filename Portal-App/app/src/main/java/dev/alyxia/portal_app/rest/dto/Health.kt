package dev.alyxia.portal_app.rest.dto

import kotlinx.serialization.Serializable

@Serializable
data class ApiHealth(
    val ok: Boolean
)
