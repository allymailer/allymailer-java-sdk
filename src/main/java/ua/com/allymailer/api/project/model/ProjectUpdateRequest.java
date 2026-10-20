package ua.com.allymailer.api.project.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** ProjectUpdateRequest */
public class ProjectUpdateRequest {
    /**
     * Ідентифікатор проєкту, що оновлюється. Проєкт має бути ідентифіковано або цим полем project_id, або
     * полем project_api_key. Ми рекомендуємо використовувати project_id, це безпечніше.
     */
    private String projectId;

    /**
     * Необов'язковий API-ключ проєкту, що оновлюється. Проєкт має бути ідентифіковано або полем
     * project_id, або полем project_api_key. Ми рекомендуємо використовувати project_id, це безпечніше.
     */
    private String projectApiKey;

    /** Об'єкт із властивостями проєкту. */
    private ProjectUpdateObject project;

    public String getProjectId() {
        return projectId;
    }

    public ProjectUpdateRequest setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectApiKey() {
        return projectApiKey;
    }

    public ProjectUpdateRequest setProjectApiKey(String projectApiKey) {
        this.projectApiKey = projectApiKey;
        return this;
    }

    public ProjectUpdateObject getProject() {
        return project;
    }

    public ProjectUpdateRequest setProject(ProjectUpdateObject project) {
        this.project = project;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ProjectUpdateRequest fromMap(Map<String, Object> data) {
        ProjectUpdateRequest result = new ProjectUpdateRequest();
        result.projectId = Json.asString(data.get("project_id"));
        result.projectApiKey = Json.asString(data.get("project_api_key"));
        result.project = Json.asObject(data.get("project"), ProjectUpdateObject::fromMap);
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "project_id", projectId);
        Json.put(result, "project_api_key", projectApiKey);
        Json.put(result, "project", project == null ? null : project.toMap());
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
