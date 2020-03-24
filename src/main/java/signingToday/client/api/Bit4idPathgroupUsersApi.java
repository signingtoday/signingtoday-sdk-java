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


import signingToday.client.model.CreateUser;
import signingToday.client.model.Id;
import signingToday.client.model.InlineResponse2001;
import signingToday.client.model.InlineResponse201;
import signingToday.client.model.InlineResponse401;
import signingToday.client.model.InlineResponse403;
import signingToday.client.model.InlineResponse404;
import signingToday.client.model.UpdateUser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bit4idPathgroupUsersApi {
    private ApiClient localVarApiClient;

    public Bit4idPathgroupUsersApi() {
        this(Configuration.getDefaultApiClient());
    }

    public Bit4idPathgroupUsersApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for createUser
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createUser The new user object to create (required)
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
    public okhttp3.Call createUserCall(String organizationId, CreateUser createUser, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = createUser;

        // create path and map variables
        String localVarPath = "/{organization-id}/users"
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
    private okhttp3.Call createUserValidateBeforeCall(String organizationId, CreateUser createUser, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling createUser(Async)");
        }
        
        // verify the required parameter 'createUser' is set
        if (createUser == null) {
            throw new ApiException("Missing the required parameter 'createUser' when calling createUser(Async)");
        }
        

        okhttp3.Call localVarCall = createUserCall(organizationId, createUser, _callback);
        return localVarCall;

    }

    /**
     * Create a user of the organization
     * This API allows to create a new user of the organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createUser The new user object to create (required)
     * @return InlineResponse201
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
    public InlineResponse201 createUser(String organizationId, CreateUser createUser) throws ApiException {
        ApiResponse<InlineResponse201> localVarResp = createUserWithHttpInfo(organizationId, createUser);
        return localVarResp.getData();
    }

    /**
     * Create a user of the organization
     * This API allows to create a new user of the organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createUser The new user object to create (required)
     * @return ApiResponse&lt;InlineResponse201&gt;
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
    public ApiResponse<InlineResponse201> createUserWithHttpInfo(String organizationId, CreateUser createUser) throws ApiException {
        okhttp3.Call localVarCall = createUserValidateBeforeCall(organizationId, createUser, null);
        Type localVarReturnType = new TypeToken<InlineResponse201>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create a user of the organization (asynchronously)
     * This API allows to create a new user of the organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createUser The new user object to create (required)
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
    public okhttp3.Call createUserAsync(String organizationId, CreateUser createUser, final ApiCallback<InlineResponse201> _callback) throws ApiException {

        okhttp3.Call localVarCall = createUserValidateBeforeCall(organizationId, createUser, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse201>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getUser
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
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
    public okhttp3.Call getUserCall(String organizationId, Id userId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/users/{user-id}"
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
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getUserValidateBeforeCall(String organizationId, Id userId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling getUser(Async)");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling getUser(Async)");
        }
        

        okhttp3.Call localVarCall = getUserCall(organizationId, userId, _callback);
        return localVarCall;

    }

    /**
     * Get information about an user
     * This API allows to get information about an user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @return InlineResponse201
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
    public InlineResponse201 getUser(String organizationId, Id userId) throws ApiException {
        ApiResponse<InlineResponse201> localVarResp = getUserWithHttpInfo(organizationId, userId);
        return localVarResp.getData();
    }

    /**
     * Get information about an user
     * This API allows to get information about an user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @return ApiResponse&lt;InlineResponse201&gt;
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
    public ApiResponse<InlineResponse201> getUserWithHttpInfo(String organizationId, Id userId) throws ApiException {
        okhttp3.Call localVarCall = getUserValidateBeforeCall(organizationId, userId, null);
        Type localVarReturnType = new TypeToken<InlineResponse201>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get information about an user (asynchronously)
     * This API allows to get information about an user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
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
    public okhttp3.Call getUserAsync(String organizationId, Id userId, final ApiCallback<InlineResponse201> _callback) throws ApiException {

        okhttp3.Call localVarCall = getUserValidateBeforeCall(organizationId, userId, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse201>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listUsers
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereMembershipId Returns the users that have the specified id (optional)
     * @param whereEmail Returns the users that have the specified email (optional)
     * @param whereLastName Returns the users that have the specified last name (optional)
     * @param whereFirstName Returns the users that have the specified first name (optional)
     * @param whereAutomatic If set up to **true** returns automatic users only, otherwise returns non automatic users only (optional)
     * @param whereRao If set up to **true** returns rao users only, otherwise returns non rao users only (optional)
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
    public okhttp3.Call listUsersCall(String organizationId, String whereMembershipId, String whereEmail, String whereLastName, String whereFirstName, Boolean whereAutomatic, Boolean whereRao, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/users"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (whereMembershipId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_membership_id", whereMembershipId));
        }

        if (whereEmail != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_email", whereEmail));
        }

        if (whereLastName != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_last_name", whereLastName));
        }

        if (whereFirstName != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_first_name", whereFirstName));
        }

        if (whereAutomatic != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_automatic", whereAutomatic));
        }

        if (whereRao != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_rao", whereRao));
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
    private okhttp3.Call listUsersValidateBeforeCall(String organizationId, String whereMembershipId, String whereEmail, String whereLastName, String whereFirstName, Boolean whereAutomatic, Boolean whereRao, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling listUsers(Async)");
        }
        

        okhttp3.Call localVarCall = listUsersCall(organizationId, whereMembershipId, whereEmail, whereLastName, whereFirstName, whereAutomatic, whereRao, page, count, whereOrder, _callback);
        return localVarCall;

    }

    /**
     * Enumerate the users of an organization
     * This API allows to enumerate the users of an organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereMembershipId Returns the users that have the specified id (optional)
     * @param whereEmail Returns the users that have the specified email (optional)
     * @param whereLastName Returns the users that have the specified last name (optional)
     * @param whereFirstName Returns the users that have the specified first name (optional)
     * @param whereAutomatic If set up to **true** returns automatic users only, otherwise returns non automatic users only (optional)
     * @param whereRao If set up to **true** returns rao users only, otherwise returns non rao users only (optional)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return InlineResponse2001
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
    public InlineResponse2001 listUsers(String organizationId, String whereMembershipId, String whereEmail, String whereLastName, String whereFirstName, Boolean whereAutomatic, Boolean whereRao, Integer page, Integer count, String whereOrder) throws ApiException {
        ApiResponse<InlineResponse2001> localVarResp = listUsersWithHttpInfo(organizationId, whereMembershipId, whereEmail, whereLastName, whereFirstName, whereAutomatic, whereRao, page, count, whereOrder);
        return localVarResp.getData();
    }

    /**
     * Enumerate the users of an organization
     * This API allows to enumerate the users of an organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereMembershipId Returns the users that have the specified id (optional)
     * @param whereEmail Returns the users that have the specified email (optional)
     * @param whereLastName Returns the users that have the specified last name (optional)
     * @param whereFirstName Returns the users that have the specified first name (optional)
     * @param whereAutomatic If set up to **true** returns automatic users only, otherwise returns non automatic users only (optional)
     * @param whereRao If set up to **true** returns rao users only, otherwise returns non rao users only (optional)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return ApiResponse&lt;InlineResponse2001&gt;
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
    public ApiResponse<InlineResponse2001> listUsersWithHttpInfo(String organizationId, String whereMembershipId, String whereEmail, String whereLastName, String whereFirstName, Boolean whereAutomatic, Boolean whereRao, Integer page, Integer count, String whereOrder) throws ApiException {
        okhttp3.Call localVarCall = listUsersValidateBeforeCall(organizationId, whereMembershipId, whereEmail, whereLastName, whereFirstName, whereAutomatic, whereRao, page, count, whereOrder, null);
        Type localVarReturnType = new TypeToken<InlineResponse2001>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Enumerate the users of an organization (asynchronously)
     * This API allows to enumerate the users of an organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereMembershipId Returns the users that have the specified id (optional)
     * @param whereEmail Returns the users that have the specified email (optional)
     * @param whereLastName Returns the users that have the specified last name (optional)
     * @param whereFirstName Returns the users that have the specified first name (optional)
     * @param whereAutomatic If set up to **true** returns automatic users only, otherwise returns non automatic users only (optional)
     * @param whereRao If set up to **true** returns rao users only, otherwise returns non rao users only (optional)
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
    public okhttp3.Call listUsersAsync(String organizationId, String whereMembershipId, String whereEmail, String whereLastName, String whereFirstName, Boolean whereAutomatic, Boolean whereRao, Integer page, Integer count, String whereOrder, final ApiCallback<InlineResponse2001> _callback) throws ApiException {

        okhttp3.Call localVarCall = listUsersValidateBeforeCall(organizationId, whereMembershipId, whereEmail, whereLastName, whereFirstName, whereAutomatic, whereRao, page, count, whereOrder, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2001>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for updateUser
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param updateUser User properties to be edited (required)
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
    public okhttp3.Call updateUserCall(String organizationId, Id userId, UpdateUser updateUser, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = updateUser;

        // create path and map variables
        String localVarPath = "/{organization-id}/users/{user-id}"
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
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateUserValidateBeforeCall(String organizationId, Id userId, UpdateUser updateUser, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling updateUser(Async)");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling updateUser(Async)");
        }
        
        // verify the required parameter 'updateUser' is set
        if (updateUser == null) {
            throw new ApiException("Missing the required parameter 'updateUser' when calling updateUser(Async)");
        }
        

        okhttp3.Call localVarCall = updateUserCall(organizationId, userId, updateUser, _callback);
        return localVarCall;

    }

    /**
     * Edit one or more user properties
     * This API allows to edit one or more user properties. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param updateUser User properties to be edited (required)
     * @return InlineResponse201
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
    public InlineResponse201 updateUser(String organizationId, Id userId, UpdateUser updateUser) throws ApiException {
        ApiResponse<InlineResponse201> localVarResp = updateUserWithHttpInfo(organizationId, userId, updateUser);
        return localVarResp.getData();
    }

    /**
     * Edit one or more user properties
     * This API allows to edit one or more user properties. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param updateUser User properties to be edited (required)
     * @return ApiResponse&lt;InlineResponse201&gt;
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
    public ApiResponse<InlineResponse201> updateUserWithHttpInfo(String organizationId, Id userId, UpdateUser updateUser) throws ApiException {
        okhttp3.Call localVarCall = updateUserValidateBeforeCall(organizationId, userId, updateUser, null);
        Type localVarReturnType = new TypeToken<InlineResponse201>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Edit one or more user properties (asynchronously)
     * This API allows to edit one or more user properties. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param updateUser User properties to be edited (required)
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
    public okhttp3.Call updateUserAsync(String organizationId, Id userId, UpdateUser updateUser, final ApiCallback<InlineResponse201> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateUserValidateBeforeCall(organizationId, userId, updateUser, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse201>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
