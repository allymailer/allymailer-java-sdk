package ua.com.allymailer.api.system.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;
import ua.com.allymailer.common.model.EmailCounterMode;

/**
 * Об'єкт із властивостями лічильника листів. Присутній лише якщо API-ключ, використаний для запиту,
 * був API-ключем проєкту.
 */
public class ProjectAccountingObject {
    /** Значення лічильника листів для проєкту, збільшується під час надсилання кожного листа. */
    private Long emailCounter;

    /**
     * Дозволяє обмежити кількість надісланих проєктом листів. У разі досягнення цього ліміту надсилання
     * припиняється. Значення 0 (за замовчуванням) означає відсутність ліміту.
     */
    private Long emailCounterLimit;

    /**
     * 'default' - лічильник автоматично скидається в нуль на початку кожного облікового періоду,
     * 'permanent' - лічильник ніколи не скидається автоматично.
     * За замовчуванням: `default`.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String emailCounterMode;

    public Long getEmailCounter() {
        return emailCounter;
    }

    public ProjectAccountingObject setEmailCounter(Long emailCounter) {
        this.emailCounter = emailCounter;
        return this;
    }

    public Long getEmailCounterLimit() {
        return emailCounterLimit;
    }

    public ProjectAccountingObject setEmailCounterLimit(Long emailCounterLimit) {
        this.emailCounterLimit = emailCounterLimit;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getEmailCounterModeValue()), null when absent.
     */
    public EmailCounterMode getEmailCounterMode() {
        return EmailCounterMode.fromValue(emailCounterMode);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setEmailCounterModeValue()).
     */
    public ProjectAccountingObject setEmailCounterMode(EmailCounterMode emailCounterMode) {
        this.emailCounterMode = EmailCounterMode.toValue(emailCounterMode);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getEmailCounterModeValue() {
        return emailCounterMode;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public ProjectAccountingObject setEmailCounterModeValue(String emailCounterMode) {
        this.emailCounterMode = emailCounterMode;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ProjectAccountingObject fromMap(Map<String, Object> data) {
        ProjectAccountingObject result = new ProjectAccountingObject();
        result.emailCounter = Json.asLong(data.get("email_counter"));
        result.emailCounterLimit = Json.asLong(data.get("email_counter_limit"));
        result.emailCounterMode = Json.asString(data.get("email_counter_mode"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "email_counter", emailCounter);
        Json.put(result, "email_counter_limit", emailCounterLimit);
        Json.put(result, "email_counter_mode", emailCounterMode);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
