package ua.com.allymailer.api.suppression.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** SuppressionSetRequest */
public class SuppressionSetRequest {
    /** Email-адреса, яку потрібно додати до списку недоступних. */
    private String email;

    /**
     * Причина, з якої надсилання на цей email блокується. Одна з таких:
     * <p>
     * - __unsubscribed__ - зазначену адресу відписано;
     * - __temporary_unavailable__ - адреса тимчасово недоступна. Це означає, що протягом наступних трьох діб надсилання на цю адресу повертатиме помилку. Email може бути тимчасово недоступним з різних причин, наприклад:
     * <p>
     * - попереднє надсилання було відхилено сервером отримувача як спам;
     * - поштова скринька отримувача переповнена або не використовується;
     * - домен не приймає пошту через неправильне налаштування на боці отримувача або з інших причин;
     * - сервер відправника було відхилено через блеклистинг;
     * <p>
     * - __permanent_unavailable__ - адреса перманентно недоступна через багаторазові недоставки;
     * - __complained__ - в одному з попередніх листів адресат натиснув “Це спам”.
     */
    private String cause;

    /** Коли було встановлено недоступність, у часовому поясі UTC у форматі "РРРР-ММ-ДД гг:хх:сс". */
    private String created;

    public String getEmail() {
        return email;
    }

    public SuppressionSetRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCause() {
        return cause;
    }

    public SuppressionSetRequest setCause(String cause) {
        this.cause = cause;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public SuppressionSetRequest setCreated(String created) {
        this.created = created;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static SuppressionSetRequest fromMap(Map<String, Object> data) {
        SuppressionSetRequest result = new SuppressionSetRequest();
        result.email = Json.asString(data.get("email"));
        result.cause = Json.asString(data.get("cause"));
        result.created = Json.asString(data.get("created"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "email", email);
        Json.put(result, "cause", cause);
        Json.put(result, "created", created);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
