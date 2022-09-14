package dev.alyxia.portal_app.lib

import dev.alyxia.portal_app.rest.dto.ApiError
import dev.alyxia.portal_app.rest.dto.ApiResponse
import io.ktor.client.statement.*
import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

/**
 * @author X1nto
 */
suspend inline fun <reified T> HttpResponse.bodyAsApiResponse(): ApiResponse<T> {
    val res = this.bodyAsText()
    return try {
        val decoded = Json.decodeFromString<T>(res)
        ApiResponse.Success(decoded)
    } catch (e: SerializationException) {
        val decoded = Json.decodeFromString<ApiError>(res)
        ApiResponse.Error(decoded)
    }
}
