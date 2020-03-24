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


import signingToday.client.model.DSTNote;
import signingToday.client.model.ErrorResponse;
import signingToday.client.model.InlineObject1;
import signingToday.client.model.ServiceFailureResponse;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DstNoteApi {
    private ApiClient localVarApiClient;

    public DstNoteApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DstNoteApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for dSTIdNoteGet
     * @param id The value of _the unique id_ (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DSTNotes </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call dSTIdNoteGetCall(UUID id, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/DST/{id}/note"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

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
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call dSTIdNoteGetValidateBeforeCall(UUID id, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling dSTIdNoteGet(Async)");
        }
        

        okhttp3.Call localVarCall = dSTIdNoteGetCall(id, _callback);
        return localVarCall;

    }

    /**
     * Retrieve the DSTNotes associated to the DST
     * This API allows to retrieve the DST Notes associated to the DST.
     * @param id The value of _the unique id_ (required)
     * @return List&lt;DSTNote&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DSTNotes </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public List<DSTNote> dSTIdNoteGet(UUID id) throws ApiException {
        ApiResponse<List<DSTNote>> localVarResp = dSTIdNoteGetWithHttpInfo(id);
        return localVarResp.getData();
    }

    /**
     * Retrieve the DSTNotes associated to the DST
     * This API allows to retrieve the DST Notes associated to the DST.
     * @param id The value of _the unique id_ (required)
     * @return ApiResponse&lt;List&lt;DSTNote&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DSTNotes </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<DSTNote>> dSTIdNoteGetWithHttpInfo(UUID id) throws ApiException {
        okhttp3.Call localVarCall = dSTIdNoteGetValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<List<DSTNote>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Retrieve the DSTNotes associated to the DST (asynchronously)
     * This API allows to retrieve the DST Notes associated to the DST.
     * @param id The value of _the unique id_ (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DSTNotes </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call dSTIdNoteGetAsync(UUID id, final ApiCallback<List<DSTNote>> _callback) throws ApiException {

        okhttp3.Call localVarCall = dSTIdNoteGetValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<List<DSTNote>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for dSTIdNoteNoteIdDelete
     * @param id The value of _the unique id_ (required)
     * @param noteId The reference of a DSTNote (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> The request has been satisfyied. No output. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call dSTIdNoteNoteIdDeleteCall(UUID id, Long noteId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/DST/{id}/note/{noteId}"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()))
            .replaceAll("\\{" + "noteId" + "\\}", localVarApiClient.escapeString(noteId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "*/*"
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
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call dSTIdNoteNoteIdDeleteValidateBeforeCall(UUID id, Long noteId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling dSTIdNoteNoteIdDelete(Async)");
        }
        
        // verify the required parameter 'noteId' is set
        if (noteId == null) {
            throw new ApiException("Missing the required parameter 'noteId' when calling dSTIdNoteNoteIdDelete(Async)");
        }
        

        okhttp3.Call localVarCall = dSTIdNoteNoteIdDeleteCall(id, noteId, _callback);
        return localVarCall;

    }

    /**
     * Delete a DSTNote
     * This API allows to delete a DSTNote.
     * @param id The value of _the unique id_ (required)
     * @param noteId The reference of a DSTNote (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> The request has been satisfyied. No output. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public void dSTIdNoteNoteIdDelete(UUID id, Long noteId) throws ApiException {
        dSTIdNoteNoteIdDeleteWithHttpInfo(id, noteId);
    }

    /**
     * Delete a DSTNote
     * This API allows to delete a DSTNote.
     * @param id The value of _the unique id_ (required)
     * @param noteId The reference of a DSTNote (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> The request has been satisfyied. No output. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> dSTIdNoteNoteIdDeleteWithHttpInfo(UUID id, Long noteId) throws ApiException {
        okhttp3.Call localVarCall = dSTIdNoteNoteIdDeleteValidateBeforeCall(id, noteId, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Delete a DSTNote (asynchronously)
     * This API allows to delete a DSTNote.
     * @param id The value of _the unique id_ (required)
     * @param noteId The reference of a DSTNote (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> The request has been satisfyied. No output. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call dSTIdNoteNoteIdDeleteAsync(UUID id, Long noteId, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = dSTIdNoteNoteIdDeleteValidateBeforeCall(id, noteId, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for dSTIdNoteNoteIdPut
     * @param id The value of _the unique id_ (required)
     * @param noteId The reference of a DSTNote (required)
     * @param dsTNote DSTNote replacing current object. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated DSTNote. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Result of a client passing incorrect or invalid data. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call dSTIdNoteNoteIdPutCall(UUID id, Long noteId, DSTNote dsTNote, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = dsTNote;

        // create path and map variables
        String localVarPath = "/DST/{id}/note/{noteId}"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()))
            .replaceAll("\\{" + "noteId" + "\\}", localVarApiClient.escapeString(noteId.toString()));

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
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "OAuth2" };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call dSTIdNoteNoteIdPutValidateBeforeCall(UUID id, Long noteId, DSTNote dsTNote, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling dSTIdNoteNoteIdPut(Async)");
        }
        
        // verify the required parameter 'noteId' is set
        if (noteId == null) {
            throw new ApiException("Missing the required parameter 'noteId' when calling dSTIdNoteNoteIdPut(Async)");
        }
        
        // verify the required parameter 'dsTNote' is set
        if (dsTNote == null) {
            throw new ApiException("Missing the required parameter 'dsTNote' when calling dSTIdNoteNoteIdPut(Async)");
        }
        

        okhttp3.Call localVarCall = dSTIdNoteNoteIdPutCall(id, noteId, dsTNote, _callback);
        return localVarCall;

    }

    /**
     * Edit a DSTNote
     * This API allows to edit a DSTNote.
     * @param id The value of _the unique id_ (required)
     * @param noteId The reference of a DSTNote (required)
     * @param dsTNote DSTNote replacing current object. (required)
     * @return DSTNote
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated DSTNote. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Result of a client passing incorrect or invalid data. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public DSTNote dSTIdNoteNoteIdPut(UUID id, Long noteId, DSTNote dsTNote) throws ApiException {
        ApiResponse<DSTNote> localVarResp = dSTIdNoteNoteIdPutWithHttpInfo(id, noteId, dsTNote);
        return localVarResp.getData();
    }

    /**
     * Edit a DSTNote
     * This API allows to edit a DSTNote.
     * @param id The value of _the unique id_ (required)
     * @param noteId The reference of a DSTNote (required)
     * @param dsTNote DSTNote replacing current object. (required)
     * @return ApiResponse&lt;DSTNote&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated DSTNote. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Result of a client passing incorrect or invalid data. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<DSTNote> dSTIdNoteNoteIdPutWithHttpInfo(UUID id, Long noteId, DSTNote dsTNote) throws ApiException {
        okhttp3.Call localVarCall = dSTIdNoteNoteIdPutValidateBeforeCall(id, noteId, dsTNote, null);
        Type localVarReturnType = new TypeToken<DSTNote>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Edit a DSTNote (asynchronously)
     * This API allows to edit a DSTNote.
     * @param id The value of _the unique id_ (required)
     * @param noteId The reference of a DSTNote (required)
     * @param dsTNote DSTNote replacing current object. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated DSTNote. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Result of a client passing incorrect or invalid data. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call dSTIdNoteNoteIdPutAsync(UUID id, Long noteId, DSTNote dsTNote, final ApiCallback<DSTNote> _callback) throws ApiException {

        okhttp3.Call localVarCall = dSTIdNoteNoteIdPutValidateBeforeCall(id, noteId, dsTNote, _callback);
        Type localVarReturnType = new TypeToken<DSTNote>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for dSTIdNotePost
     * @param id The value of _the unique id_ (required)
     * @param inlineObject1  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DSTNote just added </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Cannot satisfy the request because the resource is in an illegal status. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call dSTIdNotePostCall(UUID id, InlineObject1 inlineObject1, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = inlineObject1;

        // create path and map variables
        String localVarPath = "/DST/{id}/note"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

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
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "OAuth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call dSTIdNotePostValidateBeforeCall(UUID id, InlineObject1 inlineObject1, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling dSTIdNotePost(Async)");
        }
        

        okhttp3.Call localVarCall = dSTIdNotePostCall(id, inlineObject1, _callback);
        return localVarCall;

    }

    /**
     * Append a new DSTNote
     * This API allows to append a new DSTNote to the DST.
     * @param id The value of _the unique id_ (required)
     * @param inlineObject1  (optional)
     * @return DSTNote
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DSTNote just added </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Cannot satisfy the request because the resource is in an illegal status. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public DSTNote dSTIdNotePost(UUID id, InlineObject1 inlineObject1) throws ApiException {
        ApiResponse<DSTNote> localVarResp = dSTIdNotePostWithHttpInfo(id, inlineObject1);
        return localVarResp.getData();
    }

    /**
     * Append a new DSTNote
     * This API allows to append a new DSTNote to the DST.
     * @param id The value of _the unique id_ (required)
     * @param inlineObject1  (optional)
     * @return ApiResponse&lt;DSTNote&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DSTNote just added </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Cannot satisfy the request because the resource is in an illegal status. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<DSTNote> dSTIdNotePostWithHttpInfo(UUID id, InlineObject1 inlineObject1) throws ApiException {
        okhttp3.Call localVarCall = dSTIdNotePostValidateBeforeCall(id, inlineObject1, null);
        Type localVarReturnType = new TypeToken<DSTNote>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Append a new DSTNote (asynchronously)
     * This API allows to append a new DSTNote to the DST.
     * @param id The value of _the unique id_ (required)
     * @param inlineObject1  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DSTNote just added </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User authentication was not effective (e.g. not provided, invalid or expired). </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User is not allowed to perform the request. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The resource was not found. </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Cannot satisfy the request because the resource is in an illegal status. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal failure of the service. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call dSTIdNotePostAsync(UUID id, InlineObject1 inlineObject1, final ApiCallback<DSTNote> _callback) throws ApiException {

        okhttp3.Call localVarCall = dSTIdNotePostValidateBeforeCall(id, inlineObject1, _callback);
        Type localVarReturnType = new TypeToken<DSTNote>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
