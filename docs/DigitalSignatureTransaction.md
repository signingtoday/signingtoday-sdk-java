

# DigitalSignatureTransaction

The **Digital Signature Transaction** is the core object at the center of every `digital signature workflow` in Signing Today. It is a `collection` element and holds every document (to be signed or just attached to the transaction) as well as the signature plan required to fulfill the transaction; how many signatures are required, are there any forms to be filled, appearance, signature sequence, signers... everything starts here. 
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**UUID**](UUID.md) | The uuid code that identifies the Digital Signature Transaction |  [optional] [readonly]
**domain** | **String** | The _domain_ is the Organization which a user or a DST belongs |  [optional]
**title** | **String** | Title of the Digital Signature Transaction |  [optional]
**replaces** | [**UUID**](UUID.md) | The _DST_ which this one replaces |  [optional] [readonly]
**replacedBy** | [**UUID**](UUID.md) | The _DST_ which has replaces the current one |  [optional] [readonly]
**createdByUser** | [**UUID**](UUID.md) | The user created the Digital Signature Transaction |  [optional] [readonly]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | Date of creation of the Digital Signature Transaction |  [optional] [readonly]
**documents** | [**List&lt;Document&gt;**](Document.md) | The _documents_ field is an array containing document objects, where everyone of them is defined as follows  |  [optional]
**publishedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The _date-time_ the DST has been published |  [optional] [readonly]
**expiresAt** | [**OffsetDateTime**](OffsetDateTime.md) | Indicates when the DST will expire |  [optional] [readonly]
**resources** | [**List&lt;LFResource&gt;**](LFResource.md) | An array of resources attached to the _DST_, each one defined as follows |  [optional]
**signatures** | [**List&lt;Signature&gt;**](Signature.md) | An array of signatures, each one defined as follows |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status of the _Digital Signature Transaction_ |  [optional] [readonly]
**errorMessage** | **String** | The explication of the occurred error |  [optional]
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | Indicates when the _DST_ has been deleted |  [optional] [readonly]
**tags** | **List&lt;String&gt;** | An array of tags for the _DST_. In such way is possible to tag in the same way some _DSTs_ in order to keep them organized and been easy to find them through the custom search |  [optional]
**template** | **Boolean** | Indicates if a template has been used to create the DST or not |  [optional]
**publicTemplate** | **Boolean** | Indicates if a public template has been used to create the DST or not |  [optional]
**extraData** | **Map&lt;String, Object&gt;** | Extra information about the _DST_ |  [optional]
**visibleTo** | [**List&lt;UUID&gt;**](UUID.md) | UUIDs of the users to which the DST is visible |  [optional]
**ccGroups** | **List&lt;String&gt;** | Name of groups that are informed about the DST |  [optional]
**ccUsers** | [**List&lt;UUID&gt;**](UUID.md) | UUIDs of the users that are informed about the DST |  [optional]
**urgent** | **Boolean** | True if the DST is flagged as urgent |  [optional]
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | Indicates the last update of the DST, such as the performing of a signature |  [optional] [readonly]



## Enum: StatusEnum

Name | Value
---- | -----
DRAFT | &quot;draft&quot;
DOWNLOADINGINDRAFT | &quot;downloadingInDraft&quot;
DOWNLOADINGINPUBLISHED | &quot;downloadingInPublished&quot;
PUBLISHED | &quot;published&quot;
TOFILL | &quot;toFill&quot;
TOSIGN | &quot;toSign&quot;
EXPIRED | &quot;expired&quot;
SIGNED | &quot;signed&quot;
REJECTED | &quot;rejected&quot;
ERROR | &quot;error&quot;



