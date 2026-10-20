package ua.com.allymailer.api.webhook.model;

/**
 * Якість трафіку для статусів "opened" і "clicked". "human" — розпізнано звичайний браузер або
 * поштовий клієнт без машинних ознак; "machine" — бот, сканер посилань або проксі безпеки; "protected"
 * — механізм приватності скриньки/ОС, участь людини підтвердити не можна (Apple Mail Privacy
 * Protection / iCloud Private Relay, Gmail Image Proxy; Apple MPP — це protected, не machine);
 * "unknown" — User-Agent відсутній, пошкоджений або не розпізнаний.
 */
public enum TrafficType {
    HUMAN("human"),
    MACHINE("machine"),
    PROTECTED("protected"),
    UNKNOWN("unknown"),
    /**
     * A value this version of the SDK does not know (added to the API later): the model keeps the raw
     * value, see its get...Value() accessor.
     */
    UNKNOWN_VALUE(null);

    private final String value;

    TrafficType(String value) {
        this.value = value;
    }

    /** Value sent to and received from the API, null for UNKNOWN_VALUE. */
    public String getValue() {
        return value;
    }

    /** Enum constant for a decoded JSON value: null for null, UNKNOWN_VALUE for a value unknown to the SDK. */
    public static TrafficType fromValue(Object value) {
        if (value == null) {
            return null;
        }
        for (TrafficType item : values()) {
            if (item.value != null && String.valueOf(item.value).equals(String.valueOf(value))) {
                return item;
            }
        }
        return UNKNOWN_VALUE;
    }

    /**
     * Value of a constant for the API, null for null.
     * @param item enum constant
     * @return value sent to the API
     * @throws IllegalArgumentException for UNKNOWN_VALUE: set the raw value instead
     */
    public static String toValue(TrafficType item) {
        if (item == UNKNOWN_VALUE) {
            throw new IllegalArgumentException("TrafficType.UNKNOWN_VALUE has no API value: "
                + "set the raw value with the set...Value() setter of the model");
        }
        return item == null ? null : item.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
