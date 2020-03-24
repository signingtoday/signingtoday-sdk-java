# BackofficeApi

All URIs are relative to *https://web.sandbox.signingtoday.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**organizationIdAlfrescoSyncGet**](BackofficeApi.md#organizationIdAlfrescoSyncGet) | **GET** /organization/{id}/alfrescoSync | Sync all completed DSTs on Alfresco
[**organizationIdAlfrescoSyncPost**](BackofficeApi.md#organizationIdAlfrescoSyncPost) | **POST** /organization/{id}/alfrescoSync | Sync all completed DSTs on Alfresco
[**organizationIdDelete**](BackofficeApi.md#organizationIdDelete) | **DELETE** /organization/{id} | Enable or disable an Organization account.
[**organizationIdGet**](BackofficeApi.md#organizationIdGet) | **GET** /organization/{id} | Retrieve info on one organization
[**organizationIdPublicGet**](BackofficeApi.md#organizationIdPublicGet) | **GET** /organization/public | Retrieve public resources
[**organizationIdPut**](BackofficeApi.md#organizationIdPut) | **PUT** /organization/{id} | Update info on one organization
[**organizationIdResourceGet**](BackofficeApi.md#organizationIdResourceGet) | **GET** /organization/{id}/resource | Get an organization resource
[**organizationIdResourcePut**](BackofficeApi.md#organizationIdResourcePut) | **PUT** /organization/{id}/resource | Create or overwrite an organization resource
[**organizationResourceIdDelete**](BackofficeApi.md#organizationResourceIdDelete) | **DELETE** /organization/{id}/resource | Delete an organization resource
[**organizationResourcesGet**](BackofficeApi.md#organizationResourcesGet) | **GET** /organization/{id}/resources | List all the organization resources
[**organizationTagsGet**](BackofficeApi.md#organizationTagsGet) | **GET** /organization/tags | Retrieve organization tags
[**organizationsGet**](BackofficeApi.md#organizationsGet) | **GET** /organizations | Get the list of organizations
[**organizationsPost**](BackofficeApi.md#organizationsPost) | **POST** /organizations | Create a new organization


<a name="organizationIdAlfrescoSyncGet"></a>
# **organizationIdAlfrescoSyncGet**
> AlfrescoSync organizationIdAlfrescoSyncGet(id)

Sync all completed DSTs on Alfresco

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    String id = test_id; // String | The value of the unique id
    try {
      AlfrescoSync result = apiInstance.organizationIdAlfrescoSyncGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationIdAlfrescoSyncGet");
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
 **id** | **String**| The value of the unique id |

### Return type

[**AlfrescoSync**](AlfrescoSync.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**202** | OK |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="organizationIdAlfrescoSyncPost"></a>
# **organizationIdAlfrescoSyncPost**
> organizationIdAlfrescoSyncPost(id, alfrescoSync)

Sync all completed DSTs on Alfresco

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    String id = test_id; // String | The value of the unique id
    AlfrescoSync alfrescoSync = new AlfrescoSync(); // AlfrescoSync | Domain associated to the account.
    try {
      apiInstance.organizationIdAlfrescoSyncPost(id, alfrescoSync);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationIdAlfrescoSyncPost");
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
 **id** | **String**| The value of the unique id |
 **alfrescoSync** | [**AlfrescoSync**](AlfrescoSync.md)| Domain associated to the account. |

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
**202** | OK |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="organizationIdDelete"></a>
# **organizationIdDelete**
> organizationIdDelete(id, enabled)

Enable or disable an Organization account.

Enable or disable an Organization.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    String id = test_id; // String | The value of the unique id
    Boolean enabled = false; // Boolean | New status to set
    try {
      apiInstance.organizationIdDelete(id, enabled);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationIdDelete");
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
 **id** | **String**| The value of the unique id |
 **enabled** | **Boolean**| New status to set | [optional] [default to false]

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

<a name="organizationIdGet"></a>
# **organizationIdGet**
> Organization organizationIdGet(id)

Retrieve info on one organization

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    String id = test_id; // String | The value of the unique id
    try {
      Organization result = apiInstance.organizationIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationIdGet");
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
 **id** | **String**| The value of the unique id |

### Return type

[**Organization**](Organization.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="organizationIdPublicGet"></a>
# **organizationIdPublicGet**
> File organizationIdPublicGet(res, id)

Retrieve public resources

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    String res = logo; // String | resource id
    String id = 05ea656f-df69-49b1-a12b-9bf640c427c2; // String | organization id
    try {
      File result = apiInstance.organizationIdPublicGet(res, id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationIdPublicGet");
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
 **res** | **String**| resource id | [enum: logo]
 **id** | **String**| organization id | [optional]

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Resource content. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="organizationIdPut"></a>
# **organizationIdPut**
> organizationIdPut(id, organization)

Update info on one organization

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    String id = test_id; // String | The value of the unique id
    Organization organization = new Organization(); // Organization | 
    try {
      apiInstance.organizationIdPut(id, organization);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationIdPut");
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
 **id** | **String**| The value of the unique id |
 **organization** | [**Organization**](Organization.md)|  | [optional]

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
**500** | Internal failure of the service. |  -  |

<a name="organizationIdResourceGet"></a>
# **organizationIdResourceGet**
> File organizationIdResourceGet(id, resPath)

Get an organization resource

Get an organization resource

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    String id = test_id; // String | The value of the unique id
    String resPath = 05ea656f-df69-49b1-a12b-9bf640c427c2; // String | 
    try {
      File result = apiInstance.organizationIdResourceGet(id, resPath);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationIdResourceGet");
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
 **id** | **String**| The value of the unique id |
 **resPath** | **String**|  |

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
**200** | An organization resource. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="organizationIdResourcePut"></a>
# **organizationIdResourcePut**
> organizationIdResourcePut(id, resPath, file)

Create or overwrite an organization resource

Create or overwrite an organization resource

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    String id = test_id; // String | The value of the unique id
    String resPath = 05ea656f-df69-49b1-a12b-9bf640c427c2; // String | 
    File file = new File("/path/to/file"); // File | The file to upload.
    try {
      apiInstance.organizationIdResourcePut(id, resPath, file);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationIdResourcePut");
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
 **id** | **String**| The value of the unique id |
 **resPath** | **String**|  |
 **file** | **File**| The file to upload. |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | The request has been satisfyied. No output. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="organizationResourceIdDelete"></a>
# **organizationResourceIdDelete**
> organizationResourceIdDelete(id, resPath)

Delete an organization resource

Deletes a Resource.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    String id = test_id; // String | The value of the unique id
    String resPath = 05ea656f-df69-49b1-a12b-9bf640c427c2; // String | 
    try {
      apiInstance.organizationResourceIdDelete(id, resPath);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationResourceIdDelete");
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
 **id** | **String**| The value of the unique id |
 **resPath** | **String**|  |

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

<a name="organizationResourcesGet"></a>
# **organizationResourcesGet**
> List&lt;String&gt; organizationResourcesGet(id)

List all the organization resources

List all the organization resources.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    String id = test_id; // String | The value of the unique id
    try {
      List<String> result = apiInstance.organizationResourcesGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationResourcesGet");
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
 **id** | **String**| The value of the unique id |

### Return type

**List&lt;String&gt;**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="organizationTagsGet"></a>
# **organizationTagsGet**
> List&lt;String&gt; organizationTagsGet()

Retrieve organization tags

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    try {
      List<String> result = apiInstance.organizationTagsGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationTagsGet");
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

**List&lt;String&gt;**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Resource content. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="organizationsGet"></a>
# **organizationsGet**
> OrganizationsGetResponse organizationsGet($top, $skip, $count, $filter)

Get the list of organizations

Get the list of organizations

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    Integer $top = 32; // Integer | A number of results to return. Applied after **$skip** 
    Long $skip = 64; // Long | An offset into the collection of results
    Boolean $count = true; // Boolean | If true, the server includes the count of all the items in the response 
    String $filter = $filter=name=="Milk"; // String | A filter definition (eg. $filter=name == \"Milk\" or surname == \"Bread\")
    try {
      OrganizationsGetResponse result = apiInstance.organizationsGet($top, $skip, $count, $filter);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationsGet");
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
 **$filter** | **String**| A filter definition (eg. $filter&#x3D;name &#x3D;&#x3D; \&quot;Milk\&quot; or surname &#x3D;&#x3D; \&quot;Bread\&quot;) | [optional]

### Return type

[**OrganizationsGetResponse**](OrganizationsGetResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The list of organizations. |  -  |

<a name="organizationsPost"></a>
# **organizationsPost**
> organizationsPost(organization)

Create a new organization

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.BackofficeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BackofficeApi apiInstance = new BackofficeApi(defaultClient);
    Organization organization = new Organization(); // Organization | 
    try {
      apiInstance.organizationsPost(organization);
    } catch (ApiException e) {
      System.err.println("Exception when calling BackofficeApi#organizationsPost");
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
 **organization** | [**Organization**](Organization.md)|  | [optional]

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
**500** | Internal failure of the service. |  -  |

