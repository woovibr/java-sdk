package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable

@Serializable
public data class SubscriptionRequestBody @JvmOverloads public constructor(
  public val customer: CustomerRequest,
  public val value: Int,
  public val dayGenerateCharge: Int? = null,
  public val chargeType: ChargeType? = null,
)

@Serializable
public data class Subscription @JvmOverloads public constructor(
  public val customer: CustomerRequest,
  public val value: Int,
  public val dayGenerateCharge: Int? = null,
)

@Serializable
public data class SubscriptionResponseBody(
  public val subscription: Subscription,
)

public class SubscriptionBuilder internal constructor() {
  public var customer: CustomerRequest by Properties.required()
  public var value: Int by Properties.required()
  public var dayGenerateCharge: Int? by Properties.nullable()
  public var chargeType: ChargeType? by Properties.nullable()

  internal fun build(): SubscriptionRequestBody {
    return SubscriptionRequestBody(
      customer,
      value,
      dayGenerateCharge,
      chargeType,
    )
  }
}

@JvmSynthetic
public suspend fun WooviSDK.getSubscription(id: String): SubscriptionResponseBody {
  return client.get("/api/v1/subscriptions/$id").body<SubscriptionResponseBody>()
}

@JvmSynthetic
public suspend fun WooviSDK.createSubscription(builder: SubscriptionBuilder.() -> Unit): SubscriptionResponseBody {
  return client
    .post("/api/v1/subscriptions") { setBody(SubscriptionBuilder().apply(builder).build()) }
    .body<SubscriptionResponseBody>()
}
