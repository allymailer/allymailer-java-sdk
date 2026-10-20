package ua.com.allymailer.api.eventdump.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** EventDumpDeleteRequest */
public class EventDumpDeleteRequest {
    /**
     * Ідентифікатор дампа, отриманий методом
     * [event-dump/create](https://docs.allymailer.com.ua/ua/web-api-ref#event-dump-create).
     */
    private String dumpId;

    public String getDumpId() {
        return dumpId;
    }

    public EventDumpDeleteRequest setDumpId(String dumpId) {
        this.dumpId = dumpId;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static EventDumpDeleteRequest fromMap(Map<String, Object> data) {
        EventDumpDeleteRequest result = new EventDumpDeleteRequest();
        result.dumpId = Json.asString(data.get("dump_id"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "dump_id", dumpId);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
