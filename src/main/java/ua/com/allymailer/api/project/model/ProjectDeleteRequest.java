package ua.com.allymailer.api.project.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** ProjectDeleteRequest */
public class ProjectDeleteRequest {
    /**
     * Ідентифікатор проєкту, що видаляється. Проєкт має бути ідентифіковано або цим полем project_id, або
     * полем project_api_key. Ми рекомендуємо використовувати project_id, це безпечніше.
     */
    private String projectId;

    /**
     * Необов'язковий API-ключ проєкту, що видаляється. Проєкт має бути ідентифіковано або полем
     * project_id, або полем project_api_key. Ми рекомендуємо використовувати project_id, це безпечніше.
     */
    private String projectApiKey;

    public String getProjectId() {
        return projectId;
    }

    public ProjectDeleteRequest setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectApiKey() {
        return projectApiKey;
    }

    public ProjectDeleteRequest setProjectApiKey(String projectApiKey) {
        this.projectApiKey = projectApiKey;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ProjectDeleteRequest fromMap(Map<String, Object> data) {
        ProjectDeleteRequest result = new ProjectDeleteRequest();
        result.projectId = Json.asString(data.get("project_id"));
        result.projectApiKey = Json.asString(data.get("project_api_key"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "project_id", projectId);
        Json.put(result, "project_api_key", projectApiKey);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
