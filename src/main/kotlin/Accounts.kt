package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable

@Serializable
public data class Balance(
  public val total: Int,
  public val blocked: Int,
  public val available: Int,
)

@Serializable
public data class Account(
  public val accountId: String,
  public val isDefault: Boolean,
  public val balance: Balance,
)

@Serializable
public data class AccountList(public val accounts: List<Account>) : List<Account> by accounts

public suspend fun WooviSdk.accountById(id: String): Account {
  return client.get("api/v1/account/{$id}").body<Account>()
}

public suspend fun WooviSdk.allAccounts(): AccountList {
  return client.get("api/v1/account").body<AccountList>()
}
