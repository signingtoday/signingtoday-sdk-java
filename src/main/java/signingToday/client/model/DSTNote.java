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
import java.util.UUID;
import org.threeten.bp.OffsetDateTime;

/**
 * The _DSTNote_ represents a text note that can be attached to a DST whenever an entitled user needs it (when requesting for clarifications, informing of the proceedings, adding context) 
 */
@ApiModel(description = "The _DSTNote_ represents a text note that can be attached to a DST whenever an entitled user needs it (when requesting for clarifications, informing of the proceedings, adding context) ")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:13:36.809Z[GMT]")
public class DSTNote {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Long id;

  public static final String SERIALIZED_NAME_DST_ID = "dstId";
  @SerializedName(SERIALIZED_NAME_DST_ID)
  private UUID dstId;

  public static final String SERIALIZED_NAME_USER_ID = "userId";
  @SerializedName(SERIALIZED_NAME_USER_ID)
  private UUID userId;

  public static final String SERIALIZED_NAME_CREATED_AT = "createdAt";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private OffsetDateTime createdAt;

  public static final String SERIALIZED_NAME_TEXT = "text";
  @SerializedName(SERIALIZED_NAME_TEXT)
  private String text;


  public DSTNote id(Long id) {
    
    this.id = id;
    return this;
  }

   /**
   * The id of the note
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "32", value = "The id of the note")

  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public DSTNote dstId(UUID dstId) {
    
    this.dstId = dstId;
    return this;
  }

   /**
   * The _UUID_ code of the Digital Signature Transaction
   * @return dstId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "737dc132-a3f0-11e9-a2a3-2a2ae2dbcce4", value = "The _UUID_ code of the Digital Signature Transaction")

  public UUID getDstId() {
    return dstId;
  }


  public void setDstId(UUID dstId) {
    this.dstId = dstId;
  }


  public DSTNote userId(UUID userId) {
    
    this.userId = userId;
    return this;
  }

   /**
   * The _UUID_ code of the user which created the _Note_
   * @return userId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "123e4567-e89b-12d3-a456-426655440000", value = "The _UUID_ code of the user which created the _Note_")

  public UUID getUserId() {
    return userId;
  }


  public void setUserId(UUID userId) {
    this.userId = userId;
  }


  public DSTNote createdAt(OffsetDateTime createdAt) {
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * The _data-time_ of the note creation
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The _data-time_ of the note creation")

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }


  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }


  public DSTNote text(String text) {
    
    this.text = text;
    return this;
  }

   /**
   * Actual content of the _DST Note_
   * @return text
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "This a DSTNote sample", value = "Actual content of the _DST Note_")

  public String getText() {
    return text;
  }


  public void setText(String text) {
    this.text = text;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DSTNote dsTNote = (DSTNote) o;
    return Objects.equals(this.id, dsTNote.id) &&
        Objects.equals(this.dstId, dsTNote.dstId) &&
        Objects.equals(this.userId, dsTNote.userId) &&
        Objects.equals(this.createdAt, dsTNote.createdAt) &&
        Objects.equals(this.text, dsTNote.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dstId, userId, createdAt, text);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DSTNote {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dstId: ").append(toIndentedString(dstId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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

