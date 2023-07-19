package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
public data class PixQrCodeRequestBody(
  public val name: String,
  public val correlationID: String? = null,
  public val value: Int? = null,
  public val comment: String? = null,
  public val identifier: String,
)

@Serializable
public data class PixQrCodeResponse(
  public val pixQrCode: PixQrCode,
  public val correlationID: String? = null,
  public val brCode: String? = null,
)

@Serializable
public data class PixQrCodeList(
  public val pixQrCodes: List<PixQrCode> = emptyList(),
)

@Serializable
public data class PixQrCode(
  public val name: String,
  public val identifier: String,
  public val correlationID: String,
  public val paymentLinkID: String,
  public val createdAt: String,
  public val updatedAt: String,
  public val brCode: String,
  public val paymentLinkUrl: String,
  public val qrCodeImage: String,
)

public class PixQrCodeBuilder internal constructor() {
  public var name: String? = null
  public var correlationID: String? = null
  public var value: Int? = null
  public var comment: String? = null
  public var identifier: String? = null

  internal fun build(): PixQrCodeRequestBody {
    return PixQrCodeRequestBody(
      name!!,
      correlationID,
      value,
      comment,
      identifier!!,
    )
  }
}

public suspend fun WooviSDK.getPixQrCode(id: String): PixQrCodeResponse {
  return client.get("/api/v1/qrcode-static/$id").body<PixQrCodeResponse>()
}

public suspend fun WooviSDK.allPixQrCodes(): PixQrCodeList {
  return client.get("/api/v1/qrcode-static").body<PixQrCodeList>()
}

public suspend fun WooviSDK.createPixQrCode(builder: PixQrCodeBuilder.() -> Unit): PixQrCodeResponse {
  return client
    .post("/api/v1/qrcode-static/") { setBody(PixQrCodeBuilder().apply(builder).build()) }
    .body<PixQrCodeResponse>()
}
