package ua.com.allymailer.api.webhook.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** Об'єкт з усіма властивостями webhook. */
public class WebhookObject {
    /** Унікальний ідентифікатор webhook. */
    private Integer id;

    /** URL webhook. */
    private String url;

    /**
     * Статус webhook, за замовчуванням "active". Статус "disabled" означає, що webhook було вимкнено
     * користувачем, "stopped" означає, що webhook було зупинено системою після 24 годин невдалих викликів
     * (мінімум за 10 різними подіями).
     * За замовчуванням: `active`.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String status;

    /**
     * Формат сповіщень. "json_post"(за замовчуванням) або "json_post_gzip".
     * За замовчуванням: `json_post`.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String eventFormat;

    /**
     * Повертати (1) чи ні (0) докладну інформацію про доставку. Якщо delivery_info=1, повертається
     * додаткова інформація про відповідь сервера та внутрішній статус доставки в разі статусів доставки
     * "hard_bounced" і "soft_bounced"; user agent, IP-адреса отримувача, геодані, визначена за user agent
     * інформація про пристрій (тип і марка пристрою, назва ОС, браузера або поштового клієнта) і
     * traffic_type (human, machine, protected або unknown) в разі статусів "opened" і "clicked"; URL для
     * статусу "clicked". Для статусів "delivered", "soft_bounced" і "hard_bounced" AllyMailer також може
     * повернути sender_ip — IP-адресу SMTP-сервера, з якого було надіслано лист, якщо він доступний.
     * Допустимі значення: `0`, `1`.
     * За замовчуванням: `0`.
     */
    private Integer deliveryInfo;

    /**
     * 0=в одному виклику може надійти декілька подій, 1=лише одна подія на виклик (не рекомендується).
     * Допустимі значення: `0`, `1`.
     * За замовчуванням: `0`.
     */
    private Integer singleEvent;

    /**
     * Максимальна кількість дозволених паралельних запитів до вашого сервера. Чим більше ваш сервер може
     * обробити — тим краще.
     * За замовчуванням: `10`.
     */
    private Integer maxParallel;

    /** Час останнього оновлення властивостей webhook у часовому поясі UTC у форматі "РРРР-ММ-ДД гг:хх:сс". */
    private String updatedAt;

    /** Об'єкт, що описує події, про які потрібно сповіщати. */
    private WebhookEventsObject events;

    public Integer getId() {
        return id;
    }

    public WebhookObject setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public WebhookObject setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getStatusValue()), null when absent.
     */
    public WebhookStatus getStatus() {
        return WebhookStatus.fromValue(status);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setStatusValue()).
     */
    public WebhookObject setStatus(WebhookStatus status) {
        this.status = WebhookStatus.toValue(status);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getStatusValue() {
        return status;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public WebhookObject setStatusValue(String status) {
        this.status = status;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getEventFormatValue()), null when absent.
     */
    public WebhookEventFormat getEventFormat() {
        return WebhookEventFormat.fromValue(eventFormat);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setEventFormatValue()).
     */
    public WebhookObject setEventFormat(WebhookEventFormat eventFormat) {
        this.eventFormat = WebhookEventFormat.toValue(eventFormat);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getEventFormatValue() {
        return eventFormat;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public WebhookObject setEventFormatValue(String eventFormat) {
        this.eventFormat = eventFormat;
        return this;
    }

    public Integer getDeliveryInfo() {
        return deliveryInfo;
    }

    public WebhookObject setDeliveryInfo(Integer deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
        return this;
    }

    public Integer getSingleEvent() {
        return singleEvent;
    }

    public WebhookObject setSingleEvent(Integer singleEvent) {
        this.singleEvent = singleEvent;
        return this;
    }

    public Integer getMaxParallel() {
        return maxParallel;
    }

    public WebhookObject setMaxParallel(Integer maxParallel) {
        this.maxParallel = maxParallel;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public WebhookObject setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public WebhookEventsObject getEvents() {
        return events;
    }

    public WebhookObject setEvents(WebhookEventsObject events) {
        this.events = events;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static WebhookObject fromMap(Map<String, Object> data) {
        WebhookObject result = new WebhookObject();
        result.id = Json.asInteger(data.get("id"));
        result.url = Json.asString(data.get("url"));
        result.status = Json.asString(data.get("status"));
        result.eventFormat = Json.asString(data.get("event_format"));
        result.deliveryInfo = Json.asInteger(data.get("delivery_info"));
        result.singleEvent = Json.asInteger(data.get("single_event"));
        result.maxParallel = Json.asInteger(data.get("max_parallel"));
        result.updatedAt = Json.asString(data.get("updated_at"));
        result.events = Json.asObject(data.get("events"), WebhookEventsObject::fromMap);
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "id", id);
        Json.put(result, "url", url);
        Json.put(result, "status", status);
        Json.put(result, "event_format", eventFormat);
        Json.put(result, "delivery_info", deliveryInfo);
        Json.put(result, "single_event", singleEvent);
        Json.put(result, "max_parallel", maxParallel);
        Json.put(result, "updated_at", updatedAt);
        Json.put(result, "events", events == null ? null : events.toMap());
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
