

# SignatureImplementationResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**certificate** | [**Certificate**](Certificate.md) |  |  [optional]
**channel** | [**SignatureImplementationResponseChannel**](SignatureImplementationResponseChannel.md) |  |  [optional]
**document** | **String** |  |  [optional]
**dst** | [**Id**](Id.md) |  |  [optional]
**group** | **Integer** | Number of the groups which the signer belongs during digital signature transaction creation |  [optional]
**identity** | [**Id**](Id.md) |  |  [optional]
**padesSubfilter** | [**PadesSubfilterEnum**](#PadesSubfilterEnum) |  |  [optional]
**page** | **Integer** |  |  [optional]
**position** | [**Position**](Position.md) |  |  [optional]
**profile** | [**Profile**](Profile.md) |  |  [optional]
**providerId** | [**ProviderId**](ProviderId.md) |  |  [optional]
**reason** | [**Reason**](Reason.md) |  |  [optional]
**signature** | [**Id**](Id.md) |  |  [optional]
**signatureAppearanceUri** | [**SignatureAppearanceUri**](SignatureAppearanceUri.md) |  |  [optional]
**signatureText** | **String** |  |  [optional]
**signingTime** | [**SigningTimeEnum**](#SigningTimeEnum) |  |  [optional]
**title** | [**Title**](Title.md) |  |  [optional]



## Enum: PadesSubfilterEnum

Name | Value
---- | -----
ETSI_CADES_DETACHED | &quot;ETSI.CAdES.detached&quot;



## Enum: SigningTimeEnum

Name | Value
---- | -----
PDF | &quot;pdf&quot;



