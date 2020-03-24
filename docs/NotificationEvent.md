

# NotificationEvent

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Long** |  |  [optional] [readonly]
**time** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional] [readonly]
**dstId** | [**UUID**](UUID.md) |  |  [optional] [readonly]
**userId** | [**UUID**](UUID.md) |  |  [optional] [readonly]
**dstTitle** | **String** |  |  [optional]
**username** | **String** | If present limits the notification to one user account, otherwise is to be intended for all (active) user accounts (e.g. PC/devices, etc). Indeed one principal (User) could have multiple account (credentials)  |  [optional]
**email** | **String** |  |  [optional]
**event** | [**EventEnum**](#EventEnum) |  |  [optional] [readonly]



## Enum: EventEnum

Name | Value
---- | -----
STATUS_PUBLISHED | &quot;dst_status_published&quot;
STATUS_EXPIRED | &quot;dst_status_expired&quot;
STATUS_REJECTED | &quot;dst_status_rejected&quot;
STATUS_SIGNED | &quot;dst_status_signed&quot;
STATUS_ERROR | &quot;dst_status_error&quot;
ALERT_FILL | &quot;dst_alert_fill&quot;
ALERT_SIGN | &quot;dst_alert_sign&quot;
ALERT_NOTE_ADDED | &quot;dst_alert_note_added&quot;
ALERT_NOTE_MODIFIED | &quot;dst_alert_note_modified&quot;
ALERT_NOTE_DELETED | &quot;dst_alert_note_deleted&quot;



