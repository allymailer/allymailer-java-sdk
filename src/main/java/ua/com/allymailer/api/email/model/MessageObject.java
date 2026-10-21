package ua.com.allymailer.api.email.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ua.com.allymailer.client.Json;
import ua.com.allymailer.common.model.AttachmentsArrayItem;
import ua.com.allymailer.common.model.BodyObject;
import ua.com.allymailer.common.model.HeadersObject;
import ua.com.allymailer.common.model.InlineAttachmentsArrayItem;
import ua.com.allymailer.common.model.TemplateEngine;

/** Об'єкт, що містить усі властивості повідомлення, яке надсилається. */
public class MessageObject {
    /** Масив об'єктів з email-адресами, підстановками та метаданими отримувачів. */
    private List<MessageObjectRecipientsItem> recipients;

    /**
     * Унікальний ідентифікатор шаблону, створеного раніше методом
     * [template/set](https://docs.allymailer.com.ua/ua/web-api-ref#template-set). Якщо вказано, то поля
     * шаблону підставляються замість пропущених полів email/send. Наприклад, якщо в email/send не вказано
     * body — береться тіло листа із шаблону, а якщо не вказано subject — береться тема із шаблону.
     */
    private String templateId;

    /**
     * Масив із рядків, до 100 символів у кожному. Максимум 4 рядки в масиві, рядки мають бути унікальними.
     * Для кожного облікового запису/проєкту дозволено не більше ніж 10 000 міток, у разі перевищення метод
     * email/send повертатиме помилку. Мітки можуть використовуватися для категоризації листів за обраними
     * вами критеріями. Мітки передаються методами event-dump.
     */
    private List<String> tags;

    /**
     * Пропустити чи не пропускати додавання стандартного блока з посиланням відписки до HTML-частини
     * листа. 1=пропустити, 0=додати, за замовчуванням 0. Для использования skip_unsubscribe=1 вам надо
     * [попросить техподдержку](https://cp.allymailer.com/ru/support) включить такую возможность.
     * Допустимі значення: `0`, `1`.
     */
    private Integer skipUnsubscribe;

    /**
     * Заголовок для вибору мови посилання та сторінки відписки. Припустимі значення "be", "de", "en",
     * "es", "fr", "it", "pl", "pt", "ru", "ua", "kz".
     */
    private String globalLanguage;

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

    /** Email-адреса відправника. Обов'язковий лише за порожнього template_id. */
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
     * (0 або 1, за замовчуванням 0) Значення 1=ігнорувати список глобальної недоступності, під час
     * надсилання не враховуватимуться дані про недоступність адрес або скарги, отримані під час надсилання
     * іншими користувачами AllyMailer. Для деяких системних записів може бути заборонено
     * Допустимі значення: `0`, `1`.
     */
    private Integer bypassGlobal;

    /**
     * (0 або 1, за замовчуванням 0) Значення 1=ігнорувати список недоступних адрес поточного облікового
     * запису/проєкту. Указання 1 можливе лише за одночасного вказання bypass_global=1.
     * Допустимі значення: `0`, `1`.
     */
    private Integer bypassUnavailable;

    /**
     * (0 або 1, за замовчуванням 0) Значення 1=ігнорувати список відписаних від розсилок поточного
     * облікового запису/проєкту. Указання 1 можливе лише за одночасного вказання bypass_global=1. Параметр
     * доступний лише тим користувачам, яким [техпідтримка](https://cp.allymailer.com/ua/support) схвалила
     * вимкнення посилання відписки.
     * Допустимі значення: `0`, `1`.
     */
    private Integer bypassUnsubscribed;

    /**
     * (0 або 1, за замовчуванням 0) Значення 1=ігнорувати список тих, хто поскаржився на обліковий
     * запис/проєкт. Указання 1 можливе лише за одночасного вказання bypass_global=1. Параметр доступний
     * лише тим користувачам, яким [техпідтримка](https://cp.allymailer.com/ua/support) схвалила вимкнення
     * посилання відписки.
     * Допустимі значення: `0`, `1`.
     */
    private Integer bypassComplained;

    /**
     * Рядок до 64 символів завдовжки з унікальним ключем запиту. Може використовуватися для запобігання
     * випадковому дублюванню листів. У разі повторного надсилання запиту з тим самим ключем протягом
     * хвилини запит буде відхилено. Може створюватися автоматично для кожного листа; щоб увімкнути
     * автоматичну генерацію ключа, зв'яжіться з [техпідтримкою](https://cp.allymailer.com/ua/support).
     */
    private String idempotenceKey;

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

    /** Додаткові опції. */
    private MessageObjectOptions options;

    public List<MessageObjectRecipientsItem> getRecipients() {
        return recipients;
    }

    public MessageObject setRecipients(List<MessageObjectRecipientsItem> recipients) {
        this.recipients = recipients;
        return this;
    }

    public String getTemplateId() {
        return templateId;
    }

