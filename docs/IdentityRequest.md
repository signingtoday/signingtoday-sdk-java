

# IdentityRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**label** | **String** | The label is an arbitrary name is possible to associate to an idenity. Doing so allows to distinguish different identities issued from the same provider during the performance of the signature in the signature tray |  [optional]
**providerData** | [**SMS**](SMS.md) |  |  [optional]
**providerId** | [**ProviderIdEnum**](#ProviderIdEnum) | The id of the provider will issue the requested identity |  [optional]
**registeredBy** | **String** | The RAO user that registered the identity |  [optional]
**user** | **String** | The user is intended to associate the requestd identity |  [optional]



## Enum: ProviderIdEnum

Name | Value
---- | -----
SMS | &quot;sms&quot;
ST_APPROVAL | &quot;st-approval&quot;



