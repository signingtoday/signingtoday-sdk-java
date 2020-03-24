

# User

The **User** object is the one that serializes the users of the _Organizations_. The _User_ has field that identifies the generality of the person who has been registered and uses the platform, as well as the digital identities through which he can sign documents. 
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**UUID**](UUID.md) | The unique id of the User |  [optional] [readonly]
**username** | **String** | The username of the User. The username is used to login |  [optional]
**domain** | **String** | The _domain_ is the Organization which a user or a DST belongs |  [optional]
**language** | [**LanguageEnum**](#LanguageEnum) | The default language of the User |  [optional]
**name** | **String** | The name of the User |  [optional]
**surname** | **String** | The name of the User |  [optional]
**email** | **String** | The email address of the User |  [optional]
**phone** | [**BigDecimal**](BigDecimal.md) | The phone number of the User |  [optional]
**role** | [**RoleEnum**](#RoleEnum) | The role of the User. The **admin** can create users, as well as DSTs and can sign. The **instructor** can create DSTs and sign. The **signer** can only sign documents.  |  [optional]
**groups** | [**List&lt;UserGroup&gt;**](UserGroup.md) | A group of users. This is useful during DSTs creation, it is possible to select a group as signers. This way all the components of that group have to sign the document |  [optional]
**capabilities** | [**CapabilitiesEnum**](#CapabilitiesEnum) | The capabilities represents the action a user is able to do |  [optional]
**createdBy** | [**UUID**](UUID.md) | The one which created the User |  [optional] [readonly]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date of the creation of the User |  [optional] [readonly]
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date of deletion of the User |  [optional] [readonly]
**automatic** | **Boolean** | If true the user is automatic |  [optional] [readonly]
**extraData** | **Map&lt;String, Object&gt;** | Extra data associated to the User |  [optional]



## Enum: LanguageEnum

Name | Value
---- | -----
IT | &quot;it&quot;
EN | &quot;en&quot;
ES | &quot;es&quot;
FR | &quot;fr&quot;



## Enum: RoleEnum

Name | Value
---- | -----
ADMIN | &quot;admin&quot;
INSTRUCTOR | &quot;instructor&quot;
SIGNER | &quot;signer&quot;



## Enum: CapabilitiesEnum

Name | Value
---- | -----



