# PaymentRequestAccessApi

All URIs are relative to *https://api.woovi.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1PaymentGet**](PaymentRequestAccessApi.md#apiV1PaymentGet) | **GET** /api/v1/payment | Get a list of payments |
| [**apiV1PaymentIdGet**](PaymentRequestAccessApi.md#apiV1PaymentIdGet) | **GET** /api/v1/payment/{id} | Get one Payment |
| [**apiV1PaymentPost**](PaymentRequestAccessApi.md#apiV1PaymentPost) | **POST** /api/v1/payment | Create a Payment Request |


<a id="apiV1PaymentGet"></a>
# **apiV1PaymentGet**
> ApiV1PaymentGet200Response apiV1PaymentGet()

Get a list of payments

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.PaymentRequestAccessApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    PaymentRequestAccessApi apiInstance = new PaymentRequestAccessApi(defaultClient);
    try {
      ApiV1PaymentGet200Response result = apiInstance.apiV1PaymentGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentRequestAccessApi#apiV1PaymentGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ApiV1PaymentGet200Response**](ApiV1PaymentGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of payments |  -  |
| **400** | An error message |  -  |

<a id="apiV1PaymentIdGet"></a>
# **apiV1PaymentIdGet**
> ApiV1PaymentIdGet200Response apiV1PaymentIdGet(id)

Get one Payment

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.PaymentRequestAccessApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    PaymentRequestAccessApi apiInstance = new PaymentRequestAccessApi(defaultClient);
    String id = "Q2hhcmdlOjYwM2U3NDlhNDI1NjAyYmJiZjRlN2JlZA=="; // String | payment ID or correlation ID
    try {
      ApiV1PaymentIdGet200Response result = apiInstance.apiV1PaymentIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentRequestAccessApi#apiV1PaymentIdGet");
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
| **id** | **String**| payment ID or correlation ID | |

### Return type

[**ApiV1PaymentIdGet200Response**](ApiV1PaymentIdGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The payment retrieved using the given ID |  -  |
| **400** | An error message |  -  |

<a id="apiV1PaymentPost"></a>
# **apiV1PaymentPost**
> ApiV1PaymentPost200Response apiV1PaymentPost(paymentCreatePayload)

Create a Payment Request

Endpoint to request a payment

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.PaymentRequestAccessApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    PaymentRequestAccessApi apiInstance = new PaymentRequestAccessApi(defaultClient);
    PaymentCreatePayload paymentCreatePayload = new HashMap(); // PaymentCreatePayload | Data to create a payment request
    try {
      ApiV1PaymentPost200Response result = apiInstance.apiV1PaymentPost(paymentCreatePayload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentRequestAccessApi#apiV1PaymentPost");
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
| **paymentCreatePayload** | [**PaymentCreatePayload**](PaymentCreatePayload.md)| Data to create a payment request | |

### Return type

[**ApiV1PaymentPost200Response**](ApiV1PaymentPost200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Payment destination account information |  -  |
| **400** | An error message |  -  |

