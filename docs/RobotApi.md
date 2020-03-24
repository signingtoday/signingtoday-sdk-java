# RobotApi

All URIs are relative to *https://web.sandbox.signingtoday.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**robotConfigurationPut**](RobotApi.md#robotConfigurationPut) | **PUT** /robot/configuration | Edit the Robot configuration


<a name="robotConfigurationPut"></a>
# **robotConfigurationPut**
> robotConfigurationPut(robotConfiguration, username, domain)

Edit the Robot configuration

This API allows to edit the Robot configuration. 

### Example
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.RobotApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://web.sandbox.signingtoday.com/api");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RobotApi apiInstance = new RobotApi(defaultClient);
    RobotConfiguration robotConfiguration = new RobotConfiguration(); // RobotConfiguration | RobotConfiguration.
    String username = thirdPartApp; // String | The _username_ associated to the account
    String domain = demo; // String | The _domain_ associated to the account
    try {
      apiInstance.robotConfigurationPut(robotConfiguration, username, domain);
    } catch (ApiException e) {
      System.err.println("Exception when calling RobotApi#robotConfigurationPut");
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
 **robotConfiguration** | [**RobotConfiguration**](RobotConfiguration.md)| RobotConfiguration. |
 **username** | **String**| The _username_ associated to the account | [optional]
 **domain** | **String**| The _domain_ associated to the account | [optional]

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
**500** | Internal failure of the service. |  -  |

