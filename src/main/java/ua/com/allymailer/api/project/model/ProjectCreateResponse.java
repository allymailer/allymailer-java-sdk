package ua.com.allymailer.api.project.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** ProjectCreateResponse */
public class ProjectCreateResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /** Унікальний ідентифікатор проєкту, ASCII-рядок до 36 символів завдовжки. */
    private String projectId;

    /**
     * API-ключ проєкту. Ви можете використовувати цей ключ замість користувацького api_key у всіх методах,
     * крім project-методів.
     */
    private String projectApiKey;

    public String getStatus() {
        return status;
    }

    public ProjectCreateResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public ProjectCreateResponse setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectApiKey() {
        return projectApiKey;
    }

    public ProjectCreateResponse setProjectApiKey(String projectApiKey) {
        this.projectApiKey = projectApiKey;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ProjectCreateResponse fromMap(Map<String, Object> data) {
        ProjectCreateResponse result = new ProjectCreateResponse();
        result.status = Json.asString(data.get("status"));
        result.projectId = Json.asString(data.get("project_id"));
        result.projectApiKey = Json.asString(data.get("project_api_key"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "project_id", projectId);
        Json.put(result, "project_api_key", projectApiKey);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
