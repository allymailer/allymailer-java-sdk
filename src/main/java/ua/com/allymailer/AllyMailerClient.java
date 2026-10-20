package ua.com.allymailer;

import ua.com.allymailer.api.confirmedemail.ConfirmedEmailApi;
import ua.com.allymailer.api.domain.DomainApi;
import ua.com.allymailer.api.email.EmailApi;
import ua.com.allymailer.api.emailvalidation.EmailValidationApi;
import ua.com.allymailer.api.eventdump.EventDumpApi;
import ua.com.allymailer.api.obsolete.ObsoleteApi;
import ua.com.allymailer.api.project.ProjectApi;
import ua.com.allymailer.api.suppression.SuppressionApi;
import ua.com.allymailer.api.system.SystemApi;
import ua.com.allymailer.api.tag.TagApi;
import ua.com.allymailer.api.template.TemplateApi;
import ua.com.allymailer.api.webhook.WebhookApi;
import ua.com.allymailer.client.ApiClient;
import ua.com.allymailer.client.Configuration;

/**
 * Entry point of the AllyMailer API: one accessor per section.
 * <p>
 * AllyMailerClient client = AllyMailer.client("YOUR_API_KEY");
 * client.email().send(...);
 */
public class AllyMailerClient {
    private final ApiClient apiClient;
    private final EmailApi email;
    private final EmailValidationApi emailValidation;
    private final ConfirmedEmailApi confirmedEmail;
    private final TemplateApi template;
    private final WebhookApi webhook;
    private final SuppressionApi suppression;
    private final DomainApi domain;
    private final EventDumpApi eventDump;
    private final TagApi tag;
    private final ProjectApi project;
    private final SystemApi system;
    private final ObsoleteApi obsolete;

    public AllyMailerClient(String apiKey) {
        this(new Configuration(apiKey));
    }

    public AllyMailerClient(Configuration config) {
        this(new ApiClient(config));
    }

    public AllyMailerClient(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.email = new EmailApi(apiClient);
        this.emailValidation = new EmailValidationApi(apiClient);
        this.confirmedEmail = new ConfirmedEmailApi(apiClient);
        this.template = new TemplateApi(apiClient);
        this.webhook = new WebhookApi(apiClient);
        this.suppression = new SuppressionApi(apiClient);
        this.domain = new DomainApi(apiClient);
        this.eventDump = new EventDumpApi(apiClient);
        this.tag = new TagApi(apiClient);
        this.project = new ProjectApi(apiClient);
        this.system = new SystemApi(apiClient);
        this.obsolete = new ObsoleteApi(apiClient);
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    /** Ця група методів пов'язана з надсиланням email. */
    public EmailApi email() {
        return email;
    }

    /**
     * Методи перевірки email-адрес. Перевірка адреси електронної пошти надає докладну інформацію про
     * працездатність email. Це дозволить виключити з надсилання неіснуючі email, знизити показник скарг,
     * очистити список підписників і врешті-решт покращити вашу репутацію як відправника. Наприклад, ви
     * можете інтегрувати процес перевірки у форму реєстрації вашого сайту і вже на етапі введення адреси
     * повідомляти користувачам, що адреса, яку вони ввели у форму, недійсна.
     */
    public EmailValidationApi emailValidation() {
        return emailValidation;
    }

    /**
     * Керування email-адресами, підтвердженими для надсилання із sandbox-домену. Методи доступні лише з
     * API-ключем основного облікового запису.
     */
    public ConfirmedEmailApi confirmedEmail() {
        return confirmedEmail;
    }

    /**
     * Ви можете зберегти шаблон на боці AllyMailer і потім посилатися на нього за ідентифікатором. Це не
     * обов'язково, але вкрай рекомендовано у разі повторюваних email-повідомлень або за великих обсягів
     * надсилання. AllyMailer підтримує два різні синтаксиси для шаблонів, докладніше читайте
     * [тут](https://docs.allymailer.com.ua/en/template-engines).
     */
    public TemplateApi template() {
        return template;
    }

    /**
     * AllyMailer дозволяє вам отримувати сповіщення про зміну статусу доставки листа або спам-блокування.
     * Ви надаєте URL, і в разі виникнення події, що вас цікавить, ми сповіщаємо вас, передаючи на цей URL
     * JSON-дані про подію.
     */
    public WebhookApi webhook() {
        return webhook;
    }

    /**
     * Методи для керування адресами, надсилання на які заблоковано з різних причин — відписка,
     * недоступність, скарги.
     */
    public SuppressionApi suppression() {
        return suppression;
    }

    /**
     * Методи для налаштування доменів надсилання та перевірки їх статусів. Корисні, якщо вам недостатньо
     * додавання доменів через вебінтерфейс AllyMailer і, наприклад, хочеться автоматизувати додавання
     * доменів для ваших власних клієнтів.
     */
    public DomainApi domain() {
        return domain;
    }

    /**
     * Методи для отримання списку подій, що сталися, за певний період. Дані зберігаються до 45 днів,
     * залежно від вашого тарифу. Це означає, що можна запросити події, починаючи з 00:00:00 45-го дня тому
     * і до поточного моменту часу. Для індивідуальних тарифів з великими обсягами за замовчуванням події
     * доступні лише за останні 7 днів.
     */
    public EventDumpApi eventDump() {
        return eventDump;
    }

    /**
     * Методи керування користувацькими мітками. За допомогою міток ви можете класифікувати листи за
     * потрібними критеріями. Відокремити маркетингові листи від транзакційних або листи з підтвердженням
     * реєстрації від сповіщень про замовлення. AllyMailer дозволяє позначати мітками кожне вихідне
     * повідомлення, а потім сегментувати й аналізувати статистику на основі зазначених під час надсилання
     * міток.
     */
    public TagApi tag() {
        return tag;
    }

    /**
     * Проєкти дозволяють об'єднати кілька незалежних доменів із webhook, шаблонами та списками відписки.
     * Це дуже корисно, якщо у вас є власні клієнти і ви керуєте їхніми даними з одного облікового запису
     * AllyMailer. Кожен проєкт отримує власний ключ API, а виклики методів API з цим ключем обробляють
     * лише дані цього проєкту. Таким чином, ви можете призначити окремий проєкт для кожного користувача і
     * бути впевненими, що вони не конфліктуватимуть: наприклад, відписка від одного проєкту не вплине на
     * інший.
     */
    public ProjectApi project() {
        return project;
    }

    /** Системні методи. */
    public SystemApi system() {
        return system;
    }

    /**
     * Застарілі методи роботи з відписками. Ми рекомендуємо користуватися замість них гнучкішими методами
     * [suppression](https://docs.allymailer.com.ua/ua/web-api-ref#suppression). Зверніть увагу, що знову
     * підписати відписаного адресата через WebAPI не можна. Можна лише надіслати йому email із посиланням
     * повторної підписки за допомогою методу email/subscribe.
     */
    public ObsoleteApi obsolete() {
        return obsolete;
    }
}
