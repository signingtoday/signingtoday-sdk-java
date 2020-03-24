

# SignatureStatusChangedNotification

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**group** | **Integer** |  |  [optional]
**action** | [**ActionEnum**](#ActionEnum) |  |  [optional]
**dst** | [**SignatureStatusChangedNotificationDst**](SignatureStatusChangedNotificationDst.md) |  |  [optional]
**fillableForm** | [**FillableForm**](FillableForm.md) |  |  [optional]
**signature** | **Integer** |  |  [optional]
**signer** | **String** |  |  [optional]
**document** | [**SignatureStatusChangedNotificationDocument**](SignatureStatusChangedNotificationDocument.md) |  |  [optional]
**automatic** | **Boolean** |  |  [optional]
**page** | **Integer** |  |  [optional]



## Enum: StatusEnum

Name | Value
---- | -----
PENDING | &quot;pending&quot;
PERFORMED | &quot;performed&quot;
EXPIRED | &quot;expired&quot;
ERROR | &quot;error&quot;
DECLINED | &quot;declined&quot;



## Enum: ActionEnum

Name | Value
---- | -----
FILL | &quot;fill&quot;
SIGN | &quot;sign&quot;



