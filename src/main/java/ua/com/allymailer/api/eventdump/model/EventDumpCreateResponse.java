package ua.com.allymailer.api.eventdump.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** EventDumpCreateResponse */
public class EventDumpCreateResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /**
     * Ідентифікатор дампа. Використовується для виклику методу
     * [event-dump/get](https://docs.allymailer.com.ua/ua/web-api-ref#event-dump-get).
     */
    private String dumpId;

    public String getStatus() {
        return status;
    }

    public EventDumpCreateResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDumpId() {
        return dumpId;
    }

    public EventDumpCreateResponse setDumpId(String dumpId) {
        this.dumpId = dumpId;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static EventDumpCreateResponse fromMap(Map<String, Object> data) {
        EventDumpCreateResponse result = new EventDumpCreateResponse();
        result.status = Json.asString(data.get("status"));
        result.dumpId = Json.asString(data.get("dump_id"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "dump_id", dumpId);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
