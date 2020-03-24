

# RobotConfigurationAuthentication

The data the application will use to authenticate itself wherever there will be the need, for example in order to access to a resource
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**username** | **String** | The username for the authentication |  [optional]
**password** | **String** | The password for the authentication |  [optional]
**authMode** | [**AuthModeEnum**](#AuthModeEnum) | The type of authentication |  [optional]
**clientKey** | **String** | Client key |  [optional]
**clientCert** | **String** | Client certificate |  [optional]



## Enum: AuthModeEnum

Name | Value
---- | -----
BASIC | &quot;basic&quot;
DIGEST | &quot;digest&quot;



