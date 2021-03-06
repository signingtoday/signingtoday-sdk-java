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

import signingToday.client.ApiException;
import signingToday.client.model.AlfrescoSync;
import signingToday.client.model.ErrorResponse;
import java.io.File;
import signingToday.client.model.Organization;
import signingToday.client.model.OrganizationsGetResponse;
import signingToday.client.model.ServiceFailureResponse;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for BackofficeApi
 */
@Ignore
public class BackofficeApiTest {

    private final BackofficeApi api = new BackofficeApi();

    
    /**
     * Sync all completed DSTs on Alfresco
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationIdAlfrescoSyncGetTest() throws ApiException {
        String id = null;
        AlfrescoSync response = api.organizationIdAlfrescoSyncGet(id);

        // TODO: test validations
    }
    
    /**
     * Sync all completed DSTs on Alfresco
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationIdAlfrescoSyncPostTest() throws ApiException {
        String id = null;
        AlfrescoSync alfrescoSync = null;
        api.organizationIdAlfrescoSyncPost(id, alfrescoSync);

        // TODO: test validations
    }
    
    /**
     * Enable or disable an Organization account.
     *
     * Enable or disable an Organization.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationIdDeleteTest() throws ApiException {
        String id = null;
        Boolean enabled = null;
        api.organizationIdDelete(id, enabled);

        // TODO: test validations
    }
    
    /**
     * Retrieve info on one organization
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationIdGetTest() throws ApiException {
        String id = null;
        Organization response = api.organizationIdGet(id);

        // TODO: test validations
    }
    
    /**
     * Retrieve public resources
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationIdPublicGetTest() throws ApiException {
        String res = null;
        String id = null;
        File response = api.organizationIdPublicGet(res, id);

        // TODO: test validations
    }
    
    /**
     * Update info on one organization
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationIdPutTest() throws ApiException {
        String id = null;
        Organization organization = null;
        api.organizationIdPut(id, organization);

        // TODO: test validations
    }
    
    /**
     * Get an organization resource
     *
     * Get an organization resource
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationIdResourceGetTest() throws ApiException {
        String id = null;
        String resPath = null;
        File response = api.organizationIdResourceGet(id, resPath);

        // TODO: test validations
    }
    
    /**
     * Create or overwrite an organization resource
     *
     * Create or overwrite an organization resource
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationIdResourcePutTest() throws ApiException {
        String id = null;
        String resPath = null;
        File file = null;
        api.organizationIdResourcePut(id, resPath, file);

        // TODO: test validations
    }
    
    /**
     * Delete an organization resource
     *
     * Deletes a Resource.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationResourceIdDeleteTest() throws ApiException {
        String id = null;
        String resPath = null;
        api.organizationResourceIdDelete(id, resPath);

        // TODO: test validations
    }
    
    /**
     * List all the organization resources
     *
     * List all the organization resources.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationResourcesGetTest() throws ApiException {
        String id = null;
        List<String> response = api.organizationResourcesGet(id);

        // TODO: test validations
    }
    
    /**
     * Retrieve organization tags
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationTagsGetTest() throws ApiException {
        List<String> response = api.organizationTagsGet();

        // TODO: test validations
    }
    
    /**
     * Get the list of organizations
     *
     * Get the list of organizations
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationsGetTest() throws ApiException {
        Integer $top = null;
        Long $skip = null;
        Boolean $count = null;
        String $filter = null;
        OrganizationsGetResponse response = api.organizationsGet($top, $skip, $count, $filter);

        // TODO: test validations
    }
    
    /**
     * Create a new organization
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void organizationsPostTest() throws ApiException {
        Organization organization = null;
        api.organizationsPost(organization);

        // TODO: test validations
    }
    
}
