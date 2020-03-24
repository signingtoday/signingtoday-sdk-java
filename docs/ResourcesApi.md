# ResourcesApi

All URIs are relative to *https://web.sandbox.signingtoday.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**dSTIdResourcesGet**](ResourcesApi.md#dSTIdResourcesGet) | **GET** /DST/{id}/resources | Retrieve all resources associated to a DST
[**dSTIdResourcesPatch**](ResourcesApi.md#dSTIdResourcesPatch) | **PATCH** /DST/{id}/resources | Append a new resource to a DST
[**dSTResourceIdDelete**](ResourcesApi.md#dSTResourceIdDelete) | **DELETE** /DST/resource/{id} | Delete a Resource
[**resourceIdGet**](ResourcesApi.md#resourceIdGet) | **GET** /resource/{id} | Retrieve a Resource
[**resourceIdPut**](ResourcesApi.md#resourceIdPut) | **PUT** /resource/{id} | Update a Resource
[**userIdIdentityIdentityIdAppearanceDelete**](ResourcesApi.md#userIdIdentityIdentityIdAppearanceDelete) | **DELETE** /user/{id}/identity/{identity-id}/appearance | Delete a user appearance resource.
[**userIdIdentityIdentityIdAppearanceGet**](ResourcesApi.md#userIdIdentityIdentityIdAppearanceGet) | **GET** /user/{id}/identity/{identity-id}/appearance | Download an identity appearance resource
[**userIdIdentityIdentityIdAppearancePost**](ResourcesApi.md#userIdIdentityIdentityIdAppearancePost) | **POST** /user/{id}/identity/{identity-id}/appearance | Add a graphical appearance to a user&#39;s identity


<a name="dSTIdResourcesGet"></a>
# **dSTIdResourcesGet**
> File dSTIdResourcesGet(id)

Retrieve all resources associated to a DST

This API allows to retrieve all resources associated to a DST.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.ResourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ResourcesApi apiInstance = new ResourcesApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      File result = apiInstance.dSTIdResourcesGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#dSTIdResourcesGet");
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

[**File**](File.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The response body contains all resources associated to a DST into a zip file. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdResourcesPatch"></a>
# **dSTIdResourcesPatch**
> DigitalSignatureTransaction dSTIdResourcesPatch(id, file, filename, resourceType, title)

Append a new resource to a DST

This API allows to append a new Resource to a DST.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.ResourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ResourcesApi apiInstance = new ResourcesApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    File file = new File("/path/to/file"); // File | The file to upload
    String filename = "filename_example"; // String | The name of the file
    String resourceType = "resourceType_example"; // String | 
    String title = "title_example"; // String | User-defined title of the resource.
    try {
      DigitalSignatureTransaction result = apiInstance.dSTIdResourcesPatch(id, file, filename, resourceType, title);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#dSTIdResourcesPatch");
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
 **file** | **File**| The file to upload |
 **filename** | **String**| The name of the file |
 **resourceType** | **String**|  | [enum: PDF_Document]
 **title** | **String**| User-defined title of the resource. | [optional]

### Return type

[**DigitalSignatureTransaction**](DigitalSignatureTransaction.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The DST patched with the new resource. |  -  |
**400** | Result of a client passing incorrect or invalid data. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTResourceIdDelete"></a>
# **dSTResourceIdDelete**
> DigitalSignatureTransaction dSTResourceIdDelete(id)

Delete a Resource

This API allows to delete a Resource.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.ResourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ResourcesApi apiInstance = new ResourcesApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      DigitalSignatureTransaction result = apiInstance.dSTResourceIdDelete(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#dSTResourceIdDelete");
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
**200** | The DST Updated. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="resourceIdGet"></a>
# **resourceIdGet**
> File resourceIdGet(id)

Retrieve a Resource

This API allows to retrieve a Resource.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.ResourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ResourcesApi apiInstance = new ResourcesApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      File result = apiInstance.resourceIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#resourceIdGet");
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

[**File**](File.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The response is the binary resource file content. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="resourceIdPut"></a>
# **resourceIdPut**
> resourceIdPut(id, lfResource)

Update a Resource

This API allows to update a Resource.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.ResourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ResourcesApi apiInstance = new ResourcesApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    LFResource lfResource = new LFResource(); // LFResource | Resource replacing current object.
    try {
      apiInstance.resourceIdPut(id, lfResource);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#resourceIdPut");
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
 **lfResource** | [**LFResource**](LFResource.md)| Resource replacing current object. |

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
**400** | Result of a client passing incorrect or invalid data. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="userIdIdentityIdentityIdAppearanceDelete"></a>
# **userIdIdentityIdentityIdAppearanceDelete**
> userIdIdentityIdentityIdAppearanceDelete(id, identityId)

Delete a user appearance resource.

This API allows to delete an identity appearance resource.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.ResourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ResourcesApi apiInstance = new ResourcesApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    UUID identityId = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The unique id of the _Identity_
    try {
      apiInstance.userIdIdentityIdentityIdAppearanceDelete(id, identityId);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#userIdIdentityIdentityIdAppearanceDelete");
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
 **identityId** | [**UUID**](.md)| The unique id of the _Identity_ |

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
**500** | Internal failure of the service. |  -  |

<a name="userIdIdentityIdentityIdAppearanceGet"></a>
# **userIdIdentityIdentityIdAppearanceGet**
> File userIdIdentityIdentityIdAppearanceGet(id, identityId)

Download an identity appearance resource

This API allows to get the identity appearance resource.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.ResourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ResourcesApi apiInstance = new ResourcesApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    UUID identityId = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The unique id of the _Identity_
    try {
      File result = apiInstance.userIdIdentityIdentityIdAppearanceGet(id, identityId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#userIdIdentityIdentityIdAppearanceGet");
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
 **identityId** | [**UUID**](.md)| The unique id of the _Identity_ |

### Return type

[**File**](File.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The response is the binary resource file content. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="userIdIdentityIdentityIdAppearancePost"></a>
# **userIdIdentityIdentityIdAppearancePost**
> LFResource userIdIdentityIdentityIdAppearancePost(id, identityId, file, filename, resourceType, title)

Add a graphical appearance to a user&#39;s identity

This API allows to add a graphical appearance to the identity of a user.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.ResourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ResourcesApi apiInstance = new ResourcesApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    UUID identityId = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The unique id of the _Identity_
    File file = new File("/path/to/file"); // File | The path of the file to upload
    String filename = "filename_example"; // String | The name of the file
    String resourceType = "resourceType_example"; // String | The type of the resource
    String title = "title_example"; // String | User-defined title of the resource
    try {
      LFResource result = apiInstance.userIdIdentityIdentityIdAppearancePost(id, identityId, file, filename, resourceType, title);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#userIdIdentityIdentityIdAppearancePost");
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
 **identityId** | [**UUID**](.md)| The unique id of the _Identity_ |
 **file** | **File**| The path of the file to upload |
 **filename** | **String**| The name of the file |
 **resourceType** | **String**| The type of the resource | [enum: PDF_Document, Image]
 **title** | **String**| User-defined title of the resource | [optional]

### Return type

[**LFResource**](LFResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The new created Resource |  -  |
**400** | Result of a client passing incorrect or invalid data. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

