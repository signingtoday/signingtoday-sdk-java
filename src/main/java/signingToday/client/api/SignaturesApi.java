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


import signingToday.client.model.AutomaticSignature;
import signingToday.client.model.Id;
import signingToday.client.model.InlineObject3;
import signingToday.client.model.InlineObject4;
import signingToday.client.model.InlineObject5;
import signingToday.client.model.InlineResponse20011;
import signingToday.client.model.InlineResponse20012;
import signingToday.client.model.InlineResponse20013;
import signingToday.client.model.InlineResponse2013;
import signingToday.client.model.InlineResponse2014;
import signingToday.client.model.InlineResponse401;
import signingToday.client.model.InlineResponse403;
import signingToday.client.model.InlineResponse404;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignaturesApi {
    private ApiClient localVarApiClient;

    public SignaturesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SignaturesApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for createChannel
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
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
    public okhttp3.Call createChannelCall(String organizationId, Id dstId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization-id}/channels/{dst-id}"
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
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createChannelValidateBeforeCall(String organizationId, Id dstId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling createChannel(Async)");
        }
        
        // verify the required parameter 'dstId' is set
        if (dstId == null) {
            throw new ApiException("Missing the required parameter 'dstId' when calling createChannel(Async)");
        }
        

        okhttp3.Call localVarCall = createChannelCall(organizationId, dstId, _callback);
        return localVarCall;

    }

    /**
     * Create a channel
     * This API allows to create a channel in order to dispose, by another API, the scheduling of a signature. These two APIs are used to integrate SigningToday into another application. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
     * @return InlineResponse2014
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
    public InlineResponse2014 createChannel(String organizationId, Id dstId) throws ApiException {
        ApiResponse<InlineResponse2014> localVarResp = createChannelWithHttpInfo(organizationId, dstId);
        return localVarResp.getData();
    }

    /**
     * Create a channel
     * This API allows to create a channel in order to dispose, by another API, the scheduling of a signature. These two APIs are used to integrate SigningToday into another application. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
     * @return ApiResponse&lt;InlineResponse2014&gt;
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
    public ApiResponse<InlineResponse2014> createChannelWithHttpInfo(String organizationId, Id dstId) throws ApiException {
        okhttp3.Call localVarCall = createChannelValidateBeforeCall(organizationId, dstId, null);
        Type localVarReturnType = new TypeToken<InlineResponse2014>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create a channel (asynchronously)
     * This API allows to create a channel in order to dispose, by another API, the scheduling of a signature. These two APIs are used to integrate SigningToday into another application. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param dstId The **dst-id** is the uuid code that identifies a digital signature transaction. It is used as a path parameter to filter the requested operation to the specified **dst**  (required)
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
    public okhttp3.Call createChannelAsync(String organizationId, Id dstId, final ApiCallback<InlineResponse2014> _callback) throws ApiException {

        okhttp3.Call localVarCall = createChannelValidateBeforeCall(organizationId, dstId, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2014>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for declineDST
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param inlineObject5  (required)
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
        <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call declineDSTCall(String organizationId, Id signatureId, InlineObject5 inlineObject5, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = inlineObject5;

        // create path and map variables
        String localVarPath = "/{organization-id}/signatures/{signature-id}/decline"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "signature-id" + "\\}", localVarApiClient.escapeString(signatureId.toString()));

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
    private okhttp3.Call declineDSTValidateBeforeCall(String organizationId, Id signatureId, InlineObject5 inlineObject5, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling declineDST(Async)");
        }
        
        // verify the required parameter 'signatureId' is set
        if (signatureId == null) {
            throw new ApiException("Missing the required parameter 'signatureId' when calling declineDST(Async)");
        }
        
        // verify the required parameter 'inlineObject5' is set
        if (inlineObject5 == null) {
            throw new ApiException("Missing the required parameter 'inlineObject5' when calling declineDST(Async)");
        }
        

        okhttp3.Call localVarCall = declineDSTCall(organizationId, signatureId, inlineObject5, _callback);
        return localVarCall;

    }

    /**
     * Decline a Digital Signature Transaction
     * This API allows to decline the Signature of a digital signature transaction providing a reason. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param inlineObject5  (required)
     * @return InlineResponse2013
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2013 declineDST(String organizationId, Id signatureId, InlineObject5 inlineObject5) throws ApiException {
        ApiResponse<InlineResponse2013> localVarResp = declineDSTWithHttpInfo(organizationId, signatureId, inlineObject5);
        return localVarResp.getData();
    }

    /**
     * Decline a Digital Signature Transaction
     * This API allows to decline the Signature of a digital signature transaction providing a reason. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param inlineObject5  (required)
     * @return ApiResponse&lt;InlineResponse2013&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2013> declineDSTWithHttpInfo(String organizationId, Id signatureId, InlineObject5 inlineObject5) throws ApiException {
        okhttp3.Call localVarCall = declineDSTValidateBeforeCall(organizationId, signatureId, inlineObject5, null);
        Type localVarReturnType = new TypeToken<InlineResponse2013>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Decline a Digital Signature Transaction (asynchronously)
     * This API allows to decline the Signature of a digital signature transaction providing a reason. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param inlineObject5  (required)
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
        <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call declineDSTAsync(String organizationId, Id signatureId, InlineObject5 inlineObject5, final ApiCallback<InlineResponse2013> _callback) throws ApiException {

        okhttp3.Call localVarCall = declineDSTValidateBeforeCall(organizationId, signatureId, inlineObject5, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2013>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for performDST
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param automaticSignature Automatic Signature description (required)
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
    public okhttp3.Call performDSTCall(String organizationId, Id signatureId, AutomaticSignature automaticSignature, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = automaticSignature;

        // create path and map variables
        String localVarPath = "/{organization-id}/signatures/{signature-id}/perform"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "signature-id" + "\\}", localVarApiClient.escapeString(signatureId.toString()));

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
    private okhttp3.Call performDSTValidateBeforeCall(String organizationId, Id signatureId, AutomaticSignature automaticSignature, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling performDST(Async)");
        }
        
        // verify the required parameter 'signatureId' is set
        if (signatureId == null) {
            throw new ApiException("Missing the required parameter 'signatureId' when calling performDST(Async)");
        }
        
        // verify the required parameter 'automaticSignature' is set
        if (automaticSignature == null) {
            throw new ApiException("Missing the required parameter 'automaticSignature' when calling performDST(Async)");
        }
        

        okhttp3.Call localVarCall = performDSTCall(organizationId, signatureId, automaticSignature, _callback);
        return localVarCall;

    }

    /**
     * Sign a DST with an automatic signer
     * This API allows to sign a Digital Signature Transaction with an automatic signer certificate. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param automaticSignature Automatic Signature description (required)
     * @return InlineResponse20011
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
    public InlineResponse20011 performDST(String organizationId, Id signatureId, AutomaticSignature automaticSignature) throws ApiException {
        ApiResponse<InlineResponse20011> localVarResp = performDSTWithHttpInfo(organizationId, signatureId, automaticSignature);
        return localVarResp.getData();
    }

    /**
     * Sign a DST with an automatic signer
     * This API allows to sign a Digital Signature Transaction with an automatic signer certificate. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param automaticSignature Automatic Signature description (required)
     * @return ApiResponse&lt;InlineResponse20011&gt;
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
    public ApiResponse<InlineResponse20011> performDSTWithHttpInfo(String organizationId, Id signatureId, AutomaticSignature automaticSignature) throws ApiException {
        okhttp3.Call localVarCall = performDSTValidateBeforeCall(organizationId, signatureId, automaticSignature, null);
        Type localVarReturnType = new TypeToken<InlineResponse20011>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Sign a DST with an automatic signer (asynchronously)
     * This API allows to sign a Digital Signature Transaction with an automatic signer certificate. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param automaticSignature Automatic Signature description (required)
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
    public okhttp3.Call performDSTAsync(String organizationId, Id signatureId, AutomaticSignature automaticSignature, final ApiCallback<InlineResponse20011> _callback) throws ApiException {

        okhttp3.Call localVarCall = performDSTValidateBeforeCall(organizationId, signatureId, automaticSignature, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse20011>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for performSignature
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param inlineObject3  (required)
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
    public okhttp3.Call performSignatureCall(String organizationId, Id signatureId, Id identityId, InlineObject3 inlineObject3, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = inlineObject3;

        // create path and map variables
        String localVarPath = "/{organization-id}/signatures/{signature-id}/perform/{identity-id}"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "signature-id" + "\\}", localVarApiClient.escapeString(signatureId.toString()))
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
    private okhttp3.Call performSignatureValidateBeforeCall(String organizationId, Id signatureId, Id identityId, InlineObject3 inlineObject3, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling performSignature(Async)");
        }
        
        // verify the required parameter 'signatureId' is set
        if (signatureId == null) {
            throw new ApiException("Missing the required parameter 'signatureId' when calling performSignature(Async)");
        }
        
        // verify the required parameter 'identityId' is set
        if (identityId == null) {
            throw new ApiException("Missing the required parameter 'identityId' when calling performSignature(Async)");
        }
        
        // verify the required parameter 'inlineObject3' is set
        if (inlineObject3 == null) {
            throw new ApiException("Missing the required parameter 'inlineObject3' when calling performSignature(Async)");
        }
        

        okhttp3.Call localVarCall = performSignatureCall(organizationId, signatureId, identityId, inlineObject3, _callback);
        return localVarCall;

    }

    /**
     * Perform a Signature
     * This API allows to integrate SigningToday into another application. Through this endpoint it is possible to schedule a signature into engine. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param inlineObject3  (required)
     * @return InlineResponse20012
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
    public InlineResponse20012 performSignature(String organizationId, Id signatureId, Id identityId, InlineObject3 inlineObject3) throws ApiException {
        ApiResponse<InlineResponse20012> localVarResp = performSignatureWithHttpInfo(organizationId, signatureId, identityId, inlineObject3);
        return localVarResp.getData();
    }

    /**
     * Perform a Signature
     * This API allows to integrate SigningToday into another application. Through this endpoint it is possible to schedule a signature into engine. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param inlineObject3  (required)
     * @return ApiResponse&lt;InlineResponse20012&gt;
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
    public ApiResponse<InlineResponse20012> performSignatureWithHttpInfo(String organizationId, Id signatureId, Id identityId, InlineObject3 inlineObject3) throws ApiException {
        okhttp3.Call localVarCall = performSignatureValidateBeforeCall(organizationId, signatureId, identityId, inlineObject3, null);
        Type localVarReturnType = new TypeToken<InlineResponse20012>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Perform a Signature (asynchronously)
     * This API allows to integrate SigningToday into another application. Through this endpoint it is possible to schedule a signature into engine. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param identityId The **identity-id** is the uuid code that identifies an identity in the wallet of an user. It is, as well, used to restrict the requested operation to the scope of that identity  (required)
     * @param inlineObject3  (required)
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
    public okhttp3.Call performSignatureAsync(String organizationId, Id signatureId, Id identityId, InlineObject3 inlineObject3, final ApiCallback<InlineResponse20012> _callback) throws ApiException {

        okhttp3.Call localVarCall = performSignatureValidateBeforeCall(organizationId, signatureId, identityId, inlineObject3, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse20012>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for performSignatureWithSession
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param inlineObject4  (required)
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
    public okhttp3.Call performSignatureWithSessionCall(String organizationId, Id signatureId, InlineObject4 inlineObject4, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = inlineObject4;

        // create path and map variables
        String localVarPath = "/{organization-id}/signatures/{signature-id}/session-perform"
            .replaceAll("\\{" + "organization-id" + "\\}", localVarApiClient.escapeString(organizationId.toString()))
            .replaceAll("\\{" + "signature-id" + "\\}", localVarApiClient.escapeString(signatureId.toString()));

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
    private okhttp3.Call performSignatureWithSessionValidateBeforeCall(String organizationId, Id signatureId, InlineObject4 inlineObject4, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling performSignatureWithSession(Async)");
        }
        
        // verify the required parameter 'signatureId' is set
        if (signatureId == null) {
            throw new ApiException("Missing the required parameter 'signatureId' when calling performSignatureWithSession(Async)");
        }
        
        // verify the required parameter 'inlineObject4' is set
        if (inlineObject4 == null) {
            throw new ApiException("Missing the required parameter 'inlineObject4' when calling performSignatureWithSession(Async)");
        }
        

        okhttp3.Call localVarCall = performSignatureWithSessionCall(organizationId, signatureId, inlineObject4, _callback);
        return localVarCall;

    }

    /**
     * Perform a Signature with session
     * This API allows to perform one or more signatures within the same session. This way is possible, in the scenario of a simple signature for example, to perform multiple signatures using the same _one time password_. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param inlineObject4  (required)
     * @return InlineResponse20013
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
    public InlineResponse20013 performSignatureWithSession(String organizationId, Id signatureId, InlineObject4 inlineObject4) throws ApiException {
        ApiResponse<InlineResponse20013> localVarResp = performSignatureWithSessionWithHttpInfo(organizationId, signatureId, inlineObject4);
        return localVarResp.getData();
    }

    /**
     * Perform a Signature with session
     * This API allows to perform one or more signatures within the same session. This way is possible, in the scenario of a simple signature for example, to perform multiple signatures using the same _one time password_. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param inlineObject4  (required)
     * @return ApiResponse&lt;InlineResponse20013&gt;
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
    public ApiResponse<InlineResponse20013> performSignatureWithSessionWithHttpInfo(String organizationId, Id signatureId, InlineObject4 inlineObject4) throws ApiException {
        okhttp3.Call localVarCall = performSignatureWithSessionValidateBeforeCall(organizationId, signatureId, inlineObject4, null);
        Type localVarReturnType = new TypeToken<InlineResponse20013>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Perform a Signature with session (asynchronously)
     * This API allows to perform one or more signatures within the same session. This way is possible, in the scenario of a simple signature for example, to perform multiple signatures using the same _one time password_. 
     * @param organizationId The **organization-id** represents an organization that is included in the SigninToday application, also know as **slug** and it is used as a path parameter to restrict the asked functionality to the specified organization  (required)
     * @param signatureId The **signature-id** is the uuid code that identifies a signature that has to be performed into a digital signature transaction. It is usually used in the API endpoints to perform, decline or cancel a digital signature transaction  (required)
     * @param inlineObject4  (required)
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
    public okhttp3.Call performSignatureWithSessionAsync(String organizationId, Id signatureId, InlineObject4 inlineObject4, final ApiCallback<InlineResponse20013> _callback) throws ApiException {

        okhttp3.Call localVarCall = performSignatureWithSessionValidateBeforeCall(organizationId, signatureId, inlineObject4, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse20013>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
