package ua.com.allymailer.api.eventdump.model;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.com.allymailer.client.Json;
import ua.com.allymailer.common.model.EmailStatus;

/** Об'єкт із властивостями фільтра дампа подій. */
public class FilterObject {
    /**
     * Ідентифікатор завдання, раніше повернутий методом
     * [email/send](https://docs.allymailer.com.ua/ua/web-api-ref#email-send).
     */
    private String jobId;

    /**
     * Статус email. Можна вказати одне з таких значень:
     * <p>
     * __accepted__ — повідомлення прийнято, але ще не надіслано.
     * <p>
     * __sent__ — повідомлення надіслано, але ще не доставлено.
     * <p>
     * __delivered__ — повідомлення доставлено.
     * <p>
     * __opened__ — повідомлення доставлено й зареєстровано його прочитання.
     * <p>
     * __clicked__ — повідомлення доставлено, прочитано, було зареєстровано перехід за одним з посилань у
     * листі.
     * <p>
     * __unsubscribed__ — повідомлення було доставлено отримувачу й прочитано ним, але користувач
     * відписався за посиланням у листі.
     * <p>
     * __subscribed__ — повідомлення було доставлено отримувачу й прочитано ним, але користувач відписався,
     * а потім знову підписався за посиланням у листі.
     * <p>
     * __soft_bounced__ — тимчасова недоставка повідомлення. AllyMailer продовжує спроби доставки протягом
     * 2 діб.
     * <p>
     * __hard_bounced__ — доставка не вдалася, спроб доставки більше не буде.
     * <p>
     * __spam__ — повідомлення доставлено, але позначено як “спам” отримувачем.
     * <p>
     * Raw value, kept also when the SDK does not know it.
     */
    private String status;

    /**
     * Внутрішній детальний статус доставки AllyMailer. Можна вказати декілька статусів через кому. Ось
     * деякі з можливих статусів:
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

    /** Адреса отримувача */
    private String email;

    /** Адреса відправника */
    private String emailFrom;

    /** Домен отримувача */
    private String domain;

    /**
     * Ідентифікатор розсилки, невід'ємне десяткове ціле або UUID до 128 біт, передане в метаданих у полі з
     * іменем "campaign_id" (ім'я можна налаштувати через техпідтримку).
     */
    private String campaignId;

    public String getJobId() {
        return jobId;
    }

    public FilterObject setJobId(String jobId) {
        this.jobId = jobId;
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
    public FilterObject setStatus(EmailStatus status) {
        this.status = EmailStatus.toValue(status);
        return this;
    }

    /** Raw value of the field as sent by the API, also when the SDK does not know it. */
    public String getStatusValue() {
        return status;
    }

    /** Sets the raw value, e.g. one added to the API after this SDK version. */
    public FilterObject setStatusValue(String status) {
        this.status = status;
        return this;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public FilterObject setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public FilterObject setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public FilterObject setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public FilterObject setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public FilterObject setCampaignId(String campaignId) {
        this.campaignId = campaignId;
        return this;
    }

    /** Builds the object from decoded JSON. */
    public static FilterObject fromMap(Map<String, Object> data) {
        FilterObject result = new FilterObject();
        result.jobId = Json.asString(data.get("job_id"));
        result.status = Json.asString(data.get("status"));
        result.deliveryStatus = Json.asString(data.get("delivery_status"));
        result.email = Json.asString(data.get("email"));
        result.emailFrom = Json.asString(data.get("email_from"));
        result.domain = Json.asString(data.get("domain"));
        result.campaignId = Json.asString(data.get("campaign_id"));
        return result;
    }

    /** JSON-ready map, null fields are omitted. */
    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        Json.put(result, "job_id", jobId);
        Json.put(result, "status", status);
        Json.put(result, "delivery_status", deliveryStatus);
        Json.put(result, "email", email);
        Json.put(result, "email_from", emailFrom);
        Json.put(result, "domain", domain);
        Json.put(result, "campaign_id", campaignId);
        return result;
    }

    @Override
    public String toString() {
        return Json.stringify(toMap());
    }
}
