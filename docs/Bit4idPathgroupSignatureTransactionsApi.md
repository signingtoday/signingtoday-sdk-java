# Bit4idPathgroupSignatureTransactionsApi

All URIs are relative to *https://sandbox.signingtoday.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**cancelDST**](Bit4idPathgroupSignatureTransactionsApi.md#cancelDST) | **POST** /{organization-id}/signature-transactions/{dst-id}/cancel | Mark a DST as canceled
[**createDST**](Bit4idPathgroupSignatureTransactionsApi.md#createDST) | **POST** /{organization-id}/signature-transactions | Create a Digital Signature Transaction
[**deleteDST**](Bit4idPathgroupSignatureTransactionsApi.md#deleteDST) | **DELETE** /{organization-id}/signature-transactions/{dst-id} | Delete a Digital Signature Transaction
[**getDST**](Bit4idPathgroupSignatureTransactionsApi.md#getDST) | **GET** /{organization-id}/signature-transactions/{dst-id} | Get information about a DST
[**getDocument**](Bit4idPathgroupSignatureTransactionsApi.md#getDocument) | **GET** /{organization-id}/documents/{document-id}/download | Download a document from a DST
[**listDSTs**](Bit4idPathgroupSignatureTransactionsApi.md#listDSTs) | **GET** /{organization-id}/signature-transactions | List the DSTs of an organization


<a name="cancelDST"></a>
# **cancelDST**
> InlineResponse2013 cancelDST(organizationId, dstId, inlineObject1)

Mark a DST as canceled

This API allows to mark a Digital Signature Transaction as canceled providing a reason. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupSignatureTransactionsApi apiInstance = new Bit4idPathgroupSignatureTransactionsApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id dstId = new Id(); // Id | The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst** 
    InlineObject1 inlineObject1 = new InlineObject1(); // InlineObject1 | 
    try {
      InlineResponse2013 result = apiInstance.cancelDST(organizationId, dstId, inlineObject1);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupSignatureTransactionsApi#cancelDST");
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
 **inlineObject1** | [**InlineObject1**](InlineObject1.md)|  |

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
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="createDST"></a>
# **createDST**
> InlineResponse2013 createDST(organizationId, createSignatureTransaction)

Create a Digital Signature Transaction

This API allows to create a Digital Signature Transaction. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupSignatureTransactionsApi apiInstance = new Bit4idPathgroupSignatureTransactionsApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    CreateSignatureTransaction createSignatureTransaction = new CreateSignatureTransaction(); // CreateSignatureTransaction | The new DST to create
    try {
      InlineResponse2013 result = apiInstance.createDST(organizationId, createSignatureTransaction);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupSignatureTransactionsApi#createDST");
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
 **createSignatureTransaction** | [**CreateSignatureTransaction**](CreateSignatureTransaction.md)| The new DST to create |

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
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="deleteDST"></a>
# **deleteDST**
> InlineResponse2007 deleteDST(organizationId, dstId)

Delete a Digital Signature Transaction

This API allows to delete a Digital Signature Transaction. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupSignatureTransactionsApi apiInstance = new Bit4idPathgroupSignatureTransactionsApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id dstId = new Id(); // Id | The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst** 
    try {
      InlineResponse2007 result = apiInstance.deleteDST(organizationId, dstId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupSignatureTransactionsApi#deleteDST");
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

<a name="getDST"></a>
# **getDST**
> InlineResponse2013 getDST(organizationId, dstId)

Get information about a DST

This API allows to get information about a Digital Signature Transaction. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupSignatureTransactionsApi apiInstance = new Bit4idPathgroupSignatureTransactionsApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id dstId = new Id(); // Id | The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst** 
    try {
      InlineResponse2013 result = apiInstance.getDST(organizationId, dstId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupSignatureTransactionsApi#getDST");
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

[**InlineResponse2013**](InlineResponse2013.md)

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

<a name="getDocument"></a>
# **getDocument**
> File getDocument(organizationId, documentId)

Download a document from a DST

This API allows to download a document from a digital signature transaction. The document can be downloaded before or after one or every signature have been performed. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupSignatureTransactionsApi apiInstance = new Bit4idPathgroupSignatureTransactionsApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id documentId = new Id(); // Id | The **document-id** is the uuid code that identifies a document of a digital signature transaction. This parameter is usually used in order to download a document from a digital signature transaction 
    try {
      File result = apiInstance.getDocument(organizationId, documentId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupSignatureTransactionsApi#getDocument");
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
 **documentId** | [**Id**](.md)| The **document-id** is the uuid code that identifies a document of a digital signature transaction. This parameter is usually used in order to download a document from a digital signature transaction  | [default to null]

### Return type

[**File**](File.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/pdf, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="listDSTs"></a>
# **listDSTs**
> InlineResponse2006 listDSTs(organizationId, whereSigner, whereStatus, whereTitle, whereCreatedBy, whereCreated, whereSignatureStatus, whereDocumentName, whereReason, whereSignatureName, whereSignerGroup, page, count)

List the DSTs of an organization

This API allows to list the Digital Signature Transactions of an organization. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    Bit4idPathgroupSignatureTransactionsApi apiInstance = new Bit4idPathgroupSignatureTransactionsApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    String whereSigner = jdo; // String | Returns the Digital Signature Transactions where the specified user is a signer, searched by its id
    String whereStatus = performed; // String | Returns the Digital Signature Transactions with the specified status
    String whereTitle = Signature of a document; // String | Returns the Digital Signature Transactions that have the specified title
    String whereCreatedBy = jdo@example; // String | Returns the Digital Signature Transactions created by the specified user
    String whereCreated = 2019-11-24 12:24:17.430000; // String | Returns the Digital Signature Transactions created before, after or in the declared range
    String whereSignatureStatus = pending; // String | Returns the Digital Signature Transactions where at least one of the signers has the queried status
    String whereDocumentName = Document of example; // String | Returns the Digital Signature Transactions that have into its documents the queried one
    String whereReason = "whereReason_example"; // String | Returns the Digital Signature Transactions with the specified reason
    String whereSignatureName = John Doe; // String | Returns the Digital Signature Transactions where the specified user is a signer, searched by its name
    String whereSignerGroup = @administrators; // String | Returns the Digital Signature Transactions that have the specified group of signers
    Integer page = 1; // Integer | Restricts the search to the chosen page
    Integer count = 100; // Integer | Sets the number of users per page to display
    try {
      InlineResponse2006 result = apiInstance.listDSTs(organizationId, whereSigner, whereStatus, whereTitle, whereCreatedBy, whereCreated, whereSignatureStatus, whereDocumentName, whereReason, whereSignatureName, whereSignerGroup, page, count);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupSignatureTransactionsApi#listDSTs");
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
 **whereSigner** | **String**| Returns the Digital Signature Transactions where the specified user is a signer, searched by its id | [optional]
 **whereStatus** | **String**| Returns the Digital Signature Transactions with the specified status | [optional]
 **whereTitle** | **String**| Returns the Digital Signature Transactions that have the specified title | [optional]
 **whereCreatedBy** | **String**| Returns the Digital Signature Transactions created by the specified user | [optional]
 **whereCreated** | **String**| Returns the Digital Signature Transactions created before, after or in the declared range | [optional]
 **whereSignatureStatus** | **String**| Returns the Digital Signature Transactions where at least one of the signers has the queried status | [optional]
 **whereDocumentName** | **String**| Returns the Digital Signature Transactions that have into its documents the queried one | [optional]
 **whereReason** | **String**| Returns the Digital Signature Transactions with the specified reason | [optional]
 **whereSignatureName** | **String**| Returns the Digital Signature Transactions where the specified user is a signer, searched by its name | [optional]
 **whereSignerGroup** | **String**| Returns the Digital Signature Transactions that have the specified group of signers | [optional]
 **page** | **Integer**| Restricts the search to the chosen page | [optional]
 **count** | **Integer**| Sets the number of users per page to display | [optional] [default to 100]

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

