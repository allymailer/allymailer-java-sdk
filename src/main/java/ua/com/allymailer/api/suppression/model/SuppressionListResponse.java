package ua.com.allymailer.api.suppression.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** SuppressionListResponse */
public class SuppressionListResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /** Масив об'єктів з інформацією про недоступність. */
    private List<SuppressionListObject> suppressions;

    /**
     * Параметр указує, з якої позиції починати вибірку. Має бути порожнім або відсутнім для отримання
     * першої порції даних; для отримання другої та наступних порцій його необхідно задавати, підставляючи
     * значення поля "cursor" з попередньої порції.
     */
    private String cursor;

    public String getStatus() {
        return status;
    }

    public SuppressionListResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<SuppressionListObject> getSuppressions() {
        return suppressions;
    }

    public SuppressionListResponse setSuppressions(List<SuppressionListObject> suppressions) {
        this.suppressions = suppressions;
        return this;
    }

    public String getCursor() {
        return cursor;
    }

    public SuppressionListResponse setCursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static SuppressionListResponse fromMap(Map<String, Object> data) {
        SuppressionListResponse result = new SuppressionListResponse();
        result.status = Json.asString(data.get("status"));
        result.suppressions = Json.asList(data.get("suppressions"), v0 -> Json.asObject(v0, SuppressionListObject::fromMap));
        result.cursor = Json.asString(data.get("cursor"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "suppressions", Json.mapList(suppressions, v0 -> v0.toMap()));
        Json.put(result, "cursor", cursor);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
