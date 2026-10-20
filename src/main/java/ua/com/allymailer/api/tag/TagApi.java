package ua.com.allymailer.api.tag;

import java.util.Map;
import ua.com.allymailer.api.tag.model.TagDeleteRequest;
import ua.com.allymailer.api.tag.model.TagListResponse;
import ua.com.allymailer.client.ApiClient;
import ua.com.allymailer.client.ApiException;
import ua.com.allymailer.common.model.SuccessResponse;

/**
 * Методи керування користувацькими мітками. За допомогою міток ви можете класифікувати листи за
 * потрібними критеріями. Відокремити маркетингові листи від транзакційних або листи з підтвердженням
 * реєстрації від сповіщень про замовлення. AllyMailer дозволяє позначати мітками кожне вихідне
 * повідомлення, а потім сегментувати й аналізувати статистику на основі зазначених під час надсилання
 * міток.
 */
public class TagApi {
    private final ApiClient client;

    public TagApi(ApiClient client) {
        this.client = client;
    }

    /**
     * Метод без параметрів, повертає список усіх користувацьких міток.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#tag-list
     * @throws ApiException when the API returns an error
     */
    public TagListResponse list() {
        return TagListResponse.fromMap(client.call("/tag/list.json", null));
    }

    /**
     * Видаляє мітку.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#tag-delete
     * @throws ApiException when the API returns an error
     */
    public SuccessResponse delete(TagDeleteRequest request) {
        return SuccessResponse.fromMap(client.call("/tag/delete.json", request.toMap()));
    }
}
