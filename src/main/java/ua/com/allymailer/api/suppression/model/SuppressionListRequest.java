package ua.com.allymailer.api.suppression.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** SuppressionListRequest */
public class SuppressionListRequest {
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
     * - __blocked__ - надсилання на цю адресу заборонено адміністрацією AllyMailer.
     * У майбутньому можуть з'явитися й інші причини.
     */
    private String cause;

    /**
     * Джерело потрапляння до списку недоступних. Одне з таких:
     * <p>
     * - __user__ - дії користувача за допомогою методу [suppression/set](https://docs.allymailer.com.ua/ua/web-api-ref#suppression-set);
     * - __system__ - надсилання на цю адресу заборонено системою, наприклад через багаторазові недоставки;
     * - __subscriber__ - у зв'язку з діями отримувача. В одному з попередніх листів адресат натиснув “Це спам” або відписався.
     */
    private String source;

    /**
     * Дата у форматі РРРР-ММ-ДД гг:хх:сс, щоб отримати список блокування з "start_time" по сьогоднішній
     * день. Ігнорується, якщо параметр “cursor” не порожній.
     */
    private String startTime;

    /**
     * Параметр указує, з якої позиції починати вибірку. Має бути порожнім або відсутнім для отримання
     * першої порції даних; для отримання другої та наступних порцій його необхідно задавати, підставляючи
     * значення поля "cursor" з попередньої порції.
     */
    private String cursor;

    /** Максимум записів, що видаються за один раз, за замовчуванням 50. */
    private Integer limit;

    public String getCause() {
        return cause;
    }

    public SuppressionListRequest setCause(String cause) {
        this.cause = cause;
        return this;
    }

    public String getSource() {
        return source;
    }

    public SuppressionListRequest setSource(String source) {
        this.source = source;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public SuppressionListRequest setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getCursor() {
        return cursor;
    }

    public SuppressionListRequest setCursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public SuppressionListRequest setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static SuppressionListRequest fromMap(Map<String, Object> data) {
        SuppressionListRequest result = new SuppressionListRequest();
        result.cause = Json.asString(data.get("cause"));
        result.source = Json.asString(data.get("source"));
        result.startTime = Json.asString(data.get("start_time"));
        result.cursor = Json.asString(data.get("cursor"));
        result.limit = Json.asInteger(data.get("limit"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "cause", cause);
        Json.put(result, "source", source);
        Json.put(result, "start_time", startTime);
        Json.put(result, "cursor", cursor);
        Json.put(result, "limit", limit);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
