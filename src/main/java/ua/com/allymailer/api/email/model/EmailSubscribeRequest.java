package ua.com.allymailer.api.email.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** EmailSubscribeRequest */
public class EmailSubscribeRequest {
    /**
     * Адреса відправника на підтвердженому домені. (Також підтримується іменування поля як
     * "email_address_from").
     */
    private String fromEmail;

    /** Ім'я відправника. (Також підтримується іменування поля як "name_from"). */
    private String fromName;

    /** Адреса отримувача. (Також підтримується іменування поля як "email_address_to"). */
    private String toEmail;

    public String getFromEmail() {
        return fromEmail;
    }

    public EmailSubscribeRequest setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
        return this;
    }

    public String getFromName() {
        return fromName;
    }

    public EmailSubscribeRequest setFromName(String fromName) {
        this.fromName = fromName;
        return this;
    }

    public String getToEmail() {
        return toEmail;
    }

    public EmailSubscribeRequest setToEmail(String toEmail) {
        this.toEmail = toEmail;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static EmailSubscribeRequest fromMap(Map<String, Object> data) {
        EmailSubscribeRequest result = new EmailSubscribeRequest();
        result.fromEmail = Json.asString(data.get("from_email"));
        result.fromName = Json.asString(data.get("from_name"));
        result.toEmail = Json.asString(data.get("to_email"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "from_email", fromEmail);
        Json.put(result, "from_name", fromName);
        Json.put(result, "to_email", toEmail);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
