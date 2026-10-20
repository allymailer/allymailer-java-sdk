package ua.com.allymailer.api.system.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** SystemPingResponse */
public class SystemPingResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /** Унікальний ідентифікатор користувача. */
    private Integer userId;

    public String getStatus() {
        return status;
    }

    public SystemPingResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public SystemPingResponse setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static SystemPingResponse fromMap(Map<String, Object> data) {
        SystemPingResponse result = new SystemPingResponse();
        result.status = Json.asString(data.get("status"));
        result.userId = Json.asInteger(data.get("user_id"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "user_id", userId);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
