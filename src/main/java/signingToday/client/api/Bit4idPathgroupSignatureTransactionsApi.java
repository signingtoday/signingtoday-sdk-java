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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bit4idPathgroupSignatureTransactionsApi {
    private ApiClient localVarApiClient;

    public Bit4idPathgroupSignatureTransactionsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public Bit4idPathgroupSignatureTransactionsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for cancelDST
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
     * @param inlineObject2  (required)
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
    public okhttp3.Call cancelDSTCall(String organizationId, Id dstId, InlineObject2 inlineObject2, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = inlineObject2;

        // create path and map variables
        String localVarPath = "/{organization-id}/signature-transactions/{dst-id}/cancel"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "dst-id" + "\\}", localVarApiClient.escapeString(dstId.toString()));

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
    private okhttp3.Call cancelDSTValidateBeforeCall(String organizationId, Id dstId, InlineObject2 inlineObject2, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling cancelDST(Async)");
        }
        
        // verify the required parameter 'dstId' is set
        if (dstId == null) {
            throw new ApiException("Missing the required parameter 'dstId' when calling cancelDST(Async)");
        }
        
        // verify the required parameter 'inlineObject2' is set
        if (inlineObject2 == null) {
            throw new ApiException("Missing the required parameter 'inlineObject2' when calling cancelDST(Async)");
        }
        

        okhttp3.Call localVarCall = cancelDSTCall(organizationId, dstId, inlineObject2, _callback);
        return localVarCall;

    }

    /**
     * Mark a DST as canceled
     * This API allows to mark a Digital Signature Transaction as canceled providing a reason. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
     * @param inlineObject2  (required)
     * @return InlineResponse2013
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
    public InlineResponse2013 cancelDST(String organizationId, Id dstId, InlineObject2 inlineObject2) throws ApiException {
        ApiResponse<InlineResponse2013> localVarResp = cancelDSTWithHttpInfo(organizationId, dstId, inlineObject2);
        return localVarResp.getData();
    }

    /**
     * Mark a DST as canceled
     * This API allows to mark a Digital Signature Transaction as canceled providing a reason. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
     * @param inlineObject2  (required)
     * @return ApiResponse&lt;InlineResponse2013&gt;
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
    public ApiResponse<InlineResponse2013> cancelDSTWithHttpInfo(String organizationId, Id dstId, InlineObject2 inlineObject2) throws ApiException {
        okhttp3.Call localVarCall = cancelDSTValidateBeforeCall(organizationId, dstId, inlineObject2, null);
        Type localVarReturnType = new TypeToken<InlineResponse2013>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Mark a DST as canceled (asynchronously)
     * This API allows to mark a Digital Signature Transaction as canceled providing a reason. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
     * @param inlineObject2  (required)
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
    public okhttp3.Call cancelDSTAsync(String organizationId, Id dstId, InlineObject2 inlineObject2, final ApiCallback<InlineResponse2013> _callback) throws ApiException {

        okhttp3.Call localVarCall = cancelDSTValidateBeforeCall(organizationId, dstId, inlineObject2, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2013>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for createDST
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createSignatureTransaction The new DST to create (required)
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
    public okhttp3.Call createDSTCall(String organizationId, CreateSignatureTransaction createSignatureTransaction, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = createSignatureTransaction;

        // create path and map variables
        String localVarPath = "/{organization-id}/signature-transactions"
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
    private okhttp3.Call createDSTValidateBeforeCall(String organizationId, CreateSignatureTransaction createSignatureTransaction, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling createDST(Async)");
        }
        
        // verify the required parameter 'createSignatureTransaction' is set
        if (createSignatureTransaction == null) {
            throw new ApiException("Missing the required parameter 'createSignatureTransaction' when calling createDST(Async)");
        }
        

        okhttp3.Call localVarCall = createDSTCall(organizationId, createSignatureTransaction, _callback);
        return localVarCall;

    }

    /**
     * Create a Digital Signature Transaction
     * This API allows to create a Digital Signature Transaction. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createSignatureTransaction The new DST to create (required)
     * @return InlineResponse2013
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
    public InlineResponse2013 createDST(String organizationId, CreateSignatureTransaction createSignatureTransaction) throws ApiException {
        ApiResponse<InlineResponse2013> localVarResp = createDSTWithHttpInfo(organizationId, createSignatureTransaction);
        return localVarResp.getData();
    }

    /**
     * Create a Digital Signature Transaction
     * This API allows to create a Digital Signature Transaction. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createSignatureTransaction The new DST to create (required)
     * @return ApiResponse&lt;InlineResponse2013&gt;
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
    public ApiResponse<InlineResponse2013> createDSTWithHttpInfo(String organizationId, CreateSignatureTransaction createSignatureTransaction) throws ApiException {
        okhttp3.Call localVarCall = createDSTValidateBeforeCall(organizationId, createSignatureTransaction, null);
        Type localVarReturnType = new TypeToken<InlineResponse2013>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create a Digital Signature Transaction (asynchronously)
     * This API allows to create a Digital Signature Transaction. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param createSignatureTransaction The new DST to create (required)
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
    public okhttp3.Call createDSTAsync(String organizationId, CreateSignatureTransaction createSignatureTransaction, final ApiCallback<InlineResponse2013> _callback) throws ApiException {

        okhttp3.Call localVarCall = createDSTValidateBeforeCall(organizationId, createSignatureTransaction, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2013>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteDST
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
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
    public okhttp3.Call deleteDSTCall(String organizationId, Id dstId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/signature-transactions/{dst-id}"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "dst-id" + "\\}", localVarApiClient.escapeString(dstId.toString()));

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
    private okhttp3.Call deleteDSTValidateBeforeCall(String organizationId, Id dstId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling deleteDST(Async)");
        }
        
        // verify the required parameter 'dstId' is set
        if (dstId == null) {
            throw new ApiException("Missing the required parameter 'dstId' when calling deleteDST(Async)");
        }
        

        okhttp3.Call localVarCall = deleteDSTCall(organizationId, dstId, _callback);
        return localVarCall;

    }

    /**
     * Delete a Digital Signature Transaction
     * This API allows to delete a Digital Signature Transaction. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
     * @return InlineResponse2009
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
    public InlineResponse2009 deleteDST(String organizationId, Id dstId) throws ApiException {
        ApiResponse<InlineResponse2009> localVarResp = deleteDSTWithHttpInfo(organizationId, dstId);
        return localVarResp.getData();
    }

    /**
     * Delete a Digital Signature Transaction
     * This API allows to delete a Digital Signature Transaction. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
     * @return ApiResponse&lt;InlineResponse2009&gt;
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
    public ApiResponse<InlineResponse2009> deleteDSTWithHttpInfo(String organizationId, Id dstId) throws ApiException {
        okhttp3.Call localVarCall = deleteDSTValidateBeforeCall(organizationId, dstId, null);
        Type localVarReturnType = new TypeToken<InlineResponse2009>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Delete a Digital Signature Transaction (asynchronously)
     * This API allows to delete a Digital Signature Transaction. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
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
    public okhttp3.Call deleteDSTAsync(String organizationId, Id dstId, final ApiCallback<InlineResponse2009> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteDSTValidateBeforeCall(organizationId, dstId, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2009>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteDSTResources
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
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
    public okhttp3.Call deleteDSTResourcesCall(String organizationId, Id dstId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/signature-transactions/{dst-id}/resources"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "dst-id" + "\\}", localVarApiClient.escapeString(dstId.toString()));

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
    private okhttp3.Call deleteDSTResourcesValidateBeforeCall(String organizationId, Id dstId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling deleteDSTResources(Async)");
        }
        
        // verify the required parameter 'dstId' is set
        if (dstId == null) {
            throw new ApiException("Missing the required parameter 'dstId' when calling deleteDSTResources(Async)");
        }
        

        okhttp3.Call localVarCall = deleteDSTResourcesCall(organizationId, dstId, _callback);
        return localVarCall;

    }

    /**
     * Delete the resources of a DST
     * This API allows to delete the resources of a Digital Signature Transaction. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
     * @return InlineResponse20010
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
    public InlineResponse20010 deleteDSTResources(String organizationId, Id dstId) throws ApiException {
        ApiResponse<InlineResponse20010> localVarResp = deleteDSTResourcesWithHttpInfo(organizationId, dstId);
        return localVarResp.getData();
    }

    /**
     * Delete the resources of a DST
     * This API allows to delete the resources of a Digital Signature Transaction. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
     * @return ApiResponse&lt;InlineResponse20010&gt;
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
    public ApiResponse<InlineResponse20010> deleteDSTResourcesWithHttpInfo(String organizationId, Id dstId) throws ApiException {
        okhttp3.Call localVarCall = deleteDSTResourcesValidateBeforeCall(organizationId, dstId, null);
        Type localVarReturnType = new TypeToken<InlineResponse20010>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Delete the resources of a DST (asynchronously)
     * This API allows to delete the resources of a Digital Signature Transaction. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
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
    public okhttp3.Call deleteDSTResourcesAsync(String organizationId, Id dstId, final ApiCallback<InlineResponse20010> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteDSTResourcesValidateBeforeCall(organizationId, dstId, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse20010>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getDST
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
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
    public okhttp3.Call getDSTCall(String organizationId, Id dstId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/signature-transactions/{dst-id}"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "dst-id" + "\\}", localVarApiClient.escapeString(dstId.toString()));

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
    private okhttp3.Call getDSTValidateBeforeCall(String organizationId, Id dstId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling getDST(Async)");
        }
        
        // verify the required parameter 'dstId' is set
        if (dstId == null) {
            throw new ApiException("Missing the required parameter 'dstId' when calling getDST(Async)");
        }
        

        okhttp3.Call localVarCall = getDSTCall(organizationId, dstId, _callback);
        return localVarCall;

    }

    /**
     * Get information about a DST
     * This API allows to get information about a Digital Signature Transaction. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
     * @return InlineResponse2013
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
    public InlineResponse2013 getDST(String organizationId, Id dstId) throws ApiException {
        ApiResponse<InlineResponse2013> localVarResp = getDSTWithHttpInfo(organizationId, dstId);
        return localVarResp.getData();
    }

    /**
     * Get information about a DST
     * This API allows to get information about a Digital Signature Transaction. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
     * @return ApiResponse&lt;InlineResponse2013&gt;
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
    public ApiResponse<InlineResponse2013> getDSTWithHttpInfo(String organizationId, Id dstId) throws ApiException {
        okhttp3.Call localVarCall = getDSTValidateBeforeCall(organizationId, dstId, null);
        Type localVarReturnType = new TypeToken<InlineResponse2013>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get information about a DST (asynchronously)
     * This API allows to get information about a Digital Signature Transaction. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
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
    public okhttp3.Call getDSTAsync(String organizationId, Id dstId, final ApiCallback<InlineResponse2013> _callback) throws ApiException {

        okhttp3.Call localVarCall = getDSTValidateBeforeCall(organizationId, dstId, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2013>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getDocument
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param documentId The **document-id** is the uuid code that identifies a document of a digital signature transaction. This parameter is usually used in order to download a document from a digital signature transaction  (required)
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
    public okhttp3.Call getDocumentCall(String organizationId, Id documentId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/documents/{document-id}/download"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "document-id" + "\\}", localVarApiClient.escapeString(documentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/pdf", "application/json"
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
    private okhttp3.Call getDocumentValidateBeforeCall(String organizationId, Id documentId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling getDocument(Async)");
        }
        
        // verify the required parameter 'documentId' is set
        if (documentId == null) {
            throw new ApiException("Missing the required parameter 'documentId' when calling getDocument(Async)");
        }
        

        okhttp3.Call localVarCall = getDocumentCall(organizationId, documentId, _callback);
        return localVarCall;

    }

    /**
     * Download a document from a DST
     * This API allows to download a document from a digital signature transaction. The document can be downloaded before or after one or every signature have been performed. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param documentId The **document-id** is the uuid code that identifies a document of a digital signature transaction. This parameter is usually used in order to download a document from a digital signature transaction  (required)
     * @return File
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
    public File getDocument(String organizationId, Id documentId) throws ApiException {
        ApiResponse<File> localVarResp = getDocumentWithHttpInfo(organizationId, documentId);
        return localVarResp.getData();
    }

    /**
     * Download a document from a DST
     * This API allows to download a document from a digital signature transaction. The document can be downloaded before or after one or every signature have been performed. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param documentId The **document-id** is the uuid code that identifies a document of a digital signature transaction. This parameter is usually used in order to download a document from a digital signature transaction  (required)
     * @return ApiResponse&lt;File&gt;
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
    public ApiResponse<File> getDocumentWithHttpInfo(String organizationId, Id documentId) throws ApiException {
        okhttp3.Call localVarCall = getDocumentValidateBeforeCall(organizationId, documentId, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Download a document from a DST (asynchronously)
     * This API allows to download a document from a digital signature transaction. The document can be downloaded before or after one or every signature have been performed. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param documentId The **document-id** is the uuid code that identifies a document of a digital signature transaction. This parameter is usually used in order to download a document from a digital signature transaction  (required)
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
    public okhttp3.Call getDocumentAsync(String organizationId, Id documentId, final ApiCallback<File> _callback) throws ApiException {

        okhttp3.Call localVarCall = getDocumentValidateBeforeCall(organizationId, documentId, _callback);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listDSTs
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereSigner Returns the Digital Signature Transactions where the specified user is a signer, searched by its id (optional)
     * @param whereStatus Returns the Digital Signature Transactions with the specified status (optional)
     * @param whereTitle Returns the Digital Signature Transactions that have the specified title (optional)
     * @param whereCreatedBy Returns the Digital Signature Transactions created by the specified user (optional)
     * @param whereCreated Returns the Digital Signature Transactions created before, after or in the declared range (optional)
     * @param whereSignatureStatus Returns the Digital Signature Transactions where at least one of the signers has the queried status (optional)
     * @param whereDocumentName Returns the Digital Signature Transactions that have into its documents the queried one (optional)
     * @param whereReason Returns the Digital Signature Transactions with the specified reason (optional)
     * @param whereSignatureName Returns the Digital Signature Transactions where the specified user is a signer, searched by its name (optional)
     * @param whereSignerGroup Returns the Digital Signature Transactions that have the specified group of signers (optional)
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
    public okhttp3.Call listDSTsCall(String organizationId, String whereSigner, String whereStatus, String whereTitle, String whereCreatedBy, String whereCreated, String whereSignatureStatus, String whereDocumentName, String whereReason, String whereSignatureName, String whereSignerGroup, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/signature-transactions"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (whereSigner != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_signer", whereSigner));
        }

        if (whereStatus != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_status", whereStatus));
        }

        if (whereTitle != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_title", whereTitle));
        }

        if (whereCreatedBy != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_created_by", whereCreatedBy));
        }

        if (whereCreated != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_created", whereCreated));
        }

        if (whereSignatureStatus != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_signature_status", whereSignatureStatus));
        }

        if (whereDocumentName != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_document_name", whereDocumentName));
        }

        if (whereReason != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_reason", whereReason));
        }

        if (whereSignatureName != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_signature_name", whereSignatureName));
        }

        if (whereSignerGroup != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("where_signer_group", whereSignerGroup));
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
    private okhttp3.Call listDSTsValidateBeforeCall(String organizationId, String whereSigner, String whereStatus, String whereTitle, String whereCreatedBy, String whereCreated, String whereSignatureStatus, String whereDocumentName, String whereReason, String whereSignatureName, String whereSignerGroup, Integer page, Integer count, String whereOrder, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling listDSTs(Async)");
        }
        

        okhttp3.Call localVarCall = listDSTsCall(organizationId, whereSigner, whereStatus, whereTitle, whereCreatedBy, whereCreated, whereSignatureStatus, whereDocumentName, whereReason, whereSignatureName, whereSignerGroup, page, count, whereOrder, _callback);
        return localVarCall;

    }

    /**
     * List the DSTs of an organization
     * This API allows to list the Digital Signature Transactions of an organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereSigner Returns the Digital Signature Transactions where the specified user is a signer, searched by its id (optional)
     * @param whereStatus Returns the Digital Signature Transactions with the specified status (optional)
     * @param whereTitle Returns the Digital Signature Transactions that have the specified title (optional)
     * @param whereCreatedBy Returns the Digital Signature Transactions created by the specified user (optional)
     * @param whereCreated Returns the Digital Signature Transactions created before, after or in the declared range (optional)
     * @param whereSignatureStatus Returns the Digital Signature Transactions where at least one of the signers has the queried status (optional)
     * @param whereDocumentName Returns the Digital Signature Transactions that have into its documents the queried one (optional)
     * @param whereReason Returns the Digital Signature Transactions with the specified reason (optional)
     * @param whereSignatureName Returns the Digital Signature Transactions where the specified user is a signer, searched by its name (optional)
     * @param whereSignerGroup Returns the Digital Signature Transactions that have the specified group of signers (optional)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return InlineResponse2008
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
    public InlineResponse2008 listDSTs(String organizationId, String whereSigner, String whereStatus, String whereTitle, String whereCreatedBy, String whereCreated, String whereSignatureStatus, String whereDocumentName, String whereReason, String whereSignatureName, String whereSignerGroup, Integer page, Integer count, String whereOrder) throws ApiException {
        ApiResponse<InlineResponse2008> localVarResp = listDSTsWithHttpInfo(organizationId, whereSigner, whereStatus, whereTitle, whereCreatedBy, whereCreated, whereSignatureStatus, whereDocumentName, whereReason, whereSignatureName, whereSignerGroup, page, count, whereOrder);
        return localVarResp.getData();
    }

    /**
     * List the DSTs of an organization
     * This API allows to list the Digital Signature Transactions of an organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereSigner Returns the Digital Signature Transactions where the specified user is a signer, searched by its id (optional)
     * @param whereStatus Returns the Digital Signature Transactions with the specified status (optional)
     * @param whereTitle Returns the Digital Signature Transactions that have the specified title (optional)
     * @param whereCreatedBy Returns the Digital Signature Transactions created by the specified user (optional)
     * @param whereCreated Returns the Digital Signature Transactions created before, after or in the declared range (optional)
     * @param whereSignatureStatus Returns the Digital Signature Transactions where at least one of the signers has the queried status (optional)
     * @param whereDocumentName Returns the Digital Signature Transactions that have into its documents the queried one (optional)
     * @param whereReason Returns the Digital Signature Transactions with the specified reason (optional)
     * @param whereSignatureName Returns the Digital Signature Transactions where the specified user is a signer, searched by its name (optional)
     * @param whereSignerGroup Returns the Digital Signature Transactions that have the specified group of signers (optional)
     * @param page Restricts the search to the chosen page (optional)
     * @param count Sets the number of users per page to display (optional, default to 100)
     * @param whereOrder The **where_order** query parameter takes one or more values separated by a comma and a space. The result will be ordered by the first value (ascending order is implied; a \&quot;**-**\&quot; in front of the value indicates descending order), then the second value and so on (optional)
     * @return ApiResponse&lt;InlineResponse2008&gt;
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
    public ApiResponse<InlineResponse2008> listDSTsWithHttpInfo(String organizationId, String whereSigner, String whereStatus, String whereTitle, String whereCreatedBy, String whereCreated, String whereSignatureStatus, String whereDocumentName, String whereReason, String whereSignatureName, String whereSignerGroup, Integer page, Integer count, String whereOrder) throws ApiException {
        okhttp3.Call localVarCall = listDSTsValidateBeforeCall(organizationId, whereSigner, whereStatus, whereTitle, whereCreatedBy, whereCreated, whereSignatureStatus, whereDocumentName, whereReason, whereSignatureName, whereSignerGroup, page, count, whereOrder, null);
        Type localVarReturnType = new TypeToken<InlineResponse2008>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List the DSTs of an organization (asynchronously)
     * This API allows to list the Digital Signature Transactions of an organization. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param whereSigner Returns the Digital Signature Transactions where the specified user is a signer, searched by its id (optional)
     * @param whereStatus Returns the Digital Signature Transactions with the specified status (optional)
     * @param whereTitle Returns the Digital Signature Transactions that have the specified title (optional)
     * @param whereCreatedBy Returns the Digital Signature Transactions created by the specified user (optional)
     * @param whereCreated Returns the Digital Signature Transactions created before, after or in the declared range (optional)
     * @param whereSignatureStatus Returns the Digital Signature Transactions where at least one of the signers has the queried status (optional)
     * @param whereDocumentName Returns the Digital Signature Transactions that have into its documents the queried one (optional)
     * @param whereReason Returns the Digital Signature Transactions with the specified reason (optional)
     * @param whereSignatureName Returns the Digital Signature Transactions where the specified user is a signer, searched by its name (optional)
     * @param whereSignerGroup Returns the Digital Signature Transactions that have the specified group of signers (optional)
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
    public okhttp3.Call listDSTsAsync(String organizationId, String whereSigner, String whereStatus, String whereTitle, String whereCreatedBy, String whereCreated, String whereSignatureStatus, String whereDocumentName, String whereReason, String whereSignatureName, String whereSignerGroup, Integer page, Integer count, String whereOrder, final ApiCallback<InlineResponse2008> _callback) throws ApiException {

        okhttp3.Call localVarCall = listDSTsValidateBeforeCall(organizationId, whereSigner, whereStatus, whereTitle, whereCreatedBy, whereCreated, whereSignatureStatus, whereDocumentName, whereReason, whereSignatureName, whereSignerGroup, page, count, whereOrder, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2008>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
