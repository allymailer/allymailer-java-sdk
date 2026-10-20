package ua.com.allymailer.api.system.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** SystemInfoResponse */
public class SystemInfoResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /** Унікальний ідентифікатор користувача. */
    private Integer userId;

    /** Email користувача. */
    private String email;

    /**
     * Унікальний ідентифікатор проєкту, ASCII-рядок до 36 символів завдовжки. Присутній лише якщо
     * API-ключ, використаний для запиту, був API-ключем проєкту.
     */
    private String projectId;

    /**
     * Назва проєкту, унікальна в межах облікового запису користувача. Присутня лише якщо API-ключ,
     * використаний для запиту, був API-ключем проєкту.
     */
    private String projectName;

    /**
     * Об'єкт із властивостями лічильника листів. Присутній лише якщо API-ключ, використаний для запиту,
     * був API-ключем проєкту.
     */
    private ProjectAccountingObject projectAccounting;

    /**
     * Об'єкт з властивостями періоду обліку. Присутній лише якщо API-ключ, використаний для запиту, був
     * API-ключем користувача.
     */
    private SystemInfoResponseAccounting accounting;

    public String getStatus() {
        return status;
    }

    public SystemInfoResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public SystemInfoResponse setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SystemInfoResponse setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public SystemInfoResponse setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public SystemInfoResponse setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public ProjectAccountingObject getProjectAccounting() {
        return projectAccounting;
    }

    public SystemInfoResponse setProjectAccounting(ProjectAccountingObject projectAccounting) {
        this.projectAccounting = projectAccounting;
        return this;
    }

    public SystemInfoResponseAccounting getAccounting() {
        return accounting;
    }

    public SystemInfoResponse setAccounting(SystemInfoResponseAccounting accounting) {
        this.accounting = accounting;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static SystemInfoResponse fromMap(Map<String, Object> data) {
        SystemInfoResponse result = new SystemInfoResponse();
        result.status = Json.asString(data.get("status"));
        result.userId = Json.asInteger(data.get("user_id"));
        result.email = Json.asString(data.get("email"));
        result.projectId = Json.asString(data.get("project_id"));
        result.projectName = Json.asString(data.get("project_name"));
        result.projectAccounting = Json.asObject(data.get("project_accounting"), ProjectAccountingObject::fromMap);
        result.accounting = Json.asObject(data.get("accounting"), SystemInfoResponseAccounting::fromMap);
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "user_id", userId);
        Json.put(result, "email", email);
        Json.put(result, "project_id", projectId);
        Json.put(result, "project_name", projectName);
        Json.put(result, "project_accounting", projectAccounting == null ? null : projectAccounting.toMap());
        Json.put(result, "accounting", accounting == null ? null : accounting.toMap());
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
