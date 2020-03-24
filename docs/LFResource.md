

# LFResource

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**UUID**](UUID.md) | Unique id of the resource |  [optional]
**domain** | **String** | The _domain_ is the Organization which a user or a DST belongs |  [optional]
**type** | **String** | Type of the resource, for example a _PDFResource_ |  [optional] [readonly]
**dstUuid** | [**UUID**](UUID.md) | Unique id of the _DST_ which the resource is correlated |  [optional] [readonly]
**title** | **String** | Title of the resource |  [optional]
**filename** | **String** | Name of the file uploaded, with its extension as well |  [optional]
**url** | **String** | Url of the resource |  [optional] [readonly]
**size** | **Long** | Size of the resource |  [optional] [readonly]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | Indicates when the resource has been uploaded |  [optional] [readonly]
**mimetype** | **String** | _MIME_ type of the resource |  [optional] [readonly]
**pages** | **Integer** | Indicates how many pages the resource is |  [optional]
**extraData** | **Map&lt;String, Object&gt;** | Extra data of the resource |  [optional]



