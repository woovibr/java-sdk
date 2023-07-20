package br.com.openpix.sdk

import kotlinx.serialization.Serializable

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

@Serializable
public data class Customer(
  public val name: String? = null,
  public val taxID: TaxID? = null,
  public val email: String? = null,
  public val phone: String? = null,
  public val correlationID: String? = null,
  public val address: Address? = null,
)

@Serializable
public data class CustomerRequest(
  public val name: String? = null,
  public val taxID: TaxID? = null,
  public val email: String? = null,
  public val phone: String? = null,
  public val correlationID: String? = null,
  public val address: Address? = null,
)
