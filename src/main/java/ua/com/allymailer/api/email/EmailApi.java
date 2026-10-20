package ua.com.allymailer.api.email;

import java.util.Map;
import ua.com.allymailer.api.email.model.EmailSendRequest;
import ua.com.allymailer.api.email.model.EmailSendResponse;
import ua.com.allymailer.api.email.model.EmailSubscribeRequest;
import ua.com.allymailer.client.ApiClient;
import ua.com.allymailer.client.ApiException;
import ua.com.allymailer.common.model.SuccessResponse;

/** Ця група методів пов'язана з надсиланням email. */
public class EmailApi {
    private final ApiClient client;

    public EmailApi(ApiClient client) {
        this.client = client;
    }

    /**
     * Метод для надсилання листів вашим підписникам.
     * <p>
     * Під час надсилання ви можете використовувати підстановки змінних, шаблони, увімкнути відстеження
     * прочитань або переходів за посиланнями та багато іншого.
     * <p>
     * Обмеження:
     * * максимальний розмір запиту — 10 MB
     * * максимальна кількість отримувачів (recipients) — 500 email
     * * у назві вкладень заборонено символ '/'
     * <p>
     * Якщо під час надсилання листа у списку отримувачів будуть некоректно введені, неіснуючі, повторювані
     * або відписані адреси, вони будуть повернуті у відповіді за допомогою параметра failed_emails, лист
     * же буде надіслано на всі інші прийнятні адреси. Якщо всі адреси потраплять до failed_emails,
     * надсилання здійснено не буде, буде повернуто помилку з API-кодом 204.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#email-send
     * @throws ApiException when the API returns an error
     */
    public EmailSendResponse send(EmailSendRequest request) {
        return EmailSendResponse.fromMap(client.call("/email/send.json", request.toMap()));
    }

    /**
     * Надіслати посилання на (пере)підписку.
     * <p>
     * Метод дозволяє повторно підписати колишнього підписника, який відписався раніше, був заблокований
     * через скарги або чия адреса недоступна з якоїсь іншої причини.
     * <p>
     * Під час виклику надсилається лист у нейтральному дизайні з посиланням підписки. При переході за
     * посиланням з email підписник перестає бути недоступним для користувача та/або перестає бути
     * глобально відписаним.
     * <p>
     * За замовчуванням дозволено лише одне надсилання листа повторної підписки на добу. Якщо вам потрібно
     * більше — напишіть у техпідтримку.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#email-subscribe
     * @throws ApiException when the API returns an error
     */
    public SuccessResponse subscribe(EmailSubscribeRequest request) {
        return SuccessResponse.fromMap(client.call("/email/subscribe.json", request.toMap()));
    }
}
