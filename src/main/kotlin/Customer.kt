package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
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
  public val customers: List<Customer>,
  public val pageInfo: PageInfo,
)

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
