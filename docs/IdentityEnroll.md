

# IdentityEnroll

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**UUID**](UUID.md) |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**next** | **String** |  |  [optional]
**actions** | [**IdentityEnrollActions**](IdentityEnrollActions.md) |  |  [optional]
**provider** | **String** |  |  [optional]
**label** | **String** |  |  [optional]
**providerType** | **String** |  |  [optional]
**user** | **String** |  |  [optional]
**registeredBy** | **String** |  |  [optional]
**providerData** | [**Object**](.md) | Data of the provider that issued the certificate, it is variable from to provider to provider |  [optional]
**enrollTicket** | **String** |  |  [optional]
**createdBy** | **String** |  |  [optional]
**urlback** | **String** |  |  [optional]



## Enum: StatusEnum

Name | Value
---- | -----
PENDING | &quot;pending&quot;
ACTIVE | &quot;active&quot;
ERROR | &quot;error&quot;



