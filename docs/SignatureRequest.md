

# SignatureRequest

The association with the document is hold in the extraData of the FillableForm.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**instanceId** | **Long** | It is a reference for internal use |  [optional] [readonly]
**id** | **Integer** |  |  [optional]
**reason** | **String** |  |  [optional]
**description** | **String** |  |  [optional]
**signerId** | **Integer** |  |  [optional]
**signProfile** | [**SignProfileEnum**](#SignProfileEnum) |  |  [optional]
**withTimestamp** | **Boolean** |  |  [optional]
**declinable** | **Boolean** |  |  [optional]
**restrictions** | [**List&lt;SignatureRestriction&gt;**](SignatureRestriction.md) |  |  [optional]
**extraData** | **Map&lt;String, Object&gt;** |  |  [optional]



## Enum: SignProfileEnum

Name | Value
---- | -----
CADES | &quot;CAdES&quot;
PADES | &quot;PAdES&quot;



