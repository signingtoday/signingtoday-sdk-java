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
import java.util.UUID;
import signingToday.client.model.SignatureWhere;

/**
 * The Signature is an object of SigningToday which contains all the information needed to _digitally sign a document_. This is possible thanks to the cerficate associated to the identity in the wallet of the user is going to perform the signature. The _profile_ field of the Signature object specifies the modality of signature is going to be performed, and can be:   - _PADES_ :     - allows to exclusively sign a pdf file with the signature     directly affixed into the document;   - _CADES_ :     - allows to sign different types of documents; the signature     is not \&quot;physically\&quot; into the document but the signature and the file     are placed together in an envelope instead, making thus a _.p7m_     extension.  Consistently to the other objects, the Signature, as well, has a status, which is helpful to understand if the signature has been performed already or not, if it is expired or it is errored due to a miskate during the creation of the digital signature transaction or the performing of the signature itself. 
 */
@ApiModel(description = "The Signature is an object of SigningToday which contains all the information needed to _digitally sign a document_. This is possible thanks to the cerficate associated to the identity in the wallet of the user is going to perform the signature. The _profile_ field of the Signature object specifies the modality of signature is going to be performed, and can be:   - _PADES_ :     - allows to exclusively sign a pdf file with the signature     directly affixed into the document;   - _CADES_ :     - allows to sign different types of documents; the signature     is not \"physically\" into the document but the signature and the file     are placed together in an envelope instead, making thus a _.p7m_     extension.  Consistently to the other objects, the Signature, as well, has a status, which is helpful to understand if the signature has been performed already or not, if it is expired or it is errored due to a miskate during the creation of the digital signature transaction or the performing of the signature itself. ")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T09:30:59.492Z[GMT]")
public class Signature {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private UUID id;

  public static final String SERIALIZED_NAME_SIGNER = "signer";
  @SerializedName(SERIALIZED_NAME_SIGNER)
  private String signer;

  public static final String SERIALIZED_NAME_SIGNER_GROUP = "signer_group";
  @SerializedName(SERIALIZED_NAME_SIGNER_GROUP)
  private String signerGroup;

  public static final String SERIALIZED_NAME_SIGNATURE_TICKET = "signature_ticket";
  @SerializedName(SERIALIZED_NAME_SIGNATURE_TICKET)
  private String signatureTicket;

  public static final String SERIALIZED_NAME_AUTOMATIC = "automatic";
  @SerializedName(SERIALIZED_NAME_AUTOMATIC)
  private Boolean automatic;

  public static final String SERIALIZED_NAME_DECLINE_URL = "decline_url";
  @SerializedName(SERIALIZED_NAME_DECLINE_URL)
  private String declineUrl;

