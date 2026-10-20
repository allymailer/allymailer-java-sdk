package ua.com.allymailer.common.model;

/**
 * Встановлює режим роботи лічильника листів. Дозволяє вибрати, як має поводитися лічильник:
 * автоматично скидатися чи залишатися постійним. Припустимі значення: default - лічильник автоматично
 * скидається в нуль на початку кожного облікового періоду, permanent - лічильник ніколи не скидається
 * автоматично. Скидання може бути виконане лише вручну користувачем, передавши значення 0 у полі
 * 'email_counter'. Якщо поле не передано в запиті або передано значення null, значення режиму не
 * змінюється.
 */
public enum EmailCounterMode {
    DEFAULT("default"),
    PERMANENT("permanent"),
    /**
     * A value this version of the SDK does not know (added to the API later): the model keeps the raw
     * value, see its get...Value() accessor.
     */
    UNKNOWN_VALUE(null);

    private final String value;

    EmailCounterMode(String value) {
        this.value = value;
    }

    /** Value sent to and received from the API, null for UNKNOWN_VALUE. */
    public String getValue() {
        return value;
    }

    /** Enum constant for a decoded JSON value: null for null, UNKNOWN_VALUE for a value unknown to the SDK. */
    public static EmailCounterMode fromValue(Object value) {
        if (value == null) {
            return null;
        }
        for (EmailCounterMode item : values()) {
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
    public static String toValue(EmailCounterMode item) {
        if (item == UNKNOWN_VALUE) {
            throw new IllegalArgumentException("EmailCounterMode.UNKNOWN_VALUE has no API value: "
                + "set the raw value with the set...Value() setter of the model");
        }
        return item == null ? null : item.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
