package ua.com.allymailer.api.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** DomainValidateVerificationRecordRequest */
public class DomainValidateVerificationRecordRequest {
    /** Домен, для якого перевіряється запис про володіння. */
    private String domain;

    public String getDomain() {
        return domain;
    }

    public DomainValidateVerificationRecordRequest setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static DomainValidateVerificationRecordRequest fromMap(Map<String, Object> data) {
        DomainValidateVerificationRecordRequest result = new DomainValidateVerificationRecordRequest();
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
