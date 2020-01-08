

# User

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**automatic** | **Boolean** | If true indicates that the User is an _automatic_ one, thus the signature procedure will be different from a regular signer |  [optional]
**createdBy** | **String** | This field shows who created the User - _user_name@organization-id_. It may be a SigningToday system User as well |  [optional]
**email** | **String** | The email associated to the User |  [optional]
**firstName** | **String** | First name of the User |  [optional]
**id** | [**UUID**](UUID.md) | The uuid code that identifies the User | 
**lastName** | **String** | Last name of the User |  [optional]
**owner** | **Boolean** | The _owner field_ gives to the User administrative permissions |  [optional]
**rao** | **Boolean** | The _rao field_ identifies a RAO User, the one can associate identities to the other users |  [optional]
**status** | **String** | The status of the User |  [optional]
**type** | **String** | The _type field_ identifies the permissions the User have |  [optional]
**wallet** | [**List&lt;Identity&gt;**](Identity.md) | The wallet of an User identifies its portfolio of identities |  [optional]



