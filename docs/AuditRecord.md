

# AuditRecord

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**instanceId** | **Long** | It is a reference for internal use |  [optional] [readonly]
**at** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**event** | [**EventEnum**](#EventEnum) |  |  [optional]
**signer** | [**SignerRecord**](SignerRecord.md) |  |  [optional]
**value** | **String** |  |  [optional]
**dstId** | [**UUID**](UUID.md) |  |  [optional]
**documentId** | **Integer** |  |  [optional]
**fillableFormId** | **Integer** |  |  [optional]
**signatureRequestId** | **Integer** |  |  [optional]
**noteId** | **Long** |  |  [optional]



## Enum: EventEnum

Name | Value
---- | -----
EVENT_PUBLISHED | &quot;event_published&quot;
EVENT_FORM_FILL | &quot;event_form_fill&quot;
EVENT_SIGNATURE | &quot;event_signature&quot;
EVENT_REJECTION | &quot;event_rejection&quot;
EVENT_REPLACEMENT | &quot;event_replacement&quot;
EVENT_NOTE_ADD | &quot;event_note_add&quot;
EVENT_NOTE_MODIFY | &quot;event_note_modify&quot;
EVENT_NOTE_DELETE | &quot;event_note_delete&quot;
EVENT_SOLICITATION | &quot;event_solicitation&quot;
STAGE_TO_FILL | &quot;stage_to_fill&quot;
STAGE_TO_SIGN | &quot;stage_to_sign&quot;
STAGE_EXPIRED | &quot;stage_expired&quot;
STAGE_SIGNED | &quot;stage_signed&quot;
STAGE_REJECTED | &quot;stage_rejected&quot;
EVENT_UPLOAD_ALFRESCO | &quot;event_upload_alfresco&quot;



