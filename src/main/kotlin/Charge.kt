@file:JvmName("Charges")

package com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.cio.*
import io.ktor.utils.io.*
import java.io.File
import java.util.function.Consumer
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class Charge @JvmOverloads public constructor(
  public val customer: CustomerOrId? = null,
  public val value: Long,
  public val identifier: String? = null,
  public val correlationID: String,
  public val paymentLinkID: String,
  public val transactionID: String? = null,
  public val status: String,
  public val additionalInfo: List<AdditionalInfo>,
  public val discount: Long? = null,
  public val valueWithDiscount: Long? = null,
  public val expiresDate: String,
  public val type: String? = null,
  public val createdAt: String,
  public val updatedAt: String,
  public val brCode: String? = null,
  public val expiresIn: Long,
  public val pixKey: String? = null,
  public val paymentLinkUrl: String,
  public val qrCodeImage: String,
  public val globalID: String,
)

@Serializable(with = CustomerOrId.CustomerOrIdSerializer::class)
public sealed class CustomerOrId {
  public data class Id(public val value: String) : CustomerOrId()
  public data class IsCustomer(public val value: Customer) : CustomerOrId()

  public fun isId(): Boolean {
    return this is Id
  }

  public fun isCustomer(): Boolean {
    return this is Id
  }

  public fun unwrapId(): String {
    return when (this) {
      is Id -> value
      is IsCustomer -> error("Expected Id, got Customer")
    }
  }

  public fun unwrapCustomer(): Customer {
    return when (this) {
      is Id -> error("Expected Customer, got Id")
      is IsCustomer -> value
    }
  }

  public fun foldVoid(ifId: Consumer<String>, ifCustomer: Consumer<Customer>) {
    return when (this) {
      is Id -> ifId.accept(value)
      is IsCustomer -> ifCustomer.accept(value)
    }
  }

  public fun <T> fold(ifId: (String) -> T, ifCustomer: (Customer) -> T): T {
    return when (this) {
      is Id -> ifId(value)
      is IsCustomer -> ifCustomer(value)
    }
  }

  internal object CustomerOrIdSerializer : KSerializer<CustomerOrId> {
    override val descriptor: SerialDescriptor = Customer.serializer().descriptor

    override fun deserialize(decoder: Decoder): CustomerOrId {
      return runCatching {
        Id(decoder.decodeString())
      }.getOrElse {
        IsCustomer(decoder.decodeSerializableValue(Customer.serializer()))
      }
    }

    override fun serialize(encoder: Encoder, value: CustomerOrId) {
      when (value) {
        is Id -> encoder.encodeString(value.value)
        is IsCustomer -> encoder.encodeSerializableValue(Customer.serializer(), value.value)
      }
    }
  }
}

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
public enum class ChargeDiscountModality {
  FIXED_VALUE_UNTIL_SPECIFIED_DATE,
  PERCENTAGE_UNTIL_SPECIFIED_DATE,
}

@Serializable
public data class ChargeDiscountFixedDate(
  public val daysActive: Int,
  public val value: Int,
)

@Serializable
public data class ChargeDiscountSettings(
  public val discountModality: ChargeDiscountModality,
  public val discountFixedDate: List<ChargeDiscountFixedDate>,
)

@Serializable
public data class ChargeResponse @JvmOverloads public constructor(
  public val correlationID: String? = null,
  public val brCode: String? = null,
  public val charge: Charge,
)

@Serializable
public data class ChargeListResponse(
  @SerialName("charges")
  public override var items: List<Charge>,
  public override var pageInfo: PageInfo,
) : PageInstance<Charge>

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
  public val type: ChargeType? = null,
  public val expiresDate: String? = null,
  public val discountSettings: ChargeDiscountSettings? = null,
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
  public var type: ChargeType? by Properties.nullable()
  public var expiresDate: String? by Properties.nullable()
  public var discountSettings: ChargeDiscountSettings? by Properties.nullable()

  /**
   * The correlation ID is a unique identifier for each request. It is useful for tracking a request through the system.
   *
   * @param correlationID The correlation ID
   */
  public fun correlationID(correlationID: String): ChargeBuilder = apply {
    this.correlationID = correlationID
  }

  /**
   * The value of the charge in cents.
   *
   * @param value The value of the charge in cents
   */
  public fun value(value: Int): ChargeBuilder = apply {
    this.value = value
  }

  /**
   * The comment of the charge.
   *
   * @param comment The comment of the charge
   */
  public fun comment(comment: String): ChargeBuilder = apply {
    this.comment = comment
  }

  /**
   * The customer of the charge.
   *
   * @param customer The customer of the charge.
   */
  public fun customer(customer: CustomerRequest): ChargeBuilder = apply {
    this.customer = customer
  }

  /**
   * The customer information.
   *
   * @param customer The customer information
   */
  public fun customer(customer: CustomerBuilder): ChargeBuilder = apply {
    this.customer = customer.build()
  }

  /**
   * The expiration date of the charge in days.
   *
   * @param expiresIn The expiration date of the charge in days
   */
  public fun expiresIn(expiresIn: Int): ChargeBuilder = apply {
    this.expiresIn = expiresIn
  }

  /**
   * The days for overdue.
   *
   * @param daysForOverdue The days for overdue
   */
  public fun daysForOverdue(daysForOverdue: Int): ChargeBuilder = apply {
    this.daysForOverdue = daysForOverdue
  }

  /**
   * The days after due date.
   *
   * @param daysAfterDueDate The days after due date
   */
  public fun daysAfterDueDate(daysAfterDueDate: Int): ChargeBuilder = apply {
    this.daysAfterDueDate = daysAfterDueDate
  }

  /**
   * The interests value in cents.
   *
   * @param interests The interests value in cents
   */
  public fun interests(interests: Int): ChargeBuilder = apply {
    this.interests = Interests(interests)
  }

  /**
   * The fines value in cents.
   *
   * @param fines The fines value in cents
   */
  public fun fines(fines: Int): ChargeBuilder = apply {
    this.fines = Fines(fines)
  }

  /**
   * Adds an info.
   *
   * @param key The key of the additional info
   * @param value The value of the additional info
   */
  public fun additionalInfo(key: String, value: String): ChargeBuilder = apply {
    additionalInfo = additionalInfo + AdditionalInfo(key, value)
  }

  /**
   * Type of the charge
   *
   * @param type Type of the charge
   */
  public fun type(type: ChargeType): ChargeBuilder = apply {
    this.type = type
  }

  /**
   * Expiration date of the charge
   *
   * @param expiresDate Expiration date of the charge
   */
  public fun expiresDate(expiresDate: String): ChargeBuilder = apply {
    this.expiresDate = expiresDate
  }

  /**
   * Discount settings of the charge
   *
   * @param discountSettings Discount settings of the charge
   */
  public fun discountSettings(discountSettings: ChargeDiscountSettings): ChargeBuilder = apply {
    this.discountSettings = discountSettings
  }

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
      type,
      expiresDate,
      discountSettings,
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
