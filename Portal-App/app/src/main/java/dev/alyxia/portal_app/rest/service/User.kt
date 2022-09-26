package dev.alyxia.portal_app.rest.service

import dev.alyxia.portal_app.BuildConfig
import dev.alyxia.portal_app.lib.bodyAsApiResponse
import dev.alyxia.portal_app.rest.body.UserBody
import dev.alyxia.portal_app.rest.dto.ApiResponse
import dev.alyxia.portal_app.rest.dto.ApiUser
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface APIUserService {
    suspend fun login(body: UserBody): ApiResponse<ApiUser>
}

class APIUserServiceImpl(
    private val client: HttpClient
) : APIUserService {
    override suspend fun login(body: UserBody): ApiResponse<ApiUser> {
        val url = getLoginUrl()
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
    }
}