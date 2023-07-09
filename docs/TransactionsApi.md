# TransactionsApi

All URIs are relative to *https://api.woovi.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1TransactionGet**](TransactionsApi.md#apiV1TransactionGet) | **GET** /api/v1/transaction | Get a list of transactions |
| [**apiV1TransactionIdGet**](TransactionsApi.md#apiV1TransactionIdGet) | **GET** /api/v1/transaction/{id} | Get a Transaction |


<a id="apiV1TransactionGet"></a>
# **apiV1TransactionGet**
> ApiV1TransactionGet200Response apiV1TransactionGet(start, end, charge, pixQrCode, withdrawal)

Get a list of transactions

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.TransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    TransactionsApi apiInstance = new TransactionsApi(defaultClient);
    OffsetDateTime start = OffsetDateTime.now(); // OffsetDateTime | 
    OffsetDateTime end = OffsetDateTime.now(); // OffsetDateTime | 
    String charge = "Q2hhcmdlOjYwM2U3NDlhNDI1NjAyYmJiZjRlN2JlZA"; // String | You can use the charge ID or correlation ID or transaction ID of charge to get a list of transactions related of this transaction
    String pixQrCode = "Q2hhcmdlOjYwM2U3NDlhNDI1NjAyYmJiZjRlN2JlZA"; // String | You can use the QrCode static ID or correlation ID or identifier field of QrCode static to get a list of QrCode related of this transaction
    String withdrawal = "Q2hhcmdlOjYwM2U3NDlhNDI1NjAyYmJiZjRlN2JlZA"; // String | You can use the ID or EndToEndId of a withdrawal transaction to get all transactions related to the withdrawal
    try {
      ApiV1TransactionGet200Response result = apiInstance.apiV1TransactionGet(start, end, charge, pixQrCode, withdrawal);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionsApi#apiV1TransactionGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **start** | **OffsetDateTime**|  | [optional] |
| **end** | **OffsetDateTime**|  | [optional] |
| **charge** | **String**| You can use the charge ID or correlation ID or transaction ID of charge to get a list of transactions related of this transaction | [optional] |
| **pixQrCode** | **String**| You can use the QrCode static ID or correlation ID or identifier field of QrCode static to get a list of QrCode related of this transaction | [optional] |
| **withdrawal** | **String**| You can use the ID or EndToEndId of a withdrawal transaction to get all transactions related to the withdrawal | [optional] |

### Return type

[**ApiV1TransactionGet200Response**](ApiV1TransactionGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of transactions |  -  |
| **400** | An error message |  -  |

<a id="apiV1TransactionIdGet"></a>
# **apiV1TransactionIdGet**
> ApiV1TransactionIdGet200Response apiV1TransactionIdGet(id)

Get a Transaction

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.TransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    TransactionsApi apiInstance = new TransactionsApi(defaultClient);
    String id = "id_example"; // String | you can use the transaction id from openpix or the endToEndId of transaction from bank
    try {
      ApiV1TransactionIdGet200Response result = apiInstance.apiV1TransactionIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionsApi#apiV1TransactionIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| you can use the transaction id from openpix or the endToEndId of transaction from bank | |

### Return type

[**ApiV1TransactionIdGet200Response**](ApiV1TransactionIdGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The transaction retrieve using the given ID |  -  |
| **400** | An error message |  -  |

