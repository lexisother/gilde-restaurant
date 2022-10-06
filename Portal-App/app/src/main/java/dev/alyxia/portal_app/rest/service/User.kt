package dev.alyxia.portal_app.rest.service

import dev.alyxia.portal_app.BuildConfig
import dev.alyxia.portal_app.lib.bodyAsApiResponse
import dev.alyxia.portal_app.rest.body.UserAuthBody
import dev.alyxia.portal_app.rest.dto.ApiResponse
import dev.alyxia.portal_app.rest.dto.ApiUser
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface APIUserService {
    suspend fun login(body: UserAuthBody): ApiResponse<ApiUser>
    suspend fun clock(body: UserAuthBody): ApiResponse<ApiUser>
}

class APIUserServiceImpl(
    private val client: HttpClient
) : APIUserService {
    override suspend fun login(body: UserAuthBody): ApiResponse<ApiUser> {
        val url = getLoginUrl()
        return withContext(Dispatchers.IO) {
            client.post(url) {
                setBody(body)
            }
        }.bodyAsApiResponse()
    }

    override suspend fun clock(body: UserAuthBody): ApiResponse<ApiUser> {
        val url = getClockUrl()
        return withContext(Dispatchers.IO) {
            client.post(url) {
                setBody(body)
            }
        }.bodyAsApiResponse()
    }

    private companion object {
        const val BASE: String = BuildConfig.BASE_URL

        fun getLoginUrl(): String {
            return "$BASE/auth/login"
        }
        fun getClockUrl(): String {
            return "$BASE/user/clock"
        }
    }
}