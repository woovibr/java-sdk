# AccountApi

All URIs are relative to *https://api.woovi.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1AccountAccountIdGet**](AccountApi.md#apiV1AccountAccountIdGet) | **GET** /api/v1/account/{accountId} | Get an Account |
| [**apiV1AccountAccountIdWithdrawPost**](AccountApi.md#apiV1AccountAccountIdWithdrawPost) | **POST** /api/v1/account/{accountId}/withdraw | Withdraw from an Account |
| [**apiV1AccountGet**](AccountApi.md#apiV1AccountGet) | **GET** /api/v1/account/ | Get a list of Accounts |


<a id="apiV1AccountAccountIdGet"></a>
# **apiV1AccountAccountIdGet**
> ApiV1AccountAccountIdGet200Response apiV1AccountAccountIdGet(accountId)

Get an Account

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.AccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    AccountApi apiInstance = new AccountApi(defaultClient);
    String accountId = "6290ccfd42831958a405debc"; // String | ID of the Account
    try {
      ApiV1AccountAccountIdGet200Response result = apiInstance.apiV1AccountAccountIdGet(accountId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccountApi#apiV1AccountAccountIdGet");
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
| **accountId** | **String**| ID of the Account | |

### Return type

[**ApiV1AccountAccountIdGet200Response**](ApiV1AccountAccountIdGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The Account retrieve using the given Account ID |  -  |
| **400** | An error message |  -  |

<a id="apiV1AccountAccountIdWithdrawPost"></a>
# **apiV1AccountAccountIdWithdrawPost**
> ApiV1AccountAccountIdWithdrawPost200Response apiV1AccountAccountIdWithdrawPost(accountId, apiV1AccountAccountIdWithdrawPostRequest)

Withdraw from an Account

An additional fee may be charged depending on the minimum free withdrawal amount. See more about at https://developers.openpix.com.br/docs/FAQ/faq-virtual-account/#onde-posso-consultar-as-taxas-da-minha-conta-virtual

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.AccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    AccountApi apiInstance = new AccountApi(defaultClient);
    String accountId = "6290ccfd42831958a405debc"; // String | ID of the Account
    ApiV1AccountAccountIdWithdrawPostRequest apiV1AccountAccountIdWithdrawPostRequest = new ApiV1AccountAccountIdWithdrawPostRequest(); // ApiV1AccountAccountIdWithdrawPostRequest | 
    try {
      ApiV1AccountAccountIdWithdrawPost200Response result = apiInstance.apiV1AccountAccountIdWithdrawPost(accountId, apiV1AccountAccountIdWithdrawPostRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccountApi#apiV1AccountAccountIdWithdrawPost");
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
| **accountId** | **String**| ID of the Account | |
| **apiV1AccountAccountIdWithdrawPostRequest** | [**ApiV1AccountAccountIdWithdrawPostRequest**](ApiV1AccountAccountIdWithdrawPostRequest.md)|  | |

### Return type

[**ApiV1AccountAccountIdWithdrawPost200Response**](ApiV1AccountAccountIdWithdrawPost200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Withdraw and Acccount information |  -  |
| **400** | An error message |  -  |

<a id="apiV1AccountGet"></a>
# **apiV1AccountGet**
> ApiV1AccountGet200Response apiV1AccountGet()

Get a list of Accounts

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.AccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    AccountApi apiInstance = new AccountApi(defaultClient);
    try {
      ApiV1AccountGet200Response result = apiInstance.apiV1AccountGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccountApi#apiV1AccountGet");
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

[**ApiV1AccountGet200Response**](ApiV1AccountGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of Accounts |  -  |
| **400** | An error message |  -  |

