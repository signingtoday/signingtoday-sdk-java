# Bit4idPathgroupDstNoteApi

All URIs are relative to *https://web.sandbox.signingtoday.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**dSTIdNoteGet**](Bit4idPathgroupDstNoteApi.md#dSTIdNoteGet) | **GET** /DST/{id}/note | Retrieve the DSTNotes associated to the DST
[**dSTIdNoteNoteIdDelete**](Bit4idPathgroupDstNoteApi.md#dSTIdNoteNoteIdDelete) | **DELETE** /DST/{id}/note/{noteId} | Delete a DSTNote
[**dSTIdNoteNoteIdPut**](Bit4idPathgroupDstNoteApi.md#dSTIdNoteNoteIdPut) | **PUT** /DST/{id}/note/{noteId} | Edit a DSTNote
[**dSTIdNotePost**](Bit4idPathgroupDstNoteApi.md#dSTIdNotePost) | **POST** /DST/{id}/note | Append a new DSTNote


<a name="dSTIdNoteGet"></a>
# **dSTIdNoteGet**
> List&lt;DSTNote&gt; dSTIdNoteGet(id)

Retrieve the DSTNotes associated to the DST

This API allows to retrieve the DST Notes associated to the DST.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupDstNoteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    Bit4idPathgroupDstNoteApi apiInstance = new Bit4idPathgroupDstNoteApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    try {
      List<DSTNote> result = apiInstance.dSTIdNoteGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupDstNoteApi#dSTIdNoteGet");
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

[**List&lt;DSTNote&gt;**](DSTNote.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The DSTNotes |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdNoteNoteIdDelete"></a>
# **dSTIdNoteNoteIdDelete**
> dSTIdNoteNoteIdDelete(id, noteId)

Delete a DSTNote

This API allows to delete a DSTNote.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupDstNoteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    Bit4idPathgroupDstNoteApi apiInstance = new Bit4idPathgroupDstNoteApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    Long noteId = 14; // Long | The reference of a DSTNote
    try {
      apiInstance.dSTIdNoteNoteIdDelete(id, noteId);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupDstNoteApi#dSTIdNoteNoteIdDelete");
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
 **noteId** | **Long**| The reference of a DSTNote |

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

<a name="dSTIdNoteNoteIdPut"></a>
# **dSTIdNoteNoteIdPut**
> DSTNote dSTIdNoteNoteIdPut(id, noteId, dsTNote)

Edit a DSTNote

This API allows to edit a DSTNote.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupDstNoteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    Bit4idPathgroupDstNoteApi apiInstance = new Bit4idPathgroupDstNoteApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    Long noteId = 14; // Long | The reference of a DSTNote
    DSTNote dsTNote = new DSTNote(); // DSTNote | DSTNote replacing current object.
    try {
      DSTNote result = apiInstance.dSTIdNoteNoteIdPut(id, noteId, dsTNote);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupDstNoteApi#dSTIdNoteNoteIdPut");
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
 **noteId** | **Long**| The reference of a DSTNote |
 **dsTNote** | [**DSTNote**](DSTNote.md)| DSTNote replacing current object. |

### Return type

[**DSTNote**](DSTNote.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The updated DSTNote. |  -  |
**400** | Result of a client passing incorrect or invalid data. |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**500** | Internal failure of the service. |  -  |

<a name="dSTIdNotePost"></a>
# **dSTIdNotePost**
> DSTNote dSTIdNotePost(id, inlineObject1)

Append a new DSTNote

This API allows to append a new DSTNote to the DST.

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupDstNoteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    Bit4idPathgroupDstNoteApi apiInstance = new Bit4idPathgroupDstNoteApi(defaultClient);
    UUID id = 737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4; // UUID | The value of _the unique id_
    InlineObject1 inlineObject1 = new InlineObject1(); // InlineObject1 | 
    try {
      DSTNote result = apiInstance.dSTIdNotePost(id, inlineObject1);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupDstNoteApi#dSTIdNotePost");
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
 **inlineObject1** | [**InlineObject1**](InlineObject1.md)|  | [optional]

### Return type

[**DSTNote**](DSTNote.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The DSTNote just added |  -  |
**401** | User authentication was not effective (e.g. not provided, invalid or expired). |  -  |
**403** | User is not allowed to perform the request. |  -  |
**404** | The resource was not found. |  -  |
**409** | Cannot satisfy the request because the resource is in an illegal status. |  -  |
**500** | Internal failure of the service. |  -  |

