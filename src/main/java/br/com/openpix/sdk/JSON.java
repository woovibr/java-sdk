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


package br.com.openpix.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonElement;
import io.gsonfire.GsonFireBuilder;
import io.gsonfire.TypeSelector;

import okio.ByteString;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

/*
 * A JSON utility class
 *
 * NOTE: in the future, this class may be converted to static, which may break
 *       backward-compatibility
 */
public class JSON {
    private static Gson gson;
    private static boolean isLenientOnJson = false;
    private static DateTypeAdapter dateTypeAdapter = new DateTypeAdapter();
    private static SqlDateTypeAdapter sqlDateTypeAdapter = new SqlDateTypeAdapter();
    private static OffsetDateTimeTypeAdapter offsetDateTimeTypeAdapter = new OffsetDateTimeTypeAdapter();
    private static LocalDateTypeAdapter localDateTypeAdapter = new LocalDateTypeAdapter();
    private static ByteArrayAdapter byteArrayAdapter = new ByteArrayAdapter();

    @SuppressWarnings("unchecked")
    public static GsonBuilder createGson() {
        GsonFireBuilder fireBuilder = new GsonFireBuilder()
        ;
        GsonBuilder builder = fireBuilder.createGsonBuilder();
        return builder;
    }

    private static String getDiscriminatorValue(JsonElement readElement, String discriminatorField) {
        JsonElement element = readElement.getAsJsonObject().get(discriminatorField);
        if (null == element) {
            throw new IllegalArgumentException("missing discriminator field: <" + discriminatorField + ">");
        }
        return element.getAsString();
    }

    /**
     * Returns the Java class that implements the OpenAPI schema for the specified discriminator value.
     *
     * @param classByDiscriminatorValue The map of discriminator values to Java classes.
     * @param discriminatorValue The value of the OpenAPI discriminator in the input data.
     * @return The Java class that implements the OpenAPI schema
     */
    private static Class getClassByDiscriminator(Map classByDiscriminatorValue, String discriminatorValue) {
        Class clazz = (Class) classByDiscriminatorValue.get(discriminatorValue);
        if (null == clazz) {
            throw new IllegalArgumentException("cannot determine model class of name: <" + discriminatorValue + ">");
        }
        return clazz;
    }

