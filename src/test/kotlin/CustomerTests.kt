package br.com.openpix.sdk

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CustomerTests {
  @Test
  fun `test get customer`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "customer": {
              "name": "Dan",
              "email": "email0@example.com",
              "phone": "5511999999999",
              "taxID": {
                "taxID": "31324227036",
                "type": "BR:CPF"
              },
              "correlationID": "fe7834b4060c488a9b0f89811be5f5cf"
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
        client.getCustomer("dummy")
      }

      assertThat(response).isEqualTo(
        CustomerResponse(
          customer = Customer(
            name = "Dan",
            email = "email0@example.com",
            phone = "5511999999999",
            taxID = TaxID(
              text = "31324227036",
              kind = TaxIDKind.CPF,
            ),
            correlationID = "fe7834b4060c488a9b0f89811be5f5cf",
          ),
        ),
      )
    }
  }

  @Test
  fun `test create customer`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "customer": {
              "name": "Dan",
              "email": "email0@example.com",
              "phone": "5511999999999",
              "taxID": {
                "taxID": "31324227036",
                "type": "BR:CPF"
              },
              "correlationID": "fe7834b4060c488a9b0f89811be5f5cf"
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
        client.createCustomer {
          name = "Dan"
          taxID = "31324227036"
        }
      }

      assertThat(response).isEqualTo(
        CustomerResponse(
          customer = Customer(
            name = "Dan",
            email = "email0@example.com",
            phone = "5511999999999",
            taxID = TaxID(
              text = "31324227036",
              kind = TaxIDKind.CPF,
            ),
            correlationID = "fe7834b4060c488a9b0f89811be5f5cf",
          ),
        ),
      )
    }
  }

  @Test
  fun `test get customer list`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "customers": [{
              "name": "Dan",
              "email": "email0@example.com",
              "phone": "5511999999999",
              "taxID": {
                "taxID": "31324227036",
                "type": "BR:CPF"
              },
              "correlationID": "fe7834b4060c488a9b0f89811be5f5cf"
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
        client.customers().items()
      }

      val pageInfo = withContext(Dispatchers.IO) {
        client.customers().pageInfo()
      }

      assertThat(response).isEqualTo(
        listOf(
          Customer(
            name = "Dan",
            email = "email0@example.com",
            phone = "5511999999999",
            taxID = TaxID(
              text = "31324227036",
              kind = TaxIDKind.CPF,
            ),
            correlationID = "fe7834b4060c488a9b0f89811be5f5cf",
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
