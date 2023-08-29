package com.openpix.sdk

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RefundTests {
  @Test
  fun `test get refund`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "pixTransactionRefund": {
              "value": 100,
              "correlationID": "7777-6f71-427a-bf00-241681624586",
              "refundId": "11bf5b37e0b842e08dcfdc8c4aefc000",
              "returnIdentification": "D09089356202108032000a543e325902",
              "comment": "Comentário do reembolso"
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

    @Suppress("MaxLineLength")
    val refund = Refund(
      value = 100,
      correlationID = "7777-6f71-427a-bf00-241681624586",
      refundId = "11bf5b37e0b842e08dcfdc8c4aefc000",
      returnIdentification = "D09089356202108032000a543e325902",
      comment = "Comentário do reembolso",
    )

    runBlocking {
      val response = withContext(Dispatchers.IO) {
        client.getRefund("dummy")
      }

      assertThat(response).isEqualTo(RefundResponse(pixTransactionRefund = refund))
    }
  }

  @Test
  fun `test create refund`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "refund": {
              "value": 100,
              "correlationID": "7777-6f71-427a-bf00-241681624586",
              "refundId": "11bf5b37e0b842e08dcfdc8c4aefc000",
              "returnIdentification": "D09089356202108032000a543e325902",
              "comment": "Comentário do reembolso"
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

    @Suppress("MaxLineLength")
    val refund = Refund(
      value = 100,
      correlationID = "7777-6f71-427a-bf00-241681624586",
      refundId = "11bf5b37e0b842e08dcfdc8c4aefc000",
      returnIdentification = "D09089356202108032000a543e325902",
      comment = "Comentário do reembolso",
    )

    runBlocking {
      val response = withContext(Dispatchers.IO) {
        client.createRefund {
          transactionEndToEndId = "..."
          value = 1000
          comment = "..."
          correlationID = "..."
        }
      }

      assertThat(response).isEqualTo(RefundResponse(pixTransactionRefund = refund))
    }
  }

  @Test
  fun `test get refund list`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "refunds": [{
              "value": 100,
              "correlationID": "7777-6f71-427a-bf00-241681624586",
              "refundId": "11bf5b37e0b842e08dcfdc8c4aefc000",
              "returnIdentification": "D09089356202108032000a543e325902",
              "comment": "Comentário do reembolso"
            }],
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

    @Suppress("MaxLineLength")
    val refund = Refund(
      value = 100,
      correlationID = "7777-6f71-427a-bf00-241681624586",
      refundId = "11bf5b37e0b842e08dcfdc8c4aefc000",
      returnIdentification = "D09089356202108032000a543e325902",
      comment = "Comentário do reembolso",
    )

    runBlocking {
      val response = withContext(Dispatchers.IO) {
        client.refunds().items()
      }

      val pageInfo = withContext(Dispatchers.IO) {
        client.refunds().pageInfo()
      }

      assertThat(response).isEqualTo(listOf(refund))
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
