# CashbackFidelityApi

All URIs are relative to *https://api.woovi.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1CashbackFidelityBalanceTaxIDGet**](CashbackFidelityApi.md#apiV1CashbackFidelityBalanceTaxIDGet) | **GET** /api/v1/cashback-fidelity/balance/{taxID} | Get the exclusive cashback amount an user still has to receive by taxID. |
| [**apiV1CashbackFidelityPost**](CashbackFidelityApi.md#apiV1CashbackFidelityPost) | **POST** /api/v1/cashback-fidelity | Get or create cashback for a customer. |


<a id="apiV1CashbackFidelityBalanceTaxIDGet"></a>
# **apiV1CashbackFidelityBalanceTaxIDGet**
> ApiV1CashbackFidelityBalanceTaxIDGet200Response apiV1CashbackFidelityBalanceTaxIDGet(taxID)

Get the exclusive cashback amount an user still has to receive by taxID.

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.CashbackFidelityApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    CashbackFidelityApi apiInstance = new CashbackFidelityApi(defaultClient);
    String taxID = "60151449000182"; // String | The raw tax ID from the customer you want to get the balance.
    try {
      ApiV1CashbackFidelityBalanceTaxIDGet200Response result = apiInstance.apiV1CashbackFidelityBalanceTaxIDGet(taxID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CashbackFidelityApi#apiV1CashbackFidelityBalanceTaxIDGet");
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
| **taxID** | **String**| The raw tax ID from the customer you want to get the balance. | |

### Return type

[**ApiV1CashbackFidelityBalanceTaxIDGet200Response**](ApiV1CashbackFidelityBalanceTaxIDGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Amount the user still has to receive. |  -  |
| **400** | An error message |  -  |

<a id="apiV1CashbackFidelityPost"></a>
# **apiV1CashbackFidelityPost**
> ApiV1CashbackFidelityPost200Response apiV1CashbackFidelityPost(apiV1CashbackFidelityPostRequest)

Get or create cashback for a customer.

Create a new cashback exclusive for the customer with a given taxID. If the customer already has a pending excluisve cashback, this endpoint will return it instead.

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.CashbackFidelityApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    CashbackFidelityApi apiInstance = new CashbackFidelityApi(defaultClient);
    ApiV1CashbackFidelityPostRequest apiV1CashbackFidelityPostRequest = new ApiV1CashbackFidelityPostRequest(); // ApiV1CashbackFidelityPostRequest | Customer's taxID and the cash
    try {
      ApiV1CashbackFidelityPost200Response result = apiInstance.apiV1CashbackFidelityPost(apiV1CashbackFidelityPostRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CashbackFidelityApi#apiV1CashbackFidelityPost");
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
| **apiV1CashbackFidelityPostRequest** | [**ApiV1CashbackFidelityPostRequest**](ApiV1CashbackFidelityPostRequest.md)| Customer&#39;s taxID and the cash | |

### Return type

[**ApiV1CashbackFidelityPost200Response**](ApiV1CashbackFidelityPost200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Didn&#39;t create a new cashback, returning previously existing cashback information instead. |  -  |
| **201** | New cashback created successfully |  -  |
| **400** | An error message |  -  |

