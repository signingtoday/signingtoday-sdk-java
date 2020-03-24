

# CreateUser

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**UUID**](UUID.md) | Uuid code that identifies the User | 
**email** | **String** | The email associated to the User |  [optional]
**firstName** | **String** | First name of the User |  [optional]
**lastName** | **String** | Last name of the User |  [optional]
**createdBy** | **String** | The user created the User (user_name@organization-id). It may be a user of the system as well. |  [optional]
**automatic** | **Boolean** | True means the User is an automatic signer |  [optional]
**owner** | **Boolean** | The owner field gives to the User administrative permissions |  [optional]
**rao** | **Boolean** | The rao field identifies a RAO User |  [optional]



