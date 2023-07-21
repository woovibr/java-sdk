package br.com.openpix.sdk

import io.ktor.client.*
import io.ktor.client.call.*
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

public suspend fun main() {
  val sdk = WooviSDK(appId = System.getenv("APP_ID"))
  println(sdk.allPayments())
}

@OptIn(ExperimentalSerializationApi::class)
public class WooviSDK(
  override val coroutineContext: CoroutineContext = Executors.newCachedThreadPool().asCoroutineDispatcher(),
  private val appId: String,
  private val baseUrl: String = "https://api.openpix.com.br/",
  private var json: Json = Json {
    explicitNulls = true
    ignoreUnknownKeys = true
  },
  public val client: HttpClient = HttpClient(CIO) {
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
  },
) : CoroutineScope {
  public fun getPixQrCodeAsync(id: String): Future<PixQrCodeResponse> = future {
    getPixQrCode(id)
  }

  public fun allPixQrCodesAsync(): Future<PixQrCodeList> = future {
    allPixQrCodes()
  }

  public fun createPixQrCodeAsync(builder: PixQrCodeBuilder): Future<PixQrCodeResponse> = future {
    createPixQrCode(builder) {}
  }

  public fun getAccountAsync(id: String): Future<Account> = future {
    getAccount(id)
  }

  public fun allAccountsAsync(): Future<AccountListResponse> = future {
    allAccounts()
  }

  public fun withdrawAsync(id: String, value: Int): Future<WithdrawResponse> = future {
    withdraw(id, value)
  }

  public fun getPaymentAsync(id: String): Future<PaymentResponseObject> = future {
    getPayment(id)
  }

  public fun allPaymentsAsync(): Future<PaymentListResponse> = future {
    allPayments()
  }

  public suspend fun createPaymentAsync(builder: PaymentBuilder): Future<PaymentResponseObject> = future {
    createPayment(builder) {}
  }

  public fun deleteChargeAsync(id: String): Future<ChargeDeleteResponse> = future {
    deleteCharge(id)
  }

  public fun getChargeAsync(id: String): Future<ChargeResponse> = future {
    getCharge(id)
  }

  public fun chargesAsync(
    start: String? = null,
    end: String? = null,
    status: ChargeStatus? = null,
  ): Future<ChargeListResponse> = future {
    charges(start, end, status)
  }

  public fun createChargeAsync(builder: ChargeBuilder): Future<ChargeResponse> = future {
    createCharge(builder) {}
  }

  public fun chargeQrCodeImageAsync(id: String, size: Int = 768): Future<File> = future {
    chargeQrCodeImage(id, size)
  }

  public fun getCustomerAsync(id: String): Future<Customer> = future {
    getCustomer(id)
  }

  public fun allCustomersAsync(): Future<CustomerListResponse> = future {
    allCustomers()
  }

  public fun createCustomerAsync(value: CustomerBuilder): Future<CustomerResponse> = future {
    createCustomer(value) {}
  }

  public fun getRefundAsync(id: String): Future<RefundResponse> = future {
    getRefund(id)
  }

  public fun allRefundsAsync(): Future<RefundListResponse> = future {
    allRefunds()
  }

  public fun createRefundAsync(value: RefundBuilder): Future<RefundResponse> = future {
    createRefund(value) {}
  }

  // Java util functions

  public fun configureLenientJson(value: Boolean = true): WooviSDK = apply {
    json = Json(json) {
      isLenient = value
    }
  }

  public fun configureAllowStructuredMapKeysJson(value: Boolean = true): WooviSDK = apply {
    json = Json(json) {
      allowStructuredMapKeys = value
    }
  }

  public fun configurePrettyPrintJson(value: Boolean = true): WooviSDK = apply {
    json = Json(json) {
      prettyPrint = value
    }
  }

  public fun configureExplicitNullsJson(value: Boolean = true): WooviSDK = apply {
    json = Json(json) {
      explicitNulls = value
    }
  }

  public fun configureEncodeDefaultsJson(value: Boolean = true): WooviSDK = apply {
    json = Json(json) {
      encodeDefaults = value
    }
  }

  public fun configureIgnoreUnknownKeysJson(value: Boolean = true): WooviSDK = apply {
    json = Json(json) {
      ignoreUnknownKeys = value
    }
  }

  public companion object {
    @JvmStatic
    public fun of(executor: Executor, appId: String): WooviSDK {
      return WooviSDK(executor.asCoroutineDispatcher(), appId)
    }

    @JvmStatic
    public fun of(executor: Executor, appId: String, baseUrl: String): WooviSDK {
      return WooviSDK(executor.asCoroutineDispatcher(), appId, baseUrl)
    }

    @JvmStatic
    public fun of(executor: Executor, appId: String, baseUrl: String, json: Json): WooviSDK {
      return WooviSDK(executor.asCoroutineDispatcher(), appId, baseUrl, json)
    }

    @JvmStatic
    public fun of(executor: Executor, appId: String, json: Json, baseUrl: String, httpClient: HttpClient): WooviSDK {
      return WooviSDK(executor.asCoroutineDispatcher(), appId, baseUrl, json, httpClient)
    }
  }
}
