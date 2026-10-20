package ua.com.allymailer.api.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** Об'єкт, що описує DKIM-запис та її статус. */
public class DomainListResponseDomainsItemDkim {
    /**
     * DKIM-підпис для домену. У цьому полі повертається лише ключ. Щоб DNS-запис був коректним, перед
     * ключем потрібно додати "k=rsa, p=" (див.
     * [domain/get-dns-records](https://docs.allymailer.com.ua/ua/web-api-ref#domain-get-dns-records)).
     */
    private String key;

    /**
     * Лише домени зі статусом DKIM-запису "active" можуть використовуватися для надсилання листів.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String status;

    public String getKey() {
        return key;
    }

    public DomainListResponseDomainsItemDkim setKey(String key) {
        this.key = key;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getStatusValue()), null when absent.
     */
    public DkimStatus getStatus() {
        return DkimStatus.fromValue(status);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setStatusValue()).
     */
    public DomainListResponseDomainsItemDkim setStatus(DkimStatus status) {
        this.status = DkimStatus.toValue(status);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getStatusValue() {
        return status;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public DomainListResponseDomainsItemDkim setStatusValue(String status) {
        this.status = status;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static DomainListResponseDomainsItemDkim fromMap(Map<String, Object> data) {
        DomainListResponseDomainsItemDkim result = new DomainListResponseDomainsItemDkim();
        result.key = Json.asString(data.get("key"));
        result.status = Json.asString(data.get("status"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "key", key);
        Json.put(result, "status", status);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
