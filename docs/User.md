

# User

The User object is one of the components of the organization, which can sign digital signature transactions through one of the identities it got in the its wallet. Some of the most specific fields of this object are _\"automatic\"_, _\"rao\"_ and _\"owner\"_. They are boolean values. The first one indicates if the User can sign dsts into an automatic way, without passing through the signature tray. The rao field allows the User to enroll identities for the users of its organization. At last the owner field means that the token associated to the organization belongs to it and thus this particular User has administrative permissions. 
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**UUID**](UUID.md) | The uuid code that identifies the User | 
**status** | **String** | The status of the User |  [optional]
**type** | **String** | The _type field_ identifies the permissions the User have |  [optional]
**email** | **String** | The email associated to the User |  [optional]
**firstName** | **String** | First name of the User |  [optional]
**lastName** | **String** | Last name of the User |  [optional]
**createdBy** | **String** | This field shows who created the User - _user_name@organization-id_. It may be a SigningToday system User as well |  [optional]
**automatic** | **Boolean** | If true indicates that the User is an _automatic_ one, thus the signature procedure will be different from a regular signer |  [optional]
**owner** | **Boolean** | The _owner field_ gives to the User administrative permissions |  [optional]
**rao** | **Boolean** | The _rao field_ identifies a RAO User, the one can associate identities to the other users |  [optional]
**wallet** | [**List&lt;Identity&gt;**](Identity.md) | The wallet of an User identifies its portfolio of identities |  [optional]



