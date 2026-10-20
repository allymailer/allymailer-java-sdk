package ua.com.allymailer.api.confirmedemail;

import java.util.Map;
import ua.com.allymailer.api.confirmedemail.model.ConfirmedEmailCreateResponse;
import ua.com.allymailer.api.confirmedemail.model.ConfirmedEmailDeleteResponse;
import ua.com.allymailer.api.confirmedemail.model.ConfirmedEmailListResponse;
import ua.com.allymailer.api.confirmedemail.model.ConfirmedEmailRequest;
import ua.com.allymailer.client.ApiClient;
import ua.com.allymailer.client.ApiException;

/**
 * Керування email-адресами, підтвердженими для надсилання із sandbox-домену. Методи доступні лише з
 * API-ключем основного облікового запису.
 */
public class ConfirmedEmailApi {
    private final ApiClient client;

    public ConfirmedEmailApi(ApiClient client) {
        this.client = client;
    }

    /**
     * Adds an email address and sends a confirmation link.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#confirmed-email-create
     * @throws ApiException when the API returns an error
     */
    public ConfirmedEmailCreateResponse create(ConfirmedEmailRequest request) {
        return ConfirmedEmailCreateResponse.fromMap(client.call("/confirmed-email/create.json", request.toMap()));
    }

    /**
     * Lists confirmed and unconfirmed email addresses for the account.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#confirmed-email-list
     * @throws ApiException when the API returns an error
     */
    public ConfirmedEmailListResponse list() {
        return ConfirmedEmailListResponse.fromMap(client.call("/confirmed-email/list.json", null));
    }

    /**
     * Deletes an email address from the account's confirmed email list.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#confirmed-email-delete
     * @throws ApiException when the API returns an error
     */
    public ConfirmedEmailDeleteResponse delete(ConfirmedEmailRequest request) {
        return ConfirmedEmailDeleteResponse.fromMap(client.call("/confirmed-email/delete.json", request.toMap()));
    }
}
