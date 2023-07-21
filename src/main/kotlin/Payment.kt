package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlin.text.get
import kotlinx.serialization.Serializable

@Serializable
public data class PaymentListResponse(
  public val status: String? = null,
  public val payments: List<PaymentResponseObject>,
  public val pageInfo: PageInfo,
)

@Serializable
public data class PaymentResponseObject(
  public val payment: Payment,
  public val transaction: PaymentTransaction? = null,
  public val destination: PaymentDestination? = null,
)

@Serializable
public data class Payment(
  public val status: PaymentStatus,
  public val value: Int? = null,
  public val destinationAlias: String? = null,
  public val correlationID: String? = null,
  public val comment: String? = null,
  public val sourceAccountId: String? = null,
)

@Serializable
public data class PaymentTransaction(
  public val value: Int? = null,
  public val endToEndId: String? = null,
  public val time: String? = null,
)

@Serializable
public data class PaymentDestination(
  public val name: String? = null,
  public val taxID: String? = null,
  public val pixKey: String? = null,
  public val bank: String? = null,
  public val branch: String? = null,
  public val account: String? = null,
)

@Serializable
public data class PaymentRequest(
  public val value: Int? = null,
  public val destinationAlias: String? = null,
  public val correlationID: String? = null,
  public val comment: String? = null,
  public val sourceAccountId: String? = null,
)

@Serializable
public enum class PaymentStatus {
  CREATED,
  FAILED,
  CONFIRMED,
  DENIED,
}

public class PaymentBuilder internal constructor() {
  public var value: Int? by Properties.nullable()
  public var destinationAlias: String? by Properties.nullable()
  public var correlationID: String? by Properties.nullable()
  public var comment: String? by Properties.nullable()
  public var sourceAccountId: String? by Properties.nullable()

  @JvmSynthetic
  internal fun build(): PaymentRequest {
    return PaymentRequest(value, destinationAlias, correlationID, comment, sourceAccountId)
  }
}

@JvmSynthetic
public suspend fun WooviSDK.getPayment(id: String): PaymentResponseObject {
  return client.get("/api/v1/payment/$id").body<PaymentResponseObject>()
}

@JvmSynthetic
public suspend fun WooviSDK.allPayments(): PaymentListResponse {
  return client
    .get("/api/v1/payment")
    .body<PaymentListResponse>()
}

@JvmSynthetic
public suspend fun WooviSDK.createPayment(
  value: PaymentBuilder = PaymentBuilder(),
  builder: PaymentBuilder.() -> Unit,
): PaymentResponseObject {
  return client
    .post("/api/v1/payment") { setBody(value.apply(builder).build()) }
    .body<PaymentResponseObject>()
}
