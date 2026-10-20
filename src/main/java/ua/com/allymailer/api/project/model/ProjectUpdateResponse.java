package ua.com.allymailer.api.project.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** ProjectUpdateResponse */
public class ProjectUpdateResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /**
     * API-ключ проєкту. Повертається лише в разі, якщо в параметрі запиту був project_api_key. Якщо ж
     * проєкт було ідентифіковано через project_id, то не повертається.
     */
    private String projectApiKey;

    public String getStatus() {
        return status;
    }

    public ProjectUpdateResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getProjectApiKey() {
        return projectApiKey;
    }

    public ProjectUpdateResponse setProjectApiKey(String projectApiKey) {
        this.projectApiKey = projectApiKey;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ProjectUpdateResponse fromMap(Map<String, Object> data) {
        ProjectUpdateResponse result = new ProjectUpdateResponse();
        result.status = Json.asString(data.get("status"));
        result.projectApiKey = Json.asString(data.get("project_api_key"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "project_api_key", projectApiKey);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
