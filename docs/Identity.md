

# Identity

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**actions** | [**IdentityActions**](IdentityActions.md) |  |  [optional]
**certificate** | **String** | The X.509 certificate in PEM format of the Identity |  [optional]
**hasBeenImported** | **Boolean** | If the Identity has been imported from another pre-existing Identity the has_been_imported field is set to **true** |  [optional]
**id** | [**UUID**](UUID.md) | The uuid code that identifies the Identity |  [optional]
**label** | **String** | The label is an arbitrary name is possible to associate to an idenity. Doing so allows to distinguish different identities issued from the same provider during the performance of the signature in the signature tray |  [optional]
**next** | **String** | The next step to complete the activation procedure |  [optional]
**notAfter** | **String** | Deadline of the Identity, expressed in ISO format |  [optional]
**provider** | **String** | The name of the provider that issued the certificate for the Identity |  [optional]
**providerData** | [**Object**](.md) | Data of the provider that issued the certificate, it is variable from provider to provider |  [optional]
**providerId** | [**UUID**](UUID.md) | _provider_id_ is the univocal name of the provider that issued the identity  |  [optional]
**providerImage** | **String** | This is the logo of the provider that issued the identity |  [optional]
**providerType** | **String** | Type of the provider. The most usual type is **cloud**  |  [optional]
**sendOtpUrl** | **String** | The url to send a one time password to the user which the identity is associated |  [optional]
**signUrl** | **String** | The url to sign a document of a digital signature transaction |  [optional]
**signatureAppearanceUri** | **String** | This is the url to the image that will be impressed on the document after the performance of the signature  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Identity status which can be one of the following. When an identity request is send, the identity is created and the status is **pending** until the provider dont&#39;approve the request. Then status of the identity changes to **active**. If for some reason an error occurs during the process, or after that, the status will be **error**  |  [optional]



## Enum: StatusEnum

Name | Value
---- | -----
PENDING | &quot;pending&quot;
ACTIVE | &quot;active&quot;
ERROR | &quot;error&quot;



