@file:JvmName("Charges")

package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.cio.*
import io.ktor.utils.io.*
import java.io.File
import kotlinx.serialization.Serializable

@Serializable
public data class Charge @JvmOverloads public constructor(
  public val customer: Customer? = null,
  public val value: Long,
  public val identifier: String,
  public val correlationID: String,
  public val paymentLinkID: String,
  public val transactionID: String,
  public val status: String,
  public val additionalInfo: List<AdditionalInfo>,
  public val discount: Long,
  public val valueWithDiscount: Long,
  public val expiresDate: String,
  public val type: String? = null,
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
public enum class ChargeType {
  DYNAMIC,
  OVERDUE,
}

@Serializable
public enum class ChargeStatus {
  ACTIVE,
  COMPLETED,
  EXPIRED,
}

@Serializable
public data class ChargeResponse @JvmOverloads public constructor(
  public val correlationID: String? = null,
  public val brCode: String? = null,
  public val charge: Charge,
)

@Serializable
public data class ChargeListResponse(
  public val charges: List<Charge>,
  public val pageInfo: PageInfo,
)

@Serializable
public data class ChargeDeleteResponse(
  public val id: String,
  public val status: String,
)

@Serializable
public data class ChargeRequestBody @JvmOverloads public constructor(
  public val correlationID: String,
  public val value: Int,
  public val comment: String? = null,
  public val customer: CustomerRequest? = null,
  public val expiresIn: Int? = null,
  public val daysForOverdue: Int? = null,
  public val daysAfterDueDate: Int? = null,
  public val interests: Interests? = null,
  public val fines: Fines? = null,
  public val additionalInfos: List<AdditionalInfo>? = null,
)

@Serializable
public data class AdditionalInfo(
  public val key: String,
  public val value: String,
)

@Serializable
public data class Interests(public val value: Int)

@Serializable
public data class Fines(public val value: Int)

public class ChargeBuilder internal constructor() {
  public var correlationID: String by Properties.required()
  public var value: Int by Properties.required()
  public var comment: String? by Properties.nullable()
  public var customer: CustomerRequest? by Properties.nullable()
  public var expiresIn: Int? by Properties.nullable()
  public var daysForOverdue: Int? by Properties.nullable()
  public var daysAfterDueDate: Int? by Properties.nullable()
  public var interests: Interests? by Properties.nullable()
  public var fines: Fines? by Properties.nullable()
  public var additionalInfo: List<AdditionalInfo> = emptyList()

  @JvmSynthetic
  internal fun build(): ChargeRequestBody {
    return ChargeRequestBody(
      correlationID,
      value,
      comment,
      customer,
      expiresIn,
      daysForOverdue,
      daysAfterDueDate,
      interests,
      fines,
      additionalInfo,
    )
  }
}

@JvmSynthetic
public suspend fun WooviSDK.deleteCharge(id: String): ChargeDeleteResponse {
  return client.delete("/api/v1/charge/$id").body<ChargeDeleteResponse>()
}

@JvmSynthetic
public suspend fun WooviSDK.getCharge(id: String): ChargeResponse {
  return client.get("/api/v1/charge/$id").body<ChargeResponse>()
}

@JvmSynthetic
public suspend fun WooviSDK.charges(
  start: String? = null,
  end: String? = null,
  status: ChargeStatus? = null,
): ChargeListResponse {
  return client
    .get {
      url {
        path("/api/v1/charge")
        start?.let { encodedParameters.append("start", it) }
        end?.let { encodedParameters.append("end", it) }
        status?.let { encodedParameters.append("status", it.name) }
      }
    }
    .body<ChargeListResponse>()
}

public suspend fun WooviSDK.createCharge(
  value: ChargeBuilder = ChargeBuilder(),
  builder: ChargeBuilder.() -> Unit,
): ChargeResponse {
  return client
    .post("/api/v1/charge") { setBody(value.apply(builder).build()) }
    .body<ChargeResponse>()
}

public suspend fun WooviSDK.chargeQrCodeImage(id: String, size: Int = 768): File {
  require(size >= 600) { "The qr code size should be greater than 600" }
  require(size <= 4096) { "The qr code size should be less than 4096" }

  val file = File("$id.png")
  client.get("/openpix/charge/brcode/image/$id.png?size=$size")
    .bodyAsChannel()
    .copyAndClose(file.writeChannel())
  return file
}
