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
import signingToday.client.model.SignerRecord;

/**
 * AuditRecord
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-24T08:13:36.809Z[GMT]")
public class AuditRecord {
  public static final String SERIALIZED_NAME_INSTANCE_ID = "_instance_id";
  @SerializedName(SERIALIZED_NAME_INSTANCE_ID)
  private Long instanceId;

  public static final String SERIALIZED_NAME_AT = "at";
  @SerializedName(SERIALIZED_NAME_AT)
  private OffsetDateTime at;

  /**
   * Gets or Sets event
   */
  @JsonAdapter(EventEnum.Adapter.class)
  public enum EventEnum {
    EVENT_PUBLISHED("event_published"),
    
    EVENT_FORM_FILL("event_form_fill"),
    
    EVENT_SIGNATURE("event_signature"),
    
    EVENT_REJECTION("event_rejection"),
    
    EVENT_REPLACEMENT("event_replacement"),
    
    EVENT_NOTE_ADD("event_note_add"),
    
    EVENT_NOTE_MODIFY("event_note_modify"),
    
    EVENT_NOTE_DELETE("event_note_delete"),
    
    EVENT_SOLICITATION("event_solicitation"),
    
    STAGE_TO_FILL("stage_to_fill"),
    
    STAGE_TO_SIGN("stage_to_sign"),
    
    STAGE_EXPIRED("stage_expired"),
    
    STAGE_SIGNED("stage_signed"),
    
    STAGE_REJECTED("stage_rejected"),
    
    EVENT_UPLOAD_ALFRESCO("event_upload_alfresco");

    private String value;

    EventEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static EventEnum fromValue(String value) {
      for (EventEnum b : EventEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<EventEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EventEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EventEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return EventEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_EVENT = "event";
  @SerializedName(SERIALIZED_NAME_EVENT)
  private EventEnum event;

  public static final String SERIALIZED_NAME_SIGNER = "signer";
  @SerializedName(SERIALIZED_NAME_SIGNER)
  private SignerRecord signer;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value;

  public static final String SERIALIZED_NAME_DST_ID = "dstId";
  @SerializedName(SERIALIZED_NAME_DST_ID)
  private UUID dstId;

  public static final String SERIALIZED_NAME_DOCUMENT_ID = "documentId";
  @SerializedName(SERIALIZED_NAME_DOCUMENT_ID)
  private Integer documentId;

  public static final String SERIALIZED_NAME_FILLABLE_FORM_ID = "fillableFormId";
  @SerializedName(SERIALIZED_NAME_FILLABLE_FORM_ID)
  private Integer fillableFormId;

  public static final String SERIALIZED_NAME_SIGNATURE_REQUEST_ID = "signatureRequestId";
  @SerializedName(SERIALIZED_NAME_SIGNATURE_REQUEST_ID)
  private Integer signatureRequestId;

  public static final String SERIALIZED_NAME_NOTE_ID = "noteId";
  @SerializedName(SERIALIZED_NAME_NOTE_ID)
  private Long noteId;


   /**
   * It is a reference for internal use
   * @return instanceId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "It is a reference for internal use")

  public Long getInstanceId() {
    return instanceId;
  }




  public AuditRecord at(OffsetDateTime at) {
    
    this.at = at;
    return this;
  }

   /**
   * Get at
   * @return at
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2020-01-17T07:26Z", value = "")

  public OffsetDateTime getAt() {
    return at;
  }


  public void setAt(OffsetDateTime at) {
    this.at = at;
  }


  public AuditRecord event(EventEnum event) {
    
    this.event = event;
    return this;
  }

   /**
   * Get event
   * @return event
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "stage_signed", value = "")

  public EventEnum getEvent() {
    return event;
  }


  public void setEvent(EventEnum event) {
    this.event = event;
  }


  public AuditRecord signer(SignerRecord signer) {
    
    this.signer = signer;
    return this;
  }

   /**
   * Get signer
   * @return signer
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SignerRecord getSigner() {
    return signer;
  }


  public void setSigner(SignerRecord signer) {
    this.signer = signer;
  }


  public AuditRecord value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "utente registrato John Doe (jdo@bit4id.com) ha pubblicato la DST \"Contratto\" (aeaa6c62-8b59-4fac-9419-8e9a95aea410) La DST contiene i documenti: - \"Contratto Preliminare\" con compilatori [John Doe (jdo@bit4id.com)] e firmatari [Adam Smith (adam.smith@email.com)]", value = "")

  public String getValue() {
    return value;
  }


  public void setValue(String value) {
    this.value = value;
  }


  public AuditRecord dstId(UUID dstId) {
    
    this.dstId = dstId;
    return this;
  }

   /**
   * Get dstId
   * @return dstId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "00f462e8-333c-45d6-bdef-95797cc1a2a9", value = "")

  public UUID getDstId() {
    return dstId;
  }


  public void setDstId(UUID dstId) {
    this.dstId = dstId;
  }


  public AuditRecord documentId(Integer documentId) {
    
    this.documentId = documentId;
    return this;
  }

   /**
   * Get documentId
   * @return documentId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "")

  public Integer getDocumentId() {
    return documentId;
  }


  public void setDocumentId(Integer documentId) {
    this.documentId = documentId;
  }


  public AuditRecord fillableFormId(Integer fillableFormId) {
    
    this.fillableFormId = fillableFormId;
    return this;
  }

   /**
   * Get fillableFormId
   * @return fillableFormId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "3", value = "")

  public Integer getFillableFormId() {
    return fillableFormId;
  }


  public void setFillableFormId(Integer fillableFormId) {
    this.fillableFormId = fillableFormId;
  }


  public AuditRecord signatureRequestId(Integer signatureRequestId) {
    
    this.signatureRequestId = signatureRequestId;
    return this;
  }

   /**
   * Get signatureRequestId
   * @return signatureRequestId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getSignatureRequestId() {
    return signatureRequestId;
  }


  public void setSignatureRequestId(Integer signatureRequestId) {
    this.signatureRequestId = signatureRequestId;
  }


  public AuditRecord noteId(Long noteId) {
    
    this.noteId = noteId;
    return this;
  }

   /**
   * Get noteId
   * @return noteId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "")

  public Long getNoteId() {
    return noteId;
  }


  public void setNoteId(Long noteId) {
    this.noteId = noteId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditRecord auditRecord = (AuditRecord) o;
    return Objects.equals(this.instanceId, auditRecord.instanceId) &&
        Objects.equals(this.at, auditRecord.at) &&
        Objects.equals(this.event, auditRecord.event) &&
        Objects.equals(this.signer, auditRecord.signer) &&
        Objects.equals(this.value, auditRecord.value) &&
        Objects.equals(this.dstId, auditRecord.dstId) &&
        Objects.equals(this.documentId, auditRecord.documentId) &&
        Objects.equals(this.fillableFormId, auditRecord.fillableFormId) &&
        Objects.equals(this.signatureRequestId, auditRecord.signatureRequestId) &&
        Objects.equals(this.noteId, auditRecord.noteId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceId, at, event, signer, value, dstId, documentId, fillableFormId, signatureRequestId, noteId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditRecord {\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    at: ").append(toIndentedString(at)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    signer: ").append(toIndentedString(signer)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    dstId: ").append(toIndentedString(dstId)).append("\n");
    sb.append("    documentId: ").append(toIndentedString(documentId)).append("\n");
    sb.append("    fillableFormId: ").append(toIndentedString(fillableFormId)).append("\n");
    sb.append("    signatureRequestId: ").append(toIndentedString(signatureRequestId)).append("\n");
    sb.append("    noteId: ").append(toIndentedString(noteId)).append("\n");
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

