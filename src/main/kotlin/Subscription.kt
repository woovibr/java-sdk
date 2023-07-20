package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable

@Serializable
public data class SubscriptionRequestBody(
  public val customer: CustomerRequest,
  public val value: Int,
  public val dayGenerateCharge: Int? = null,
  public val chargeType: ChargeType? = null,
)

@Serializable
public data class Subscription(
  public val customer: CustomerRequest,
  public val value: Int,
  public val dayGenerateCharge: Int? = null,
)

@Serializable
public data class SubscriptionResponseBody(
  public val subscription: Subscription,
)

public class SubscriptionBuilder internal constructor() {
  private var customer: CustomerRequest by Properties.required()
  private var value: Int by Properties.required()
  private var dayGenerateCharge: Int? by Properties.nullable()
  private var chargeType: ChargeType? by Properties.nullable()

  internal fun build(): SubscriptionRequestBody {
    return SubscriptionRequestBody(
      customer,
      value,
      dayGenerateCharge,
      chargeType,
    )
  }
}

public suspend fun WooviSDK.getSubscription(id: String): SubscriptionResponseBody {
  return client.get("/api/v1/subscriptions/$id").body<SubscriptionResponseBody>()
}

public suspend fun WooviSDK.createSubscription(builder: SubscriptionBuilder.() -> Unit): SubscriptionResponseBody {
  return client
    .post("/api/v1/subscriptions") { setBody(SubscriptionBuilder().apply(builder).build()) }
    .body<SubscriptionResponseBody>()
}
