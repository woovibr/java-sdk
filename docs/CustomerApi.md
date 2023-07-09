# CustomerApi

All URIs are relative to *https://api.woovi.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1CustomerGet**](CustomerApi.md#apiV1CustomerGet) | **GET** /api/v1/customer | Get a list of customers |
| [**apiV1CustomerIdGet**](CustomerApi.md#apiV1CustomerIdGet) | **GET** /api/v1/customer/{id} | Get one customer |
| [**apiV1CustomerPost**](CustomerApi.md#apiV1CustomerPost) | **POST** /api/v1/customer | Create a new Customer |


<a id="apiV1CustomerGet"></a>
# **apiV1CustomerGet**
> ApiV1CustomerGet200Response apiV1CustomerGet()

Get a list of customers

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.CustomerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    CustomerApi apiInstance = new CustomerApi(defaultClient);
    try {
      ApiV1CustomerGet200Response result = apiInstance.apiV1CustomerGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomerApi#apiV1CustomerGet");
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

[**ApiV1CustomerGet200Response**](ApiV1CustomerGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of customers |  -  |
| **400** | An error message |  -  |

<a id="apiV1CustomerIdGet"></a>
# **apiV1CustomerIdGet**
> ApiV1CustomerIdGet200Response apiV1CustomerIdGet(id)

Get one customer

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.CustomerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    CustomerApi apiInstance = new CustomerApi(defaultClient);
    String id = "fe7834b4060c488a9b0f89811be5f5cf"; // String | correlation ID
    try {
      ApiV1CustomerIdGet200Response result = apiInstance.apiV1CustomerIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomerApi#apiV1CustomerIdGet");
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
| **id** | **String**| correlation ID | |

### Return type

[**ApiV1CustomerIdGet200Response**](ApiV1CustomerIdGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The customer retrieve using the given ID |  -  |
| **400** | An error message |  -  |

<a id="apiV1CustomerPost"></a>
# **apiV1CustomerPost**
> ApiV1CustomerPost200Response apiV1CustomerPost(customerPayload)

Create a new Customer

Endpoint to create a new Customer

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.CustomerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    CustomerApi apiInstance = new CustomerApi(defaultClient);
    CustomerPayload customerPayload = new HashMap(); // CustomerPayload | Data to create a new customer
    try {
      ApiV1CustomerPost200Response result = apiInstance.apiV1CustomerPost(customerPayload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomerApi#apiV1CustomerPost");
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
| **customerPayload** | [**CustomerPayload**](CustomerPayload.md)| Data to create a new customer | |

### Return type

[**ApiV1CustomerPost200Response**](ApiV1CustomerPost200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Customer ID |  -  |
| **400** | An error message |  -  |

