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
import signingToday.client.model.IdentityActions;

/**
 * The Identity is the core object of SigningToday, because inside it there are all the information that allows an user to sign a digital signature transaction. Of course the most important information is the cerficate, which is a base64 string in PEM format. This allows to sign documents with a legal validity. The Identity has as well an expiration date, a status, which may be simply active, error, in case of problems during its emission either if the certificate has been somehow altered, or pending if the enrollment procedure has to be completed (the following steps are indicated in the &#39;next&#39; field as well). Also there are information about the provider issued the Identity and fields with an url value that allows to send one time passwords or to sign digital signature transactions. 
 */
@ApiModel(description = "The Identity is the core object of SigningToday, because inside it there are all the information that allows an user to sign a digital signature transaction. Of course the most important information is the cerficate, which is a base64 string in PEM format. This allows to sign documents with a legal validity. The Identity has as well an expiration date, a status, which may be simply active, error, in case of problems during its emission either if the certificate has been somehow altered, or pending if the enrollment procedure has to be completed (the following steps are indicated in the 'next' field as well). Also there are information about the provider issued the Identity and fields with an url value that allows to send one time passwords or to sign digital signature transactions. ")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T09:30:59.492Z[GMT]")
public class Identity {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private UUID id;

  public static final String SERIALIZED_NAME_CERTIFICATE = "certificate";
  @SerializedName(SERIALIZED_NAME_CERTIFICATE)
  private String certificate;

  public static final String SERIALIZED_NAME_NOT_AFTER = "not_after";
  @SerializedName(SERIALIZED_NAME_NOT_AFTER)
  private String notAfter;

