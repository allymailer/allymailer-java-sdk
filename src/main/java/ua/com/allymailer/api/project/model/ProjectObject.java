package ua.com.allymailer.api.project.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;

/** Об'єкт із властивостями проєкту. */
public class ProjectObject {
    /** Назва проєкту, унікальна в межах облікового запису користувача. */
    private String name;

    /**
     * Двобуквений код країни за правилами ISO-3166 alpha-2. Якщо задано, то AllyMailer обробляє
     * персональні дані проєкту відповідно до законів заданої країни — наприклад, відповідно до GDPR для
     * європейських країн.
     */
    private String country;

    /**
     * Чи дозволено надсилання листів для проєкту.
     * За замовчуванням: `True`.
     */
    private Boolean sendEnabled;

    /**
     * Якщо false, то AllyMailer додає в кінець кожного листа системне посилання відписки. Значення true
     * вимикає автоматичне додавання системою посилання відписки в кінець листа й дозволяє використовувати
     * власне посилання відписки або надсилати листи зовсім без посилання відписки. Докладніше див.
     * [тут](https://docs.allymailer.com.ua/ua/unsubscribe-link). Якщо ви не вказуєте значення
     * custom_unsubscribe_url_enabled під час створення проєкту — то це значення копіюється з головного
     * облікового запису (якщо в головному обліковому записі було встановлено примусове вимкнення посилання
     * відписки — то й у проєкту посилання відписки буде вимкнено).
     */
    private Boolean customUnsubscribeUrlEnabled;

    /**
     * Унікальний ідентифікатор backend-домену, який визначає [домен посилань](/tracking-domains) або пул
     * [виділених IP-адрес](/dedicated-ip) за замовчуванням. Якщо відсутній — обліковому запису/проєкту
     * буде призначено дефолтний backend-домен за замовчуванням.
     */
    private Integer backendDomainId;

    /**
     * Унікальний ідентифікатор, який визначає сторінку відписки за замовчуванням. Якщо відсутній —
     * обліковому запису/проєкту буде призначено системну сторінку відписки за замовчуванням.
     */
    private Integer unsubscribePageId;

    public String getName() {
        return name;
    }

    public ProjectObject setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ProjectObject setCountry(String country) {
        this.country = country;
        return this;
    }

    public Boolean getSendEnabled() {
        return sendEnabled;
    }

    public ProjectObject setSendEnabled(Boolean sendEnabled) {
        this.sendEnabled = sendEnabled;
        return this;
    }

    public Boolean getCustomUnsubscribeUrlEnabled() {
        return customUnsubscribeUrlEnabled;
    }

    public ProjectObject setCustomUnsubscribeUrlEnabled(Boolean customUnsubscribeUrlEnabled) {
        this.customUnsubscribeUrlEnabled = customUnsubscribeUrlEnabled;
        return this;
    }

    public Integer getBackendDomainId() {
        return backendDomainId;
    }

    public ProjectObject setBackendDomainId(Integer backendDomainId) {
        this.backendDomainId = backendDomainId;
        return this;
    }

    public Integer getUnsubscribePageId() {
        return unsubscribePageId;
    }

    public ProjectObject setUnsubscribePageId(Integer unsubscribePageId) {
        this.unsubscribePageId = unsubscribePageId;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ProjectObject fromMap(Map<String, Object> data) {
        ProjectObject result = new ProjectObject();
        result.name = Json.asString(data.get("name"));
        result.country = Json.asString(data.get("country"));
        result.sendEnabled = Json.asBoolean(data.get("send_enabled"));
        result.customUnsubscribeUrlEnabled = Json.asBoolean(data.get("custom_unsubscribe_url_enabled"));
        result.backendDomainId = Json.asInteger(data.get("backend_domain_id"));
        result.unsubscribePageId = Json.asInteger(data.get("unsubscribe_page_id"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "name", name);
        Json.put(result, "country", country);
        Json.put(result, "send_enabled", sendEnabled);
        Json.put(result, "custom_unsubscribe_url_enabled", customUnsubscribeUrlEnabled);
        Json.put(result, "backend_domain_id", backendDomainId);
        Json.put(result, "unsubscribe_page_id", unsubscribePageId);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
