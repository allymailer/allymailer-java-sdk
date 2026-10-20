package ua.com.allymailer.api.webhook.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** WebhookCallbackEventsByUserItem */
public class WebhookCallbackEventsByUserItem {
    /** Унікальний ідентифікатор користувача. */
    private Integer userId;

    /** Ідентифікатор проєкту, присутній, якщо webhook було зареєстровано за допомогою API-ключа проєкту. */
    private String projectId;

    /** Назва проєкту, присутня, якщо webhook було зареєстровано за допомогою API-ключа проєкту. */
    private String projectName;

    /** Масив подій, про які сповіщає виклик webhook. */
    private List<WebhookCallbackEventsByUserItemEventsItem> events;

    public Integer getUserId() {
        return userId;
    }

    public WebhookCallbackEventsByUserItem setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public WebhookCallbackEventsByUserItem setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public WebhookCallbackEventsByUserItem setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public List<WebhookCallbackEventsByUserItemEventsItem> getEvents() {
        return events;
    }

    public WebhookCallbackEventsByUserItem setEvents(List<WebhookCallbackEventsByUserItemEventsItem> events) {
        this.events = events;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static WebhookCallbackEventsByUserItem fromMap(Map<String, Object> data) {
        WebhookCallbackEventsByUserItem result = new WebhookCallbackEventsByUserItem();
        result.userId = Json.asInteger(data.get("user_id"));
        result.projectId = Json.asString(data.get("project_id"));
        result.projectName = Json.asString(data.get("project_name"));
        result.events = Json.asList(data.get("events"), v0 -> Json.asObject(v0, WebhookCallbackEventsByUserItemEventsItem::fromMap));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "user_id", userId);
        Json.put(result, "project_id", projectId);
        Json.put(result, "project_name", projectName);
        Json.put(result, "events", Json.mapList(events, v0 -> v0.toMap()));
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
