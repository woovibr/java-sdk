@file:JvmName("Accounts")

package br.com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable

@Serializable
public data class Balance(
  /** Total amount in cents */
  public val total: Int,

  /** Blocked amount in cents */
  public val blocked: Int,

  /** Available amount in cents */
  public val available: Int,
)

@Serializable
public data class Account(
  /** The id of the account */
  public val accountId: String,

  /** If the account is a default account */
  public val isDefault: Boolean,

  /** The balance of the account */
  public val balance: Balance,
)

@Serializable
public data class WithdrawRequest(
  /** Value in cents */
  public val value: Int,
)

@Serializable
public data class WithdrawResponse(public val withdraw: Withdraw)

/**
 * The withdrawal response.
 *
 * @property account The account that the withdrawal was made
 * @property transaction The transaction of the withdrawal
 */
@Serializable
public data class Withdraw(
  public val account: Account,
  public val transaction: WithdrawTransaction,
)

/**
 * The transaction of the withdrawal.
 *
 * @property endToEndId The end to end id of the transaction
 * @property value The value of the transaction in cents
 */
@Serializable
public data class WithdrawTransaction(
  public val endToEndId: String,
  public val value: Int,
)

/**
 * The response of the account list.
 *
 * @property accounts The list of accounts
 */
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
