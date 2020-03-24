# SigningServicesApi

All URIs are relative to *https://web.sandbox.signingtoday.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**signServiceOpen**](SigningServicesApi.md#signServiceOpen) | **POST** /sign-service/open | sign-service open post
[**signServiceOpenId**](SigningServicesApi.md#signServiceOpenId) | **POST** /sign-service/open/{transaction-id} | sign-service-open-transaction-id post
[**signatureIdPerformIdPost**](SigningServicesApi.md#signatureIdPerformIdPost) | **POST** /sign-service/{signature-id}/perform/{identity-id} | sign-service-signature-id-perform-identity-id post


<a name="signServiceOpen"></a>
# **signServiceOpen**
> Object signServiceOpen()

sign-service open post

description bla bla

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.SigningServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SigningServicesApi apiInstance = new SigningServicesApi(defaultClient);
    try {
      Object result = apiInstance.signServiceOpen();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SigningServicesApi#signServiceOpen");
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

**Object**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="signServiceOpenId"></a>
# **signServiceOpenId**
> Object signServiceOpenId(transactionId)

sign-service-open-transaction-id post

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.SigningServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SigningServicesApi apiInstance = new SigningServicesApi(defaultClient);
    String transactionId = "transactionId_example"; // String | 
    try {
      Object result = apiInstance.signServiceOpenId(transactionId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SigningServicesApi#signServiceOpenId");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **transactionId** | **String**|  |

### Return type

**Object**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |

<a name="signatureIdPerformIdPost"></a>
# **signatureIdPerformIdPost**
> Object signatureIdPerformIdPost(signatureId, identityId, inlineObject8)

sign-service-signature-id-perform-identity-id post

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.SigningServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SigningServicesApi apiInstance = new SigningServicesApi(defaultClient);
    String signatureId = "signatureId_example"; // String | 
    String identityId = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // String | 
    InlineObject8 inlineObject8 = new InlineObject8(); // InlineObject8 | 
    try {
      Object result = apiInstance.signatureIdPerformIdPost(signatureId, identityId, inlineObject8);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SigningServicesApi#signatureIdPerformIdPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **signatureId** | **String**|  |
 **identityId** | **String**|  |
 **inlineObject8** | [**InlineObject8**](InlineObject8.md)|  | [optional]

### Return type

**Object**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

