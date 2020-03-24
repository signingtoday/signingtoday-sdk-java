

# CreateDigitalSignatureTransaction

The **DST Template** from which will be created the DST 
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**title** | **String** | Title of the _Digital Signature Transaction_ |  [optional]
**documents** | [**List&lt;CreateDocument&gt;**](CreateDocument.md) | The document or documents of the _DST_ |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status of the _DST_ |  [optional]
**expiresAt** | [**OffsetDateTime**](OffsetDateTime.md) | Date of expiration of the _DST_ |  [optional]
**tags** | **List&lt;String&gt;** | An array of tags for the DST. In such way is possible to tag in the same way some DSTs in order to keep them organized and been easy to find them through the custom search |  [optional]
**template** | **Boolean** | True if the _DST_ has been created from a template |  [optional]
**publicTemplate** | **Boolean** | Indicates if a public template has been used to create the DST or not |  [optional]
**ccGroups** | **List&lt;String&gt;** | Name of groups that are informed about the DST. |  [optional]
**ccUsers** | [**List&lt;UUID&gt;**](UUID.md) | UUIDs of the users that are informed about the DST. |  [optional]
**urgent** | **Boolean** | True if the DST is flagged as urgent |  [optional]



## Enum: StatusEnum

Name | Value
---- | -----
DRAFT | &quot;draft&quot;
PUBLISHED | &quot;published&quot;



