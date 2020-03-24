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
import signingToday.client.model.InlineObject6;
import signingToday.client.model.NotificationsResponse;
import signingToday.client.model.ServiceFailureResponse;
import java.util.UUID;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for Bit4idPathgroupNotificationsApi
 */
@Ignore
public class Bit4idPathgroupNotificationsApiTest {

    private final Bit4idPathgroupNotificationsApi api = new Bit4idPathgroupNotificationsApi();

    
    /**
     * Clear Notifications for a DST
     *
     * This API notifies that a user consumed all active notifications for a DST.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void notificationsDstIdDeleteTest() throws ApiException {
        UUID id = null;
        api.notificationsDstIdDelete(id);

        // TODO: test validations
    }
    
    /**
     * Get latest DST Notifications
     *
     * This APIs allows to get latest user Notifications for DSTs sorted desc by time.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void notificationsDstsGetTest() throws ApiException {
        Integer $top = null;
        Long $skip = null;
        Boolean $count = null;
        NotificationsResponse response = api.notificationsDstsGet($top, $skip, $count);

        // TODO: test validations
    }
    
    /**
     * Clear a registered push notification token
     *
     * This API deregister a deviceId from the push notifications.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void notificationsPushTokenDeleteTest() throws ApiException {
        String deviceId = null;
        api.notificationsPushTokenDelete(deviceId);

        // TODO: test validations
    }
    
    /**
     * Register a token for push notifications
     *
     * This API allows to register a token for push notifications. Only trusted deviceId can be registered. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void notificationsPushTokenPostTest() throws ApiException {
        InlineObject6 inlineObject6 = null;
        api.notificationsPushTokenPost(inlineObject6);

        // TODO: test validations
    }
    
}
