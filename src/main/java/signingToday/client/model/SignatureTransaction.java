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
import java.util.UUID;
import signingToday.client.model.Document;

/**
 * The Digital Signature Transaction is the object that makes possible a flow of signatures of one or more documents happen. Once there is an organization with some users, it is possible to create a dst through the definition of the document or the documents have to be signed, the signer or, eventually, the signers, grouping them, in this way it is possible to decide the order of the signatories will be followed. The status of the DST is _pending_ until all the signers have signed. Once that happens the status will change to _performed_. 
 */
@ApiModel(description = "The Digital Signature Transaction is the object that makes possible a flow of signatures of one or more documents happen. Once there is an organization with some users, it is possible to create a dst through the definition of the document or the documents have to be signed, the signer or, eventually, the signers, grouping them, in this way it is possible to decide the order of the signatories will be followed. The status of the DST is _pending_ until all the signers have signed. Once that happens the status will change to _performed_. ")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T09:30:59.492Z[GMT]")
public class SignatureTransaction {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private UUID id;

  public static final String SERIALIZED_NAME_DOCUMENTS = "documents";
  @SerializedName(SERIALIZED_NAME_DOCUMENTS)
  private List<Document> documents = null;

  public static final String SERIALIZED_NAME_ARCHIVED = "archived";
  @SerializedName(SERIALIZED_NAME_ARCHIVED)
  private Boolean archived = false;

  public static final String SERIALIZED_NAME_CREATED_BY = "created_by";
  @SerializedName(SERIALIZED_NAME_CREATED_BY)
  private String createdBy;

  /**
   * The Digital Signature Transaction may have the following statuses:   - &#x60;waiting&#x60;: Not all the documents has ben uploaded and validated yet   - &#x60;pending&#x60;: The DST is ready to be signed   - &#x60;performed&#x60;: The DST has been signed by all the signers   - &#x60;expired&#x60;: The DST expired before all the signers have signed it   - &#x60;cancelled&#x60;: The DST has been canceled; the motivation is in the reason 
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    WAITING("waiting"),
    
    PENDING("pending"),
    
    PERFORMED("performed"),
    
    EXPIRED("expired"),
    
    CANCELLED("cancelled");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return StatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private StatusEnum status;

  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  private String created;

  /**
   * The motivations for the cancellation may be:   - &#x60;CANNOT_DOWNLOAD_DOCUMENT&#x60;: Signing Today could not download the     document   - &#x60;INVALID_DOCUMENT&#x60;: The downloaded document is not valid   - &#x60;PROTECTED_DOCUMENT&#x60;: The document is protected by password   - &#x60;declined&#x60;: One of the documents has been refused   - &#x60;MOTIVAZIONE_ESPLICITA&#x60;: Rejected from the system with a custom     reason 
   */
  @JsonAdapter(ReasonEnum.Adapter.class)
  public enum ReasonEnum {
    CANNOT_DOWNLOAD_DOCUMENT("CANNOT_DOWNLOAD_DOCUMENT"),
    
    INVALID_DOCUMENT("INVALID_DOCUMENT"),
    
    PROTECTED_DOCUMENT("PROTECTED_DOCUMENT"),
    
    DECLINED("declined"),
    
    MOTIVAZIONE_ESPLICITA("MOTIVAZIONE_ESPLICITA");

    private String value;

    ReasonEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ReasonEnum fromValue(String value) {
      for (ReasonEnum b : ReasonEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ReasonEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ReasonEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ReasonEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ReasonEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REASON = "reason";
  @SerializedName(SERIALIZED_NAME_REASON)
  private ReasonEnum reason;

  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_NOT_AFTER = "not_after";
  @SerializedName(SERIALIZED_NAME_NOT_AFTER)
  private String notAfter;

  public static final String SERIALIZED_NAME_URLBACK = "urlback";
  @SerializedName(SERIALIZED_NAME_URLBACK)
  private String urlback;

  public static final String SERIALIZED_NAME_CANCELBACK = "cancelback";
  @SerializedName(SERIALIZED_NAME_CANCELBACK)
  private String cancelback;

  public static final String SERIALIZED_NAME_TEMPLATE_NAME = "template_name";
  @SerializedName(SERIALIZED_NAME_TEMPLATE_NAME)
  private String templateName;


  public SignatureTransaction id(UUID id) {
    
    this.id = id;
    return this;
  }

   /**
   * The uuid code that identifies the Digital Signature Transaction
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4", value = "The uuid code that identifies the Digital Signature Transaction")

  public UUID getId() {
    return id;
  }


  public void setId(UUID id) {
    this.id = id;
  }


  public SignatureTransaction documents(List<Document> documents) {
    
    this.documents = documents;
    return this;
  }

  public SignatureTransaction addDocumentsItem(Document documentsItem) {
    if (this.documents == null) {
      this.documents = new ArrayList<Document>();
    }
    this.documents.add(documentsItem);
    return this;
  }

   /**
   * The _documents_ field is an array containing document objects, where everyone of them is defined as follows 
   * @return documents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The _documents_ field is an array containing document objects, where everyone of them is defined as follows ")

  public List<Document> getDocuments() {
    return documents;
  }


  public void setDocuments(List<Document> documents) {
    this.documents = documents;
  }


  public SignatureTransaction archived(Boolean archived) {
    
    this.archived = archived;
    return this;
  }

   /**
   * True if the DST&#39;s resources has been deleted
   * @return archived
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "True if the DST's resources has been deleted")

  public Boolean getArchived() {
    return archived;
  }


  public void setArchived(Boolean archived) {
    this.archived = archived;
  }


  public SignatureTransaction createdBy(String createdBy) {
    
    this.createdBy = createdBy;
    return this;
  }

   /**
   * The user created the Digital Signature Transaction
   * @return createdBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "jdo@bit4id", value = "The user created the Digital Signature Transaction")

  public String getCreatedBy() {
    return createdBy;
  }


  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public SignatureTransaction status(StatusEnum status) {
    
    this.status = status;
    return this;
  }

   /**
   * The Digital Signature Transaction may have the following statuses:   - &#x60;waiting&#x60;: Not all the documents has ben uploaded and validated yet   - &#x60;pending&#x60;: The DST is ready to be signed   - &#x60;performed&#x60;: The DST has been signed by all the signers   - &#x60;expired&#x60;: The DST expired before all the signers have signed it   - &#x60;cancelled&#x60;: The DST has been canceled; the motivation is in the reason 
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "performed", value = "The Digital Signature Transaction may have the following statuses:   - `waiting`: Not all the documents has ben uploaded and validated yet   - `pending`: The DST is ready to be signed   - `performed`: The DST has been signed by all the signers   - `expired`: The DST expired before all the signers have signed it   - `cancelled`: The DST has been canceled; the motivation is in the reason ")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  public SignatureTransaction created(String created) {
    
    this.created = created;
    return this;
  }

   /**
   * Date of creation of the Digital Signature Transaction
   * @return created
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2019-11-24T12:24:17.430Z", value = "Date of creation of the Digital Signature Transaction")

  public String getCreated() {
    return created;
  }


  public void setCreated(String created) {
    this.created = created;
  }


  public SignatureTransaction reason(ReasonEnum reason) {
    
    this.reason = reason;
    return this;
  }

   /**
   * The motivations for the cancellation may be:   - &#x60;CANNOT_DOWNLOAD_DOCUMENT&#x60;: Signing Today could not download the     document   - &#x60;INVALID_DOCUMENT&#x60;: The downloaded document is not valid   - &#x60;PROTECTED_DOCUMENT&#x60;: The document is protected by password   - &#x60;declined&#x60;: One of the documents has been refused   - &#x60;MOTIVAZIONE_ESPLICITA&#x60;: Rejected from the system with a custom     reason 
   * @return reason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The motivations for the cancellation may be:   - `CANNOT_DOWNLOAD_DOCUMENT`: Signing Today could not download the     document   - `INVALID_DOCUMENT`: The downloaded document is not valid   - `PROTECTED_DOCUMENT`: The document is protected by password   - `declined`: One of the documents has been refused   - `MOTIVAZIONE_ESPLICITA`: Rejected from the system with a custom     reason ")

  public ReasonEnum getReason() {
    return reason;
  }


  public void setReason(ReasonEnum reason) {
    this.reason = reason;
  }


  public SignatureTransaction title(String title) {
    
    this.title = title;
    return this;
  }

   /**
   * Title of the Digital Signature Transaction
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Signature Transaction Demo", value = "Title of the Digital Signature Transaction")

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public SignatureTransaction notAfter(String notAfter) {
    
    this.notAfter = notAfter;
    return this;
  }

   /**
   * Deadline of the Digital Signature Transaction, expressed in ISO format
   * @return notAfter
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2019-09-19T19:00:18.016304Z", value = "Deadline of the Digital Signature Transaction, expressed in ISO format")

  public String getNotAfter() {
    return notAfter;
  }


  public void setNotAfter(String notAfter) {
    this.notAfter = notAfter;
  }


  public SignatureTransaction urlback(String urlback) {
    
    this.urlback = urlback;
    return this;
  }

   /**
   * The url for the redirection from signature tray when the Digital Signature Transaction is completed or refused
   * @return urlback
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://signing.today/sample/home", value = "The url for the redirection from signature tray when the Digital Signature Transaction is completed or refused")

  public String getUrlback() {
    return urlback;
  }


  public void setUrlback(String urlback) {
    this.urlback = urlback;
  }


  public SignatureTransaction cancelback(String cancelback) {
    
    this.cancelback = cancelback;
    return this;
  }

   /**
   * If set, in the signature tray will be displayed a button that needs to go back to a third part application
   * @return cancelback
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If set, in the signature tray will be displayed a button that needs to go back to a third part application")

  public String getCancelback() {
    return cancelback;
  }


  public void setCancelback(String cancelback) {
    this.cancelback = cancelback;
  }


  public SignatureTransaction templateName(String templateName) {
    
    this.templateName = templateName;
    return this;
  }

   /**
   * A label to indicate the template used to create the Digital Signature Transaction
   * @return templateName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Template-1", value = "A label to indicate the template used to create the Digital Signature Transaction")

  public String getTemplateName() {
    return templateName;
  }


  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignatureTransaction signatureTransaction = (SignatureTransaction) o;
    return Objects.equals(this.id, signatureTransaction.id) &&
        Objects.equals(this.documents, signatureTransaction.documents) &&
        Objects.equals(this.archived, signatureTransaction.archived) &&
        Objects.equals(this.createdBy, signatureTransaction.createdBy) &&
        Objects.equals(this.status, signatureTransaction.status) &&
        Objects.equals(this.created, signatureTransaction.created) &&
        Objects.equals(this.reason, signatureTransaction.reason) &&
        Objects.equals(this.title, signatureTransaction.title) &&
        Objects.equals(this.notAfter, signatureTransaction.notAfter) &&
        Objects.equals(this.urlback, signatureTransaction.urlback) &&
        Objects.equals(this.cancelback, signatureTransaction.cancelback) &&
        Objects.equals(this.templateName, signatureTransaction.templateName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, documents, archived, createdBy, status, created, reason, title, notAfter, urlback, cancelback, templateName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureTransaction {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    documents: ").append(toIndentedString(documents)).append("\n");
    sb.append("    archived: ").append(toIndentedString(archived)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    notAfter: ").append(toIndentedString(notAfter)).append("\n");
    sb.append("    urlback: ").append(toIndentedString(urlback)).append("\n");
    sb.append("    cancelback: ").append(toIndentedString(cancelback)).append("\n");
    sb.append("    templateName: ").append(toIndentedString(templateName)).append("\n");
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

