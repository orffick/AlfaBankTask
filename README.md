
### Задание
Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:
если курс по отношению к рублю за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich
если ниже - отсюда https://giphy.com/search/broke
Ссылки
REST API курсов валют - https://docs.openexchangerates.org/
REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide
Must Have
Сервис на Spring Boot 2 + Java / Kotlin
Запросы приходят на HTTP endpoint, туда передается код валюты
Для взаимодействия с внешними сервисами используется Feign
Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки
На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)
Для сборки должен использоваться Gradle
Результатом выполнения должен быть репо на GitHub с инструкцией по запуску
Nice to Have
Сборка и запуск Docker контейнера с этим сервисом

---

### Endpoints:

* /api/*
    
  по умолчанию возвращает гифку для USD

* /api/gif/{base} 

  возвращает гифку для валюты, переданной параметром base

---

### Запуск
```
java -jar currencyChecker-1.0.0.jar
```
---

### Сборка и запуск Docker контейнера с этим сервисом

Сборка:
```
docker build -t currency_checker_image .
```

Запуск:
```
docker run -p 9090:9090 currency_checker_image
```

