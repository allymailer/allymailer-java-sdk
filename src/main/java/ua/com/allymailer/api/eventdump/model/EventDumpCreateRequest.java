package ua.com.allymailer.api.eventdump.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** EventDumpCreateRequest */
public class EventDumpCreateRequest {
    /**
     * Дата й час у форматі РРРР-ММ-ДД гг:хх:сс, починаючи з якої необхідно отримати події. Дані
     * зберігаються до 45 днів, залежно від вашого тарифу.
     */
    private String startTime;

    /** Дата й час у форматі РРРР-ММ-ДД гг:хх:сс, до якої (не включно) запитуються події. */
    private String endTime;

    /**
     * Максимальна кількість подій, що повертаються, за замовчуванням 50. Якщо це значення перевищує 100
     * 000, буде створено декілька файлів, кожен з яких містить максимум 100 000 подій.
     */
    private Integer limit;

    /**
     * Якщо у користувача увімкнено проєкти, all_projects=true дозволить отримати дані всіх проєктів.
     * За замовчуванням: `False`.
     */
    private Boolean allProjects;

    /** Об'єкт із властивостями фільтра дампа подій. */
    private FilterObject filter;

    /**
     * Масив із рядків з переліком назв стовпців, які необхідно отримати у вивантаженні (у порядку
     * переліку). Якщо 'dump_fields' відсутній або порожній — застосовується набір і порядок полів за
     * замовчуванням. Припустимі значення (у порядку за замовчуванням): 'project_id', 'event_time',
     * 'job_id', 'from_email', 'email', 'status', 'delivery_status', 'metadata', 'destination_response',
     * 'user_agent', 'url', 'ip', 'tags'. З метою більшої конфіденційності поле 'subject' не входить до
     * набору полів за замовчуванням, але ви можете додати його, вказавши в параметрі 'dump_fields'.
     */
    private List<String> dumpFields;

    /**
     * Дозволяє отримати агреговану статистику за вказаний період. Може набувати одного з двох значень:
     * <p>
     * - __day_status__ - отримати агреговану статистику; за такого значення параметр filter має бути відсутнім або порожнім об'єктом (фільтри неприпустимі);
     * - __порожній рядок__ - значення за замовчуванням, еквівалентне відсутності параметра aggregate, і метод event_dump/create у цьому разі працює як раніше.
     */
    private String aggregate;

    /** Роздільник полів, за замовчуванням ','. Припустимі значення ',' і ';'. */
    private String delimiter;

    /**
     * Формат отримуваного файлу “csv” (за замовчуванням) або “csv_gzip”.
     * За замовчуванням: `csv`.
     */
    private String format;

    public String getStartTime() {
        return startTime;
    }

    public EventDumpCreateRequest setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public EventDumpCreateRequest setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public EventDumpCreateRequest setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Boolean getAllProjects() {
        return allProjects;
    }

    public EventDumpCreateRequest setAllProjects(Boolean allProjects) {
        this.allProjects = allProjects;
        return this;
    }

    public FilterObject getFilter() {
        return filter;
    }

    public EventDumpCreateRequest setFilter(FilterObject filter) {
        this.filter = filter;
        return this;
    }

    public List<String> getDumpFields() {
        return dumpFields;
    }

    public EventDumpCreateRequest setDumpFields(List<String> dumpFields) {
        this.dumpFields = dumpFields;
        return this;
    }

    public String getAggregate() {
        return aggregate;
    }

    public EventDumpCreateRequest setAggregate(String aggregate) {
        this.aggregate = aggregate;
        return this;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public EventDumpCreateRequest setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public EventDumpCreateRequest setFormat(String format) {
        this.format = format;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static EventDumpCreateRequest fromMap(Map<String, Object> data) {
        EventDumpCreateRequest result = new EventDumpCreateRequest();
        result.startTime = Json.asString(data.get("start_time"));
        result.endTime = Json.asString(data.get("end_time"));
        result.limit = Json.asInteger(data.get("limit"));
        result.allProjects = Json.asBoolean(data.get("all_projects"));
        result.filter = Json.asObject(data.get("filter"), FilterObject::fromMap);
        result.dumpFields = Json.asList(data.get("dump_fields"), Json::asString);
        result.aggregate = Json.asString(data.get("aggregate"));
        result.delimiter = Json.asString(data.get("delimiter"));
        result.format = Json.asString(data.get("format"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "start_time", startTime);
        Json.put(result, "end_time", endTime);
        Json.put(result, "limit", limit);
        Json.put(result, "all_projects", allProjects);
        Json.put(result, "filter", filter == null ? null : filter.toMap());
        Json.put(result, "dump_fields", dumpFields);
        Json.put(result, "aggregate", aggregate);
        Json.put(result, "delimiter", delimiter);
        Json.put(result, "format", format);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
