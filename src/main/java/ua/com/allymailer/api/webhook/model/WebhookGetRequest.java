package ua.com.allymailer.api.webhook.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** WebhookGetRequest */
public class WebhookGetRequest {
    /** URL webhook. */
    private String url;

    public String getUrl() {
        return url;
    }

    public WebhookGetRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static WebhookGetRequest fromMap(Map<String, Object> data) {
        WebhookGetRequest result = new WebhookGetRequest();
        result.url = Json.asString(data.get("url"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "url", url);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
