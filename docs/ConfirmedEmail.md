# ConfirmedEmail

[До списку розділів](../README.md)

Керування email-адресами, підтвердженими для надсилання із sandbox-домену. Методи доступні лише з API-ключем основного облікового запису.

`ua.com.allymailer.api.confirmedemail.ConfirmedEmailApi`, `client.confirmedEmail()`

| Метод | Ендпоінт | Опис |
|---|---|---|
| [`create`](#create) | `POST /confirmed-email/create.json` | Adds an email address and sends a confirmation link. |
| [`list`](#list) | `POST /confirmed-email/list.json` | Lists confirmed and unconfirmed email addresses for the account. |
| [`delete`](#delete) | `POST /confirmed-email/delete.json` | Deletes an email address from the account's confirmed email list. |

## create

`POST /confirmed-email/create.json` · [Документація](https://docs.allymailer.com.ua/ua/web-api-ref#confirmed-email-create)

Adds an email address and sends a confirmation link.

### Запит: `ConfirmedEmailRequest`

| Поле | Тип | Обов'язкове | Опис |
|---|---|---|---|
| `email` | `String` | так | Email address to add or delete. |

### Відповідь: `ConfirmedEmailCreateResponse`

| Поле | Тип | Опис |
|---|---|---|
| `status` | `String` | Рядок "success". (`success`) |
| `confirmedEmail` | `ConfirmedEmail` |  |

### Приклад

```java
import ua.com.allymailer.AllyMailer;
import ua.com.allymailer.api.confirmedemail.model.ConfirmedEmailRequest;

public class Example {
    public static void main(String[] args) {
        var client = AllyMailer.client("YOUR_API_KEY");

        var response = client.confirmedEmail().create(new ConfirmedEmailRequest()
            .setEmail("dev@example.com"));
        System.out.println(response.getConfirmedEmail());
    }
}
```

## list

`POST /confirmed-email/list.json` · [Документація](https://docs.allymailer.com.ua/ua/web-api-ref#confirmed-email-list)

Lists confirmed and unconfirmed email addresses for the account.

### Запит

Метод не має параметрів.

### Відповідь: `ConfirmedEmailListResponse`

| Поле | Тип | Опис |
|---|---|---|
| `status` | `String` | Рядок "success". (`success`) |
| `confirmedEmails` | `List<ConfirmedEmail>` |  |

### Приклад

```java
import ua.com.allymailer.AllyMailer;

public class Example {
    public static void main(String[] args) {
        var client = AllyMailer.client("YOUR_API_KEY");

        var response = client.confirmedEmail().list();
        System.out.println(response.getConfirmedEmails());
    }
}
```

## delete

`POST /confirmed-email/delete.json` · [Документація](https://docs.allymailer.com.ua/ua/web-api-ref#confirmed-email-delete)

Deletes an email address from the account's confirmed email list.

### Запит: `ConfirmedEmailRequest`

| Поле | Тип | Обов'язкове | Опис |
|---|---|---|---|
| `email` | `String` | так | Email address to add or delete. |

### Відповідь: `ConfirmedEmailDeleteResponse`

| Поле | Тип | Опис |
|---|---|---|
| `status` | `String` | Рядок "success". (`success`) |
| `message` | `String` |  |

### Приклад

```java
import ua.com.allymailer.AllyMailer;
import ua.com.allymailer.api.confirmedemail.model.ConfirmedEmailRequest;

public class Example {
    public static void main(String[] args) {
        var client = AllyMailer.client("YOUR_API_KEY");

        var response = client.confirmedEmail().delete(new ConfirmedEmailRequest()
            .setEmail("dev@example.com"));
        System.out.println(response.getMessage());
    }
}
```
