package ua.com.allymailer.api.obsolete.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** ObsoleteUnsubscribedSetResponse */
public class ObsoleteUnsubscribedSetResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /** Відписаний email. */
    private String address;

    /**
     * Подробиці відписки:
     * <p>
     * - "unsubscribed" якщо email було щойно відписано,
     * - "was inactive" якщо він уже був позначений як неактивний і немає сенсу відписувати,
     * - "was unsubscribed" якщо email уже було відписано раніше,
     * - "added and unsubscribed" якщо для цього email не зберігалося жодного більш раннього статусу, тому його було додано й одразу ж відписано.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String message;

    public String getStatus() {
        return status;
    }

    public ObsoleteUnsubscribedSetResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ObsoleteUnsubscribedSetResponse setAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getMessageValue()), null when absent.
     */
    public ObsoleteUnsubscribedSetMessage getMessage() {
        return ObsoleteUnsubscribedSetMessage.fromValue(message);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setMessageValue()).
     */
    public ObsoleteUnsubscribedSetResponse setMessage(ObsoleteUnsubscribedSetMessage message) {
        this.message = ObsoleteUnsubscribedSetMessage.toValue(message);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getMessageValue() {
        return message;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public ObsoleteUnsubscribedSetResponse setMessageValue(String message) {
        this.message = message;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ObsoleteUnsubscribedSetResponse fromMap(Map<String, Object> data) {
        ObsoleteUnsubscribedSetResponse result = new ObsoleteUnsubscribedSetResponse();
        result.status = Json.asString(data.get("status"));
        result.address = Json.asString(data.get("address"));
        result.message = Json.asString(data.get("message"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "address", address);
        Json.put(result, "message", message);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
