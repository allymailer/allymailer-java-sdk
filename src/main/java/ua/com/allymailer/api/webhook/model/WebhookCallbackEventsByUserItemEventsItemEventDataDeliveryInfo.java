package ua.com.allymailer.api.webhook.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/**
 * Об'єкт з додатковою інформацією про доставку. Присутній лише якщо властивість delivery_info під час
 * встановлення webhook дорівнювала 1 і якщо event_name="transactional_email_status".
 */
public class WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo {
    /**
     * Внутрішній детальний статус доставки AllyMailer. Ось деякі з можливих статусів:
     * <p>
     * __err_user_unknown__ -- адреса не існує (і невідомо, чи існувала колись);
     * <p>
     * __err_user_inactive__ -- адреса не використовується;
     * <p>
     * __err_will_retry__ -- лист було тимчасово відхилено, пізніше буде здійснено повторну спробу
     * доставки;
     * <p>
     * __err_mailbox_discarded__ -- адресу видалено (тобто колись існувала, але тепер її немає);
     * <p>
     * __err_mailbox_full__ -- поштова скринька переповнена;
     * <p>
     * __err_spam_rejected__ -- лист відхилено як спам;
     * <p>
     * __err_blacklisted__ -- лист було відхилено через наявність IP-адреси або домену відправника в
     * якомусь із чорних списків;
     * <p>
     * __err_too_large__ -- на думку сервера отримувача, лист перевищує допустимий розмір;
     * <p>
     * __err_unsubscribed__ -- адресат раніше відписався від ваших розсилок;
     * <p>
     * __err_unreachable__ -- адресу позначено як постійно недоступну через багаторазові помилки доставки
     * на цю адресу;
     * <p>
     * __err_skip_letter__ -- надсилання скасовано, оскільки email-адреса тимчасово недоступна;
     * <p>
     * __err_domain_inactive__ -- домен не приймає пошту або не існує;
     * <p>
     * __err_destination_misconfigured__ -- домен не приймає пошту через неправильне налаштування на боці
     * отримувача, причому відповідь сервера містить інформацію про усувну причину (наприклад,
     * використовується непрацюючий блеклист тощо);
     * <p>
     * __err_delivery_failed__ -- доставка не вдалася з інших причин;
     * <p>
     * __err_spam_skipped__ -- надсилання скасовано через блокування розсилки як спаму;
     * <p>
     * __err_lost__ -- лист не було надіслано через неузгодженість його частин, або його було втрачено
     * через збій на нашому боці. Відправник має повторно надіслати лист самостійно, оскільки оригінал не
     * зберігся;
     * <p>
     * Ми залишаємо за собою право змінювати й додавати внутрішні статуси, тому решту
     * використовуваних наразі статусів перелічимо лише довідково, без пояснень:
     * ok_accepted, ok_sent, ok_delivered, ok_read, ok_link_visited, ok_unsubscribed, ok_resubscribed,
     * ok_spam_folder, ok_fbl,
     * not_sent, skip_dup_unreachable, skip_dup_temp_unreachable, skip_dup_mailbox_full,
     * err_spam_removed, err_resend, err_unknown, err_retry_letter, err_src_invalid,
     * err_dest_invalid, err_not_available, err_internal, err_no_dns, err_no_smtp, err_giveup.
     */
    private String deliveryStatus;

    /** Відповідь SMTP-сервера. */
    private String destinationResponse;

    /**
     * Рядок user agent отримувача. Присутній лише якщо вдалося його визначити, для статусів "clicked" і
     * "opened".
     */
    private String userAgent;

    /**
     * Тип пристрою отримувача, визначений за user agent. Присутній для статусів "clicked" і "opened";
     * дорівнює "unknown", якщо тип пристрою визначити не вдалося.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String deviceType;

    /**
     * Марка пристрою отримувача, визначена за user agent. Присутня для статусів "clicked" і "opened", якщо
     * її вдалося визначити. Для device_type "mobile" і "tablet" присутня завжди та дорівнює "unknown",
     * якщо марку визначити не вдалося.
     */
    private String deviceBrand;

    /**
     * Назва операційної системи пристрою отримувача, визначена за user agent. Присутня для статусів
     * "clicked" і "opened"; дорівнює "unknown", якщо ОС визначити не вдалося.
     */
    private String osName;

    /**
     * Назва браузера, у якому було відкрито лист, визначена за user agent. Присутня для статусів "clicked"
     * і "opened", лише якщо було визначено браузер, тому ніколи не надходить разом з email_client_name.
     */
    private String browserName;

