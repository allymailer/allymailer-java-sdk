package ua.com.allymailer.api.tag.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** TagDeleteRequest */
public class TagDeleteRequest {
    /** Унікальний id мітки. */
    private Integer tagId;

    public Integer getTagId() {
        return tagId;
    }

    public TagDeleteRequest setTagId(Integer tagId) {
        this.tagId = tagId;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static TagDeleteRequest fromMap(Map<String, Object> data) {
        TagDeleteRequest result = new TagDeleteRequest();
        result.tagId = Json.asInteger(data.get("tag_id"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "tag_id", tagId);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
