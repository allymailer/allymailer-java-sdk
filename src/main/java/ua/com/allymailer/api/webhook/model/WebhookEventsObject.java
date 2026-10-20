package ua.com.allymailer.api.webhook.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ua.com.allymailer.client.Json;
import ua.com.allymailer.common.model.EmailStatus;

/** Об'єкт, що описує події, про які потрібно сповіщати. */
public class WebhookEventsObject {
    /**
     * Якщо присутній, то надсилатимуться сповіщення про спам-блокування. У масиві має бути єдиний елемент
     * із рядком "*".
     */
    private List<String> spamBlock;

    /**
     * Якщо присутній, то надсилатимуться сповіщення про зміну статусу email. У масиві перелічуються ті
     * статуси, про які надсилатимуться сповіщення.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private List<String> emailStatus;

    public List<String> getSpamBlock() {
        return spamBlock;
    }

    public WebhookEventsObject setSpamBlock(List<String> spamBlock) {
        this.spamBlock = spamBlock;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getEmailStatusValue()), null when absent.
     */
    public List<EmailStatus> getEmailStatus() {
        return Json.asList(emailStatus, EmailStatus::fromValue);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setEmailStatusValue()).
     */
    public WebhookEventsObject setEmailStatus(List<EmailStatus> emailStatus) {
        this.emailStatus = Json.convertList(emailStatus, EmailStatus::toValue);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public List<String> getEmailStatusValue() {
        return emailStatus;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public WebhookEventsObject setEmailStatusValue(List<String> emailStatus) {
        this.emailStatus = emailStatus;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static WebhookEventsObject fromMap(Map<String, Object> data) {
        WebhookEventsObject result = new WebhookEventsObject();
        result.spamBlock = Json.asList(data.get("spam_block"), Json::asString);
        result.emailStatus = Json.asList(data.get("email_status"), Json::asString);
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "spam_block", spamBlock);
        Json.put(result, "email_status", emailStatus);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
