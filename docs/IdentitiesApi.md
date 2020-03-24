# IdentitiesApi

All URIs are relative to *https://sandbox.signingtoday.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**associateAppearance**](IdentitiesApi.md#associateAppearance) | **POST** /{organization-id}/identities/{identity-id}/appearance | Associate an appearance to an identity
[**associateIdentity**](IdentitiesApi.md#associateIdentity) | **POST** /{organization-id}/users/{user-id}/wallet | Associate to an user an already existing identity
[**createTokenFromIdentity**](IdentitiesApi.md#createTokenFromIdentity) | **POST** /{organization-id}/identities/create/token | Create an identity from token
[**deleteAppearance**](IdentitiesApi.md#deleteAppearance) | **DELETE** /{organization-id}/identities/{identity-id}/appearance | Delete the appearance of an identity
[**deleteEnrollmentRequest**](IdentitiesApi.md#deleteEnrollmentRequest) | **DELETE** /{organization-id}/identity-requests/{enrollment-id} | Delete an enrollment request
[**deleteIdentity**](IdentitiesApi.md#deleteIdentity) | **DELETE** /{organization-id}/identities/{identity-id} | Delete an identity
[**getEnrollmentRequest**](IdentitiesApi.md#getEnrollmentRequest) | **GET** /{organization-id}/identity-requests/{enrollment-id} | Get information about an enrollment request
[**getIdentity**](IdentitiesApi.md#getIdentity) | **GET** /{organization-id}/identities/{identity-id} | Get information about an identity
[**listEnrollmentRequests**](IdentitiesApi.md#listEnrollmentRequests) | **GET** /{organization-id}/identity-requests | Enumerate the enrollment requests of an organization
[**listIdentities**](IdentitiesApi.md#listIdentities) | **GET** /{organization-id}/identities | Enumerate the identities of an organization
[**listUserEnrollments**](IdentitiesApi.md#listUserEnrollments) | **GET** /{organization-id}/users/{user-id}/identity-requests | List the enrollments of an user
[**listUserIdentities**](IdentitiesApi.md#listUserIdentities) | **GET** /{organization-id}/users/{user-id}/wallet | Enumerate the identities of an user
[**renewIdentity**](IdentitiesApi.md#renewIdentity) | **POST** /{organization-id}/identity-requests/{enrollment-id}/renew | Renew an Identity
[**requestEnrollment**](IdentitiesApi.md#requestEnrollment) | **POST** /{organization-id}/enroll | Submit an enrollment request


<a name="associateAppearance"></a>
# **associateAppearance**
> InlineResponse2011 associateAppearance(organizationId, identityId, inlineObject)

Associate an appearance to an identity

Associate a signature appearance to an already existing identity through an url to an image. This appearance will be displayed on the document after the signature. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id identityId = new Id(); // Id | The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity 
    InlineObject inlineObject = new InlineObject(); // InlineObject | 
    try {
      InlineResponse2011 result = apiInstance.associateAppearance(organizationId, identityId, inlineObject);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#associateAppearance");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **identityId** | [**Id**](.md)| The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  | [default to null]
 **inlineObject** | [**InlineObject**](InlineObject.md)|  |

### Return type

[**InlineResponse2011**](InlineResponse2011.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**400** | Bad Request |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="associateIdentity"></a>
# **associateIdentity**
> InlineResponse2011 associateIdentity(organizationId, userId, identityAssociation)

Associate to an user an already existing identity

Associate to an user of the organization an already existing identity of a provider. The _provider_data_ field is an object and is different for each provider. The minimum set of information to provide as provider_data is the following:   - **aruba**     - _auth_domain_ : string     - _username_ : string     - _password_ : string   - **aruba-auto**     - _auth_domain_ : string     - _username_ : string     - _password_ : string   - **infocert**     - _username_ : string     - _password_ : string   - **namirial**     - _id_titolare_ : string     - _id_otp_ : string     - _username_ : string     - _password_ : string 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id userId = new Id(); // Id | The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user 
    IdentityAssociation identityAssociation = new IdentityAssociation(); // IdentityAssociation | Provider data to associate
    try {
      InlineResponse2011 result = apiInstance.associateIdentity(organizationId, userId, identityAssociation);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#associateIdentity");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **userId** | [**Id**](.md)| The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  | [default to null]
 **identityAssociation** | [**IdentityAssociation**](IdentityAssociation.md)| Provider data to associate |

### Return type

[**InlineResponse2011**](InlineResponse2011.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="createTokenFromIdentity"></a>
# **createTokenFromIdentity**
> InlineResponse2012 createTokenFromIdentity(organizationId, createIdentitybyToken)

Create an identity from token

This API allows to create an identity from a token. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    CreateIdentitybyToken createIdentitybyToken = new CreateIdentitybyToken(); // CreateIdentitybyToken | Body of the request to create an identity from a token
    try {
      InlineResponse2012 result = apiInstance.createTokenFromIdentity(organizationId, createIdentitybyToken);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#createTokenFromIdentity");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **createIdentitybyToken** | [**CreateIdentitybyToken**](CreateIdentitybyToken.md)| Body of the request to create an identity from a token |

### Return type

[**InlineResponse2012**](InlineResponse2012.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |

<a name="deleteAppearance"></a>
# **deleteAppearance**
> InlineResponse2011 deleteAppearance(organizationId, identityId)

Delete the appearance of an identity

This API allows to delete the appearance associated to an identity. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id identityId = new Id(); // Id | The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity 
    try {
      InlineResponse2011 result = apiInstance.deleteAppearance(organizationId, identityId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#deleteAppearance");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **identityId** | [**Id**](.md)| The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  | [default to null]

### Return type

[**InlineResponse2011**](InlineResponse2011.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="deleteEnrollmentRequest"></a>
# **deleteEnrollmentRequest**
> InlineResponse2012 deleteEnrollmentRequest(organizationId, enrollmentId)

Delete an enrollment request

This API allows to delete an enrollment request. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id enrollmentId = new Id(); // Id | The **enrollment-id** is the uuid code that identifies a specific enrollment request 
    try {
      InlineResponse2012 result = apiInstance.deleteEnrollmentRequest(organizationId, enrollmentId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#deleteEnrollmentRequest");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **enrollmentId** | [**Id**](.md)| The **enrollment-id** is the uuid code that identifies a specific enrollment request  | [default to null]

### Return type

[**InlineResponse2012**](InlineResponse2012.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="deleteIdentity"></a>
# **deleteIdentity**
> InlineResponse2006 deleteIdentity(organizationId, identityId)

Delete an identity

This API allows to delete an identity of an user. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id identityId = new Id(); // Id | The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity 
    try {
      InlineResponse2006 result = apiInstance.deleteIdentity(organizationId, identityId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#deleteIdentity");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **identityId** | [**Id**](.md)| The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  | [default to null]

### Return type

[**InlineResponse2006**](InlineResponse2006.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="getEnrollmentRequest"></a>
# **getEnrollmentRequest**
> InlineResponse2007 getEnrollmentRequest(organizationId, enrollmentId)

Get information about an enrollment request

This API allows to get information about an enrollment request. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id enrollmentId = new Id(); // Id | The **enrollment-id** is the uuid code that identifies a specific enrollment request 
    try {
      InlineResponse2007 result = apiInstance.getEnrollmentRequest(organizationId, enrollmentId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#getEnrollmentRequest");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **enrollmentId** | [**Id**](.md)| The **enrollment-id** is the uuid code that identifies a specific enrollment request  | [default to null]

### Return type

[**InlineResponse2007**](InlineResponse2007.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="getIdentity"></a>
# **getIdentity**
> InlineResponse2005 getIdentity(organizationId, identityId, whereOrder)

Get information about an identity

This API allows to get all the information of an identity. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id identityId = new Id(); // Id | The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity 
    String whereOrder = where_first_name; // String | The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \"**-**\" in front of the value indicates descending order), then the second value and so on
    try {
      InlineResponse2005 result = apiInstance.getIdentity(organizationId, identityId, whereOrder);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#getIdentity");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **identityId** | [**Id**](.md)| The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  | [default to null]
 **whereOrder** | **String**| The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on | [optional]

### Return type

[**InlineResponse2005**](InlineResponse2005.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="listEnrollmentRequests"></a>
# **listEnrollmentRequests**
> InlineResponse2003 listEnrollmentRequests(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder)

Enumerate the enrollment requests of an organization

This API allows to enumerate the enrollment requests of an organization. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    String whereProvider = sms; // String | Returns the identity requests that have been issued by the specified provider
    String whereUser = msa; // String | Returns the identity requests of the specified user, searched by its id
    String whereFirstName = John; // String | Returns the identity requests of the users that have the specified first name
    String whereLastName = Doe; // String | Returns the identity requests of the users that have the specified last name
    String whereRegisteredBy = fba; // String | Returns the identity requests registered by this user
    String whereFiscalCode = MLLSNT82P65Z404U; // String | Returns the identity requests have the specified fiscal code
    Integer page = 1; // Integer | Restricts the search to the chosen page
    Integer count = 100; // Integer | Sets the number of users per page to display
    String whereOrder = where_first_name; // String | The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \"**-**\" in front of the value indicates descending order), then the second value and so on
    try {
      InlineResponse2003 result = apiInstance.listEnrollmentRequests(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#listEnrollmentRequests");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **whereProvider** | **String**| Returns the identity requests that have been issued by the specified provider | [optional]
 **whereUser** | **String**| Returns the identity requests of the specified user, searched by its id | [optional]
 **whereFirstName** | **String**| Returns the identity requests of the users that have the specified first name | [optional]
 **whereLastName** | **String**| Returns the identity requests of the users that have the specified last name | [optional]
 **whereRegisteredBy** | **String**| Returns the identity requests registered by this user | [optional]
 **whereFiscalCode** | **String**| Returns the identity requests have the specified fiscal code | [optional]
 **page** | **Integer**| Restricts the search to the chosen page | [optional]
 **count** | **Integer**| Sets the number of users per page to display | [optional] [default to 100]
 **whereOrder** | **String**| The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on | [optional]

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="listIdentities"></a>
# **listIdentities**
> InlineResponse2002 listIdentities(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder)

Enumerate the identities of an organization

This API allows to enumerate all the users of an organization. It is possible to filter the data using the supported _django lookups_. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    String whereProvider = sms; // String | Returns the identities that have been issued by the specified provider
    String whereUser = msa; // String | Returns the identities of the specified user, searched by its id
    String whereFirstName = John; // String | Returns the identities of the users that have the specified first name
    String whereLastName = Doe; // String | Returns the identities of the users that have the specified last name
    String whereRegisteredBy = fba; // String | Returns the identities registered by this user
    String whereFiscalCode = MLLSNT82P65Z404U; // String | Returns the identities that have the specified fiscal code
    Integer page = 1; // Integer | Restricts the search to the chosen page
    Integer count = 100; // Integer | Sets the number of users per page to display
    String whereOrder = where_first_name; // String | The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \"**-**\" in front of the value indicates descending order), then the second value and so on
    try {
      InlineResponse2002 result = apiInstance.listIdentities(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#listIdentities");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **whereProvider** | **String**| Returns the identities that have been issued by the specified provider | [optional]
 **whereUser** | **String**| Returns the identities of the specified user, searched by its id | [optional]
 **whereFirstName** | **String**| Returns the identities of the users that have the specified first name | [optional]
 **whereLastName** | **String**| Returns the identities of the users that have the specified last name | [optional]
 **whereRegisteredBy** | **String**| Returns the identities registered by this user | [optional]
 **whereFiscalCode** | **String**| Returns the identities that have the specified fiscal code | [optional]
 **page** | **Integer**| Restricts the search to the chosen page | [optional]
 **count** | **Integer**| Sets the number of users per page to display | [optional] [default to 100]
 **whereOrder** | **String**| The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on | [optional]

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="listUserEnrollments"></a>
# **listUserEnrollments**
> InlineResponse2003 listUserEnrollments(organizationId, userId, page, count, whereOrder)

List the enrollments of an user

This API allows to list all the enrollments of an user. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id userId = new Id(); // Id | The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user 
    Integer page = 1; // Integer | Restricts the search to the chosen page
    Integer count = 100; // Integer | Sets the number of users per page to display
    String whereOrder = where_first_name; // String | The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \"**-**\" in front of the value indicates descending order), then the second value and so on
    try {
      InlineResponse2003 result = apiInstance.listUserEnrollments(organizationId, userId, page, count, whereOrder);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#listUserEnrollments");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **userId** | [**Id**](.md)| The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  | [default to null]
 **page** | **Integer**| Restricts the search to the chosen page | [optional]
 **count** | **Integer**| Sets the number of users per page to display | [optional] [default to 100]
 **whereOrder** | **String**| The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on | [optional]

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="listUserIdentities"></a>
# **listUserIdentities**
> InlineResponse2002 listUserIdentities(organizationId, userId, page, count, whereOrder)

Enumerate the identities of an user

This API allows to enumerate all the identities of an user, which are located in its wallet. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id userId = new Id(); // Id | The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user 
    Integer page = 1; // Integer | Restricts the search to the chosen page
    Integer count = 100; // Integer | Sets the number of users per page to display
    String whereOrder = where_first_name; // String | The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \"**-**\" in front of the value indicates descending order), then the second value and so on
    try {
      InlineResponse2002 result = apiInstance.listUserIdentities(organizationId, userId, page, count, whereOrder);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#listUserIdentities");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **userId** | [**Id**](.md)| The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  | [default to null]
 **page** | **Integer**| Restricts the search to the chosen page | [optional]
 **count** | **Integer**| Sets the number of users per page to display | [optional] [default to 100]
 **whereOrder** | **String**| The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on | [optional]

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="renewIdentity"></a>
# **renewIdentity**
> InlineResponse2007 renewIdentity(organizationId, enrollmentId, inlineObject1)

Renew an Identity

This API allows to renew an Identity of a user. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id enrollmentId = new Id(); // Id | The **enrollment-id** is the uuid code that identifies a specific enrollment request 
    InlineObject1 inlineObject1 = new InlineObject1(); // InlineObject1 | 
    try {
      InlineResponse2007 result = apiInstance.renewIdentity(organizationId, enrollmentId, inlineObject1);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#renewIdentity");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **enrollmentId** | [**Id**](.md)| The **enrollment-id** is the uuid code that identifies a specific enrollment request  | [default to null]
 **inlineObject1** | [**InlineObject1**](InlineObject1.md)|  |

### Return type

[**InlineResponse2007**](InlineResponse2007.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**400** | Bad Request |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="requestEnrollment"></a>
# **requestEnrollment**
> InlineResponse2007 requestEnrollment(organizationId, identityRequest)

Submit an enrollment request

This API allows to submit an enrollment request. The user of the request will be created if it does not exists already. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.IdentitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    IdentitiesApi apiInstance = new IdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    IdentityRequest identityRequest = new IdentityRequest(); // IdentityRequest | The enrollment request to submit
    try {
      InlineResponse2007 result = apiInstance.requestEnrollment(organizationId, identityRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IdentitiesApi#requestEnrollment");
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
 **organizationId** | **String**| The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  | [default to &quot;api-demo&quot;]
 **identityRequest** | [**IdentityRequest**](IdentityRequest.md)| The enrollment request to submit |

### Return type

[**InlineResponse2007**](InlineResponse2007.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**409** | Conflict |  -  |

