@file:JvmName("Refunds")

package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable

@Serializable
public data class Refund(
  public val value: Int,
  public val status: RefundStatus,
  public val correlationID: String,
  public val refundId: String,
  public val time: String,
  public val comment: String? = null,
)

@Serializable
public enum class RefundStatus {
  IN_PROCESSING,
  REFUNDED,
  CONFIRMED,
  NOT_ACCOMPLISHED,
}

@Serializable
public data class RefundResponse(public val refund: Refund)

@Serializable
public data class RefundListResponse(
  public val refunds: List<Refund>,
  public val pageInfo: PageInfo,
)

@Serializable
public data class RefundRequestBody(
  public val correlationID: String,
  public val value: Int,
  public val transactionEndToEndId: String,
  public val comment: String? = null,
)

public class RefundBuilder internal constructor() {
  public var correlationID: String by Properties.required()
  public var value: Int by Properties.required()
  public var transactionEndToEndId: String by Properties.required()
  public var comment: String? by Properties.nullable()

  @JvmSynthetic
  internal fun build(): RefundRequestBody {
    return RefundRequestBody(correlationID, value, transactionEndToEndId, comment)
  }
}

@JvmSynthetic
public suspend fun WooviSDK.getRefund(id: String): RefundResponse {
  return client.get("/api/v1/refund/$id").body<RefundResponse>()
}

@JvmSynthetic
public suspend fun WooviSDK.allRefunds(): RefundListResponse {
  return client.get("/api/v1/refund").body<RefundListResponse>()
}

@JvmSynthetic
public suspend fun WooviSDK.createRefund(
  value: RefundBuilder = RefundBuilder(),
  builder: RefundBuilder.() -> Unit,
): RefundResponse {
  return client
    .post("/api/v1/refund") { setBody(value.apply(builder).build()) }
    .body<RefundResponse>()
}
