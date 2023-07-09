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
import br.com.openpix.sdk.model.AccountObjectPayload;
import br.com.openpix.sdk.model.CompanyObjectPayload;
import br.com.openpix.sdk.model.PreRegistrationObjectPayload;
import br.com.openpix.sdk.model.PreRegistrationUserObject;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

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
 * ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-09T10:01:02.014525-03:00[America/Sao_Paulo]")
public class ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration {
  public static final String SERIALIZED_NAME_PRE_REGISTRATION = "preRegistration";
  @SerializedName(SERIALIZED_NAME_PRE_REGISTRATION)
  private PreRegistrationObjectPayload preRegistration;

  public static final String SERIALIZED_NAME_USER = "user";
  @SerializedName(SERIALIZED_NAME_USER)
  private PreRegistrationUserObject user;

  public static final String SERIALIZED_NAME_COMPANY = "company";
  @SerializedName(SERIALIZED_NAME_COMPANY)
  private CompanyObjectPayload company;

  public static final String SERIALIZED_NAME_ACCOUNT = "account";
  @SerializedName(SERIALIZED_NAME_ACCOUNT)
  private AccountObjectPayload account;

  public ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration() {
  }

  public ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration preRegistration(PreRegistrationObjectPayload preRegistration) {
    
    this.preRegistration = preRegistration;
    return this;
  }

   /**
   * Get preRegistration
   * @return preRegistration
  **/
  @javax.annotation.Nonnull
  public PreRegistrationObjectPayload getPreRegistration() {
    return preRegistration;
  }


  public void setPreRegistration(PreRegistrationObjectPayload preRegistration) {
    this.preRegistration = preRegistration;
  }


  public ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration user(PreRegistrationUserObject user) {
    
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @javax.annotation.Nonnull
  public PreRegistrationUserObject getUser() {
    return user;
  }


  public void setUser(PreRegistrationUserObject user) {
    this.user = user;
  }


  public ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration company(CompanyObjectPayload company) {
    
    this.company = company;
    return this;
  }

   /**
   * Get company
   * @return company
  **/
  @javax.annotation.Nullable
  public CompanyObjectPayload getCompany() {
    return company;
  }


  public void setCompany(CompanyObjectPayload company) {
    this.company = company;
  }


  public ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration account(AccountObjectPayload account) {
    
    this.account = account;
    return this;
  }

   /**
   * Get account
   * @return account
  **/
  @javax.annotation.Nullable
  public AccountObjectPayload getAccount() {
    return account;
  }


  public void setAccount(AccountObjectPayload account) {
    this.account = account;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration apiV1PartnerCompanyTaxIDGet200ResponsePreRegistration = (ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration) o;
    return Objects.equals(this.preRegistration, apiV1PartnerCompanyTaxIDGet200ResponsePreRegistration.preRegistration) &&
        Objects.equals(this.user, apiV1PartnerCompanyTaxIDGet200ResponsePreRegistration.user) &&
        Objects.equals(this.company, apiV1PartnerCompanyTaxIDGet200ResponsePreRegistration.company) &&
        Objects.equals(this.account, apiV1PartnerCompanyTaxIDGet200ResponsePreRegistration.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(preRegistration, user, company, account);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration {\n");
    sb.append("    preRegistration: ").append(toIndentedString(preRegistration)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
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
    openapiFields.add("preRegistration");
    openapiFields.add("user");
    openapiFields.add("company");
    openapiFields.add("account");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("preRegistration");
    openapiRequiredFields.add("user");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration is not found in the empty JSON string", ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `preRegistration`
      PreRegistrationObjectPayload.validateJsonElement(jsonObj.get("preRegistration"));
      // validate the required field `user`
      PreRegistrationUserObject.validateJsonElement(jsonObj.get("user"));
      // validate the optional field `company`
      if (jsonObj.get("company") != null && !jsonObj.get("company").isJsonNull()) {
        CompanyObjectPayload.validateJsonElement(jsonObj.get("company"));
      }
      // validate the optional field `account`
      if (jsonObj.get("account") != null && !jsonObj.get("account").isJsonNull()) {
        AccountObjectPayload.validateJsonElement(jsonObj.get("account"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration.class));

       return (TypeAdapter<T>) new TypeAdapter<ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration>() {
           @Override
           public void write(JsonWriter out, ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration
  * @throws IOException if the JSON string is invalid with respect to ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration
  */
  public static ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration.class);
  }

 /**
  * Convert an instance of ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

