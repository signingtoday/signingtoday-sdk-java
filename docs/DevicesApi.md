# DevicesApi

All URIs are relative to *https://web.sandbox.signingtoday.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deviceAuthorizationDelete**](DevicesApi.md#deviceAuthorizationDelete) | **DELETE** /device/authorization | Clear a trusted device
[**deviceAuthorizationGet**](DevicesApi.md#deviceAuthorizationGet) | **GET** /device/authorization | Retrieve a challenge for authorizing a new trusted device
[**deviceAuthorizationPost**](DevicesApi.md#deviceAuthorizationPost) | **POST** /device/authorization | Register a new trusted device
[**devicesGet**](DevicesApi.md#devicesGet) | **GET** /devices | Get the list of trusted devices


<a name="deviceAuthorizationDelete"></a>
# **deviceAuthorizationDelete**
> deviceAuthorizationDelete(deviceId, userId)

Clear a trusted device

This APIs allows to deregister a _deviceId_ of a trusted device.  It also deletes any notification push-token associated to the trusted device. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DevicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DevicesApi apiInstance = new DevicesApi(defaultClient);
    String deviceId = 05ea656f-df69-49b1-a12b-9bf640c427c2; // String | The _deviceId_ to deregister
    UUID userId = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | Select the objects relative to the user specified by the parameter. If not specified will be used the id of the current authenticated user
    try {
      apiInstance.deviceAuthorizationDelete(deviceId, userId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DevicesApi#deviceAuthorizationDelete");
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
 **deviceId** | **String**| The _deviceId_ to deregister |
 **userId** | [**UUID**](.md)| Select the objects relative to the user specified by the parameter. If not specified will be used the id of the current authenticated user | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | The request has been satisfyied. No output. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**500** | Internal failure of the service. |  -  |

<a name="deviceAuthorizationGet"></a>
# **deviceAuthorizationGet**
> DeviceAuthorizationResponse deviceAuthorizationGet()

Retrieve a challenge for authorizing a new trusted device

This API allows to retrieve a challenge in order to authorize a new trusted device.   - If asked in image/png the challenge is given encoded as a QR-Code image.   - An invocation of the endpoint invalidate any previous challenge.   - The challenge lasts 10 minutes. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DevicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DevicesApi apiInstance = new DevicesApi(defaultClient);
    try {
      DeviceAuthorizationResponse result = apiInstance.deviceAuthorizationGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DevicesApi#deviceAuthorizationGet");
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

[**DeviceAuthorizationResponse**](DeviceAuthorizationResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, image/png, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The challenge to be used for the authorization. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**500** | Internal failure of the service. |  -  |

<a name="deviceAuthorizationPost"></a>
# **deviceAuthorizationPost**
> List&lt;UUID&gt; deviceAuthorizationPost(inlineObject7)

Register a new trusted device

This API allows to register a new trusted device. If the device is already present, it returns the current associated Token and updates the name. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.models.*;
import signingToday.client.api.DevicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");

    DevicesApi apiInstance = new DevicesApi(defaultClient);
    InlineObject7 inlineObject7 = new InlineObject7(); // InlineObject7 | 
    try {
      List<UUID> result = apiInstance.deviceAuthorizationPost(inlineObject7);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DevicesApi#deviceAuthorizationPost");
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
 **inlineObject7** | [**InlineObject7**](InlineObject7.md)|  |

### Return type

[**List&lt;UUID&gt;**](UUID.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The token to be used for next calls of the endpoint /device/authorize. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**500** | Internal failure of the service. |  -  |

<a name="devicesGet"></a>
# **devicesGet**
> TrustedDevicesGetResponse devicesGet(userId, $top, $skip, $count)

Get the list of trusted devices

The API allows to enumerate all the devices of a user. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DevicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DevicesApi apiInstance = new DevicesApi(defaultClient);
    UUID userId = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | Select the objects relative to the user specified by the parameter. If not specified will be used the id of the current authenticated user
    Integer $top = 32; // Integer | A number of results to return. Applied after **$skip** 
    Long $skip = 64; // Long | An offset into the collection of results
    Boolean $count = true; // Boolean | If true, the server includes the count of all the items in the response 
    try {
      TrustedDevicesGetResponse result = apiInstance.devicesGet(userId, $top, $skip, $count);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DevicesApi#devicesGet");
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
 **userId** | [**UUID**](.md)| Select the objects relative to the user specified by the parameter. If not specified will be used the id of the current authenticated user | [optional]
 **$top** | **Integer**| A number of results to return. Applied after **$skip**  | [optional]
 **$skip** | **Long**| An offset into the collection of results | [optional]
 **$count** | **Boolean**| If true, the server includes the count of all the items in the response  | [optional]

### Return type

[**TrustedDevicesGetResponse**](TrustedDevicesGetResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The list of trusted devices. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |

