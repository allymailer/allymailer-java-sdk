package ua.com.allymailer.api.webhook.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** WebhookGetResponse */
public class WebhookGetResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /** Об'єкт з усіма властивостями webhook. */
    private WebhookObject object;

    public String getStatus() {
        return status;
    }

    public WebhookGetResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public WebhookObject getObject() {
        return object;
    }

    public WebhookGetResponse setObject(WebhookObject object) {
        this.object = object;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static WebhookGetResponse fromMap(Map<String, Object> data) {
        WebhookGetResponse result = new WebhookGetResponse();
        result.status = Json.asString(data.get("status"));
        result.object = Json.asObject(data.get("object"), WebhookObject::fromMap);
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "object", object == null ? null : object.toMap());
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
