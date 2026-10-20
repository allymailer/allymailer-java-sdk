package ua.com.allymailer.api.system.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/**
 * Об'єкт з властивостями періоду обліку. Присутній лише якщо API-ключ, використаний для запиту, був
 * API-ключем користувача.
 */
public class SystemInfoResponseAccounting {
    /** Дата й час початку періоду обліку в часовому поясі UTC у форматі "РРРР-ММ-ДД гг:хх:сс". */
    private String periodStart;

    /** Дата й час кінця періоду обліку в часовому поясі UTC у форматі "РРРР-ММ-ДД гг:хх:сс". */
    private String periodEnd;

    /** Кількість листів, включених в обліковий період. */
    private Long emailsIncluded;

    /**
     * Кількість листів, надісланих за обліковий період. Може бути більшою за emails_included у разі
     * перевищення.
     */
    private Long emailsSent;

    public String getPeriodStart() {
        return periodStart;
    }

    public SystemInfoResponseAccounting setPeriodStart(String periodStart) {
        this.periodStart = periodStart;
        return this;
    }

    public String getPeriodEnd() {
        return periodEnd;
    }

    public SystemInfoResponseAccounting setPeriodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
        return this;
    }

    public Long getEmailsIncluded() {
        return emailsIncluded;
    }

    public SystemInfoResponseAccounting setEmailsIncluded(Long emailsIncluded) {
        this.emailsIncluded = emailsIncluded;
        return this;
    }

    public Long getEmailsSent() {
        return emailsSent;
    }

    public SystemInfoResponseAccounting setEmailsSent(Long emailsSent) {
        this.emailsSent = emailsSent;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static SystemInfoResponseAccounting fromMap(Map<String, Object> data) {
        SystemInfoResponseAccounting result = new SystemInfoResponseAccounting();
        result.periodStart = Json.asString(data.get("period_start"));
        result.periodEnd = Json.asString(data.get("period_end"));
        result.emailsIncluded = Json.asLong(data.get("emails_included"));
        result.emailsSent = Json.asLong(data.get("emails_sent"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "period_start", periodStart);
        Json.put(result, "period_end", periodEnd);
        Json.put(result, "emails_included", emailsIncluded);
        Json.put(result, "emails_sent", emailsSent);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
