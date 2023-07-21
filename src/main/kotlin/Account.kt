@file:JvmName("Accounts")

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
public data class WithdrawRequest(
  public val value: Int,
)

@Serializable
public data class WithdrawResponse(
  public val withdraw: Withdraw,
)

@Serializable
public data class Withdraw(
  public val account: Account,
  public val transaction: WithdrawTransaction,
)

@Serializable
public data class WithdrawTransaction(
  public val endToEndId: String,
  public val value: Int,
)

@Serializable
public data class AccountListResponse(public val accounts: List<Account>) : List<Account> by accounts

@JvmSynthetic
public suspend fun WooviSDK.getAccount(id: String): Account {
  return client.get("/api/v1/account/{$id}").body<Account>()
}

@JvmSynthetic
public suspend fun WooviSDK.allAccounts(): AccountListResponse {
  return client.get("/api/v1/account").body<AccountListResponse>()
}

@JvmSynthetic
public suspend fun WooviSDK.withdraw(id: String, value: Int): WithdrawResponse {
  return client
    .post("/api/v1/account/$id/withdraw") { setBody(WithdrawRequest(value)) }
    .body<WithdrawResponse>()
}
