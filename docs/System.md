# System

[До списку розділів](../README.md)

Системні методи.

`ua.com.allymailer.api.system.SystemApi`, `client.system()`

| Метод | Ендпоінт | Опис |
|---|---|---|
| [`ping`](#ping) | `POST /system/ping.json` | Перевіряє валідність API-ключа та повертає ідентифікатор користувача. |
| [`info`](#info) | `POST /system/info.json` | Повертає інформацію про користувача або проєкт за API-ключем. |

## ping

`POST /system/ping.json` · [Документація](https://docs.allymailer.com.ua/ua/web-api-ref#system-ping)

Перевіряє валідність API-ключа та повертає ідентифікатор користувача.

### Запит

Метод не має параметрів.

### Відповідь: `SystemPingResponse`

| Поле | Тип | Опис |
|---|---|---|
| `status` | `String` | Рядок "success". (`success`) |
| `userId` | `Integer` | Унікальний ідентифікатор користувача. |

### Приклад

```java
import ua.com.allymailer.AllyMailer;
import ua.com.allymailer.AllyMailerClient;
import ua.com.allymailer.api.system.model.SystemPingResponse;

public class Example {
    public static void main(String[] args) {
        AllyMailerClient client = AllyMailer.client("YOUR_API_KEY");

        SystemPingResponse response = client.system().ping();
        System.out.println(response.getUserId());
    }
}
```

## info

`POST /system/info.json` · [Документація](https://docs.allymailer.com.ua/ua/web-api-ref#system-info)

Повертає інформацію про користувача або проєкт за API-ключем.

### Запит

Метод не має параметрів.

### Відповідь: `SystemInfoResponse`

| Поле | Тип | Опис |
|---|---|---|
| `status` | `String` | Рядок "success". (`success`) |
| `userId` | `Integer` | Унікальний ідентифікатор користувача. |
| `email` | `String` | Email користувача. |
| `projectId` | `String` | Унікальний ідентифікатор проєкту, ASCII-рядок до 36 символів завдовжки. Присутній лише якщо API-ключ, використаний для запиту, був API-ключем проєкту. |
| `projectName` | `String` | Назва проєкту, унікальна в межах облікового запису користувача. Присутня лише якщо API-ключ, використаний для запиту, був API-ключем проєкту. |
| `projectAccounting` | `ProjectAccountingObject` | Об'єкт із властивостями лічильника листів. Присутній лише якщо API-ключ, використаний для запиту, був API-ключем проєкту. |
| `accounting` | `SystemInfoResponseAccounting` | Об'єкт з властивостями періоду обліку. Присутній лише якщо API-ключ, використаний для запиту, був API-ключем користувача. |

### Приклад

```java
import ua.com.allymailer.AllyMailer;
import ua.com.allymailer.AllyMailerClient;
import ua.com.allymailer.api.system.model.SystemInfoResponse;

public class Example {
    public static void main(String[] args) {
        AllyMailerClient client = AllyMailer.client("YOUR_API_KEY");

        SystemInfoResponse response = client.system().info();
        System.out.println(response.getUserId());
    }
}
```
