package br.com.openpix.sdk

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

public suspend fun main() {
  val sdk = WooviSDK(appId = System.getenv("APP_ID"))
  println(sdk.chargeQrCodeImage("gksdahlkg"))
}

@OptIn(ExperimentalSerializationApi::class)
public class WooviSDK(
  private val appId: String,
  private val json: Json = Json {
    explicitNulls = true
    ignoreUnknownKeys = true
  },
  public val client: HttpClient = HttpClient(CIO) {
    install(Logging) {
      level = LogLevel.HEADERS
    }

    install(ContentNegotiation) {
      json(json)
    }

    install(HttpCallValidator) {
      validateResponse { response ->
        if (response.status.isSuccess()) return@validateResponse
        throw response.body<WooviError>()
      }
      handleResponseExceptionWithRequest { exception, _ ->
        val clientException = exception as? ClientRequestException ?: return@handleResponseExceptionWithRequest
        throw clientException.response.body<WooviError>()
      }
    }

    defaultRequest {
      url("https://api.openpix.com.br/")
      header("Content-Type", "application/json")
      header("Authorization", appId)
    }
  },
)
