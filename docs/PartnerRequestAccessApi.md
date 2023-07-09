# PartnerRequestAccessApi

All URIs are relative to *https://api.woovi.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1PartnerApplicationPost**](PartnerRequestAccessApi.md#apiV1PartnerApplicationPost) | **POST** /api/v1/partner/application | Create a new application to some of your preregistration&#39;s company. |
| [**apiV1PartnerCompanyGet**](PartnerRequestAccessApi.md#apiV1PartnerCompanyGet) | **GET** /api/v1/partner/company | Get every preregistration that is managed by you. |
| [**apiV1PartnerCompanyPost**](PartnerRequestAccessApi.md#apiV1PartnerCompanyPost) | **POST** /api/v1/partner/company | Create a pre registration with a partner reference (your company) |
| [**apiV1PartnerCompanyTaxIDGet**](PartnerRequestAccessApi.md#apiV1PartnerCompanyTaxIDGet) | **GET** /api/v1/partner/company/{taxID} | Get an specific preregistration via taxID param. |


<a id="apiV1PartnerApplicationPost"></a>
# **apiV1PartnerApplicationPost**
> ApiV1PartnerApplicationPost200Response apiV1PartnerApplicationPost(apiV1PartnerApplicationPostRequest)

Create a new application to some of your preregistration&#39;s company.

As a partner company, you can create a new application to some of your companies. The application should give access to our API to this companies, so they can use it too. 

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.PartnerRequestAccessApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    PartnerRequestAccessApi apiInstance = new PartnerRequestAccessApi(defaultClient);
    ApiV1PartnerApplicationPostRequest apiV1PartnerApplicationPostRequest = new ApiV1PartnerApplicationPostRequest(); // ApiV1PartnerApplicationPostRequest | The request body to create a pre registration.
    try {
      ApiV1PartnerApplicationPost200Response result = apiInstance.apiV1PartnerApplicationPost(apiV1PartnerApplicationPostRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PartnerRequestAccessApi#apiV1PartnerApplicationPost");
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
| **apiV1PartnerApplicationPostRequest** | [**ApiV1PartnerApplicationPostRequest**](ApiV1PartnerApplicationPostRequest.md)| The request body to create a pre registration. | |

### Return type

[**ApiV1PartnerApplicationPost200Response**](ApiV1PartnerApplicationPost200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Our \&quot;idempotence output\&quot;, if you get this HTTP code, it&#39;s an application that already has been registered.  |  -  |
| **201** | A new application has been registered. It&#39;ll be identified by the name that you give to it and by the company that has been referenced.  |  -  |
| **400** | An error message |  -  |
| **403** | You are unauthorized to use this endpoint. |  -  |

<a id="apiV1PartnerCompanyGet"></a>
# **apiV1PartnerCompanyGet**
> ApiV1PartnerCompanyGet200Response apiV1PartnerCompanyGet()

Get every preregistration that is managed by you.

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.PartnerRequestAccessApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    PartnerRequestAccessApi apiInstance = new PartnerRequestAccessApi(defaultClient);
    try {
      ApiV1PartnerCompanyGet200Response result = apiInstance.apiV1PartnerCompanyGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PartnerRequestAccessApi#apiV1PartnerCompanyGet");
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

[**ApiV1PartnerCompanyGet200Response**](ApiV1PartnerCompanyGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list with preregistrations. |  -  |
| **400** | An error message |  -  |

<a id="apiV1PartnerCompanyPost"></a>
# **apiV1PartnerCompanyPost**
> PreRegistrationPayloadObject apiV1PartnerCompanyPost(preRegistrationPayloadObject)

Create a pre registration with a partner reference (your company)

As a partner company, you can create a new pre registration referencing your company as a partner. 

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.PartnerRequestAccessApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    PartnerRequestAccessApi apiInstance = new PartnerRequestAccessApi(defaultClient);
    PreRegistrationPayloadObject preRegistrationPayloadObject = new HashMap(); // PreRegistrationPayloadObject | The request body to create a pre registration.
    try {
      PreRegistrationPayloadObject result = apiInstance.apiV1PartnerCompanyPost(preRegistrationPayloadObject);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PartnerRequestAccessApi#apiV1PartnerCompanyPost");
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
| **preRegistrationPayloadObject** | [**PreRegistrationPayloadObject**](PreRegistrationPayloadObject.md)| The request body to create a pre registration. | |

### Return type

[**PreRegistrationPayloadObject**](PreRegistrationPayloadObject.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Payload with a pre registration data. Being the taxID our idempotence key, if you do the request with the same taxID multiple times, every time you&#39;ll receive the same data from our endpoint.  |  -  |
| **201** | A new preregistration that is related to you has been created. |  -  |
| **400** | An error message |  -  |
| **403** | You are unauthorized to use this endpoint. |  -  |

<a id="apiV1PartnerCompanyTaxIDGet"></a>
# **apiV1PartnerCompanyTaxIDGet**
> ApiV1PartnerCompanyTaxIDGet200Response apiV1PartnerCompanyTaxIDGet(taxID)

Get an specific preregistration via taxID param.

### Example
```java
// Import classes:
import br.com.openpix.sdk.ApiClient;
import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.Configuration;
import br.com.openpix.sdk.auth.*;
import br.com.openpix.sdk.models.*;
import br.com.openpix.sdk.api.PartnerRequestAccessApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woovi.com");
    
    // Configure API key authorization: AppID
    ApiKeyAuth AppID = (ApiKeyAuth) defaultClient.getAuthentication("AppID");
    AppID.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //AppID.setApiKeyPrefix("Token");

    PartnerRequestAccessApi apiInstance = new PartnerRequestAccessApi(defaultClient);
    String taxID = "60151449000182"; // String | The raw tax ID from the preregistration that you want to get.
    try {
      ApiV1PartnerCompanyTaxIDGet200Response result = apiInstance.apiV1PartnerCompanyTaxIDGet(taxID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PartnerRequestAccessApi#apiV1PartnerCompanyTaxIDGet");
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
| **taxID** | **String**| The raw tax ID from the preregistration that you want to get. | |

### Return type

[**ApiV1PartnerCompanyTaxIDGet200Response**](ApiV1PartnerCompanyTaxIDGet200Response.md)

### Authorization

[AppID](../README.md#AppID)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The preregistration retrieved by the tax ID. |  -  |
| **400** | An error message |  -  |

