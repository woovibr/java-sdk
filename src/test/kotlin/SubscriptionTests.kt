package br.com.openpix.sdk

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SubscriptionTests {
  @Test
  fun `test get subscription`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "subscription": {
              "globalID": "UGF5bWVudFN1YnNjcmlwdGlvbjo2M2UzYjJiNzczZDNkOTNiY2RkMzI5OTM=",
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
              "dayGenerateCharge": 5
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
    val subscription = Subscription(
      globalID = "UGF5bWVudFN1YnNjcmlwdGlvbjo2M2UzYjJiNzczZDNkOTNiY2RkMzI5OTM=",
      customer = Customer(
        name = "Dan",
        email = "email0@example.com",
        phone = "5511999999999",
        taxID = TaxID(
          text = "31324227036",
          kind = TaxIDKind.CPF,
        ),
      ),
      value = 100,
      dayGenerateCharge = 5,
    )

    runBlocking {
      val response = withContext(Dispatchers.IO) {
        client.getSubscription("dummy")
      }

      assertThat(response).isEqualTo(SubscriptionResponseBody(subscription = subscription))
    }
  }

  @Test
  fun `test create subscription`() {
    val engine = MockEngine {
      respond(
        content = ByteReadChannel(
          """
          {
            "subscription": {
              "globalID": "UGF5bWVudFN1YnNjcmlwdGlvbjo2M2UzYjJiNzczZDNkOTNiY2RkMzI5OTM=",
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
              "dayGenerateCharge": 5
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
    val subscription = Subscription(
      globalID = "UGF5bWVudFN1YnNjcmlwdGlvbjo2M2UzYjJiNzczZDNkOTNiY2RkMzI5OTM=",
      customer = Customer(
        name = "Dan",
        email = "email0@example.com",
        phone = "5511999999999",
        taxID = TaxID(
          text = "31324227036",
          kind = TaxIDKind.CPF,
        ),
      ),
      value = 100,
      dayGenerateCharge = 5,
    )

    runBlocking {
      val response = withContext(Dispatchers.IO) {
        client.createSubscription {
          customer = CustomerRequest()
          value = 100
        }
      }

      assertThat(response).isEqualTo(SubscriptionResponseBody(subscription = subscription))
    }
  }
}
