package com.kardelencetin.moviekmm.data.remote

import com.kardelencetin.moviekmm.data.util.getApiKey
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/* internal yazılan modifierlar sadece ilgili modül içerisinde geçerli olur */
// ContentNegotiation -> networking işlemleri için kullanılır

private const val BASE_URL = "https://api.themoviedb.org/"
private val API_KEY = getApiKey()

internal abstract class KtorApi {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true // gelen dönüşten bildiği keyleri alabilmesi için kullanılır
                useAlternativeNames = false //
                })
        }
    }

    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(BASE_URL)
            path("3", path)
            parameter("api_key", API_KEY)
        }
    }
}