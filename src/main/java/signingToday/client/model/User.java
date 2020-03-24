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
import signingToday.client.model.Identity;

/**
 * The User object is one of the components of the organization, which can sign digital signature transactions through one of the identities it got in the its wallet. Some of the most specific fields of this object are _\&quot;automatic\&quot;_, _\&quot;rao\&quot;_ and _\&quot;owner\&quot;_. They are boolean values. The first one indicates if the User can sign dsts into an automatic way, without passing through the signature tray. The rao field allows the User to enroll identities for the users of its organization. At last the owner field means that the token associated to the organization belongs to it and thus this particular User has administrative permissions. 
 */
@ApiModel(description = "The User object is one of the components of the organization, which can sign digital signature transactions through one of the identities it got in the its wallet. Some of the most specific fields of this object are _\"automatic\"_, _\"rao\"_ and _\"owner\"_. They are boolean values. The first one indicates if the User can sign dsts into an automatic way, without passing through the signature tray. The rao field allows the User to enroll identities for the users of its organization. At last the owner field means that the token associated to the organization belongs to it and thus this particular User has administrative permissions. ")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:35:42.543Z[GMT]")
public class User {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private UUID id;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_FIRST_NAME = "first_name";
  @SerializedName(SERIALIZED_NAME_FIRST_NAME)
  private String firstName;

  public static final String SERIALIZED_NAME_LAST_NAME = "last_name";
  @SerializedName(SERIALIZED_NAME_LAST_NAME)
  private String lastName;

  public static final String SERIALIZED_NAME_CREATED_BY = "created_by";
  @SerializedName(SERIALIZED_NAME_CREATED_BY)
  private String createdBy;

  public static final String SERIALIZED_NAME_AUTOMATIC = "automatic";
  @SerializedName(SERIALIZED_NAME_AUTOMATIC)
  private Boolean automatic;

  public static final String SERIALIZED_NAME_OWNER = "owner";
  @SerializedName(SERIALIZED_NAME_OWNER)
  private Boolean owner;

  public static final String SERIALIZED_NAME_RAO = "rao";
  @SerializedName(SERIALIZED_NAME_RAO)
  private Boolean rao;

  public static final String SERIALIZED_NAME_WALLET = "wallet";
  @SerializedName(SERIALIZED_NAME_WALLET)
  private List<Identity> wallet = null;


  public User id(UUID id) {
    
    this.id = id;
    return this;
  }

   /**
   * The uuid code that identifies the User
   * @return id
  **/
  @ApiModelProperty(example = "737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4", required = true, value = "The uuid code that identifies the User")

  public UUID getId() {
    return id;
  }


  public void setId(UUID id) {
    this.id = id;
  }


  public User status(String status) {
    
    this.status = status;
    return this;
  }

   /**
   * The status of the User
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "enabled", value = "The status of the User")

  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    this.status = status;
  }


  public User type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * The _type field_ identifies the permissions the User have
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Basic user account", value = "The _type field_ identifies the permissions the User have")

  public String getType() {
    return type;
  }


  public void setType(String type) {
    this.type = type;
  }


  public User email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * The email associated to the User
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "jdo@example.com", value = "The email associated to the User")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public User firstName(String firstName) {
    
    this.firstName = firstName;
    return this;
  }

   /**
   * First name of the User
   * @return firstName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "John", value = "First name of the User")

  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public User lastName(String lastName) {
    
    this.lastName = lastName;
    return this;
  }

   /**
   * Last name of the User
   * @return lastName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Doe", value = "Last name of the User")

  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public User createdBy(String createdBy) {
    
    this.createdBy = createdBy;
    return this;
  }

   /**
   * This field shows who created the User - _user_name@organization-id_. It may be a SigningToday system User as well
   * @return createdBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "system", value = "This field shows who created the User - _user_name@organization-id_. It may be a SigningToday system User as well")

  public String getCreatedBy() {
    return createdBy;
  }


  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public User automatic(Boolean automatic) {
    
    this.automatic = automatic;
    return this;
  }

   /**
   * If true indicates that the User is an _automatic_ one, thus the signature procedure will be different from a regular signer
   * @return automatic
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "If true indicates that the User is an _automatic_ one, thus the signature procedure will be different from a regular signer")

  public Boolean getAutomatic() {
    return automatic;
  }


  public void setAutomatic(Boolean automatic) {
    this.automatic = automatic;
  }


  public User owner(Boolean owner) {
    
    this.owner = owner;
    return this;
  }

   /**
   * The _owner field_ gives to the User administrative permissions
   * @return owner
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "The _owner field_ gives to the User administrative permissions")

  public Boolean getOwner() {
    return owner;
  }


  public void setOwner(Boolean owner) {
    this.owner = owner;
  }


  public User rao(Boolean rao) {
    
    this.rao = rao;
    return this;
  }

   /**
   * The _rao field_ identifies a RAO User, the one can associate identities to the other users
   * @return rao
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "The _rao field_ identifies a RAO User, the one can associate identities to the other users")

  public Boolean getRao() {
    return rao;
  }


  public void setRao(Boolean rao) {
    this.rao = rao;
  }


  public User wallet(List<Identity> wallet) {
    
    this.wallet = wallet;
    return this;
  }

  public User addWalletItem(Identity walletItem) {
    if (this.wallet == null) {
      this.wallet = new ArrayList<Identity>();
    }
    this.wallet.add(walletItem);
    return this;
  }

   /**
   * The wallet of an User identifies its portfolio of identities
   * @return wallet
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The wallet of an User identifies its portfolio of identities")

  public List<Identity> getWallet() {
    return wallet;
  }


  public void setWallet(List<Identity> wallet) {
    this.wallet = wallet;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.status, user.status) &&
        Objects.equals(this.type, user.type) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.firstName, user.firstName) &&
        Objects.equals(this.lastName, user.lastName) &&
        Objects.equals(this.createdBy, user.createdBy) &&
        Objects.equals(this.automatic, user.automatic) &&
        Objects.equals(this.owner, user.owner) &&
        Objects.equals(this.rao, user.rao) &&
        Objects.equals(this.wallet, user.wallet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, type, email, firstName, lastName, createdBy, automatic, owner, rao, wallet);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    automatic: ").append(toIndentedString(automatic)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    rao: ").append(toIndentedString(rao)).append("\n");
    sb.append("    wallet: ").append(toIndentedString(wallet)).append("\n");
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

