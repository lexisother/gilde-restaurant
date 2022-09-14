package dev.alyxia.portal_app.rest.dto

sealed interface ApiResponse<T> {
    class Success<T>(val data: T) : ApiResponse<T>
    class Error<T>(val error: ApiError) : ApiResponse<T>
}
