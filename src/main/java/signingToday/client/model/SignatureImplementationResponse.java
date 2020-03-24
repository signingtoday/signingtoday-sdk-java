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
import signingToday.client.model.Certificate;
import signingToday.client.model.Id;
import signingToday.client.model.Position;
import signingToday.client.model.Profile;
import signingToday.client.model.ProviderId;
import signingToday.client.model.Reason;
import signingToday.client.model.SignatureAppearanceUri;
import signingToday.client.model.SignatureImplementationResponseChannel;
import signingToday.client.model.Title;

/**
 * SignatureImplementationResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:35:42.543Z[GMT]")
public class SignatureImplementationResponse {
  public static final String SERIALIZED_NAME_PROFILE = "profile";
  @SerializedName(SERIALIZED_NAME_PROFILE)
  private Profile profile = null;

  public static final String SERIALIZED_NAME_PROVIDER_ID = "provider_id";
  @SerializedName(SERIALIZED_NAME_PROVIDER_ID)
  private ProviderId providerId = null;

  public static final String SERIALIZED_NAME_POSITION = "position";
  @SerializedName(SERIALIZED_NAME_POSITION)
  private Position position = null;

  public static final String SERIALIZED_NAME_GROUP = "group";
  @SerializedName(SERIALIZED_NAME_GROUP)
  private Integer group;

  public static final String SERIALIZED_NAME_CERTIFICATE = "certificate";
  @SerializedName(SERIALIZED_NAME_CERTIFICATE)
  private Certificate certificate = null;

  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private Title title = null;

  public static final String SERIALIZED_NAME_DST = "dst";
  @SerializedName(SERIALIZED_NAME_DST)
  private Id dst = null;

  /**
   * Gets or Sets signingTime
   */
  @JsonAdapter(SigningTimeEnum.Adapter.class)
  public enum SigningTimeEnum {
    PDF("pdf");

    private String value;

    SigningTimeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SigningTimeEnum fromValue(String value) {
      for (SigningTimeEnum b : SigningTimeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SigningTimeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SigningTimeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SigningTimeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SigningTimeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SIGNING_TIME = "signing_time";
  @SerializedName(SERIALIZED_NAME_SIGNING_TIME)
  private SigningTimeEnum signingTime;

  public static final String SERIALIZED_NAME_REASON = "reason";
  @SerializedName(SERIALIZED_NAME_REASON)
  private Reason reason = null;

  public static final String SERIALIZED_NAME_CHANNEL = "channel";
  @SerializedName(SERIALIZED_NAME_CHANNEL)
  private SignatureImplementationResponseChannel channel;

  public static final String SERIALIZED_NAME_SIGNATURE_TEXT = "signature_text";
  @SerializedName(SERIALIZED_NAME_SIGNATURE_TEXT)
  private String signatureText;

  public static final String SERIALIZED_NAME_SIGNATURE = "signature";
  @SerializedName(SERIALIZED_NAME_SIGNATURE)
  private Id signature = null;

  public static final String SERIALIZED_NAME_SIGNATURE_APPEARANCE_URI = "signature_appearance_uri";
  @SerializedName(SERIALIZED_NAME_SIGNATURE_APPEARANCE_URI)
  private SignatureAppearanceUri signatureAppearanceUri = null;

  /**
   * Gets or Sets padesSubfilter
   */
  @JsonAdapter(PadesSubfilterEnum.Adapter.class)
  public enum PadesSubfilterEnum {
    ETSI_CADES_DETACHED("ETSI.CAdES.detached");

    private String value;

    PadesSubfilterEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PadesSubfilterEnum fromValue(String value) {
      for (PadesSubfilterEnum b : PadesSubfilterEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PadesSubfilterEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PadesSubfilterEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PadesSubfilterEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PadesSubfilterEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PADES_SUBFILTER = "pades_subfilter";
  @SerializedName(SERIALIZED_NAME_PADES_SUBFILTER)
  private PadesSubfilterEnum padesSubfilter;

  public static final String SERIALIZED_NAME_DOCUMENT = "document";
  @SerializedName(SERIALIZED_NAME_DOCUMENT)
  private String document;

  public static final String SERIALIZED_NAME_PAGE = "page";
  @SerializedName(SERIALIZED_NAME_PAGE)
  private Integer page;

  public static final String SERIALIZED_NAME_IDENTITY = "identity";
  @SerializedName(SERIALIZED_NAME_IDENTITY)
  private Id identity = null;


  public SignatureImplementationResponse profile(Profile profile) {
    
    this.profile = profile;
    return this;
  }

   /**
   * Get profile
   * @return profile
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Profile getProfile() {
    return profile;
  }


  public void setProfile(Profile profile) {
    this.profile = profile;
  }


  public SignatureImplementationResponse providerId(ProviderId providerId) {
    
    this.providerId = providerId;
    return this;
  }

   /**
   * Get providerId
   * @return providerId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ProviderId getProviderId() {
    return providerId;
  }


  public void setProviderId(ProviderId providerId) {
    this.providerId = providerId;
  }


  public SignatureImplementationResponse position(Position position) {
    
    this.position = position;
    return this;
  }

   /**
   * Get position
   * @return position
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Position getPosition() {
    return position;
  }


  public void setPosition(Position position) {
    this.position = position;
  }


  public SignatureImplementationResponse group(Integer group) {
    
    this.group = group;
    return this;
  }

   /**
   * Number of the groups which the signer belongs during digital signature transaction creation
   * @return group
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0", value = "Number of the groups which the signer belongs during digital signature transaction creation")

  public Integer getGroup() {
    return group;
  }


  public void setGroup(Integer group) {
    this.group = group;
  }


  public SignatureImplementationResponse certificate(Certificate certificate) {
    
    this.certificate = certificate;
    return this;
  }

   /**
   * Get certificate
   * @return certificate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Certificate getCertificate() {
    return certificate;
  }


  public void setCertificate(Certificate certificate) {
    this.certificate = certificate;
  }


  public SignatureImplementationResponse title(Title title) {
    
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Title getTitle() {
    return title;
  }


  public void setTitle(Title title) {
    this.title = title;
  }


  public SignatureImplementationResponse dst(Id dst) {
    
    this.dst = dst;
    return this;
  }

   /**
   * Get dst
   * @return dst
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Id getDst() {
    return dst;
  }


  public void setDst(Id dst) {
    this.dst = dst;
  }


  public SignatureImplementationResponse signingTime(SigningTimeEnum signingTime) {
    
    this.signingTime = signingTime;
    return this;
  }

   /**
   * Get signingTime
   * @return signingTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SigningTimeEnum getSigningTime() {
    return signingTime;
  }


  public void setSigningTime(SigningTimeEnum signingTime) {
    this.signingTime = signingTime;
  }


  public SignatureImplementationResponse reason(Reason reason) {
    
    this.reason = reason;
    return this;
  }

   /**
   * Get reason
   * @return reason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Reason getReason() {
    return reason;
  }


  public void setReason(Reason reason) {
    this.reason = reason;
  }


  public SignatureImplementationResponse channel(SignatureImplementationResponseChannel channel) {
    
    this.channel = channel;
    return this;
  }

   /**
   * Get channel
   * @return channel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SignatureImplementationResponseChannel getChannel() {
    return channel;
  }


  public void setChannel(SignatureImplementationResponseChannel channel) {
    this.channel = channel;
  }


  public SignatureImplementationResponse signatureText(String signatureText) {
    
    this.signatureText = signatureText;
    return this;
  }

   /**
   * Get signatureText
   * @return signatureText
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[{\"format\": [\"Signed by {subject[commonName]}\", \"{subject[C]}\", \"{subject[L]}\", \"{subject[S]}\", \"{subject[OU]}\", \"{subject[O]}\", \"{subject[E]}\"]}]", value = "")

  public String getSignatureText() {
    return signatureText;
  }


  public void setSignatureText(String signatureText) {
    this.signatureText = signatureText;
  }


  public SignatureImplementationResponse signature(Id signature) {
    
    this.signature = signature;
    return this;
  }

   /**
   * Get signature
   * @return signature
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Id getSignature() {
    return signature;
  }


  public void setSignature(Id signature) {
    this.signature = signature;
  }


  public SignatureImplementationResponse signatureAppearanceUri(SignatureAppearanceUri signatureAppearanceUri) {
    
    this.signatureAppearanceUri = signatureAppearanceUri;
    return this;
  }

   /**
   * Get signatureAppearanceUri
   * @return signatureAppearanceUri
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SignatureAppearanceUri getSignatureAppearanceUri() {
    return signatureAppearanceUri;
  }


  public void setSignatureAppearanceUri(SignatureAppearanceUri signatureAppearanceUri) {
    this.signatureAppearanceUri = signatureAppearanceUri;
  }


  public SignatureImplementationResponse padesSubfilter(PadesSubfilterEnum padesSubfilter) {
    
    this.padesSubfilter = padesSubfilter;
    return this;
  }

   /**
   * Get padesSubfilter
   * @return padesSubfilter
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public PadesSubfilterEnum getPadesSubfilter() {
    return padesSubfilter;
  }


  public void setPadesSubfilter(PadesSubfilterEnum padesSubfilter) {
    this.padesSubfilter = padesSubfilter;
  }


  public SignatureImplementationResponse document(String document) {
    
    this.document = document;
    return this;
  }

   /**
   * Get document
   * @return document
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/docs/dsts/94794c07-d16e-4791-a507-0549225538b5/0", value = "")

  public String getDocument() {
    return document;
  }


  public void setDocument(String document) {
    this.document = document;
  }


  public SignatureImplementationResponse page(Integer page) {
    
    this.page = page;
    return this;
  }

   /**
   * Get page
   * @return page
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getPage() {
    return page;
  }


  public void setPage(Integer page) {
    this.page = page;
  }


  public SignatureImplementationResponse identity(Id identity) {
    
    this.identity = identity;
    return this;
  }

   /**
   * Get identity
   * @return identity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Id getIdentity() {
    return identity;
  }


  public void setIdentity(Id identity) {
    this.identity = identity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignatureImplementationResponse signatureImplementationResponse = (SignatureImplementationResponse) o;
    return Objects.equals(this.profile, signatureImplementationResponse.profile) &&
        Objects.equals(this.providerId, signatureImplementationResponse.providerId) &&
        Objects.equals(this.position, signatureImplementationResponse.position) &&
        Objects.equals(this.group, signatureImplementationResponse.group) &&
        Objects.equals(this.certificate, signatureImplementationResponse.certificate) &&
        Objects.equals(this.title, signatureImplementationResponse.title) &&
        Objects.equals(this.dst, signatureImplementationResponse.dst) &&
        Objects.equals(this.signingTime, signatureImplementationResponse.signingTime) &&
        Objects.equals(this.reason, signatureImplementationResponse.reason) &&
        Objects.equals(this.channel, signatureImplementationResponse.channel) &&
        Objects.equals(this.signatureText, signatureImplementationResponse.signatureText) &&
        Objects.equals(this.signature, signatureImplementationResponse.signature) &&
        Objects.equals(this.signatureAppearanceUri, signatureImplementationResponse.signatureAppearanceUri) &&
        Objects.equals(this.padesSubfilter, signatureImplementationResponse.padesSubfilter) &&
        Objects.equals(this.document, signatureImplementationResponse.document) &&
        Objects.equals(this.page, signatureImplementationResponse.page) &&
        Objects.equals(this.identity, signatureImplementationResponse.identity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(profile, providerId, position, group, certificate, title, dst, signingTime, reason, channel, signatureText, signature, signatureAppearanceUri, padesSubfilter, document, page, identity);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureImplementationResponse {\n");
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    certificate: ").append(toIndentedString(certificate)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    dst: ").append(toIndentedString(dst)).append("\n");
    sb.append("    signingTime: ").append(toIndentedString(signingTime)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    signatureText: ").append(toIndentedString(signatureText)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("    signatureAppearanceUri: ").append(toIndentedString(signatureAppearanceUri)).append("\n");
    sb.append("    padesSubfilter: ").append(toIndentedString(padesSubfilter)).append("\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
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

