# Bit4idPathgroupTokensApi

All URIs are relative to *https://sandbox.signingtoday.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createToken**](Bit4idPathgroupTokensApi.md#createToken) | **POST** /{organization-id}/tokens | Create an application token
[**deleteToken**](Bit4idPathgroupTokensApi.md#deleteToken) | **DELETE** /{organization-id}/tokens/{token-id} | Delete a token of the organization
[**getToken**](Bit4idPathgroupTokensApi.md#getToken) | **GET** /{organization-id}/tokens/{token-id} | Get information about a token
[**listTokens**](Bit4idPathgroupTokensApi.md#listTokens) | **GET** /{organization-id}/tokens | Enumerate the tokens of an organization
[**listUserTokens**](Bit4idPathgroupTokensApi.md#listUserTokens) | **GET** /{organization-id}/users/{user-id}/tokens | Enumerate the tokens of an user
[**updateToken**](Bit4idPathgroupTokensApi.md#updateToken) | **PUT** /{organization-id}/tokens/{token-id} | Update the properties of a token


<a name="createToken"></a>
# **createToken**
> InlineResponse2015 createToken(organizationId, createToken)

Create an application token

This API allows to create an application token. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupTokensApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupTokensApi apiInstance = new Bit4idPathgroupTokensApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    CreateToken createToken = new CreateToken(); // CreateToken | Token data
    try {
      InlineResponse2015 result = apiInstance.createToken(organizationId, createToken);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupTokensApi#createToken");
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
 **createToken** | [**CreateToken**](CreateToken.md)| Token data |

### Return type

[**InlineResponse2015**](InlineResponse2015.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Bad Request |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="deleteToken"></a>
# **deleteToken**
> InlineResponse2012 deleteToken(organizationId, tokenId)

Delete a token of the organization

This API allows to delete a token of the organization. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupTokensApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupTokensApi apiInstance = new Bit4idPathgroupTokensApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id tokenId = new Id(); // Id | The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token 
    try {
      InlineResponse2012 result = apiInstance.deleteToken(organizationId, tokenId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupTokensApi#deleteToken");
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
 **tokenId** | [**Id**](.md)| The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  | [default to null]

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

<a name="getToken"></a>
# **getToken**
> InlineResponse2015 getToken(organizationId, tokenId)

Get information about a token

This API allows to get information about a token. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupTokensApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupTokensApi apiInstance = new Bit4idPathgroupTokensApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id tokenId = new Id(); // Id | The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token 
    try {
      InlineResponse2015 result = apiInstance.getToken(organizationId, tokenId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupTokensApi#getToken");
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
 **tokenId** | [**Id**](.md)| The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  | [default to null]

### Return type

[**InlineResponse2015**](InlineResponse2015.md)

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

<a name="listTokens"></a>
# **listTokens**
> InlineResponse2004 listTokens(organizationId, whereUser, whereLabel, count, page, whereOrder)

Enumerate the tokens of an organization

This API allows to enumerate the tokens of an organization. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupTokensApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupTokensApi apiInstance = new Bit4idPathgroupTokensApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    String whereUser = jdo; // String | Returns the tokens of the specified user, searched by its id
    String whereLabel = token; // String | Returns the tokens with the specified label
    Integer count = 100; // Integer | Sets the number of tokens per page to display
    Integer page = 1; // Integer | Restricts the search to chosen page
    String whereOrder = where_first_name; // String | The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \"**-**\" in front of the value indicates descending order), then the second value and so on
    try {
      InlineResponse2004 result = apiInstance.listTokens(organizationId, whereUser, whereLabel, count, page, whereOrder);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupTokensApi#listTokens");
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
 **whereUser** | **String**| Returns the tokens of the specified user, searched by its id | [optional]
 **whereLabel** | **String**| Returns the tokens with the specified label | [optional]
 **count** | **Integer**| Sets the number of tokens per page to display | [optional] [default to 100]
 **page** | **Integer**| Restricts the search to chosen page | [optional]
 **whereOrder** | **String**| The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on | [optional]

### Return type

[**InlineResponse2004**](InlineResponse2004.md)

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

<a name="listUserTokens"></a>
# **listUserTokens**
> InlineResponse2004 listUserTokens(organizationId, userId, page, count, whereOrder)

Enumerate the tokens of an user

This API allows to enumerate all the tokens of an user. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupTokensApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupTokensApi apiInstance = new Bit4idPathgroupTokensApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id userId = new Id(); // Id | The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user 
    Integer page = 1; // Integer | Restricts the search to the chosen page
    Integer count = 100; // Integer | Sets the number of users per page to display
    String whereOrder = where_first_name; // String | The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \"**-**\" in front of the value indicates descending order), then the second value and so on
    try {
      InlineResponse2004 result = apiInstance.listUserTokens(organizationId, userId, page, count, whereOrder);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupTokensApi#listUserTokens");
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

[**InlineResponse2004**](InlineResponse2004.md)

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

<a name="updateToken"></a>
# **updateToken**
> InlineResponse2015 updateToken(organizationId, tokenId, updateToken)

Update the properties of a token

This API allows to update the properties of a token. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupTokensApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupTokensApi apiInstance = new Bit4idPathgroupTokensApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id tokenId = new Id(); // Id | The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token 
    UpdateToken updateToken = new UpdateToken(); // UpdateToken | Token data
    try {
      InlineResponse2015 result = apiInstance.updateToken(organizationId, tokenId, updateToken);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupTokensApi#updateToken");
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
 **tokenId** | [**Id**](.md)| The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  | [default to null]
 **updateToken** | [**UpdateToken**](UpdateToken.md)| Token data |

### Return type

[**InlineResponse2015**](InlineResponse2015.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

