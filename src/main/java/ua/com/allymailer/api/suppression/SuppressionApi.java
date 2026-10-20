package ua.com.allymailer.api.suppression;

import java.util.Map;
import ua.com.allymailer.api.suppression.model.SuppressionDeleteRequest;
import ua.com.allymailer.api.suppression.model.SuppressionGetRequest;
import ua.com.allymailer.api.suppression.model.SuppressionGetResponse;
import ua.com.allymailer.api.suppression.model.SuppressionListRequest;
import ua.com.allymailer.api.suppression.model.SuppressionListResponse;
import ua.com.allymailer.api.suppression.model.SuppressionSetRequest;
import ua.com.allymailer.client.ApiClient;
import ua.com.allymailer.client.ApiException;
import ua.com.allymailer.common.model.SuccessResponse;

/**
 * Методи для керування адресами, надсилання на які заблоковано з різних причин — відписка,
 * недоступність, скарги.
 */
public class SuppressionApi {
    private final ApiClient client;

    public SuppressionApi(ApiClient client) {
        this.client = client;
    }

    /**
     * Додає email-адресу до списку недоступних. Ви завжди зможете пізніше видалити цю адресу зі списку
     * недоступних методом
     * [suppression/delete](https://docs.allymailer.com.ua/ua/web-api-ref#suppression-delete).
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#suppression-set
     * @throws ApiException when the API returns an error
     */
    public SuccessResponse set(SuppressionSetRequest request) {
        return SuccessResponse.fromMap(client.call("/suppression/set.json", request.toMap()));
    }

    /**
     * Повертає причину й дату блокування email-адреси.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#suppression-get
     * @throws ApiException when the API returns an error
     */
    public SuppressionGetResponse get(SuppressionGetRequest request) {
        return SuppressionGetResponse.fromMap(client.call("/suppression/get.json", request.toMap()));
    }

    /**
     * Повертає список недоступних, починаючи з указаної дати.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#suppression-list
     * @throws ApiException when the API returns an error
     */
    public SuppressionListResponse list(SuppressionListRequest request) {
        return SuppressionListResponse.fromMap(client.call("/suppression/list.json", request.toMap()));
    }

    /**
     * Видаляє email-адресу зі списку недоступних (лише записи з is_deletable=true). Якщо жодного запису
     * для email не знайдено, повертається помилка API 3003. Якщо записи про недоступність знайдено, але
     * жодну з них видалити не можна, повертається помилка API 3004. Якщо перевищено ліміт видалень на
     * добу, повертається помилка API 906.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#suppression-delete
     * @throws ApiException when the API returns an error
     */
    public SuccessResponse delete(SuppressionDeleteRequest request) {
        return SuccessResponse.fromMap(client.call("/suppression/delete.json", request.toMap()));
    }
}
