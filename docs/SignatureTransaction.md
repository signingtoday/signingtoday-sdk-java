

# SignatureTransaction

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**created** | **String** | Date of creation of the Digital Signature Transaction |  [optional]
**createdBy** | **String** | The user created the Digital Signature Transaction |  [optional]
**documents** | [**List&lt;Document1&gt;**](Document1.md) | The _documents_ field is an array containing document objects, where everyone of them is defined as follows  |  [optional]
**id** | [**UUID**](UUID.md) | The uuid code that identifies the Digital Signature Transaction |  [optional]
**notAfter** | **String** | Deadline of the Digital Signature Transaction, expressed in ISO format |  [optional]
**reason** | [**ReasonEnum**](#ReasonEnum) | The motivations for the cancellation may be:   - &#x60;CANNOT_DOWNLOAD_DOCUMENT&#x60;: Signing Today could not download the     document   - &#x60;INVALID_DOCUMENT&#x60;: The downloaded document is not valid   - &#x60;PROTECTED_DOCUMENT&#x60;: The document is protected by password   - &#x60;declined&#x60;: One of the documents has been refused   - &#x60;MOTIVAZIONE_ESPLICITA&#x60;: Rejected from the system with a custom     reason  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The Digital Signature Transaction may have the following statuses:   - &#x60;waiting&#x60;: Not all the documents has ben uploaded and validated yet   - &#x60;pending&#x60;: The DST is ready to be signed   - &#x60;performed&#x60;: The DST has been signed by all the signers   - &#x60;expired&#x60;: The DST expired before all the signers have signed it   - &#x60;cancelled&#x60;: The DST has been canceled; the motivation is in the reason  |  [optional]
**templateName** | **String** | A label to indicate the template used to create the Digital Signature Transaction |  [optional]
**title** | **String** | Title of the Digital Signature Transaction |  [optional]
**urlback** | **String** | The url for the redirection from signature tray when the Digital Signature Transaction is completed or annulled |  [optional]



## Enum: ReasonEnum

Name | Value
---- | -----
CANNOT_DOWNLOAD_DOCUMENT | &quot;CANNOT_DOWNLOAD_DOCUMENT&quot;
INVALID_DOCUMENT | &quot;INVALID_DOCUMENT&quot;
PROTECTED_DOCUMENT | &quot;PROTECTED_DOCUMENT&quot;
DECLINED | &quot;declined&quot;
MOTIVAZIONE_ESPLICITA | &quot;MOTIVAZIONE_ESPLICITA&quot;



## Enum: StatusEnum

Name | Value
---- | -----
WAITING | &quot;waiting&quot;
PENDING | &quot;pending&quot;
PERFORMED | &quot;performed&quot;
EXPIRED | &quot;expired&quot;
CANCELLED | &quot;cancelled&quot;



