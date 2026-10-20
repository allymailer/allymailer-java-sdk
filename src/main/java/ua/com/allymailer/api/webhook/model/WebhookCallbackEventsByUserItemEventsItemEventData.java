package ua.com.allymailer.api.webhook.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;
import ua.com.allymailer.common.model.EmailStatus;

/**
 * Об'єкт з різними властивостями події, що залежать від поля "event_name". Нижче перелічено всі
 * можливі властивості, спочатку для події "transactional_email_status", потім для події
 * "transactional_spam_block".
 */
public class WebhookCallbackEventsByUserItemEventsItemEventData {
    /**
     * Ідентифікатор завдання, раніше повернутий методом
     * [email/send](https://docs.allymailer.com.ua/ua/web-api-ref#email-send). Присутній лише якщо
     * event_name="transactional_email_status".
     */
    private String jobId;

    /**
     * Метадані, раніше передані методом
     * [email/send](https://docs.allymailer.com.ua/ua/web-api-ref#email-send) у полі recipients.metadata
     * або global_metadata. Присутні лише якщо event_name="transactional_email_status".
     */
    private Map<String, String> metadata;

    /**
     * Email, на який було здійснено надсилання. Присутній лише якщо
     * event_name="transactional_email_status".
     */
    private String email;

    /**
     * Статус доставки листа. Присутній лише якщо event_name="transactional_email_status". Набуває одного з
     * таких значень:
     * <p>
     * __accepted__ — повідомлення прийнято, але ще не надіслано.
     * <p>
     * __sent__ — повідомлення надіслано, але ще не доставлено.
     * <p>
     * __delivered__ — повідомлення доставлено. Може змінитися на “opened”, “clicked”, “unsubscribed”,
     * “subscribed” або “spam”.
     * <p>
     * __opened__ — повідомлення доставлено й зареєстровано його прочитання. Може змінитися на “clicked”,
     * “unsubscribed”, “subscribed” або “spam”.
     * <p>
     * __clicked__ — повідомлення доставлено, прочитано, було зареєстровано перехід за одним з посилань у
     * листі. Може змінитися на “unsubscribed”, “subscribed” або “spam”.
     * <p>
     * __unsubscribed__ — повідомлення було доставлено отримувачу й прочитано ним, але користувач
     * відписався за посиланням у листі. Може змінитися на “subscribed”.
     * <p>
     * __subscribed__ — повідомлення було доставлено отримувачу й прочитано ним, але користувач відписався,
     * а потім знову підписався за посиланням у листі. Може змінитися на “unsubscribed”.
     * <p>
     * __soft_bounced__ — тимчасова недоставка повідомлення. AllyMailer продовжує спроби доставки протягом
     * 2 діб. У разі успішної доставки лист перейде у статус “delivered”, у разі неуспішної — у
     * “hard_bounced”.
     * <p>
     * __hard_bounced__ — доставка не вдалася, спроб доставки більше не буде. Статус остаточний. Можливих
     * причин невдалої доставки безліч, для їх аналізу можна використати текст відповіді SMTP-сервера з
     * поля delivery_info.destination_response або нашу внутрішню класифікацію помилок з поля
     * delivery_info.delivery_status.
     * <p>
     * __spam__ — повідомлення доставлено, але позначено як “спам” отримувачем. Статус остаточний. Ось
     * деякі домени, від яких AllyMailer може отримати й обробити скаргу про спам (використовуючи
     * технологію FBL): mail.ru, msn.com, outlook.com, hotmail.com, live.com, ukr.net, yahoo.com, aol.com.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String status;

    /**
     * Дата й час події в часовому поясі UTC у форматі "РРРР-ММ-ДД гг:хх:сс". Присутній лише якщо
     * event_name="transactional_email_status".
     */
    private String eventTime;

    /**
     * URL у разі статусів "opened" і "clicked". Присутній лише якщо
     * event_name="transactional_email_status".
     */
    private String url;

    /**
     * Об'єкт з додатковою інформацією про доставку. Присутній лише якщо властивість delivery_info під час
     * встановлення webhook дорівнювала 1 і якщо event_name="transactional_email_status".
     */
    private WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo deliveryInfo;

    /**
     * Дата й час спам-блока в часовому поясі UTC у форматі "РРРР-ММ-ДД гг:хх:сс". Присутній лише якщо
     * event_name="transactional_spam_block".
     */
    private String blockTime;

    /**
     * Тип спам-блока — заблоковано або один відправляючий SMTP, або одразу багато. У разі блокування
     * одиночного SMTP із загального пулу AllyMailer пробуватиме ще декілька. Властивість присутня лише
     * якщо event_name="transactional_spam_block".
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String blockType;

    /**
     * Домен, що заблокував надсилання. Властивість присутня лише якщо
     * event_name="transactional_spam_block".
     */
    private String domain;

