package ua.com.allymailer.api.suppression.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** Об'єкт з даними про блокування email. */
public class SuppressionGetObject {
    /** Унікальний ідентифікатор проєкту, ASCII-рядок до 36 символів завдовжки. */
    private String projectId;

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

    /** Чи можна видалити запис за допомогою виклику suppression/delete. */
    private Boolean isDeletable;

    /** Коли було встановлено недоступність, у часовому поясі UTC у форматі "РРРР-ММ-ДД гг:хх:сс". */
    private String created;

    public String getProjectId() {
        return projectId;
    }

    public SuppressionGetObject setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getCause() {
        return cause;
    }

    public SuppressionGetObject setCause(String cause) {
        this.cause = cause;
        return this;
    }

    public String getSource() {
        return source;
    }

    public SuppressionGetObject setSource(String source) {
        this.source = source;
        return this;
    }

    public Boolean getIsDeletable() {
        return isDeletable;
    }

    public SuppressionGetObject setIsDeletable(Boolean isDeletable) {
        this.isDeletable = isDeletable;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public SuppressionGetObject setCreated(String created) {
        this.created = created;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static SuppressionGetObject fromMap(Map<String, Object> data) {
        SuppressionGetObject result = new SuppressionGetObject();
        result.projectId = Json.asString(data.get("project_id"));
        result.cause = Json.asString(data.get("cause"));
        result.source = Json.asString(data.get("source"));
        result.isDeletable = Json.asBoolean(data.get("is_deletable"));
        result.created = Json.asString(data.get("created"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "project_id", projectId);
        Json.put(result, "cause", cause);
        Json.put(result, "source", source);
        Json.put(result, "is_deletable", isDeletable);
        Json.put(result, "created", created);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
