package ua.com.allymailer.api.system;

import java.util.Map;
import ua.com.allymailer.api.system.model.SystemInfoResponse;
import ua.com.allymailer.api.system.model.SystemPingResponse;
import ua.com.allymailer.client.ApiClient;
import ua.com.allymailer.client.ApiException;

/** Системні методи. */
public class SystemApi {
    private final ApiClient client;

    public SystemApi(ApiClient client) {
        this.client = client;
    }

    /**
     * Перевіряє валідність API-ключа та повертає ідентифікатор користувача.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#system-ping
     * @throws ApiException when the API returns an error
     */
    public SystemPingResponse ping() {
        return SystemPingResponse.fromMap(client.call("/system/ping.json", null));
    }

    /**
     * Повертає інформацію про користувача або проєкт за API-ключем.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#system-info
     * @throws ApiException when the API returns an error
     */
    public SystemInfoResponse info() {
        return SystemInfoResponse.fromMap(client.call("/system/info.json", null));
    }
}
