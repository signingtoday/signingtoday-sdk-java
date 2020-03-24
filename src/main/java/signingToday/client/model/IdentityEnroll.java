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
import signingToday.client.model.IdentityEnrollActions;

/**
 * IdentityEnroll
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:35:42.543Z[GMT]")
public class IdentityEnroll {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private UUID id;

  /**
   * Gets or Sets status
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
  private IdentityEnrollActions actions;

  public static final String SERIALIZED_NAME_PROVIDER = "provider";
  @SerializedName(SERIALIZED_NAME_PROVIDER)
  private String provider;

  public static final String SERIALIZED_NAME_LABEL = "label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_PROVIDER_TYPE = "provider_type";
  @SerializedName(SERIALIZED_NAME_PROVIDER_TYPE)
  private String providerType;

  public static final String SERIALIZED_NAME_USER = "user";
  @SerializedName(SERIALIZED_NAME_USER)
  private String user;

  public static final String SERIALIZED_NAME_REGISTERED_BY = "registered_by";
  @SerializedName(SERIALIZED_NAME_REGISTERED_BY)
  private String registeredBy;

  public static final String SERIALIZED_NAME_PROVIDER_DATA = "provider_data";
  @SerializedName(SERIALIZED_NAME_PROVIDER_DATA)
  private Object providerData;

  public static final String SERIALIZED_NAME_ENROLL_TICKET = "enroll_ticket";
  @SerializedName(SERIALIZED_NAME_ENROLL_TICKET)
  private String enrollTicket;

  public static final String SERIALIZED_NAME_CREATED_BY = "created_by";
  @SerializedName(SERIALIZED_NAME_CREATED_BY)
  private String createdBy;

  public static final String SERIALIZED_NAME_URLBACK = "urlback";
  @SerializedName(SERIALIZED_NAME_URLBACK)
  private String urlback;


  public IdentityEnroll id(UUID id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4", value = "")

  public UUID getId() {
    return id;
  }


  public void setId(UUID id) {
    this.id = id;
  }


  public IdentityEnroll status(StatusEnum status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "active", value = "")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  public IdentityEnroll next(String next) {
    
    this.next = next;
    return this;
  }

   /**
   * Get next
   * @return next
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "next activity to complete sample", value = "")

  public String getNext() {
    return next;
  }


  public void setNext(String next) {
    this.next = next;
  }


  public IdentityEnroll actions(IdentityEnrollActions actions) {
    
    this.actions = actions;
    return this;
  }

   /**
   * Get actions
   * @return actions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public IdentityEnrollActions getActions() {
    return actions;
  }


  public void setActions(IdentityEnrollActions actions) {
    this.actions = actions;
  }


  public IdentityEnroll provider(String provider) {
    
    this.provider = provider;
    return this;
  }

   /**
   * Get provider
   * @return provider
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "system provider", value = "")

  public String getProvider() {
    return provider;
  }


  public void setProvider(String provider) {
    this.provider = provider;
  }


  public IdentityEnroll label(String label) {
    
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "identity provider", value = "")

  public String getLabel() {
    return label;
  }


  public void setLabel(String label) {
    this.label = label;
  }


  public IdentityEnroll providerType(String providerType) {
    
    this.providerType = providerType;
    return this;
  }

   /**
   * Get providerType
   * @return providerType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "provider type", value = "")

  public String getProviderType() {
    return providerType;
  }


  public void setProviderType(String providerType) {
    this.providerType = providerType;
  }


  public IdentityEnroll user(String user) {
    
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "jdo", value = "")

  public String getUser() {
    return user;
  }


  public void setUser(String user) {
    this.user = user;
  }


  public IdentityEnroll registeredBy(String registeredBy) {
    
    this.registeredBy = registeredBy;
    return this;
  }

   /**
   * Get registeredBy
   * @return registeredBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "jdo", value = "")

  public String getRegisteredBy() {
    return registeredBy;
  }


  public void setRegisteredBy(String registeredBy) {
    this.registeredBy = registeredBy;
  }


  public IdentityEnroll providerData(Object providerData) {
    
    this.providerData = providerData;
    return this;
  }

   /**
   * Data of the provider that issued the certificate, it is variable from to provider to provider
   * @return providerData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "{}", value = "Data of the provider that issued the certificate, it is variable from to provider to provider")

  public Object getProviderData() {
    return providerData;
  }


  public void setProviderData(Object providerData) {
    this.providerData = providerData;
  }


  public IdentityEnroll enrollTicket(String enrollTicket) {
    
    this.enrollTicket = enrollTicket;
    return this;
  }

   /**
   * Get enrollTicket
   * @return enrollTicket
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://signing.today/sample/enroll-ticket", value = "")

  public String getEnrollTicket() {
    return enrollTicket;
  }


  public void setEnrollTicket(String enrollTicket) {
    this.enrollTicket = enrollTicket;
  }


  public IdentityEnroll createdBy(String createdBy) {
    
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Get createdBy
   * @return createdBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "admin@sample.com", value = "")

  public String getCreatedBy() {
    return createdBy;
  }


  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public IdentityEnroll urlback(String urlback) {
    
    this.urlback = urlback;
    return this;
  }

   /**
   * Get urlback
   * @return urlback
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://signing.today/sample/home", value = "")

  public String getUrlback() {
    return urlback;
  }


  public void setUrlback(String urlback) {
    this.urlback = urlback;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityEnroll identityEnroll = (IdentityEnroll) o;
    return Objects.equals(this.id, identityEnroll.id) &&
        Objects.equals(this.status, identityEnroll.status) &&
        Objects.equals(this.next, identityEnroll.next) &&
        Objects.equals(this.actions, identityEnroll.actions) &&
        Objects.equals(this.provider, identityEnroll.provider) &&
        Objects.equals(this.label, identityEnroll.label) &&
        Objects.equals(this.providerType, identityEnroll.providerType) &&
        Objects.equals(this.user, identityEnroll.user) &&
        Objects.equals(this.registeredBy, identityEnroll.registeredBy) &&
        Objects.equals(this.providerData, identityEnroll.providerData) &&
        Objects.equals(this.enrollTicket, identityEnroll.enrollTicket) &&
        Objects.equals(this.createdBy, identityEnroll.createdBy) &&
        Objects.equals(this.urlback, identityEnroll.urlback);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, next, actions, provider, label, providerType, user, registeredBy, providerData, enrollTicket, createdBy, urlback);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentityEnroll {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    providerType: ").append(toIndentedString(providerType)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    registeredBy: ").append(toIndentedString(registeredBy)).append("\n");
    sb.append("    providerData: ").append(toIndentedString(providerData)).append("\n");
    sb.append("    enrollTicket: ").append(toIndentedString(enrollTicket)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    urlback: ").append(toIndentedString(urlback)).append("\n");
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

