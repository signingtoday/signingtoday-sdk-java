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
import signingToday.client.model.CreateSignatureTransaction;
import java.io.File;
import signingToday.client.model.Id;
import signingToday.client.model.InlineObject2;
import signingToday.client.model.InlineResponse20010;
import signingToday.client.model.InlineResponse2008;
import signingToday.client.model.InlineResponse2009;
import signingToday.client.model.InlineResponse2013;
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
 * API tests for Bit4idPathgroupSignatureTransactionsApi
 */
@Ignore
public class Bit4idPathgroupSignatureTransactionsApiTest {

    private final Bit4idPathgroupSignatureTransactionsApi api = new Bit4idPathgroupSignatureTransactionsApi();

    
    /**
     * Mark a DST as canceled
     *
     * This API allows to mark a Digital Signature Transaction as canceled providing a reason. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void cancelDSTTest() throws ApiException {
        String organizationId = null;
        Id dstId = null;
        InlineObject2 inlineObject2 = null;
        InlineResponse2013 response = api.cancelDST(organizationId, dstId, inlineObject2);

        // TODO: test validations
    }
    
    /**
     * Create a Digital Signature Transaction
     *
     * This API allows to create a Digital Signature Transaction. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createDSTTest() throws ApiException {
        String organizationId = null;
        CreateSignatureTransaction createSignatureTransaction = null;
        InlineResponse2013 response = api.createDST(organizationId, createSignatureTransaction);

        // TODO: test validations
    }
    
    /**
     * Delete a Digital Signature Transaction
     *
     * This API allows to delete a Digital Signature Transaction. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteDSTTest() throws ApiException {
        String organizationId = null;
        Id dstId = null;
        InlineResponse2009 response = api.deleteDST(organizationId, dstId);

        // TODO: test validations
    }
    
    /**
     * Delete the resources of a DST
     *
     * This API allows to delete the resources of a Digital Signature Transaction. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteDSTResourcesTest() throws ApiException {
        String organizationId = null;
        Id dstId = null;
        InlineResponse20010 response = api.deleteDSTResources(organizationId, dstId);

        // TODO: test validations
    }
    
    /**
     * Get information about a DST
     *
     * This API allows to get information about a Digital Signature Transaction. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getDSTTest() throws ApiException {
        String organizationId = null;
        Id dstId = null;
        InlineResponse2013 response = api.getDST(organizationId, dstId);

        // TODO: test validations
    }
    
    /**
     * Download a document from a DST
     *
     * This API allows to download a document from a digital signature transaction. The document can be downloaded before or after one or every signature have been performed. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getDocumentTest() throws ApiException {
        String organizationId = null;
        Id documentId = null;
        File response = api.getDocument(organizationId, documentId);

        // TODO: test validations
    }
    
    /**
     * List the DSTs of an organization
     *
     * This API allows to list the Digital Signature Transactions of an organization. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listDSTsTest() throws ApiException {
        String organizationId = null;
        String whereSigner = null;
        String whereStatus = null;
        String whereTitle = null;
        String whereCreatedBy = null;
        String whereCreated = null;
        String whereSignatureStatus = null;
        String whereDocumentName = null;
        String whereReason = null;
        String whereSignatureName = null;
        String whereSignerGroup = null;
        Integer page = null;
        Integer count = null;
        String whereOrder = null;
        InlineResponse2008 response = api.listDSTs(organizationId, whereSigner, whereStatus, whereTitle, whereCreatedBy, whereCreated, whereSignatureStatus, whereDocumentName, whereReason, whereSignatureName, whereSignerGroup, page, count, whereOrder);

        // TODO: test validations
    }
    
}
