package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject

@Serializable
public data class Charge (
  public val customer: Customer? = null,
  public val value: Long,
  public val identifier: String,
  public val correlationID: String,
  public val paymentLinkID: String,
  public val transactionID: String,
  public val status: String,
  public val additionalInfo: JsonArray,
  public val discount: Long,
  public val valueWithDiscount: Long,
  public val expiresDate: String,
  public val type: String,
  public val createdAt: String,
  public val updatedAt: String,
  public val brCode: String,
  public val expiresIn: Long,
  public val pixKey: String,
  public val paymentLinkUrl: String,
  public val qrCodeImage: String,
  public val globalID: String,
)

@Serializable
public data class ChargeResponse(
  public val correlationID: String? = null,
  public val brCode: String? = null,
  public val charge: Charge,
)

@Serializable
public data class ChargeDeleteResponse(
  public val id: String,
  public val status: String,
)

@Serializable
public data class ChargeRequestBody(
  public val correlationID: String,
  public val value: Int,
  public val comment: String? = null,
  public val customer: Customer? = null,
  public val additionalInfos: List<AdditionalInfo>? = null,
)

@Serializable
public data class AdditionalInfo(
  public val key: String,
  public val value: String,
)

@Serializable
public data class Customer(
  public val name: String,
  public val taxID: String? = null,
  public val email: String,
  public val phone: String,
  public val address: Address? = null,
)

@Serializable
public data class Address(
  public val zipcode: String,
  public val street: String,
  public val number: String,
  public val neighborhood: String,
  public val city: String,
  public val state: String,
  public val complement: String,
  public val country: String,
)

public class ChargeBuilder internal constructor() {
  public var correlationID: String by Properties.required()
  public var value: Int by Properties.required()
  public var comment: String? by Properties.nullable()
  public var customer: Customer? by Properties.nullable()
  public var additionalInfo: List<AdditionalInfo> = emptyList()

  internal fun build(): ChargeRequestBody {
    return ChargeRequestBody(correlationID, value, comment, customer, additionalInfo)
  }
}

public suspend fun WooviSDK.deleteCharge(id: String): ChargeDeleteResponse {
  return client.delete("/api/v1/charge/$id").body<ChargeDeleteResponse>()
}

public suspend fun WooviSDK.getCharge(id: String): ChargeResponse {
  return client.get("/api/v1/charge/$id").body<ChargeResponse>()
}

public suspend fun WooviSDK.createCharge(builder: ChargeBuilder.() -> Unit): ChargeResponse {
  return client
    .post("/api/v1/charge") { setBody(ChargeBuilder().apply(builder).build()) }
    .body<ChargeResponse>()
}
