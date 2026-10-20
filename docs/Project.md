# Project

[До списку розділів](../README.md)

Проєкти дозволяють об'єднати кілька незалежних доменів із webhook, шаблонами та списками відписки. Це дуже корисно, якщо у вас є власні клієнти і ви керуєте їхніми даними з одного облікового запису AllyMailer. Кожен проєкт отримує власний ключ API, а виклики методів API з цим ключем обробляють лише дані цього проєкту. Таким чином, ви можете призначити окремий проєкт для кожного користувача і бути впевненими, що вони не конфліктуватимуть: наприклад, відписка від одного проєкту не вплине на інший.

Методи проєктів за замовчуванням вимкнено через заходи захисту від спаму. Щоб їх увімкнути, вам необхідно звернутися до [служби підтримки](https://cp.allymailer.com/ua/support).

Зверніть увагу: за замовчуванням домени для надсилання підтверджуються та використовуються незалежно для основного облікового запису й кожного з проєктів. Але є можливість увімкнути для проєктів використання доменів, підтверджених в основному обліковому записі. Просто попросіть про це [техпідтримку](https://cp.allymailer.com/ua/support).

`ua.com.allymailer.api.project.ProjectApi`, `client.project()`

| Метод | Ендпоінт | Опис |
|---|---|---|
| [`create`](#create) | `POST /project/create.json` | Створити новий проєкт. |
| [`update`](#update) | `POST /project/update.json` | Змінити властивості проєкту. |
| [`list`](#list) | `POST /project/list.json` | Повертає список проєктів. |
| [`delete`](#delete) | `POST /project/delete.json` | Видалити проєкт. |

## create

`POST /project/create.json` · [Документація](https://docs.allymailer.com.ua/ua/web-api-ref#project-create)

Створити новий проєкт.

### Запит: `ProjectCreateRequest`

| Поле | Тип | Обов'язкове | Опис |
|---|---|---|---|
| `project` | `ProjectObject` | так | Об'єкт із властивостями проєкту. |

### Відповідь: `ProjectCreateResponse`

| Поле | Тип | Опис |
|---|---|---|
| `status` | `String` | Рядок "success". (`success`) |
| `projectId` | `String` | Унікальний ідентифікатор проєкту, ASCII-рядок до 36 символів завдовжки. |
| `projectApiKey` | `String` | API-ключ проєкту. Ви можете використовувати цей ключ замість користувацького api_key у всіх методах, крім project-методів. |

### Приклад

```java
import ua.com.allymailer.AllyMailer;
import ua.com.allymailer.api.project.model.ProjectCreateRequest;
import ua.com.allymailer.api.project.model.ProjectObject;

public class Example {
    public static void main(String[] args) {
        var client = AllyMailer.client("YOUR_API_KEY");

        var response = client.project().create(new ProjectCreateRequest()
            .setProject(new ProjectObject()
                    .setName("Project 1A")
                    .setCountry("ES")
                    .setBackendDomainId(1234)
                    .setUnsubscribePageId(1)));
        System.out.println(response.getProjectId());
    }
}
```

## update

`POST /project/update.json` · [Документація](https://docs.allymailer.com.ua/ua/web-api-ref#project-update)

Змінити властивості проєкту.

### Запит: `ProjectUpdateRequest`

| Поле | Тип | Обов'язкове | Опис |
|---|---|---|---|
| `projectId` | `String` |  | Ідентифікатор проєкту, що оновлюється. Проєкт має бути ідентифіковано або цим полем project_id, або полем project_api_key. Ми рекомендуємо використовувати project_id, це безпечніше. |
| `projectApiKey` | `String` |  | Необов'язковий API-ключ проєкту, що оновлюється. Проєкт має бути ідентифіковано або полем project_id, або полем project_api_key. Ми рекомендуємо використовувати project_id, це безпечніше. |
| `project` | `ProjectUpdateObject` | так | Об'єкт із властивостями проєкту. |

### Відповідь: `ProjectUpdateResponse`

| Поле | Тип | Опис |
|---|---|---|
| `status` | `String` | Рядок "success". (`success`) |
| `projectApiKey` | `String` | API-ключ проєкту. Повертається лише в разі, якщо в параметрі запиту був project_api_key. Якщо ж проєкт було ідентифіковано через project_id, то не повертається. |

### Приклад

```java
import ua.com.allymailer.AllyMailer;
import ua.com.allymailer.api.project.model.ProjectUpdateObject;
import ua.com.allymailer.api.project.model.ProjectUpdateRequest;

public class Example {
    public static void main(String[] args) {
        var client = AllyMailer.client("YOUR_API_KEY");

        var response = client.project().update(new ProjectUpdateRequest()
            .setProjectId("1234567890")
            .setProjectApiKey("your api_key")
            .setProject(new ProjectUpdateObject()
                    .setName("Project 1A")
                    .setCountry("ES")
                    .setBackendDomainId(1234)
                    .setUnsubscribePageId(1)));
        System.out.println(response.getProjectApiKey());
    }
}
```

## list

`POST /project/list.json` · [Документація](https://docs.allymailer.com.ua/ua/web-api-ref#project-list)

Повертає список проєктів.

### Запит: `ProjectListRequest`

| Поле | Тип | Обов'язкове | Опис |
|---|---|---|---|
| `projectId` | `String` |  | Опціональна можливість указати project_id для включення до списку лише вказаного проєкту. |
| `projectApiKey` | `String` |  | Опціональна можливість указати project_api_key для включення до списку лише вказаного проєкту. |

### Відповідь: `ProjectListResponse`

| Поле | Тип | Опис |
|---|---|---|
| `status` | `String` | Рядок "success". (`success`) |
| `projects` | `List<ProjectListObject>` | Масив об'єктів, де кожен об'єкт відповідає окремому проєкту. |

### Приклад

```java
import ua.com.allymailer.AllyMailer;
import ua.com.allymailer.api.project.model.ProjectListRequest;

public class Example {
    public static void main(String[] args) {
        var client = AllyMailer.client("YOUR_API_KEY");

        var response = client.project().list(new ProjectListRequest()
            .setProjectId("1234567890")
            .setProjectApiKey("your api_key"));
        System.out.println(response.getProjects());
    }
}
```

## delete

`POST /project/delete.json` · [Документація](https://docs.allymailer.com.ua/ua/web-api-ref#project-delete)

Видалити проєкт.

Деякий час проєкт не видаляється остаточно, і його ще можна відновити — для цього необхідно звернутися в техпідтримку.

### Запит: `ProjectDeleteRequest`

| Поле | Тип | Обов'язкове | Опис |
|---|---|---|---|
| `projectId` | `String` |  | Ідентифікатор проєкту, що видаляється. Проєкт має бути ідентифіковано або цим полем project_id, або полем project_api_key. Ми рекомендуємо використовувати project_id, це безпечніше. |
| `projectApiKey` | `String` |  | Необов'язковий API-ключ проєкту, що видаляється. Проєкт має бути ідентифіковано або полем project_id, або полем project_api_key. Ми рекомендуємо використовувати project_id, це безпечніше. |

### Відповідь: `SuccessResponse`

| Поле | Тип | Опис |
|---|---|---|
| `status` | `String` | Рядок "success". (`success`) |

### Приклад

```java
import ua.com.allymailer.AllyMailer;
import ua.com.allymailer.api.project.model.ProjectDeleteRequest;

public class Example {
    public static void main(String[] args) {
        var client = AllyMailer.client("YOUR_API_KEY");

        var response = client.project().delete(new ProjectDeleteRequest()
            .setProjectId("1234567890")
            .setProjectApiKey("your api_key"));
        System.out.println(response);
    }
}
```
