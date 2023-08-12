@file:Suppress("MaxLineLength", "LongMethod")

package br.com.openpix.sdk

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class PixQrCodeTests {
  @Test
  fun `test get pix qr code async`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "pixQrCode": {
              "value": 100,
              "name": "dummy",
              "comment": "good",
              "correlationID": "9134e286-6f71-427a-bf00-241681624586",
              "identifier": "zr7833b4060c488a9b0f89811",
              "paymentLinkID": "7777a23s-6f71-427a-bf00-241681624586",
              "paymentLinkUrl": "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
              "qrCodeImage": "https://api.openpix.com.br/openpi...",
              "createdAt": "2021-03-02T17:28:51.882Z",
              "updatedAt": "2021-03-02T17:28:51.882Z",
              "brCode": "000201010212261060014br.gov.bcb..."
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
    val pixQrCode = PixQrCode(
      name = "dummy",
      identifier = "zr7833b4060c488a9b0f89811",
      correlationID = "9134e286-6f71-427a-bf00-241681624586",
      paymentLinkID = "7777a23s-6f71-427a-bf00-241681624586",
      paymentLinkUrl = "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
      createdAt = "2021-03-02T17:28:51.882Z",
      updatedAt = "2021-03-02T17:28:51.882Z",
      brCode = "000201010212261060014br.gov.bcb...",
      qrCodeImage = "https://api.openpix.com.br/openpi...",
    )

    runBlocking {
      val response = withContext(Dispatchers.IO) {
        client.getPixQrCodeAsync("dummy").get()
      }

      assertThat(response).isEqualTo(PixQrCodeResponse(pixQrCode = pixQrCode))
    }
  }

  @Test
  fun `test get pix qr code page async`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "pixQrCodes": [
              {
                "value": 100,
                "name": "dummy",
                "comment": "good",
                "correlationID": "9134e286-6f71-427a-bf00-241681624586",
                "identifier": "zr7833b4060c488a9b0f89811",
                "paymentLinkID": "7777a23s-6f71-427a-bf00-241681624586",
                "paymentLinkUrl": "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
                "qrCodeImage": "https://api.openpix.com.br/openpi...",
                "createdAt": "2021-03-02T17:28:51.882Z",
                "updatedAt": "2021-03-02T17:28:51.882Z",
                "brCode": "000201010212261060014br.gov.bcb..."
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

    @Suppress("MaxLineLength")
    val pixQrCode = PixQrCode(
      name = "dummy",
      identifier = "zr7833b4060c488a9b0f89811",
      correlationID = "9134e286-6f71-427a-bf00-241681624586",
      paymentLinkID = "7777a23s-6f71-427a-bf00-241681624586",
      paymentLinkUrl = "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
      createdAt = "2021-03-02T17:28:51.882Z",
      updatedAt = "2021-03-02T17:28:51.882Z",
      brCode = "000201010212261060014br.gov.bcb...",
      qrCodeImage = "https://api.openpix.com.br/openpi...",
    )

    runBlocking {
      val response = withContext(Dispatchers.IO) {
        client.pixQrCodes().items()
      }

      val pageInfo = withContext(Dispatchers.IO) {
        client.pixQrCodes().pageInfo()
      }

      assertThat(response).isEqualTo(listOf(pixQrCode))
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

  @Test
  fun `test create pix qr code async`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "pixQrCode": {
              "value": 100,
              "name": "dummy",
              "comment": "good",
              "correlationID": "9134e286-6f71-427a-bf00-241681624586",
              "identifier": "zr7833b4060c488a9b0f89811",
              "paymentLinkID": "7777a23s-6f71-427a-bf00-241681624586",
              "paymentLinkUrl": "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
              "qrCodeImage": "https://api.openpix.com.br/openpi...",
              "createdAt": "2021-03-02T17:28:51.882Z",
              "updatedAt": "2021-03-02T17:28:51.882Z",
              "brCode": "000201010212261060014br.gov.bcb..."
            },
            "brCode": "000201010212261060014br.gov.bcb...",
            "correlationID": "9134e286-6f71-427a-bf00-241681624586"
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
    val pixQrCode = PixQrCode(
      name = "dummy",
      identifier = "zr7833b4060c488a9b0f89811",
      correlationID = "9134e286-6f71-427a-bf00-241681624586",
      paymentLinkID = "7777a23s-6f71-427a-bf00-241681624586",
      paymentLinkUrl = "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
      createdAt = "2021-03-02T17:28:51.882Z",
      updatedAt = "2021-03-02T17:28:51.882Z",
      brCode = "000201010212261060014br.gov.bcb...",
      qrCodeImage = "https://api.openpix.com.br/openpi...",
    )

    runBlocking {
      val response = withContext(Dispatchers.IO) {
        client.createPixQrCode {
          correlationID = "9134e286-6f71-427a-bf00-241681624586"
          identifier = "zr7833b4060c488a9b0f89811"
          name = "dummy"
          value = 100
        }
      }

      assertThat(response).isEqualTo(
        PixQrCodeResponse(
          pixQrCode = pixQrCode,
          brCode = "000201010212261060014br.gov.bcb...",
          correlationID = "9134e286-6f71-427a-bf00-241681624586",
        ),
      )
    }
  }
}
