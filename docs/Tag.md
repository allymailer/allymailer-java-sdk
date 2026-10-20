# Tag

[До списку розділів](../README.md)

Методи керування користувацькими мітками. За допомогою міток ви можете класифікувати листи за потрібними критеріями. Відокремити маркетингові листи від транзакційних або листи з підтвердженням реєстрації від сповіщень про замовлення. AllyMailer дозволяє позначати мітками кожне вихідне повідомлення, а потім сегментувати й аналізувати статистику на основі зазначених під час надсилання міток.

`ua.com.allymailer.api.tag.TagApi`, `client.tag()`

| Метод | Ендпоінт | Опис |
|---|---|---|
| [`list`](#list) | `POST /tag/list.json` | Метод без параметрів, повертає список усіх користувацьких міток. |
| [`delete`](#delete) | `POST /tag/delete.json` | Видаляє мітку. |

## list

`POST /tag/list.json` · [Документація](https://docs.allymailer.com.ua/ua/web-api-ref#tag-list)

Метод без параметрів, повертає список усіх користувацьких міток.

### Запит

Метод не має параметрів.

### Відповідь: `TagListResponse`

| Поле | Тип | Опис |
|---|---|---|
| `status` | `String` | Рядок "success". (`success`) |
| `tags` | `List<TagsResponseObject>` | Масив об'єктів з даними користувацьких міток. |

### Приклад

```java
import ua.com.allymailer.AllyMailer;
import ua.com.allymailer.AllyMailerClient;
import ua.com.allymailer.api.tag.model.TagListResponse;

public class Example {
    public static void main(String[] args) {
        AllyMailerClient client = AllyMailer.client("YOUR_API_KEY");

        TagListResponse response = client.tag().list();
        System.out.println(response.getTags());
    }
}
```

## delete

`POST /tag/delete.json` · [Документація](https://docs.allymailer.com.ua/ua/web-api-ref#tag-delete)

Видаляє мітку.

### Запит: `TagDeleteRequest`

| Поле | Тип | Обов'язкове | Опис |
|---|---|---|---|
| `tagId` | `Integer` | так | Унікальний id мітки. |

### Відповідь: `SuccessResponse`

| Поле | Тип | Опис |
|---|---|---|
| `status` | `String` | Рядок "success". (`success`) |

### Приклад

```java
import ua.com.allymailer.AllyMailer;
import ua.com.allymailer.AllyMailerClient;
import ua.com.allymailer.api.tag.model.TagDeleteRequest;
import ua.com.allymailer.common.model.SuccessResponse;

public class Example {
    public static void main(String[] args) {
        AllyMailerClient client = AllyMailer.client("YOUR_API_KEY");

        SuccessResponse response = client.tag().delete(new TagDeleteRequest()
            .setTagId(54));
        System.out.println(response);
    }
}
```
