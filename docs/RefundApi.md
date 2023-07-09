# RefundApi

All URIs are relative to *https://api.woovi.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1RefundGet**](RefundApi.md#apiV1RefundGet) | **GET** /api/v1/refund | Get a list of refunds |
| [**apiV1RefundIdGet**](RefundApi.md#apiV1RefundIdGet) | **GET** /api/v1/refund/{id} | Get one refund |
| [**apiV1RefundPost**](RefundApi.md#apiV1RefundPost) | **POST** /api/v1/refund | Create a new refund |


<a id="apiV1RefundGet"></a>
# **apiV1RefundGet**
> ApiV1RefundGet200Response apiV1RefundGet()

Get a list of refunds

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.RefundApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    RefundApi apiInstance = new RefundApi(defaultClient);
    try {
      ApiV1RefundGet200Response result = apiInstance.apiV1RefundGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RefundApi#apiV1RefundGet");
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

[**ApiV1RefundGet200Response**](ApiV1RefundGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of refunds |  -  |
| **400** | An error message |  -  |

<a id="apiV1RefundIdGet"></a>
# **apiV1RefundIdGet**
> ApiV1RefundIdGet200Response apiV1RefundIdGet(id)

Get one refund

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.RefundApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    RefundApi apiInstance = new RefundApi(defaultClient);
    String id = "Q2hhcmdlOjYwM2U3NDlhNDI1NjAyYmJiZjRlN2JlZA=="; // String | refund ID or correlation ID
    try {
      ApiV1RefundIdGet200Response result = apiInstance.apiV1RefundIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RefundApi#apiV1RefundIdGet");
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
| **id** | **String**| refund ID or correlation ID | |

### Return type

[**ApiV1RefundIdGet200Response**](ApiV1RefundIdGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The refund retrieve using the given ID |  -  |
| **400** | An error message |  -  |

<a id="apiV1RefundPost"></a>
# **apiV1RefundPost**
> ApiV1RefundPost200Response apiV1RefundPost(refundPayload)

Create a new refund

Endpoint to create a new refund for a customer

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.RefundApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    RefundApi apiInstance = new RefundApi(defaultClient);
    RefundPayload refundPayload = new HashMap(); // RefundPayload | Data to create a new refund
    try {
      ApiV1RefundPost200Response result = apiInstance.apiV1RefundPost(refundPayload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RefundApi#apiV1RefundPost");
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
| **refundPayload** | [**RefundPayload**](RefundPayload.md)| Data to create a new refund | |

### Return type

[**ApiV1RefundPost200Response**](ApiV1RefundPost200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The created Refund |  -  |
| **400** | An error message |  -  |

