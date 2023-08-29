package com.openpix.sdk

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountTests {
  @Test
  fun `test get account`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "account": {
              "accountId": "6290ccfd42831958a405debc",
              "isDefault": true,
              "balance": {
                "total": 129430,
                "blocked": 0,
                "available": 129430
              }
            }
          } 
          """.trimIndent(),
        ),
        headers = headersOf("Content-Type" to listOf("application/json")),
        status = HttpStatusCode.OK,
      )
    }

    val httpClient = createDefaultHttpClient(engine, "", "", createJson())
    val client = WooviSDK("", client = httpClient)

    runBlocking {
      val response = withContext(Dispatchers.IO) {
        client.getAccount("dummy")
      }

      assertThat(response).isEqualTo(
        AccountResponse(
          account = Account(
            accountId = "6290ccfd42831958a405debc",
            isDefault = true,
            balance = Balance(
              total = 129430,
              blocked = 0,
              available = 129430,
            ),
          ),
        ),
      )
    }
  }

  @Test
  fun `test get account list`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "accounts": [{
              "accountId": "6290ccfd42831958a405debc",
              "isDefault": true,
              "balance": {
                "total": 129430,
                "blocked": 0,
                "available": 129430
              }
            }]
          } 
          """.trimIndent(),
        ),
        headers = headersOf("Content-Type" to listOf("application/json")),
        status = HttpStatusCode.OK,
      )
    }

    val httpClient = createDefaultHttpClient(engine, "", "", createJson())
    val client = WooviSDK("", client = httpClient)

    runBlocking {
      val response = withContext(Dispatchers.IO) {
        client.allAccounts()
      }

      assertThat(response).isEqualTo(
        AccountListResponse(
          accounts = listOf(
            Account(
              accountId = "6290ccfd42831958a405debc",
              isDefault = true,
              balance = Balance(
                total = 129430,
                blocked = 0,
                available = 129430,
              ),
            ),
          ),
        ),
      )
    }
  }
}
