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
import signingToday.client.model.Signature;

/**
 * Document
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:35:42.543Z[GMT]")
public class Document {
  public static final String SERIALIZED_NAME_DOCUMENT_URI = "document_uri";
  @SerializedName(SERIALIZED_NAME_DOCUMENT_URI)
  private String documentUri;

  public static final String SERIALIZED_NAME_DOCUMENT_URI_OPTIONS = "document_uri_options";
  @SerializedName(SERIALIZED_NAME_DOCUMENT_URI_OPTIONS)
  private Object documentUriOptions;

  public static final String SERIALIZED_NAME_DOCUMENT = "document";
  @SerializedName(SERIALIZED_NAME_DOCUMENT)
  private String document;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display_name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_GROUPS = "groups";
  @SerializedName(SERIALIZED_NAME_GROUPS)
  private List<List<Signature>> groups = null;

  public static final String SERIALIZED_NAME_PREVIEW = "preview";
  @SerializedName(SERIALIZED_NAME_PREVIEW)
  private String preview;


  public Document documentUri(String documentUri) {
    
    this.documentUri = documentUri;
    return this;
  }

   /**
   * This is the url from where the document, commonly in pdf format, has been uploaded to the Digital Signature Transaction
   * @return documentUri
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://signing.today/sample/document-uri", value = "This is the url from where the document, commonly in pdf format, has been uploaded to the Digital Signature Transaction")

  public String getDocumentUri() {
    return documentUri;
  }


  public void setDocumentUri(String documentUri) {
    this.documentUri = documentUri;
  }


  public Document documentUriOptions(Object documentUriOptions) {
    
    this.documentUriOptions = documentUriOptions;
    return this;
  }

   /**
   * Additional options about the upload of the document
   * @return documentUriOptions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "{\"headers\":{\"Authorization\":\"barer ba12bb43ac54dd65\"},\"method\":\"GET\"}", value = "Additional options about the upload of the document")

  public Object getDocumentUriOptions() {
    return documentUriOptions;
  }


  public void setDocumentUriOptions(Object documentUriOptions) {
    this.documentUriOptions = documentUriOptions;
  }


  public Document document(String document) {
    
    this.document = document;
    return this;
  }

   /**
   * The url to download the document
   * @return document
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://signing.today/sample/get-document", value = "The url to download the document")

  public String getDocument() {
    return document;
  }


  public void setDocument(String document) {
    this.document = document;
  }


  public Document displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * The name associated to the document, provided during the Digital Signature Transaction creation
   * @return displayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Work Contract", value = "The name associated to the document, provided during the Digital Signature Transaction creation")

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public Document groups(List<List<Signature>> groups) {
    
    this.groups = groups;
    return this;
  }

  public Document addGroupsItem(List<Signature> groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<List<Signature>>();
    }
    this.groups.add(groupsItem);
    return this;
  }

   /**
   * The scheduled signatures ordered as groups of signers. The signatures of a group can be performed only once all the signatures of the previous groups have been completed 
   * @return groups
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The scheduled signatures ordered as groups of signers. The signatures of a group can be performed only once all the signatures of the previous groups have been completed ")

  public List<List<Signature>> getGroups() {
    return groups;
  }


  public void setGroups(List<List<Signature>> groups) {
    this.groups = groups;
  }


  public Document preview(String preview) {
    
    this.preview = preview;
    return this;
  }

   /**
   * The preview field is a parametric url which can be used to make a preview of the documents in the client integration of SigningToday. The parameters are:   - page: the page to display   - width: the width of the page   - heigth: the heigth of the page The width and height parameters allows to display the page in a preferred size. If both are provided the first one is only use because the proportion of the page remains unchanged 
   * @return preview
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/pdfr/737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4/0/{page}.png?w={width}&h={height}", value = "The preview field is a parametric url which can be used to make a preview of the documents in the client integration of SigningToday. The parameters are:   - page: the page to display   - width: the width of the page   - heigth: the heigth of the page The width and height parameters allows to display the page in a preferred size. If both are provided the first one is only use because the proportion of the page remains unchanged ")

  public String getPreview() {
    return preview;
  }


  public void setPreview(String preview) {
    this.preview = preview;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Document document = (Document) o;
    return Objects.equals(this.documentUri, document.documentUri) &&
        Objects.equals(this.documentUriOptions, document.documentUriOptions) &&
        Objects.equals(this.document, document.document) &&
        Objects.equals(this.displayName, document.displayName) &&
        Objects.equals(this.groups, document.groups) &&
        Objects.equals(this.preview, document.preview);
  }

  @Override
  public int hashCode() {
    return Objects.hash(documentUri, documentUriOptions, document, displayName, groups, preview);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Document {\n");
    sb.append("    documentUri: ").append(toIndentedString(documentUri)).append("\n");
    sb.append("    documentUriOptions: ").append(toIndentedString(documentUriOptions)).append("\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    preview: ").append(toIndentedString(preview)).append("\n");
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

