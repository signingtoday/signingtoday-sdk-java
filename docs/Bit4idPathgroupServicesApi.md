# Bit4idPathgroupServicesApi

All URIs are relative to *https://web.sandbox.signingtoday.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authChangePasswordPost**](Bit4idPathgroupServicesApi.md#authChangePasswordPost) | **POST** /auth/changePassword | Consume a token to change the password
[**authPasswordLostGet**](Bit4idPathgroupServicesApi.md#authPasswordLostGet) | **GET** /auth/passwordLost | Request to recover own password
[**authPasswordResetGet**](Bit4idPathgroupServicesApi.md#authPasswordResetGet) | **GET** /auth/passwordReset | Reset a user password with superuser
[**authPasswordResetPost**](Bit4idPathgroupServicesApi.md#authPasswordResetPost) | **POST** /auth/passwordReset | Reset your own password
[**authPasswordTokenGet**](Bit4idPathgroupServicesApi.md#authPasswordTokenGet) | **GET** /auth/passwordToken | Get token to change password
[**authSamlPost**](Bit4idPathgroupServicesApi.md#authSamlPost) | **POST** /auth/saml | Register or Update a SAML user
[**authUser**](Bit4idPathgroupServicesApi.md#authUser) | **GET** /auth/user | Return the current logged in user
[**configurationGet**](Bit4idPathgroupServicesApi.md#configurationGet) | **GET** /service/configuration | Retrieve the App configuration
[**logoutUser**](Bit4idPathgroupServicesApi.md#logoutUser) | **GET** /auth/logout | Log out current user terminating the session
[**oauthTokenPost**](Bit4idPathgroupServicesApi.md#oauthTokenPost) | **POST** /oauth/token | Get the bearer token
[**pdfResourceIdThumbsGet**](Bit4idPathgroupServicesApi.md#pdfResourceIdThumbsGet) | **GET** /pdfResource/{id}/thumbs | Retrieve a Resource (of service)
[**serviceChangePasswordPost**](Bit4idPathgroupServicesApi.md#serviceChangePasswordPost) | **POST** /service/changePassword | Change the password of a service user
[**serviceUsersSyncPost**](Bit4idPathgroupServicesApi.md#serviceUsersSyncPost) | **POST** /service/users/sync | Sync user accounts


<a name="authChangePasswordPost"></a>
# **authChangePasswordPost**
> authChangePasswordPost(passwordToken, body)

Consume a token to change the password

This API allows to change the password by consuming a token.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    String passwordToken = 05ea656f-df69-49b1-a12b-9bf640c427c2; // String | The password token issued to change password
    String body = "body_example"; // String | New password associated to the account (BCrypt)
    try {
      apiInstance.authChangePasswordPost(passwordToken, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#authChangePasswordPost");
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
 **passwordToken** | **String**| The password token issued to change password |
 **body** | **String**| New password associated to the account (BCrypt) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | The request has been satisfyied. No output. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="authPasswordLostGet"></a>
# **authPasswordLostGet**
> authPasswordLostGet(username, domain)

Request to recover own password

This API requests to recover the own password.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    String username = jdo; // String | Username associated to the account
    String domain = demo; // String | Domain associated to the account
    try {
      apiInstance.authPasswordLostGet(username, domain);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#authPasswordLostGet");
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
 **username** | **String**| Username associated to the account |
 **domain** | **String**| Domain associated to the account |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | The request has been satisfyied. No output. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="authPasswordResetGet"></a>
# **authPasswordResetGet**
> authPasswordResetGet(username, domain)

Reset a user password with superuser

This API allows to reset the password of a user. This is possible when the request is performed with a superuser.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    String username = jdo; // String | Username associated to the account
    String domain = demo; // String | Domain associated to the account
    try {
      apiInstance.authPasswordResetGet(username, domain);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#authPasswordResetGet");
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
 **username** | **String**| Username associated to the account |
 **domain** | **String**| Domain associated to the account |

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
**403** | User is not allowed to perform the request. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="authPasswordResetPost"></a>
# **authPasswordResetPost**
> authPasswordResetPost(inlineObject4)

Reset your own password

This API allows to reset your own password knowing the previous one with a logged user.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    InlineObject4 inlineObject4 = new InlineObject4(); // InlineObject4 | 
    try {
      apiInstance.authPasswordResetPost(inlineObject4);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#authPasswordResetPost");
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
 **inlineObject4** | [**InlineObject4**](InlineObject4.md)|  |

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
**403** | User is not allowed to perform the request. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="authPasswordTokenGet"></a>
# **authPasswordTokenGet**
> List&lt;Object&gt; authPasswordTokenGet()

Get token to change password

This API allows to get a password token to use in order to change a password.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    try {
      List<Object> result = apiInstance.authPasswordTokenGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#authPasswordTokenGet");
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

**List&lt;Object&gt;**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A password token associated to the logged user. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="authSamlPost"></a>
# **authSamlPost**
> authSamlPost(domain, idToken1, idToken2)

Register or Update a SAML user

This API allows to register or Update a SAML user.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    String domain = "domain_example"; // String | SAML domain
    String idToken1 = "idToken1_example"; // String | The BASE64-encoded SAML Reply in JSON
    String idToken2 = "idToken2_example"; // String | The Hex-encoded HMAC-SHA256 of the decoded IDToken1
    try {
      apiInstance.authSamlPost(domain, idToken1, idToken2);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#authSamlPost");
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
 **domain** | **String**| SAML domain |
 **idToken1** | **String**| The BASE64-encoded SAML Reply in JSON |
 **idToken2** | **String**| The Hex-encoded HMAC-SHA256 of the decoded IDToken1 |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**303** | Redirect to frontend page with new auth token (Post/Redirect/Get design pattern). |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="authUser"></a>
# **authUser**
> User authUser()

Return the current logged in user

This API allows to retrieve the current logged in user.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    try {
      User result = apiInstance.authUser();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#authUser");
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

[**User**](User.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Return current logged in user |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**500** | Internal failure of the service. |  -  |

<a name="configurationGet"></a>
# **configurationGet**
> Map&lt;String, Object&gt; configurationGet()

Retrieve the App configuration

This API allows to get the public configuration associated to the application. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    try {
      Map<String, Object> result = apiInstance.configurationGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#configurationGet");
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

**Map&lt;String, Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="logoutUser"></a>
# **logoutUser**
> logoutUser()

Log out current user terminating the session

This API allows to Log out current user.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    try {
      apiInstance.logoutUser();
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#logoutUser");
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

<a name="oauthTokenPost"></a>
# **oauthTokenPost**
> InlineResponse200 oauthTokenPost(username, password, grantType)

Get the bearer token

This API allows to get the token needed to access other APIs through the OAuth2 authentication.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    String username = "username_example"; // String | The username in the form _username_@_domain_ where *domain* is the organization the user belongs to
    String password = "password_example"; // String | This is the actual password of the user
    String grantType = "grantType_example"; // String | A parameter that indicates the type of the grant in order to perform the basic authentication
    try {
      InlineResponse200 result = apiInstance.oauthTokenPost(username, password, grantType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#oauthTokenPost");
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
 **username** | **String**| The username in the form _username_@_domain_ where *domain* is the organization the user belongs to | [optional]
 **password** | **String**| This is the actual password of the user | [optional]
 **grantType** | **String**| A parameter that indicates the type of the grant in order to perform the basic authentication | [optional] [enum: password]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OAuth Access Token |  -  |

<a name="pdfResourceIdThumbsGet"></a>
# **pdfResourceIdThumbsGet**
> File pdfResourceIdThumbsGet(id, page, width)

Retrieve a Resource (of service)

This API allows to extract thumbnails from a PDF Resource.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    Integer page = 1; // Integer | The page to retrieve
    Integer width = 20; // Integer | The output image width
    try {
      File result = apiInstance.pdfResourceIdThumbsGet(id, page, width);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#pdfResourceIdThumbsGet");
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
 **page** | **Integer**| The page to retrieve |
 **width** | **Integer**| The output image width | [optional]

### Return type

[**File**](File.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: image/jpeg, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The output is a raw string. The thumbnails of the page requested for the PDF resource. |  -  |
**400** | Result of a client passing incorrect or invalid data. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="serviceChangePasswordPost"></a>
# **serviceChangePasswordPost**
> serviceChangePasswordPost(username, domain, body)

Change the password of a service user

This API allows to change the password of a **service user**. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    String username = jdo; // String | Username associated to the account
    String domain = demo; // String | Domain associated to the account
    String body = "body_example"; // String | New password associated to the account (BCrypt)
    try {
      apiInstance.serviceChangePasswordPost(username, domain, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#serviceChangePasswordPost");
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
 **username** | **String**| Username associated to the account |
 **domain** | **String**| Domain associated to the account |
 **body** | **String**| New password associated to the account (BCrypt) |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | The request has been satisfyied. No output. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="serviceUsersSyncPost"></a>
# **serviceUsersSyncPost**
> UserSyncReport serviceUsersSyncPost(inlineObject)

Sync user accounts

This API allows to sync user accounts.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    Bit4idPathgroupServicesApi apiInstance = new Bit4idPathgroupServicesApi(defaultClient);
    List<InlineObject> inlineObject = Arrays.asList(); // List<InlineObject> | User Accounts
    try {
      UserSyncReport result = apiInstance.serviceUsersSyncPost(inlineObject);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupServicesApi#serviceUsersSyncPost");
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
 **inlineObject** | [**List&lt;InlineObject&gt;**](InlineObject.md)| User Accounts |

### Return type

[**UserSyncReport**](UserSyncReport.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Report of last sync. |  -  |
**400** | Result of a client passing incorrect or invalid data. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**500** | Internal failure of the service. |  -  |

