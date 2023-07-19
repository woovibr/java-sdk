package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
public data class Charge(
  public val status: String,
  public val value: Int,
  public val paymentLinkID: String,
  public val paymentLinkUrl: String,
  public val correlationID: String,
  public val brCode: String,
  public val qrCodeImage: String,
  public val expiresIn: Long,
  public val expiresDate: String, // kotlinx.date
  public val createdAt: String, // kotlinx.date
  public val updatedAt: String, // kotlinx.date
  public val customer: Customer,
  public val additionalInfos: List<AdditionalInfo>,
)

@Serializable
public data class ChargeResponse(
  public val correlationID: String,
  public val brCode: String,
  public val charge: Charge,
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
  public var correlationID: String? = null
  public var value: Int? = null
  public var comment: String? = null
  public var customer: Customer? = null
  public var additionalInfo: List<AdditionalInfo>? = null

  internal fun build(): ChargeRequestBody {
    return ChargeRequestBody(
      correlationID!!,
      value!!,
      comment,
      customer,
      additionalInfo,
    )
  }
}

public suspend fun WooviSDK.deleteCharge(id: String): JsonObject {
  return client.delete("/api/v1/charge/${id}").body<JsonObject>()
}

//public suspend fun WooviSDK.getChargeList(id: String): Account {
//  return client.get("/api/v1/charge?start=${start}&end=${end}&status=${status}").body<Account>()
//}

public suspend fun WooviSDK.getCharge(id: String): JsonObject {
  return client.get("/api/v1/charge/${id}").body<JsonObject>()
}

public suspend fun WooviSDK.createCharge(builder: ChargeBuilder.() -> Unit): JsonObject {
  return client
    .post("/api/v1/charge") { setBody(ChargeBuilder().apply(builder).build()) }
    .body<JsonObject>()
}

//public suspend fun WooviSDK.getQrCodeImageFromCharge(id: String, size: String? = null): JsonObject {
//  if (!size.toBoolean()) {
//    return client.get("/openpix/charge/brcode/image/${id}.png?size=1024")
//  }
//
//  return client.get("/openpix/charge/brcode/image/${id}.png?size=${size}")
//}
