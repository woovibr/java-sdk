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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;

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
 * CompanyBankAccountBalance
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-09T10:01:02.014525-03:00[America/Sao_Paulo]")
public class CompanyBankAccountBalance {
  public static final String SERIALIZED_NAME_TOTAL = "total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private BigDecimal total;

  public static final String SERIALIZED_NAME_BLOCKED = "blocked";
  @SerializedName(SERIALIZED_NAME_BLOCKED)
  private BigDecimal blocked;

  public static final String SERIALIZED_NAME_AVAILABLE = "available";
  @SerializedName(SERIALIZED_NAME_AVAILABLE)
  private BigDecimal available;

  public CompanyBankAccountBalance() {
  }

  public CompanyBankAccountBalance total(BigDecimal total) {
    
    this.total = total;
    return this;
  }

   /**
   * Total amount in cents
   * @return total
  **/
  @javax.annotation.Nullable
  public BigDecimal getTotal() {
    return total;
  }


  public void setTotal(BigDecimal total) {
    this.total = total;
  }


  public CompanyBankAccountBalance blocked(BigDecimal blocked) {
    
    this.blocked = blocked;
    return this;
  }

   /**
   * Blocked amount in cents
   * @return blocked
  **/
  @javax.annotation.Nullable
  public BigDecimal getBlocked() {
    return blocked;
  }


  public void setBlocked(BigDecimal blocked) {
    this.blocked = blocked;
  }


  public CompanyBankAccountBalance available(BigDecimal available) {
    
    this.available = available;
    return this;
  }

   /**
   * Available amount in cents
   * @return available
  **/
  @javax.annotation.Nullable
  public BigDecimal getAvailable() {
    return available;
  }


  public void setAvailable(BigDecimal available) {
    this.available = available;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompanyBankAccountBalance companyBankAccountBalance = (CompanyBankAccountBalance) o;
    return Objects.equals(this.total, companyBankAccountBalance.total) &&
        Objects.equals(this.blocked, companyBankAccountBalance.blocked) &&
        Objects.equals(this.available, companyBankAccountBalance.available);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, blocked, available);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompanyBankAccountBalance {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    blocked: ").append(toIndentedString(blocked)).append("\n");
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
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
    openapiFields.add("total");
    openapiFields.add("blocked");
    openapiFields.add("available");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to CompanyBankAccountBalance
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!CompanyBankAccountBalance.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CompanyBankAccountBalance is not found in the empty JSON string", CompanyBankAccountBalance.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!CompanyBankAccountBalance.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CompanyBankAccountBalance` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CompanyBankAccountBalance.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CompanyBankAccountBalance' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CompanyBankAccountBalance> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CompanyBankAccountBalance.class));

       return (TypeAdapter<T>) new TypeAdapter<CompanyBankAccountBalance>() {
           @Override
           public void write(JsonWriter out, CompanyBankAccountBalance value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CompanyBankAccountBalance read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CompanyBankAccountBalance given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CompanyBankAccountBalance
  * @throws IOException if the JSON string is invalid with respect to CompanyBankAccountBalance
  */
  public static CompanyBankAccountBalance fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CompanyBankAccountBalance.class);
  }

 /**
  * Convert an instance of CompanyBankAccountBalance to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

