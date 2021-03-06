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


package signingToday.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import signingToday.client.model.CreateDocumentResource;
import signingToday.client.model.FillableForm;
import signingToday.client.model.SignatureRequest;
import signingToday.client.model.SignersGroup;

/**
 * CreateDocument
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:13:36.809Z[GMT]")
public class CreateDocument {
  public static final String SERIALIZED_NAME_RESOURCE = "resource";
  @SerializedName(SERIALIZED_NAME_RESOURCE)
  private CreateDocumentResource resource;

  public static final String SERIALIZED_NAME_FORMS = "forms";
  @SerializedName(SERIALIZED_NAME_FORMS)
  private List<FillableForm> forms = null;

  public static final String SERIALIZED_NAME_SIGNATURE_REQUESTS = "signatureRequests";
  @SerializedName(SERIALIZED_NAME_SIGNATURE_REQUESTS)
  private List<SignatureRequest> signatureRequests = null;

  public static final String SERIALIZED_NAME_SIGNER_GROUPS = "signerGroups";
  @SerializedName(SERIALIZED_NAME_SIGNER_GROUPS)
  private List<SignersGroup> signerGroups = null;


  public CreateDocument resource(CreateDocumentResource resource) {
    
    this.resource = resource;
    return this;
  }

   /**
   * Get resource
   * @return resource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CreateDocumentResource getResource() {
    return resource;
  }


  public void setResource(CreateDocumentResource resource) {
    this.resource = resource;
  }


  public CreateDocument forms(List<FillableForm> forms) {
    
    this.forms = forms;
    return this;
  }

  public CreateDocument addFormsItem(FillableForm formsItem) {
    if (this.forms == null) {
      this.forms = new ArrayList<FillableForm>();
    }
    this.forms.add(formsItem);
    return this;
  }

   /**
   * The fillable elements of the document. Use the type field to identify textual fillable field and signature fields.
   * @return forms
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The fillable elements of the document. Use the type field to identify textual fillable field and signature fields.")

  public List<FillableForm> getForms() {
    return forms;
  }


  public void setForms(List<FillableForm> forms) {
    this.forms = forms;
  }


  public CreateDocument signatureRequests(List<SignatureRequest> signatureRequests) {
    
    this.signatureRequests = signatureRequests;
    return this;
  }

  public CreateDocument addSignatureRequestsItem(SignatureRequest signatureRequestsItem) {
    if (this.signatureRequests == null) {
      this.signatureRequests = new ArrayList<SignatureRequest>();
    }
    this.signatureRequests.add(signatureRequestsItem);
    return this;
  }

   /**
   * The list of signature request of the document.
   * @return signatureRequests
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list of signature request of the document.")

  public List<SignatureRequest> getSignatureRequests() {
    return signatureRequests;
  }


  public void setSignatureRequests(List<SignatureRequest> signatureRequests) {
    this.signatureRequests = signatureRequests;
  }


  public CreateDocument signerGroups(List<SignersGroup> signerGroups) {
    
    this.signerGroups = signerGroups;
    return this;
  }

  public CreateDocument addSignerGroupsItem(SignersGroup signerGroupsItem) {
    if (this.signerGroups == null) {
      this.signerGroups = new ArrayList<SignersGroup>();
    }
    this.signerGroups.add(signerGroupsItem);
    return this;
  }

   /**
   * The sign plan for the document
   * @return signerGroups
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The sign plan for the document")

  public List<SignersGroup> getSignerGroups() {
    return signerGroups;
  }


  public void setSignerGroups(List<SignersGroup> signerGroups) {
    this.signerGroups = signerGroups;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDocument createDocument = (CreateDocument) o;
    return Objects.equals(this.resource, createDocument.resource) &&
        Objects.equals(this.forms, createDocument.forms) &&
        Objects.equals(this.signatureRequests, createDocument.signatureRequests) &&
        Objects.equals(this.signerGroups, createDocument.signerGroups);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resource, forms, signatureRequests, signerGroups);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDocument {\n");
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
    sb.append("    forms: ").append(toIndentedString(forms)).append("\n");
    sb.append("    signatureRequests: ").append(toIndentedString(signatureRequests)).append("\n");
    sb.append("    signerGroups: ").append(toIndentedString(signerGroups)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

