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
import signingToday.client.model.OrganizationSettingsAlfrescoProperties;

/**
 * OrganizationSettings
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:13:36.809Z[GMT]")
public class OrganizationSettings {
  public static final String SERIALIZED_NAME_DEFAULT_D_S_T_EXPIRE_DAYS = "defaultDSTExpire_days";
  @SerializedName(SERIALIZED_NAME_DEFAULT_D_S_T_EXPIRE_DAYS)
  private Integer defaultDSTExpireDays = 30;

  /**
   * Gets or Sets defaultLanguage
   */
  @JsonAdapter(DefaultLanguageEnum.Adapter.class)
  public enum DefaultLanguageEnum {
    IT("it"),
    
    EN("en"),
    
    ES("es"),
    
    FR("fr");

    private String value;

    DefaultLanguageEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DefaultLanguageEnum fromValue(String value) {
      for (DefaultLanguageEnum b : DefaultLanguageEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DefaultLanguageEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DefaultLanguageEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DefaultLanguageEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DefaultLanguageEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DEFAULT_LANGUAGE = "defaultLanguage";
  @SerializedName(SERIALIZED_NAME_DEFAULT_LANGUAGE)
  private DefaultLanguageEnum defaultLanguage;

  public static final String SERIALIZED_NAME_ALFRESCO_PROPERTIES = "alfrescoProperties";
  @SerializedName(SERIALIZED_NAME_ALFRESCO_PROPERTIES)
  private OrganizationSettingsAlfrescoProperties alfrescoProperties;


  public OrganizationSettings defaultDSTExpireDays(Integer defaultDSTExpireDays) {
    
    this.defaultDSTExpireDays = defaultDSTExpireDays;
    return this;
  }

   /**
   * Get defaultDSTExpireDays
   * @return defaultDSTExpireDays
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "30", value = "")

  public Integer getDefaultDSTExpireDays() {
    return defaultDSTExpireDays;
  }


  public void setDefaultDSTExpireDays(Integer defaultDSTExpireDays) {
    this.defaultDSTExpireDays = defaultDSTExpireDays;
  }


  public OrganizationSettings defaultLanguage(DefaultLanguageEnum defaultLanguage) {
    
    this.defaultLanguage = defaultLanguage;
    return this;
  }

   /**
   * Get defaultLanguage
   * @return defaultLanguage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public DefaultLanguageEnum getDefaultLanguage() {
    return defaultLanguage;
  }


  public void setDefaultLanguage(DefaultLanguageEnum defaultLanguage) {
    this.defaultLanguage = defaultLanguage;
  }


  public OrganizationSettings alfrescoProperties(OrganizationSettingsAlfrescoProperties alfrescoProperties) {
    
    this.alfrescoProperties = alfrescoProperties;
    return this;
  }

   /**
   * Get alfrescoProperties
   * @return alfrescoProperties
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OrganizationSettingsAlfrescoProperties getAlfrescoProperties() {
    return alfrescoProperties;
  }


  public void setAlfrescoProperties(OrganizationSettingsAlfrescoProperties alfrescoProperties) {
    this.alfrescoProperties = alfrescoProperties;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationSettings organizationSettings = (OrganizationSettings) o;
    return Objects.equals(this.defaultDSTExpireDays, organizationSettings.defaultDSTExpireDays) &&
        Objects.equals(this.defaultLanguage, organizationSettings.defaultLanguage) &&
        Objects.equals(this.alfrescoProperties, organizationSettings.alfrescoProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultDSTExpireDays, defaultLanguage, alfrescoProperties);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationSettings {\n");
    sb.append("    defaultDSTExpireDays: ").append(toIndentedString(defaultDSTExpireDays)).append("\n");
    sb.append("    defaultLanguage: ").append(toIndentedString(defaultLanguage)).append("\n");
    sb.append("    alfrescoProperties: ").append(toIndentedString(alfrescoProperties)).append("\n");
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

