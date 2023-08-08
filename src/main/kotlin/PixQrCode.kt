@file:JvmName("PixQrCodes")

package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.SerialName
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
  @SerialName("pixQrCodes")
  public override var items: List<PixQrCode> = emptyList(),
  public override var pageInfo: PageInfo,
) : PageInstance<PixQrCode>

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
  public var name: String by Properties.required()
  public var correlationID: String? by Properties.nullable()
  public var value: Int? by Properties.nullable()
  public var comment: String? by Properties.nullable()
  public var identifier: String by Properties.required()

  /**
   * The name of the pix qr code.
   *
   * @param name The name of the pix qr code.
   */
  public fun name(name: String): PixQrCodeBuilder = apply {
    this.name = name
  }

  /**
   * The correlation id of the pix qr code.
   *
   * @param correlationID The correlation id of the pix qr code.
   */
  public fun correlationID(correlationID: String): PixQrCodeBuilder = apply {
    this.correlationID = correlationID
  }

  /**
   * The value of the pix qr code.
   *
   * @param value The value of the pix qr code.
   */
  public fun value(value: Int): PixQrCodeBuilder = apply {
    this.value = value
  }

  /**
   * The comment of the pix qr code.
   *
   * @param comment The comment of the pix qr code.
   */
  public fun comment(comment: String): PixQrCodeBuilder = apply {
    this.comment = comment
  }

  /**
   * The identifier of the pix qr code.
   *
   * @param identifier The identifier of the pix qr code.
   */
  public fun identifier(identifier: String): PixQrCodeBuilder = apply {
    this.identifier = identifier
  }

  @JvmSynthetic
  internal fun build(): PixQrCodeRequestBody {
    return PixQrCodeRequestBody(name, correlationID, value, comment, identifier)
  }
}

@JvmSynthetic
public suspend fun WooviSDK.getPixQrCode(id: String): PixQrCodeResponse {
  return client.get("/api/v1/qrcode-static/$id").body<PixQrCodeResponse>()
}

@JvmSynthetic
public suspend fun WooviSDK.allPixQrCodes(): PixQrCodeList {
  return client.get("/api/v1/qrcode-static").body<PixQrCodeList>()
}

@JvmSynthetic
public suspend fun WooviSDK.createPixQrCode(
  value: PixQrCodeBuilder = PixQrCodeBuilder(),
  builder: PixQrCodeBuilder.() -> Unit,
): PixQrCodeResponse {
  return client
    .post("/api/v1/qrcode-static/") { setBody(value.apply(builder).build()) }
    .body<PixQrCodeResponse>()
}
