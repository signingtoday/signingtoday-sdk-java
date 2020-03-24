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
import signingToday.client.model.FillableForm;
import signingToday.client.model.SignatureStatusChangedNotificationDocument;
import signingToday.client.model.SignatureStatusChangedNotificationDst;

/**
 * SignatureStatusChangedNotification
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:13:36.809Z[GMT]")
public class SignatureStatusChangedNotification {
  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    PENDING("pending"),
    
    PERFORMED("performed"),
    
    EXPIRED("expired"),
    
    ERROR("error"),
    
    DECLINED("declined");

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

  public static final String SERIALIZED_NAME_GROUP = "group";
  @SerializedName(SERIALIZED_NAME_GROUP)
  private Integer group;

  /**
   * Gets or Sets action
   */
  @JsonAdapter(ActionEnum.Adapter.class)
  public enum ActionEnum {
    FILL("fill"),
    
    SIGN("sign");

    private String value;

    ActionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ActionEnum fromValue(String value) {
      for (ActionEnum b : ActionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ActionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ActionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ActionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ActionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ACTION = "action";
  @SerializedName(SERIALIZED_NAME_ACTION)
  private ActionEnum action;

  public static final String SERIALIZED_NAME_DST = "dst";
  @SerializedName(SERIALIZED_NAME_DST)
  private SignatureStatusChangedNotificationDst dst;

  public static final String SERIALIZED_NAME_FILLABLE_FORM = "fillableForm";
  @SerializedName(SERIALIZED_NAME_FILLABLE_FORM)
  private FillableForm fillableForm;

  public static final String SERIALIZED_NAME_SIGNATURE = "signature";
  @SerializedName(SERIALIZED_NAME_SIGNATURE)
  private Integer signature;

  public static final String SERIALIZED_NAME_SIGNER = "signer";
  @SerializedName(SERIALIZED_NAME_SIGNER)
  private String signer;

  public static final String SERIALIZED_NAME_DOCUMENT = "document";
  @SerializedName(SERIALIZED_NAME_DOCUMENT)
  private SignatureStatusChangedNotificationDocument document;

  public static final String SERIALIZED_NAME_AUTOMATIC = "automatic";
  @SerializedName(SERIALIZED_NAME_AUTOMATIC)
  private Boolean automatic;

  public static final String SERIALIZED_NAME_PAGE = "page";
  @SerializedName(SERIALIZED_NAME_PAGE)
  private Integer page;


  public SignatureStatusChangedNotification status(StatusEnum status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  public SignatureStatusChangedNotification group(Integer group) {
    
    this.group = group;
    return this;
  }

   /**
   * Get group
   * @return group
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getGroup() {
    return group;
  }


  public void setGroup(Integer group) {
    this.group = group;
  }


  public SignatureStatusChangedNotification action(ActionEnum action) {
    
    this.action = action;
    return this;
  }

   /**
   * Get action
   * @return action
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ActionEnum getAction() {
    return action;
  }


  public void setAction(ActionEnum action) {
    this.action = action;
  }


  public SignatureStatusChangedNotification dst(SignatureStatusChangedNotificationDst dst) {
    
    this.dst = dst;
    return this;
  }

   /**
   * Get dst
   * @return dst
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SignatureStatusChangedNotificationDst getDst() {
    return dst;
  }


  public void setDst(SignatureStatusChangedNotificationDst dst) {
    this.dst = dst;
  }


  public SignatureStatusChangedNotification fillableForm(FillableForm fillableForm) {
    
    this.fillableForm = fillableForm;
    return this;
  }

   /**
   * Get fillableForm
   * @return fillableForm
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public FillableForm getFillableForm() {
    return fillableForm;
  }


  public void setFillableForm(FillableForm fillableForm) {
    this.fillableForm = fillableForm;
  }


  public SignatureStatusChangedNotification signature(Integer signature) {
    
    this.signature = signature;
    return this;
  }

   /**
   * Get signature
   * @return signature
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getSignature() {
    return signature;
  }


  public void setSignature(Integer signature) {
    this.signature = signature;
  }


  public SignatureStatusChangedNotification signer(String signer) {
    
    this.signer = signer;
    return this;
  }

   /**
   * Get signer
   * @return signer
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "admin.test.com", value = "")

  public String getSigner() {
    return signer;
  }


  public void setSigner(String signer) {
    this.signer = signer;
  }


  public SignatureStatusChangedNotification document(SignatureStatusChangedNotificationDocument document) {
    
    this.document = document;
    return this;
  }

   /**
   * Get document
   * @return document
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SignatureStatusChangedNotificationDocument getDocument() {
    return document;
  }


  public void setDocument(SignatureStatusChangedNotificationDocument document) {
    this.document = document;
  }


  public SignatureStatusChangedNotification automatic(Boolean automatic) {
    
    this.automatic = automatic;
    return this;
  }

   /**
   * Get automatic
   * @return automatic
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "")

  public Boolean getAutomatic() {
    return automatic;
  }


  public void setAutomatic(Boolean automatic) {
    this.automatic = automatic;
  }


  public SignatureStatusChangedNotification page(Integer page) {
    
    this.page = page;
    return this;
  }

   /**
   * Get page
   * @return page
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getPage() {
    return page;
  }


  public void setPage(Integer page) {
    this.page = page;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignatureStatusChangedNotification signatureStatusChangedNotification = (SignatureStatusChangedNotification) o;
    return Objects.equals(this.status, signatureStatusChangedNotification.status) &&
        Objects.equals(this.group, signatureStatusChangedNotification.group) &&
        Objects.equals(this.action, signatureStatusChangedNotification.action) &&
        Objects.equals(this.dst, signatureStatusChangedNotification.dst) &&
        Objects.equals(this.fillableForm, signatureStatusChangedNotification.fillableForm) &&
        Objects.equals(this.signature, signatureStatusChangedNotification.signature) &&
        Objects.equals(this.signer, signatureStatusChangedNotification.signer) &&
        Objects.equals(this.document, signatureStatusChangedNotification.document) &&
        Objects.equals(this.automatic, signatureStatusChangedNotification.automatic) &&
        Objects.equals(this.page, signatureStatusChangedNotification.page);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, group, action, dst, fillableForm, signature, signer, document, automatic, page);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureStatusChangedNotification {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    dst: ").append(toIndentedString(dst)).append("\n");
    sb.append("    fillableForm: ").append(toIndentedString(fillableForm)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("    signer: ").append(toIndentedString(signer)).append("\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
    sb.append("    automatic: ").append(toIndentedString(automatic)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
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
