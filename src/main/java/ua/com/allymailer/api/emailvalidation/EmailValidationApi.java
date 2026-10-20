package ua.com.allymailer.api.emailvalidation;

import java.util.Map;
import ua.com.allymailer.api.emailvalidation.model.EmailValidationSingleRequest;
import ua.com.allymailer.api.emailvalidation.model.EmailValidationSingleResponse;
import ua.com.allymailer.client.ApiClient;
import ua.com.allymailer.client.ApiException;

/**
 * Методи перевірки email-адрес. Перевірка адреси електронної пошти надає докладну інформацію про
 * працездатність email. Це дозволить виключити з надсилання неіснуючі email, знизити показник скарг,
 * очистити список підписників і врешті-решт покращити вашу репутацію як відправника. Наприклад, ви
 * можете інтегрувати процес перевірки у форму реєстрації вашого сайту і вже на етапі введення адреси
 * повідомляти користувачам, що адреса, яку вони ввели у форму, недійсна.
 */
public class EmailValidationApi {
    private final ApiClient client;

    public EmailValidationApi(ApiClient client) {
        this.client = client;
    }

    /**
     * Допускається не більше ніж два одночасні запити; у разі перевищення буде повернуто помилку. Оскільки
     * перевірка має бути швидкою, ми обмежуємо час, що витрачається на перевірку адреси електронної пошти.
     * Тому, якщо ми зіткнемося з повільним поштовим сервером, час відповіді якого перевищує 5 секунд,
     * результат перевірки може бути невідомим.
     * <p>
     * Документація: https://docs.allymailer.com.ua/ua/web-api-ref#email-validation-single
     * @throws ApiException when the API returns an error
     */
    public EmailValidationSingleResponse single(EmailValidationSingleRequest request) {
        return EmailValidationSingleResponse.fromMap(client.call("/email-validation/single.json", request.toMap()));
    }
}
