@file:JvmName("Webhooks")

package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import java.net.URI
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class WebhookPayload(
  public val name: Int?,
  public val url: String?,
  public val authorization: String?,
  public val isActive: Boolean?,

  /**
   * Available events to register a webhook to listen to. If no one selected anyone the default event will be
   * `OPENPIX:TRANSACTION_RECEIVED`.
   */
  public val event: WebhookEvent = WebhookEvent.TransactionReceived,
)

@Serializable
public data class Webhook(
  public val id: String,
  public val name: String,
  public val url: String? = null,
  public val authorization: String? = null,
  public val isActive: Boolean,
  public val createdAt: String? = null,
  public val updatedAt: String? = null,

  /**
   * Available events to register a webhook to listen to. If no one selected anyone the default event will be
   * `OPENPIX:TRANSACTION_RECEIVED`.
   */
  public val event: WebhookEvent = WebhookEvent.TransactionReceived,
)

@Serializable
public data class WebhookDeleteResponse(public val status: String)

@Serializable
public data class WebhookRequest(public val webhook: WebhookPayload)

@Serializable
public data class WebhookResponse(public val webhook: Webhook)

@Serializable
public data class WebhookListResponse(
  public val webhooks: List<Webhook>,
  public val pageInfo: PageInfo,
)

@Serializable
public enum class WebhookEvent {
  /**
   * New charge created
   */
  @SerialName("OPENPIX:CHARGE_CREATED")
  ChargeCreated,

  /**
   * Charge completed is when a charge is fully paid
   */
  @SerialName("OPENPIX:CHARGE_COMPLETED")
  ChargeCompleted,

  /**
   * Charge expired is when a charge is not fully paid and expired
   */
  @SerialName("OPENPIX:CHARGE_EXPIRED")
  ChargeExpired,

  /**
   * New PIX transaction received
   */
  @SerialName("OPENPIX:TRANSACTION_RECEIVED")
  TransactionReceived,

  /**
   * New PIX transaction refund received or refunded
   */
  @SerialName("OPENPIX:TRANSACTION_REFUND_RECEIVED ")
  TransactionRefundReceived,

  /**
   * Payment confirmed is when the pix transaction related to the payment gets confirmed
   */
  @SerialName("OPENPIX:MOVEMENT_CONFIRMED")
  MovementConfirmed,

  /**
   * Payment failed is when the payment gets approved and a error occurs
   */
  @SerialName("OPENPIX:MOVEMENT_FAILED")
  MovementFailed,

  /**
   * Payment was removed by user
   */
  @SerialName("OPENPIX:MOVEMENT_REMOVED")
  MovementRemoved,
}

public class WebhookBuilder internal constructor() {
  public var number: Int? by Properties.nullable()
  public var url: String? by Properties.nullable()
  public var authorization: String? by Properties.nullable()
  public var isActive: Boolean? by Properties.nullable()
  public var event: WebhookEvent? by Properties.nullable()

  /**
   * The number of the webhook.
   *
   * @param number The number of the webhook.
   */
  public fun number(number: Int): WebhookBuilder = apply {
    this.number = number
  }

  /**
   * The url of the webhook.
   *
   * @param url The url of the webhook.
   */
  public fun url(url: String): WebhookBuilder = apply {
    this.url = url
  }

  /**
   * The url of the webhook.
   *
   * @param url The url of the webhook.
   */
  public fun url(url: Url): WebhookBuilder = apply {
    this.url = url.toString()
  }

  /**
   * The url of the webhook.
   *
   * @param uri The url of the webhook.
   */
  public fun uri(uri: URI): WebhookBuilder = apply {
    this.url = uri.toASCIIString()
  }

  /**
   * The authorization of the webhook.
   *
   * @param authorization The authorization of the webhook.
   */
  public fun authorization(authorization: String): WebhookBuilder = apply {
    this.authorization = authorization
  }

  /**
   * The isActive of the webhook.
   *
   * @param isActive The isActive of the webhook.
   */
  public fun isActive(isActive: Boolean): WebhookBuilder = apply {
    this.isActive = isActive
  }

  /**
   * Makes active
   */
  public fun enableWebhook(): WebhookBuilder = apply {
    this.isActive = true
  }

  /**
   * The event of the webhook.
   *
   * @param event The event of the webhook.
   */
  public fun event(event: WebhookEvent): WebhookBuilder = apply {
    this.event = event
  }

  /**
   * Changes the event to charge created.
   */
  public fun onChargeCreated(): WebhookBuilder = apply {
    this.event = WebhookEvent.ChargeCreated
  }

  /**
   * Changes the event to charge completed.
   */
  public fun onChargeCompleted(): WebhookBuilder = apply {
    this.event = WebhookEvent.ChargeCompleted
  }

  /**
   * Changes the event to charge expired.
   */
  public fun onChargeExpired(): WebhookBuilder = apply {
    this.event = WebhookEvent.ChargeExpired
  }

  /**
   * Changes the event to transaction received.
   */
  public fun onTransactionReceived(): WebhookBuilder = apply {
    this.event = WebhookEvent.TransactionReceived
  }

  /**
   * Changes the event to transaction refund received.
   */
  public fun onTransactionRefundReceived(): WebhookBuilder = apply {
    this.event = WebhookEvent.TransactionRefundReceived
  }

  /**
   * Changes the event to movement confirmed.
   */
  public fun onMovementConfirmed(): WebhookBuilder = apply {
    this.event = WebhookEvent.MovementConfirmed
  }

  /**
   * Changes the event to movement failed.
   */
  public fun onMovementFailed(): WebhookBuilder = apply {
    this.event = WebhookEvent.MovementFailed
  }

  /**
   * Changes the event to movement removed.
   */
  public fun onMovementRemoved(): WebhookBuilder = apply {
    this.event = WebhookEvent.MovementRemoved
  }

  @JvmSynthetic
  internal fun build(): WebhookRequest {
    return WebhookRequest(
      webhook = WebhookPayload(
        name = number,
        url = url,
        authorization = authorization,
        isActive = isActive,
        event = event ?: WebhookEvent.TransactionReceived,
      ),
    )
  }
}

@JvmSynthetic
public suspend fun WooviSDK.allWebhooks(url: String? = null): WebhookListResponse {
  return client
    .get("/api/v1/webhook") {
      url?.let { parameter("url", it) }
    }
    .body<WebhookListResponse>()
}

@JvmSynthetic
public suspend fun WooviSDK.deleteWebhook(id: String): WebhookDeleteResponse {
  return client.delete("/api/v1/webhook/$id").body<WebhookDeleteResponse>()
}

@JvmSynthetic
public suspend fun WooviSDK.createWebhook(
  value: WebhookBuilder = WebhookBuilder(),
  builder: WebhookBuilder.() -> Unit,
): WebhookResponse {
  return client
    .post("/api/v1/webhook") { setBody(value.apply(builder).build()) }
    .body<WebhookResponse>()
}
