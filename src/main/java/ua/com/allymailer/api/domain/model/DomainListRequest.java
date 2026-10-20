package ua.com.allymailer.api.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** DomainListRequest */
public class DomainListRequest {
    /** Опціональне ім'я домену, якщо вам потрібно отримати статуси лише за одним доменом. */
    private String domain;

    /**
     * Максимальна кількість доменів, що повертаються. За замовчуванням 50.
     * За замовчуванням: `50`.
     */
    private Integer limit;

    /**
     * Індекс першого домену зі списку, що повертається, рахуючи з нуля.
     * За замовчуванням: `0`.
     */
    private Integer offset;

    public String getDomain() {
        return domain;
    }

    public DomainListRequest setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public DomainListRequest setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public DomainListRequest setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static DomainListRequest fromMap(Map<String, Object> data) {
        DomainListRequest result = new DomainListRequest();
        result.domain = Json.asString(data.get("domain"));
        result.limit = Json.asInteger(data.get("limit"));
        result.offset = Json.asInteger(data.get("offset"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "domain", domain);
        Json.put(result, "limit", limit);
        Json.put(result, "offset", offset);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
