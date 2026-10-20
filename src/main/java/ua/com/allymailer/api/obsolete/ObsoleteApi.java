package ua.com.allymailer.api.obsolete;

import java.util.Map;
import ua.com.allymailer.api.obsolete.model.ObsoleteUnsubscribedCheckRequest;
import ua.com.allymailer.api.obsolete.model.ObsoleteUnsubscribedCheckResponse;
import ua.com.allymailer.api.obsolete.model.ObsoleteUnsubscribedListRequest;
import ua.com.allymailer.api.obsolete.model.ObsoleteUnsubscribedListResponse;
import ua.com.allymailer.api.obsolete.model.ObsoleteUnsubscribedSetRequest;
import ua.com.allymailer.api.obsolete.model.ObsoleteUnsubscribedSetResponse;
import ua.com.allymailer.client.ApiClient;
import ua.com.allymailer.client.ApiException;

/**
 * Застарілі методи роботи з відписками. Ми рекомендуємо користуватися замість них гнучкішими методами
 * [suppression](https://docs.allymailer.com.ua/ua/web-api-ref#suppression). Зверніть увагу, що знову
 * підписати відписаного адресата через WebAPI не можна. Можна лише надіслати йому email із посиланням
 * повторної підписки за допомогою методу email/subscribe.
 */
public class ObsoleteApi {
    private final ApiClient client;

    public ObsoleteApi(ApiClient client) {
        this.client = client;
    }

    /**
     * Внести email до списку відписаних.
     * <p>
     * Після внесення email до списку відписаних усі майбутні спроби надіслати на нього повідомлення будуть
     * відхилятися. Зауважте, що видалити email зі списку відписаних безпосередньо за допомогою API не
     * можна. Але можна надіслати йому повідомлення з посиланням повторної підписки за допомогою методу
     * [email/subscribe](https://docs.allymailer.com.ua/ua/web-api-ref#email-subscribe) або видалити його
     * зі списку відписаних вручну на сторінці [Пошук email](https://cp.allymailer.com/ua/user/email) у
     * панелі керування (але кількість таких видалень на день сильно обмежена).
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#unsubscribed-set
     * @throws ApiException when the API returns an error
     */
    public ObsoleteUnsubscribedSetResponse unsubscribedSet(ObsoleteUnsubscribedSetRequest request) {
        return ObsoleteUnsubscribedSetResponse.fromMap(client.call("/unsubscribed/set.json", request.toMap()));
    }

    /**
     * Перевіряє, чи відписано email.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#unsubscribed-check
     * @throws ApiException when the API returns an error
     */
    public ObsoleteUnsubscribedCheckResponse unsubscribedCheck(ObsoleteUnsubscribedCheckRequest request) {
        return ObsoleteUnsubscribedCheckResponse.fromMap(client.call("/unsubscribed/check.json", request.toMap()));
    }

    /**
     * Повертає список адрес, відписаних починаючи з указаної дати.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#unsubscribed-list
     * @throws ApiException when the API returns an error
     */
    public ObsoleteUnsubscribedListResponse unsubscribedList(ObsoleteUnsubscribedListRequest request) {
        return ObsoleteUnsubscribedListResponse.fromMap(client.call("/unsubscribed/list.json", request.toMap()));
    }
}
