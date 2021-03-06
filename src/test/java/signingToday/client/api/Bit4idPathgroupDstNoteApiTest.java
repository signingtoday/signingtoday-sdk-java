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
import signingToday.client.model.DSTNote;
import signingToday.client.model.ErrorResponse;
import signingToday.client.model.InlineObject1;
import signingToday.client.model.ServiceFailureResponse;
import java.util.UUID;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for Bit4idPathgroupDstNoteApi
 */
@Ignore
public class Bit4idPathgroupDstNoteApiTest {

    private final Bit4idPathgroupDstNoteApi api = new Bit4idPathgroupDstNoteApi();

    
    /**
     * Retrieve the DSTNotes associated to the DST
     *
     * This API allows to retrieve the DST Notes associated to the DST.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void dSTIdNoteGetTest() throws ApiException {
        UUID id = null;
        List<DSTNote> response = api.dSTIdNoteGet(id);

        // TODO: test validations
    }
    
    /**
     * Delete a DSTNote
     *
     * This API allows to delete a DSTNote.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void dSTIdNoteNoteIdDeleteTest() throws ApiException {
        UUID id = null;
        Long noteId = null;
        api.dSTIdNoteNoteIdDelete(id, noteId);

        // TODO: test validations
    }
    
    /**
     * Edit a DSTNote
     *
     * This API allows to edit a DSTNote.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void dSTIdNoteNoteIdPutTest() throws ApiException {
        UUID id = null;
        Long noteId = null;
        DSTNote dsTNote = null;
        DSTNote response = api.dSTIdNoteNoteIdPut(id, noteId, dsTNote);

        // TODO: test validations
    }
    
    /**
     * Append a new DSTNote
     *
     * This API allows to append a new DSTNote to the DST.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void dSTIdNotePostTest() throws ApiException {
        UUID id = null;
        InlineObject1 inlineObject1 = null;
        DSTNote response = api.dSTIdNotePost(id, inlineObject1);

        // TODO: test validations
    }
    
}
