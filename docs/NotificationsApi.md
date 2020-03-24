# NotificationsApi

All URIs are relative to *https://web.sandbox.signingtoday.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**notificationsDstIdDelete**](NotificationsApi.md#notificationsDstIdDelete) | **DELETE** /notifications/dst/{id} | Clear Notifications for a DST
[**notificationsDstsGet**](NotificationsApi.md#notificationsDstsGet) | **GET** /notifications/dsts | Get latest DST Notifications
[**notificationsPushTokenDelete**](NotificationsApi.md#notificationsPushTokenDelete) | **DELETE** /notifications/push-token | Clear a registered push notification token
[**notificationsPushTokenPost**](NotificationsApi.md#notificationsPushTokenPost) | **POST** /notifications/push-token | Register a token for push notifications


<a name="notificationsDstIdDelete"></a>
# **notificationsDstIdDelete**
> notificationsDstIdDelete(id)

Clear Notifications for a DST

This API notifies that a user consumed all active notifications for a DST.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.NotificationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    NotificationsApi apiInstance = new NotificationsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      apiInstance.notificationsDstIdDelete(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling NotificationsApi#notificationsDstIdDelete");
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
 **id** | [**UUID**](.md)| The value of _the unique id_ |

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

<a name="notificationsDstsGet"></a>
# **notificationsDstsGet**
> NotificationsResponse notificationsDstsGet($top, $skip, $count)

Get latest DST Notifications

This APIs allows to get latest user Notifications for DSTs sorted desc by time.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.NotificationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    NotificationsApi apiInstance = new NotificationsApi(defaultClient);
    Integer $top = 32; // Integer | A number of results to return. Applied after **$skip** 
    Long $skip = 64; // Long | An offset into the collection of results
    Boolean $count = true; // Boolean | If true, the server includes the count of all the items in the response 
    try {
      NotificationsResponse result = apiInstance.notificationsDstsGet($top, $skip, $count);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling NotificationsApi#notificationsDstsGet");
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
 **$top** | **Integer**| A number of results to return. Applied after **$skip**  | [optional]
 **$skip** | **Long**| An offset into the collection of results | [optional]
 **$count** | **Boolean**| If true, the server includes the count of all the items in the response  | [optional]

### Return type

[**NotificationsResponse**](NotificationsResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Last DST notifications. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**500** | Internal failure of the service. |  -  |

<a name="notificationsPushTokenDelete"></a>
# **notificationsPushTokenDelete**
> notificationsPushTokenDelete(deviceId)

Clear a registered push notification token

This API deregister a deviceId from the push notifications.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.NotificationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    NotificationsApi apiInstance = new NotificationsApi(defaultClient);
    String deviceId = 05ea656f-df69-49b1-a12b-9bf640c427c2; // String | The _deviceId_ to deregister
    try {
      apiInstance.notificationsPushTokenDelete(deviceId);
    } catch (ApiException e) {
      System.err.println("Exception when calling NotificationsApi#notificationsPushTokenDelete");
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

<a name="notificationsPushTokenPost"></a>
# **notificationsPushTokenPost**
> notificationsPushTokenPost(inlineObject6)

Register a token for push notifications

This API allows to register a token for push notifications. Only trusted deviceId can be registered. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.NotificationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    NotificationsApi apiInstance = new NotificationsApi(defaultClient);
    InlineObject6 inlineObject6 = new InlineObject6(); // InlineObject6 | 
    try {
      apiInstance.notificationsPushTokenPost(inlineObject6);
    } catch (ApiException e) {
      System.err.println("Exception when calling NotificationsApi#notificationsPushTokenPost");
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
 **inlineObject6** | [**InlineObject6**](InlineObject6.md)|  |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | The request has been satisfyied. No output. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

