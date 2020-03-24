# Bit4idPathgroupUsersApi

All URIs are relative to *https://sandbox.signingtoday.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](Bit4idPathgroupUsersApi.md#createUser) | **POST** /{organization-id}/users | Create a user of the organization
[**getUser**](Bit4idPathgroupUsersApi.md#getUser) | **GET** /{organization-id}/users/{user-id} | Get information about an user
[**listUsers**](Bit4idPathgroupUsersApi.md#listUsers) | **GET** /{organization-id}/users | Enumerate the users of an organization
[**updateUser**](Bit4idPathgroupUsersApi.md#updateUser) | **PUT** /{organization-id}/users/{user-id} | Edit one or more user properties


<a name="createUser"></a>
# **createUser**
> InlineResponse201 createUser(organizationId, createUser)

Create a user of the organization

This API allows to create a new user of the organization. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupUsersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupUsersApi apiInstance = new Bit4idPathgroupUsersApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    CreateUser createUser = new CreateUser(); // CreateUser | The new user object to create
    try {
      InlineResponse201 result = apiInstance.createUser(organizationId, createUser);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupUsersApi#createUser");
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
 **createUser** | [**CreateUser**](CreateUser.md)| The new user object to create |

### Return type

[**InlineResponse201**](InlineResponse201.md)

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

<a name="getUser"></a>
# **getUser**
> InlineResponse201 getUser(organizationId, userId)

Get information about an user

This API allows to get information about an user. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupUsersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupUsersApi apiInstance = new Bit4idPathgroupUsersApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id userId = new Id(); // Id | The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user 
    try {
      InlineResponse201 result = apiInstance.getUser(organizationId, userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupUsersApi#getUser");
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

### Return type

[**InlineResponse201**](InlineResponse201.md)

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

<a name="listUsers"></a>
# **listUsers**
> InlineResponse2001 listUsers(organizationId, whereMembershipId, whereEmail, whereLastName, whereFirstName, whereAutomatic, whereRao, page, count, whereOrder)

Enumerate the users of an organization

This API allows to enumerate the users of an organization. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupUsersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupUsersApi apiInstance = new Bit4idPathgroupUsersApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    String whereMembershipId = jdo; // String | Returns the users that have the specified id
    String whereEmail = test@mail.com; // String | Returns the users that have the specified email
    String whereLastName = Doe; // String | Returns the users that have the specified last name
    String whereFirstName = John; // String | Returns the users that have the specified first name
    Boolean whereAutomatic = false; // Boolean | If set up to **true** returns automatic users only, otherwise returns non automatic users only
    Boolean whereRao = false; // Boolean | If set up to **true** returns rao users only, otherwise returns non rao users only
    Integer page = 1; // Integer | Restricts the search to the chosen page
    Integer count = 100; // Integer | Sets the number of users per page to display
    String whereOrder = where_first_name; // String | The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \"**-**\" in front of the value indicates descending order), then the second value and so on
    try {
      InlineResponse2001 result = apiInstance.listUsers(organizationId, whereMembershipId, whereEmail, whereLastName, whereFirstName, whereAutomatic, whereRao, page, count, whereOrder);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupUsersApi#listUsers");
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
 **whereMembershipId** | **String**| Returns the users that have the specified id | [optional]
 **whereEmail** | **String**| Returns the users that have the specified email | [optional]
 **whereLastName** | **String**| Returns the users that have the specified last name | [optional]
 **whereFirstName** | **String**| Returns the users that have the specified first name | [optional]
 **whereAutomatic** | **Boolean**| If set up to **true** returns automatic users only, otherwise returns non automatic users only | [optional]
 **whereRao** | **Boolean**| If set up to **true** returns rao users only, otherwise returns non rao users only | [optional]
 **page** | **Integer**| Restricts the search to the chosen page | [optional]
 **count** | **Integer**| Sets the number of users per page to display | [optional] [default to 100]
 **whereOrder** | **String**| The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

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

<a name="updateUser"></a>
# **updateUser**
> InlineResponse201 updateUser(organizationId, userId, updateUser)

Edit one or more user properties

This API allows to edit one or more user properties. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupUsersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupUsersApi apiInstance = new Bit4idPathgroupUsersApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id userId = new Id(); // Id | The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user 
    UpdateUser updateUser = new UpdateUser(); // UpdateUser | User properties to be edited
    try {
      InlineResponse201 result = apiInstance.updateUser(organizationId, userId, updateUser);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupUsersApi#updateUser");
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
 **updateUser** | [**UpdateUser**](UpdateUser.md)| User properties to be edited |

### Return type

[**InlineResponse201**](InlineResponse201.md)

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

