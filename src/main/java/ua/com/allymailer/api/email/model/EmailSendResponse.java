package ua.com.allymailer.api.email.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** EmailSendResponse */
public class EmailSendResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /** Ідентифікатор завдання з надсилання, може виявитися корисним під час з'ясування причин збоїв. */
    private String jobId;

    /** Масив email-адрес, успішно прийнятих до надсилання. */
    private List<String> emails;

    /**
     * Об'єкт із email-адресами, не прийнятими до надсилання. Email представлено іменем властивості, а його
     * статус — значенням властивості, наприклад: {"email1&#64;gmail.com": "temporary_unavailable"}. Можливі
     * статуси адрес, на які не вдалося здійснити надсилання:
     * <p>
     * - __unsubscribed__ — зазначену адресу відписано;
     * - __invalid__ — адреса не існує або введена некоректно;
     * - __duplicate__ — адреса повторюється в запиті, повторне надсилання на той самий email запобігнуто;
     * - __temporary_unavailable__ — адреса тимчасово недоступна. Це означає, що протягом наступних трьох діб надсилання на цю адресу повертатиме помилку. Email може бути тимчасово недоступним з різних причин, наприклад:
     * <p>
     * - попереднє надсилання було відхилено сервером отримувача як спам;
     * - поштова скринька отримувача переповнена або не використовується;
     * - домен не приймає пошту через неправильне налаштування на боці отримувача або з інших причин;
     * - сервер відправника було відхилено через блеклистинг;
     * <p>
     * - __permanent_unavailable__ — адреса перманентно недоступна через багаторазові недоставки;
     * - __complained__ — в одному з попередніх листів адресат натиснув “Це спам”;
     * - __blocked__ — надсилання на цю адресу заборонено адміністрацією AllyMailer.
     * У майбутньому можуть з'явитися й інші статуси.
     */
    private Map<String, String> failedEmails;

    public String getStatus() {
        return status;
    }

    public EmailSendResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public EmailSendResponse setJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public List<String> getEmails() {
        return emails;
    }

    public EmailSendResponse setEmails(List<String> emails) {
        this.emails = emails;
        return this;
    }

    public Map<String, String> getFailedEmails() {
        return failedEmails;
    }

    public EmailSendResponse setFailedEmails(Map<String, String> failedEmails) {
        this.failedEmails = failedEmails;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static EmailSendResponse fromMap(Map<String, Object> data) {
        EmailSendResponse result = new EmailSendResponse();
        result.status = Json.asString(data.get("status"));
        result.jobId = Json.asString(data.get("job_id"));
        result.emails = Json.asList(data.get("emails"), Json::asString);
        result.failedEmails = Json.asMapOf(data.get("failed_emails"), Json::asString);
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "job_id", jobId);
        Json.put(result, "emails", emails);
        Json.put(result, "failed_emails", failedEmails);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
