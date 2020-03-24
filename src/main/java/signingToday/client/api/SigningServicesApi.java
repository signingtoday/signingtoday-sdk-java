/*
 * Signing Today Web
 * *Signing Today* is the perfect Digital Signature Gateway. Whenever in Your workflow You need to add one or more Digital Signatures to Your document, *Signing Today* is the right choice. You prepare Your documents, *Signing Today* takes care of all the rest: send invitations (`signature tickets`) to signers, collects their signatures, send You back the signed document. Integrating *Signing Today* in Your existing applications is very easy. Just follow these API specifications and get inspired by the many examples presented hereafter. 
 *
 * The version of the OpenAPI document: 2.0.0
 * 
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


import signingToday.client.model.ErrorResponse;
import signingToday.client.model.InlineObject8;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SigningServicesApi {
    private ApiClient localVarApiClient;

    public SigningServicesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SigningServicesApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for signServiceOpen
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call signServiceOpenCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/sign-service/open";

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

        String[] localVarAuthNames = new String[] { "OAuth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call signServiceOpenValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = signServiceOpenCall(_callback);
        return localVarCall;

    }

    /**
     * sign-service open post
     * description bla bla
     * @return Object
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public Object signServiceOpen() throws ApiException {
        ApiResponse<Object> localVarResp = signServiceOpenWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * sign-service open post
     * description bla bla
     * @return ApiResponse&lt;Object&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Object> signServiceOpenWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = signServiceOpenValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * sign-service open post (asynchronously)
     * description bla bla
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call signServiceOpenAsync(final ApiCallback<Object> _callback) throws ApiException {

        okhttp3.Call localVarCall = signServiceOpenValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for signServiceOpenId
     * @param transactionId  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call signServiceOpenIdCall(String transactionId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/sign-service/open/{transaction-id}"
            .replaceAll("\\{" + "transaction-id" + "\\}", localVarApiClient.escapeString(transactionId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json", "*/*"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "OAuth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call signServiceOpenIdValidateBeforeCall(String transactionId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'transactionId' is set
        if (transactionId == null) {
            throw new ApiException("Missing the required parameter 'transactionId' when calling signServiceOpenId(Async)");
        }
        

        okhttp3.Call localVarCall = signServiceOpenIdCall(transactionId, _callback);
        return localVarCall;

    }

    /**
     * sign-service-open-transaction-id post
     * 
     * @param transactionId  (required)
     * @return Object
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
     </table>
     */
    public Object signServiceOpenId(String transactionId) throws ApiException {
        ApiResponse<Object> localVarResp = signServiceOpenIdWithHttpInfo(transactionId);
        return localVarResp.getData();
    }

    /**
     * sign-service-open-transaction-id post
     * 
     * @param transactionId  (required)
     * @return ApiResponse&lt;Object&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Object> signServiceOpenIdWithHttpInfo(String transactionId) throws ApiException {
        okhttp3.Call localVarCall = signServiceOpenIdValidateBeforeCall(transactionId, null);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * sign-service-open-transaction-id post (asynchronously)
     * 
     * @param transactionId  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call signServiceOpenIdAsync(String transactionId, final ApiCallback<Object> _callback) throws ApiException {

        okhttp3.Call localVarCall = signServiceOpenIdValidateBeforeCall(transactionId, _callback);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for signatureIdPerformIdPost
     * @param signatureId  (required)
     * @param identityId  (required)
     * @param inlineObject8  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call signatureIdPerformIdPostCall(String signatureId, String identityId, InlineObject8 inlineObject8, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = inlineObject8;

        // create path and map variables
        String localVarPath = "/sign-service/{signature-id}/perform/{identity-id}"
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

        String[] localVarAuthNames = new String[] { "OAuth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call signatureIdPerformIdPostValidateBeforeCall(String signatureId, String identityId, InlineObject8 inlineObject8, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'signatureId' is set
        if (signatureId == null) {
            throw new ApiException("Missing the required parameter 'signatureId' when calling signatureIdPerformIdPost(Async)");
        }
        
        // verify the required parameter 'identityId' is set
        if (identityId == null) {
            throw new ApiException("Missing the required parameter 'identityId' when calling signatureIdPerformIdPost(Async)");
        }
        

        okhttp3.Call localVarCall = signatureIdPerformIdPostCall(signatureId, identityId, inlineObject8, _callback);
        return localVarCall;

    }

    /**
     * sign-service-signature-id-perform-identity-id post
     * 
     * @param signatureId  (required)
     * @param identityId  (required)
     * @param inlineObject8  (optional)
     * @return Object
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public Object signatureIdPerformIdPost(String signatureId, String identityId, InlineObject8 inlineObject8) throws ApiException {
        ApiResponse<Object> localVarResp = signatureIdPerformIdPostWithHttpInfo(signatureId, identityId, inlineObject8);
        return localVarResp.getData();
    }

    /**
     * sign-service-signature-id-perform-identity-id post
     * 
     * @param signatureId  (required)
     * @param identityId  (required)
     * @param inlineObject8  (optional)
     * @return ApiResponse&lt;Object&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Object> signatureIdPerformIdPostWithHttpInfo(String signatureId, String identityId, InlineObject8 inlineObject8) throws ApiException {
        okhttp3.Call localVarCall = signatureIdPerformIdPostValidateBeforeCall(signatureId, identityId, inlineObject8, null);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * sign-service-signature-id-perform-identity-id post (asynchronously)
     * 
     * @param signatureId  (required)
     * @param identityId  (required)
     * @param inlineObject8  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call signatureIdPerformIdPostAsync(String signatureId, String identityId, InlineObject8 inlineObject8, final ApiCallback<Object> _callback) throws ApiException {

        okhttp3.Call localVarCall = signatureIdPerformIdPostValidateBeforeCall(signatureId, identityId, inlineObject8, _callback);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
