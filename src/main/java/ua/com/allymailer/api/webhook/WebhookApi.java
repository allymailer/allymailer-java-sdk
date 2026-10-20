package ua.com.allymailer.api.webhook;

import java.util.Map;
import ua.com.allymailer.api.webhook.model.WebhookCallback;
import ua.com.allymailer.api.webhook.model.WebhookDeleteRequest;
import ua.com.allymailer.api.webhook.model.WebhookGetRequest;
import ua.com.allymailer.api.webhook.model.WebhookGetResponse;
import ua.com.allymailer.api.webhook.model.WebhookListRequest;
import ua.com.allymailer.api.webhook.model.WebhookListResponse;
import ua.com.allymailer.api.webhook.model.WebhookSetRequest;
import ua.com.allymailer.api.webhook.model.WebhookSetResponse;
import ua.com.allymailer.client.ApiClient;
import ua.com.allymailer.client.ApiException;
import ua.com.allymailer.client.Json;
import ua.com.allymailer.common.model.SuccessResponse;

/**
 * AllyMailer дозволяє вам отримувати сповіщення про зміну статусу доставки листа або спам-блокування.
 * Ви надаєте URL, і в разі виникнення події, що вас цікавить, ми сповіщаємо вас, передаючи на цей URL
 * JSON-дані про подію.
 * <p>
 * Ви можете налаштувати формат виклику webhook (просто JSON або JSON, запакований у gzip), які саме
 * події вас цікавлять, чи дозволено групувати кілька подій в одному виклику, чи потрібні вам такі
 * подробиці, як SMTP-відповідь сервера або user agent отримувача тощо.
 * <p>
 * Зверніть увагу, що ваш обробник має вміти приймати щонайменше 5 паралельних викликів, до 100 подій у
 * кожному (але ви можете налаштувати максимально дозволену кількість паралельних викликів, збільшивши
 * її до 100).
 * <p>
 * Якщо URL, на який надсилається webhook, недоступний (немає відповіді HTTP 200 OK протягом 3 секунд),
 * спроби надсилання webhook на цей URL до отримання очікуваного 200 OK триватимуть протягом 24 годин з
 * інтервалом у 10 хвилин з додатковим параметром retry_count, значення якого збільшуватиметься на 1 з
 * кожним повторним надсиланням webhook. Якщо протягом 24 годин сталося щонайменше 10 подій і жоден із
 * багаторазових викликів webhook про ці події не був успішним, то ми вважаємо обробник непрацездатним
 * і автоматично встановлюємо його статус у неактивний та повідомляємо про це на email, [вказаний в
 * особистому кабінеті](https://cp.allymailer.com/ua/user/alerting/technical/).
 * <p>
 * Формат webhook і структура кожної події описані
 * [тут](https://docs.allymailer.com.ua/ua/web-api-ref#callback-format).
 */
public class WebhookApi {
    private final ApiClient client;

    public WebhookApi(ApiClient client) {
        this.client = client;
    }

    /**
     * Встановлює або змінює властивості [webhook](https://docs.allymailer.com.ua/ua/web-api-ref#webhook) —
     * вашого обробника сповіщень про події. У момент виклику
     * [webhook/set](https://docs.allymailer.com.ua/ua/web-api-ref#webhook-set) ми очікуємо, що до
     * вказаного вами URL можна звернутися GET-запитом без параметрів і у відповідь надійде 200 OK.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#webhook-set
     * @throws ApiException when the API returns an error
     */
    public WebhookSetResponse set(WebhookSetRequest request) {
        return WebhookSetResponse.fromMap(client.call("/webhook/set.json", request.toMap()));
    }

    /**
     * Повертає властивості [webhook](https://docs.allymailer.com.ua/ua/web-api-ref#webhook)
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#webhook-get
     * @throws ApiException when the API returns an error
     */
    public WebhookGetResponse get(WebhookGetRequest request) {
        return WebhookGetResponse.fromMap(client.call("/webhook/get.json", request.toMap()));
    }

    /**
     * Повернути список усіх або кількох [webhook](https://docs.allymailer.com.ua/ua/web-api-ref#webhook)
     * (обробників сповіщень про події) користувача або проєкту.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#webhook-list
     * @throws ApiException when the API returns an error
     */
    public WebhookListResponse list(WebhookListRequest request) {
        return WebhookListResponse.fromMap(client.call("/webhook/list.json", request.toMap()));
    }

    /**
     * Видалити webhook.
     * <p>
     * Ви також можете тимчасово вимкнути webhook без його видалення, встановивши його поле status у
     * "disabled" за допомогою методу
     * [webhook/set](https://docs.allymailer.com.ua/ua/web-api-ref#webhook-set).
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#webhook-delete
     * @throws ApiException when the API returns an error
     */
    public SuccessResponse delete(WebhookDeleteRequest request) {
        return SuccessResponse.fromMap(client.call("/webhook/delete.json", request.toMap()));
    }

    /**
     * Опис формату webhook.
     * @param body raw body of the incoming request
     */
    public static WebhookCallback parseCallback(String body) {
        return WebhookCallback.fromMap(Json.asMap(Json.parse(body)));
    }
}
