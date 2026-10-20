package ua.com.allymailer.common.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** InlineAttachmentsArrayItem */
public class InlineAttachmentsArrayItem {
    /**
     * Тип вкладення, див. [MIME](https://en.wikipedia.org/wiki/MIME). Якщо не впевнені, використовуйте
     * "application/octet-stream".
     */
    private String type;

    /**
     * Ідентифікатор вкладення. Якщо, наприклад, "name"="IMAGECID", то для виведення картинки з цього
     * вкладення в HTML-тексті листа потрібно вказати &lt;img src="cid:IMAGECID"&gt;.
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

    public InlineAttachmentsArrayItem setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public InlineAttachmentsArrayItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getContent() {
        return content;
    }

    public InlineAttachmentsArrayItem setContent(String content) {
        this.content = content;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static InlineAttachmentsArrayItem fromMap(Map<String, Object> data) {
        InlineAttachmentsArrayItem result = new InlineAttachmentsArrayItem();
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
