package br.com.openpix.sdk

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.Test

class PixQrCodeTests {
  @Test
  fun `test woovi sdk get pix qr code async`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "pixQrCode": {
              "value": 100,
              "name": "some name",
              "comment": "good",
              "correlationID": "9134e286-6f71-427a-bf00-241681624586",
              "identifier": "zr7833b4060c488a9b0f89811",
              "paymentLinkID": "7777a23s-6f71-427a-bf00-241681624586",
              "paymentLinkUrl": "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
              "qrCodeImage": "https://api.openpix.com.br/openpix/pixQrCode/brcode/image/9134e286-6f71-427a-bf00-241681624586.png",
              "createdAt": "2021-03-02T17:28:51.882Z",
              "updatedAt": "2021-03-02T17:28:51.882Z",
              "brCode": "000201010212261060014br.gov.bcb.pix2584https://api.openpix.com.br/openpix/testing?transactionID=867ba5173c734202ac659721306b38c952040000530398654040.015802BR5909LOCALHOST6009Sao Paulo62360532867ba5173c734202ac659721306b38c963044BCA"
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
      name = "some name",
      identifier = "zr7833b4060c488a9b0f89811",
      correlationID = "9134e286-6f71-427a-bf00-241681624586",
      paymentLinkID = "7777a23s-6f71-427a-bf00-241681624586",
      paymentLinkUrl = "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
      createdAt = "2021-03-02T17:28:51.882Z",
      updatedAt = "2021-03-02T17:28:51.882Z",
      brCode = "000201010212261060014br.gov.bcb.pix2584https://api.openpix.com.br/openpix/testing?transactionID=867ba5173c734202ac659721306b38c952040000530398654040.015802BR5909LOCALHOST6009Sao Paulo62360532867ba5173c734202ac659721306b38c963044BCA",
      qrCodeImage = "https://api.openpix.com.br/openpix/pixQrCode/brcode/image/9134e286-6f71-427a-bf00-241681624586.png",
    )
    val pixQrCodeResponse = PixQrCodeResponse(pixQrCode = pixQrCode)

    runBlocking {
      val response = withContext(Dispatchers.IO) {
        client.getPixQrCodeAsync("dummy").get()
      }

      assert(response == pixQrCodeResponse)
    }
  }
}
