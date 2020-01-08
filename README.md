# signingToday-java-client
Signing Today API
- API version: 1.5.0
  - Build date: 2020-01-03T15:44:26.198Z[GMT]
*Signing Today* enables seamless integration of digital signatures into any
website by the use of easy requests to our API. This is the smart way of
adding digital signature support with a great user experience.
*Signing Today APIs* use HTTP methods and are RESTful based, moreover they
are protected by a *server to server authentication* standard by the use of
tokens.
*Signing Today APIs* can be used in these environments:
| Environment | Description | Endpoint |
| ----------- | ----------- | -------- |
| Sandbox     | Test environment | `https://sandbox.signingtoday.com` |
| Live        | Production environment | `https://api.signingtoday.com` |
For every single request to Signing Today has to be defined the following
*HTTP* header:
- `Authorization`, which contains the authentication token.
If the request has a body than another *HTTP* header is requested:
- `Content-Type`, with `application/json` value.
Follows an example of usage to enumerate all the user of *my-org*
organization.
**Example**
```json
$ curl https://sandbox.signingtoday.com/api/v1/my-org/users \
    -H 'Authorization: Token <access-token>'
```
## HTTP methods used
APIs use the right HTTP verb in every situation.
| Method   | Description                    |
| -------- | ------------------------------ |
| `GET`    | Request data from a resource   |
| `POST`   | Send data to create a resource |
| `PUT`    | Update a resource              |
| `PATCH`  | Partially update a resource    |
| `DELETE` | Delete a resourse              |
## Response definition
All the response are in JSON format.
As response to a request of all users of an organization you will have a
result like this:
```json
{
    "pagination": {
      "count": 75,
      "previous": "https://sandbox.signingtoday.com/api/v1/my-org/users?page=1",
      "next": "https://sandbox.signingtoday.com/api/v1/my-org/users?page=3",
      "pages": 8,
      "page": 2
    },
    "meta": {
      "code": 200
    },
    "data": [
      {
        "id": "jdo",
        "status": "enabled",
        "type": "Basic user account",
        "email": johndoe@dummyemail.com,
        "first_name": "John",
        "last_name": "Doe",
        "wallet": [],
        "created_by": "system",
        "owner": false,
        "automatic": false,
        "rao": false
      },
      ...
    ]
  }
```
The JSON of the response is made of three parts:
- Pagination
- Meta
- Data
### Pagination
*Pagination* object allows to split the response into parts and then to
rebuild it sequentially by the use of `next` and `previous` parameters, by
which you get previous and following blocks. The *Pagination* is present
only if the response is a list of objects.
The general structure of *Pagination* object is the following:
```json
{
    "pagination": {
      "count": 75,
      "previous": "https://sandbox.signingtoday.com/api/v1/my-org/users?page=1",
      "next": "https://sandbox.signingtoday.com/api/v1/my-org/users?page=3",
      "pages": 8,
      "page": 2
    },
    ...
  }
```
### Meta
*Meta* object is used to enrich the information about the response. In the
previous example, a successful case of response, *Meta* will have value
`status: 2XX`. In case of unsuccessful response, *Meta* will have further
information, as follows:
```json
{
    "meta": {
      "code": <HTTP STATUS CODE>,
      "error_type": <STATUS CODE DESCRIPTION>,
      "error_message": <ERROR DESCRIPTION>
    }
  }
```
### Data
*Data* object outputs as object or list of them. Contains the expected data
as requested to the API.
## Search filters
Search filters of the API have the following structure:
`where_ATTRIBUTENAME`=`VALUE`
In this way you make a case-sensitive search of *VALUE*. You can extend it
through the Django lookup, obtaining more specific filters. For example:
`where_ATTRIBUTENAME__LOOKUP`=`VALUE`
where *LOOKUP* can be replaced with `icontains` to have a partial insensitive
research, where
`where_first_name__icontains`=`CHa`
matches with every user that have the *cha* string in their name, with
no differences between capital and lower cases.
[Here](https://docs.djangoproject.com/en/1.11/ref/models/querysets/#field-lookups)
the list of the lookups.
## Webhooks
Signing Today supports webhooks for the update of DSTs and identities status.
You can choose if to use or not webhooks and if you want to receive updates
about DSTs and/or identities. You can configurate it on application token
level, in the *webhook* field, as follows:
```json
"webhooks": {
  "dst": "URL",
  "identity": "URL"
  }
```
### DSTs status update
DSTs send the following status updates:
- **DST_STATUS_CHANGED**: whenever the DST changes its status
- **SIGNATURE_STATUS_CHANGED**: whenever one of the signatures changes its
status
#### DST_STATUS_CHANGED
Sends the following information:
```json
{
    "message": "DST_STATUS_CHANGED",
    "data": {
      "status": "<DST_STATUS>",
      "dst": "<DST_ID>",
      "reason": "<DST_REASON>"
    }
  }
```
#### SIGNATURE_STATUS_CHANGED
Sends the following information:
```json
{
    "message": "SIGNATURE_STATUS_CHANGED",
    "data": {
      "status": "<SIGNATURE_STATUS>",
      "group": <MEMBERSHIP_GROUP_INDEX>,
      "dst": {
        "id": "<DST_ID>",
        "title": "<DST_TITLE>"
      },
      "signature": "<SIGNATURE_ID>",
      "signer": "<SIGNER_USERNAME>",
      "position": "<SIGNATURE_POSITION>",
      "document": {
        "display_name": "<DOCUMENT_TITLE>",
        "id": "<DOCUMENT_ID>",
        "order": <DOCUMENT_INDEX>
      },
      "automatic": <DECLARES_IF_THE_SIGNER_IS_AUTOMATIC>,
      "page": "<SIGNATURE_PAGE>"
    }
  }
```
### Identities status update
Identities send the following status updates:
- **IDENTITY_REQUEST_ENROLLED**: whenever an identity request is activated
#### IDENTITY_REQUEST_ENROLLED
Sends the following information:
```json
{
    "message": "IDENTITY_REQUEST_ENROLLED",
    "data": {
      "status": "<REQUEST_STATUS>",
      "request": "<REQUEST_ID>",
      "user": "<APPLICANT_USERNAME>"
    }
  }
```
### Urlback
Sometimes may be necessary to make a redirect after an user, from the
signature tray, has completed his operations or activated a certificate.
If set, redirects could happen in 3 cases:
- after a signature or decline
- after a DST has been signed by all the signers or canceled
- after the activation of a certificate
In the first two cases the urlback returns the following information through
a data form:
- **dst-id**: id of the DST
- **dst-url**: signature_ticket of the signature
- **dst-status**: current status of the DST
- **dst-signature-id**: id of the signature
- **dst-signature-status**: current status of the signature
- **user**: username of the signer
- **decline-reason**: in case of a refused DST contains the reason of the
decline
In the last case the urlback returns the following information through a
data form:
- **user**: username of the user activated the certificate
- **identity-provider**: the provider has been used to issue the certificate
- **identity-request-id**: id of the enrollment request
- **identity-id**: id of the new identity
- **identity-label**: the label assigned to the identity
- **identity-certificate**: public key of the certificate
  For more information, please visit [https://signing.today/contacts/](https://signing.today/contacts/)
*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*
## Requirements
Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle
## Installation
To install the API client library to your local Maven repository, simply execute:
```shell
mvn clean install
```
To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:
```shell
mvn clean deploy
```
Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.
### Maven users
Add this dependency to your project's POM:
```xml
<dependency>
  <groupId>signingToday</groupId>
  <artifactId>signingToday-java-client</artifactId>
  <version>1.5.0</version>
  <scope>compile</scope>
</dependency>
```
### Gradle users
Add this dependency to your project's build file:
```groovy
compile "signingToday:signingToday-java-client:1.5.0"
```
### Others
At first generate the JAR by executing:
```shell
mvn clean package
```
Then manually install the following JARs:
* `target/signingToday-java-client-1.5.0.jar`
* `target/lib/*.jar`
## Getting Started
Please follow the [installation](#installation) instruction and execute the following Java code:
```java
// Import classes:
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.Configuration;
import signingToday.client.auth.*;
import signingToday.client.models.*;
import signingToday.client.api.Bit4idPathgroupIdentitiesApi;
public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://sandbox.signingtoday.com/api/v1");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");
    Bit4idPathgroupIdentitiesApi apiInstance = new Bit4idPathgroupIdentitiesApi(defaultClient);
    String organizationId = api-demo; // String | The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization 
    Id identityId = new Id(); // Id | The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity 
    InlineObject inlineObject = new InlineObject(); // InlineObject | 
    try {
      InlineResponse2004 result = apiInstance.associateAppearance(organizationId, identityId, inlineObject);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Bit4idPathgroupIdentitiesApi#associateAppearance");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```
## Documentation for API Endpoints
All URIs are relative to *https://sandbox.signingtoday.com/api/v1*
Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*Bit4idPathgroupIdentitiesApi* | [**associateAppearance**](docs/Bit4idPathgroupIdentitiesApi.md#associateAppearance) | **POST** /{organization-id}/identities/{identity-id}/appearance | Associate an appearance to an identity
*Bit4idPathgroupIdentitiesApi* | [**associateIdentity**](docs/Bit4idPathgroupIdentitiesApi.md#associateIdentity) | **POST** /{organization-id}/users/{user-id}/wallet | Associate to an user an already existing identity
*Bit4idPathgroupIdentitiesApi* | [**createTokenFromIdentity**](docs/Bit4idPathgroupIdentitiesApi.md#createTokenFromIdentity) | **POST** /{organization-id}/identities/create/token | Create an identity from token
*Bit4idPathgroupIdentitiesApi* | [**deleteAppearance**](docs/Bit4idPathgroupIdentitiesApi.md#deleteAppearance) | **DELETE** /{organization-id}/identities/{identity-id}/appearance | Delete the appearance of an identity
*Bit4idPathgroupIdentitiesApi* | [**deleteEnrollmentRequest**](docs/Bit4idPathgroupIdentitiesApi.md#deleteEnrollmentRequest) | **DELETE** /{organization-id}/identity-requests/{enrollment-id} | Delete an enrollment request
*Bit4idPathgroupIdentitiesApi* | [**deleteIdentity**](docs/Bit4idPathgroupIdentitiesApi.md#deleteIdentity) | **DELETE** /{organization-id}/identities/{identity-id} | Delete an identity
*Bit4idPathgroupIdentitiesApi* | [**getEnrollmentRequest**](docs/Bit4idPathgroupIdentitiesApi.md#getEnrollmentRequest) | **GET** /{organization-id}/identity-requests/{enrollment-id} | Get information about an enrollment request
*Bit4idPathgroupIdentitiesApi* | [**getIdentity**](docs/Bit4idPathgroupIdentitiesApi.md#getIdentity) | **GET** /{organization-id}/identities/{identity-id} | Get information about an identity
*Bit4idPathgroupIdentitiesApi* | [**listEnrollmentRequests**](docs/Bit4idPathgroupIdentitiesApi.md#listEnrollmentRequests) | **GET** /{organization-id}/identity-requests | Enumerate the enrollment requests of an organization
*Bit4idPathgroupIdentitiesApi* | [**listIdentities**](docs/Bit4idPathgroupIdentitiesApi.md#listIdentities) | **GET** /{organization-id}/identities | Enumerate the identities of an organization
*Bit4idPathgroupIdentitiesApi* | [**listUserEnrollments**](docs/Bit4idPathgroupIdentitiesApi.md#listUserEnrollments) | **GET** /{organization-id}/users/{user-id}/identity-requests | List the enrollments of an user
*Bit4idPathgroupIdentitiesApi* | [**listUserIdentities**](docs/Bit4idPathgroupIdentitiesApi.md#listUserIdentities) | **GET** /{organization-id}/users/{user-id}/wallet | Enumerate the identities of an user
*Bit4idPathgroupIdentitiesApi* | [**requestEnrollment**](docs/Bit4idPathgroupIdentitiesApi.md#requestEnrollment) | **POST** /{organization-id}/enroll | Submit an enrollment request
*Bit4idPathgroupOrganizationsApi* | [**getOrganization**](docs/Bit4idPathgroupOrganizationsApi.md#getOrganization) | **GET** /organizations/{organization-id} | Get the settings of an oraganization
*Bit4idPathgroupOrganizationsApi* | [**patchOrganization**](docs/Bit4idPathgroupOrganizationsApi.md#patchOrganization) | **PATCH** /organizations/{organization-id} | Edit the settings of an organization
*Bit4idPathgroupSignatureTransactionsApi* | [**cancelDST**](docs/Bit4idPathgroupSignatureTransactionsApi.md#cancelDST) | **POST** /{organization-id}/signature-transactions/{dst-id}/cancel | Mark a DST as canceled
*Bit4idPathgroupSignatureTransactionsApi* | [**createDST**](docs/Bit4idPathgroupSignatureTransactionsApi.md#createDST) | **POST** /{organization-id}/signature-transactions | Create a Digital Signature Transaction
*Bit4idPathgroupSignatureTransactionsApi* | [**deleteDST**](docs/Bit4idPathgroupSignatureTransactionsApi.md#deleteDST) | **DELETE** /{organization-id}/signature-transactions/{dst-id} | Delete a Digital Signature Transaction
*Bit4idPathgroupSignatureTransactionsApi* | [**getDST**](docs/Bit4idPathgroupSignatureTransactionsApi.md#getDST) | **GET** /{organization-id}/signature-transactions/{dst-id} | Get information about a DST
*Bit4idPathgroupSignatureTransactionsApi* | [**getDocument**](docs/Bit4idPathgroupSignatureTransactionsApi.md#getDocument) | **GET** /{organization-id}/documents/{document-id}/download | Download a document from a DST
*Bit4idPathgroupSignatureTransactionsApi* | [**listDSTs**](docs/Bit4idPathgroupSignatureTransactionsApi.md#listDSTs) | **GET** /{organization-id}/signature-transactions | List the DSTs of an organization
*Bit4idPathgroupSignaturesApi* | [**createChannel**](docs/Bit4idPathgroupSignaturesApi.md#createChannel) | **POST** /{organization-id}/channels/{dst-id} | Create a channel
*Bit4idPathgroupSignaturesApi* | [**declineDST**](docs/Bit4idPathgroupSignaturesApi.md#declineDST) | **POST** /{organization-id}/signatures/{signature-id}/decline | Decline a Digital Signature Transaction
*Bit4idPathgroupSignaturesApi* | [**performDST**](docs/Bit4idPathgroupSignaturesApi.md#performDST) | **POST** /{organization-id}/signatures/{signature-id}/perform | Sign a DST with an automatic signer
*Bit4idPathgroupSignaturesApi* | [**performSignature**](docs/Bit4idPathgroupSignaturesApi.md#performSignature) | **POST** /{organization-id}/signatures/{signature-id}/perform/{identity-id} | Perform a Signature
*Bit4idPathgroupSignaturesApi* | [**performSignatureWithSession**](docs/Bit4idPathgroupSignaturesApi.md#performSignatureWithSession) | **POST** /{organization-id}/signatures/{signature-id}/session-perform | Perform a Signature with session
*Bit4idPathgroupTokensApi* | [**createToken**](docs/Bit4idPathgroupTokensApi.md#createToken) | **POST** /{organization-id}/tokens | Create an application token
*Bit4idPathgroupTokensApi* | [**deleteToken**](docs/Bit4idPathgroupTokensApi.md#deleteToken) | **DELETE** /{organization-id}/tokens/{token-id} | Delete a token of the organization
*Bit4idPathgroupTokensApi* | [**getToken**](docs/Bit4idPathgroupTokensApi.md#getToken) | **GET** /{organization-id}/tokens/{token-id} | Get information about a token
*Bit4idPathgroupTokensApi* | [**listTokens**](docs/Bit4idPathgroupTokensApi.md#listTokens) | **GET** /{organization-id}/tokens | Enumerate the tokens of an organization
*Bit4idPathgroupTokensApi* | [**listUserTokens**](docs/Bit4idPathgroupTokensApi.md#listUserTokens) | **GET** /{organization-id}/users/{user-id}/tokens | Enumerate the tokens of an user
*Bit4idPathgroupTokensApi* | [**updateToken**](docs/Bit4idPathgroupTokensApi.md#updateToken) | **PUT** /{organization-id}/tokens/{token-id} | Update the properties of a token
*Bit4idPathgroupUsersApi* | [**createUser**](docs/Bit4idPathgroupUsersApi.md#createUser) | **POST** /{organization-id}/users | Create a user of the organization
*Bit4idPathgroupUsersApi* | [**getUser**](docs/Bit4idPathgroupUsersApi.md#getUser) | **GET** /{organization-id}/users/{user-id} | Get information about an user
*Bit4idPathgroupUsersApi* | [**listUsers**](docs/Bit4idPathgroupUsersApi.md#listUsers) | **GET** /{organization-id}/users | Enumerate the users of an organization
*Bit4idPathgroupUsersApi* | [**updateUser**](docs/Bit4idPathgroupUsersApi.md#updateUser) | **PUT** /{organization-id}/users/{user-id} | Edit one or more user properties
*IdentitiesApi* | [**associateAppearance**](docs/IdentitiesApi.md#associateAppearance) | **POST** /{organization-id}/identities/{identity-id}/appearance | Associate an appearance to an identity
*IdentitiesApi* | [**associateIdentity**](docs/IdentitiesApi.md#associateIdentity) | **POST** /{organization-id}/users/{user-id}/wallet | Associate to an user an already existing identity
*IdentitiesApi* | [**createTokenFromIdentity**](docs/IdentitiesApi.md#createTokenFromIdentity) | **POST** /{organization-id}/identities/create/token | Create an identity from token
*IdentitiesApi* | [**deleteAppearance**](docs/IdentitiesApi.md#deleteAppearance) | **DELETE** /{organization-id}/identities/{identity-id}/appearance | Delete the appearance of an identity
*IdentitiesApi* | [**deleteEnrollmentRequest**](docs/IdentitiesApi.md#deleteEnrollmentRequest) | **DELETE** /{organization-id}/identity-requests/{enrollment-id} | Delete an enrollment request
*IdentitiesApi* | [**deleteIdentity**](docs/IdentitiesApi.md#deleteIdentity) | **DELETE** /{organization-id}/identities/{identity-id} | Delete an identity
*IdentitiesApi* | [**getEnrollmentRequest**](docs/IdentitiesApi.md#getEnrollmentRequest) | **GET** /{organization-id}/identity-requests/{enrollment-id} | Get information about an enrollment request
*IdentitiesApi* | [**getIdentity**](docs/IdentitiesApi.md#getIdentity) | **GET** /{organization-id}/identities/{identity-id} | Get information about an identity
*IdentitiesApi* | [**listEnrollmentRequests**](docs/IdentitiesApi.md#listEnrollmentRequests) | **GET** /{organization-id}/identity-requests | Enumerate the enrollment requests of an organization
*IdentitiesApi* | [**listIdentities**](docs/IdentitiesApi.md#listIdentities) | **GET** /{organization-id}/identities | Enumerate the identities of an organization
*IdentitiesApi* | [**listUserEnrollments**](docs/IdentitiesApi.md#listUserEnrollments) | **GET** /{organization-id}/users/{user-id}/identity-requests | List the enrollments of an user
*IdentitiesApi* | [**listUserIdentities**](docs/IdentitiesApi.md#listUserIdentities) | **GET** /{organization-id}/users/{user-id}/wallet | Enumerate the identities of an user
*IdentitiesApi* | [**requestEnrollment**](docs/IdentitiesApi.md#requestEnrollment) | **POST** /{organization-id}/enroll | Submit an enrollment request
*OrganizationsApi* | [**getOrganization**](docs/OrganizationsApi.md#getOrganization) | **GET** /organizations/{organization-id} | Get the settings of an oraganization
*OrganizationsApi* | [**patchOrganization**](docs/OrganizationsApi.md#patchOrganization) | **PATCH** /organizations/{organization-id} | Edit the settings of an organization
*SignatureTransactionsApi* | [**cancelDST**](docs/SignatureTransactionsApi.md#cancelDST) | **POST** /{organization-id}/signature-transactions/{dst-id}/cancel | Mark a DST as canceled
*SignatureTransactionsApi* | [**createDST**](docs/SignatureTransactionsApi.md#createDST) | **POST** /{organization-id}/signature-transactions | Create a Digital Signature Transaction
*SignatureTransactionsApi* | [**deleteDST**](docs/SignatureTransactionsApi.md#deleteDST) | **DELETE** /{organization-id}/signature-transactions/{dst-id} | Delete a Digital Signature Transaction
*SignatureTransactionsApi* | [**getDST**](docs/SignatureTransactionsApi.md#getDST) | **GET** /{organization-id}/signature-transactions/{dst-id} | Get information about a DST
*SignatureTransactionsApi* | [**getDocument**](docs/SignatureTransactionsApi.md#getDocument) | **GET** /{organization-id}/documents/{document-id}/download | Download a document from a DST
*SignatureTransactionsApi* | [**listDSTs**](docs/SignatureTransactionsApi.md#listDSTs) | **GET** /{organization-id}/signature-transactions | List the DSTs of an organization
*SignaturesApi* | [**createChannel**](docs/SignaturesApi.md#createChannel) | **POST** /{organization-id}/channels/{dst-id} | Create a channel
*SignaturesApi* | [**declineDST**](docs/SignaturesApi.md#declineDST) | **POST** /{organization-id}/signatures/{signature-id}/decline | Decline a Digital Signature Transaction
*SignaturesApi* | [**performDST**](docs/SignaturesApi.md#performDST) | **POST** /{organization-id}/signatures/{signature-id}/perform | Sign a DST with an automatic signer
*SignaturesApi* | [**performSignature**](docs/SignaturesApi.md#performSignature) | **POST** /{organization-id}/signatures/{signature-id}/perform/{identity-id} | Perform a Signature
*SignaturesApi* | [**performSignatureWithSession**](docs/SignaturesApi.md#performSignatureWithSession) | **POST** /{organization-id}/signatures/{signature-id}/session-perform | Perform a Signature with session
*TokensApi* | [**createToken**](docs/TokensApi.md#createToken) | **POST** /{organization-id}/tokens | Create an application token
*TokensApi* | [**deleteToken**](docs/TokensApi.md#deleteToken) | **DELETE** /{organization-id}/tokens/{token-id} | Delete a token of the organization
*TokensApi* | [**getToken**](docs/TokensApi.md#getToken) | **GET** /{organization-id}/tokens/{token-id} | Get information about a token
*TokensApi* | [**listTokens**](docs/TokensApi.md#listTokens) | **GET** /{organization-id}/tokens | Enumerate the tokens of an organization
*TokensApi* | [**listUserTokens**](docs/TokensApi.md#listUserTokens) | **GET** /{organization-id}/users/{user-id}/tokens | Enumerate the tokens of an user
*TokensApi* | [**updateToken**](docs/TokensApi.md#updateToken) | **PUT** /{organization-id}/tokens/{token-id} | Update the properties of a token
*UsersApi* | [**createUser**](docs/UsersApi.md#createUser) | **POST** /{organization-id}/users | Create a user of the organization
*UsersApi* | [**getUser**](docs/UsersApi.md#getUser) | **GET** /{organization-id}/users/{user-id} | Get information about an user
*UsersApi* | [**listUsers**](docs/UsersApi.md#listUsers) | **GET** /{organization-id}/users | Enumerate the users of an organization
*UsersApi* | [**updateUser**](docs/UsersApi.md#updateUser) | **PUT** /{organization-id}/users/{user-id} | Edit one or more user properties
## Documentation for Models
 - [AutomaticSignature](docs/AutomaticSignature.md)
 - [CreateIdentitybyToken](docs/CreateIdentitybyToken.md)
 - [CreateSignatureTransaction](docs/CreateSignatureTransaction.md)
 - [CreateToken](docs/CreateToken.md)
 - [CreateTokenHttpOptions](docs/CreateTokenHttpOptions.md)
 - [CreateTokenWebhooks](docs/CreateTokenWebhooks.md)
 - [CreateUser](docs/CreateUser.md)
 - [Document](docs/Document.md)
 - [Document1](docs/Document1.md)
 - [Identity](docs/Identity.md)
 - [IdentityActions](docs/IdentityActions.md)
 - [IdentityAssociation](docs/IdentityAssociation.md)
 - [IdentityEnroll](docs/IdentityEnroll.md)
 - [IdentityEnrollActions](docs/IdentityEnrollActions.md)
 - [IdentityRequest](docs/IdentityRequest.md)
 - [InlineObject](docs/InlineObject.md)
 - [InlineObject1](docs/InlineObject1.md)
 - [InlineObject2](docs/InlineObject2.md)
 - [InlineObject3](docs/InlineObject3.md)
 - [InlineObject4](docs/InlineObject4.md)
 - [InlineResponse200](docs/InlineResponse200.md)
 - [InlineResponse2001](docs/InlineResponse2001.md)
 - [InlineResponse20010](docs/InlineResponse20010.md)
 - [InlineResponse20010Data](docs/InlineResponse20010Data.md)
 - [InlineResponse20011](docs/InlineResponse20011.md)
 - [InlineResponse20012](docs/InlineResponse20012.md)
 - [InlineResponse2002](docs/InlineResponse2002.md)
 - [InlineResponse2003](docs/InlineResponse2003.md)
 - [InlineResponse2004](docs/InlineResponse2004.md)
 - [InlineResponse2005](docs/InlineResponse2005.md)
 - [InlineResponse2006](docs/InlineResponse2006.md)
 - [InlineResponse2007](docs/InlineResponse2007.md)
 - [InlineResponse2007Meta](docs/InlineResponse2007Meta.md)
 - [InlineResponse2008](docs/InlineResponse2008.md)
 - [InlineResponse2009](docs/InlineResponse2009.md)
 - [InlineResponse201](docs/InlineResponse201.md)
 - [InlineResponse2011](docs/InlineResponse2011.md)
 - [InlineResponse2012](docs/InlineResponse2012.md)
 - [InlineResponse2013](docs/InlineResponse2013.md)
 - [InlineResponse2014](docs/InlineResponse2014.md)
 - [InlineResponse2015](docs/InlineResponse2015.md)
 - [InlineResponse201Data](docs/InlineResponse201Data.md)
 - [InlineResponse401](docs/InlineResponse401.md)
 - [InlineResponse403](docs/InlineResponse403.md)
 - [InlineResponse404](docs/InlineResponse404.md)
 - [MetaDataError](docs/MetaDataError.md)
 - [MetaDataSuccess](docs/MetaDataSuccess.md)
 - [Organization](docs/Organization.md)
 - [OrganizationSettings](docs/OrganizationSettings.md)
 - [PaginationData](docs/PaginationData.md)
 - [SMS](docs/SMS.md)
 - [Signature](docs/Signature.md)
 - [SignatureDST](docs/SignatureDST.md)
 - [SignatureDSTWhere](docs/SignatureDSTWhere.md)
 - [SignatureImplementationResponse](docs/SignatureImplementationResponse.md)
 - [SignatureImplementationResponseChannel](docs/SignatureImplementationResponseChannel.md)
 - [SignatureTransaction](docs/SignatureTransaction.md)
 - [SignatureWhere](docs/SignatureWhere.md)
 - [Token](docs/Token.md)
 - [UpdateOrganization](docs/UpdateOrganization.md)
 - [UpdateToken](docs/UpdateToken.md)
 - [UpdateUser](docs/UpdateUser.md)
 - [User](docs/User.md)
## Documentation for Authorization
Authentication schemes defined for the API:
### ApiKeyAuth
- **Type**: API key
- **API key parameter name**: Authorization
- **Location**: HTTP header
## Recommendation
It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.
## Author
smartcloud@bit4id.com
