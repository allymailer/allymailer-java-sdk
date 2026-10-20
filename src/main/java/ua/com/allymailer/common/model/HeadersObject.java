package ua.com.allymailer.common.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import ua.com.allymailer.client.Json;

/**
 * Об'єкт, що містить додаткові заголовки листа, максимум 50 заголовків. Префікс “X-” в імені заголовка
 * обов'язковий, заголовки без нього будуть проігноровані, наприклад X-ALLYMAILER-Global-Language,
 * X-ALLYMAILER-Template-Engine. Стандартні заголовки "To", "CC", "BCC" передаються без префікса "X-",
 * але обробляються спеціальним чином, тому мають низку обмежень, докладніше про це можна прочитати
 * [тут](/cc-and-bcc). Також якщо [техпідтримка](https://cp.allymailer.com/ua/support) схвалила вам
 * вимкнення посилання відписки, то ви також можете передавати заголовки List-Unsubscribe,
 * List-Subscribe, List-Help, List-Owner, List-Archive, In-Reply-To і References.
 * <p>
 * Keys beyond the named fields (any header, e.g. X-MyHeader, CC, List-Unsubscribe) go to the extra
 * map: putExtra("X-MyHeader", "value"). In JSON they sit next to the named fields; a named field wins
 * over an extra key with the same name.
 */
public class HeadersObject {
    /** JSON keys of the named fields. */
    private static final Set<String> NAMED = Collections.unmodifiableSet(new HashSet<>(
        Arrays.asList("X-ALLYMAILER-Global-Language", "X-ALLYMAILER-Template-Engine")));

    /**
     * Заголовок для вибору мови посилання та сторінки відписки. Припустимі значення "be", "de", "en",
     * "es", "fr", "it", "pl", "pt", "ru", "ua", "kz".
     */
    private String xALLYMAILERGlobalLanguage;

    /**
     * Заголовок для вибору шаблонізатора — або “simple”, або “velocity”, або “liquid”, або “none”. За
     * замовчуванням — “simple”. Має пріоритет над значенням, що передається в параметрі “template_engine”.
     */
    private String xALLYMAILERTemplateEngine;

    /** Keys beyond the named fields (additionalProperties). */
    private Map<String, String> extra;

    public String getXALLYMAILERGlobalLanguage() {
        return xALLYMAILERGlobalLanguage;
    }

    public HeadersObject setXALLYMAILERGlobalLanguage(String xALLYMAILERGlobalLanguage) {
        this.xALLYMAILERGlobalLanguage = xALLYMAILERGlobalLanguage;
        return this;
    }

    public String getXALLYMAILERTemplateEngine() {
        return xALLYMAILERTemplateEngine;
    }

    public HeadersObject setXALLYMAILERTemplateEngine(String xALLYMAILERTemplateEngine) {
        this.xALLYMAILERTemplateEngine = xALLYMAILERTemplateEngine;
        return this;
    }

    /** Keys beyond the named fields, null when there are none. */
    public Map<String, String> getExtra() {
        return extra;
    }

    /** Replaces the keys beyond the named fields. */
    public HeadersObject setExtra(Map<String, String> extra) {
        this.extra = extra;
        return this;
    }

    /** Adds a key beyond the named fields, e.g. putExtra("X-MyHeader", "value"). */
    public HeadersObject putExtra(String key, String value) {
        if (extra == null) {
            extra = new LinkedHashMap<>();
        }
        extra.put(key, value);
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static HeadersObject fromMap(Map<String, Object> data) {
        HeadersObject result = new HeadersObject();
        result.xALLYMAILERGlobalLanguage = Json.asString(data.get("X-ALLYMAILER-Global-Language"));
        result.xALLYMAILERTemplateEngine = Json.asString(data.get("X-ALLYMAILER-Template-Engine"));
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            if (!NAMED.contains(entry.getKey())) {
                result.putExtra(entry.getKey(), Json.asString(entry.getValue()));
            }
        }
        return result;
    }

    /**
     * JSON-ready map, null fields are omitted. Extra keys follow the named fields, a named field wins on a
     * clash.
     */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "X-ALLYMAILER-Global-Language", xALLYMAILERGlobalLanguage);
        Json.put(result, "X-ALLYMAILER-Template-Engine", xALLYMAILERTemplateEngine);
        if (extra != null) {
            for (Map.Entry<String, String> entry : extra.entrySet()) {
                if (entry.getValue() != null && !result.containsKey(entry.getKey())) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
