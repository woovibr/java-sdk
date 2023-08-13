@file:OptIn(ExperimentalSerializationApi::class)
@file:JvmName("WooviSDKs")

package br.com.openpix.sdk

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import java.io.File
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.future.future
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.jetbrains.annotations.TestOnly

/**
 * The entrypoint of Woovi SDK for Java, Kotlin and another JVM Languages, it does take an authorization [appId].
 */
public class WooviSDK @JvmOverloads public constructor(
  /** The authorization [appId] of your application. */
  @TestOnly
  @JvmSynthetic
  internal val appId: String,

  /** The base URL of Woovi API. */
  private val baseUrl: String = "https://api.openpix.com.br/",

  /** The [CoroutineContext] of the SDK. */
  public override val coroutineContext: CoroutineContext = Executors.newCachedThreadPool().asCoroutineDispatcher(),

  /** The [Json] instance of the SDK. */
  private var json: Json = createJson(),

  /** The [HttpClient] instance of the SDK. */
  public val client: HttpClient = createDefaultHttpClient(CIO.create { }, appId, baseUrl, json),
) : CoroutineScope {
  /**
   * Returns a charges' paginator with the given [start] and [end] dates.
   *
   * @param start The start date.
   * @param end The end date.
   * @param status The charge status.
   * @param pageSize The page size.
   */
  @JvmOverloads
  public fun charges(
    start: String? = null,
    end: String? = null,
    status: ChargeStatus? = null,
    pageSize: Int = 15,
  ): Paginator<Charge> {
    return Paginator.createPaginator<ChargeListResponse, _>(
      sdk = this,
      endpoint = "/api/v1/charge",
      pageSize = pageSize,
      initialQueries = mapOf("start" to start, "end" to end, "status" to status?.name),
    )
  }

  /**
   * Returns a pix qr codes' paginator with the given [start] and [end] dates.
   *
   * @param start The start date.
   * @param end The end date.
   * @param pageSize The page size.
   */
  @JvmOverloads
  public fun pixQrCodes(
    start: String? = null,
    end: String? = null,
    pageSize: Int = 15,
  ): Paginator<PixQrCode> {
    return Paginator.createPaginator<PixQrCodeList, _>(
      sdk = this,
      endpoint = "/api/v1/qrcode-static",
      pageSize = pageSize,
      initialQueries = mapOf("start" to start, "end" to end),
    )
  }

  /**
   * Returns a payments' paginator with the given [start] and [end] dates.
   *
   * @param start The start date.
   * @param end The end date.
   * @param pageSize The page size.
   */
  @JvmOverloads
  public fun payments(
    start: String? = null,
    end: String? = null,
    pageSize: Int = 15,
  ): Paginator<PaymentResponseObject> {
    return Paginator.createPaginator<PaymentListResponse, _>(
      sdk = this,
      endpoint = "/api/v1/payment",
      pageSize = pageSize,
      initialQueries = mapOf("start" to start, "end" to end),
    )
  }

  /**
   * Returns a refunds' paginator with the given [start] and [end] dates.
   *
   * @param start The start date.
   * @param end The end date.
   * @param pageSize The page size.
   */
  @JvmOverloads
  public fun refunds(
    start: String? = null,
    end: String? = null,
    pageSize: Int = 15,
  ): Paginator<Refund> {
    return Paginator.createPaginator<RefundListResponse, _>(
      sdk = this,
      endpoint = "/api/v1/refund",
      pageSize = pageSize,
      initialQueries = mapOf("start" to start, "end" to end),
    )
  }

  /**
   * Returns a customers' paginator with the given [start] and [end] dates.
   *
   * @param start The start date.
   * @param end The end date.
   * @param pageSize The page size.
   */
  @JvmOverloads
  public fun customers(
    start: String? = null,
    end: String? = null,
    pageSize: Int = 15,
  ): Paginator<Customer> {
    return Paginator.createPaginator<CustomerListResponse, _>(
      sdk = this,
      endpoint = "/api/v1/customer",
      pageSize = pageSize,
      initialQueries = mapOf("start" to start, "end" to end),
    )
  }

  /**
   * Returns a webhooks' paginator with the given [start] and [end] dates.
   *
   * @param start The start date.
   * @param end The end date.
   * @param url The webhook url.
   * @param pageSize The page size.
   */
  @JvmOverloads
  public fun webhooks(
    start: String? = null,
    end: String? = null,
    url: String? = null,
    pageSize: Int = 15,
  ): Paginator<Webhook> {
    return Paginator.createPaginator<WebhookListResponse, _>(
      sdk = this,
      endpoint = "/api/v1/webhook",
      pageSize = pageSize,
      initialQueries = mapOf("start" to start, "end" to end, "url" to url),
    )
  }

  /**
   * Returns a transactions' paginator with the given [start] and [end] dates.
   *
   * @param start Start date used in the query. Complies with RFC 3339.
   * @param end End date used in the query. Complies with RFC 3339.
   * @param charge You can use the charge ID or correlation ID or transaction ID of charge to get a list
   *  of transactions related of this transaction
   * @param pixQrCode You can use the QrCode static ID or correlation ID or identifier field of QrCode
   *  static to get a list of QrCode related of this transaction
   * @param withdrawal You can use the ID or EndToEndId of a withdrawal transaction to get all transactions
   *  related to the withdrawal
   * @return The transaction list response.
   */
  @JvmOverloads
  @Suppress("LongParameterList")
  public fun transactions(
    /** Start date used in the query. Complies with RFC 3339. */
    start: String? = null,

    /** End date used in the query. Complies with RFC 3339. */
    end: String? = null,

    /**
     * You can use the charge ID or correlation ID or transaction ID of charge to get a list of transactions
     * related of this transaction
     */
    charge: String? = null,

    /**
     * You can use the QrCode static ID or correlation ID or identifier field of QrCode static to get a list
     * of QrCode related of this transaction
     */
    pixQrCode: String? = null,

    /**
     *You can use the ID or EndToEndId of a withdrawal transaction to get all transactions related to the
     * withdrawal
     */
    withdrawal: String? = null,

    /**
     * The page size.
     */
    pageSize: Int = 15,
  ): Paginator<Transaction> {
    return Paginator.createPaginator<TransactionListResponse, _>(
      sdk = this,
      endpoint = "/api/v1/transaction",
      pageSize = pageSize,
      initialQueries = mapOf(
        "start" to start,
        "end" to end,
        "charge" to charge,
        "pixQrCode" to pixQrCode,
        "withdrawal" to withdrawal,
      ),
    )
  }

  /**
   * Returns a pix qr code.
   *
   * @param id The pix qr code id.
   * @return The pix qr code response.
   */
  public fun getPixQrCodeAsync(id: String): Future<PixQrCodeResponse> = future {
    getPixQrCode(id)
  }

  /**
   * Returns all pix qr codes.
   *
   * @return The pix qr code list.
   */
  public fun allPixQrCodesAsync(): Future<PixQrCodeList> = future {
    allPixQrCodes()
  }

  /**
   * Creates a pix qr code.
   *
   * @param builder The pix qr code builder.
   * @return The pix qr code response.
   */
  public fun createPixQrCodeAsync(builder: PixQrCodeBuilder): Future<PixQrCodeResponse> = future {
    createPixQrCode(builder) {}
  }

  /**
   * Returns an account.
   *
   * @param id The account id.
   * @return The account response.
   */
  public fun getAccountAsync(id: String): Future<AccountResponse> = future {
    getAccount(id)
  }

  /**
   * Returns all accounts.
   *
   * @return The account list response.
   */
  public fun allAccountsAsync(): Future<AccountListResponse> = future {
    allAccounts()
  }

  /**
   * Withdraws a value [value] from an account with id [id].
   *
   * @param id The account id.
   * @param value The value to withdraw.
   * @return The withdraw response.
   */
  public fun withdrawAsync(id: String, value: Int): Future<WithdrawResponse> = future {
    withdraw(id, value)
  }

  /**
   * Returns a payment.
   *
   * @param id The payment id.
   * @return The payment response.
   */
  public fun getPaymentAsync(id: String): Future<PaymentResponseObject> = future {
    getPayment(id)
  }

  /**
   * Returns all payments.
   *
   * @return The payment list response.
   */
  public fun allPaymentsAsync(): Future<PaymentListResponse> = future {
    allPayments()
  }

  /**
   * Creates a payment.
   *
   * @param builder The payment builder.
   * @return The payment response.
   */
  public fun createPaymentAsync(builder: PaymentBuilder): Future<PaymentResponseObject> = future {
    createPayment(builder) {}
  }

  /**
   * Deletes a charge.
   *
   * @param id The charge id.
   * @return The charge delete response.
   */
  public fun deleteChargeAsync(id: String): Future<ChargeDeleteResponse> = future {
    deleteCharge(id)
  }

  /**
   * Returns a charge.
   *
   * @param id The charge id.
   * @return The charge response.
   */
  public fun getChargeAsync(id: String): Future<ChargeResponse> = future {
    getCharge(id)
  }

  /**
   * Creates a new charge.
   *
   * @param builder The charge builder.
   * @return The charge response.
   */
  public fun createChargeAsync(builder: ChargeBuilder): Future<ChargeResponse> = future {
    createCharge(builder) {}
  }

  /**
   * Returns a charge QR code image.
   *
   * @param id The charge id.
   * @param size The image size.
   * @return The charge QR code image.
   */
  public fun chargeQrCodeImageAsync(id: String, size: Int = 768): Future<File> = future {
    chargeQrCodeImage(id, size)
  }

  /**
   * Returns a customer.
   *
   * @param id The customer id.
   * @return The customer response.
   */
  public fun getCustomerAsync(id: String): Future<CustomerResponse> = future {
    getCustomer(id)
  }

  /**
   * Returns all customers.
   *
   * @return The customer list response.
   */
  public fun allCustomersAsync(): Future<CustomerListResponse> = future {
    allCustomers()
  }

  /**
   * Creates a new customer.
   *
   * @param value The customer builder.
   * @return The customer response.
   */
  public fun createCustomerAsync(value: CustomerBuilder): Future<CustomerResponse> = future {
    createCustomer(value) {}
  }

  /**
   * Returns a refund.
   *
   * @param id The refund id.
   * @return The refund response.
   */
  public fun getRefundAsync(id: String): Future<RefundResponse> = future {
    getRefund(id)
  }

  /**
   * Returns all refunds.
   *
   * @return The refund list response.
   */
  public fun allRefundsAsync(): Future<RefundListResponse> = future {
    allRefunds()
  }

  /**
   * Gets a subscription by its id.
   *
   * @param id The subscription id.
   * @return The subscription response.
   */
  public fun getSubscriptionAsync(id: String): Future<SubscriptionResponseBody> = future {
    getSubscription(id)
  }

  /**
   * Creates subscription.
   *
   * @param builder The subscription builder.
   * @return The subscription response.
   */
  public fun createSubscriptionAsync(builder: SubscriptionBuilder): Future<SubscriptionResponseBody> = future {
    createSubscription(builder) {}
  }

  /**
   * Creates a new refund.
   *
   * @param value The refund builder.
   * @return The refund response.
   */
  public fun createRefundAsync(value: RefundBuilder): Future<RefundResponse> = future {
    createRefund(value) {}
  }

  /**
   * Deletes a webhook by id.
   *
   * @param id The webhook id.
   * @return The webhook delete response.
   */
  public fun deleteWebhookAsync(id: String): Future<WebhookDeleteResponse> = future {
    deleteWebhook(id)
  }

  /**
   * Returns all webhooks.
   *
   * @param url The webhook url.
   * @return The webhook list response.
   */
  @JvmOverloads
  public fun allWebhooksAsync(url: String? = null): Future<WebhookListResponse> = future {
    allWebhooks(url)
  }

  /**
   * Creates a new webhook.
   *
   * @param builder The webhook builder.
   * @return The webhook response.
   */
  public fun createWebhookAsync(builder: WebhookBuilder): Future<WebhookResponse> = future {
    createWebhook(builder) {}
  }

  /**
   * Returns a transaction.
   *
   * @param id The transaction id.
   * @return The transaction response.
   */
  public fun getTransactionAsync(id: String): Future<TransactionResponse> = future {
    getTransaction(id)
  }

  /**
   * Removes JSON specification restriction (RFC-4627) and makes parser
   * more liberal to the malformed input. In lenient mode quoted boolean literals,
   * and unquoted string literals are allowed.
   *
   * Its relaxations can be expanded in the future, so that lenient parser becomes even more
   * permissive to invalid value in the input, replacing them with defaults.
   *
   * `false` by default.
   */
  @JvmOverloads
  @OptIn(ExperimentalSerializationApi::class)
  public fun configureLenientJson(value: Boolean = true): WooviSDK = apply {
    json = Json(json) {
      isLenient = value
    }
  }

  /**
   * Enables structured objects to be serialized as map keys by
   * changing serialized form of the map from JSON object (key-value pairs) to flat array like `[k1, v1, k2, v2]`.
   * `false` by default.
   */
  @JvmOverloads
  @OptIn(ExperimentalSerializationApi::class)
  public fun configureAllowStructuredMapKeysJson(value: Boolean = true): WooviSDK = apply {
    json = Json(json) {
      allowStructuredMapKeys = value
    }
  }

  /**
   * Specifies whether resulting JSON should be pretty-printed.
   *  `false` by default.
   */
  @JvmOverloads
  @OptIn(ExperimentalSerializationApi::class)
  public fun configurePrettyPrintJson(value: Boolean = true): WooviSDK = apply {
    json = Json(json) {
      prettyPrint = value
    }
  }

  /**
   * Specifies whether `null` values should be encoded for nullable properties and must be present in JSON object
   * during decoding.
   *
   * When this flag is disabled properties with `null` values without default are not encoded;
   * during decoding, the absence of a field value is treated as `null` for nullable properties without a default value.
   *
   * `true` by default.
   */
  @JvmOverloads
  @OptIn(ExperimentalSerializationApi::class)
  public fun configureExplicitNullsJson(value: Boolean = true): WooviSDK = apply {
    json = Json(json) {
      explicitNulls = value
    }
  }

  /**
   * Specifies whether default values of Kotlin properties should be encoded.
   * `false` by default.
   */
  @JvmOverloads
  @OptIn(ExperimentalSerializationApi::class)
  public fun configureEncodeDefaultsJson(value: Boolean = true): WooviSDK = apply {
    json = Json(json) {
      encodeDefaults = value
    }
  }

  /**
   * Specifies whether encounters of unknown properties in the input JSON
   * should be ignored instead of throwing [SerializationException].
   * `false` by default.
   */
  @JvmOverloads
  @OptIn(ExperimentalSerializationApi::class)
  public fun configureIgnoreUnknownKeysJson(value: Boolean = true): WooviSDK = apply {
    json = Json(json) {
      ignoreUnknownKeys = value
    }
  }

  public companion object {
    /**
     * The entrypoint of Woovi SDK for Java, Kotlin and another JVM Languages, it does take an authorization [appId].
     * The overload constructor does take an [Executor] instead of [CoroutineContext] for better Java interoperability.
     *
     * @param appId The authorization [appId] of your application.
     * @param baseUrl The base URL of Woovi API.
     * @param executor The [Executor] of the SDK.
     * @param json The [Json] instance of the SDK.
     * @param client The [HttpClient] instance of the SDK.
     */
    @JvmOverloads
    @JvmStatic
    public fun create(
      /** The authorization [appId] of your application. */
      appId: String,

      /** The base URL of Woovi API. */
      baseUrl: String = "https://api.openpix.com.br/",

      /** The [Executor] of the SDK. */
      executor: Executor = Executors.newCachedThreadPool(),

      /** The [Json] instance of the SDK. */
      json: Json = createJson(),

      /** The [HttpClient] instance of the SDK. */
      client: HttpClient = createDefaultHttpClient(CIO.create { }, appId, baseUrl, json),
    ): WooviSDK = WooviSDK(appId, baseUrl, executor.asCoroutineDispatcher(), json, client)
  }
}

@JvmSynthetic
internal fun createJson(): Json = Json {
  explicitNulls = true
  ignoreUnknownKeys = true
  coerceInputValues = true
}

@JvmSynthetic
internal fun createDefaultHttpClient(
  engine: HttpClientEngine,
  appId: String,
  baseUrl: String,
  json: Json
): HttpClient {
  return HttpClient(engine) {
    install(Logging) {
      level = LogLevel.HEADERS
    }

    install(ContentNegotiation) {
      json(json)
    }

    install(HttpCallValidator) {
      validateResponse { response ->
        if (response.status.isSuccess()) return@validateResponse
        throw response.body<WooviError>()
      }
      handleResponseExceptionWithRequest { exception, _ ->
        val clientException = exception as? ClientRequestException ?: return@handleResponseExceptionWithRequest
        throw clientException.response.body<WooviError>()
      }
    }

    defaultRequest {
      url(baseUrl)
      header("Content-Type", "application/json")
      header("Authorization", appId)
    }
  }
}
