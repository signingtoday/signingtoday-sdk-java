# DigitalSignatureTransactionsApi

All URIs are relative to *https://web.sandbox.signingtoday.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**dSTIdAuditGet**](DigitalSignatureTransactionsApi.md#dSTIdAuditGet) | **GET** /DST/{id}/audit | Retrieve the audit records associated to the DST
[**dSTIdDelete**](DigitalSignatureTransactionsApi.md#dSTIdDelete) | **DELETE** /DST/{id} | Delete a DST
[**dSTIdFillPatch**](DigitalSignatureTransactionsApi.md#dSTIdFillPatch) | **PATCH** /DST/{id}/fill | Fill a form of a DST
[**dSTIdGet**](DigitalSignatureTransactionsApi.md#dSTIdGet) | **GET** /DST/{id} | Retrieve a DST
[**dSTIdInstantiatePost**](DigitalSignatureTransactionsApi.md#dSTIdInstantiatePost) | **POST** /DST/{id}/instantiate | Instantiate a DST from a template
[**dSTIdModifyPost**](DigitalSignatureTransactionsApi.md#dSTIdModifyPost) | **POST** /DST/{id}/modify | Modify a published DST template
[**dSTIdNotifyPost**](DigitalSignatureTransactionsApi.md#dSTIdNotifyPost) | **POST** /DST/{id}/notify | Send notifications for a DST
[**dSTIdPublishPost**](DigitalSignatureTransactionsApi.md#dSTIdPublishPost) | **POST** /DST/{id}/publish | Publish a DST
[**dSTIdPut**](DigitalSignatureTransactionsApi.md#dSTIdPut) | **PUT** /DST/{id} | Update a DST
[**dSTIdReplacePost**](DigitalSignatureTransactionsApi.md#dSTIdReplacePost) | **POST** /DST/{id}/replace | Replace a rejected DST
[**dSTIdSignDocIdSignIdGet**](DigitalSignatureTransactionsApi.md#dSTIdSignDocIdSignIdGet) | **GET** /DST/{id}/sign/{docId}/{signId} | Return the address for signing
[**dSTIdTemplatizePost**](DigitalSignatureTransactionsApi.md#dSTIdTemplatizePost) | **POST** /DST/{id}/templatize | Create a template from a DST
[**dSTsGet**](DigitalSignatureTransactionsApi.md#dSTsGet) | **GET** /DSTs | Retrieve DSTs
[**dSTsPost**](DigitalSignatureTransactionsApi.md#dSTsPost) | **POST** /DSTs | Create a new DST


<a name="dSTIdAuditGet"></a>
# **dSTIdAuditGet**
> List&lt;AuditRecord&gt; dSTIdAuditGet(id)

Retrieve the audit records associated to the DST

This API allows to retrieves the audit records associated to the DST.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      List<AuditRecord> result = apiInstance.dSTIdAuditGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTIdAuditGet");
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

[**List&lt;AuditRecord&gt;**](AuditRecord.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The audit associated to the DST sorted by date. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdDelete"></a>
# **dSTIdDelete**
> dSTIdDelete(id)

Delete a DST

This API allows to delete a DST. Actually the DST is marked as deleted thus not displayed anymore into the organization, but it will still be present in the database.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      apiInstance.dSTIdDelete(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTIdDelete");
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
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdFillPatch"></a>
# **dSTIdFillPatch**
> DigitalSignatureTransaction dSTIdFillPatch(id, fillableForm)

Fill a form of a DST

This API allows to fill a form of a DST.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    FillableForm fillableForm = new FillableForm(); // FillableForm | The form filled by the user.
    try {
      DigitalSignatureTransaction result = apiInstance.dSTIdFillPatch(id, fillableForm);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTIdFillPatch");
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
 **fillableForm** | [**FillableForm**](FillableForm.md)| The form filled by the user. |

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
**200** | The DST has been modified according to the operation. |  -  |
**400** | Result of a client passing incorrect or invalid data. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdGet"></a>
# **dSTIdGet**
> DigitalSignatureTransaction dSTIdGet(id)

Retrieve a DST

This API allows to retrieve a DST.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      DigitalSignatureTransaction result = apiInstance.dSTIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTIdGet");
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

[**DigitalSignatureTransaction**](DigitalSignatureTransaction.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The data matching the selection parameters. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdInstantiatePost"></a>
# **dSTIdInstantiatePost**
> DigitalSignatureTransaction dSTIdInstantiatePost(id)

Instantiate a DST from a template

This API allows to instantiate a DST from a template by specifying the template Id.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      DigitalSignatureTransaction result = apiInstance.dSTIdInstantiatePost(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTIdInstantiatePost");
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

[**DigitalSignatureTransaction**](DigitalSignatureTransaction.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
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

<a name="dSTIdModifyPost"></a>
# **dSTIdModifyPost**
> DigitalSignatureTransaction dSTIdModifyPost(id)

Modify a published DST template

This API allows to move a published DST to DRAFT, allowing the modification. This way is possible to modify a _DST Template_. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      DigitalSignatureTransaction result = apiInstance.dSTIdModifyPost(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTIdModifyPost");
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

[**DigitalSignatureTransaction**](DigitalSignatureTransaction.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The modified DST in DRAFT state. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdNotifyPost"></a>
# **dSTIdNotifyPost**
> dSTIdNotifyPost(id)

Send notifications for a DST

This API allows to send notifications to pending users for an active _DST_.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      apiInstance.dSTIdNotifyPost(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTIdNotifyPost");
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
**400** | Result of a client passing incorrect or invalid data. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdPublishPost"></a>
# **dSTIdPublishPost**
> DigitalSignatureTransaction dSTIdPublishPost(id)

Publish a DST

This API allows to publish a DST, the new state becomes published. It will automatically evolve to a new state where it will be filled or signed.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      DigitalSignatureTransaction result = apiInstance.dSTIdPublishPost(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTIdPublishPost");
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

[**DigitalSignatureTransaction**](DigitalSignatureTransaction.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The DST has been modified according to the operation. |  -  |
**400** | Result of a client passing incorrect or invalid data. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdPut"></a>
# **dSTIdPut**
> DigitalSignatureTransaction dSTIdPut(id, digitalSignatureTransaction)

Update a DST

This API allows to update a DST.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    DigitalSignatureTransaction digitalSignatureTransaction = new DigitalSignatureTransaction(); // DigitalSignatureTransaction | DST replacing current object.
    try {
      DigitalSignatureTransaction result = apiInstance.dSTIdPut(id, digitalSignatureTransaction);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTIdPut");
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
 **digitalSignatureTransaction** | [**DigitalSignatureTransaction**](DigitalSignatureTransaction.md)| DST replacing current object. |

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
**200** | The updated DST. |  -  |
**400** | Result of a client passing incorrect or invalid data. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdReplacePost"></a>
# **dSTIdReplacePost**
> DigitalSignatureTransaction dSTIdReplacePost(id)

Replace a rejected DST

This API allows to replace a rejected DST instantiating a new one. The replacing DST is created in DRAFT state.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      DigitalSignatureTransaction result = apiInstance.dSTIdReplacePost(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTIdReplacePost");
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

[**DigitalSignatureTransaction**](DigitalSignatureTransaction.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The new DST that has been generated as a replace of the referred DST. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdSignDocIdSignIdGet"></a>
# **dSTIdSignDocIdSignIdGet**
> DSTSigningAddressResponse dSTIdSignDocIdSignIdGet(id, docId, signId)

Return the address for signing

This API returns the address to perform the signature.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    Integer docId = 3; // Integer | Reference to _docId_ has to be signed
    Integer signId = 2; // Integer | Reference to the signature request id
    try {
      DSTSigningAddressResponse result = apiInstance.dSTIdSignDocIdSignIdGet(id, docId, signId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTIdSignDocIdSignIdGet");
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
 **docId** | **Integer**| Reference to _docId_ has to be signed |
 **signId** | **Integer**| Reference to the signature request id |

### Return type

[**DSTSigningAddressResponse**](DSTSigningAddressResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The URL where to sign. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdTemplatizePost"></a>
# **dSTIdTemplatizePost**
> DigitalSignatureTransaction dSTIdTemplatizePost(id)

Create a template from a DST

This API allows to creates a new template starting from a DST. Currently implemented only for published DST templates.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      DigitalSignatureTransaction result = apiInstance.dSTIdTemplatizePost(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTIdTemplatizePost");
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

[**DigitalSignatureTransaction**](DigitalSignatureTransaction.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The new DST that has been generated as a template of the referred DST. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTsGet"></a>
# **dSTsGet**
> DSTsGetResponse dSTsGet(template, userId, $top, $skip, $count, $orderBy, $filter)

Retrieve DSTs

This API allows to list the DSTs of an organization.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    Boolean template = false; // Boolean | Select templates or instances
    UUID userId = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | Select the objects relative to the user specified by the parameter. If not specified will be used the id of the current authenticated user
    Integer $top = 32; // Integer | A number of results to return. Applied after **$skip** 
    Long $skip = 64; // Long | An offset into the collection of results
    Boolean $count = true; // Boolean | If true, the server includes the count of all the items in the response 
    String $orderBy = $orderBy=updatedAt; // String | An ordering definition (eg. $orderBy=updatedAt,desc)
    String $filter = $filter=name=="Milk"; // String | A filter definition (eg. $filter=name == \"Milk\" or surname == \"Bread\")
    try {
      DSTsGetResponse result = apiInstance.dSTsGet(template, userId, $top, $skip, $count, $orderBy, $filter);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTsGet");
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
 **template** | **Boolean**| Select templates or instances | [optional] [default to false]
 **userId** | [**UUID**](.md)| Select the objects relative to the user specified by the parameter. If not specified will be used the id of the current authenticated user | [optional]
 **$top** | **Integer**| A number of results to return. Applied after **$skip**  | [optional]
 **$skip** | **Long**| An offset into the collection of results | [optional]
 **$count** | **Boolean**| If true, the server includes the count of all the items in the response  | [optional]
 **$orderBy** | **String**| An ordering definition (eg. $orderBy&#x3D;updatedAt,desc) | [optional]
 **$filter** | **String**| A filter definition (eg. $filter&#x3D;name &#x3D;&#x3D; \&quot;Milk\&quot; or surname &#x3D;&#x3D; \&quot;Bread\&quot;) | [optional]

### Return type

[**DSTsGetResponse**](DSTsGetResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The data matching the selection parameters. |  -  |
**400** | Result of a client passing incorrect or invalid data. |  -  |
**403** | User is not allowed to perform the request. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTsPost"></a>
# **dSTsPost**
> DigitalSignatureTransaction dSTsPost(digitalSignatureTransaction)

Create a new DST

This API allows to creates a new DST. A DST is created in the Draft state and then updated using PUT. Example of creation request:  &#x60;&#x60;&#x60; {   status: \&quot;draft\&quot;,   publishedAt: null,   tags: [],   urgent: false,   template: false } &#x60;&#x60;&#x60;  To add documents use the Resources Patch endpoint &#x60;/DST/{id}/resources&#x60;.  If the *template* flag is set true the DST is a Template. If the *publicTemplate* flag is set true the Template is visible to all users with rights to create a DST.  A DST is made made available to users using *publish* end point. A template generates a DST with the *instantiate* endpoint. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.DigitalSignatureTransactionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    DigitalSignatureTransactionsApi apiInstance = new DigitalSignatureTransactionsApi(defaultClient);
    DigitalSignatureTransaction digitalSignatureTransaction = new DigitalSignatureTransaction(); // DigitalSignatureTransaction | DST to append to the current resources.
    try {
      DigitalSignatureTransaction result = apiInstance.dSTsPost(digitalSignatureTransaction);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DigitalSignatureTransactionsApi#dSTsPost");
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
 **digitalSignatureTransaction** | [**DigitalSignatureTransaction**](DigitalSignatureTransaction.md)| DST to append to the current resources. |

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
**201** | The new DST added to the list. |  -  |
**400** | Result of a client passing incorrect or invalid data. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**500** | Internal failure of the service. |  -  |

