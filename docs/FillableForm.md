

# FillableForm

Two type of fillable exists; `SignatureForm` and `TextForm`. The former represents the association with the SignatureRequest, the latter represents any editable text form field to be filled before the signature process begins.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**instanceId** | **Long** | It is a reference for internal use |  [optional] [readonly]
**id** | **Integer** | Id of the _form_ |  [optional]
**documentId** | **Integer** | Id of the document |  [optional]
**type** | **String** | Type of the fill form |  [optional]
**positionX** | **Float** | Position onto the X axis of the form, expressed in percentage |  [optional]
**positionY** | **Float** | Position onto the Y axis of the form, expressed in percentage |  [optional]
**width** | **Float** | Width of the form expressed in percentage |  [optional]
**height** | **Float** | Height of the form expressed in percentage |  [optional]
**page** | **Long** | Page of the document where the form is |  [optional]
**signerId** | **Integer** | Id of the signer in the sign plan |  [optional]
**toFill** | **Boolean** | **True** if the field need to be filled by the user. In case of a Signature it is **false**  |  [optional]
**filled** | **Boolean** | True ones the form has been filled |  [optional]
**invisible** | **Boolean** | True if the appearance has to be hidden |  [optional]
**extraData** | **Map&lt;String, Object&gt;** | Extra information about the form |  [optional]



