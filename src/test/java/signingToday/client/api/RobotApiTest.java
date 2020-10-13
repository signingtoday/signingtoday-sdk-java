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
import signingToday.client.model.RobotConfiguration;
import signingToday.client.model.ServiceFailureResponse;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for RobotApi
 */
@Ignore
public class RobotApiTest {

    private final RobotApi api = new RobotApi();

    
    /**
     * Edit the Robot configuration
     *
     * This API allows to edit the Robot configuration. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void robotConfigurationPutTest() throws ApiException {
        RobotConfiguration robotConfiguration = null;
        String username = null;
        String domain = null;
        api.robotConfigurationPut(robotConfiguration, username, domain);

        // TODO: test validations
    }
    
}