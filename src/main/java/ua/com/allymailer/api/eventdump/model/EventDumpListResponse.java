package ua.com.allymailer.api.eventdump.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** EventDumpListResponse */
public class EventDumpListResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /**
     * Масив об'єктів, що описують дампи подій. Кожен об'єкт містить ті самі властивості, що й об'єкт
     * 'event_dump', який повертає метод
     * [event-dump/get](https://docs.allymailer.com.ua/ua/web-api-ref#event-dump-get).
     */
    private List<EventDumpObject> eventDumps;

    public String getStatus() {
        return status;
    }

    public EventDumpListResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<EventDumpObject> getEventDumps() {
        return eventDumps;
    }

    public EventDumpListResponse setEventDumps(List<EventDumpObject> eventDumps) {
        this.eventDumps = eventDumps;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static EventDumpListResponse fromMap(Map<String, Object> data) {
        EventDumpListResponse result = new EventDumpListResponse();
        result.status = Json.asString(data.get("status"));
        result.eventDumps = Json.asList(data.get("event_dumps"), v0 -> Json.asObject(v0, EventDumpObject::fromMap));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "event_dumps", Json.mapList(eventDumps, v0 -> v0.toMap()));
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
