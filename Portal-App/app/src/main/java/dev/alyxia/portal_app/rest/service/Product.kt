package dev.alyxia.portal_app.rest.service

import dev.alyxia.portal_app.BuildConfig
import dev.alyxia.portal_app.lib.bodyAsApiResponse
import dev.alyxia.portal_app.rest.body.ProductBody
import dev.alyxia.portal_app.rest.dto.ApiResponse
import dev.alyxia.portal_app.rest.dto.ProductList
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface APIProductService {
    suspend fun fetchAll(): ApiResponse<ProductList>
    suspend fun fetch(body: ProductBody): ApiResponse<ProductList>
}

class APIProductServiceImpl(
    private val client: HttpClient
) : APIProductService {

    override suspend fun fetchAll(): ApiResponse<ProductList> {
        val url = getProductsUrl()
        return withContext(Dispatchers.IO) {
            client.get(url)
        }.bodyAsApiResponse()
    }

    override suspend fun fetch(body: ProductBody): ApiResponse<ProductList> {
        val url = getProductsUrl()
        return withContext(Dispatchers.IO) {
            client.get(url) {
                setBody(body)
            }
        }.bodyAsApiResponse()
    }

    private companion object {
        const val BASE: String = BuildConfig.BASE_URL

        fun getProductsUrl(): String {
            return "$BASE/products"
        }
    }
}
