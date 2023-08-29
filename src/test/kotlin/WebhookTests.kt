package com.openpix.sdk

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WebhookTests {
  @Test
  fun `test create webhook`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "webhook": {
              "id": "V2ViaG9vazo2MDNlYmUxZWRlYjkzNWU4NmQyMmNmMTg=",
              "name": "webhookName",
              "url": "https://mycompany.com.br/webhook",
              "authorization": "openpix",
              "event": "OPENPIX:TRANSACTION_RECEIVED",
              "isActive": true,
              "createdAt": "2021-03-02T22:29:10.720Z",
              "updatedAt": "2021-03-02T22:29:10.720Z"
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
        client.createWebhook { }
      }

      assertThat(response).isEqualTo(
        WebhookResponse(
          webhook = Webhook(
            id = "V2ViaG9vazo2MDNlYmUxZWRlYjkzNWU4NmQyMmNmMTg=",
            name = "webhookName",
            event = WebhookEvent.TransactionReceived,
            url = "https://mycompany.com.br/webhook",
            authorization = "openpix",
            isActive = true,
            createdAt = "2021-03-02T22:29:10.720Z",
            updatedAt = "2021-03-02T22:29:10.720Z",
          ),
        ),
      )
    }
  }

  @Test
  fun `test delete webhook`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "status": "string"
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
        client.deleteWebhook("dummy")
      }

      assertThat(response).isEqualTo(
        WebhookDeleteResponse(
          status = "string",
        ),
      )
    }
  }

  @Test
  fun `test get webhook list`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "webhooks": [
              {
                "id": "V2ViaG9vazo2MDNlYmUxZWRlYjkzNWU4NmQyMmNmMTg=",
                "name": "webhookName",
                "url": "https://mycompany.com.br/webhook",
                "authorization": "openpix",
                "event": "OPENPIX:TRANSACTION_RECEIVED",
                "isActive": true,
                "createdAt": "2021-03-02T22:29:10.720Z",
                "updatedAt": "2021-03-02T22:29:10.720Z"
              },
              {
                "id": "V2ViaG9vazo2MDNlYmUxZWRlYjkzNWU4NmQyMmNmOTk=",
                "name": "webhookName",
                "url": "https://mycompany.com.br/webhook",
                "authorization": "openpix",
                "event": "OPENPIX:CHARGE_CREATED",
                "isActive": true,
                "createdAt": "2021-03-02T22:29:10.720Z",
                "updatedAt": "2021-03-02T22:29:10.720Z"
              }
            ],
            "pageInfo": {
              "errors": [],
              "skip": 0,
              "limit": 1,
              "totalCount": 1,
              "hasNextPage": false,
              "hasPreviousPage": false
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
        client.webhooks().items()
      }

      val pageInfo = withContext(Dispatchers.IO) {
        client.webhooks().pageInfo()
      }

      assertThat(response).isEqualTo(
        listOf(
          Webhook(
            id = "V2ViaG9vazo2MDNlYmUxZWRlYjkzNWU4NmQyMmNmMTg=",
            name = "webhookName",
            event = WebhookEvent.TransactionReceived,
            url = "https://mycompany.com.br/webhook",
            authorization = "openpix",
            isActive = true,
            createdAt = "2021-03-02T22:29:10.720Z",
            updatedAt = "2021-03-02T22:29:10.720Z",
          ),
          Webhook(
            id = "V2ViaG9vazo2MDNlYmUxZWRlYjkzNWU4NmQyMmNmOTk=",
            name = "webhookName",
            event = WebhookEvent.ChargeCreated,
            url = "https://mycompany.com.br/webhook",
            authorization = "openpix",
            isActive = true,
            createdAt = "2021-03-02T22:29:10.720Z",
            updatedAt = "2021-03-02T22:29:10.720Z",
          ),
        ),
      )
      assertThat(pageInfo).isEqualTo(
        PageInfo(
          errors = listOf(),
          skip = 0,
          limit = 1,
          totalCount = 1,
          hasNextPage = false,
          hasPreviousPage = false,
        ),
      )
    }
  }
}
