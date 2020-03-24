

# DSTNote

The _DSTNote_ represents a text note that can be attached to a DST whenever an entitled user needs it (when requesting for clarifications, informing of the proceedings, adding context) 
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Long** | The id of the note |  [optional]
**dstId** | [**UUID**](UUID.md) | The _UUID_ code of the Digital Signature Transaction |  [optional]
**userId** | [**UUID**](UUID.md) | The _UUID_ code of the user which created the _Note_ |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The _data-time_ of the note creation |  [optional]
**text** | **String** | Actual content of the _DST Note_ |  [optional]



