package ua.com.allymailer.common.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** AttachmentsArrayItem */
public class AttachmentsArrayItem {
    /**
     * Тип вкладення, див. [MIME](https://en.wikipedia.org/wiki/MIME). Якщо не впевнені, використовуйте
     * "application/octet-stream".
     */
    private String type;

    /**
     * Назва вкладення у форматі: "ім'я.розширення". У разі передачі кількох вкладень їхні назви мають бути
     * унікальними. У назві вкладень заборонено символ ‘/’.
     */
    private String name;

    /**
     * Вміст файлу у [base64](https://en.wikipedia.org/wiki/Base64). Максимальний розмір файлу 7 Мб
     * (9786710 байт у base64).
     */
    private String content;

    public String getType() {
        return type;
    }

    public AttachmentsArrayItem setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public AttachmentsArrayItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getContent() {
        return content;
    }

    public AttachmentsArrayItem setContent(String content) {
        this.content = content;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static AttachmentsArrayItem fromMap(Map<String, Object> data) {
        AttachmentsArrayItem result = new AttachmentsArrayItem();
        result.type = Json.asString(data.get("type"));
        result.name = Json.asString(data.get("name"));
        result.content = Json.asString(data.get("content"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "type", type);
        Json.put(result, "name", name);
        Json.put(result, "content", content);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
