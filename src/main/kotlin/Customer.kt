@file:JvmName("Customers")

package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Address @JvmOverloads public constructor(
  public val zipcode: String? = null,
  public val street: String? = null,
  public val number: String? = null,
  public val neighborhood: String? = null,
  public val city: String? = null,
  public val state: String? = null,
  public val complement: String? = null,
  public val country: String? = null,
)

@Serializable
public data class Customer @JvmOverloads public constructor(
  public val name: String? = null,
  public val taxID: TaxID? = null,
  public val email: String? = null,
  public val phone: String? = null,
  public val correlationID: String? = null,
  public val address: Address? = null,
)

@Serializable
public data class CustomerResponse(
  public val customer: Customer,
)

@Serializable
public data class CustomerListResponse(
  @SerialName("customers")
  public override var items: List<Customer>,
  public override var pageInfo: PageInfo,
) : PageInstance<Customer>

@Serializable
public data class CustomerRequest @JvmOverloads public constructor(
  public val name: String? = null,
  public val taxID: String? = null,
  public val email: String? = null,
  public val phone: String? = null,
  public val correlationID: String? = null,
  public val address: Address? = null,
)

public class CustomerBuilder internal constructor() {
  public var name: String by Properties.required()
  public var taxID: String by Properties.required()
  public var email: String? by Properties.nullable()
  public var phone: String? by Properties.nullable()
  public var correlationID: String? by Properties.nullable()
  public var address: Address? by Properties.nullable()

  /**
   * The customer's name.
   *
   * @param name The customer's name.
   */
  public fun name(name: String): CustomerBuilder = apply {
    this.name = name
  }

  /**
   * The customer's tax id.
   *
   * @param taxID The customer's tax id.
   */
  public fun taxID(taxID: String): CustomerBuilder = apply {
    this.taxID = taxID
  }

  /**
   * The customer's email.
   *
   * @param email The customer's email.
   */
  public fun email(email: String): CustomerBuilder = apply {
    this.email = email
  }

  /**
   * The customer's phone.
   *
   * @param phone The customer's phone.
   */
  public fun phone(phone: String): CustomerBuilder = apply {
    this.phone = phone
  }

  /**
   * The customer's correlation id.
   *
   * @param correlationID The customer's correlation id.
   */
  public fun correlationID(correlationID: String): CustomerBuilder = apply {
    this.correlationID = correlationID
  }

  /**
   * The customer's address.
   *
   * @param address The customer's address.
   */
  public fun address(address: Address): CustomerBuilder = apply {
    this.address = address
  }

  @JvmSynthetic
  internal fun build(): CustomerRequest {
    return CustomerRequest(name, taxID, email, phone, correlationID, address)
  }
}

@JvmSynthetic
public suspend fun WooviSDK.getCustomer(id: String): Customer {
  return client.get("/api/v1/customer/{$id}").body<Customer>()
}

@JvmSynthetic
public suspend fun WooviSDK.allCustomers(): CustomerListResponse {
  return client.get("/api/v1/customer").body<CustomerListResponse>()
}

@JvmSynthetic
public suspend fun WooviSDK.createCustomer(
  value: CustomerBuilder,
  builder: CustomerBuilder.() -> Unit,
): CustomerResponse {
  return client
    .post("/api/v1/customer") { setBody(value.apply(builder).build()) }
    .body<CustomerResponse>()
}
