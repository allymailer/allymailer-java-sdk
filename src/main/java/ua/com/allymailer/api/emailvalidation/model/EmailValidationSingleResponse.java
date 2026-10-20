package ua.com.allymailer.api.emailvalidation.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** EmailValidationSingleResponse */
public class EmailValidationSingleResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /** Email, що перевіряється. */
    private String email;

    /**
     * Можливі статуси:
     * <p>
     * - "valid" - email-адреса дійсна,
     * - "invalid" - email-адреса недійсна,
     * - "suspicious" - email-адреса підозріла,
     * - "unknown" - адресу не вдалося перевірити. Приймаючий сервер не відповів у межах припустимого часу перевірки.
     */
    private String resultValue;

    /**
     * Можливі статуси:
     * <p>
     * - "no_mx_record" - у домену відсутні MX-записи,
     * - "syntax_error" - адреса не відповідає стандартам email,
     * - "possible_typo" - можливо, адресу введено з помилкою,
     * - "mailbox_not_found" - адреса не існує,
     * - "global_suppression" - адреса перманентно недоступна в сервісі через багаторазові недоставки,
     * - "disposable" - одноразовий email, зазвичай такі адреси приймають пошту лише декілька хвилин,
     * - "role" - загальна адреса електронної пошти, найчастіше використовується групою людей і не належить конкретній особі,
     * - "abuse" - адреси, з яких надходить велика кількість скарг і натискань на "спам", іноді навіть в автоматичному режимі,
     * - "spamtrap" - адреси-спам-пастки, зазвичай розміщуються поштовими провайдерами у відкритому доступі, але ніколи не використовуються для підписки. Надсилання листів на такі адреси сильно шкодить репутації відправника,
     * - "smtp_connection_failed" - SMTP-сервер недоступний — можливо, адресу введено з помилкою.
     */
    private String cause;

    /** Імовірність того, що адреса дійсна. Від 0 до 100 (100 - дійсна, 0 - недійсна). */
    private Integer validity;

    /** Локальна частина email-адреси (усе, що перед знаком "&#64;"). */
    private String localPart;

    /** Доменна частина email-адреси. */
    private String domain;

    /** Чи є у домену MX-запис? true якщо є, false якщо відсутній. */
    private Boolean mxFound;

    /** Бажана MX-запис домену. */
    private String mxRecord;

    /** Можлива адреса, отримана після виправлення помилки (для cause=possible_typo). */
    private String didYouMean;

    /** Дата й час перевірки адреси у форматі РРРР-ММ-ДД гг:хх:сс у часовому поясі UTC. */
    private String processedAt;

    public String getStatus() {
        return status;
    }

    public EmailValidationSingleResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmailValidationSingleResponse setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getResultValue() {
        return resultValue;
    }

    public EmailValidationSingleResponse setResultValue(String resultValue) {
        this.resultValue = resultValue;
        return this;
    }

    public String getCause() {
        return cause;
    }

    public EmailValidationSingleResponse setCause(String cause) {
        this.cause = cause;
        return this;
    }

    public Integer getValidity() {
        return validity;
    }

    public EmailValidationSingleResponse setValidity(Integer validity) {
        this.validity = validity;
        return this;
    }

    public String getLocalPart() {
        return localPart;
    }

    public EmailValidationSingleResponse setLocalPart(String localPart) {
        this.localPart = localPart;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public EmailValidationSingleResponse setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public Boolean getMxFound() {
        return mxFound;
    }

    public EmailValidationSingleResponse setMxFound(Boolean mxFound) {
        this.mxFound = mxFound;
        return this;
    }

    public String getMxRecord() {
        return mxRecord;
    }

    public EmailValidationSingleResponse setMxRecord(String mxRecord) {
        this.mxRecord = mxRecord;
        return this;
    }

    public String getDidYouMean() {
        return didYouMean;
    }

    public EmailValidationSingleResponse setDidYouMean(String didYouMean) {
        this.didYouMean = didYouMean;
        return this;
    }

    public String getProcessedAt() {
        return processedAt;
    }

    public EmailValidationSingleResponse setProcessedAt(String processedAt) {
        this.processedAt = processedAt;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static EmailValidationSingleResponse fromMap(Map<String, Object> data) {
        EmailValidationSingleResponse result = new EmailValidationSingleResponse();
        result.status = Json.asString(data.get("status"));
        result.email = Json.asString(data.get("email"));
        result.resultValue = Json.asString(data.get("result"));
        result.cause = Json.asString(data.get("cause"));
        result.validity = Json.asInteger(data.get("validity"));
        result.localPart = Json.asString(data.get("local_part"));
        result.domain = Json.asString(data.get("domain"));
        result.mxFound = Json.asBoolean(data.get("mx_found"));
        result.mxRecord = Json.asString(data.get("mx_record"));
        result.didYouMean = Json.asString(data.get("did_you_mean"));
        result.processedAt = Json.asString(data.get("processed_at"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "email", email);
        Json.put(result, "result", resultValue);
        Json.put(result, "cause", cause);
        Json.put(result, "validity", validity);
        Json.put(result, "local_part", localPart);
        Json.put(result, "domain", domain);
        Json.put(result, "mx_found", mxFound);
        Json.put(result, "mx_record", mxRecord);
        Json.put(result, "did_you_mean", didYouMean);
        Json.put(result, "processed_at", processedAt);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
