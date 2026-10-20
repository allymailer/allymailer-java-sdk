package ua.com.allymailer.api.suppression.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** SuppressionGetResponse */
public class SuppressionGetResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /** Email-адреса, для якої було запитано дані про недоступність. */
    private String email;

    /** Масив об'єктів з інформацією про недоступність. */
    private List<SuppressionGetObject> suppressions;

    public String getStatus() {
        return status;
    }

    public SuppressionGetResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SuppressionGetResponse setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<SuppressionGetObject> getSuppressions() {
        return suppressions;
    }

    public SuppressionGetResponse setSuppressions(List<SuppressionGetObject> suppressions) {
        this.suppressions = suppressions;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static SuppressionGetResponse fromMap(Map<String, Object> data) {
        SuppressionGetResponse result = new SuppressionGetResponse();
        result.status = Json.asString(data.get("status"));
        result.email = Json.asString(data.get("email"));
        result.suppressions = Json.asList(data.get("suppressions"), v0 -> Json.asObject(v0, SuppressionGetObject::fromMap));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "email", email);
        Json.put(result, "suppressions", Json.mapList(suppressions, v0 -> v0.toMap()));
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
