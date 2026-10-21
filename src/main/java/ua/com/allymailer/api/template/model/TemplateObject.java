package ua.com.allymailer.api.template.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ua.com.allymailer.client.Json;
import ua.com.allymailer.common.model.AttachmentsArrayItem;
import ua.com.allymailer.common.model.BodyObject;
import ua.com.allymailer.common.model.HeadersObject;
import ua.com.allymailer.common.model.InlineAttachmentsArrayItem;
import ua.com.allymailer.common.model.TemplateEngine;

/** Об'єкт, що містить властивості шаблону. */
public class TemplateObject {
    /**
     * Унікальний ідентифікатор шаблону. Якщо вказано, система спробує знайти шаблон із указаним id і
     * відредагувати його. Якщо не задано, буде створено новий шаблон.
     */
    private String id;

    /** Назва шаблону. */
    private String name;

    /**
     * Тип редактора шаблону у вебінтерфейсі, "html" або "visual". За замовчуванням — "html". Створення
     * шаблонів із типом редактора "visual" можливе лише через вебінтерфейс.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String editorType;

    /**
     * Параметр для вибору [шаблонізатора](https://docs.allymailer.com.ua/ua/template-engines) — або
     * "simple", або "velocity", або "liquid", або "none". За замовчуванням — "simple".
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String templateEngine;

    /**
     * Об'єкт для передачі глобальних підстановок (наприклад, назва компанії). Якщо назви змінних
     * повторюються в об'єкті користувацьких підстановок "substitutions", значення змінних будуть взяті з
     * об'єкта "substitutions". Підстановки працюють у параметрах:
     * <p>
     * - body.html
     * - body.plaintext
     * - body.amp
     * - subject
     * - from_name
     * - options.unsubscribe_url
     * Назви змінних можуть містити літери латинського алфавіту, цифри, символ "_". Першим символом може
     * бути лише літера, використання пробілів не допускається.
     */
    private Map<String, String> globalSubstitutions;

    /**
     * Об'єкт для передачі метаданих, спільних для всіх отримувачів, у форматі: "key": "value". Максимальна
     * кількість ключів: 10; максимальна довжина ключа: 64 символи; максимальна довжина значення ключа:
     * 1024 символи. Метадані передаються під час виклику
     * [webhook](https://docs.allymailer.com.ua/ua/web-api-ref#webhook). Для групування листів в одну
     * розсилку може використовуватися системний ключ "campaign_id" зі значенням у вигляді невід'ємного
     * десяткового цілого до 128 біт або UUID вигляду "c7703772-453e-4c77-a9ae-9a1b94051b5a". Неправильні
     * значення будуть прирівняні до '0'
     */
    private Map<String, String> globalMetadata;

    /**
     * Об'єкт, що містить у собі html-, plaintext- і amp-частини листа. Або html-, або plaintext-частина
     * має бути присутня обов'язково.
     */
    private BodyObject body;

    /** Тема листа. */
    private String subject;

    /** Email-адреса відправника. */
    private String fromEmail;

    /** Ім'я відправника. */
    private String fromName;

    /** Необов'язкова email-адреса для відповідей (на випадок, якщо відрізняється від адреси відправника) */
    private String replyTo;

    /**
     * Необов'язкове ім'я для відповідей (якщо вказано email reply_to і ви хочете, щоб відображався не лише
     * цей email, але й ім'я)
     */
    private String replyToName;

    /**
     * 1 = відстеження переходів за посиланнями увімкнено (значення за замовчуванням), 0=вимкнено. Для
     * використання track_links = 0 вам потрібно [попросити
     * техпідтримку](https://cp.allymailer.com/ua/support) увімкнути таку можливість.
     * Допустимі значення: `0`, `1`.
     */
    private Integer trackLinks;

    /**
     * 1 = відстеження прочитань листа увімкнено (значення за замовчуванням), 0 = вимкнено. Для
     * використання track_read = 0 вам потрібно [попросити
     * техпідтримку](https://cp.allymailer.com/ua/support) увімкнути таку можливість.
     * Допустимі значення: `0`, `1`.
     */
    private Integer trackRead;

    /**
     * Об'єкт, що містить додаткові заголовки листа, максимум 50 заголовків. Префікс “X-” в імені заголовка
     * обов'язковий, заголовки без нього будуть проігноровані, наприклад X-ALLYMAILER-Global-Language,
     * X-ALLYMAILER-Template-Engine. Стандартні заголовки "To", "CC", "BCC" передаються без префікса "X-",
     * але обробляються спеціальним чином, тому мають низку обмежень, докладніше про це можна прочитати
     * [тут](/cc-and-bcc). Також якщо [техпідтримка](https://cp.allymailer.com/ua/support) схвалила вам
     * вимкнення посилання відписки, то ви також можете передавати заголовки List-Unsubscribe,
     * List-Subscribe, List-Help, List-Owner, List-Archive, In-Reply-To і References.
     */
    private HeadersObject headers;

    /** Необов'язковий масив вкладень. */
    private List<AttachmentsArrayItem> attachments;

    /**
     * Масив для передачі inline-вкладень, наприклад, для включення зображень у лист замість завантаження
     * їх за посиланням.
     */
    private List<InlineAttachmentsArrayItem> inlineAttachments;

    public String getId() {
        return id;
    }

