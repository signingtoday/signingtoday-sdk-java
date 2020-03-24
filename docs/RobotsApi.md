# RobotsApi

All URIs are relative to *https://web.sandbox.signingtoday.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**robotAuthenticationDelete**](RobotsApi.md#robotAuthenticationDelete) | **DELETE** /robot/authentication | Clear a Robot authentication lifetime token
[**robotAuthenticationGet**](RobotsApi.md#robotAuthenticationGet) | **GET** /robot/authentication | Retrieve the Robot authentication lifetime token
[**robotConfigurationGet**](RobotsApi.md#robotConfigurationGet) | **GET** /robot/configuration | Retrieve the Robot configuration
[**robotDSTsPost**](RobotsApi.md#robotDSTsPost) | **POST** /robot/DSTs | Create a new DST in one call
[**robotIdInstantiatePost**](RobotsApi.md#robotIdInstantiatePost) | **POST** /robot/{id}/instantiate | Instantiate a DST from a template by robot


<a name="robotAuthenticationDelete"></a>
# **robotAuthenticationDelete**
> robotAuthenticationDelete(username, domain)

Clear a Robot authentication lifetime token

This API allows to clear the Robot authentication lifetime token.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.RobotsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RobotsApi apiInstance = new RobotsApi(defaultClient);
    String username = thirdPartApp; // String | The _username_ associated to the account
    String domain = demo; // String | The _domain_ associated to the account
    try {
      apiInstance.robotAuthenticationDelete(username, domain);
    } catch (ApiException e) {
      System.err.println("Exception when calling RobotsApi#robotAuthenticationDelete");
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
 **username** | **String**| The _username_ associated to the account | [optional]
 **domain** | **String**| The _domain_ associated to the account | [optional]

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

<a name="robotAuthenticationGet"></a>
# **robotAuthenticationGet**
> RobotAuthenticationToken robotAuthenticationGet(username, domain)

Retrieve the Robot authentication lifetime token

This API allows to generate or retrieves the Robot authentication lifetime token for the specified robot account, or the current logged in account. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.RobotsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RobotsApi apiInstance = new RobotsApi(defaultClient);
    String username = thirdPartApp; // String | The _username_ associated to the account
    String domain = demo; // String | The _domain_ associated to the account
    try {
      RobotAuthenticationToken result = apiInstance.robotAuthenticationGet(username, domain);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RobotsApi#robotAuthenticationGet");
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
 **username** | **String**| The _username_ associated to the account | [optional]
 **domain** | **String**| The _domain_ associated to the account | [optional]

### Return type

[**RobotAuthenticationToken**](RobotAuthenticationToken.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The lifetime robot token. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**500** | Internal failure of the service. |  -  |

<a name="robotConfigurationGet"></a>
# **robotConfigurationGet**
> RobotConfiguration robotConfigurationGet(username, domain)

Retrieve the Robot configuration

This API allows to retrieve the Robot configuration. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.RobotsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RobotsApi apiInstance = new RobotsApi(defaultClient);
    String username = thirdPartApp; // String | The _username_ associated to the account
    String domain = demo; // String | The _domain_ associated to the account
    try {
      RobotConfiguration result = apiInstance.robotConfigurationGet(username, domain);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RobotsApi#robotConfigurationGet");
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
 **username** | **String**| The _username_ associated to the account | [optional]
 **domain** | **String**| The _domain_ associated to the account | [optional]

### Return type

[**RobotConfiguration**](RobotConfiguration.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The Robot configuration. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**500** | Internal failure of the service. |  -  |

<a name="robotDSTsPost"></a>
# **robotDSTsPost**
> DigitalSignatureTransaction robotDSTsPost(createDigitalSignatureTransaction)

Create a new DST in one call

This API allows to create a new DST with a more convenient interface for client applications. The purpose is to provide a method for the creation of a DST in order to semplify the integration into third part applications. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.RobotsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RobotsApi apiInstance = new RobotsApi(defaultClient);
    CreateDigitalSignatureTransaction createDigitalSignatureTransaction = new CreateDigitalSignatureTransaction(); // CreateDigitalSignatureTransaction | description
    try {
      DigitalSignatureTransaction result = apiInstance.robotDSTsPost(createDigitalSignatureTransaction);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RobotsApi#robotDSTsPost");
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
 **createDigitalSignatureTransaction** | [**CreateDigitalSignatureTransaction**](CreateDigitalSignatureTransaction.md)| description |

### Return type

[**DigitalSignatureTransaction**](DigitalSignatureTransaction.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The new DST. |  -  |
**400** | Result of a client passing incorrect or invalid data. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="robotIdInstantiatePost"></a>
# **robotIdInstantiatePost**
> DigitalSignatureTransaction robotIdInstantiatePost(id, instantiateDSTTemplate)

Instantiate a DST from a template by robot

This API allows to instantiate a DST from a template patching parts of its data structure. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.RobotsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RobotsApi apiInstance = new RobotsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    InstantiateDSTTemplate instantiateDSTTemplate = new InstantiateDSTTemplate(); // InstantiateDSTTemplate | 
    try {
      DigitalSignatureTransaction result = apiInstance.robotIdInstantiatePost(id, instantiateDSTTemplate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RobotsApi#robotIdInstantiatePost");
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
 **instantiateDSTTemplate** | [**InstantiateDSTTemplate**](InstantiateDSTTemplate.md)|  |

### Return type

[**DigitalSignatureTransaction**](DigitalSignatureTransaction.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The new DST that has been generated as an instance of the template. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

