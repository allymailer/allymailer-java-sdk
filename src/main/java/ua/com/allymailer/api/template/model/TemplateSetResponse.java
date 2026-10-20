package ua.com.allymailer.api.template.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** TemplateSetResponse */
public class TemplateSetResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /** Об'єкт, що містить властивості шаблону. */
    private TemplateObject template;

    public String getStatus() {
        return status;
    }

    public TemplateSetResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public TemplateObject getTemplate() {
        return template;
    }

    public TemplateSetResponse setTemplate(TemplateObject template) {
        this.template = template;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static TemplateSetResponse fromMap(Map<String, Object> data) {
        TemplateSetResponse result = new TemplateSetResponse();
        result.status = Json.asString(data.get("status"));
        result.template = Json.asObject(data.get("template"), TemplateObject::fromMap);
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "template", template == null ? null : template.toMap());
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
