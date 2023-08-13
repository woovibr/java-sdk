package br.com.openpix.sdk

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChargeTests {
  @Test
  fun `test create charge`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "charge": {
              "status": "ACTIVE",
              "customer": {
                "name": "Dan",
                "email": "email0@example.com",
                "phone": "5511999999999",
                "taxID": {
                  "taxID": "31324227036",
                  "type": "BR:CPF"
                }
              },
              "value": 100,
              "comment": "good",
              "correlationID": "9134e286-6f71-427a-bf00-241681624586",
              "paymentLinkID": "7777-6f71-427a-bf00-241681624586",
              "paymentLinkUrl": "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
              "globalID": "Q2hhcmdlOjcxOTFmMWIwMjA0NmJmNWY1M2RjZmEwYg==",
              "qrCodeImage": "https://api.openpix.com.br/openpix/charge/brcode/image/9134e286-6f71-427a-bf00-241681624586.png",
              "brCode": "000201010212261060014br.gov.bcb.pix2584https://api.openpix.com.br/openpix/testing?transactionID=867ba5173c734202ac659721306b38c952040000530398654040.015802BR5909LOCALHOST6009Sao Paulo62360532867ba5173c734202ac659721306b38c963044BCA",
              "additionalInfo": [
                {
                  "key": "Product",
                  "value": "Pencil"
                },
                {
                  "key": "Invoice",
                  "value": "18476"
                },
                {
                  "key": "Order",
                  "value": "302"
                }
              ],
              "expiresIn": 2592000,
              "expiresDate": "2021-04-01T17:28:51.882Z",
              "createdAt": "2021-03-02T17:28:51.882Z",
              "updatedAt": "2021-03-02T17:28:51.882Z"
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
        client.createCharge {
          correlationID = "..."
          value = 100
        }
      }

      @Suppress("MaxLineLength")
      assertThat(response).isEqualTo(
        ChargeResponse(
          charge = Charge(
            status = "ACTIVE",
            customer = CustomerOrId.IsCustomer(
              value = Customer(
                name = "Dan",
                email = "email0@example.com",
                phone = "5511999999999",
                taxID = TaxID(
                  text = "31324227036",
                  kind = TaxIDKind.CPF,
                ),
              ),
            ),
            value = 100,
            correlationID = "9134e286-6f71-427a-bf00-241681624586",
            paymentLinkID = "7777-6f71-427a-bf00-241681624586",
            paymentLinkUrl = "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
            additionalInfo = listOf(
              AdditionalInfo(
                key = "Product",
                value = "Pencil",
              ),
              AdditionalInfo(
                key = "Invoice",
                value = "18476",
              ),
              AdditionalInfo(
                key = "Order",
                value = "302",
              ),
            ),
            expiresIn = 2592000,
            expiresDate = "2021-04-01T17:28:51.882Z",
            createdAt = "2021-03-02T17:28:51.882Z",
            updatedAt = "2021-03-02T17:28:51.882Z",
            globalID = "Q2hhcmdlOjcxOTFmMWIwMjA0NmJmNWY1M2RjZmEwYg==",
            qrCodeImage = "https://api.openpix.com.br/openpix/charge/brcode/image/9134e286-6f71-427a-bf00-241681624586.png",
            brCode = "000201010212261060014br.gov.bcb.pix2584https://api.openpix.com.br/openpix/testing?transactionID=867ba5173c734202ac659721306b38c952040000530398654040.015802BR5909LOCALHOST6009Sao Paulo62360532867ba5173c734202ac659721306b38c963044BCA", // ktlint-disable
          ),
        )
      )
    }
  }
  @Test
  fun `test get charge`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "charge": {
              "status": "ACTIVE",
              "customer": {
                "name": "Dan",
                "email": "email0@example.com",
                "phone": "5511999999999",
                "taxID": {
                  "taxID": "31324227036",
                  "type": "BR:CPF"
                }
              },
              "value": 100,
              "comment": "good",
              "correlationID": "9134e286-6f71-427a-bf00-241681624586",
              "paymentLinkID": "7777-6f71-427a-bf00-241681624586",
              "paymentLinkUrl": "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
              "globalID": "Q2hhcmdlOjcxOTFmMWIwMjA0NmJmNWY1M2RjZmEwYg==",
              "qrCodeImage": "https://api.openpix.com.br/openpix/charge/brcode/image/9134e286-6f71-427a-bf00-241681624586.png",
              "brCode": "000201010212261060014br.gov.bcb.pix2584https://api.openpix.com.br/openpix/testing?transactionID=867ba5173c734202ac659721306b38c952040000530398654040.015802BR5909LOCALHOST6009Sao Paulo62360532867ba5173c734202ac659721306b38c963044BCA",
              "additionalInfo": [
                {
                  "key": "Product",
                  "value": "Pencil"
                },
                {
                  "key": "Invoice",
                  "value": "18476"
                },
                {
                  "key": "Order",
                  "value": "302"
                }
              ],
              "expiresIn": 2592000,
              "expiresDate": "2021-04-01T17:28:51.882Z",
              "createdAt": "2021-03-02T17:28:51.882Z",
              "updatedAt": "2021-03-02T17:28:51.882Z"
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
        client.getCharge("dummy")
      }

      @Suppress("MaxLineLength")
      assertThat(response).isEqualTo(
        ChargeResponse(
          charge = Charge(
            status = "ACTIVE",
            customer = CustomerOrId.IsCustomer(
              value = Customer(
                name = "Dan",
                email = "email0@example.com",
                phone = "5511999999999",
                taxID = TaxID(
                  text = "31324227036",
                  kind = TaxIDKind.CPF,
                ),
              ),
            ),
            value = 100,
            correlationID = "9134e286-6f71-427a-bf00-241681624586",
            paymentLinkID = "7777-6f71-427a-bf00-241681624586",
            paymentLinkUrl = "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
            additionalInfo = listOf(
              AdditionalInfo(
                key = "Product",
                value = "Pencil",
              ),
              AdditionalInfo(
                key = "Invoice",
                value = "18476",
              ),
              AdditionalInfo(
                key = "Order",
                value = "302",
              ),
            ),
            expiresIn = 2592000,
            expiresDate = "2021-04-01T17:28:51.882Z",
            createdAt = "2021-03-02T17:28:51.882Z",
            updatedAt = "2021-03-02T17:28:51.882Z",
            globalID = "Q2hhcmdlOjcxOTFmMWIwMjA0NmJmNWY1M2RjZmEwYg==",
            qrCodeImage = "https://api.openpix.com.br/openpix/charge/brcode/image/9134e286-6f71-427a-bf00-241681624586.png",
            brCode = "000201010212261060014br.gov.bcb.pix2584https://api.openpix.com.br/openpix/testing?transactionID=867ba5173c734202ac659721306b38c952040000530398654040.015802BR5909LOCALHOST6009Sao Paulo62360532867ba5173c734202ac659721306b38c963044BCA", // ktlint-disable
          ),
        )
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
            "status": "OK",
            "id": "fe7834b4060c488a9b0f89811be5f5cf"
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
        client.deleteCharge("dummy")
      }

      assertThat(response).isEqualTo(
        ChargeDeleteResponse(
          id = "fe7834b4060c488a9b0f89811be5f5cf",
          status = "OK",
        ),
      )
    }
  }

  @Test
  fun `test get charge list`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "charges": [{
              "status": "ACTIVE",
              "customer": {
                "name": "Dan",
                "email": "email0@example.com",
                "phone": "5511999999999",
                "taxID": {
                  "taxID": "31324227036",
                  "type": "BR:CPF"
                }
              },
              "value": 100,
              "comment": "good",
              "correlationID": "9134e286-6f71-427a-bf00-241681624586",
              "paymentLinkID": "7777-6f71-427a-bf00-241681624586",
              "paymentLinkUrl": "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
              "globalID": "Q2hhcmdlOjcxOTFmMWIwMjA0NmJmNWY1M2RjZmEwYg==",
              "qrCodeImage": "https://api.openpix.com.br/openpix/charge/brcode/image/9134e286-6f71-427a-bf00-241681624586.png",
              "brCode": "000201010212261060014br.gov.bcb.pix2584https://api.openpix.com.br/openpix/testing?transactionID=867ba5173c734202ac659721306b38c952040000530398654040.015802BR5909LOCALHOST6009Sao Paulo62360532867ba5173c734202ac659721306b38c963044BCA",
              "additionalInfo": [
                {
                  "key": "Product",
                  "value": "Pencil"
                },
                {
                  "key": "Invoice",
                  "value": "18476"
                },
                {
                  "key": "Order",
                  "value": "302"
                }
              ],
              "expiresIn": 2592000,
              "expiresDate": "2021-04-01T17:28:51.882Z",
              "createdAt": "2021-03-02T17:28:51.882Z",
              "updatedAt": "2021-03-02T17:28:51.882Z"
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

    runBlocking {
      val response = withContext(Dispatchers.IO) {
        client.charges().items()
      }

      val pageInfo = withContext(Dispatchers.IO) {
        client.charges().pageInfo()
      }

      @Suppress("MaxLineLength")
      assertThat(response).isEqualTo(
        listOf(
          Charge(
            status = "ACTIVE",
            customer = CustomerOrId.IsCustomer(
              value = Customer(
                name = "Dan",
                email = "email0@example.com",
                phone = "5511999999999",
                taxID = TaxID(
                  text = "31324227036",
                  kind = TaxIDKind.CPF,
                ),
              ),
            ),
            value = 100,
            correlationID = "9134e286-6f71-427a-bf00-241681624586",
            paymentLinkID = "7777-6f71-427a-bf00-241681624586",
            paymentLinkUrl = "https://openpix.com.br/pay/9134e286-6f71-427a-bf00-241681624586",
            additionalInfo = listOf(
              AdditionalInfo(
                key = "Product",
                value = "Pencil",
              ),
              AdditionalInfo(
                key = "Invoice",
                value = "18476",
              ),
              AdditionalInfo(
                key = "Order",
                value = "302",
              ),
            ),
            expiresIn = 2592000,
            expiresDate = "2021-04-01T17:28:51.882Z",
            createdAt = "2021-03-02T17:28:51.882Z",
            updatedAt = "2021-03-02T17:28:51.882Z",
            globalID = "Q2hhcmdlOjcxOTFmMWIwMjA0NmJmNWY1M2RjZmEwYg==",
            qrCodeImage = "https://api.openpix.com.br/openpix/charge/brcode/image/9134e286-6f71-427a-bf00-241681624586.png",
            brCode = "000201010212261060014br.gov.bcb.pix2584https://api.openpix.com.br/openpix/testing?transactionID=867ba5173c734202ac659721306b38c952040000530398654040.015802BR5909LOCALHOST6009Sao Paulo62360532867ba5173c734202ac659721306b38c963044BCA", // ktlint-disable
          ),
        )
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
