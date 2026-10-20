package ua.com.allymailer.api.project.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** ProjectCreateRequest */
public class ProjectCreateRequest {
    /** Об'єкт із властивостями проєкту. */
    private ProjectObject project;

    public ProjectObject getProject() {
        return project;
    }

    public ProjectCreateRequest setProject(ProjectObject project) {
        this.project = project;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ProjectCreateRequest fromMap(Map<String, Object> data) {
        ProjectCreateRequest result = new ProjectCreateRequest();
        result.project = Json.asObject(data.get("project"), ProjectObject::fromMap);
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "project", project == null ? null : project.toMap());
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
