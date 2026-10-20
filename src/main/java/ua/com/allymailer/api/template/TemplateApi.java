package ua.com.allymailer.api.template;

import java.util.Map;
import ua.com.allymailer.api.template.model.TemplateDeleteRequest;
import ua.com.allymailer.api.template.model.TemplateGetRequest;
import ua.com.allymailer.api.template.model.TemplateGetResponse;
import ua.com.allymailer.api.template.model.TemplateListRequest;
import ua.com.allymailer.api.template.model.TemplateListResponse;
import ua.com.allymailer.api.template.model.TemplateSetRequest;
import ua.com.allymailer.api.template.model.TemplateSetResponse;
import ua.com.allymailer.client.ApiClient;
import ua.com.allymailer.client.ApiException;
import ua.com.allymailer.common.model.SuccessResponse;

/**
 * Ви можете зберегти шаблон на боці AllyMailer і потім посилатися на нього за ідентифікатором. Це не
 * обов'язково, але вкрай рекомендовано у разі повторюваних email-повідомлень або за великих обсягів
 * надсилання. AllyMailer підтримує два різні синтаксиси для шаблонів, докладніше читайте
 * [тут](https://docs.allymailer.com.ua/en/template-engines).
 */
public class TemplateApi {
    private final ApiClient client;

    public TemplateApi(ApiClient client) {
        this.client = client;
    }

    /**
     * Створити або оновити шаблон.
     * <p>
     * Обмеження:
     * * Максимальний розмір запиту — 10 MB.
     * * Кількість шаблонів обмежено 10000.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#template-set
     * @throws ApiException when the API returns an error
     */
    public TemplateSetResponse set(TemplateSetRequest request) {
        return TemplateSetResponse.fromMap(client.call("/template/set.json", request.toMap()));
    }

    /**
     * Повертає властивості шаблону за його ідентифікатором.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#template-get
     * @throws ApiException when the API returns an error
     */
    public TemplateGetResponse get(TemplateGetRequest request) {
        return TemplateGetResponse.fromMap(client.call("/template/get.json", request.toMap()));
    }

    /**
     * Повертає повний список або частину списку всіх шаблонів.
     * <p>
     * Ви можете переглядати великий список частинами, використовуючи параметри "offset" і "limit". Якщо
     * повернуто менше ніж "limit" шаблонів — значить, ви досягли кінця списку.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#template-list
     * @throws ApiException when the API returns an error
     */
    public TemplateListResponse list(TemplateListRequest request) {
        return TemplateListResponse.fromMap(client.call("/template/list.json", request.toMap()));
    }

    /**
     * Видаляє шаблон за ідентифікатором.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#template-delete
     * @throws ApiException when the API returns an error
     */
    public SuccessResponse delete(TemplateDeleteRequest request) {
        return SuccessResponse.fromMap(client.call("/template/delete.json", request.toMap()));
    }
}
