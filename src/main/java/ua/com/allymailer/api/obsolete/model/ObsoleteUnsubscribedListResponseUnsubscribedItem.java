package ua.com.allymailer.api.obsolete.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** ObsoleteUnsubscribedListResponseUnsubscribedItem */
public class ObsoleteUnsubscribedListResponseUnsubscribedItem {
    /** Відписаний email. */
    private String address;

    /** Дата й час відписки адреси у форматі РРРР-ММ-ДД гг:хх:сс у часовому поясі UTC. */
    private String unsubscribedOn;

    public String getAddress() {
        return address;
    }

    public ObsoleteUnsubscribedListResponseUnsubscribedItem setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getUnsubscribedOn() {
        return unsubscribedOn;
    }

    public ObsoleteUnsubscribedListResponseUnsubscribedItem setUnsubscribedOn(String unsubscribedOn) {
        this.unsubscribedOn = unsubscribedOn;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ObsoleteUnsubscribedListResponseUnsubscribedItem fromMap(Map<String, Object> data) {
        ObsoleteUnsubscribedListResponseUnsubscribedItem result = new ObsoleteUnsubscribedListResponseUnsubscribedItem();
        result.address = Json.asString(data.get("address"));
        result.unsubscribedOn = Json.asString(data.get("unsubscribed_on"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "address", address);
        Json.put(result, "unsubscribed_on", unsubscribedOn);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
