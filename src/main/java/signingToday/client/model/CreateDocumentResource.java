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
import signingToday.client.model.CreateDocumentSource;

/**
 * The actual resource (e.g. a pdf file)
 */
@ApiModel(description = "The actual resource (e.g. a pdf file)")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:13:36.809Z[GMT]")
public class CreateDocumentResource {
  public static final String SERIALIZED_NAME_FILENAME = "filename";
  @SerializedName(SERIALIZED_NAME_FILENAME)
  private String filename;

  /**
   * Gets or Sets resourceType
   */
  @JsonAdapter(String.Adapter.class)
  public enum String {

    private String value;

    String(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static String fromValue(String value) {
      for (String b : String.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<String> {
      @Override
      public void write(final JsonWriter jsonWriter, final String enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public String read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return String.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_RESOURCE_TYPE = "resourceType";
  @SerializedName(SERIALIZED_NAME_RESOURCE_TYPE)
  private ResourceTypeEnum resourceType = null;

  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_SOURCE = "source";
  @SerializedName(SERIALIZED_NAME_SOURCE)
  private CreateDocumentSource source;


  public CreateDocumentResource filename(String filename) {
    
    this.filename = filename;
    return this;
  }

   /**
   * Get filename
   * @return filename
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "contract.pdf", value = "")

  public String getFilename() {
    return filename;
  }


  public void setFilename(String filename) {
    this.filename = filename;
  }


  public CreateDocumentResource resourceType(ResourceTypeEnum resourceType) {
    
    this.resourceType = resourceType;
    return this;
  }

  public CreateDocumentResource addResourceTypeItem(String resourceTypeItem) {
    if (this.resourceType == null) {
      this.resourceType = new ArrayList<String>();
    }
    this.resourceType.add(resourceTypeItem);
    return this;
  }

   /**
   * Get resourceType
   * @return resourceType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ResourceTypeEnum getResourceType() {
    return resourceType;
  }


  public void setResourceType(ResourceTypeEnum resourceType) {
    this.resourceType = resourceType;
  }


  public CreateDocumentResource title(String title) {
    
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Sales Contract", value = "")

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public CreateDocumentResource source(CreateDocumentSource source) {
    
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CreateDocumentSource getSource() {
    return source;
  }


  public void setSource(CreateDocumentSource source) {
    this.source = source;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDocumentResource createDocumentResource = (CreateDocumentResource) o;
    return Objects.equals(this.filename, createDocumentResource.filename) &&
        Objects.equals(this.resourceType, createDocumentResource.resourceType) &&
        Objects.equals(this.title, createDocumentResource.title) &&
        Objects.equals(this.source, createDocumentResource.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filename, resourceType, title, source);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDocumentResource {\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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

