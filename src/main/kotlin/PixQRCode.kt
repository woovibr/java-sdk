package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable

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
  private var name: String by Properties.required()
  private var correlationID: String? by Properties.nullable()
  private var value: Int? by Properties.nullable()
  private var comment: String? by Properties.nullable()
  private var identifier: String by Properties.required()

  internal fun build(): PixQrCodeRequestBody {
    return PixQrCodeRequestBody(name, correlationID, value, comment, identifier)
  }
}

public suspend fun WooviSDK.getPixQrCode(id: String): PixQrCodeResponse {
  return client.get("/api/v1/qrcode-static/$id").body<PixQrCodeResponse>()
}

public suspend fun WooviSDK.allPixQrCodes(): PixQrCodeList {
  return client.get("/api/v1/qrcode-static").body<PixQrCodeList>()
}

public suspend fun WooviSDK.createPixQrCode(
  value: PixQrCodeBuilder = PixQrCodeBuilder(),
  builder: PixQrCodeBuilder.() -> Unit,
): PixQrCodeResponse {
  return client
    .post("/api/v1/qrcode-static/") { setBody(value.apply(builder).build()) }
    .body<PixQrCodeResponse>()
}