    {
        GsonBuilder gsonBuilder = createGson();
        gsonBuilder.registerTypeAdapter(Date.class, dateTypeAdapter);
        gsonBuilder.registerTypeAdapter(java.sql.Date.class, sqlDateTypeAdapter);
        gsonBuilder.registerTypeAdapter(OffsetDateTime.class, offsetDateTimeTypeAdapter);
        gsonBuilder.registerTypeAdapter(LocalDate.class, localDateTypeAdapter);
        gsonBuilder.registerTypeAdapter(byte[].class, byteArrayAdapter);
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.AccountObjectPayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1AccountAccountIdGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1AccountAccountIdGet400Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1AccountAccountIdWithdrawPost200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1AccountAccountIdWithdrawPost200ResponseWithdraw.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1AccountAccountIdWithdrawPostRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1AccountGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1CashbackFidelityBalanceTaxIDGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1CashbackFidelityPost200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1CashbackFidelityPost200ResponseCashback.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1CashbackFidelityPost201Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1CashbackFidelityPost201ResponseCashback.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1CashbackFidelityPostRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1ChargeGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1ChargeGet200ResponsePageInfo.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1ChargeGet200ResponsePageInfoErrorsInner.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1ChargeGet200ResponsePageInfoErrorsInnerData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1ChargeIdDelete200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1ChargeIdGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1ChargeIdRefundGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1ChargeIdRefundPost200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1ChargePost200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1CustomerGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1CustomerIdGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1CustomerPost200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1PartnerApplicationPost200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1PartnerApplicationPostRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1PartnerApplicationPostRequestApplication.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1PartnerCompanyGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1PartnerCompanyTaxIDGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1PartnerCompanyTaxIDGet200ResponsePreRegistration.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1PaymentGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1PaymentGet200ResponsePaymentsInner.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1PaymentIdGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1PaymentPost200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1PixQrCodeStaticIdGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1QrcodeStaticGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1QrcodeStaticPost200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1RefundGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1RefundIdGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1RefundPost200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1SubscriptionsIdGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1TransactionGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1TransactionIdGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1WebhookGet200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1WebhookGet200ResponsePageInfo.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1WebhookIdDelete200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1WebhookIdDelete400Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1WebhookPostRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1WebhookPostRequestPix.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ApiV1WebhookPostRequestPixRaw.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.Charge.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ChargeAdditionalInfoInner.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ChargePayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ChargePayloadFines.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ChargePayloadInterests.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ChargeRefund.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.ChargeRefundPayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.CompanyBankAccount.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.CompanyBankAccountBalance.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.CompanyObjectPayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.Customer.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.CustomerAddress.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.CustomerPayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.CustomerTaxID.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.PartnerApplicationPayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.Payment.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.PaymentCreatePayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.PaymentTransaction.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.PixQrCode.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.PixQrCodePayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.PixWithdrawTransaction.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.PreRegistrationObject.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.PreRegistrationObjectPayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.PreRegistrationPayloadObject.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.PreRegistrationUserObject.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.Refund.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.RefundPayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.Subscription.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.SubscriptionPayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.SubscriptionPayloadCustomer.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.TaxIDObjectPayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.Transaction.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.Webhook.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.WebhookPayload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new br.com.openpix.sdk.model.WithdrawTransaction.CustomTypeAdapterFactory());
        gson = gsonBuilder.create();
    }

    /**
     * Get Gson.
     *
     * @return Gson
     */
    public static Gson getGson() {
        return gson;
    }

    /**
     * Set Gson.
     *
     * @param gson Gson
     */
    public static void setGson(Gson gson) {
        JSON.gson = gson;
    }

    public static void setLenientOnJson(boolean lenientOnJson) {
        isLenientOnJson = lenientOnJson;
    }

    /**
     * Serialize the given Java object into JSON string.
     *
     * @param obj Object
     * @return String representation of the JSON
     */
    public static String serialize(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * Deserialize the given JSON string to Java object.
     *
     * @param <T>        Type
     * @param body       The JSON string
     * @param returnType The type to deserialize into
     * @return The deserialized Java object
     */
    @SuppressWarnings("unchecked")
    public static <T> T deserialize(String body, Type returnType) {
        try {
            if (isLenientOnJson) {
                JsonReader jsonReader = new JsonReader(new StringReader(body));
                // see https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/stream/JsonReader.html#setLenient(boolean)
                jsonReader.setLenient(true);
                return gson.fromJson(jsonReader, returnType);
            } else {
                return gson.fromJson(body, returnType);
            }
        } catch (JsonParseException e) {
            // Fallback processing when failed to parse JSON form response body:
            // return the response body string directly for the String return type;
            if (returnType.equals(String.class)) {
                return (T) body;
            } else {
                throw (e);
            }
        }
    }

    /**
     * Gson TypeAdapter for Byte Array type
     */
    public static class ByteArrayAdapter extends TypeAdapter<byte[]> {

        @Override
        public void write(JsonWriter out, byte[] value) throws IOException {
            if (value == null) {
                out.nullValue();
            } else {
                out.value(ByteString.of(value).base64());
            }
        }

        @Override
        public byte[] read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String bytesAsBase64 = in.nextString();
                    ByteString byteString = ByteString.decodeBase64(bytesAsBase64);
                    return byteString.toByteArray();
            }
        }
    }

    /**
     * Gson TypeAdapter for JSR310 OffsetDateTime type
     */
    public static class OffsetDateTimeTypeAdapter extends TypeAdapter<OffsetDateTime> {

        private DateTimeFormatter formatter;

        public OffsetDateTimeTypeAdapter() {
            this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }

        public OffsetDateTimeTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, OffsetDateTime date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public OffsetDateTime read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    if (date.endsWith("+0000")) {
                        date = date.substring(0, date.length()-5) + "Z";
                    }
                    return OffsetDateTime.parse(date, formatter);
            }
        }
    }

    /**
     * Gson TypeAdapter for JSR310 LocalDate type
     */
    public static class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

        private DateTimeFormatter formatter;

        public LocalDateTypeAdapter() {
            this(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        public LocalDateTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, LocalDate date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public LocalDate read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    return LocalDate.parse(date, formatter);
            }
        }
    }

    public static void setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
        offsetDateTimeTypeAdapter.setFormat(dateFormat);
    }

    public static void setLocalDateFormat(DateTimeFormatter dateFormat) {
        localDateTypeAdapter.setFormat(dateFormat);
    }

    /**
     * Gson TypeAdapter for java.sql.Date type
     * If the dateFormat is null, a simple "yyyy-MM-dd" format will be used
     * (more efficient than SimpleDateFormat).
     */
    public static class SqlDateTypeAdapter extends TypeAdapter<java.sql.Date> {

        private DateFormat dateFormat;

        public SqlDateTypeAdapter() {}

        public SqlDateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, java.sql.Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = date.toString();
                }
                out.value(value);
            }
        }

        @Override
        public java.sql.Date read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    try {
                        if (dateFormat != null) {
                            return new java.sql.Date(dateFormat.parse(date).getTime());
                        }
                        return new java.sql.Date(ISO8601Utils.parse(date, new ParsePosition(0)).getTime());
                    } catch (ParseException e) {
                        throw new JsonParseException(e);
                    }
            }
        }
    }

    /**
     * Gson TypeAdapter for java.util.Date type
     * If the dateFormat is null, ISO8601Utils will be used.
     */
    public static class DateTypeAdapter extends TypeAdapter<Date> {

        private DateFormat dateFormat;

        public DateTypeAdapter() {}

        public DateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = ISO8601Utils.format(date, true);
                }
                out.value(value);
            }
        }

        @Override
        public Date read(JsonReader in) throws IOException {
            try {
                switch (in.peek()) {
                    case NULL:
                        in.nextNull();
                        return null;
                    default:
                        String date = in.nextString();
                        try {
                            if (dateFormat != null) {
                                return dateFormat.parse(date);
                            }
                            return ISO8601Utils.parse(date, new ParsePosition(0));
                        } catch (ParseException e) {
                            throw new JsonParseException(e);
                        }
                }
            } catch (IllegalArgumentException e) {
                throw new JsonParseException(e);
            }
        }
    }

    public static void setDateFormat(DateFormat dateFormat) {
        dateTypeAdapter.setFormat(dateFormat);
    }

    public static void setSqlDateFormat(DateFormat dateFormat) {
        sqlDateTypeAdapter.setFormat(dateFormat);
    }
}