  public static final String SERIALIZED_NAME_DESCRIPTION_HTML = "description_html";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION_HTML)
  private String descriptionHtml;

  /**
   * The status of the Signature. As the digital signature transaction is created the status of the Signature is _waiting_, if everything is legit than the status changes to _pending_, otherwise to _error_. Once the Signature is made the status changes to _performed_. If the DST expires before the Signature is performed then the status changes to _expired_
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    WAITING("waiting"),
    
    PENDING("pending"),
    
    PERFORMED("performed"),
    
    EXPIRED("expired"),
    
    ERROR("error");

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

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display_name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  /**
   * The _profile_ field of the Signature object specifies the modality of signature is going to be performed, and can be:   - _PADES_ : allows to exclusively sign a pdf file with the signature     directly affixed into the document;   - _CADES_ : allows to sign different types of documents; the signature     is not \&quot;physically\&quot; into the document but the signature and the file     are placed together in an envelope instead, making thus a .p7m extension. 
   */
  @JsonAdapter(ProfileEnum.Adapter.class)
  public enum ProfileEnum {
    PADES_BES("pades-bes"),
    
    PADES_T("pades-t"),
    
    CADES_BES("cades-bes"),
    
    CADES_T("cades-t");

    private String value;

    ProfileEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ProfileEnum fromValue(String value) {
      for (ProfileEnum b : ProfileEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ProfileEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ProfileEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ProfileEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ProfileEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PROFILE = "profile";
  @SerializedName(SERIALIZED_NAME_PROFILE)
  private ProfileEnum profile;

  public static final String SERIALIZED_NAME_REASON = "reason";
  @SerializedName(SERIALIZED_NAME_REASON)
  private String reason;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_DECLINABLE = "declinable";
  @SerializedName(SERIALIZED_NAME_DECLINABLE)
  private Boolean declinable;

  public static final String SERIALIZED_NAME_URLBACK = "urlback";
  @SerializedName(SERIALIZED_NAME_URLBACK)
  private String urlback;

  public static final String SERIALIZED_NAME_WHERE = "where";
  @SerializedName(SERIALIZED_NAME_WHERE)
  private SignatureWhere where;

  public static final String SERIALIZED_NAME_CONSTRAINTS = "constraints";
  @SerializedName(SERIALIZED_NAME_CONSTRAINTS)
  private Object constraints;


  public Signature id(UUID id) {
    
    this.id = id;
    return this;
  }

   /**
   * The uuid code that identifies the Signature
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "787dc132-b3f0-11e9-a1a3-2a2ae2dbcce5", value = "The uuid code that identifies the Signature")

  public UUID getId() {
    return id;
  }


  public void setId(UUID id) {
    this.id = id;
  }


  public Signature signer(String signer) {
    
    this.signer = signer;
    return this;
  }

   /**
   * The user that have to sign the digital signature transaction
   * @return signer
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "jdo", value = "The user that have to sign the digital signature transaction")

  public String getSigner() {
    return signer;
  }


  public void setSigner(String signer) {
    this.signer = signer;
  }


  public Signature signerGroup(String signerGroup) {
    
    this.signerGroup = signerGroup;
    return this;
  }

   /**
   * The group which the signer belongs. This field is used in the scenario of a digital signature transaction that has multiple signatures to be performed, where the signers belongs to the same group. Let&#39;s think to the group _\&quot;teachers\&quot;_ of a school. Thus is possible to add the _signer_group_ _\&quot;teachers\&quot;_ as signers of the digital signature transaction without worrying about who really belong to that group
   * @return signerGroup
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The group which the signer belongs. This field is used in the scenario of a digital signature transaction that has multiple signatures to be performed, where the signers belongs to the same group. Let's think to the group _\"teachers\"_ of a school. Thus is possible to add the _signer_group_ _\"teachers\"_ as signers of the digital signature transaction without worrying about who really belong to that group")

  public String getSignerGroup() {
    return signerGroup;
  }


  public void setSignerGroup(String signerGroup) {
    this.signerGroup = signerGroup;
  }


  public Signature signatureTicket(String signatureTicket) {
    
    this.signatureTicket = signatureTicket;
    return this;
  }

   /**
   * This is the url where a signature tray is predisposed for a specific signer that have to sign a specific digital signature transaction. It is possible to set the signature tray language by the use of the **locate** query string - e.g. *?locate&#x3D;en* 
   * @return signatureTicket
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://sandbox.signingtoday.com/787dc132-b3f0-11e9-a1a3-2a2ae2dbcce5/signature", value = "This is the url where a signature tray is predisposed for a specific signer that have to sign a specific digital signature transaction. It is possible to set the signature tray language by the use of the **locate** query string - e.g. *?locate=en* ")

  public String getSignatureTicket() {
    return signatureTicket;
  }


  public void setSignatureTicket(String signatureTicket) {
    this.signatureTicket = signatureTicket;
  }


  public Signature automatic(Boolean automatic) {
    
    this.automatic = automatic;
    return this;
  }

   /**
   * If true indicates that the signer is an _automatic_ one, thus the signature procedure will be different from a regular signer
   * @return automatic
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "If true indicates that the signer is an _automatic_ one, thus the signature procedure will be different from a regular signer")

  public Boolean getAutomatic() {
    return automatic;
  }


  public void setAutomatic(Boolean automatic) {
    this.automatic = automatic;
  }


  public Signature declineUrl(String declineUrl) {
    
    this.declineUrl = declineUrl;
    return this;
  }

   /**
   * This is the url to decline a digital signature transaction
   * @return declineUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/api/v1/bit4id/signatures/787dc132-b3f0-11e9-a1a3-2a2ae2dbcce5/decline", value = "This is the url to decline a digital signature transaction")

  public String getDeclineUrl() {
    return declineUrl;
  }


  public void setDeclineUrl(String declineUrl) {
    this.declineUrl = declineUrl;
  }


  public Signature descriptionHtml(String descriptionHtml) {
    
    this.descriptionHtml = descriptionHtml;
    return this;
  }

   /**
   * This is a _html_ description to attach with the Signature
   * @return descriptionHtml
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "<i>my-description</i>", value = "This is a _html_ description to attach with the Signature")

  public String getDescriptionHtml() {
    return descriptionHtml;
  }


  public void setDescriptionHtml(String descriptionHtml) {
    this.descriptionHtml = descriptionHtml;
  }


  public Signature status(StatusEnum status) {
    
    this.status = status;
    return this;
  }

   /**
   * The status of the Signature. As the digital signature transaction is created the status of the Signature is _waiting_, if everything is legit than the status changes to _pending_, otherwise to _error_. Once the Signature is made the status changes to _performed_. If the DST expires before the Signature is performed then the status changes to _expired_
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "performed", value = "The status of the Signature. As the digital signature transaction is created the status of the Signature is _waiting_, if everything is legit than the status changes to _pending_, otherwise to _error_. Once the Signature is made the status changes to _performed_. If the DST expires before the Signature is performed then the status changes to _expired_")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  public Signature displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * This is the name will be displayed on the signature tray associated to the Signature has to be performed. Usually is the _full name_ of the user is going to sign
   * @return displayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "John", value = "This is the name will be displayed on the signature tray associated to the Signature has to be performed. Usually is the _full name_ of the user is going to sign")

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public Signature profile(ProfileEnum profile) {
    
    this.profile = profile;
    return this;
  }

   /**
   * The _profile_ field of the Signature object specifies the modality of signature is going to be performed, and can be:   - _PADES_ : allows to exclusively sign a pdf file with the signature     directly affixed into the document;   - _CADES_ : allows to sign different types of documents; the signature     is not \&quot;physically\&quot; into the document but the signature and the file     are placed together in an envelope instead, making thus a .p7m extension. 
   * @return profile
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "pades-bes", value = "The _profile_ field of the Signature object specifies the modality of signature is going to be performed, and can be:   - _PADES_ : allows to exclusively sign a pdf file with the signature     directly affixed into the document;   - _CADES_ : allows to sign different types of documents; the signature     is not \"physically\" into the document but the signature and the file     are placed together in an envelope instead, making thus a .p7m extension. ")

  public ProfileEnum getProfile() {
    return profile;
  }


  public void setProfile(ProfileEnum profile) {
    this.profile = profile;
  }


  public Signature reason(String reason) {
    
    this.reason = reason;
    return this;
  }

   /**
   * The reason of the Signature, or rather a motivational description associated to the Signature
   * @return reason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "For approval", value = "The reason of the Signature, or rather a motivational description associated to the Signature")

  public String getReason() {
    return reason;
  }


  public void setReason(String reason) {
    this.reason = reason;
  }


  public Signature description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * This is a simple description to attach with the Signature
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "*my-description*", value = "This is a simple description to attach with the Signature")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public Signature declinable(Boolean declinable) {
    
    this.declinable = declinable;
    return this;
  }

   /**
   * If true the signer is able to decline the Signature if he wants to
   * @return declinable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "If true the signer is able to decline the Signature if he wants to")

  public Boolean getDeclinable() {
    return declinable;
  }


  public void setDeclinable(Boolean declinable) {
    this.declinable = declinable;
  }


  public Signature urlback(String urlback) {
    
    this.urlback = urlback;
    return this;
  }

   /**
   * The url for the redirection from Signature tray when the digital signature transaction is completed or annulled
   * @return urlback
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://signing.today/sample/home", value = "The url for the redirection from Signature tray when the digital signature transaction is completed or annulled")

  public String getUrlback() {
    return urlback;
  }


  public void setUrlback(String urlback) {
    this.urlback = urlback;
  }


  public Signature where(SignatureWhere where) {
    
    this.where = where;
    return this;
  }

   /**
   * Get where
   * @return where
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SignatureWhere getWhere() {
    return where;
  }


  public void setWhere(SignatureWhere where) {
    this.where = where;
  }


  public Signature constraints(Object constraints) {
    
    this.constraints = constraints;
    return this;
  }

   /**
   * Particular constraints for the Signature. For example constraints about the _firs tname_ or _last name_ of the certificate associated with the identity is going to sign. The way to use this field is through the _django lookups_, for example:   - \&quot;certificate__subject_givenName__iexact&#x3D;JOHN\&quot; 
   * @return constraints
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "{}", value = "Particular constraints for the Signature. For example constraints about the _firs tname_ or _last name_ of the certificate associated with the identity is going to sign. The way to use this field is through the _django lookups_, for example:   - \"certificate__subject_givenName__iexact=JOHN\" ")

  public Object getConstraints() {
    return constraints;
  }


  public void setConstraints(Object constraints) {
    this.constraints = constraints;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Signature signature = (Signature) o;
    return Objects.equals(this.id, signature.id) &&
        Objects.equals(this.signer, signature.signer) &&
        Objects.equals(this.signerGroup, signature.signerGroup) &&
        Objects.equals(this.signatureTicket, signature.signatureTicket) &&
        Objects.equals(this.automatic, signature.automatic) &&
        Objects.equals(this.declineUrl, signature.declineUrl) &&
        Objects.equals(this.descriptionHtml, signature.descriptionHtml) &&
        Objects.equals(this.status, signature.status) &&
        Objects.equals(this.displayName, signature.displayName) &&
        Objects.equals(this.profile, signature.profile) &&
        Objects.equals(this.reason, signature.reason) &&
        Objects.equals(this.description, signature.description) &&
        Objects.equals(this.declinable, signature.declinable) &&
        Objects.equals(this.urlback, signature.urlback) &&
        Objects.equals(this.where, signature.where) &&
        Objects.equals(this.constraints, signature.constraints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, signer, signerGroup, signatureTicket, automatic, declineUrl, descriptionHtml, status, displayName, profile, reason, description, declinable, urlback, where, constraints);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Signature {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    signer: ").append(toIndentedString(signer)).append("\n");
    sb.append("    signerGroup: ").append(toIndentedString(signerGroup)).append("\n");
    sb.append("    signatureTicket: ").append(toIndentedString(signatureTicket)).append("\n");
    sb.append("    automatic: ").append(toIndentedString(automatic)).append("\n");
    sb.append("    declineUrl: ").append(toIndentedString(declineUrl)).append("\n");
    sb.append("    descriptionHtml: ").append(toIndentedString(descriptionHtml)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    declinable: ").append(toIndentedString(declinable)).append("\n");
    sb.append("    urlback: ").append(toIndentedString(urlback)).append("\n");
    sb.append("    where: ").append(toIndentedString(where)).append("\n");
    sb.append("    constraints: ").append(toIndentedString(constraints)).append("\n");
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

