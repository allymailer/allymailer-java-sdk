package ua.com.allymailer.api.suppression.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** SuppressionGetRequest */
public class SuppressionGetRequest {
    /** Email-адреса, для якої потрібно отримати дані про недоступність. */
    private String email;

    /**
     * Якщо у користувача увімкнено проєкти, all_projects=true дозволить шукати за даними всіх проєктів.
     * За замовчуванням: `False`.
     */
    private Boolean allProjects;

    public String getEmail() {
        return email;
    }

    public SuppressionGetRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean getAllProjects() {
        return allProjects;
    }

    public SuppressionGetRequest setAllProjects(Boolean allProjects) {
        this.allProjects = allProjects;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static SuppressionGetRequest fromMap(Map<String, Object> data) {
        SuppressionGetRequest result = new SuppressionGetRequest();
        result.email = Json.asString(data.get("email"));
        result.allProjects = Json.asBoolean(data.get("all_projects"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "email", email);
        Json.put(result, "all_projects", allProjects);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
