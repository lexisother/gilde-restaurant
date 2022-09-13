package dev.alyxia.portal_app.rest.service

import dev.alyxia.portal_app.rest.dto.ApiHealth
import dev.alyxia.portal_app.BuildConfig
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface APIHealthService {
    suspend fun checkHealth(): ApiHealth
}

class APIHealthServiceImpl(
    private val client: HttpClient
): APIHealthService {

    override suspend fun checkHealth(): ApiHealth {
        val url = getHealthUrl()
        return withContext(Dispatchers.IO) {
            client.get(url)
        }.body()
    }

    private companion object {
        const val BASE: String = BuildConfig.BASE_URL

        fun getHealthUrl(): String {
            return "$BASE/health"
        }
    }
}