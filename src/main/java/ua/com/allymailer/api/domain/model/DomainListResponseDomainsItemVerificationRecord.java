package ua.com.allymailer.api.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;
import ua.com.allymailer.common.model.VerificationRecordStatus;

/** Об'єкт, що описує запис перевірки володіння та її статус. */
public class DomainListResponseDomainsItemVerificationRecord {
    /** Запис, який потрібно внести "як є" для підтвердження володіння цим доменом. */
    private String value;

    /**
     * Лише домени зі статусом "confirmed" запису про володіння доменом можуть використовуватися для
     * надсилання листів.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String status;

    public String getValue() {
        return value;
    }

    public DomainListResponseDomainsItemVerificationRecord setValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getStatusValue()), null when absent.
     */
    public VerificationRecordStatus getStatus() {
        return VerificationRecordStatus.fromValue(status);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setStatusValue()).
     */
    public DomainListResponseDomainsItemVerificationRecord setStatus(VerificationRecordStatus status) {
        this.status = VerificationRecordStatus.toValue(status);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getStatusValue() {
        return status;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public DomainListResponseDomainsItemVerificationRecord setStatusValue(String status) {
        this.status = status;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static DomainListResponseDomainsItemVerificationRecord fromMap(Map<String, Object> data) {
        DomainListResponseDomainsItemVerificationRecord result = new DomainListResponseDomainsItemVerificationRecord();
        result.value = Json.asString(data.get("value"));
        result.status = Json.asString(data.get("status"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "value", value);
        Json.put(result, "status", status);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
