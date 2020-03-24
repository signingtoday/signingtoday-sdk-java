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

/**
 * UpdateOrganization
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:35:42.543Z[GMT]")
public class UpdateOrganization {
  public static final String SERIALIZED_NAME_DEFAULT_RAO = "default_rao";
  @SerializedName(SERIALIZED_NAME_DEFAULT_RAO)
  private String defaultRao;

  public static final String SERIALIZED_NAME_DST_DEFAULT_DAYS = "dst_default_days";
  @SerializedName(SERIALIZED_NAME_DST_DEFAULT_DAYS)
  private Integer dstDefaultDays = 3;

  public static final String SERIALIZED_NAME_SIGNATURE_APPEARANCE = "signature_appearance";
  @SerializedName(SERIALIZED_NAME_SIGNATURE_APPEARANCE)
  private String signatureAppearance;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_LOGO = "logo";
  @SerializedName(SERIALIZED_NAME_LOGO)
  private String logo;


  public UpdateOrganization defaultRao(String defaultRao) {
    
    this.defaultRao = defaultRao;
    return this;
  }

   /**
   * This is the default *RAO* user of the Organization. A rao user is the one can associate identities to the other users 
   * @return defaultRao
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "jdo", value = "This is the default *RAO* user of the Organization. A rao user is the one can associate identities to the other users ")

  public String getDefaultRao() {
    return defaultRao;
  }


  public void setDefaultRao(String defaultRao) {
    this.defaultRao = defaultRao;
  }


  public UpdateOrganization dstDefaultDays(Integer dstDefaultDays) {
    
    this.dstDefaultDays = dstDefaultDays;
    return this;
  }

   /**
   * This is the default deadline before the expiration of a digital signature transaction
   * @return dstDefaultDays
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "3", value = "This is the default deadline before the expiration of a digital signature transaction")

  public Integer getDstDefaultDays() {
    return dstDefaultDays;
  }


  public void setDstDefaultDays(Integer dstDefaultDays) {
    this.dstDefaultDays = dstDefaultDays;
  }


  public UpdateOrganization signatureAppearance(String signatureAppearance) {
    
    this.signatureAppearance = signatureAppearance;
    return this;
  }

   /**
   * This is the url to the default signature appearance will be used for every member of the organization. In the scenario of a user that owns an identity with a signature_appearance will be uset the image associated to the identity rather than the default one 
   * @return signatureAppearance
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://www.my-organization.com/signature.png", value = "This is the url to the default signature appearance will be used for every member of the organization. In the scenario of a user that owns an identity with a signature_appearance will be uset the image associated to the identity rather than the default one ")

  public String getSignatureAppearance() {
    return signatureAppearance;
  }


  public void setSignatureAppearance(String signatureAppearance) {
    this.signatureAppearance = signatureAppearance;
  }


  public UpdateOrganization name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * This is an arbitrary name is possible to associate to the Organization 
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Bit4id", value = "This is an arbitrary name is possible to associate to the Organization ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public UpdateOrganization logo(String logo) {
    
    this.logo = logo;
    return this;
  }

   /**
   * This is the url to the image is supposed to be used as logo of the Organization, for example the logo or the motto of the company is integrating SigningToday 
   * @return logo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://www.my-organization.com/logo.png", value = "This is the url to the image is supposed to be used as logo of the Organization, for example the logo or the motto of the company is integrating SigningToday ")

  public String getLogo() {
    return logo;
  }


  public void setLogo(String logo) {
    this.logo = logo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateOrganization updateOrganization = (UpdateOrganization) o;
    return Objects.equals(this.defaultRao, updateOrganization.defaultRao) &&
        Objects.equals(this.dstDefaultDays, updateOrganization.dstDefaultDays) &&
        Objects.equals(this.signatureAppearance, updateOrganization.signatureAppearance) &&
        Objects.equals(this.name, updateOrganization.name) &&
        Objects.equals(this.logo, updateOrganization.logo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultRao, dstDefaultDays, signatureAppearance, name, logo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateOrganization {\n");
    sb.append("    defaultRao: ").append(toIndentedString(defaultRao)).append("\n");
    sb.append("    dstDefaultDays: ").append(toIndentedString(dstDefaultDays)).append("\n");
    sb.append("    signatureAppearance: ").append(toIndentedString(signatureAppearance)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    logo: ").append(toIndentedString(logo)).append("\n");
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

