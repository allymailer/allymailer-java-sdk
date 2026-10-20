package ua.com.allymailer.api.tag.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** TagListResponse */
public class TagListResponse {
    /**
     * Рядок "success".
     * Допустимі значення: `success`.
     */
    private String status;

    /** Масив об'єктів з даними користувацьких міток. */
    private List<TagsResponseObject> tags;

    public String getStatus() {
        return status;
    }

    public TagListResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<TagsResponseObject> getTags() {
        return tags;
    }

    public TagListResponse setTags(List<TagsResponseObject> tags) {
        this.tags = tags;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static TagListResponse fromMap(Map<String, Object> data) {
        TagListResponse result = new TagListResponse();
        result.status = Json.asString(data.get("status"));
        result.tags = Json.asList(data.get("tags"), v0 -> Json.asObject(v0, TagsResponseObject::fromMap));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "status", status);
        Json.put(result, "tags", Json.mapList(tags, v0 -> v0.toMap()));
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
