package ua.com.allymailer.api.project.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;
import ua.com.allymailer.common.model.EmailCounterMode;

/** ProjectListObject */
public class ProjectListObject {
    /** Унікальний ідентифікатор проєкту, ASCII-рядок до 36 символів завдовжки. */
    private String id;

    /**
     * API-ключ проєкту. Ви можете використовувати цей ключ замість користувацького api_key у всіх методах,
     * крім project-методів.
     */
    private String apiKey;

    /** Назва проєкту, унікальна в межах облікового запису користувача. */
    private String name;

    /**
     * Двобуквений код країни за правилами ISO-3166 alpha-2. Якщо задано, то AllyMailer обробляє
     * персональні дані проєкту відповідно до законів заданої країни — наприклад, відповідно до GDPR для
     * європейських країн.
     */
    private String country;

    /** Дата й час створення проєкту в часовому поясі UTC у форматі "РРРР-ММ-ДД гг:хх:сс". */
    private String regTime;

    /**
     * Чи дозволено надсилання листів для проєкту.
     * За замовчуванням: `True`.
     */
    private Boolean sendEnabled;

    /**
     * Якщо false, то AllyMailer додає в кінець кожного листа системне посилання відписки. Значення true
     * вимикає автоматичне додавання системою посилання відписки в кінець листа й дозволяє використовувати
     * власне посилання відписки або надсилати листи зовсім без посилання відписки. Докладніше див.
     * [тут](https://docs.allymailer.com.ua/en/unsubscribe-link). Якщо ви не вказуєте значення
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

    /** Значення лічильника листів для проєкту, збільшується під час надсилання кожного листа. */
    private Long emailCounter;

    /**
     * Дозволяє обмежити кількість надісланих проєктом листів. У разі досягнення цього ліміту надсилання
     * припиняється. Значення 0 (за замовчуванням) означає відсутність ліміту.
     */
    private Long emailCounterLimit;

    /**
     * 'default' - лічильник автоматично скидається в нуль на початку кожного облікового періоду,
     * 'permanent' - лічильник ніколи не скидається автоматично.
     * За замовчуванням: `default`.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String emailCounterMode;

    /**
     * Унікальний ідентифікатор, який визначає сторінку відписки за замовчуванням. Якщо відсутній —
     * обліковому запису/проєкту буде призначено системну сторінку відписки за замовчуванням.
     */
    private Integer unsubscribePageId;

    public String getId() {
        return id;
    }

    public ProjectListObject setId(String id) {
        this.id = id;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public ProjectListObject setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProjectListObject setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ProjectListObject setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getRegTime() {
        return regTime;
    }

    public ProjectListObject setRegTime(String regTime) {
        this.regTime = regTime;
        return this;
    }

    public Boolean getSendEnabled() {
        return sendEnabled;
    }

    public ProjectListObject setSendEnabled(Boolean sendEnabled) {
        this.sendEnabled = sendEnabled;
        return this;
    }

    public Boolean getCustomUnsubscribeUrlEnabled() {
        return customUnsubscribeUrlEnabled;
    }

    public ProjectListObject setCustomUnsubscribeUrlEnabled(Boolean customUnsubscribeUrlEnabled) {
        this.customUnsubscribeUrlEnabled = customUnsubscribeUrlEnabled;
        return this;
    }

    public Integer getBackendDomainId() {
        return backendDomainId;
    }

    public ProjectListObject setBackendDomainId(Integer backendDomainId) {
        this.backendDomainId = backendDomainId;
        return this;
    }

    public Long getEmailCounter() {
        return emailCounter;
    }

    public ProjectListObject setEmailCounter(Long emailCounter) {
        this.emailCounter = emailCounter;
        return this;
    }

    public Long getEmailCounterLimit() {
        return emailCounterLimit;
    }

    public ProjectListObject setEmailCounterLimit(Long emailCounterLimit) {
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
    public ProjectListObject setEmailCounterMode(EmailCounterMode emailCounterMode) {
        this.emailCounterMode = EmailCounterMode.toValue(emailCounterMode);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getEmailCounterModeValue() {
        return emailCounterMode;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public ProjectListObject setEmailCounterModeValue(String emailCounterMode) {
        this.emailCounterMode = emailCounterMode;
        return this;
    }

    public Integer getUnsubscribePageId() {
        return unsubscribePageId;
    }

    public ProjectListObject setUnsubscribePageId(Integer unsubscribePageId) {
        this.unsubscribePageId = unsubscribePageId;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static ProjectListObject fromMap(Map<String, Object> data) {
        ProjectListObject result = new ProjectListObject();
        result.id = Json.asString(data.get("id"));
        result.apiKey = Json.asString(data.get("api_key"));
        result.name = Json.asString(data.get("name"));
        result.country = Json.asString(data.get("country"));
        result.regTime = Json.asString(data.get("reg_time"));
        result.sendEnabled = Json.asBoolean(data.get("send_enabled"));
        result.customUnsubscribeUrlEnabled = Json.asBoolean(data.get("custom_unsubscribe_url_enabled"));
        result.backendDomainId = Json.asInteger(data.get("backend_domain_id"));
        result.emailCounter = Json.asLong(data.get("email_counter"));
        result.emailCounterLimit = Json.asLong(data.get("email_counter_limit"));
        result.emailCounterMode = Json.asString(data.get("email_counter_mode"));
        result.unsubscribePageId = Json.asInteger(data.get("unsubscribe_page_id"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "id", id);
        Json.put(result, "api_key", apiKey);
        Json.put(result, "name", name);
        Json.put(result, "country", country);
        Json.put(result, "reg_time", regTime);
        Json.put(result, "send_enabled", sendEnabled);
        Json.put(result, "custom_unsubscribe_url_enabled", customUnsubscribeUrlEnabled);
        Json.put(result, "backend_domain_id", backendDomainId);
        Json.put(result, "email_counter", emailCounter);
        Json.put(result, "email_counter_limit", emailCounterLimit);
        Json.put(result, "email_counter_mode", emailCounterMode);
        Json.put(result, "unsubscribe_page_id", unsubscribePageId);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