    /**
     * Назва поштового клієнта, у якому було відкрито лист, визначена за user agent. Присутня для статусів
     * "clicked" і "opened", лише якщо було визначено поштовий клієнт, тому ніколи не надходить разом з
     * browser_name.
     */
    private String emailClientName;

    /**
     * Якість трафіку для статусів "opened" і "clicked". "human" — розпізнано звичайний браузер або
     * поштовий клієнт без машинних ознак; "machine" — бот, сканер посилань або проксі безпеки; "protected"
     * — механізм приватності скриньки/ОС, участь людини підтвердити не можна (Apple Mail Privacy
     * Protection / iCloud Private Relay, Gmail Image Proxy; Apple MPP — це protected, не machine);
     * "unknown" — User-Agent відсутній, пошкоджений або не розпізнаний.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String trafficType;

    /** IP-адреса отримувача. Присутня лише якщо вдалося її визначити, для статусів "clicked" і "opened". */
    private String ip;

    /**
     * ISO 3166-1 alpha-2 код країни, визначений за IP-адресою отримувача. Присутній для статусів "clicked"
     * і "opened".
     */
    private String countryCode;

    /** Країна, визначена за IP-адресою отримувача. Присутня для статусів "clicked" і "opened". */
    private String country;

    /** Місто, визначене за IP-адресою отримувача. Присутнє для статусів "clicked" і "opened". */
    private String city;

    /**
     * IP-адреса SMTP-сервера, з якого було надіслано лист. Присутня лише для статусів "delivered",
     * "soft_bounced" і "hard_bounced", якщо доступна.
     */
    private String senderIp;

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
        return this;
    }

    public String getDestinationResponse() {
        return destinationResponse;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setDestinationResponse(String destinationResponse) {
        this.destinationResponse = destinationResponse;
        return this;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getDeviceTypeValue()), null when absent.
     */
    public DeviceType getDeviceType() {
        return DeviceType.fromValue(deviceType);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setDeviceTypeValue()).
     */
    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setDeviceType(DeviceType deviceType) {
        this.deviceType = DeviceType.toValue(deviceType);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getDeviceTypeValue() {
        return deviceType;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setDeviceTypeValue(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
        return this;
    }

    public String getOsName() {
        return osName;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setOsName(String osName) {
        this.osName = osName;
        return this;
    }

    public String getBrowserName() {
        return browserName;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setBrowserName(String browserName) {
        this.browserName = browserName;
        return this;
    }

    public String getEmailClientName() {
        return emailClientName;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setEmailClientName(String emailClientName) {
        this.emailClientName = emailClientName;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getTrafficTypeValue()), null when absent.
     */
    public TrafficType getTrafficType() {
        return TrafficType.fromValue(trafficType);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setTrafficTypeValue()).
     */
    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setTrafficType(TrafficType trafficType) {
        this.trafficType = TrafficType.toValue(trafficType);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getTrafficTypeValue() {
        return trafficType;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setTrafficTypeValue(String trafficType) {
        this.trafficType = trafficType;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setCity(String city) {
        this.city = city;
        return this;
    }

    public String getSenderIp() {
        return senderIp;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo setSenderIp(String senderIp) {
        this.senderIp = senderIp;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo fromMap(Map<String, Object> data) {
        WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo result = new WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo();
        result.deliveryStatus = Json.asString(data.get("delivery_status"));
        result.destinationResponse = Json.asString(data.get("destination_response"));
        result.userAgent = Json.asString(data.get("user_agent"));
        result.deviceType = Json.asString(data.get("device_type"));
        result.deviceBrand = Json.asString(data.get("device_brand"));
        result.osName = Json.asString(data.get("os_name"));
        result.browserName = Json.asString(data.get("browser_name"));
        result.emailClientName = Json.asString(data.get("email_client_name"));
        result.trafficType = Json.asString(data.get("traffic_type"));
        result.ip = Json.asString(data.get("ip"));
        result.countryCode = Json.asString(data.get("country_code"));
        result.country = Json.asString(data.get("country"));
        result.city = Json.asString(data.get("city"));
        result.senderIp = Json.asString(data.get("sender_ip"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "delivery_status", deliveryStatus);
        Json.put(result, "destination_response", destinationResponse);
        Json.put(result, "user_agent", userAgent);
        Json.put(result, "device_type", deviceType);
        Json.put(result, "device_brand", deviceBrand);
        Json.put(result, "os_name", osName);
        Json.put(result, "browser_name", browserName);
        Json.put(result, "email_client_name", emailClientName);
        Json.put(result, "traffic_type", trafficType);
        Json.put(result, "ip", ip);
        Json.put(result, "country_code", countryCode);
        Json.put(result, "country", country);
        Json.put(result, "city", city);
        Json.put(result, "sender_ip", senderIp);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
