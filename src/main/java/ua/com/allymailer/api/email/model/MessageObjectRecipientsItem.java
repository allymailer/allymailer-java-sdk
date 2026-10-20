package ua.com.allymailer.api.email.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** MessageObjectRecipientsItem */
public class MessageObjectRecipientsItem {
    /** Email-адреса отримувача */
    private String email;

    /**
     * Об'єкт, що описує підстановки для конкретного отримувача (наприклад, ім'я, товар для показу саме
     * цьому отримувачу — див. [Шаблонізатори](https://docs.allymailer.com.ua/en/template-engines)).
     * Підстановки працюють у параметрах:
     * <p>
     * - body.html
     * - body.plaintext
     * - body.amp
     * - subject
     * - from_name
     * - headers["List-Unsubscribe"]
     * - options.unsubscribe_url
     * Назви змінних можуть містити літери латинського алфавіту, цифри, символ "_". Першим символом може
     * бути лише літера, використання пробілів не допускається. Є спеціальна змінна "to_name", що дозволяє
     * задати ім'я отримувача. У разі підстановки туди "Ім'я Прізвище" SMTP-заголовок “To” виглядатиме як
     * "Ім'я Прізвище &lt;email&#64;example.com&gt;". Довжина змінної "to_name" обмежена 78 символами.
     */
    private Map<String, String> substitutions;

    /**
     * Об'єкт для передачі метаданих, специфічних для окремого отримувача, де "key" — рядок до 64 символів
     * завдовжки, "value" — рядок до 1024 символів завдовжки, максимальна кількість ключів — 10. Метадані
     * передаються під час виклику [webhook](https://docs.allymailer.com.ua/ua/web-api-ref#webhook) і
     * методів [event-dump](https://docs.allymailer.com.ua/ua/web-api-ref#event-dump). Для групування
     * листів в одну розсилку може використовуватися системний ключ "campaign_id" зі значенням у вигляді
     * невід'ємного десяткового цілого або UUID до 128 біт.
     */
    private Map<String, String> metadata;

    public String getEmail() {
        return email;
    }

    public MessageObjectRecipientsItem setEmail(String email) {
        this.email = email;
        return this;
    }

    public Map<String, String> getSubstitutions() {
        return substitutions;
    }

    public MessageObjectRecipientsItem setSubstitutions(Map<String, String> substitutions) {
        this.substitutions = substitutions;
        return this;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public MessageObjectRecipientsItem setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static MessageObjectRecipientsItem fromMap(Map<String, Object> data) {
        MessageObjectRecipientsItem result = new MessageObjectRecipientsItem();
        result.email = Json.asString(data.get("email"));
        result.substitutions = Json.asMapOf(data.get("substitutions"), Json::asString);
        result.metadata = Json.asMapOf(data.get("metadata"), Json::asString);
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "email", email);
        Json.put(result, "substitutions", substitutions);
        Json.put(result, "metadata", metadata);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
