# SubscriptionApi

All URIs are relative to *https://api.woovi.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1SubscriptionsIdGet**](SubscriptionApi.md#apiV1SubscriptionsIdGet) | **GET** /api/v1/subscriptions/{id} | Get one subscription |
| [**apiV1SubscriptionsPost**](SubscriptionApi.md#apiV1SubscriptionsPost) | **POST** /api/v1/subscriptions | Create a new Subscription |


<a id="apiV1SubscriptionsIdGet"></a>
# **apiV1SubscriptionsIdGet**
> ApiV1SubscriptionsIdGet200Response apiV1SubscriptionsIdGet(id)

Get one subscription

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.SubscriptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    SubscriptionApi apiInstance = new SubscriptionApi(defaultClient);
    String id = "UGF5bWVudFN1YnNjcmlwdGlvbjo2M2UzYjJiNzczZDNkOTNiY2RkMzI5OTM="; // String | The globalID of the subscription.
    try {
      ApiV1SubscriptionsIdGet200Response result = apiInstance.apiV1SubscriptionsIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SubscriptionApi#apiV1SubscriptionsIdGet");
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
| **id** | **String**| The globalID of the subscription. | |

### Return type

[**ApiV1SubscriptionsIdGet200Response**](ApiV1SubscriptionsIdGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The subscription retrieved using the given ID |  -  |
| **400** | An error message |  -  |

<a id="apiV1SubscriptionsPost"></a>
# **apiV1SubscriptionsPost**
> ApiV1SubscriptionsIdGet200Response apiV1SubscriptionsPost(subscriptionPayload)

Create a new Subscription

Endpoint to create a new Subcription

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.SubscriptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    SubscriptionApi apiInstance = new SubscriptionApi(defaultClient);
    SubscriptionPayload subscriptionPayload = new HashMap(); // SubscriptionPayload | Data to create a new Subscription
    try {
      ApiV1SubscriptionsIdGet200Response result = apiInstance.apiV1SubscriptionsPost(subscriptionPayload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SubscriptionApi#apiV1SubscriptionsPost");
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
| **subscriptionPayload** | [**SubscriptionPayload**](SubscriptionPayload.md)| Data to create a new Subscription | |

### Return type

[**ApiV1SubscriptionsIdGet200Response**](ApiV1SubscriptionsIdGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The subscription created |  -  |
| **400** | An error message |  -  |

