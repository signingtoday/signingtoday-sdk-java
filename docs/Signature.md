

# Signature

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**instanceId** | **Long** | It is a reference for internal use |  [optional] [readonly]
**documentId** | **Integer** | Id of the document |  [optional]
**signatureRequestId** | **Integer** | Id of the requested signature |  [optional]
**signedAt** | [**OffsetDateTime**](OffsetDateTime.md) | Indicates when the DST has been signed |  [optional]
**declinedReason** | **String** |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status of the signature, which can be _signed_ or _declined_ |  [optional] [readonly]
**extraData** | **Map&lt;String, Object&gt;** | Extra data of the signature |  [optional]



## Enum: StatusEnum

Name | Value
---- | -----
SIGNED | &quot;signed&quot;
DECLINED | &quot;declined&quot;



