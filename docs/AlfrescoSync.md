

# AlfrescoSync

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** |  |  [optional] [readonly]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional] [readonly]
**completedAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional] [readonly]
**message** | **String** |  |  [optional] [readonly]



## Enum: StatusEnum

Name | Value
---- | -----
NOT_SCHEDULED | &quot;NOT_SCHEDULED&quot;
ENQUEUED | &quot;ENQUEUED&quot;
RUNNING | &quot;RUNNING&quot;
FAILED | &quot;FAILED&quot;
COMPLETED | &quot;COMPLETED&quot;



