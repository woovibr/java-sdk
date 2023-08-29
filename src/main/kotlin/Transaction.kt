package com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Transaction @JvmOverloads public constructor(
  public val charge: Charge? = null,
  public val value: Int,
  public val time: String,
  public val payer: Customer? = null,
  public val globalID: String? = null,
  public val pixQrCode: PixQrCode? = null,

  public val withdraw: PixWithdrawTransaction? = null,

  @SerialName("endToEndID")
  public val firstEndToEndId: String? = null,

  @SerialName("endToEndId")
  public val secondEndToEndId: String? = null,

  @SerialName("infoPagador")
  public val infoPayer: String? = null,

  @SerialName("customer")
  public val customer: Customer? = null,

  @SerialName("type")
  public val kind: TransactionKind,
)

@Serializable
public enum class TransactionKind {
  PAYMENT,
  WITHDRAW,
  REFUND,
  FEE,
  GIFTBACK,
}

@Serializable
public data class TransactionListResponse(
  public val status: String,
  @SerialName("transactions")
  public override var items: List<Transaction>,
  public override var pageInfo: PageInfo,
) : PageInstance<Transaction>

@Serializable
public data class TransactionResponse(public val transaction: Transaction)

@Serializable
public data class PixWithdrawTransaction @JvmOverloads public constructor(
  public val value: Int? = null,
  public val time: String? = null,
  public val payer: Customer? = null,

  @SerialName("type")
  public val kind: String,

  @SerialName("infoPagador")
  public val infoPayer: String? = null,

  @SerialName("endToEndID")
  public val firstEndToEndId: String? = null,

  @SerialName("endToEndId")
  public val secondEndToEndId: String? = null,
)

@JvmSynthetic
public suspend fun WooviSDK.getTransaction(id: String): TransactionResponse {
  return client.get("/api/v1/transaction/$id").body<TransactionResponse>()
}

@JvmSynthetic
public suspend fun WooviSDK.transactions(
  /** Start date used in the query. Complies with RFC 3339. */
  start: String? = null,

  /** End date used in the query. Complies with RFC 3339. */
  end: String? = null,

  /**
   * You can use the charge ID or correlation ID or transaction ID of charge to get a list of transactions
   * related of this transaction
   */
  charge: String? = null,

  /**
   * You can use the QrCode static ID or correlation ID or identifier field of QrCode static to get a list
   * of QrCode related of this transaction
   */
  pixQrCode: String? = null,

  /**
   *You can use the ID or EndToEndId of a withdrawal transaction to get all transactions related to the
   * withdrawal
   */
  withdrawal: String? = null,
): TransactionListResponse {
  return client
    .get("/api/v1/transaction") {
      start?.let { parameter("start", it) }
      end?.let { parameter("end", it) }
      charge?.let { parameter("charge", it) }
      pixQrCode?.let { parameter("pixQrCode", it) }
      withdrawal?.let { parameter("withdrawal", it) }
    }
    .body<TransactionListResponse>()
}
