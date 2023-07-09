# ChargeRefundApi

All URIs are relative to *https://api.woovi.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1ChargeIdRefundGet**](ChargeRefundApi.md#apiV1ChargeIdRefundGet) | **GET** /api/v1/charge/{id}/refund | Get all refunds of a charge |
| [**apiV1ChargeIdRefundPost**](ChargeRefundApi.md#apiV1ChargeIdRefundPost) | **POST** /api/v1/charge/{id}/refund | Create a new refund for a charge |


<a id="apiV1ChargeIdRefundGet"></a>
# **apiV1ChargeIdRefundGet**
> ApiV1ChargeIdRefundGet200Response apiV1ChargeIdRefundGet(id)

Get all refunds of a charge

Endpoint to get all refunds of a charge

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.ChargeRefundApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    ChargeRefundApi apiInstance = new ChargeRefundApi(defaultClient);
    String id = "cf4012c9-b2ac-484d-8121-deedd1c6d8af"; // String | The correlation ID of the charge. You will need URI encoding if your correlation ID has characters outside the ASCII set or reserved characters (%, \\#, /).
    try {
      ApiV1ChargeIdRefundGet200Response result = apiInstance.apiV1ChargeIdRefundGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChargeRefundApi#apiV1ChargeIdRefundGet");
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
| **id** | **String**| The correlation ID of the charge. You will need URI encoding if your correlation ID has characters outside the ASCII set or reserved characters (%, \\#, /). | |

### Return type

[**ApiV1ChargeIdRefundGet200Response**](ApiV1ChargeIdRefundGet200Response.md)

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

<a id="apiV1ChargeIdRefundPost"></a>
# **apiV1ChargeIdRefundPost**
> ApiV1ChargeIdRefundPost200Response apiV1ChargeIdRefundPost(id, chargeRefundPayload)

Create a new refund for a charge

Endpoint to create a new refund for a charge

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.ChargeRefundApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    ChargeRefundApi apiInstance = new ChargeRefundApi(defaultClient);
    String id = "cf4012c9-b2ac-484d-8121-deedd1c6d8af"; // String | The correlation ID of the charge. You will need URI encoding if your correlation ID has characters outside the ASCII set or reserved characters (%, \\#, /).
    ChargeRefundPayload chargeRefundPayload = new HashMap(); // ChargeRefundPayload | Data to create a new refund for a charge
    try {
      ApiV1ChargeIdRefundPost200Response result = apiInstance.apiV1ChargeIdRefundPost(id, chargeRefundPayload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChargeRefundApi#apiV1ChargeIdRefundPost");
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
| **id** | **String**| The correlation ID of the charge. You will need URI encoding if your correlation ID has characters outside the ASCII set or reserved characters (%, \\#, /). | |
| **chargeRefundPayload** | [**ChargeRefundPayload**](ChargeRefundPayload.md)| Data to create a new refund for a charge | |

### Return type

[**ApiV1ChargeIdRefundPost200Response**](ApiV1ChargeIdRefundPost200Response.md)

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

