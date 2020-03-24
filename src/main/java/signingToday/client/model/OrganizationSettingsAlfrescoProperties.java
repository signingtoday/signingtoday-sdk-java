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
 * OrganizationSettingsAlfrescoProperties
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:13:36.809Z[GMT]")
public class OrganizationSettingsAlfrescoProperties {
  public static final String SERIALIZED_NAME_ENABLED = "enabled";
  @SerializedName(SERIALIZED_NAME_ENABLED)
  private Boolean enabled = false;

  /**
   * Gets or Sets type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    REST("rest"),
    
    CMIS("cmis");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_USERNAME = "username";
  @SerializedName(SERIALIZED_NAME_USERNAME)
  private String username;

  public static final String SERIALIZED_NAME_PASSWORD = "password";
  @SerializedName(SERIALIZED_NAME_PASSWORD)
  private String password;

  public static final String SERIALIZED_NAME_BASE_PATH = "basePath";
  @SerializedName(SERIALIZED_NAME_BASE_PATH)
  private String basePath;

  public static final String SERIALIZED_NAME_RELATIVE_PATH = "relativePath";
  @SerializedName(SERIALIZED_NAME_RELATIVE_PATH)
  private String relativePath;

  public static final String SERIALIZED_NAME_BASE_NODE_ID = "baseNodeId";
  @SerializedName(SERIALIZED_NAME_BASE_NODE_ID)
  private String baseNodeId;


  public OrganizationSettingsAlfrescoProperties enabled(Boolean enabled) {
    
    this.enabled = enabled;
    return this;
  }

   /**
   * Get enabled
   * @return enabled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getEnabled() {
    return enabled;
  }


  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }


  public OrganizationSettingsAlfrescoProperties type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    this.type = type;
  }


  public OrganizationSettingsAlfrescoProperties username(String username) {
    
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  public OrganizationSettingsAlfrescoProperties password(String password) {
    
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public OrganizationSettingsAlfrescoProperties basePath(String basePath) {
    
    this.basePath = basePath;
    return this;
  }

   /**
   * Get basePath
   * @return basePath
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getBasePath() {
    return basePath;
  }


  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }


  public OrganizationSettingsAlfrescoProperties relativePath(String relativePath) {
    
    this.relativePath = relativePath;
    return this;
  }

   /**
   * Get relativePath
   * @return relativePath
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getRelativePath() {
    return relativePath;
  }


  public void setRelativePath(String relativePath) {
    this.relativePath = relativePath;
  }


  public OrganizationSettingsAlfrescoProperties baseNodeId(String baseNodeId) {
    
    this.baseNodeId = baseNodeId;
    return this;
  }

   /**
   * Get baseNodeId
   * @return baseNodeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getBaseNodeId() {
    return baseNodeId;
  }


  public void setBaseNodeId(String baseNodeId) {
    this.baseNodeId = baseNodeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationSettingsAlfrescoProperties organizationSettingsAlfrescoProperties = (OrganizationSettingsAlfrescoProperties) o;
    return Objects.equals(this.enabled, organizationSettingsAlfrescoProperties.enabled) &&
        Objects.equals(this.type, organizationSettingsAlfrescoProperties.type) &&
        Objects.equals(this.username, organizationSettingsAlfrescoProperties.username) &&
        Objects.equals(this.password, organizationSettingsAlfrescoProperties.password) &&
        Objects.equals(this.basePath, organizationSettingsAlfrescoProperties.basePath) &&
        Objects.equals(this.relativePath, organizationSettingsAlfrescoProperties.relativePath) &&
        Objects.equals(this.baseNodeId, organizationSettingsAlfrescoProperties.baseNodeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, type, username, password, basePath, relativePath, baseNodeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationSettingsAlfrescoProperties {\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    basePath: ").append(toIndentedString(basePath)).append("\n");
    sb.append("    relativePath: ").append(toIndentedString(relativePath)).append("\n");
    sb.append("    baseNodeId: ").append(toIndentedString(baseNodeId)).append("\n");
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

