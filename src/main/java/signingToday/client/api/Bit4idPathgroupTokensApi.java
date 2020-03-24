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


import signingToday.client.model.CreateToken;
import signingToday.client.model.Id;
import signingToday.client.model.InlineResponse2004;
import signingToday.client.model.InlineResponse2012;
import signingToday.client.model.InlineResponse2015;
import signingToday.client.model.InlineResponse401;
import signingToday.client.model.InlineResponse403;
import signingToday.client.model.InlineResponse404;
import signingToday.client.model.UpdateToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bit4idPathgroupTokensApi {
    private ApiClient localVarApiClient;

    public Bit4idPathgroupTokensApi() {
        this(Configuration.getDefaultApiClient());
    }

    public Bit4idPathgroupTokensApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for createToken
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createToken Token data (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createTokenCall(String organizationId, CreateToken createToken, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = createToken;

        // create path and map variables
        String localVarPath = "/{organization-id}/tokens"
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
    private okhttp3.Call createTokenValidateBeforeCall(String organizationId, CreateToken createToken, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling createToken(Async)");
        }
        
        // verify the required parameter 'createToken' is set
        if (createToken == null) {
            throw new ApiException("Missing the required parameter 'createToken' when calling createToken(Async)");
        }
        

        okhttp3.Call localVarCall = createTokenCall(organizationId, createToken, _callback);
        return localVarCall;

    }

    /**
     * Create an application token
     * This API allows to create an application token. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createToken Token data (required)
     * @return InlineResponse2015
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2015 createToken(String organizationId, CreateToken createToken) throws ApiException {
        ApiResponse<InlineResponse2015> localVarResp = createTokenWithHttpInfo(organizationId, createToken);
        return localVarResp.getData();
    }

    /**
     * Create an application token
     * This API allows to create an application token. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createToken Token data (required)
     * @return ApiResponse&lt;InlineResponse2015&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2015> createTokenWithHttpInfo(String organizationId, CreateToken createToken) throws ApiException {
        okhttp3.Call localVarCall = createTokenValidateBeforeCall(organizationId, createToken, null);
        Type localVarReturnType = new TypeToken<InlineResponse2015>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create an application token (asynchronously)
     * This API allows to create an application token. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createToken Token data (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createTokenAsync(String organizationId, CreateToken createToken, final ApiCallback<InlineResponse2015> _callback) throws ApiException {

        okhttp3.Call localVarCall = createTokenValidateBeforeCall(organizationId, createToken, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2015>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteToken
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param tokenId The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  (required)
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
    public okhttp3.Call deleteTokenCall(String organizationId, Id tokenId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/tokens/{token-id}"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "token-id" + "\\}", localVarApiClient.escapeString(tokenId.toString()));

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
    private okhttp3.Call deleteTokenValidateBeforeCall(String organizationId, Id tokenId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling deleteToken(Async)");
        }
        
        // verify the required parameter 'tokenId' is set
        if (tokenId == null) {
            throw new ApiException("Missing the required parameter 'tokenId' when calling deleteToken(Async)");
        }
        

        okhttp3.Call localVarCall = deleteTokenCall(organizationId, tokenId, _callback);
        return localVarCall;

    }

    /**
     * Delete a token of the organization
     * This API allows to delete a token of the organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param tokenId The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  (required)
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
    public InlineResponse2012 deleteToken(String organizationId, Id tokenId) throws ApiException {
        ApiResponse<InlineResponse2012> localVarResp = deleteTokenWithHttpInfo(organizationId, tokenId);
        return localVarResp.getData();
    }

    /**
     * Delete a token of the organization
     * This API allows to delete a token of the organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param tokenId The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  (required)
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
    public ApiResponse<InlineResponse2012> deleteTokenWithHttpInfo(String organizationId, Id tokenId) throws ApiException {
        okhttp3.Call localVarCall = deleteTokenValidateBeforeCall(organizationId, tokenId, null);
        Type localVarReturnType = new TypeToken<InlineResponse2012>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Delete a token of the organization (asynchronously)
     * This API allows to delete a token of the organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param tokenId The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  (required)
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
    public okhttp3.Call deleteTokenAsync(String organizationId, Id tokenId, final ApiCallback<InlineResponse2012> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteTokenValidateBeforeCall(organizationId, tokenId, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2012>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getToken
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param tokenId The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  (required)
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
    public okhttp3.Call getTokenCall(String organizationId, Id tokenId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/tokens/{token-id}"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "token-id" + "\\}", localVarApiClient.escapeString(tokenId.toString()));

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
    private okhttp3.Call getTokenValidateBeforeCall(String organizationId, Id tokenId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling getToken(Async)");
        }
        
        // verify the required parameter 'tokenId' is set
        if (tokenId == null) {
            throw new ApiException("Missing the required parameter 'tokenId' when calling getToken(Async)");
        }
        

        okhttp3.Call localVarCall = getTokenCall(organizationId, tokenId, _callback);
        return localVarCall;

    }

    /**
     * Get information about a token
     * This API allows to get information about a token. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param tokenId The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  (required)
     * @return InlineResponse2015
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
    public InlineResponse2015 getToken(String organizationId, Id tokenId) throws ApiException {
        ApiResponse<InlineResponse2015> localVarResp = getTokenWithHttpInfo(organizationId, tokenId);
        return localVarResp.getData();
    }

    /**
     * Get information about a token
     * This API allows to get information about a token. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param tokenId The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  (required)
     * @return ApiResponse&lt;InlineResponse2015&gt;
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
    public ApiResponse<InlineResponse2015> getTokenWithHttpInfo(String organizationId, Id tokenId) throws ApiException {
        okhttp3.Call localVarCall = getTokenValidateBeforeCall(organizationId, tokenId, null);
        Type localVarReturnType = new TypeToken<InlineResponse2015>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get information about a token (asynchronously)
     * This API allows to get information about a token. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param tokenId The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  (required)
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
    public okhttp3.Call getTokenAsync(String organizationId, Id tokenId, final ApiCallback<InlineResponse2015> _callback) throws ApiException {

        okhttp3.Call localVarCall = getTokenValidateBeforeCall(organizationId, tokenId, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2015>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listTokens
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereUser Returns the tokens of the specified user, searched by its id (optional)
     * @param whereLabel Returns the tokens with the specified label (optional)
     * @param count Sets the number of tokens per page to display (optional, default to 100)
     * @param page Restricts the search to chosen page (optional)
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
    public okhttp3.Call listTokensCall(String organizationId, String whereUser, String whereLabel, Integer count, Integer page, String whereOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/tokens"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (whereUser != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_user", whereUser));
        }

        if (whereLabel != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_label", whereLabel));
        }

        if (count != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("count", count));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
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
    private okhttp3.Call listTokensValidateBeforeCall(String organizationId, String whereUser, String whereLabel, Integer count, Integer page, String whereOrder, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling listTokens(Async)");
        }
        

        okhttp3.Call localVarCall = listTokensCall(organizationId, whereUser, whereLabel, count, page, whereOrder, _callback);
        return localVarCall;

    }

    /**
     * Enumerate the tokens of an organization
     * This API allows to enumerate the tokens of an organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereUser Returns the tokens of the specified user, searched by its id (optional)
     * @param whereLabel Returns the tokens with the specified label (optional)
     * @param count Sets the number of tokens per page to display (optional, default to 100)
     * @param page Restricts the search to chosen page (optional)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return InlineResponse2004
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
    public InlineResponse2004 listTokens(String organizationId, String whereUser, String whereLabel, Integer count, Integer page, String whereOrder) throws ApiException {
        ApiResponse<InlineResponse2004> localVarResp = listTokensWithHttpInfo(organizationId, whereUser, whereLabel, count, page, whereOrder);
        return localVarResp.getData();
    }

    /**
     * Enumerate the tokens of an organization
     * This API allows to enumerate the tokens of an organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereUser Returns the tokens of the specified user, searched by its id (optional)
     * @param whereLabel Returns the tokens with the specified label (optional)
     * @param count Sets the number of tokens per page to display (optional, default to 100)
     * @param page Restricts the search to chosen page (optional)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return ApiResponse&lt;InlineResponse2004&gt;
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
    public ApiResponse<InlineResponse2004> listTokensWithHttpInfo(String organizationId, String whereUser, String whereLabel, Integer count, Integer page, String whereOrder) throws ApiException {
        okhttp3.Call localVarCall = listTokensValidateBeforeCall(organizationId, whereUser, whereLabel, count, page, whereOrder, null);
        Type localVarReturnType = new TypeToken<InlineResponse2004>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Enumerate the tokens of an organization (asynchronously)
     * This API allows to enumerate the tokens of an organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereUser Returns the tokens of the specified user, searched by its id (optional)
     * @param whereLabel Returns the tokens with the specified label (optional)
     * @param count Sets the number of tokens per page to display (optional, default to 100)
     * @param page Restricts the search to chosen page (optional)
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
    public okhttp3.Call listTokensAsync(String organizationId, String whereUser, String whereLabel, Integer count, Integer page, String whereOrder, final ApiCallback<InlineResponse2004> _callback) throws ApiException {

        okhttp3.Call localVarCall = listTokensValidateBeforeCall(organizationId, whereUser, whereLabel, count, page, whereOrder, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2004>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listUserTokens
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
    public okhttp3.Call listUserTokensCall(String organizationId, Id userId, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/users/{user-id}/tokens"
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
    private okhttp3.Call listUserTokensValidateBeforeCall(String organizationId, Id userId, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling listUserTokens(Async)");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling listUserTokens(Async)");
        }
        

        okhttp3.Call localVarCall = listUserTokensCall(organizationId, userId, page, count, whereOrder, _callback);
        return localVarCall;

    }

    /**
     * Enumerate the tokens of an user
     * This API allows to enumerate all the tokens of an user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return InlineResponse2004
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
    public InlineResponse2004 listUserTokens(String organizationId, Id userId, Integer page, Integer count, String whereOrder) throws ApiException {
        ApiResponse<InlineResponse2004> localVarResp = listUserTokensWithHttpInfo(organizationId, userId, page, count, whereOrder);
        return localVarResp.getData();
    }

    /**
     * Enumerate the tokens of an user
     * This API allows to enumerate all the tokens of an user. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param userId The **user-id** is the uuid code that identifies a user of an organization. It is used as a path parameter to restrict the requested operation to the scope of that user  (required)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return ApiResponse&lt;InlineResponse2004&gt;
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
    public ApiResponse<InlineResponse2004> listUserTokensWithHttpInfo(String organizationId, Id userId, Integer page, Integer count, String whereOrder) throws ApiException {
        okhttp3.Call localVarCall = listUserTokensValidateBeforeCall(organizationId, userId, page, count, whereOrder, null);
        Type localVarReturnType = new TypeToken<InlineResponse2004>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Enumerate the tokens of an user (asynchronously)
     * This API allows to enumerate all the tokens of an user. 
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
    public okhttp3.Call listUserTokensAsync(String organizationId, Id userId, Integer page, Integer count, String whereOrder, final ApiCallback<InlineResponse2004> _callback) throws ApiException {

        okhttp3.Call localVarCall = listUserTokensValidateBeforeCall(organizationId, userId, page, count, whereOrder, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2004>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for updateToken
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param tokenId The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  (required)
     * @param updateToken Token data (required)
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
    public okhttp3.Call updateTokenCall(String organizationId, Id tokenId, UpdateToken updateToken, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = updateToken;

        // create path and map variables
        String localVarPath = "/{organization-id}/tokens/{token-id}"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "token-id" + "\\}", localVarApiClient.escapeString(tokenId.toString()));

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
    private okhttp3.Call updateTokenValidateBeforeCall(String organizationId, Id tokenId, UpdateToken updateToken, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling updateToken(Async)");
        }
        
        // verify the required parameter 'tokenId' is set
        if (tokenId == null) {
            throw new ApiException("Missing the required parameter 'tokenId' when calling updateToken(Async)");
        }
        
        // verify the required parameter 'updateToken' is set
        if (updateToken == null) {
            throw new ApiException("Missing the required parameter 'updateToken' when calling updateToken(Async)");
        }
        

        okhttp3.Call localVarCall = updateTokenCall(organizationId, tokenId, updateToken, _callback);
        return localVarCall;

    }

    /**
     * Update the properties of a token
     * This API allows to update the properties of a token. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param tokenId The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  (required)
     * @param updateToken Token data (required)
     * @return InlineResponse2015
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
    public InlineResponse2015 updateToken(String organizationId, Id tokenId, UpdateToken updateToken) throws ApiException {
        ApiResponse<InlineResponse2015> localVarResp = updateTokenWithHttpInfo(organizationId, tokenId, updateToken);
        return localVarResp.getData();
    }

    /**
     * Update the properties of a token
     * This API allows to update the properties of a token. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param tokenId The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  (required)
     * @param updateToken Token data (required)
     * @return ApiResponse&lt;InlineResponse2015&gt;
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
    public ApiResponse<InlineResponse2015> updateTokenWithHttpInfo(String organizationId, Id tokenId, UpdateToken updateToken) throws ApiException {
        okhttp3.Call localVarCall = updateTokenValidateBeforeCall(organizationId, tokenId, updateToken, null);
        Type localVarReturnType = new TypeToken<InlineResponse2015>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update the properties of a token (asynchronously)
     * This API allows to update the properties of a token. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param tokenId The **token-id** is the uuid code that identifies a token. It is, as well, used to restrict the requested operation to the scope of that token  (required)
     * @param updateToken Token data (required)
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
    public okhttp3.Call updateTokenAsync(String organizationId, Id tokenId, UpdateToken updateToken, final ApiCallback<InlineResponse2015> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateTokenValidateBeforeCall(organizationId, tokenId, updateToken, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2015>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
