

# Document

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**instanceId** | **Long** | It is a reference for internal use |  [optional] [readonly]
**id** | **Integer** | Unique Id of the document |  [optional]
**plainDocumentUuid** | [**UUID**](UUID.md) | Id of the associated Resource (plain PDF file e.g. the one uploaded by the user) |  [optional]
**filledDocumentUuid** | [**UUID**](UUID.md) | Id of the associated PDF file that contains all the forms filled (present only once the whole document has been filled) |  [optional] [readonly]
**signedDocumentUuid** | [**UUID**](UUID.md) | Id of the associated PDF file that contains all the signatures  (present only once the whole document has been signed) |  [optional] [readonly]
**status** | [**StatusEnum**](#StatusEnum) | The status of the _Document_, which can be: - \&quot;plain\&quot;: The document has been correctly updated by the user - \&quot;filled\&quot;: The document has been filled - \&quot;signed\&quot;: The document has been signed  |  [optional] [readonly]
**forms** | [**List&lt;FillableForm&gt;**](FillableForm.md) | The fillable elements of the document. Use the type field to identify textual fillable fields and signature fields |  [optional]
**signatureRequests** | [**List&lt;SignatureRequest&gt;**](SignatureRequest.md) | The list of signature request of the document |  [optional]
**signerGroups** | [**List&lt;SignersGroup&gt;**](SignersGroup.md) | The sign plan for the document |  [optional]



## Enum: StatusEnum

Name | Value
---- | -----
PLAIN | &quot;plain&quot;
FILLED | &quot;filled&quot;
SIGNED | &quot;signed&quot;