  /**
   * Identity status which can be one of the following. When an identity request is send, the identity is created and the status is **pending** until the provider dont&#39;approve the request. Then status of the identity changes to **active**. If for some reason an error occurs during the process, or after that, the status will be **error** 
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    PENDING("pending"),
    
    ACTIVE("active"),
    
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

  public static final String SERIALIZED_NAME_NEXT = "next";
  @SerializedName(SERIALIZED_NAME_NEXT)
  private String next;

  public static final String SERIALIZED_NAME_ACTIONS = "actions";
  @SerializedName(SERIALIZED_NAME_ACTIONS)
  private IdentityActions actions;

  public static final String SERIALIZED_NAME_PROVIDER = "provider";
  @SerializedName(SERIALIZED_NAME_PROVIDER)
  private String provider;

  public static final String SERIALIZED_NAME_LABEL = "label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_SIGNATURE_APPEARANCE_URI = "signature_appearance_uri";
  @SerializedName(SERIALIZED_NAME_SIGNATURE_APPEARANCE_URI)
  private String signatureAppearanceUri;

  public static final String SERIALIZED_NAME_PROVIDER_ID = "provider_id";
  @SerializedName(SERIALIZED_NAME_PROVIDER_ID)
  private UUID providerId;

  public static final String SERIALIZED_NAME_PROVIDER_TYPE = "provider_type";
  @SerializedName(SERIALIZED_NAME_PROVIDER_TYPE)
  private String providerType;

  public static final String SERIALIZED_NAME_PROVIDER_DATA = "provider_data";
  @SerializedName(SERIALIZED_NAME_PROVIDER_DATA)
  private Object providerData;

  public static final String SERIALIZED_NAME_PROVIDER_IMAGE = "provider_image";
  @SerializedName(SERIALIZED_NAME_PROVIDER_IMAGE)
  private String providerImage;

  public static final String SERIALIZED_NAME_SEND_OTP_URL = "send_otp_url";
  @SerializedName(SERIALIZED_NAME_SEND_OTP_URL)
  private String sendOtpUrl;

  public static final String SERIALIZED_NAME_SIGN_URL = "sign_url";
  @SerializedName(SERIALIZED_NAME_SIGN_URL)
  private String signUrl;

  public static final String SERIALIZED_NAME_HAS_BEEN_IMPORTED = "has_been_imported";
  @SerializedName(SERIALIZED_NAME_HAS_BEEN_IMPORTED)
  private Boolean hasBeenImported;


  public Identity id(UUID id) {
    
    this.id = id;
    return this;
  }

   /**
   * The uuid code that identifies the Identity
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4", value = "The uuid code that identifies the Identity")

  public UUID getId() {
    return id;
  }


  public void setId(UUID id) {
    this.id = id;
  }


  public Identity certificate(String certificate) {
    
    this.certificate = certificate;
    return this;
  }

   /**
   * The X.509 certificate in PEM format of the Identity
   * @return certificate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "<certificate-string>", value = "The X.509 certificate in PEM format of the Identity")

  public String getCertificate() {
    return certificate;
  }


  public void setCertificate(String certificate) {
    this.certificate = certificate;
  }


  public Identity notAfter(String notAfter) {
    
    this.notAfter = notAfter;
    return this;
  }

   /**
   * Deadline of the Identity, expressed in ISO format
   * @return notAfter
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2021-10-17T07:26Z", value = "Deadline of the Identity, expressed in ISO format")

  public String getNotAfter() {
    return notAfter;
  }


  public void setNotAfter(String notAfter) {
    this.notAfter = notAfter;
  }


  public Identity status(StatusEnum status) {
    
    this.status = status;
    return this;
  }

   /**
   * Identity status which can be one of the following. When an identity request is send, the identity is created and the status is **pending** until the provider dont&#39;approve the request. Then status of the identity changes to **active**. If for some reason an error occurs during the process, or after that, the status will be **error** 
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "active", value = "Identity status which can be one of the following. When an identity request is send, the identity is created and the status is **pending** until the provider dont'approve the request. Then status of the identity changes to **active**. If for some reason an error occurs during the process, or after that, the status will be **error** ")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  public Identity next(String next) {
    
    this.next = next;
    return this;
  }

   /**
   * The next step to complete the activation procedure
   * @return next
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "next activity to complete <sample>", value = "The next step to complete the activation procedure")

  public String getNext() {
    return next;
  }


  public void setNext(String next) {
    this.next = next;
  }


  public Identity actions(IdentityActions actions) {
    
    this.actions = actions;
    return this;
  }

   /**
   * Get actions
   * @return actions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public IdentityActions getActions() {
    return actions;
  }


  public void setActions(IdentityActions actions) {
    this.actions = actions;
  }


  public Identity provider(String provider) {
    
    this.provider = provider;
    return this;
  }

   /**
   * The name of the provider that issued the certificate for the Identity
   * @return provider
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "System Sample Provider", value = "The name of the provider that issued the certificate for the Identity")

  public String getProvider() {
    return provider;
  }


  public void setProvider(String provider) {
    this.provider = provider;
  }


  public Identity label(String label) {
    
    this.label = label;
    return this;
  }

   /**
   * The label is an arbitrary name is possible to associate to an idenity. Doing so allows to distinguish different identities issued from the same provider during the performance of the signature in the signature tray
   * @return label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Identity Label", value = "The label is an arbitrary name is possible to associate to an idenity. Doing so allows to distinguish different identities issued from the same provider during the performance of the signature in the signature tray")

  public String getLabel() {
    return label;
  }


  public void setLabel(String label) {
    this.label = label;
  }


  public Identity signatureAppearanceUri(String signatureAppearanceUri) {
    
    this.signatureAppearanceUri = signatureAppearanceUri;
    return this;
  }

   /**
   * This is the url to the image that will be impressed on the document after the performance of the signature 
   * @return signatureAppearanceUri
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://upload.mysite.com/signature_appearance.png", value = "This is the url to the image that will be impressed on the document after the performance of the signature ")

  public String getSignatureAppearanceUri() {
    return signatureAppearanceUri;
  }


  public void setSignatureAppearanceUri(String signatureAppearanceUri) {
    this.signatureAppearanceUri = signatureAppearanceUri;
  }


  public Identity providerId(UUID providerId) {
    
    this.providerId = providerId;
    return this;
  }

   /**
   * _provider_id_ is the univocal name of the provider that issued the identity 
   * @return providerId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "_provider_id_ is the univocal name of the provider that issued the identity ")

  public UUID getProviderId() {
    return providerId;
  }


  public void setProviderId(UUID providerId) {
    this.providerId = providerId;
  }


  public Identity providerType(String providerType) {
    
    this.providerType = providerType;
    return this;
  }

   /**
   * Type of the provider. The most usual type is **cloud** 
   * @return providerType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "provider type", value = "Type of the provider. The most usual type is **cloud** ")

  public String getProviderType() {
    return providerType;
  }


  public void setProviderType(String providerType) {
    this.providerType = providerType;
  }


  public Identity providerData(Object providerData) {
    
    this.providerData = providerData;
    return this;
  }

   /**
   * Data of the provider that issued the certificate, it is variable from provider to provider
   * @return providerData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "{}", value = "Data of the provider that issued the certificate, it is variable from provider to provider")

  public Object getProviderData() {
    return providerData;
  }


  public void setProviderData(Object providerData) {
    this.providerData = providerData;
  }


  public Identity providerImage(String providerImage) {
    
    this.providerImage = providerImage;
    return this;
  }

   /**
   * This is the logo of the provider that issued the identity
   * @return providerImage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://my-org/image", value = "This is the logo of the provider that issued the identity")

  public String getProviderImage() {
    return providerImage;
  }


  public void setProviderImage(String providerImage) {
    this.providerImage = providerImage;
  }


  public Identity sendOtpUrl(String sendOtpUrl) {
    
    this.sendOtpUrl = sendOtpUrl;
    return this;
  }

   /**
   * The url to send a one time password to the user which the identity is associated
   * @return sendOtpUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://signing.today/sample/send-otp", value = "The url to send a one time password to the user which the identity is associated")

  public String getSendOtpUrl() {
    return sendOtpUrl;
  }


  public void setSendOtpUrl(String sendOtpUrl) {
    this.sendOtpUrl = sendOtpUrl;
  }


  public Identity signUrl(String signUrl) {
    
    this.signUrl = signUrl;
    return this;
  }

   /**
   * The url to sign a document of a digital signature transaction
   * @return signUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://signing.today/sample/sign-document", value = "The url to sign a document of a digital signature transaction")

  public String getSignUrl() {
    return signUrl;
  }


  public void setSignUrl(String signUrl) {
    this.signUrl = signUrl;
  }


  public Identity hasBeenImported(Boolean hasBeenImported) {
    
    this.hasBeenImported = hasBeenImported;
    return this;
  }

   /**
   * If the Identity has been imported from another pre-existing Identity the has_been_imported field is set to **true**
   * @return hasBeenImported
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "If the Identity has been imported from another pre-existing Identity the has_been_imported field is set to **true**")

  public Boolean getHasBeenImported() {
    return hasBeenImported;
  }


  public void setHasBeenImported(Boolean hasBeenImported) {
    this.hasBeenImported = hasBeenImported;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identity identity = (Identity) o;
    return Objects.equals(this.id, identity.id) &&
        Objects.equals(this.certificate, identity.certificate) &&
        Objects.equals(this.notAfter, identity.notAfter) &&
        Objects.equals(this.status, identity.status) &&
        Objects.equals(this.next, identity.next) &&
        Objects.equals(this.actions, identity.actions) &&
        Objects.equals(this.provider, identity.provider) &&
        Objects.equals(this.label, identity.label) &&
        Objects.equals(this.signatureAppearanceUri, identity.signatureAppearanceUri) &&
        Objects.equals(this.providerId, identity.providerId) &&
        Objects.equals(this.providerType, identity.providerType) &&
        Objects.equals(this.providerData, identity.providerData) &&
        Objects.equals(this.providerImage, identity.providerImage) &&
        Objects.equals(this.sendOtpUrl, identity.sendOtpUrl) &&
        Objects.equals(this.signUrl, identity.signUrl) &&
        Objects.equals(this.hasBeenImported, identity.hasBeenImported);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, certificate, notAfter, status, next, actions, provider, label, signatureAppearanceUri, providerId, providerType, providerData, providerImage, sendOtpUrl, signUrl, hasBeenImported);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identity {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    certificate: ").append(toIndentedString(certificate)).append("\n");
    sb.append("    notAfter: ").append(toIndentedString(notAfter)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    signatureAppearanceUri: ").append(toIndentedString(signatureAppearanceUri)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    providerType: ").append(toIndentedString(providerType)).append("\n");
    sb.append("    providerData: ").append(toIndentedString(providerData)).append("\n");
    sb.append("    providerImage: ").append(toIndentedString(providerImage)).append("\n");
    sb.append("    sendOtpUrl: ").append(toIndentedString(sendOtpUrl)).append("\n");
    sb.append("    signUrl: ").append(toIndentedString(signUrl)).append("\n");
    sb.append("    hasBeenImported: ").append(toIndentedString(hasBeenImported)).append("\n");
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

