package ua.com.allymailer.api.webhook.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** WebhookListRequest */
public class WebhookListRequest {
    /** Максимальна кількість webhook, що повертаються за один виклик. Рекомендується 50. */
    private Integer limit;

    /**
     * Індекс першого webhook зі списку, що повертається, рахуючи з нуля.
     * За замовчуванням: `0`.
     */
    private Integer offset;

    public Integer getLimit() {
        return limit;
    }

    public WebhookListRequest setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public WebhookListRequest setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static WebhookListRequest fromMap(Map<String, Object> data) {
        WebhookListRequest result = new WebhookListRequest();
        result.limit = Json.asInteger(data.get("limit"));
        result.offset = Json.asInteger(data.get("offset"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "limit", limit);
        Json.put(result, "offset", offset);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
