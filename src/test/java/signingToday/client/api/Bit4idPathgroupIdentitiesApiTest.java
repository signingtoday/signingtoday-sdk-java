/*
 * Signing Today API
 * *Signing Today* enables seamless integration of digital signatures into any website by the use of easy requests to our API. This is the smart way of adding digital signature support with a great user experience.   *Signing Today APIs* use HTTP methods and are RESTful based, moreover they are protected by a *server to server authentication* standard by the use of tokens.   *Signing Today APIs* can be used in these environments:   | Environment | Description | Endpoint | | ----------- | ----------- | -------- | | Sandbox     | Test environment | `https://sandbox.signingtoday.com` | | Live        | Production environment | `https://api.signingtoday.com` |   For every single request to Signing Today has to be defined the following *HTTP* header: - `Authorization`, which contains the authentication token.  If the request has a body than another *HTTP* header is requested: - `Content-Type`, with `application/json` value.   Follows an example of usage to enumerate all the user of *my-org* organization.  **Example**  ```json $ curl https://sandbox.signingtoday.com/api/v1/my-org/users \\     -H 'Authorization: Token <access-token>' ```  ## HTTP methods used  APIs use the right HTTP verb in every situation.  | Method   | Description                    | | -------- | ------------------------------ | | `GET`    | Request data from a resource   | | `POST`   | Send data to create a resource | | `PUT`    | Update a resource              | | `PATCH`  | Partially update a resource    | | `DELETE` | Delete a resourse              |   ## Response definition  All the response are in JSON format. As response to a request of all users of an organization you will have a result like this:  ```json {     \"pagination\": {       \"count\": 75,       \"previous\": \"https://sandbox.signingtoday.com/api/v1/my-org/users?page=1\",       \"next\": \"https://sandbox.signingtoday.com/api/v1/my-org/users?page=3\",       \"pages\": 8,       \"page\": 2     },     \"meta\": {       \"code\": 200     },     \"data\": [       {         \"id\": \"jdo\",         \"status\": \"enabled\",         \"type\": \"Basic user account\",         \"email\": johndoe@dummyemail.com,         \"first_name\": \"John\",         \"last_name\": \"Doe\",         \"wallet\": [],         \"created_by\": \"system\",         \"owner\": false,         \"automatic\": false,         \"rao\": false       },       ...     ]   } ```  The JSON of the response is made of three parts: - Pagination - Meta - Data  ### Pagination  *Pagination* object allows to split the response into parts and then to rebuild it sequentially by the use of `next` and `previous` parameters, by which you get previous and following blocks. The *Pagination* is present only if the response is a list of objects.  The general structure of *Pagination* object is the following:  ```json {     \"pagination\": {       \"count\": 75,       \"previous\": \"https://sandbox.signingtoday.com/api/v1/my-org/users?page=1\",       \"next\": \"https://sandbox.signingtoday.com/api/v1/my-org/users?page=3\",       \"pages\": 8,       \"page\": 2     },     ...   } ```  ### Meta  *Meta* object is used to enrich the information about the response. In the previous example, a successful case of response, *Meta* will have value `status: 2XX`. In case of unsuccessful response, *Meta* will have further information, as follows:  ```json {     \"meta\": {       \"code\": <HTTP STATUS CODE>,       \"error_type\": <STATUS CODE DESCRIPTION>,       \"error_message\": <ERROR DESCRIPTION>     }   } ```  ### Data  *Data* object outputs as object or list of them. Contains the expected data as requested to the API.  ## Search filters  Search filters of the API have the following structure:  `where_ATTRIBUTENAME`=`VALUE`  In this way you make a case-sensitive search of *VALUE*. You can extend it through the Django lookup, obtaining more specific filters. For example:  `where_ATTRIBUTENAME__LOOKUP`=`VALUE`  where *LOOKUP* can be replaced with `icontains` to have a partial insensitive research, where  `where_first_name__icontains`=`CHa`  matches with every user that have the *cha* string in their name, with no differences between capital and lower cases.  [Here](https://docs.djangoproject.com/en/1.11/ref/models/querysets/#field-lookups) the list of the lookups.  ## Webhooks  Signing Today supports webhooks for the update of DSTs and identities status. You can choose if to use or not webhooks and if you want to receive updates about DSTs and/or identities. You can configurate it on application token level, in the *webhook* field, as follows:  ```json \"webhooks\": {   \"dst\": \"URL\",   \"identity\": \"URL\"   } ```  ### DSTs status update  DSTs send the following status updates: - **DST_STATUS_CHANGED**: whenever the DST changes its status - **SIGNATURE_STATUS_CHANGED**: whenever one of the signatures changes its status  #### DST_STATUS_CHANGED  Sends the following information:  ```json {     \"message\": \"DST_STATUS_CHANGED\",     \"data\": {       \"status\": \"<DST_STATUS>\",       \"dst\": \"<DST_ID>\",       \"reason\": \"<DST_REASON>\"     }   } ```  #### SIGNATURE_STATUS_CHANGED  Sends the following information:  ```json {     \"message\": \"SIGNATURE_STATUS_CHANGED\",     \"data\": {       \"status\": \"<SIGNATURE_STATUS>\",       \"group\": <MEMBERSHIP_GROUP_INDEX>,       \"dst\": {         \"id\": \"<DST_ID>\",         \"title\": \"<DST_TITLE>\"       },       \"signature\": \"<SIGNATURE_ID>\",       \"signer\": \"<SIGNER_USERNAME>\",       \"position\": \"<SIGNATURE_POSITION>\",       \"document\": {         \"display_name\": \"<DOCUMENT_TITLE>\",         \"id\": \"<DOCUMENT_ID>\",         \"order\": <DOCUMENT_INDEX>       },       \"automatic\": <DECLARES_IF_THE_SIGNER_IS_AUTOMATIC>,       \"page\": \"<SIGNATURE_PAGE>\"     }   } ```  ### Identities status update  Identities send the following status updates: - **IDENTITY_REQUEST_ENROLLED**: whenever an identity request is activated  #### IDENTITY_REQUEST_ENROLLED  Sends the following information:  ```json {     \"message\": \"IDENTITY_REQUEST_ENROLLED\",     \"data\": {       \"status\": \"<REQUEST_STATUS>\",       \"request\": \"<REQUEST_ID>\",       \"user\": \"<APPLICANT_USERNAME>\"     }   } ```  ### Urlback  Sometimes may be necessary to make a redirect after an user, from the signature tray, has completed his operations or activated a certificate.  If set, redirects could happen in 3 cases: - after a signature or decline - after a DST has been signed by all the signers or canceled - after the activation of a certificate  In the first two cases the urlback returns the following information through a data form: - **dst-id**: id of the DST - **dst-url**: signature_ticket of the signature - **dst-status**: current status of the DST - **dst-signature-id**: id of the signature - **dst-signature-status**: current status of the signature - **user**: username of the signer - **decline-reason**: in case of a refused DST contains the reason of the decline  In the last case the urlback returns the following information through a data form: - **user**: username of the user activated the certificate - **identity-provider**: the provider has been used to issue the certificate - **identity-request-id**: id of the enrollment request - **identity-id**: id of the new identity - **identity-label**: the label assigned to the identity - **identity-certificate**: public key of the certificate   
 *
 * The version of the OpenAPI document: 1.5.0
 * Contact: smartcloud@bit4id.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package signingToday.client.api;

import signingToday.client.ApiException;
import signingToday.client.model.CreateIdentitybyToken;
import signingToday.client.model.Id;
import signingToday.client.model.IdentityAssociation;
import signingToday.client.model.IdentityRequest;
import signingToday.client.model.InlineObject;
import signingToday.client.model.InlineObject1;
import signingToday.client.model.InlineResponse2002;
import signingToday.client.model.InlineResponse2003;
import signingToday.client.model.InlineResponse2005;
import signingToday.client.model.InlineResponse2006;
import signingToday.client.model.InlineResponse2007;
import signingToday.client.model.InlineResponse2011;
import signingToday.client.model.InlineResponse2012;
import signingToday.client.model.InlineResponse401;
import signingToday.client.model.InlineResponse403;
import signingToday.client.model.InlineResponse404;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for Bit4idPathgroupIdentitiesApi
 */
