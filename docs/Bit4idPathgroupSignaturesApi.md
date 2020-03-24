# Bit4idPathgroupSignaturesApi

All URIs are relative to *https://sandbox.signingtoday.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createChannel**](Bit4idPathgroupSignaturesApi.md#createChannel) | **POST** /{organization-id}/channels/{dst-id} | Create a channel
[**declineDST**](Bit4idPathgroupSignaturesApi.md#declineDST) | **POST** /{organization-id}/signatures/{signature-id}/decline | Decline a Digital Signature Transaction
[**performDST**](Bit4idPathgroupSignaturesApi.md#performDST) | **POST** /{organization-id}/signatures/{signature-id}/perform | Sign a DST with an automatic signer
[**performSignature**](Bit4idPathgroupSignaturesApi.md#performSignature) | **POST** /{organization-id}/signatures/{signature-id}/perform/{identity-id} | Perform a Signature
[**performSignatureWithSession**](Bit4idPathgroupSignaturesApi.md#performSignatureWithSession) | **POST** /{organization-id}/signatures/{signature-id}/session-perform | Perform a Signature with session


<a name="createChannel"></a>
# **createChannel**
> InlineResponse2014 createChannel(organizationId, dstId)

Create a channel

This API allows to create a channel in order to dispose, by another API, the scheduling of a signature. These two APIs are used to integrate SigningToday into another application. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupSignaturesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupSignaturesApi apiInstance = new Bit4idPathgroupSignaturesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id dstId = new Id(); // Id | The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst** 
    try {
      InlineResponse2014 result = apiInstance.createChannel(organizationId, dstId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupSignaturesApi#createChannel");
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
 **dstId** | [**Id**](.md)| The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  | [default to null]

### Return type

[**InlineResponse2014**](InlineResponse2014.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="declineDST"></a>
# **declineDST**
> InlineResponse2013 declineDST(organizationId, signatureId, inlineObject5)

Decline a Digital Signature Transaction

This API allows to decline the Signature of a digital signature transaction providing a reason. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupSignaturesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupSignaturesApi apiInstance = new Bit4idPathgroupSignaturesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id signatureId = new Id(); // Id | The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction 
    InlineObject5 inlineObject5 = new InlineObject5(); // InlineObject5 | 
    try {
      InlineResponse2013 result = apiInstance.declineDST(organizationId, signatureId, inlineObject5);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupSignaturesApi#declineDST");
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
 **signatureId** | [**Id**](.md)| The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  | [default to null]
 **inlineObject5** | [**InlineObject5**](InlineObject5.md)|  |

### Return type

[**InlineResponse2013**](InlineResponse2013.md)

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
**409** | Conflict |  -  |

<a name="performDST"></a>
# **performDST**
> InlineResponse20011 performDST(organizationId, signatureId, automaticSignature)

Sign a DST with an automatic signer

This API allows to sign a Digital Signature Transaction with an automatic signer certificate. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupSignaturesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupSignaturesApi apiInstance = new Bit4idPathgroupSignaturesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id signatureId = new Id(); // Id | The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction 
    AutomaticSignature automaticSignature = new AutomaticSignature(); // AutomaticSignature | Automatic Signature description
    try {
      InlineResponse20011 result = apiInstance.performDST(organizationId, signatureId, automaticSignature);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupSignaturesApi#performDST");
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
 **signatureId** | [**Id**](.md)| The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  | [default to null]
 **automaticSignature** | [**AutomaticSignature**](AutomaticSignature.md)| Automatic Signature description |

### Return type

[**InlineResponse20011**](InlineResponse20011.md)

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

<a name="performSignature"></a>
# **performSignature**
> InlineResponse20012 performSignature(organizationId, signatureId, identityId, inlineObject3)

Perform a Signature

This API allows to integrate SigningToday into another application. Through this endpoint it is possible to schedule a signature into engine. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupSignaturesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupSignaturesApi apiInstance = new Bit4idPathgroupSignaturesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id signatureId = new Id(); // Id | The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction 
    Id identityId = new Id(); // Id | The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity 
    InlineObject3 inlineObject3 = new InlineObject3(); // InlineObject3 | 
    try {
      InlineResponse20012 result = apiInstance.performSignature(organizationId, signatureId, identityId, inlineObject3);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupSignaturesApi#performSignature");
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
 **signatureId** | [**Id**](.md)| The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  | [default to null]
 **identityId** | [**Id**](.md)| The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  | [default to null]
 **inlineObject3** | [**InlineObject3**](InlineObject3.md)|  |

### Return type

[**InlineResponse20012**](InlineResponse20012.md)

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

<a name="performSignatureWithSession"></a>
# **performSignatureWithSession**
> InlineResponse20013 performSignatureWithSession(organizationId, signatureId, inlineObject4)

Perform a Signature with session

This API allows to perform one or more signatures within the same session. This way is possible, in the scenario of a simple signature for example, to perform multiple signatures using the same _one time password_. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupSignaturesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupSignaturesApi apiInstance = new Bit4idPathgroupSignaturesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id signatureId = new Id(); // Id | The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction 
    InlineObject4 inlineObject4 = new InlineObject4(); // InlineObject4 | 
    try {
      InlineResponse20013 result = apiInstance.performSignatureWithSession(organizationId, signatureId, inlineObject4);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupSignaturesApi#performSignatureWithSession");
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
 **signatureId** | [**Id**](.md)| The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  | [default to null]
 **inlineObject4** | [**InlineObject4**](InlineObject4.md)|  |

### Return type

[**InlineResponse20013**](InlineResponse20013.md)

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