    /**
     * Кількість заблокованих вихідних SMTP. Властивість присутня лише якщо
     * event_name="transactional_spam_block".
     */
    private Long sMTPBlocksCount;

    /**
     * Це подія блокування чи розблокування. Властивість присутня лише якщо
     * event_name="transactional_spam_block".
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String domainStatus;

    public String getJobId() {
        return jobId;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventData setJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventData setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventData setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getStatusValue()), null when absent.
     */
    public EmailStatus getStatus() {
        return EmailStatus.fromValue(status);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setStatusValue()).
     */
    public WebhookCallbackEventsByUserItemEventsItemEventData setStatus(EmailStatus status) {
        this.status = EmailStatus.toValue(status);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getStatusValue() {
        return status;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public WebhookCallbackEventsByUserItemEventsItemEventData setStatusValue(String status) {
        this.status = status;
        return this;
    }

    public String getEventTime() {
        return eventTime;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventData setEventTime(String eventTime) {
        this.eventTime = eventTime;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventData setUrl(String url) {
        this.url = url;
        return this;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventData setDeliveryInfo(WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
        return this;
    }

    public String getBlockTime() {
        return blockTime;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventData setBlockTime(String blockTime) {
        this.blockTime = blockTime;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getBlockTypeValue()), null when absent.
     */
    public BlockType getBlockType() {
        return BlockType.fromValue(blockType);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setBlockTypeValue()).
     */
    public WebhookCallbackEventsByUserItemEventsItemEventData setBlockType(BlockType blockType) {
        this.blockType = BlockType.toValue(blockType);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getBlockTypeValue() {
        return blockType;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public WebhookCallbackEventsByUserItemEventsItemEventData setBlockTypeValue(String blockType) {
        this.blockType = blockType;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventData setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public Long getSMTPBlocksCount() {
        return sMTPBlocksCount;
    }

    public WebhookCallbackEventsByUserItemEventsItemEventData setSMTPBlocksCount(Long sMTPBlocksCount) {
        this.sMTPBlocksCount = sMTPBlocksCount;
        return this;
    }

    /**
     * Enum value of the field, UNKNOWN_VALUE for a value unknown to this SDK version (the raw one:
     * getDomainStatusValue()), null when absent.
     */
    public DomainStatus getDomainStatus() {
        return DomainStatus.fromValue(domainStatus);
    }

    /**
     * Sets the field; IllegalArgumentException for UNKNOWN_VALUE (an unknown value goes to
     * setDomainStatusValue()).
     */
    public WebhookCallbackEventsByUserItemEventsItemEventData setDomainStatus(DomainStatus domainStatus) {
        this.domainStatus = DomainStatus.toValue(domainStatus);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getDomainStatusValue() {
        return domainStatus;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public WebhookCallbackEventsByUserItemEventsItemEventData setDomainStatusValue(String domainStatus) {
        this.domainStatus = domainStatus;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static WebhookCallbackEventsByUserItemEventsItemEventData fromMap(Map<String, Object> data) {
        WebhookCallbackEventsByUserItemEventsItemEventData result = new WebhookCallbackEventsByUserItemEventsItemEventData();
        result.jobId = Json.asString(data.get("job_id"));
        result.metadata = Json.asMapOf(data.get("metadata"), Json::asString);
        result.email = Json.asString(data.get("email"));
        result.status = Json.asString(data.get("status"));
        result.eventTime = Json.asString(data.get("event_time"));
        result.url = Json.asString(data.get("url"));
        result.deliveryInfo = Json.asObject(data.get("delivery_info"), WebhookCallbackEventsByUserItemEventsItemEventDataDeliveryInfo::fromMap);
        result.blockTime = Json.asString(data.get("block_time"));
        result.blockType = Json.asString(data.get("block_type"));
        result.domain = Json.asString(data.get("domain"));
        result.sMTPBlocksCount = Json.asLong(data.get("SMTP_blocks_count"));
        result.domainStatus = Json.asString(data.get("domain_status"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "job_id", jobId);
        Json.put(result, "metadata", metadata);
        Json.put(result, "email", email);
        Json.put(result, "status", status);
        Json.put(result, "event_time", eventTime);
        Json.put(result, "url", url);
        Json.put(result, "delivery_info", deliveryInfo == null ? null : deliveryInfo.toMap());
        Json.put(result, "block_time", blockTime);
        Json.put(result, "block_type", blockType);
        Json.put(result, "domain", domain);
        Json.put(result, "SMTP_blocks_count", sMTPBlocksCount);
        Json.put(result, "domain_status", domainStatus);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
