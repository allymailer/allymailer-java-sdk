package ua.com.allymailer.api.template.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** Об'єкт з усіма властивостями шаблону. */
public class TemplateSetRequest {
    /** Об'єкт, що містить властивості шаблону. */
    private TemplateObject template;

    public TemplateObject getTemplate() {
        return template;
    }

    public TemplateSetRequest setTemplate(TemplateObject template) {
        this.template = template;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static TemplateSetRequest fromMap(Map<String, Object> data) {
        TemplateSetRequest result = new TemplateSetRequest();
        result.template = Json.asObject(data.get("template"), TemplateObject::fromMap);
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "template", template == null ? null : template.toMap());
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
