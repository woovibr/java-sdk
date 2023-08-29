@file:JvmName("Subscriptions")

package com.openpix.sdk

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
  public val globalID: String? = null,
  public val customer: Customer,
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

  /**
   * The customer of the subscription.
   *
   * @param customer The customer of the subscription.
   */
  public fun customer(customer: CustomerRequest): SubscriptionBuilder = apply {
    this.customer = customer
  }

  /**
   * The value of the subscription.
   *
   * @param value The value of the subscription.
   */
  public fun value(value: Int): SubscriptionBuilder = apply {
    this.value = value
  }

  /**
   * The day generate charge of the subscription.
   *
   * @param dayGenerateCharge The day generate charge of the subscription.
   */
  public fun dayGenerateCharge(dayGenerateCharge: Int): SubscriptionBuilder = apply {
    this.dayGenerateCharge = dayGenerateCharge
  }

  /**
   * The charge type of the subscription.
   *
   * @param chargeType The charge type of the subscription.
   */
  public fun chargeType(chargeType: ChargeType): SubscriptionBuilder = apply {
    this.chargeType = chargeType
  }

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
public suspend fun WooviSDK.createSubscription(
  value: SubscriptionBuilder = SubscriptionBuilder(),
  builder: SubscriptionBuilder.() -> Unit
): SubscriptionResponseBody {
  return client
    .post("/api/v1/subscriptions") { setBody(value.apply(builder).build()) }
    .body<SubscriptionResponseBody>()
}
