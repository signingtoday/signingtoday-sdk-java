

# IdentityAssociation

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**providerId** | [**ProviderIdEnum**](#ProviderIdEnum) | _provider_id_ is the univocal name of the provider that issued the identity  |  [optional]
**label** | **String** | The label is an arbitrary name is possible to associate to an idenity. Doing so allows to distinguish different identities issued from the same provider during the performance of the signature in the signature tray |  [optional]
**providerData** | [**Object**](.md) | Data of the provider that issued the certificate, it is variable from to provider to provider |  [optional]



## Enum: ProviderIdEnum

Name | Value
---- | -----
ARUBA | &quot;aruba&quot;
ARUBA_AUTO | &quot;aruba-auto&quot;
INFOCERT | &quot;infocert&quot;
NAMIRIAL | &quot;namirial&quot;



