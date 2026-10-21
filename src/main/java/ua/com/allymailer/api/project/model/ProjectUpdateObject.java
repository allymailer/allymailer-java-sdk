package ua.com.allymailer.api.project.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;
import ua.com.allymailer.common.model.EmailCounterMode;

/** Об'єкт із властивостями проєкту. */
public class ProjectUpdateObject {
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

    /**
     * Значення лічильника листів для проєкту, збільшується під час надсилання кожного листа. Приймає лише
     * значення 0 (тобто скидання лічильника в нуль) або оновлюється автоматично, залежно від режиму роботи
     * лічильника, заданого параметром 'email_counter_mode'. Якщо поле не передано в запиті або передано
     * null, то значення лічильника не змінюється.
     */
    private Long emailCounter;

    /**
     * Дозволяє обмежити кількість надісланих проєктом листів. У разі досягнення цього ліміту надсилання
     * припиняється. Приймається будь-яке невід'ємне 64-бітне ціле число. Значення 0 означає відсутність
     * ліміту. Якщо поле не передано в запиті або передано null, то значення ліміту не змінюється.
     * За замовчуванням: `0`.
     */
    private Long emailCounterLimit;

    /**
     * Встановлює режим роботи лічильника листів. Дозволяє вибрати, як має поводитися лічильник:
     * автоматично скидатися чи залишатися постійним. Припустимі значення: default - лічильник автоматично
     * скидається в нуль на початку кожного облікового періоду, permanent - лічильник ніколи не скидається
     * автоматично. Скидання може бути виконане лише вручну користувачем, передавши значення 0 у полі
     * 'email_counter'. Якщо поле не передано в запиті або передано значення null, значення режиму не
     * змінюється.
     * За замовчуванням: `default`.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String emailCounterMode;

    public String getName() {
        return name;
    }

    public ProjectUpdateObject setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ProjectUpdateObject setCountry(String country) {
        this.country = country;
        return this;
    }

    public Boolean getSendEnabled() {
        return sendEnabled;
    }

    public ProjectUpdateObject setSendEnabled(Boolean sendEnabled) {
        this.sendEnabled = sendEnabled;
        return this;
    }

    public Boolean getCustomUnsubscribeUrlEnabled() {
        return customUnsubscribeUrlEnabled;
    }

    public ProjectUpdateObject setCustomUnsubscribeUrlEnabled(Boolean customUnsubscribeUrlEnabled) {
        this.customUnsubscribeUrlEnabled = customUnsubscribeUrlEnabled;
        return this;
    }

    public Integer getBackendDomainId() {
        return backendDomainId;
    }

    public ProjectUpdateObject setBackendDomainId(Integer backendDomainId) {
        this.backendDomainId = backendDomainId;
        return this;
    }

    public Integer getUnsubscribePageId() {
        return unsubscribePageId;
    }

    public ProjectUpdateObject setUnsubscribePageId(Integer unsubscribePageId) {
        this.unsubscribePageId = unsubscribePageId;
        return this;
    }

    public Long getEmailCounter() {
        return emailCounter;
    }

    public ProjectUpdateObject setEmailCounter(Long emailCounter) {
        this.emailCounter = emailCounter;
        return this;
    }

    public Long getEmailCounterLimit() {
        return emailCounterLimit;
    }

    public ProjectUpdateObject setEmailCounterLimit(Long emailCounterLimit) {
        this.emailCounterLimit = emailCounterLimit;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getEmailCounterModeValue()), null when absent.
     */
    public EmailCounterMode getEmailCounterMode() {
        return EmailCounterMode.fromValue(emailCounterMode);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setEmailCounterModeValue()).
     */
    public ProjectUpdateObject setEmailCounterMode(EmailCounterMode emailCounterMode) {
        this.emailCounterMode = EmailCounterMode.toValue(emailCounterMode);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getEmailCounterModeValue() {
        return emailCounterMode;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public ProjectUpdateObject setEmailCounterModeValue(String emailCounterMode) {
        this.emailCounterMode = emailCounterMode;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ProjectUpdateObject fromMap(Map<String, Object> data) {
        ProjectUpdateObject result = new ProjectUpdateObject();
        result.name = Json.asString(data.get("name"));
        result.country = Json.asString(data.get("country"));
        result.sendEnabled = Json.asBoolean(data.get("send_enabled"));
        result.customUnsubscribeUrlEnabled = Json.asBoolean(data.get("custom_unsubscribe_url_enabled"));
        result.backendDomainId = Json.asInteger(data.get("backend_domain_id"));
        result.unsubscribePageId = Json.asInteger(data.get("unsubscribe_page_id"));
        result.emailCounter = Json.asLong(data.get("email_counter"));
        result.emailCounterLimit = Json.asLong(data.get("email_counter_limit"));
        result.emailCounterMode = Json.asString(data.get("email_counter_mode"));
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
        Json.put(result, "email_counter", emailCounter);
        Json.put(result, "email_counter_limit", emailCounterLimit);
        Json.put(result, "email_counter_mode", emailCounterMode);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
