/*
 * Woovi
 * A Woovi é uma Plataforma de Gestão de Pagamentos. Para utilizar nossa API você deve acessar  __[https://api.woovi.com/](https://api.woovi.com/)__ e somente o mesmo. A Woovi não aceita subdominios para a API.  Veja como configurar seu acesso a nossa API [aqui](https://developers.woovi.com/docs/apis/api-getting-started).
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package br.com.openpix.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import br.com.openpix.sdk.model.Charge;
import br.com.openpix.sdk.model.Customer;
import br.com.openpix.sdk.model.PixQrCode;
import br.com.openpix.sdk.model.PixWithdrawTransaction;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import br.com.openpix.sdk.JSON;

/**
 * Transaction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-09T10:01:02.014525-03:00[America/Sao_Paulo]")
public class Transaction {
  public static final String SERIALIZED_NAME_CHARGE = "charge";
  @SerializedName(SERIALIZED_NAME_CHARGE)
  private Charge charge;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private BigDecimal value;

  public static final String SERIALIZED_NAME_TIME = "time";
  @SerializedName(SERIALIZED_NAME_TIME)
  private String time;

  public static final String SERIALIZED_NAME_END_TO_END_I_D = "endToEndID";
  @SerializedName(SERIALIZED_NAME_END_TO_END_I_D)
  private String endToEndID;

  public static final String SERIALIZED_NAME_TRANSACTION_I_D = "transactionID";
  @SerializedName(SERIALIZED_NAME_TRANSACTION_I_D)
  private String transactionID;

  public static final String SERIALIZED_NAME_INFO_PAGADOR = "infoPagador";
  @SerializedName(SERIALIZED_NAME_INFO_PAGADOR)
  private String infoPagador;

  public static final String SERIALIZED_NAME_END_TO_END_ID = "endToEndId";
  @SerializedName(SERIALIZED_NAME_END_TO_END_ID)
  private String endToEndId;

  public static final String SERIALIZED_NAME_CUSTOMER = "customer";
  @SerializedName(SERIALIZED_NAME_CUSTOMER)
  private Customer customer;

  public static final String SERIALIZED_NAME_WITHDRAW = "withdraw";
  @SerializedName(SERIALIZED_NAME_WITHDRAW)
  private PixWithdrawTransaction withdraw;

  public static final String SERIALIZED_NAME_PAYER = "payer";
  @SerializedName(SERIALIZED_NAME_PAYER)
  private Customer payer;

  /**
   * Pix Transaction type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    PAYMENT("PAYMENT"),
    
    WITHDRAW("WITHDRAW"),
    
    REFUND("REFUND"),
    
    FEE("FEE");

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

  public static final String SERIALIZED_NAME_GLOBAL_I_D = "globalID";
  @SerializedName(SERIALIZED_NAME_GLOBAL_I_D)
  private Object globalID = null;

  public static final String SERIALIZED_NAME_PIX_QR_CODE = "pixQrCode";
  @SerializedName(SERIALIZED_NAME_PIX_QR_CODE)
  private PixQrCode pixQrCode;

  public Transaction() {
  }

  public Transaction charge(Charge charge) {
    
    this.charge = charge;
    return this;
  }

   /**
   * Get charge
   * @return charge
  **/
  @javax.annotation.Nullable
  public Charge getCharge() {
    return charge;
  }


  public void setCharge(Charge charge) {
    this.charge = charge;
  }


  public Transaction value(BigDecimal value) {
    
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @javax.annotation.Nullable
  public BigDecimal getValue() {
    return value;
  }


  public void setValue(BigDecimal value) {
    this.value = value;
  }


  public Transaction time(String time) {
    
    this.time = time;
    return this;
  }

   /**
   * Get time
   * @return time
  **/
  @javax.annotation.Nullable
  public String getTime() {
    return time;
  }


  public void setTime(String time) {
    this.time = time;
  }


  public Transaction endToEndID(String endToEndID) {
    
    this.endToEndID = endToEndID;
    return this;
  }

   /**
   * Get endToEndID
   * @return endToEndID
  **/
  @javax.annotation.Nullable
  public String getEndToEndID() {
    return endToEndID;
  }


  public void setEndToEndID(String endToEndID) {
    this.endToEndID = endToEndID;
  }


  public Transaction transactionID(String transactionID) {
    
    this.transactionID = transactionID;
    return this;
  }

   /**
   * Get transactionID
   * @return transactionID
  **/
  @javax.annotation.Nullable
  public String getTransactionID() {
    return transactionID;
  }


  public void setTransactionID(String transactionID) {
    this.transactionID = transactionID;
  }


  public Transaction infoPagador(String infoPagador) {
    
    this.infoPagador = infoPagador;
    return this;
  }

   /**
   * Get infoPagador
   * @return infoPagador
  **/
  @javax.annotation.Nullable
  public String getInfoPagador() {
    return infoPagador;
  }


  public void setInfoPagador(String infoPagador) {
    this.infoPagador = infoPagador;
  }


  public Transaction endToEndId(String endToEndId) {
    
    this.endToEndId = endToEndId;
    return this;
  }

   /**
   * Get endToEndId
   * @return endToEndId
  **/
  @javax.annotation.Nullable
  public String getEndToEndId() {
    return endToEndId;
  }


  public void setEndToEndId(String endToEndId) {
    this.endToEndId = endToEndId;
  }


  public Transaction customer(Customer customer) {
    
    this.customer = customer;
    return this;
  }

   /**
   * Get customer
   * @return customer
  **/
  @javax.annotation.Nullable
  public Customer getCustomer() {
    return customer;
  }


  public void setCustomer(Customer customer) {
    this.customer = customer;
  }


  public Transaction withdraw(PixWithdrawTransaction withdraw) {
    
    this.withdraw = withdraw;
    return this;
  }

   /**
   * Get withdraw
   * @return withdraw
  **/
  @javax.annotation.Nullable
  public PixWithdrawTransaction getWithdraw() {
    return withdraw;
  }


  public void setWithdraw(PixWithdrawTransaction withdraw) {
    this.withdraw = withdraw;
  }


  public Transaction payer(Customer payer) {
    
    this.payer = payer;
    return this;
  }

   /**
   * Get payer
   * @return payer
  **/
  @javax.annotation.Nullable
  public Customer getPayer() {
    return payer;
  }


  public void setPayer(Customer payer) {
    this.payer = payer;
  }


  public Transaction type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Pix Transaction type
   * @return type
  **/
  @javax.annotation.Nullable
  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    this.type = type;
  }


  public Transaction globalID(Object globalID) {
    
    this.globalID = globalID;
    return this;
  }

   /**
   * External ID of this transaction
   * @return globalID
  **/
  @javax.annotation.Nullable
  public Object getGlobalID() {
    return globalID;
  }


  public void setGlobalID(Object globalID) {
    this.globalID = globalID;
  }


  public Transaction pixQrCode(PixQrCode pixQrCode) {
    
    this.pixQrCode = pixQrCode;
    return this;
  }

   /**
   * Get pixQrCode
   * @return pixQrCode
  **/
  @javax.annotation.Nullable
  public PixQrCode getPixQrCode() {
    return pixQrCode;
  }


  public void setPixQrCode(PixQrCode pixQrCode) {
    this.pixQrCode = pixQrCode;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.charge, transaction.charge) &&
        Objects.equals(this.value, transaction.value) &&
        Objects.equals(this.time, transaction.time) &&
        Objects.equals(this.endToEndID, transaction.endToEndID) &&
        Objects.equals(this.transactionID, transaction.transactionID) &&
        Objects.equals(this.infoPagador, transaction.infoPagador) &&
        Objects.equals(this.endToEndId, transaction.endToEndId) &&
        Objects.equals(this.customer, transaction.customer) &&
        Objects.equals(this.withdraw, transaction.withdraw) &&
        Objects.equals(this.payer, transaction.payer) &&
        Objects.equals(this.type, transaction.type) &&
        Objects.equals(this.globalID, transaction.globalID) &&
        Objects.equals(this.pixQrCode, transaction.pixQrCode);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(charge, value, time, endToEndID, transactionID, infoPagador, endToEndId, customer, withdraw, payer, type, globalID, pixQrCode);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    sb.append("    charge: ").append(toIndentedString(charge)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    endToEndID: ").append(toIndentedString(endToEndID)).append("\n");
    sb.append("    transactionID: ").append(toIndentedString(transactionID)).append("\n");
    sb.append("    infoPagador: ").append(toIndentedString(infoPagador)).append("\n");
    sb.append("    endToEndId: ").append(toIndentedString(endToEndId)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    withdraw: ").append(toIndentedString(withdraw)).append("\n");
    sb.append("    payer: ").append(toIndentedString(payer)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    globalID: ").append(toIndentedString(globalID)).append("\n");
    sb.append("    pixQrCode: ").append(toIndentedString(pixQrCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("charge");
    openapiFields.add("value");
    openapiFields.add("time");
    openapiFields.add("endToEndID");
    openapiFields.add("transactionID");
    openapiFields.add("infoPagador");
    openapiFields.add("endToEndId");
    openapiFields.add("customer");
    openapiFields.add("withdraw");
    openapiFields.add("payer");
    openapiFields.add("type");
    openapiFields.add("globalID");
    openapiFields.add("pixQrCode");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to Transaction
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Transaction.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Transaction is not found in the empty JSON string", Transaction.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!Transaction.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Transaction` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("time") != null && !jsonObj.get("time").isJsonNull()) && !jsonObj.get("time").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `time` to be a primitive type in the JSON string but got `%s`", jsonObj.get("time").toString()));
      }
      if ((jsonObj.get("endToEndID") != null && !jsonObj.get("endToEndID").isJsonNull()) && !jsonObj.get("endToEndID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `endToEndID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("endToEndID").toString()));
      }
      if ((jsonObj.get("transactionID") != null && !jsonObj.get("transactionID").isJsonNull()) && !jsonObj.get("transactionID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `transactionID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("transactionID").toString()));
      }
      if ((jsonObj.get("infoPagador") != null && !jsonObj.get("infoPagador").isJsonNull()) && !jsonObj.get("infoPagador").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `infoPagador` to be a primitive type in the JSON string but got `%s`", jsonObj.get("infoPagador").toString()));
      }
      if ((jsonObj.get("endToEndId") != null && !jsonObj.get("endToEndId").isJsonNull()) && !jsonObj.get("endToEndId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `endToEndId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("endToEndId").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Transaction.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Transaction' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Transaction> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Transaction.class));

       return (TypeAdapter<T>) new TypeAdapter<Transaction>() {
           @Override
           public void write(JsonWriter out, Transaction value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Transaction read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Transaction given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Transaction
  * @throws IOException if the JSON string is invalid with respect to Transaction
  */
  public static Transaction fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Transaction.class);
  }

 /**
  * Convert an instance of Transaction to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

