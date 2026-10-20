package ua.com.allymailer.api.suppression.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** SuppressionDeleteRequest */
public class SuppressionDeleteRequest {
    /** Email-адреса, яку потрібно видалити зі списку недоступних. */
    private String email;

    public String getEmail() {
        return email;
    }

    public SuppressionDeleteRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static SuppressionDeleteRequest fromMap(Map<String, Object> data) {
        SuppressionDeleteRequest result = new SuppressionDeleteRequest();
        result.email = Json.asString(data.get("email"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "email", email);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
