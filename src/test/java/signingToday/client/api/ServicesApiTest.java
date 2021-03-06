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
import signingToday.client.model.ErrorResponse;
import java.io.File;
import signingToday.client.model.InlineObject;
import signingToday.client.model.InlineObject4;
import signingToday.client.model.InlineResponse200;
import signingToday.client.model.ServiceFailureResponse;
import java.util.UUID;
import signingToday.client.model.User;
import signingToday.client.model.UserSyncReport;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ServicesApi
 */
@Ignore
public class ServicesApiTest {

    private final ServicesApi api = new ServicesApi();

    
    /**
     * Consume a token to change the password
     *
     * This API allows to change the password by consuming a token.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void authChangePasswordPostTest() throws ApiException {
        String passwordToken = null;
        String body = null;
        api.authChangePasswordPost(passwordToken, body);

        // TODO: test validations
    }
    
    /**
     * Request to recover own password
     *
     * This API requests to recover the own password.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void authPasswordLostGetTest() throws ApiException {
        String username = null;
        String domain = null;
        api.authPasswordLostGet(username, domain);

        // TODO: test validations
    }
    
    /**
     * Reset a user password with superuser
     *
     * This API allows to reset the password of a user. This is possible when the request is performed with a superuser.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void authPasswordResetGetTest() throws ApiException {
        String username = null;
        String domain = null;
        api.authPasswordResetGet(username, domain);

        // TODO: test validations
    }
    
    /**
     * Reset your own password
     *
     * This API allows to reset your own password knowing the previous one with a logged user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void authPasswordResetPostTest() throws ApiException {
        InlineObject4 inlineObject4 = null;
        api.authPasswordResetPost(inlineObject4);

        // TODO: test validations
    }
    
    /**
     * Get token to change password
     *
     * This API allows to get a password token to use in order to change a password.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void authPasswordTokenGetTest() throws ApiException {
        List<Object> response = api.authPasswordTokenGet();

        // TODO: test validations
    }
    
    /**
     * Register or Update a SAML user
     *
     * This API allows to register or Update a SAML user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void authSamlPostTest() throws ApiException {
        String domain = null;
        String idToken1 = null;
        String idToken2 = null;
        api.authSamlPost(domain, idToken1, idToken2);

        // TODO: test validations
    }
    
    /**
     * Return the current logged in user
     *
     * This API allows to retrieve the current logged in user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void authUserTest() throws ApiException {
        User response = api.authUser();

        // TODO: test validations
    }
    
    /**
     * Retrieve the App configuration
     *
     * This API allows to get the public configuration associated to the application. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void configurationGetTest() throws ApiException {
        Map<String, Object> response = api.configurationGet();

        // TODO: test validations
    }
    
    /**
     * Log out current user terminating the session
     *
     * This API allows to Log out current user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void logoutUserTest() throws ApiException {
        api.logoutUser();

        // TODO: test validations
    }
    
    /**
     * Get the bearer token
     *
     * This API allows to get the token needed to access other APIs through the OAuth2 authentication.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void oauthTokenPostTest() throws ApiException {
        String username = null;
        String password = null;
        String grantType = null;
        InlineResponse200 response = api.oauthTokenPost(username, password, grantType);

        // TODO: test validations
    }
    
    /**
     * Retrieve a Resource (of service)
     *
     * This API allows to extract thumbnails from a PDF Resource.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pdfResourceIdThumbsGetTest() throws ApiException {
        UUID id = null;
        Integer page = null;
        Integer width = null;
        File response = api.pdfResourceIdThumbsGet(id, page, width);

        // TODO: test validations
    }
    
    /**
     * Change the password of a service user
     *
     * This API allows to change the password of a **service user**. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void serviceChangePasswordPostTest() throws ApiException {
        String username = null;
        String domain = null;
        String body = null;
        api.serviceChangePasswordPost(username, domain, body);

        // TODO: test validations
    }
    
    /**
     * Sync user accounts
     *
     * This API allows to sync user accounts.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void serviceUsersSyncPostTest() throws ApiException {
        List<InlineObject> inlineObject = null;
        UserSyncReport response = api.serviceUsersSyncPost(inlineObject);

        // TODO: test validations
    }
    
}
