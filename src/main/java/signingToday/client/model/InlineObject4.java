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

/**
 * InlineObject4
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:13:36.809Z[GMT]")
public class InlineObject4 {
  public static final String SERIALIZED_NAME_CURRENT_PASSWORD = "currentPassword";
  @SerializedName(SERIALIZED_NAME_CURRENT_PASSWORD)
  private String currentPassword;

  public static final String SERIALIZED_NAME_NEW_PASSWORD = "newPassword";
  @SerializedName(SERIALIZED_NAME_NEW_PASSWORD)
  private String newPassword;


  public InlineObject4 currentPassword(String currentPassword) {
    
    this.currentPassword = currentPassword;
    return this;
  }

   /**
   * The current password of the user
   * @return currentPassword
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "a12345678Z", value = "The current password of the user")

  public String getCurrentPassword() {
    return currentPassword;
  }


  public void setCurrentPassword(String currentPassword) {
    this.currentPassword = currentPassword;
  }


  public InlineObject4 newPassword(String newPassword) {
    
    this.newPassword = newPassword;
    return this;
  }

   /**
   * The new password choosen
   * @return newPassword
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0abcdefgH9", value = "The new password choosen")

  public String getNewPassword() {
    return newPassword;
  }


  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObject4 inlineObject4 = (InlineObject4) o;
    return Objects.equals(this.currentPassword, inlineObject4.currentPassword) &&
        Objects.equals(this.newPassword, inlineObject4.newPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPassword, newPassword);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject4 {\n");
    sb.append("    currentPassword: ").append(toIndentedString(currentPassword)).append("\n");
    sb.append("    newPassword: ").append(toIndentedString(newPassword)).append("\n");
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

