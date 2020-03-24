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
import signingToday.client.model.CreateDigitalSignatureTransaction;
import signingToday.client.model.DigitalSignatureTransaction;
import signingToday.client.model.ErrorResponse;
import signingToday.client.model.InstantiateDSTTemplate;
import signingToday.client.model.RobotAuthenticationToken;
import signingToday.client.model.RobotConfiguration;
import signingToday.client.model.ServiceFailureResponse;
import java.util.UUID;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for Bit4idPathgroupRobotsApi
 */
@Ignore
public class Bit4idPathgroupRobotsApiTest {

    private final Bit4idPathgroupRobotsApi api = new Bit4idPathgroupRobotsApi();

    
    /**
     * Clear a Robot authentication lifetime token
     *
     * This API allows to clear the Robot authentication lifetime token.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void robotAuthenticationDeleteTest() throws ApiException {
        String username = null;
        String domain = null;
        api.robotAuthenticationDelete(username, domain);

        // TODO: test validations
    }
    
    /**
     * Retrieve the Robot authentication lifetime token
     *
     * This API allows to generate or retrieves the Robot authentication lifetime token for the specified robot account, or the current logged in account. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void robotAuthenticationGetTest() throws ApiException {
        String username = null;
        String domain = null;
        RobotAuthenticationToken response = api.robotAuthenticationGet(username, domain);

        // TODO: test validations
    }
    
    /**
     * Retrieve the Robot configuration
     *
     * This API allows to retrieve the Robot configuration. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void robotConfigurationGetTest() throws ApiException {
        String username = null;
        String domain = null;
        RobotConfiguration response = api.robotConfigurationGet(username, domain);

        // TODO: test validations
    }
    
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
    
    /**
     * Create a new DST in one call
     *
     * This API allows to create a new DST with a more convenient interface for client applications. The purpose is to provide a method for the creation of a DST in order to semplify the integration into third part applications. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void robotDSTsPostTest() throws ApiException {
        CreateDigitalSignatureTransaction createDigitalSignatureTransaction = null;
        DigitalSignatureTransaction response = api.robotDSTsPost(createDigitalSignatureTransaction);

        // TODO: test validations
    }
    
    /**
     * Instantiate a DST from a template by robot
     *
     * This API allows to instantiate a DST from a template patching parts of its data structure. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void robotIdInstantiatePostTest() throws ApiException {
        UUID id = null;
        InstantiateDSTTemplate instantiateDSTTemplate = null;
        DigitalSignatureTransaction response = api.robotIdInstantiatePost(id, instantiateDSTTemplate);

        // TODO: test validations
    }
    
}
