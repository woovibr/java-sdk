# PixQrCodeApi

All URIs are relative to *https://api.woovi.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1PixQrCodeStaticIdGet**](PixQrCodeApi.md#apiV1PixQrCodeStaticIdGet) | **GET** /api/v1/pixQrCode-static/{id} | Get one Pix QrCode |
| [**apiV1QrcodeStaticGet**](PixQrCodeApi.md#apiV1QrcodeStaticGet) | **GET** /api/v1/qrcode-static | Get a list of Pix QrCodes |
| [**apiV1QrcodeStaticPost**](PixQrCodeApi.md#apiV1QrcodeStaticPost) | **POST** /api/v1/qrcode-static | Create a new Pix QrCode Static |


<a id="apiV1PixQrCodeStaticIdGet"></a>
# **apiV1PixQrCodeStaticIdGet**
> ApiV1PixQrCodeStaticIdGet200Response apiV1PixQrCodeStaticIdGet(id)

Get one Pix QrCode

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.PixQrCodeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    PixQrCodeApi apiInstance = new PixQrCodeApi(defaultClient);
    String id = "Q2hhcmdlOjYwM2U3NDlhNDI1NjAyYmJiZjRlN2JlZA=="; // String | pixQrCode ID, correlation ID or emv identifier
    try {
      ApiV1PixQrCodeStaticIdGet200Response result = apiInstance.apiV1PixQrCodeStaticIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PixQrCodeApi#apiV1PixQrCodeStaticIdGet");
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
| **id** | **String**| pixQrCode ID, correlation ID or emv identifier | |

### Return type

[**ApiV1PixQrCodeStaticIdGet200Response**](ApiV1PixQrCodeStaticIdGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The pixQrCode retrieve using the given ID |  -  |
| **400** | An error message |  -  |

<a id="apiV1QrcodeStaticGet"></a>
# **apiV1QrcodeStaticGet**
> ApiV1QrcodeStaticGet200Response apiV1QrcodeStaticGet()

Get a list of Pix QrCodes

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.PixQrCodeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    PixQrCodeApi apiInstance = new PixQrCodeApi(defaultClient);
    try {
      ApiV1QrcodeStaticGet200Response result = apiInstance.apiV1QrcodeStaticGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PixQrCodeApi#apiV1QrcodeStaticGet");
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

[**ApiV1QrcodeStaticGet200Response**](ApiV1QrcodeStaticGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of pixQrCodes |  -  |
| **400** | An error message |  -  |

<a id="apiV1QrcodeStaticPost"></a>
# **apiV1QrcodeStaticPost**
> ApiV1QrcodeStaticPost200Response apiV1QrcodeStaticPost(pixQrCodePayload)

Create a new Pix QrCode Static

Endpoint to create a new Pix QrCode Static

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.PixQrCodeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    PixQrCodeApi apiInstance = new PixQrCodeApi(defaultClient);
    PixQrCodePayload pixQrCodePayload = new HashMap(); // PixQrCodePayload | Data to create a new Pix QrCode Static
    try {
      ApiV1QrcodeStaticPost200Response result = apiInstance.apiV1QrcodeStaticPost(pixQrCodePayload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PixQrCodeApi#apiV1QrcodeStaticPost");
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
| **pixQrCodePayload** | [**PixQrCodePayload**](PixQrCodePayload.md)| Data to create a new Pix QrCode Static | |

### Return type

[**ApiV1QrcodeStaticPost200Response**](ApiV1QrcodeStaticPost200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | PixQrCode ID and also the generated Dynamic BR Code to be rendered as a QRCode |  -  |
| **400** | An error message |  -  |

