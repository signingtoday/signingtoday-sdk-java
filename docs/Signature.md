

# Signature

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**automatic** | **Boolean** | If true indicates that the signer is an _automatic_ one, thus the signature procedure will be different from a regular signer |  [optional]
**constraints** | [**Object**](.md) | Particular constraints for the Signature. For example constraints about the _firs tname_ or _last name_ of the certificate associated with the identity is going to sign. The way to use this field is through the _django lookups_, for example:   - \&quot;certificate__subject_givenName__iexact&#x3D;JOHN\&quot;  |  [optional]
**declinable** | **Boolean** | If true the signer is able to decline the Signature if he wants to |  [optional]
**declineUrl** | **String** | This is the url to decline a digital signature transaction |  [optional]
**description** | **String** | This is a simple description to attach with the Signature |  [optional]
**descriptionHtml** | **String** | This is a _html_ description to attach with the Signature |  [optional]
**displayName** | **String** | This is the name will be displayed on the signature tray associated to the Signature has to be performed. Usually is the _full name_ of the user is going to sign |  [optional]
**id** | [**UUID**](UUID.md) | The uuid code that identifies the Signature |  [optional]
**profile** | [**ProfileEnum**](#ProfileEnum) | The _profile_ field of the Signature object specifies the modality of signature is going to be performed, and can be:   - _PADES_ : allows to exclusively sign a pdf file with the signature     directly affixed into the document;   - _CADES_ : allows to sign different types of documents; the signature     is not \&quot;physically\&quot; into the document but the signature and the file     are placed together in an envelope instead, making thus a .p7m extension.  |  [optional]
**reason** | **String** | The reason of the Signature, or rather a motivational description associated to the Signature |  [optional]
**signatureTicket** | **String** | This is the url where a signature tray is predisposed for a specific signer that have to sign a specific digital signature transaction |  [optional]
**signer** | **String** | The user that have to sign the digital signature transaction |  [optional]
**signerGroup** | **String** | The group which the signer belongs. This field is used in the scenario of a digital signature transaction that has multiple signatures to be performed, where the signers belongs to the same group. Let&#39;s think to the group _\&quot;teachers\&quot;_ of a school. Thus is possible to add the _signer_group_ _\&quot;teachers\&quot;_ as signers of the digital signature transaction without worrying about who really belong to that group |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the Signature. As the digital signature transaction is created the status of the Signature is _waiting_, if everything is legit than the status changes to _pending_, otherwise to _error_. Once the Signature is made the status changes to _performed_. If the DST expires before the Signature is performed then the status changes to _expired_ |  [optional]
**urlback** | **String** | The url for the redirection from Signature tray when the digital signature transaction is completed or annulled |  [optional]
**where** | [**SignatureWhere**](SignatureWhere.md) |  |  [optional]



## Enum: ProfileEnum

Name | Value
---- | -----
PADES_BES | &quot;pades-bes&quot;
PADES_T | &quot;pades-t&quot;
CADES_BES | &quot;cades-bes&quot;
CADES_T | &quot;cades-t&quot;



## Enum: StatusEnum

Name | Value
---- | -----
WAITING | &quot;waiting&quot;
PENDING | &quot;pending&quot;
PERFORMED | &quot;performed&quot;
EXPIRED | &quot;expired&quot;
ERROR | &quot;error&quot;



