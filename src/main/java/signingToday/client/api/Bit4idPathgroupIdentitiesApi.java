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

import signingToday.client.ApiCallback;
import signingToday.client.ApiClient;
import signingToday.client.ApiException;
import signingToday.client.ApiResponse;
import signingToday.client.Configuration;
import signingToday.client.Pair;
import signingToday.client.ProgressRequestBody;
import signingToday.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bit4idPathgroupIdentitiesApi {
    private ApiClient localVarApiClient;

    public Bit4idPathgroupIdentitiesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public Bit4idPathgroupIdentitiesApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for associateAppearance
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param inlineObject  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call associateAppearanceCall(String organizationId, Id identityId, InlineObject inlineObject, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = inlineObject;

        // create path and map variables
        String localVarPath = "/{organization-id}/identities/{identity-id}/appearance"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "identity-id" + "\\}", localVarApiClient.escapeString(identityId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call associateAppearanceValidateBeforeCall(String organizationId, Id identityId, InlineObject inlineObject, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling associateAppearance(Async)");
        }
        
        // verify the required parameter 'identityId' is set
        if (identityId == null) {
            throw new ApiException("Missing the required parameter 'identityId' when calling associateAppearance(Async)");
        }
        
        // verify the required parameter 'inlineObject' is set
        if (inlineObject == null) {
            throw new ApiException("Missing the required parameter 'inlineObject' when calling associateAppearance(Async)");
        }
        

        okhttp3.Call localVarCall = associateAppearanceCall(organizationId, identityId, inlineObject, _callback);
        return localVarCall;

    }

    /**
     * Associate an appearance to an identity
     * Associate a signature appearance to an already existing identity through an url to an image. This appearance will be displayed on the document after the signature. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param inlineObject  (required)
     * @return InlineResponse2011
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2011 associateAppearance(String organizationId, Id identityId, InlineObject inlineObject) throws ApiException {
        ApiResponse<InlineResponse2011> localVarResp = associateAppearanceWithHttpInfo(organizationId, identityId, inlineObject);
        return localVarResp.getData();
    }

    /**
     * Associate an appearance to an identity
     * Associate a signature appearance to an already existing identity through an url to an image. This appearance will be displayed on the document after the signature. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param inlineObject  (required)
     * @return ApiResponse&lt;InlineResponse2011&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2011> associateAppearanceWithHttpInfo(String organizationId, Id identityId, InlineObject inlineObject) throws ApiException {
        okhttp3.Call localVarCall = associateAppearanceValidateBeforeCall(organizationId, identityId, inlineObject, null);
        Type localVarReturnType = new TypeToken<InlineResponse2011>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Associate an appearance to an identity (asynchronously)
     * Associate a signature appearance to an already existing identity through an url to an image. This appearance will be displayed on the document after the signature. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param inlineObject  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call associateAppearanceAsync(String organizationId, Id identityId, InlineObject inlineObject, final ApiCallback<InlineResponse2011> _callback) throws ApiException {

        okhttp3.Call localVarCall = associateAppearanceValidateBeforeCall(organizationId, identityId, inlineObject, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2011>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for associateIdentity
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param identityAssociation Provider data to associate (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call associateIdentityCall(String organizationId, Id userId, IdentityAssociation identityAssociation, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = identityAssociation;

        // create path and map variables
        String localVarPath = "/{organization-id}/users/{user-id}/wallet"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "user-id" + "\\}", localVarApiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call associateIdentityValidateBeforeCall(String organizationId, Id userId, IdentityAssociation identityAssociation, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling associateIdentity(Async)");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling associateIdentity(Async)");
        }
        
        // verify the required parameter 'identityAssociation' is set
        if (identityAssociation == null) {
            throw new ApiException("Missing the required parameter 'identityAssociation' when calling associateIdentity(Async)");
        }
        

        okhttp3.Call localVarCall = associateIdentityCall(organizationId, userId, identityAssociation, _callback);
        return localVarCall;

    }

    /**
     * Associate to an user an already existing identity
     * Associate to an user of the organization an already existing identity of a provider. The _provider_data_ field is an object and is different for each provider. The minimum set of information to provide as provider_data is the following:   - **aruba**     - _auth_domain_ : string     - _username_ : string     - _password_ : string   - **aruba-auto**     - _auth_domain_ : string     - _username_ : string     - _password_ : string   - **infocert**     - _username_ : string     - _password_ : string   - **namirial**     - _id_titolare_ : string     - _id_otp_ : string     - _username_ : string     - _password_ : string 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param identityAssociation Provider data to associate (required)
     * @return InlineResponse2011
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2011 associateIdentity(String organizationId, Id userId, IdentityAssociation identityAssociation) throws ApiException {
        ApiResponse<InlineResponse2011> localVarResp = associateIdentityWithHttpInfo(organizationId, userId, identityAssociation);
        return localVarResp.getData();
    }

    /**
     * Associate to an user an already existing identity
     * Associate to an user of the organization an already existing identity of a provider. The _provider_data_ field is an object and is different for each provider. The minimum set of information to provide as provider_data is the following:   - **aruba**     - _auth_domain_ : string     - _username_ : string     - _password_ : string   - **aruba-auto**     - _auth_domain_ : string     - _username_ : string     - _password_ : string   - **infocert**     - _username_ : string     - _password_ : string   - **namirial**     - _id_titolare_ : string     - _id_otp_ : string     - _username_ : string     - _password_ : string 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param identityAssociation Provider data to associate (required)
     * @return ApiResponse&lt;InlineResponse2011&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2011> associateIdentityWithHttpInfo(String organizationId, Id userId, IdentityAssociation identityAssociation) throws ApiException {
        okhttp3.Call localVarCall = associateIdentityValidateBeforeCall(organizationId, userId, identityAssociation, null);
        Type localVarReturnType = new TypeToken<InlineResponse2011>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Associate to an user an already existing identity (asynchronously)
     * Associate to an user of the organization an already existing identity of a provider. The _provider_data_ field is an object and is different for each provider. The minimum set of information to provide as provider_data is the following:   - **aruba**     - _auth_domain_ : string     - _username_ : string     - _password_ : string   - **aruba-auto**     - _auth_domain_ : string     - _username_ : string     - _password_ : string   - **infocert**     - _username_ : string     - _password_ : string   - **namirial**     - _id_titolare_ : string     - _id_otp_ : string     - _username_ : string     - _password_ : string 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param identityAssociation Provider data to associate (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call associateIdentityAsync(String organizationId, Id userId, IdentityAssociation identityAssociation, final ApiCallback<InlineResponse2011> _callback) throws ApiException {

        okhttp3.Call localVarCall = associateIdentityValidateBeforeCall(organizationId, userId, identityAssociation, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2011>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for createTokenFromIdentity
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createIdentitybyToken Body of the request to create an identity from a token (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createTokenFromIdentityCall(String organizationId, CreateIdentitybyToken createIdentitybyToken, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = createIdentitybyToken;

        // create path and map variables
        String localVarPath = "/{organization-id}/identities/create/token"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createTokenFromIdentityValidateBeforeCall(String organizationId, CreateIdentitybyToken createIdentitybyToken, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling createTokenFromIdentity(Async)");
        }
        
        // verify the required parameter 'createIdentitybyToken' is set
        if (createIdentitybyToken == null) {
            throw new ApiException("Missing the required parameter 'createIdentitybyToken' when calling createTokenFromIdentity(Async)");
        }
        

        okhttp3.Call localVarCall = createTokenFromIdentityCall(organizationId, createIdentitybyToken, _callback);
        return localVarCall;

    }

    /**
     * Create an identity from token
     * This API allows to create an identity from a token. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createIdentitybyToken Body of the request to create an identity from a token (required)
     * @return InlineResponse2012
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2012 createTokenFromIdentity(String organizationId, CreateIdentitybyToken createIdentitybyToken) throws ApiException {
        ApiResponse<InlineResponse2012> localVarResp = createTokenFromIdentityWithHttpInfo(organizationId, createIdentitybyToken);
        return localVarResp.getData();
    }

    /**
     * Create an identity from token
     * This API allows to create an identity from a token. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createIdentitybyToken Body of the request to create an identity from a token (required)
     * @return ApiResponse&lt;InlineResponse2012&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2012> createTokenFromIdentityWithHttpInfo(String organizationId, CreateIdentitybyToken createIdentitybyToken) throws ApiException {
        okhttp3.Call localVarCall = createTokenFromIdentityValidateBeforeCall(organizationId, createIdentitybyToken, null);
        Type localVarReturnType = new TypeToken<InlineResponse2012>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create an identity from token (asynchronously)
     * This API allows to create an identity from a token. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createIdentitybyToken Body of the request to create an identity from a token (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createTokenFromIdentityAsync(String organizationId, CreateIdentitybyToken createIdentitybyToken, final ApiCallback<InlineResponse2012> _callback) throws ApiException {

        okhttp3.Call localVarCall = createTokenFromIdentityValidateBeforeCall(organizationId, createIdentitybyToken, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2012>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteAppearance
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteAppearanceCall(String organizationId, Id identityId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/identities/{identity-id}/appearance"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "identity-id" + "\\}", localVarApiClient.escapeString(identityId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteAppearanceValidateBeforeCall(String organizationId, Id identityId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling deleteAppearance(Async)");
        }
        
        // verify the required parameter 'identityId' is set
        if (identityId == null) {
            throw new ApiException("Missing the required parameter 'identityId' when calling deleteAppearance(Async)");
        }
        

        okhttp3.Call localVarCall = deleteAppearanceCall(organizationId, identityId, _callback);
        return localVarCall;

    }

    /**
     * Delete the appearance of an identity
     * This API allows to delete the appearance associated to an identity. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @return InlineResponse2011
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2011 deleteAppearance(String organizationId, Id identityId) throws ApiException {
        ApiResponse<InlineResponse2011> localVarResp = deleteAppearanceWithHttpInfo(organizationId, identityId);
        return localVarResp.getData();
    }

    /**
     * Delete the appearance of an identity
     * This API allows to delete the appearance associated to an identity. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @return ApiResponse&lt;InlineResponse2011&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2011> deleteAppearanceWithHttpInfo(String organizationId, Id identityId) throws ApiException {
        okhttp3.Call localVarCall = deleteAppearanceValidateBeforeCall(organizationId, identityId, null);
        Type localVarReturnType = new TypeToken<InlineResponse2011>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Delete the appearance of an identity (asynchronously)
     * This API allows to delete the appearance associated to an identity. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteAppearanceAsync(String organizationId, Id identityId, final ApiCallback<InlineResponse2011> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteAppearanceValidateBeforeCall(organizationId, identityId, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2011>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteEnrollmentRequest
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param enrollmentId The **enrollment-id** is the uuid code that identifies a specific enrollment request  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteEnrollmentRequestCall(String organizationId, Id enrollmentId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/identity-requests/{enrollment-id}"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "enrollment-id" + "\\}", localVarApiClient.escapeString(enrollmentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteEnrollmentRequestValidateBeforeCall(String organizationId, Id enrollmentId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling deleteEnrollmentRequest(Async)");
        }
        
        // verify the required parameter 'enrollmentId' is set
        if (enrollmentId == null) {
            throw new ApiException("Missing the required parameter 'enrollmentId' when calling deleteEnrollmentRequest(Async)");
        }
        

        okhttp3.Call localVarCall = deleteEnrollmentRequestCall(organizationId, enrollmentId, _callback);
        return localVarCall;

    }

    /**
     * Delete an enrollment request
     * This API allows to delete an enrollment request. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param enrollmentId The **enrollment-id** is the uuid code that identifies a specific enrollment request  (required)
     * @return InlineResponse2012
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2012 deleteEnrollmentRequest(String organizationId, Id enrollmentId) throws ApiException {
        ApiResponse<InlineResponse2012> localVarResp = deleteEnrollmentRequestWithHttpInfo(organizationId, enrollmentId);
        return localVarResp.getData();
    }

    /**
     * Delete an enrollment request
     * This API allows to delete an enrollment request. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param enrollmentId The **enrollment-id** is the uuid code that identifies a specific enrollment request  (required)
     * @return ApiResponse&lt;InlineResponse2012&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2012> deleteEnrollmentRequestWithHttpInfo(String organizationId, Id enrollmentId) throws ApiException {
        okhttp3.Call localVarCall = deleteEnrollmentRequestValidateBeforeCall(organizationId, enrollmentId, null);
        Type localVarReturnType = new TypeToken<InlineResponse2012>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Delete an enrollment request (asynchronously)
     * This API allows to delete an enrollment request. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param enrollmentId The **enrollment-id** is the uuid code that identifies a specific enrollment request  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteEnrollmentRequestAsync(String organizationId, Id enrollmentId, final ApiCallback<InlineResponse2012> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteEnrollmentRequestValidateBeforeCall(organizationId, enrollmentId, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2012>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteIdentity
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteIdentityCall(String organizationId, Id identityId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/identities/{identity-id}"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "identity-id" + "\\}", localVarApiClient.escapeString(identityId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteIdentityValidateBeforeCall(String organizationId, Id identityId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling deleteIdentity(Async)");
        }
        
        // verify the required parameter 'identityId' is set
        if (identityId == null) {
            throw new ApiException("Missing the required parameter 'identityId' when calling deleteIdentity(Async)");
        }
        

        okhttp3.Call localVarCall = deleteIdentityCall(organizationId, identityId, _callback);
        return localVarCall;

    }

    /**
     * Delete an identity
     * This API allows to delete an identity of an user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @return InlineResponse2006
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2006 deleteIdentity(String organizationId, Id identityId) throws ApiException {
        ApiResponse<InlineResponse2006> localVarResp = deleteIdentityWithHttpInfo(organizationId, identityId);
        return localVarResp.getData();
    }

    /**
     * Delete an identity
     * This API allows to delete an identity of an user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @return ApiResponse&lt;InlineResponse2006&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2006> deleteIdentityWithHttpInfo(String organizationId, Id identityId) throws ApiException {
        okhttp3.Call localVarCall = deleteIdentityValidateBeforeCall(organizationId, identityId, null);
        Type localVarReturnType = new TypeToken<InlineResponse2006>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Delete an identity (asynchronously)
     * This API allows to delete an identity of an user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteIdentityAsync(String organizationId, Id identityId, final ApiCallback<InlineResponse2006> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteIdentityValidateBeforeCall(organizationId, identityId, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2006>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getEnrollmentRequest
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param enrollmentId The **enrollment-id** is the uuid code that identifies a specific enrollment request  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getEnrollmentRequestCall(String organizationId, Id enrollmentId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/identity-requests/{enrollment-id}"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "enrollment-id" + "\\}", localVarApiClient.escapeString(enrollmentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getEnrollmentRequestValidateBeforeCall(String organizationId, Id enrollmentId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling getEnrollmentRequest(Async)");
        }
        
        // verify the required parameter 'enrollmentId' is set
        if (enrollmentId == null) {
            throw new ApiException("Missing the required parameter 'enrollmentId' when calling getEnrollmentRequest(Async)");
        }
        

        okhttp3.Call localVarCall = getEnrollmentRequestCall(organizationId, enrollmentId, _callback);
        return localVarCall;

    }

    /**
     * Get information about an enrollment request
     * This API allows to get information about an enrollment request. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param enrollmentId The **enrollment-id** is the uuid code that identifies a specific enrollment request  (required)
     * @return InlineResponse2007
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2007 getEnrollmentRequest(String organizationId, Id enrollmentId) throws ApiException {
        ApiResponse<InlineResponse2007> localVarResp = getEnrollmentRequestWithHttpInfo(organizationId, enrollmentId);
        return localVarResp.getData();
    }

    /**
     * Get information about an enrollment request
     * This API allows to get information about an enrollment request. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param enrollmentId The **enrollment-id** is the uuid code that identifies a specific enrollment request  (required)
     * @return ApiResponse&lt;InlineResponse2007&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2007> getEnrollmentRequestWithHttpInfo(String organizationId, Id enrollmentId) throws ApiException {
        okhttp3.Call localVarCall = getEnrollmentRequestValidateBeforeCall(organizationId, enrollmentId, null);
        Type localVarReturnType = new TypeToken<InlineResponse2007>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get information about an enrollment request (asynchronously)
     * This API allows to get information about an enrollment request. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param enrollmentId The **enrollment-id** is the uuid code that identifies a specific enrollment request  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getEnrollmentRequestAsync(String organizationId, Id enrollmentId, final ApiCallback<InlineResponse2007> _callback) throws ApiException {

        okhttp3.Call localVarCall = getEnrollmentRequestValidateBeforeCall(organizationId, enrollmentId, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2007>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getIdentity
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getIdentityCall(String organizationId, Id identityId, String whereOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/identities/{identity-id}"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "identity-id" + "\\}", localVarApiClient.escapeString(identityId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (whereOrder != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_order", whereOrder));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getIdentityValidateBeforeCall(String organizationId, Id identityId, String whereOrder, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling getIdentity(Async)");
        }
        
        // verify the required parameter 'identityId' is set
        if (identityId == null) {
            throw new ApiException("Missing the required parameter 'identityId' when calling getIdentity(Async)");
        }
        

        okhttp3.Call localVarCall = getIdentityCall(organizationId, identityId, whereOrder, _callback);
        return localVarCall;

    }

    /**
     * Get information about an identity
     * This API allows to get all the information of an identity. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return InlineResponse2005
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2005 getIdentity(String organizationId, Id identityId, String whereOrder) throws ApiException {
        ApiResponse<InlineResponse2005> localVarResp = getIdentityWithHttpInfo(organizationId, identityId, whereOrder);
        return localVarResp.getData();
    }

    /**
     * Get information about an identity
     * This API allows to get all the information of an identity. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return ApiResponse&lt;InlineResponse2005&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2005> getIdentityWithHttpInfo(String organizationId, Id identityId, String whereOrder) throws ApiException {
        okhttp3.Call localVarCall = getIdentityValidateBeforeCall(organizationId, identityId, whereOrder, null);
        Type localVarReturnType = new TypeToken<InlineResponse2005>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get information about an identity (asynchronously)
     * This API allows to get all the information of an identity. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getIdentityAsync(String organizationId, Id identityId, String whereOrder, final ApiCallback<InlineResponse2005> _callback) throws ApiException {

        okhttp3.Call localVarCall = getIdentityValidateBeforeCall(organizationId, identityId, whereOrder, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2005>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listEnrollmentRequests
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereProvider Returns the identity requests that have been issued by the specified provider (optional)
     * @param whereUser Returns the identity requests of the specified user, searched by its id (optional)
     * @param whereFirstName Returns the identity requests of the users that have the specified first name (optional)
     * @param whereLastName Returns the identity requests of the users that have the specified last name (optional)
     * @param whereRegisteredBy Returns the identity requests registered by this user (optional)
     * @param whereFiscalCode Returns the identity requests have the specified fiscal code (optional)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listEnrollmentRequestsCall(String organizationId, String whereProvider, String whereUser, String whereFirstName, String whereLastName, String whereRegisteredBy, String whereFiscalCode, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/identity-requests"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (whereProvider != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_provider", whereProvider));
        }

        if (whereUser != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_user", whereUser));
        }

        if (whereFirstName != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_first_name", whereFirstName));
        }

        if (whereLastName != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_last_name", whereLastName));
        }

        if (whereRegisteredBy != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_registered_by", whereRegisteredBy));
        }

        if (whereFiscalCode != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_fiscal_code", whereFiscalCode));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (count != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("count", count));
        }

        if (whereOrder != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_order", whereOrder));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listEnrollmentRequestsValidateBeforeCall(String organizationId, String whereProvider, String whereUser, String whereFirstName, String whereLastName, String whereRegisteredBy, String whereFiscalCode, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling listEnrollmentRequests(Async)");
        }
        

        okhttp3.Call localVarCall = listEnrollmentRequestsCall(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder, _callback);
        return localVarCall;

    }

    /**
     * Enumerate the enrollment requests of an organization
     * This API allows to enumerate the enrollment requests of an organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereProvider Returns the identity requests that have been issued by the specified provider (optional)
     * @param whereUser Returns the identity requests of the specified user, searched by its id (optional)
     * @param whereFirstName Returns the identity requests of the users that have the specified first name (optional)
     * @param whereLastName Returns the identity requests of the users that have the specified last name (optional)
     * @param whereRegisteredBy Returns the identity requests registered by this user (optional)
     * @param whereFiscalCode Returns the identity requests have the specified fiscal code (optional)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return InlineResponse2003
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2003 listEnrollmentRequests(String organizationId, String whereProvider, String whereUser, String whereFirstName, String whereLastName, String whereRegisteredBy, String whereFiscalCode, Integer page, Integer count, String whereOrder) throws ApiException {
        ApiResponse<InlineResponse2003> localVarResp = listEnrollmentRequestsWithHttpInfo(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder);
        return localVarResp.getData();
    }

    /**
     * Enumerate the enrollment requests of an organization
     * This API allows to enumerate the enrollment requests of an organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereProvider Returns the identity requests that have been issued by the specified provider (optional)
     * @param whereUser Returns the identity requests of the specified user, searched by its id (optional)
     * @param whereFirstName Returns the identity requests of the users that have the specified first name (optional)
     * @param whereLastName Returns the identity requests of the users that have the specified last name (optional)
     * @param whereRegisteredBy Returns the identity requests registered by this user (optional)
     * @param whereFiscalCode Returns the identity requests have the specified fiscal code (optional)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return ApiResponse&lt;InlineResponse2003&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2003> listEnrollmentRequestsWithHttpInfo(String organizationId, String whereProvider, String whereUser, String whereFirstName, String whereLastName, String whereRegisteredBy, String whereFiscalCode, Integer page, Integer count, String whereOrder) throws ApiException {
        okhttp3.Call localVarCall = listEnrollmentRequestsValidateBeforeCall(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder, null);
        Type localVarReturnType = new TypeToken<InlineResponse2003>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Enumerate the enrollment requests of an organization (asynchronously)
     * This API allows to enumerate the enrollment requests of an organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereProvider Returns the identity requests that have been issued by the specified provider (optional)
     * @param whereUser Returns the identity requests of the specified user, searched by its id (optional)
     * @param whereFirstName Returns the identity requests of the users that have the specified first name (optional)
     * @param whereLastName Returns the identity requests of the users that have the specified last name (optional)
     * @param whereRegisteredBy Returns the identity requests registered by this user (optional)
     * @param whereFiscalCode Returns the identity requests have the specified fiscal code (optional)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listEnrollmentRequestsAsync(String organizationId, String whereProvider, String whereUser, String whereFirstName, String whereLastName, String whereRegisteredBy, String whereFiscalCode, Integer page, Integer count, String whereOrder, final ApiCallback<InlineResponse2003> _callback) throws ApiException {

        okhttp3.Call localVarCall = listEnrollmentRequestsValidateBeforeCall(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2003>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listIdentities
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereProvider Returns the identities that have been issued by the specified provider (optional)
     * @param whereUser Returns the identities of the specified user, searched by its id (optional)
     * @param whereFirstName Returns the identities of the users that have the specified first name (optional)
     * @param whereLastName Returns the identities of the users that have the specified last name (optional)
     * @param whereRegisteredBy Returns the identities registered by this user (optional)
     * @param whereFiscalCode Returns the identities that have the specified fiscal code (optional)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listIdentitiesCall(String organizationId, String whereProvider, String whereUser, String whereFirstName, String whereLastName, String whereRegisteredBy, String whereFiscalCode, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/identities"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (whereProvider != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_provider", whereProvider));
        }

        if (whereUser != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_user", whereUser));
        }

        if (whereFirstName != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_first_name", whereFirstName));
        }

        if (whereLastName != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_last_name", whereLastName));
        }

        if (whereRegisteredBy != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_registered_by", whereRegisteredBy));
        }

        if (whereFiscalCode != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_fiscal_code", whereFiscalCode));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (count != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("count", count));
        }

        if (whereOrder != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_order", whereOrder));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listIdentitiesValidateBeforeCall(String organizationId, String whereProvider, String whereUser, String whereFirstName, String whereLastName, String whereRegisteredBy, String whereFiscalCode, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling listIdentities(Async)");
        }
        

        okhttp3.Call localVarCall = listIdentitiesCall(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder, _callback);
        return localVarCall;

    }

    /**
     * Enumerate the identities of an organization
     * This API allows to enumerate all the users of an organization. It is possible to filter the data using the supported _django lookups_. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereProvider Returns the identities that have been issued by the specified provider (optional)
     * @param whereUser Returns the identities of the specified user, searched by its id (optional)
     * @param whereFirstName Returns the identities of the users that have the specified first name (optional)
     * @param whereLastName Returns the identities of the users that have the specified last name (optional)
     * @param whereRegisteredBy Returns the identities registered by this user (optional)
     * @param whereFiscalCode Returns the identities that have the specified fiscal code (optional)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return InlineResponse2002
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2002 listIdentities(String organizationId, String whereProvider, String whereUser, String whereFirstName, String whereLastName, String whereRegisteredBy, String whereFiscalCode, Integer page, Integer count, String whereOrder) throws ApiException {
        ApiResponse<InlineResponse2002> localVarResp = listIdentitiesWithHttpInfo(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder);
        return localVarResp.getData();
    }

    /**
     * Enumerate the identities of an organization
     * This API allows to enumerate all the users of an organization. It is possible to filter the data using the supported _django lookups_. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereProvider Returns the identities that have been issued by the specified provider (optional)
     * @param whereUser Returns the identities of the specified user, searched by its id (optional)
     * @param whereFirstName Returns the identities of the users that have the specified first name (optional)
     * @param whereLastName Returns the identities of the users that have the specified last name (optional)
     * @param whereRegisteredBy Returns the identities registered by this user (optional)
     * @param whereFiscalCode Returns the identities that have the specified fiscal code (optional)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return ApiResponse&lt;InlineResponse2002&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2002> listIdentitiesWithHttpInfo(String organizationId, String whereProvider, String whereUser, String whereFirstName, String whereLastName, String whereRegisteredBy, String whereFiscalCode, Integer page, Integer count, String whereOrder) throws ApiException {
        okhttp3.Call localVarCall = listIdentitiesValidateBeforeCall(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder, null);
        Type localVarReturnType = new TypeToken<InlineResponse2002>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Enumerate the identities of an organization (asynchronously)
     * This API allows to enumerate all the users of an organization. It is possible to filter the data using the supported _django lookups_. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereProvider Returns the identities that have been issued by the specified provider (optional)
     * @param whereUser Returns the identities of the specified user, searched by its id (optional)
     * @param whereFirstName Returns the identities of the users that have the specified first name (optional)
     * @param whereLastName Returns the identities of the users that have the specified last name (optional)
     * @param whereRegisteredBy Returns the identities registered by this user (optional)
     * @param whereFiscalCode Returns the identities that have the specified fiscal code (optional)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listIdentitiesAsync(String organizationId, String whereProvider, String whereUser, String whereFirstName, String whereLastName, String whereRegisteredBy, String whereFiscalCode, Integer page, Integer count, String whereOrder, final ApiCallback<InlineResponse2002> _callback) throws ApiException {

        okhttp3.Call localVarCall = listIdentitiesValidateBeforeCall(organizationId, whereProvider, whereUser, whereFirstName, whereLastName, whereRegisteredBy, whereFiscalCode, page, count, whereOrder, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2002>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listUserEnrollments
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listUserEnrollmentsCall(String organizationId, Id userId, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/users/{user-id}/identity-requests"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "user-id" + "\\}", localVarApiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (count != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("count", count));
        }

        if (whereOrder != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_order", whereOrder));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listUserEnrollmentsValidateBeforeCall(String organizationId, Id userId, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling listUserEnrollments(Async)");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling listUserEnrollments(Async)");
        }
        

        okhttp3.Call localVarCall = listUserEnrollmentsCall(organizationId, userId, page, count, whereOrder, _callback);
        return localVarCall;

    }

    /**
     * List the enrollments of an user
     * This API allows to list all the enrollments of an user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return InlineResponse2003
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2003 listUserEnrollments(String organizationId, Id userId, Integer page, Integer count, String whereOrder) throws ApiException {
        ApiResponse<InlineResponse2003> localVarResp = listUserEnrollmentsWithHttpInfo(organizationId, userId, page, count, whereOrder);
        return localVarResp.getData();
    }

    /**
     * List the enrollments of an user
     * This API allows to list all the enrollments of an user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return ApiResponse&lt;InlineResponse2003&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2003> listUserEnrollmentsWithHttpInfo(String organizationId, Id userId, Integer page, Integer count, String whereOrder) throws ApiException {
        okhttp3.Call localVarCall = listUserEnrollmentsValidateBeforeCall(organizationId, userId, page, count, whereOrder, null);
        Type localVarReturnType = new TypeToken<InlineResponse2003>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List the enrollments of an user (asynchronously)
     * This API allows to list all the enrollments of an user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listUserEnrollmentsAsync(String organizationId, Id userId, Integer page, Integer count, String whereOrder, final ApiCallback<InlineResponse2003> _callback) throws ApiException {

        okhttp3.Call localVarCall = listUserEnrollmentsValidateBeforeCall(organizationId, userId, page, count, whereOrder, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2003>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listUserIdentities
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listUserIdentitiesCall(String organizationId, Id userId, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/users/{user-id}/wallet"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "user-id" + "\\}", localVarApiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (count != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("count", count));
        }

        if (whereOrder != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_order", whereOrder));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listUserIdentitiesValidateBeforeCall(String organizationId, Id userId, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling listUserIdentities(Async)");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling listUserIdentities(Async)");
        }
        

        okhttp3.Call localVarCall = listUserIdentitiesCall(organizationId, userId, page, count, whereOrder, _callback);
        return localVarCall;

    }

    /**
     * Enumerate the identities of an user
     * This API allows to enumerate all the identities of an user, which are located in its wallet. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return InlineResponse2002
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2002 listUserIdentities(String organizationId, Id userId, Integer page, Integer count, String whereOrder) throws ApiException {
        ApiResponse<InlineResponse2002> localVarResp = listUserIdentitiesWithHttpInfo(organizationId, userId, page, count, whereOrder);
        return localVarResp.getData();
    }

    /**
     * Enumerate the identities of an user
     * This API allows to enumerate all the identities of an user, which are located in its wallet. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return ApiResponse&lt;InlineResponse2002&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2002> listUserIdentitiesWithHttpInfo(String organizationId, Id userId, Integer page, Integer count, String whereOrder) throws ApiException {
        okhttp3.Call localVarCall = listUserIdentitiesValidateBeforeCall(organizationId, userId, page, count, whereOrder, null);
        Type localVarReturnType = new TypeToken<InlineResponse2002>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Enumerate the identities of an user (asynchronously)
     * This API allows to enumerate all the identities of an user, which are located in its wallet. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listUserIdentitiesAsync(String organizationId, Id userId, Integer page, Integer count, String whereOrder, final ApiCallback<InlineResponse2002> _callback) throws ApiException {

        okhttp3.Call localVarCall = listUserIdentitiesValidateBeforeCall(organizationId, userId, page, count, whereOrder, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2002>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for renewIdentity
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param enrollmentId The **enrollment-id** is the uuid code that identifies a specific enrollment request  (required)
     * @param inlineObject1  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call renewIdentityCall(String organizationId, Id enrollmentId, InlineObject1 inlineObject1, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = inlineObject1;

        // create path and map variables
        String localVarPath = "/{organization-id}/identity-requests/{enrollment-id}/renew"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "enrollment-id" + "\\}", localVarApiClient.escapeString(enrollmentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call renewIdentityValidateBeforeCall(String organizationId, Id enrollmentId, InlineObject1 inlineObject1, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling renewIdentity(Async)");
        }
        
        // verify the required parameter 'enrollmentId' is set
        if (enrollmentId == null) {
            throw new ApiException("Missing the required parameter 'enrollmentId' when calling renewIdentity(Async)");
        }
        
        // verify the required parameter 'inlineObject1' is set
        if (inlineObject1 == null) {
            throw new ApiException("Missing the required parameter 'inlineObject1' when calling renewIdentity(Async)");
        }
        

        okhttp3.Call localVarCall = renewIdentityCall(organizationId, enrollmentId, inlineObject1, _callback);
        return localVarCall;

    }

    /**
     * Renew an Identity
     * This API allows to renew an Identity of a user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param enrollmentId The **enrollment-id** is the uuid code that identifies a specific enrollment request  (required)
     * @param inlineObject1  (required)
     * @return InlineResponse2007
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2007 renewIdentity(String organizationId, Id enrollmentId, InlineObject1 inlineObject1) throws ApiException {
        ApiResponse<InlineResponse2007> localVarResp = renewIdentityWithHttpInfo(organizationId, enrollmentId, inlineObject1);
        return localVarResp.getData();
    }

    /**
     * Renew an Identity
     * This API allows to renew an Identity of a user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param enrollmentId The **enrollment-id** is the uuid code that identifies a specific enrollment request  (required)
     * @param inlineObject1  (required)
     * @return ApiResponse&lt;InlineResponse2007&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2007> renewIdentityWithHttpInfo(String organizationId, Id enrollmentId, InlineObject1 inlineObject1) throws ApiException {
        okhttp3.Call localVarCall = renewIdentityValidateBeforeCall(organizationId, enrollmentId, inlineObject1, null);
        Type localVarReturnType = new TypeToken<InlineResponse2007>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Renew an Identity (asynchronously)
     * This API allows to renew an Identity of a user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param enrollmentId The **enrollment-id** is the uuid code that identifies a specific enrollment request  (required)
     * @param inlineObject1  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call renewIdentityAsync(String organizationId, Id enrollmentId, InlineObject1 inlineObject1, final ApiCallback<InlineResponse2007> _callback) throws ApiException {

        okhttp3.Call localVarCall = renewIdentityValidateBeforeCall(organizationId, enrollmentId, inlineObject1, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2007>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for requestEnrollment
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityRequest The enrollment request to submit (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call requestEnrollmentCall(String organizationId, IdentityRequest identityRequest, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = identityRequest;

        // create path and map variables
        String localVarPath = "/{organization-id}/enroll"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call requestEnrollmentValidateBeforeCall(String organizationId, IdentityRequest identityRequest, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling requestEnrollment(Async)");
        }
        
        // verify the required parameter 'identityRequest' is set
        if (identityRequest == null) {
            throw new ApiException("Missing the required parameter 'identityRequest' when calling requestEnrollment(Async)");
        }
        

        okhttp3.Call localVarCall = requestEnrollmentCall(organizationId, identityRequest, _callback);
        return localVarCall;

    }

    /**
     * Submit an enrollment request
     * This API allows to submit an enrollment request. The user of the request will be created if it does not exists already. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityRequest The enrollment request to submit (required)
     * @return InlineResponse2007
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2007 requestEnrollment(String organizationId, IdentityRequest identityRequest) throws ApiException {
        ApiResponse<InlineResponse2007> localVarResp = requestEnrollmentWithHttpInfo(organizationId, identityRequest);
        return localVarResp.getData();
    }

    /**
     * Submit an enrollment request
     * This API allows to submit an enrollment request. The user of the request will be created if it does not exists already. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityRequest The enrollment request to submit (required)
     * @return ApiResponse&lt;InlineResponse2007&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2007> requestEnrollmentWithHttpInfo(String organizationId, IdentityRequest identityRequest) throws ApiException {
        okhttp3.Call localVarCall = requestEnrollmentValidateBeforeCall(organizationId, identityRequest, null);
        Type localVarReturnType = new TypeToken<InlineResponse2007>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Submit an enrollment request (asynchronously)
     * This API allows to submit an enrollment request. The user of the request will be created if it does not exists already. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param identityRequest The enrollment request to submit (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call requestEnrollmentAsync(String organizationId, IdentityRequest identityRequest, final ApiCallback<InlineResponse2007> _callback) throws ApiException {

        okhttp3.Call localVarCall = requestEnrollmentValidateBeforeCall(organizationId, identityRequest, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2007>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
