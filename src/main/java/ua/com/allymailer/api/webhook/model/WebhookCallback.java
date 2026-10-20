package ua.com.allymailer.api.webhook.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** Опис формату webhook. */
public class WebhookCallback {
    /**
     * MD5-хеш рядкового тіла повідомлення, у якому значення auth замінено на api_key користувача/проєкту,
     * чий обробник викликається. За допомогою цього отримувач сповіщення може як провести автентифікацію,
     * так і перевірити цілісність сповіщення.
     */
    private String auth;

    /** Масив з одним елементом, що містить дані про події користувача/проєкту. */
    private List<WebhookCallbackEventsByUserItem> eventsByUser;

    public String getAuth() {
        return auth;
    }

    public WebhookCallback setAuth(String auth) {
        this.auth = auth;
        return this;
    }

    public List<WebhookCallbackEventsByUserItem> getEventsByUser() {
        return eventsByUser;
    }

    public WebhookCallback setEventsByUser(List<WebhookCallbackEventsByUserItem> eventsByUser) {
        this.eventsByUser = eventsByUser;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static WebhookCallback fromMap(Map<String, Object> data) {
        WebhookCallback result = new WebhookCallback();
        result.auth = Json.asString(data.get("auth"));
        result.eventsByUser = Json.asList(data.get("events_by_user"), v0 -> Json.asObject(v0, WebhookCallbackEventsByUserItem::fromMap));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "auth", auth);
        Json.put(result, "events_by_user", Json.mapList(eventsByUser, v0 -> v0.toMap()));
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
