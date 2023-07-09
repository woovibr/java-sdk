# ChargeApi

All URIs are relative to *https://api.woovi.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1ChargeGet**](ChargeApi.md#apiV1ChargeGet) | **GET** /api/v1/charge | Get a list of charges |
| [**apiV1ChargeIdDelete**](ChargeApi.md#apiV1ChargeIdDelete) | **DELETE** /api/v1/charge/{id} | Delete a charge |
| [**apiV1ChargeIdGet**](ChargeApi.md#apiV1ChargeIdGet) | **GET** /api/v1/charge/{id} | Get one charge |
| [**apiV1ChargePost**](ChargeApi.md#apiV1ChargePost) | **POST** /api/v1/charge | Create a new Charge |
| [**openpixChargeBrcodeImageIdPngsize1024Get**](ChargeApi.md#openpixChargeBrcodeImageIdPngsize1024Get) | **GET** /openpix/charge/brcode/image/{id}.png?size&#x3D;1024 | Get an image of Qr Code from a Charge |


<a id="apiV1ChargeGet"></a>
# **apiV1ChargeGet**
> ApiV1ChargeGet200Response apiV1ChargeGet(start, end, status)

Get a list of charges

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.ChargeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    ChargeApi apiInstance = new ChargeApi(defaultClient);
    OffsetDateTime start = OffsetDateTime.parse("2020-01-01T00:00Z"); // OffsetDateTime | 
    OffsetDateTime end = OffsetDateTime.parse("2020-12-01T17:00Z"); // OffsetDateTime | 
    String status = "ACTIVE"; // String | 
    try {
      ApiV1ChargeGet200Response result = apiInstance.apiV1ChargeGet(start, end, status);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChargeApi#apiV1ChargeGet");
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
| **status** | **String**|  | [optional] [enum: ACTIVE, COMPLETED, EXPIRED] |

### Return type

[**ApiV1ChargeGet200Response**](ApiV1ChargeGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of charges |  -  |
| **400** | An error message |  -  |

<a id="apiV1ChargeIdDelete"></a>
# **apiV1ChargeIdDelete**
> ApiV1ChargeIdDelete200Response apiV1ChargeIdDelete(id)

Delete a charge

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.ChargeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    ChargeApi apiInstance = new ChargeApi(defaultClient);
    String id = "Q2hhcmdlOjYwM2U3NDlhNDI1NjAyYmJiZjRlN2JlZA=="; // String | charge ID or correlation ID. You will need URI encoding if your correlation ID has characters outside the ASCII set or reserved characters (%, \\#, /).
    try {
      ApiV1ChargeIdDelete200Response result = apiInstance.apiV1ChargeIdDelete(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChargeApi#apiV1ChargeIdDelete");
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
| **id** | **String**| charge ID or correlation ID. You will need URI encoding if your correlation ID has characters outside the ASCII set or reserved characters (%, \\#, /). | |

### Return type

[**ApiV1ChargeIdDelete200Response**](ApiV1ChargeIdDelete200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The charge deleted |  -  |
| **400** | An error message |  -  |

<a id="apiV1ChargeIdGet"></a>
# **apiV1ChargeIdGet**
> ApiV1ChargeIdGet200Response apiV1ChargeIdGet(id)

Get one charge

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.ChargeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    ChargeApi apiInstance = new ChargeApi(defaultClient);
    String id = "Q2hhcmdlOjYwM2U3NDlhNDI1NjAyYmJiZjRlN2JlZA=="; // String | charge ID or correlation ID. You will need URI encoding if your correlation ID has characters outside the ASCII set or reserved characters (%, \\#, /).
    try {
      ApiV1ChargeIdGet200Response result = apiInstance.apiV1ChargeIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChargeApi#apiV1ChargeIdGet");
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
| **id** | **String**| charge ID or correlation ID. You will need URI encoding if your correlation ID has characters outside the ASCII set or reserved characters (%, \\#, /). | |

### Return type

[**ApiV1ChargeIdGet200Response**](ApiV1ChargeIdGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The charge retrieve using the given ID |  -  |
| **400** | An error message |  -  |

<a id="apiV1ChargePost"></a>
# **apiV1ChargePost**
> ApiV1ChargePost200Response apiV1ChargePost(chargePayload, returnExisting)

Create a new Charge

Endpoint to create a new Charge for a customer

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.ChargeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    ChargeApi apiInstance = new ChargeApi(defaultClient);
    ChargePayload chargePayload = new HashMap(); // ChargePayload | Data to create a new charge
    Boolean returnExisting = true; // Boolean | Make the endpoint idempotent, will return an existent charge if already has a one with the correlationID
    try {
      ApiV1ChargePost200Response result = apiInstance.apiV1ChargePost(chargePayload, returnExisting);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChargeApi#apiV1ChargePost");
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
| **chargePayload** | [**ChargePayload**](ChargePayload.md)| Data to create a new charge | |
| **returnExisting** | **Boolean**| Make the endpoint idempotent, will return an existent charge if already has a one with the correlationID | [optional] |

### Return type

[**ApiV1ChargePost200Response**](ApiV1ChargePost200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Charge ID and also the generated Dynamic BR Code to be rendered as a QRCode |  -  |
| **400** | An error message |  -  |

<a id="openpixChargeBrcodeImageIdPngsize1024Get"></a>
# **openpixChargeBrcodeImageIdPngsize1024Get**
> openpixChargeBrcodeImageIdPngsize1024Get(id, size)

Get an image of Qr Code from a Charge

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.ChargeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    ChargeApi apiInstance = new ChargeApi(defaultClient);
    String id = "fe7834b4060c488a9b0f89811be5f5cf"; // String | charge link payment ID
    String size = "768"; // String | Size for the image. This size should be between 600 and 4096. if the size parameter was not passed, the default value will be 1024.
    try {
      apiInstance.openpixChargeBrcodeImageIdPngsize1024Get(id, size);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChargeApi#openpixChargeBrcodeImageIdPngsize1024Get");
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
| **id** | **String**| charge link payment ID | |
| **size** | **String**| Size for the image. This size should be between 600 and 4096. if the size parameter was not passed, the default value will be 1024. | [optional] |

### Return type

null (empty response body)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The Qr Code image as MIME type |  -  |
| **400** | An error message |  -  |

