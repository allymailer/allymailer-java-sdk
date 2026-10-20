package ua.com.allymailer.api.email.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** Додаткові опції. */
public class MessageObjectOptions {
    /**
     * Дата й час у форматі "РРРР-ММ-ДД гг:хх:сс" у часовому поясі UTC. Дозволяє запланувати час надсилання
     * на майбутнє, у межах 24 годин від поточного часу.
     */
    private String sendAt;

    /** Користувацьке посилання відписки. Докладніше [тут](https://docs.allymailer.com.ua/unsubscribe-link). */
    private String unsubscribeUrl;

    /**
     * Ідентифікатор backend-домену, через який надсилається повідомлення. Якщо відсутній — надсилання буде
     * від імені backend-домену, призначеного вашому обліковому запису/проєкту за замовчуванням. Ви можете
     * придбати один або декілька виділених IP-адрес і використовувати цю опцію для вибору.
     */
    private Integer customBackendId;

    /**
     * Ідентифікатор пулу SMTP, через який надсилається повідомлення. Зазвичай немає необхідності вказувати
     * пул явно, оскільки він обирається автоматично або як пул за замовчуванням для вашого облікового
     * запису/проєкту, або відповідно до переданого параметра custom_backend_id.
     */
    private String smtpPoolId;

    public String getSendAt() {
        return sendAt;
    }

    public MessageObjectOptions setSendAt(String sendAt) {
        this.sendAt = sendAt;
        return this;
    }

    public String getUnsubscribeUrl() {
        return unsubscribeUrl;
    }

    public MessageObjectOptions setUnsubscribeUrl(String unsubscribeUrl) {
        this.unsubscribeUrl = unsubscribeUrl;
        return this;
    }

    public Integer getCustomBackendId() {
        return customBackendId;
    }

    public MessageObjectOptions setCustomBackendId(Integer customBackendId) {
        this.customBackendId = customBackendId;
        return this;
    }

    public String getSmtpPoolId() {
        return smtpPoolId;
    }

    public MessageObjectOptions setSmtpPoolId(String smtpPoolId) {
        this.smtpPoolId = smtpPoolId;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static MessageObjectOptions fromMap(Map<String, Object> data) {
        MessageObjectOptions result = new MessageObjectOptions();
        result.sendAt = Json.asString(data.get("send_at"));
        result.unsubscribeUrl = Json.asString(data.get("unsubscribe_url"));
        result.customBackendId = Json.asInteger(data.get("custom_backend_id"));
        result.smtpPoolId = Json.asString(data.get("smtp_pool_id"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "send_at", sendAt);
        Json.put(result, "unsubscribe_url", unsubscribeUrl);
        Json.put(result, "custom_backend_id", customBackendId);
        Json.put(result, "smtp_pool_id", smtpPoolId);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