    public MessageObject setTemplateId(String templateId) {
        this.templateId = templateId;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public MessageObject setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public Integer getSkipUnsubscribe() {
        return skipUnsubscribe;
    }

    public MessageObject setSkipUnsubscribe(Integer skipUnsubscribe) {
        this.skipUnsubscribe = skipUnsubscribe;
        return this;
    }

    public String getGlobalLanguage() {
        return globalLanguage;
    }

    public MessageObject setGlobalLanguage(String globalLanguage) {
        this.globalLanguage = globalLanguage;
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
    public MessageObject setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = TemplateEngine.toValue(templateEngine);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getTemplateEngineValue() {
        return templateEngine;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public MessageObject setTemplateEngineValue(String templateEngine) {
        this.templateEngine = templateEngine;
        return this;
    }

    public Map<String, String> getGlobalSubstitutions() {
        return globalSubstitutions;
    }

    public MessageObject setGlobalSubstitutions(Map<String, String> globalSubstitutions) {
        this.globalSubstitutions = globalSubstitutions;
        return this;
    }

    public Map<String, String> getGlobalMetadata() {
        return globalMetadata;
    }

    public MessageObject setGlobalMetadata(Map<String, String> globalMetadata) {
        this.globalMetadata = globalMetadata;
        return this;
    }

    public BodyObject getBody() {
        return body;
    }

    public MessageObject setBody(BodyObject body) {
        this.body = body;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public MessageObject setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public MessageObject setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
        return this;
    }

    public String getFromName() {
        return fromName;
    }

    public MessageObject setFromName(String fromName) {
        this.fromName = fromName;
        return this;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public MessageObject setReplyTo(String replyTo) {
        this.replyTo = replyTo;
        return this;
    }

    public String getReplyToName() {
        return replyToName;
    }

    public MessageObject setReplyToName(String replyToName) {
        this.replyToName = replyToName;
        return this;
    }

    public Integer getTrackLinks() {
        return trackLinks;
    }

    public MessageObject setTrackLinks(Integer trackLinks) {
        this.trackLinks = trackLinks;
        return this;
    }

    public Integer getTrackRead() {
        return trackRead;
    }

    public MessageObject setTrackRead(Integer trackRead) {
        this.trackRead = trackRead;
        return this;
    }

    public Integer getBypassGlobal() {
        return bypassGlobal;
    }

    public MessageObject setBypassGlobal(Integer bypassGlobal) {
        this.bypassGlobal = bypassGlobal;
        return this;
    }

    public Integer getBypassUnavailable() {
        return bypassUnavailable;
    }

    public MessageObject setBypassUnavailable(Integer bypassUnavailable) {
        this.bypassUnavailable = bypassUnavailable;
        return this;
    }

    public Integer getBypassUnsubscribed() {
        return bypassUnsubscribed;
    }

    public MessageObject setBypassUnsubscribed(Integer bypassUnsubscribed) {
        this.bypassUnsubscribed = bypassUnsubscribed;
        return this;
    }

    public Integer getBypassComplained() {
        return bypassComplained;
    }

    public MessageObject setBypassComplained(Integer bypassComplained) {
        this.bypassComplained = bypassComplained;
        return this;
    }

    public String getIdempotenceKey() {
        return idempotenceKey;
    }

    public MessageObject setIdempotenceKey(String idempotenceKey) {
        this.idempotenceKey = idempotenceKey;
        return this;
    }

    public HeadersObject getHeaders() {
        return headers;
    }

    public MessageObject setHeaders(HeadersObject headers) {
        this.headers = headers;
        return this;
    }

    public List<AttachmentsArrayItem> getAttachments() {
        return attachments;
    }

    public MessageObject setAttachments(List<AttachmentsArrayItem> attachments) {
        this.attachments = attachments;
        return this;
    }

    public List<InlineAttachmentsArrayItem> getInlineAttachments() {
        return inlineAttachments;
    }

    public MessageObject setInlineAttachments(List<InlineAttachmentsArrayItem> inlineAttachments) {
        this.inlineAttachments = inlineAttachments;
        return this;
    }

    public MessageObjectOptions getOptions() {
        return options;
    }

    public MessageObject setOptions(MessageObjectOptions options) {
        this.options = options;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static MessageObject fromMap(Map<String, Object> data) {
        MessageObject result = new MessageObject();
        result.recipients = Json.asList(data.get("recipients"), v0 -> Json.asObject(v0, MessageObjectRecipientsItem::fromMap));
        result.templateId = Json.asString(data.get("template_id"));
        result.tags = Json.asList(data.get("tags"), Json::asString);
        result.skipUnsubscribe = Json.asInteger(data.get("skip_unsubscribe"));
        result.globalLanguage = Json.asString(data.get("global_language"));
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
        result.bypassGlobal = Json.asInteger(data.get("bypass_global"));
        result.bypassUnavailable = Json.asInteger(data.get("bypass_unavailable"));
        result.bypassUnsubscribed = Json.asInteger(data.get("bypass_unsubscribed"));
        result.bypassComplained = Json.asInteger(data.get("bypass_complained"));
        result.idempotenceKey = Json.asString(data.get("idempotence_key"));
        result.headers = Json.asObject(data.get("headers"), HeadersObject::fromMap);
        result.attachments = Json.asList(data.get("attachments"), v0 -> Json.asObject(v0, AttachmentsArrayItem::fromMap));
        result.inlineAttachments = Json.asList(data.get("inline_attachments"), v0 -> Json.asObject(v0, InlineAttachmentsArrayItem::fromMap));
        result.options = Json.asObject(data.get("options"), MessageObjectOptions::fromMap);
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "recipients", Json.mapList(recipients, v0 -> v0.toMap()));
        Json.put(result, "template_id", templateId);
        Json.put(result, "tags", tags);
        Json.put(result, "skip_unsubscribe", skipUnsubscribe);
        Json.put(result, "global_language", globalLanguage);
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
        Json.put(result, "bypass_global", bypassGlobal);
        Json.put(result, "bypass_unavailable", bypassUnavailable);
        Json.put(result, "bypass_unsubscribed", bypassUnsubscribed);
        Json.put(result, "bypass_complained", bypassComplained);
        Json.put(result, "idempotence_key", idempotenceKey);
        Json.put(result, "headers", headers == null ? null : headers.toMap());
        Json.put(result, "attachments", Json.mapList(attachments, v0 -> v0.toMap()));
        Json.put(result, "inline_attachments", Json.mapList(inlineAttachments, v0 -> v0.toMap()));
        Json.put(result, "options", options == null ? null : options.toMap());
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
