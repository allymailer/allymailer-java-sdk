package ua.com.allymailer.common.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** SuccessResponse */
public class SuccessResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    public String getStatus() {
        return status;
    }

    public SuccessResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static SuccessResponse fromMap(Map<String, Object> data) {
        SuccessResponse result = new SuccessResponse();
        result.status = Json.asString(data.get("status"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
