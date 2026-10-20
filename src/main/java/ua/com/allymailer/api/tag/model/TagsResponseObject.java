package ua.com.allymailer.api.tag.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** Об'єкт із властивостями користувацьких міток. */
public class TagsResponseObject {
    /** Унікальний id мітки. */
    private Integer tagId;

    /** Назва мітки. */
    private String tag;

    public Integer getTagId() {
        return tagId;
    }

    public TagsResponseObject setTagId(Integer tagId) {
        this.tagId = tagId;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public TagsResponseObject setTag(String tag) {
        this.tag = tag;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static TagsResponseObject fromMap(Map<String, Object> data) {
        TagsResponseObject result = new TagsResponseObject();
        result.tagId = Json.asInteger(data.get("tag_id"));
        result.tag = Json.asString(data.get("tag"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "tag_id", tagId);
        Json.put(result, "tag", tag);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
