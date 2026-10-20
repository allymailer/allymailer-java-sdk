package ua.com.allymailer.api.obsolete.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** ObsoleteUnsubscribedListRequest */
public class ObsoleteUnsubscribedListRequest {
    /**
     * Дата у форматі РРРР-ММ-ДД, щоб отримати всі відписані адреси з "date_from" по сьогоднішній день.
     * Якщо параметр не вказати, період за замовчуванням буде з 00:00 сьогоднішнього дня за UTC.
     */
    private String dateFrom;

    public String getDateFrom() {
        return dateFrom;
    }

    public ObsoleteUnsubscribedListRequest setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ObsoleteUnsubscribedListRequest fromMap(Map<String, Object> data) {
        ObsoleteUnsubscribedListRequest result = new ObsoleteUnsubscribedListRequest();
        result.dateFrom = Json.asString(data.get("date_from"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "date_from", dateFrom);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
