package ua.com.allymailer.api.eventdump.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** Об'єкт із властивостями дампа подій. */
public class EventDumpObject {
    /**
     * Ідентифікатор дампа, отриманий методом
     * [event-dump/create](https://docs.allymailer.com.ua/ua/web-api-ref#event-dump-create).
     */
    private String dumpId;

    /**
     * Статус задачі. Одне з чотирьох значень:
     * <p>
     * - __queued__ - очікує в черзі, обробка ще не починалася;
     * - __in_process__ - триває обробка;
     * - __ready__ - обробку завершено, файли доступні для завантаження;
     * - __failed__ - обробку перервано з помилкою.
     */
    private String dumpStatus;

    /**
     * Масив об'єктів, кожен з яких позначає готовий до завантаження файл. Навіть якщо
     * "dump_status"="in_process", уже можна завантажувати ті файли, які вказані в "files". У разі
     * відсутності подій за заданими параметрами буде повернуто порожній масив.
     */
    private List<EventDumpFilesObject> files;

    public String getDumpId() {
        return dumpId;
    }

    public EventDumpObject setDumpId(String dumpId) {
        this.dumpId = dumpId;
        return this;
    }

    public String getDumpStatus() {
        return dumpStatus;
    }

    public EventDumpObject setDumpStatus(String dumpStatus) {
        this.dumpStatus = dumpStatus;
        return this;
    }

    public List<EventDumpFilesObject> getFiles() {
        return files;
    }

    public EventDumpObject setFiles(List<EventDumpFilesObject> files) {
        this.files = files;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static EventDumpObject fromMap(Map<String, Object> data) {
        EventDumpObject result = new EventDumpObject();
        result.dumpId = Json.asString(data.get("dump_id"));
        result.dumpStatus = Json.asString(data.get("dump_status"));
        result.files = Json.asList(data.get("files"), v0 -> Json.asObject(v0, EventDumpFilesObject::fromMap));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "dump_id", dumpId);
        Json.put(result, "dump_status", dumpStatus);
        Json.put(result, "files", Json.mapList(files, v0 -> v0.toMap()));
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
