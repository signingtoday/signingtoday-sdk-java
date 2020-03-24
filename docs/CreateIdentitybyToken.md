

# CreateIdentitybyToken

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**certificate** | **String** | The X.509 certificate in PEM format is wanted to associate to the identity will be created |  [optional]
**label** | **String** | The label is an arbitrary name is possible to associate to an idenity. Doing so allows to distinguish different identities issued from the same provider during the performance of the signature in the signature tray |  [optional]
**data** | [**Object**](.md) | The data associated to the identity, analogue to the _provider_data_ field used during traditional identity creation. Of course the _provider_data_ has to be congruent with the choosen cerficate  |  [optional]



