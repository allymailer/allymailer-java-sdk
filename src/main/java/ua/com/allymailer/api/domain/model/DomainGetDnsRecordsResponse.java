package ua.com.allymailer.api.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** DomainGetDnsRecordsResponse */
public class DomainGetDnsRecordsResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /** Домен, для якого потрібно отримати інформацію про DNS-записи. */
    private String domain;

    /** Запис, який потрібно внести "як є" для підтвердження володіння цим доменом. */
    private String verificationRecord;

    /**
     * DKIM-підпис для домену. У цьому полі повертається лише ключ. Щоб TXT-запис був коректним, перед
     * ключем потрібно додати "v=DKIM1; k=rsa; p=".
     */
    private String dkim;

    /** Значення CNAME-запису для хоста "_dmarc" домену. */
    private String dmarc;

    public String getStatus() {
        return status;
    }

    public DomainGetDnsRecordsResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public DomainGetDnsRecordsResponse setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getVerificationRecord() {
        return verificationRecord;
    }

    public DomainGetDnsRecordsResponse setVerificationRecord(String verificationRecord) {
        this.verificationRecord = verificationRecord;
        return this;
    }

    public String getDkim() {
        return dkim;
    }

    public DomainGetDnsRecordsResponse setDkim(String dkim) {
        this.dkim = dkim;
        return this;
    }

    public String getDmarc() {
        return dmarc;
    }

    public DomainGetDnsRecordsResponse setDmarc(String dmarc) {
        this.dmarc = dmarc;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static DomainGetDnsRecordsResponse fromMap(Map<String, Object> data) {
        DomainGetDnsRecordsResponse result = new DomainGetDnsRecordsResponse();
        result.status = Json.asString(data.get("status"));
        result.domain = Json.asString(data.get("domain"));
        result.verificationRecord = Json.asString(data.get("verification-record"));
        result.dkim = Json.asString(data.get("dkim"));
        result.dmarc = Json.asString(data.get("dmarc"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "domain", domain);
        Json.put(result, "verification-record", verificationRecord);
        Json.put(result, "dkim", dkim);
        Json.put(result, "dmarc", dmarc);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
