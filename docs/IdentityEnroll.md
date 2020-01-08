

# IdentityEnroll

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**actions** | [**IdentityEnrollActions**](IdentityEnrollActions.md) |  |  [optional]
**createdBy** | **String** |  |  [optional]
**enrollTicket** | **String** |  |  [optional]
**id** | [**UUID**](UUID.md) |  |  [optional]
**label** | **String** |  |  [optional]
**next** | **String** |  |  [optional]
**provider** | **String** |  |  [optional]
**providerData** | [**Object**](.md) | Data of the provider that issued the certificate, it is variable from to provider to provider |  [optional]
**providerType** | **String** |  |  [optional]
**registeredBy** | **String** |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**urlback** | **String** |  |  [optional]
**user** | **String** |  |  [optional]



## Enum: StatusEnum

Name | Value
---- | -----
PENDING | &quot;pending&quot;
ACTIVE | &quot;active&quot;
ERROR | &quot;error&quot;



