package ua.com.allymailer.api.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** DomainGetDnsRecordsRequest */
public class DomainGetDnsRecordsRequest {
    /** Домен, для якого потрібно отримати інформацію про DNS-записи. */
    private String domain;

    public String getDomain() {
        return domain;
    }

    public DomainGetDnsRecordsRequest setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static DomainGetDnsRecordsRequest fromMap(Map<String, Object> data) {
        DomainGetDnsRecordsRequest result = new DomainGetDnsRecordsRequest();
        result.domain = Json.asString(data.get("domain"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "domain", domain);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
