package dev.alyxia.portal_app.rest.dto

import kotlinx.serialization.Serializable

@Serializable
data class ApiError(
    val error: Error
)

@Serializable
data class Error(
    val type: String,
    val message: String,
    val code: String,
    val file: String,
    val line: Int
)