

# SignatureImplementationResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**profile** | [**Profile**](Profile.md) |  |  [optional]
**providerId** | [**ProviderId**](ProviderId.md) |  |  [optional]
**position** | [**Position**](Position.md) |  |  [optional]
**group** | **Integer** | Number of the groups which the signer belongs during digital signature transaction creation |  [optional]
**certificate** | [**Certificate**](Certificate.md) |  |  [optional]
**title** | [**Title**](Title.md) |  |  [optional]
**dst** | [**Id**](Id.md) |  |  [optional]
**signingTime** | [**SigningTimeEnum**](#SigningTimeEnum) |  |  [optional]
**reason** | [**Reason**](Reason.md) |  |  [optional]
**channel** | [**SignatureImplementationResponseChannel**](SignatureImplementationResponseChannel.md) |  |  [optional]
**signatureText** | **String** |  |  [optional]
**signature** | [**Id**](Id.md) |  |  [optional]
**signatureAppearanceUri** | [**SignatureAppearanceUri**](SignatureAppearanceUri.md) |  |  [optional]
**padesSubfilter** | [**PadesSubfilterEnum**](#PadesSubfilterEnum) |  |  [optional]
**document** | **String** |  |  [optional]
**page** | **Integer** |  |  [optional]
**identity** | [**Id**](Id.md) |  |  [optional]



## Enum: SigningTimeEnum

Name | Value
---- | -----
PDF | &quot;pdf&quot;



## Enum: PadesSubfilterEnum

Name | Value
---- | -----
ETSI_CADES_DETACHED | &quot;ETSI.CAdES.detached&quot;



