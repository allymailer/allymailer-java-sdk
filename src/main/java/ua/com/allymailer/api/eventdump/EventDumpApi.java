package ua.com.allymailer.api.eventdump;

import java.util.Map;
import ua.com.allymailer.api.eventdump.model.EventDumpCreateRequest;
import ua.com.allymailer.api.eventdump.model.EventDumpCreateResponse;
import ua.com.allymailer.api.eventdump.model.EventDumpDeleteRequest;
import ua.com.allymailer.api.eventdump.model.EventDumpGetRequest;
import ua.com.allymailer.api.eventdump.model.EventDumpGetResponse;
import ua.com.allymailer.api.eventdump.model.EventDumpListResponse;
import ua.com.allymailer.client.ApiClient;
import ua.com.allymailer.client.ApiException;
import ua.com.allymailer.common.model.SuccessResponse;

/**
 * Методи для отримання списку подій, що сталися, за певний період. Дані зберігаються до 45 днів,
 * залежно від вашого тарифу. Це означає, що можна запросити події, починаючи з 00:00:00 45-го дня тому
 * і до поточного моменту часу. Для індивідуальних тарифів з великими обсягами за замовчуванням події
 * доступні лише за останні 7 днів.
 */
public class EventDumpApi {
    private final ApiClient client;

    public EventDumpApi(ApiClient client) {
        this.client = client;
    }

    /**
     * Асинхронний метод, який ініціює підготовку для завантаження файлів дампа у форматі CSV. Максимальна
     * кількість збережених/створюваних дампів обмежена десятьма. У разі досягнення ліміту для запиту на
     * підготовку нового дампа потрібно видалити старі. Час зберігання сформованого дампа — 8 годин, після
     * чого він автоматично видаляється. Якщо період запиту даних більший за добу або подій багато, буде
     * сформовано декілька файлів, у кожному з яких буде не більше ніж 100 000 подій. Файл містить колонки
     * з такою інформацією — 'event_time', 'job_id', 'from_email', 'email', 'status', 'delivery_status',
     * 'metadata', 'destination_response', 'user_agent', 'url', 'ip', 'tags' і 'project_id' (якщо у
     * користувача увімкнено проєкти). Ви можете відфільтрувати поля та змінити їх порядок, а також додати
     * поле 'subject' за допомогою параметра 'dump_fileds'.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#event-dump-create
     * @throws ApiException when the API returns an error
     */
    public EventDumpCreateResponse create(EventDumpCreateRequest request) {
        return EventDumpCreateResponse.fromMap(client.call("/event-dump/create.json", request.toMap()));
    }

    /**
     * Повертає властивості дампа за його ідентифікатором.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#event-dump-get
     * @throws ApiException when the API returns an error
     */
    public EventDumpGetResponse get(EventDumpGetRequest request) {
        return EventDumpGetResponse.fromMap(client.call("/event-dump/get.json", request.toMap()));
    }

    /**
     * Метод без параметрів, повертає список усіх дампів подій.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#event-dump-list
     * @throws ApiException when the API returns an error
     */
    public EventDumpListResponse list() {
        return EventDumpListResponse.fromMap(client.call("/event-dump/list.json", null));
    }

    /**
     * Видаляє дамп із черги та/або зі сховища.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#event-dump-delete
     * @throws ApiException when the API returns an error
     */
    public SuccessResponse delete(EventDumpDeleteRequest request) {
        return SuccessResponse.fromMap(client.call("/event-dump/delete.json", request.toMap()));
    }
}