@Ignore
public class Bit4idPathgroupIdentitiesApiTest {

    private final Bit4idPathgroupIdentitiesApi api = new Bit4idPathgroupIdentitiesApi();

    
    /**
     * Associate an appearance to an identity
     *
     * Associate a signature appearance to an already existing identity through an url to an image. This appearance will be displayed on the document after the signature. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void associateAppearanceTest() throws ApiException {
        String organizationId = null;
        Id identityId = null;
        InlineObject inlineObject = null;
        InlineResponse2011 response = api.associateAppearance(organizationId, identityId, inlineObject);

        // TODO: test validations
    }
    
    /**
     * Associate to an user an already existing identity
     *
     * Associate to an user of the organization an already existing identity of a provider. The _provider_data_ field is an object and is different for each provider. The minimum set of information to provide as provider_data is the following:   - **aruba**     - _auth_domain_ : string     - _username_ : string     - _password_ : string   - **aruba-auto**     - _auth_domain_ : string     - _username_ : string     - _password_ : string   - **infocert**     - _username_ : string     - _password_ : string   - **namirial**     - _id_titolare_ : string     - _id_otp_ : string     - _username_ : string     - _password_ : string 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void associateIdentityTest() throws ApiException {
        String organizationId = null;
        Id userId = null;
        IdentityAssociation identityAssociation = null;
        InlineResponse2011 response = api.associateIdentity(organizationId, userId, identityAssociation);

        // TODO: test validations
    }
    
    /**
     * Create an identity from token
     *
     * This API allows to create an identity from a token. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createTokenFromIdentityTest() throws ApiException {
        String organizationId = null;
        CreateIdentitybyToken createIdentitybyToken = null;
        InlineResponse2012 response = api.createTokenFromIdentity(organizationId, createIdentitybyToken);

        // TODO: test validations
    }
    
    /**
     * Delete the appearance of an identity
     *
     * This API allows to delete the appearance associated to an identity. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteAppearanceTest() throws ApiException {
        String organizationId = null;
        Id identityId = null;
        InlineResponse2011 response = api.deleteAppearance(organizationId, identityId);

        // TODO: test validations
    }
    
    /**
     * Delete an enrollment request
     *
     * This API allows to delete an enrollment request. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteEnrollmentRequestTest() throws ApiException {
        String organizationId = null;
        Id enrollmentId = null;
        InlineResponse2012 response = api.deleteEnrollmentRequest(organizationId, enrollmentId);

        // TODO: test validations
    }
    
    /**
     * Delete an identity
     *
     * This API allows to delete an identity of an user. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteIdentityTest() throws ApiException {
        String organizationId = null;
        Id identityId = null;
        InlineResponse2006 response = api.deleteIdentity(organizationId, identityId);

        // TODO: test validations
    }
    
    /**
     * Get information about an enrollment request
     *
     * This API allows to get information about an enrollment request. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEnrollmentRequestTest() throws ApiException {
        String organizationId = null;
        Id enrollmentId = null;
        InlineResponse2007 response = api.getEnrollmentRequest(organizationId, enrollmentId);

        // TODO: test validations
    }
    
    /**
     * Get information about an identity
     *
     * This API allows to get all the information of an identity. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getIdentityTest() throws ApiException {
        String organizationId = null;
        Id identityId = null;
        String whereOrder = null;
        InlineResponse2005 response = api.getIdentity(organizationId, identityId, whereOrder);

        // TODO: test validations
    }
    
    /**
     * Enumerate the enrollment requests of an organization
     *
     * This API allows to enumerate the enrollment requests of an organization. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listEnrollmentRequestsTest() throws ApiException {
        String organizationId = null;
        String whereProvider = null;
        String whereUser = null;
        String whereFirstName = null;
        String whereLastName = null;
        String whereRegisteredBy = null;
        String whereFiscalCode = null;
        Integer page = null;
        Integer count = null;
        String whereOrder = null;
        InlineResponse2003 response = api.listEnrollmentRequests(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder);

        // TODO: test validations
    }
    
    /**
     * Enumerate the identities of an organization
     *
     * This API allows to enumerate all the users of an organization. It is possible to filter the data using the supported _django lookups_. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listIdentitiesTest() throws ApiException {
        String organizationId = null;
        String whereProvider = null;
        String whereUser = null;
        String whereFirstName = null;
        String whereLastName = null;
        String whereRegisteredBy = null;
        String whereFiscalCode = null;
        Integer page = null;
        Integer count = null;
        String whereOrder = null;
        InlineResponse2002 response = api.listIdentities(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder);

        // TODO: test validations
    }
    
    /**
     * List the enrollments of an user
     *
     * This API allows to list all the enrollments of an user. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listUserEnrollmentsTest() throws ApiException {
        String organizationId = null;
        Id userId = null;
        Integer page = null;
        Integer count = null;
        String whereOrder = null;
        InlineResponse2003 response = api.listUserEnrollments(organizationId, userId, page, count, whereOrder);

        // TODO: test validations
    }
    
    /**
     * Enumerate the identities of an user
     *
     * This API allows to enumerate all the identities of an user, which are located in its wallet. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listUserIdentitiesTest() throws ApiException {
        String organizationId = null;
        Id userId = null;
        Integer page = null;
        Integer count = null;
        String whereOrder = null;
        InlineResponse2002 response = api.listUserIdentities(organizationId, userId, page, count, whereOrder);

        // TODO: test validations
    }
    
    /**
     * Renew an Identity
     *
     * This API allows to renew an Identity of a user. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void renewIdentityTest() throws ApiException {
        String organizationId = null;
        Id enrollmentId = null;
        InlineObject1 inlineObject1 = null;
        InlineResponse2007 response = api.renewIdentity(organizationId, enrollmentId, inlineObject1);

        // TODO: test validations
    }
    
    /**
     * Submit an enrollment request
     *
     * This API allows to submit an enrollment request. The user of the request will be created if it does not exists already. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void requestEnrollmentTest() throws ApiException {
        String organizationId = null;
        IdentityRequest identityRequest = null;
        InlineResponse2007 response = api.requestEnrollment(organizationId, identityRequest);

        // TODO: test validations
    }
    
}