    public TemplateObject setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TemplateObject setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getEditorTypeValue()), null when absent.
     */
    public EditorType getEditorType() {
        return EditorType.fromValue(editorType);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setEditorTypeValue()).
     */
    public TemplateObject setEditorType(EditorType editorType) {
        this.editorType = EditorType.toValue(editorType);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getEditorTypeValue() {
        return editorType;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public TemplateObject setEditorTypeValue(String editorType) {
        this.editorType = editorType;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getTemplateEngineValue()), null when absent.
     */
    public TemplateEngine getTemplateEngine() {
        return TemplateEngine.fromValue(templateEngine);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setTemplateEngineValue()).
     */
    public TemplateObject setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = TemplateEngine.toValue(templateEngine);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getTemplateEngineValue() {
        return templateEngine;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public TemplateObject setTemplateEngineValue(String templateEngine) {
        this.templateEngine = templateEngine;
        return this;
    }

    public Map<String, String> getGlobalSubstitutions() {
        return globalSubstitutions;
    }

    public TemplateObject setGlobalSubstitutions(Map<String, String> globalSubstitutions) {
        this.globalSubstitutions = globalSubstitutions;
        return this;
    }

    public Map<String, String> getGlobalMetadata() {
        return globalMetadata;
    }

    public TemplateObject setGlobalMetadata(Map<String, String> globalMetadata) {
        this.globalMetadata = globalMetadata;
        return this;
    }

    public BodyObject getBody() {
        return body;
    }

    public TemplateObject setBody(BodyObject body) {
        this.body = body;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public TemplateObject setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public TemplateObject setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
        return this;
    }

    public String getFromName() {
        return fromName;
    }

    public TemplateObject setFromName(String fromName) {
        this.fromName = fromName;
        return this;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public TemplateObject setReplyTo(String replyTo) {
        this.replyTo = replyTo;
        return this;
    }

    public String getReplyToName() {
        return replyToName;
    }

    public TemplateObject setReplyToName(String replyToName) {
        this.replyToName = replyToName;
        return this;
    }

    public Integer getTrackLinks() {
        return trackLinks;
    }

    public TemplateObject setTrackLinks(Integer trackLinks) {
        this.trackLinks = trackLinks;
        return this;
    }

    public Integer getTrackRead() {
        return trackRead;
    }

    public TemplateObject setTrackRead(Integer trackRead) {
        this.trackRead = trackRead;
        return this;
    }

    public HeadersObject getHeaders() {
        return headers;
    }

    public TemplateObject setHeaders(HeadersObject headers) {
        this.headers = headers;
        return this;
    }

    public List<AttachmentsArrayItem> getAttachments() {
        return attachments;
    }

    public TemplateObject setAttachments(List<AttachmentsArrayItem> attachments) {
        this.attachments = attachments;
        return this;
    }

    public List<InlineAttachmentsArrayItem> getInlineAttachments() {
        return inlineAttachments;
    }

    public TemplateObject setInlineAttachments(List<InlineAttachmentsArrayItem> inlineAttachments) {
        this.inlineAttachments = inlineAttachments;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static TemplateObject fromMap(Map<String, Object> data) {
        TemplateObject result = new TemplateObject();
        result.id = Json.asString(data.get("id"));
        result.name = Json.asString(data.get("name"));
        result.editorType = Json.asString(data.get("editor_type"));
        result.templateEngine = Json.asString(data.get("template_engine"));
        result.globalSubstitutions = Json.asMapOf(data.get("global_substitutions"), Json::asString);
        result.globalMetadata = Json.asMapOf(data.get("global_metadata"), Json::asString);
        result.body = Json.asObject(data.get("body"), BodyObject::fromMap);
        result.subject = Json.asString(data.get("subject"));
        result.fromEmail = Json.asString(data.get("from_email"));
        result.fromName = Json.asString(data.get("from_name"));
        result.replyTo = Json.asString(data.get("reply_to"));
        result.replyToName = Json.asString(data.get("reply_to_name"));
        result.trackLinks = Json.asInteger(data.get("track_links"));
        result.trackRead = Json.asInteger(data.get("track_read"));
        result.headers = Json.asObject(data.get("headers"), HeadersObject::fromMap);
        result.attachments = Json.asList(data.get("attachments"), v0 -> Json.asObject(v0, AttachmentsArrayItem::fromMap));
        result.inlineAttachments = Json.asList(data.get("inline_attachments"), v0 -> Json.asObject(v0, InlineAttachmentsArrayItem::fromMap));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "id", id);
        Json.put(result, "name", name);
        Json.put(result, "editor_type", editorType);
        Json.put(result, "template_engine", templateEngine);
        Json.put(result, "global_substitutions", globalSubstitutions);
        Json.put(result, "global_metadata", globalMetadata);
        Json.put(result, "body", body == null ? null : body.toMap());
        Json.put(result, "subject", subject);
        Json.put(result, "from_email", fromEmail);
        Json.put(result, "from_name", fromName);
        Json.put(result, "reply_to", replyTo);
        Json.put(result, "reply_to_name", replyToName);
        Json.put(result, "track_links", trackLinks);
        Json.put(result, "track_read", trackRead);
        Json.put(result, "headers", headers == null ? null : headers.toMap());
        Json.put(result, "attachments", Json.mapList(attachments, v0 -> v0.toMap()));
        Json.put(result, "inline_attachments", Json.mapList(inlineAttachments, v0 -> v0.toMap()));
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
