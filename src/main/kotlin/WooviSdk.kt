package br.com.openpix.sdk

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

public suspend fun main() {
  val sdk = WooviSDK(appId = System.getenv("APP_ID"))
  println(
    sdk.createPixQrCode {
      name = "samuel qrcode kt"
      identifier = "akfjsgassak"
    },
  )
}

@OptIn(ExperimentalSerializationApi::class)
public class WooviSDK(
  private val appId: String,
  public val client: HttpClient = HttpClient(CIO) {
    install(Logging) {
      level = LogLevel.HEADERS
    }

    install(ContentNegotiation) {
      json(
        Json {
          explicitNulls = true
          ignoreUnknownKeys = true
        },
      )
    }

    defaultRequest {
      url("https://api.openpix.com.br/")
      header("Content-Type", "application/json")
      header("Authorization", appId)
    }
  },
)
