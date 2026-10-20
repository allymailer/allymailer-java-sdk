package ua.com.allymailer.api.project;

import java.util.Map;
import ua.com.allymailer.api.project.model.ProjectCreateRequest;
import ua.com.allymailer.api.project.model.ProjectCreateResponse;
import ua.com.allymailer.api.project.model.ProjectDeleteRequest;
import ua.com.allymailer.api.project.model.ProjectListRequest;
import ua.com.allymailer.api.project.model.ProjectListResponse;
import ua.com.allymailer.api.project.model.ProjectUpdateRequest;
import ua.com.allymailer.api.project.model.ProjectUpdateResponse;
import ua.com.allymailer.client.ApiClient;
import ua.com.allymailer.client.ApiException;
import ua.com.allymailer.common.model.SuccessResponse;

/**
 * Проєкти дозволяють об'єднати кілька незалежних доменів із webhook, шаблонами та списками відписки.
 * Це дуже корисно, якщо у вас є власні клієнти і ви керуєте їхніми даними з одного облікового запису
 * AllyMailer. Кожен проєкт отримує власний ключ API, а виклики методів API з цим ключем обробляють
 * лише дані цього проєкту. Таким чином, ви можете призначити окремий проєкт для кожного користувача і
 * бути впевненими, що вони не конфліктуватимуть: наприклад, відписка від одного проєкту не вплине на
 * інший.
 * <p>
 * Методи проєктів за замовчуванням вимкнено через заходи захисту від спаму. Щоб їх увімкнути, вам
 * необхідно звернутися до [служби підтримки](https://cp.allymailer.com/ua/support).
 * <p>
 * Зверніть увагу: за замовчуванням домени для надсилання підтверджуються та використовуються незалежно
 * для основного облікового запису й кожного з проєктів. Але є можливість увімкнути для проєктів
 * використання доменів, підтверджених в основному обліковому записі. Просто попросіть про це
 * [техпідтримку](https://cp.allymailer.com/ua/support).
 */
public class ProjectApi {
    private final ApiClient client;

    public ProjectApi(ApiClient client) {
        this.client = client;
    }

    /**
     * Створити новий проєкт.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#project-create
     * @throws ApiException when the API returns an error
     */
    public ProjectCreateResponse create(ProjectCreateRequest request) {
        return ProjectCreateResponse.fromMap(client.call("/project/create.json", request.toMap()));
    }

    /**
     * Змінити властивості проєкту.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#project-update
     * @throws ApiException when the API returns an error
     */
    public ProjectUpdateResponse update(ProjectUpdateRequest request) {
        return ProjectUpdateResponse.fromMap(client.call("/project/update.json", request.toMap()));
    }

    /**
     * Повертає список проєктів.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#project-list
     * @throws ApiException when the API returns an error
     */
    public ProjectListResponse list(ProjectListRequest request) {
        return ProjectListResponse.fromMap(client.call("/project/list.json", request.toMap()));
    }

    /**
     * Видалити проєкт.
     * <p>
     * Деякий час проєкт не видаляється остаточно, і його ще можна відновити — для цього необхідно
     * звернутися в техпідтримку.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#project-delete
     * @throws ApiException when the API returns an error
     */
    public SuccessResponse delete(ProjectDeleteRequest request) {
        return SuccessResponse.fromMap(client.call("/project/delete.json", request.toMap()));
    }
}
