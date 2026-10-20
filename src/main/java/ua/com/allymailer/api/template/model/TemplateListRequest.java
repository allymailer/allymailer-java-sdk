package ua.com.allymailer.api.template.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** TemplateListRequest */
public class TemplateListRequest {
    /**
     * Максимальна кількість шаблонів, що повертаються, за замовчуванням 50.
     * За замовчуванням: `50`.
     */
    private Integer limit;

    /**
     * Індекс першого шаблону зі списку, що повертається, рахуючи з нуля.
     * За замовчуванням: `0`.
     */
    private Integer offset;

    public Integer getLimit() {
        return limit;
    }

    public TemplateListRequest setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public TemplateListRequest setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static TemplateListRequest fromMap(Map<String, Object> data) {
        TemplateListRequest result = new TemplateListRequest();
        result.limit = Json.asInteger(data.get("limit"));
        result.offset = Json.asInteger(data.get("offset"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "limit", limit);
        Json.put(result, "offset", offset);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
