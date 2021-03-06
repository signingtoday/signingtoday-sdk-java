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
import org.threeten.bp.OffsetDateTime;
import signingToday.client.model.SAMLTokenEduPersonTargetedID;

/**
 * SAMLToken
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:13:36.809Z[GMT]")
public class SAMLToken {
  public static final String SERIALIZED_NAME_NOT_ONORAFTER = "_not_onorafter";
  @SerializedName(SERIALIZED_NAME_NOT_ONORAFTER)
  private OffsetDateTime notOnorafter;

  public static final String SERIALIZED_NAME_SURNAME = "surname";
  @SerializedName(SERIALIZED_NAME_SURNAME)
  private String surname;

  public static final String SERIALIZED_NAME_GIVEN_NAME = "givenName";
  @SerializedName(SERIALIZED_NAME_GIVEN_NAME)
  private String givenName;

  public static final String SERIALIZED_NAME_COMMON_NAME = "commonName";
  @SerializedName(SERIALIZED_NAME_COMMON_NAME)
  private String commonName;

  public static final String SERIALIZED_NAME_RFC822_MAILBOX = "rfc822Mailbox";
  @SerializedName(SERIALIZED_NAME_RFC822_MAILBOX)
  private String rfc822Mailbox;

  public static final String SERIALIZED_NAME_NOT_BEFORE = "_not_before";
  @SerializedName(SERIALIZED_NAME_NOT_BEFORE)
  private OffsetDateTime notBefore;

  public static final String SERIALIZED_NAME_USERID = "userid";
  @SerializedName(SERIALIZED_NAME_USERID)
  private String userid;

  public static final String SERIALIZED_NAME_MAIL_ALTERNATE_ADDRESS = "mailAlternateAddress";
  @SerializedName(SERIALIZED_NAME_MAIL_ALTERNATE_ADDRESS)
  private String mailAlternateAddress;

  public static final String SERIALIZED_NAME_EDU_PERSON_ORG_D_N = "eduPersonOrgDN";
  @SerializedName(SERIALIZED_NAME_EDU_PERSON_ORG_D_N)
  private String eduPersonOrgDN;

  public static final String SERIALIZED_NAME_EDU_PERSON_PRINCIPAL_NAME = "eduPersonPrincipalName";
  @SerializedName(SERIALIZED_NAME_EDU_PERSON_PRINCIPAL_NAME)
  private String eduPersonPrincipalName;

  public static final String SERIALIZED_NAME_IS_MEMBER_OF = "isMemberOf";
  @SerializedName(SERIALIZED_NAME_IS_MEMBER_OF)
  private List<String> isMemberOf = null;

  public static final String SERIALIZED_NAME_GROUPS = "groups";
  @SerializedName(SERIALIZED_NAME_GROUPS)
  private List<String> groups = null;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_EDU_PERSON_TARGETED_I_D = "eduPersonTargetedID";
  @SerializedName(SERIALIZED_NAME_EDU_PERSON_TARGETED_I_D)
  private SAMLTokenEduPersonTargetedID eduPersonTargetedID;

  public static final String SERIALIZED_NAME_COOKIES = "_cookies";
  @SerializedName(SERIALIZED_NAME_COOKIES)
  private String cookies;


  public SAMLToken notOnorafter(OffsetDateTime notOnorafter) {
    
    this.notOnorafter = notOnorafter;
    return this;
  }

   /**
   * Get notOnorafter
   * @return notOnorafter
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2019-03-01T16:46:59Z", value = "")

  public OffsetDateTime getNotOnorafter() {
    return notOnorafter;
  }


  public void setNotOnorafter(OffsetDateTime notOnorafter) {
    this.notOnorafter = notOnorafter;
  }


  public SAMLToken surname(String surname) {
    
    this.surname = surname;
    return this;
  }

   /**
   * Get surname
   * @return surname
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Palazzo", value = "")

  public String getSurname() {
    return surname;
  }


  public void setSurname(String surname) {
    this.surname = surname;
  }


  public SAMLToken givenName(String givenName) {
    
    this.givenName = givenName;
    return this;
  }

   /**
   * Get givenName
   * @return givenName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Vincenzo", value = "")

  public String getGivenName() {
    return givenName;
  }


  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }


  public SAMLToken commonName(String commonName) {
    
    this.commonName = commonName;
    return this;
  }

   /**
   * Get commonName
   * @return commonName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Vincenzo Palazzo", value = "")

  public String getCommonName() {
    return commonName;
  }


  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }


  public SAMLToken rfc822Mailbox(String rfc822Mailbox) {
    
    this.rfc822Mailbox = rfc822Mailbox;
    return this;
  }

   /**
   * Get rfc822Mailbox
   * @return rfc822Mailbox
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "vpa@bit4id.com", value = "")

  public String getRfc822Mailbox() {
    return rfc822Mailbox;
  }


  public void setRfc822Mailbox(String rfc822Mailbox) {
    this.rfc822Mailbox = rfc822Mailbox;
  }


  public SAMLToken notBefore(OffsetDateTime notBefore) {
    
    this.notBefore = notBefore;
    return this;
  }

   /**
   * Get notBefore
   * @return notBefore
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2019-03-01T16:41:29Z", value = "")

  public OffsetDateTime getNotBefore() {
    return notBefore;
  }


  public void setNotBefore(OffsetDateTime notBefore) {
    this.notBefore = notBefore;
  }


  public SAMLToken userid(String userid) {
    
    this.userid = userid;
    return this;
  }

   /**
   * Get userid
   * @return userid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "VP-51635", value = "")

  public String getUserid() {
    return userid;
  }


  public void setUserid(String userid) {
    this.userid = userid;
  }


  public SAMLToken mailAlternateAddress(String mailAlternateAddress) {
    
    this.mailAlternateAddress = mailAlternateAddress;
    return this;
  }

   /**
   * Get mailAlternateAddress
   * @return mailAlternateAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "vpa@bit4id.com", value = "")

  public String getMailAlternateAddress() {
    return mailAlternateAddress;
  }


  public void setMailAlternateAddress(String mailAlternateAddress) {
    this.mailAlternateAddress = mailAlternateAddress;
  }


  public SAMLToken eduPersonOrgDN(String eduPersonOrgDN) {
    
    this.eduPersonOrgDN = eduPersonOrgDN;
    return this;
  }

   /**
   * Get eduPersonOrgDN
   * @return eduPersonOrgDN
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "cc3dbbdd1e7cb592cb2ba24d461ec24656f3daa4@infn.it", value = "")

  public String getEduPersonOrgDN() {
    return eduPersonOrgDN;
  }


  public void setEduPersonOrgDN(String eduPersonOrgDN) {
    this.eduPersonOrgDN = eduPersonOrgDN;
  }


  public SAMLToken eduPersonPrincipalName(String eduPersonPrincipalName) {
    
    this.eduPersonPrincipalName = eduPersonPrincipalName;
    return this;
  }

   /**
   * Get eduPersonPrincipalName
   * @return eduPersonPrincipalName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "VP-51635@infn.it", value = "")

  public String getEduPersonPrincipalName() {
    return eduPersonPrincipalName;
  }


  public void setEduPersonPrincipalName(String eduPersonPrincipalName) {
    this.eduPersonPrincipalName = eduPersonPrincipalName;
  }


  public SAMLToken isMemberOf(List<String> isMemberOf) {
    
    this.isMemberOf = isMemberOf;
    return this;
  }

  public SAMLToken addIsMemberOfItem(String isMemberOfItem) {
    if (this.isMemberOf == null) {
      this.isMemberOf = new ArrayList<String>();
    }
    this.isMemberOf.add(isMemberOfItem);
    return this;
  }

   /**
   * Get isMemberOf
   * @return isMemberOf
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getIsMemberOf() {
    return isMemberOf;
  }


  public void setIsMemberOf(List<String> isMemberOf) {
    this.isMemberOf = isMemberOf;
  }


  public SAMLToken groups(List<String> groups) {
    
    this.groups = groups;
    return this;
  }

  public SAMLToken addGroupsItem(String groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<String>();
    }
    this.groups.add(groupsItem);
    return this;
  }

   /**
   * Get groups
   * @return groups
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[]", value = "")

  public List<String> getGroups() {
    return groups;
  }


  public void setGroups(List<String> groups) {
    this.groups = groups;
  }


  public SAMLToken displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Vincenzo Palazzo", value = "")

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public SAMLToken eduPersonTargetedID(SAMLTokenEduPersonTargetedID eduPersonTargetedID) {
    
    this.eduPersonTargetedID = eduPersonTargetedID;
    return this;
  }

   /**
   * Get eduPersonTargetedID
   * @return eduPersonTargetedID
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SAMLTokenEduPersonTargetedID getEduPersonTargetedID() {
    return eduPersonTargetedID;
  }


  public void setEduPersonTargetedID(SAMLTokenEduPersonTargetedID eduPersonTargetedID) {
    this.eduPersonTargetedID = eduPersonTargetedID;
  }


  public SAMLToken cookies(String cookies) {
    
    this.cookies = cookies;
    return this;
  }

   /**
   * Get cookies
   * @return cookies
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCookies() {
    return cookies;
  }


  public void setCookies(String cookies) {
    this.cookies = cookies;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SAMLToken saMLToken = (SAMLToken) o;
    return Objects.equals(this.notOnorafter, saMLToken.notOnorafter) &&
        Objects.equals(this.surname, saMLToken.surname) &&
        Objects.equals(this.givenName, saMLToken.givenName) &&
        Objects.equals(this.commonName, saMLToken.commonName) &&
        Objects.equals(this.rfc822Mailbox, saMLToken.rfc822Mailbox) &&
        Objects.equals(this.notBefore, saMLToken.notBefore) &&
        Objects.equals(this.userid, saMLToken.userid) &&
        Objects.equals(this.mailAlternateAddress, saMLToken.mailAlternateAddress) &&
        Objects.equals(this.eduPersonOrgDN, saMLToken.eduPersonOrgDN) &&
        Objects.equals(this.eduPersonPrincipalName, saMLToken.eduPersonPrincipalName) &&
        Objects.equals(this.isMemberOf, saMLToken.isMemberOf) &&
        Objects.equals(this.groups, saMLToken.groups) &&
        Objects.equals(this.displayName, saMLToken.displayName) &&
        Objects.equals(this.eduPersonTargetedID, saMLToken.eduPersonTargetedID) &&
        Objects.equals(this.cookies, saMLToken.cookies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notOnorafter, surname, givenName, commonName, rfc822Mailbox, notBefore, userid, mailAlternateAddress, eduPersonOrgDN, eduPersonPrincipalName, isMemberOf, groups, displayName, eduPersonTargetedID, cookies);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SAMLToken {\n");
    sb.append("    notOnorafter: ").append(toIndentedString(notOnorafter)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    commonName: ").append(toIndentedString(commonName)).append("\n");
    sb.append("    rfc822Mailbox: ").append(toIndentedString(rfc822Mailbox)).append("\n");
    sb.append("    notBefore: ").append(toIndentedString(notBefore)).append("\n");
    sb.append("    userid: ").append(toIndentedString(userid)).append("\n");
    sb.append("    mailAlternateAddress: ").append(toIndentedString(mailAlternateAddress)).append("\n");
    sb.append("    eduPersonOrgDN: ").append(toIndentedString(eduPersonOrgDN)).append("\n");
    sb.append("    eduPersonPrincipalName: ").append(toIndentedString(eduPersonPrincipalName)).append("\n");
    sb.append("    isMemberOf: ").append(toIndentedString(isMemberOf)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    eduPersonTargetedID: ").append(toIndentedString(eduPersonTargetedID)).append("\n");
    sb.append("    cookies: ").append(toIndentedString(cookies)).append("\n");
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

