package ua.com.allymailer.api.project.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** ProjectListRequest */
public class ProjectListRequest {
    /** Опціональна можливість указати project_id для включення до списку лише вказаного проєкту. */
    private String projectId;

    /** Опціональна можливість указати project_api_key для включення до списку лише вказаного проєкту. */
    private String projectApiKey;

    public String getProjectId() {
        return projectId;
    }

    public ProjectListRequest setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectApiKey() {
        return projectApiKey;
    }

    public ProjectListRequest setProjectApiKey(String projectApiKey) {
        this.projectApiKey = projectApiKey;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ProjectListRequest fromMap(Map<String, Object> data) {
        ProjectListRequest result = new ProjectListRequest();
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
