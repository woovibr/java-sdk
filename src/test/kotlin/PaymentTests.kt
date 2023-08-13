package br.com.openpix.sdk

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PaymentTests {
  @Test
  fun `test get payment`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "payment": {
              "value": 100,
              "status": "CONFIRMED",
              "destinationAlias": "c4249323-b4ca-43f2-8139-8232aab09b93",
              "comment": "payment comment",
              "correlationID": "payment1",
              "sourceAccountId": "my-source-account-id"
            },
            "transaction": {
              "value": 100,
              "endToEndId": "transaction-end-to-end-id",
              "time": "2023-03-20T13:14:17.000Z"
            },
            "destination": {
              "name": "Dan",
              "taxID": "31324227036",
              "pixKey": "c4249323-b4ca-43f2-8139-8232aab09b93",
              "bank": "A Bank",
              "branch": "1",
              "account": "123456"
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
        client.getPayment("dummy")
      }

      assertThat(response).isEqualTo(
        PaymentResponseObject(
          payment = Payment(
            value = 100,
            status = PaymentStatus.CONFIRMED,
            destinationAlias = "c4249323-b4ca-43f2-8139-8232aab09b93",
            comment = "payment comment",
            correlationID = "payment1",
            sourceAccountId = "my-source-account-id",
          ),
          transaction = PaymentTransaction(
            value = 100,
            endToEndId = "transaction-end-to-end-id",
            time = "2023-03-20T13:14:17.000Z",
          ),
          destination = PaymentDestination(
            name = "Dan",
            taxID = "31324227036",
            pixKey = "c4249323-b4ca-43f2-8139-8232aab09b93",
            bank = "A Bank",
            branch = "1",
            account = "123456",
          ),
        ),
      )
    }
  }

  @Test
  fun `test create payment`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "payment": {
              "value": 100,
              "status": "CONFIRMED",
              "destinationAlias": "c4249323-b4ca-43f2-8139-8232aab09b93",
              "comment": "payment comment",
              "correlationID": "payment1",
              "sourceAccountId": "my-source-account-id"
            },
            "transaction": {
              "value": 100,
              "endToEndId": "transaction-end-to-end-id",
              "time": "2023-03-20T13:14:17.000Z"
            },
            "destination": {
              "name": "Dan",
              "taxID": "31324227036",
              "pixKey": "c4249323-b4ca-43f2-8139-8232aab09b93",
              "bank": "A Bank",
              "branch": "1",
              "account": "123456"
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
        client.createPayment { }
      }

      assertThat(response).isEqualTo(
        PaymentResponseObject(
          payment = Payment(
            value = 100,
            status = PaymentStatus.CONFIRMED,
            destinationAlias = "c4249323-b4ca-43f2-8139-8232aab09b93",
            comment = "payment comment",
            correlationID = "payment1",
            sourceAccountId = "my-source-account-id",
          ),
          transaction = PaymentTransaction(
            value = 100,
            endToEndId = "transaction-end-to-end-id",
            time = "2023-03-20T13:14:17.000Z",
          ),
          destination = PaymentDestination(
            name = "Dan",
            taxID = "31324227036",
            pixKey = "c4249323-b4ca-43f2-8139-8232aab09b93",
            bank = "A Bank",
            branch = "1",
            account = "123456",
          ),
        ),
      )
    }
  }

  @Test
  fun `test get payment list`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "payments": [{
              "payment": {
                "value": 100,
                "status": "CONFIRMED",
                "destinationAlias": "c4249323-b4ca-43f2-8139-8232aab09b93",
                "comment": "payment comment",
                "correlationID": "payment1",
                "sourceAccountId": "my-source-account-id"
              },
              "transaction": {
                "value": 100,
                "endToEndId": "transaction-end-to-end-id",
                "time": "2023-03-20T13:14:17.000Z"
              },
              "destination": {
                "name": "Dan",
                "taxID": "31324227036",
                "pixKey": "c4249323-b4ca-43f2-8139-8232aab09b93",
                "bank": "A Bank",
                "branch": "1",
                "account": "123456"
              }
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
        client.payments().items()
      }

      val pageInfo = withContext(Dispatchers.IO) {
        client.payments().pageInfo()
      }

      assertThat(response).isEqualTo(
        listOf(
          PaymentResponseObject(
            payment = Payment(
              value = 100,
              status = PaymentStatus.CONFIRMED,
              destinationAlias = "c4249323-b4ca-43f2-8139-8232aab09b93",
              comment = "payment comment",
              correlationID = "payment1",
              sourceAccountId = "my-source-account-id",
            ),
            transaction = PaymentTransaction(
              value = 100,
              endToEndId = "transaction-end-to-end-id",
              time = "2023-03-20T13:14:17.000Z",
            ),
            destination = PaymentDestination(
              name = "Dan",
              taxID = "31324227036",
              pixKey = "c4249323-b4ca-43f2-8139-8232aab09b93",
              bank = "A Bank",
              branch = "1",
              account = "123456",
            ),
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
