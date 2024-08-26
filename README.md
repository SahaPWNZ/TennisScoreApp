

# Tennis scoreboard Project

## Обзор и мотивация создания проекта

- Создать клиент-серверное приложение с веб-интерфейсом
- Получить практический опыт работы с ORM Hibernate
- Сверстать простой веб-интерфейс без сторонних библиотек
- Познакомиться с архитектурным паттерном MVC(S)

Проект создан в образовательных целях
по [предоставленному ТЗ](https://zhukovsd.github.io/java-backend-learning-course/projects/tennis-scoreboard/)
в контексте [java-backend-learning-course](https://zhukovsd.github.io/java-backend-learning-course/#%D1%82%D1%80%D0%B5%D0%B1%D1%83%D0%B5%D0%BC%D1%8B%D0%B5-%D0%B7%D0%BD%D0%B0%D0%BD%D0%B8%D1%8F-%D0%B8-%D1%82%D0%B5%D1%85%D0%BD%D0%BE%D0%BB%D0%BE%D0%B3%D0%B8%D0%B8)
от Сергея Жукова.

## Используемые технологии/инструменты:

- Jakarta Servlets
- Maven
- Hibernate
- SQL
- H2
- JSP
- HTML/CSS
- JUnit5

## Установка

### Требования
+ Java 21+
+ Apache Maven
+ Tomcat 10
+ Intellij IDEA

### Запуск проекта локально

1. Клонировать репозиторий и открыть проект в Intellij IDEA
   ```
   git clone https://github.com/SahaPWNZ/TennisScoreApp

   ```
2. Далее в Intellij IDEA выбрать select Run -> Edit Configuration.
3. Нажимаем на Add new configuration, там выбираем tomcat и его настраиваем
4. Далее там же в настройках tomcat нажимаем на "fix" и добавляем "war exploded"
5. Запускаем проект
## Использование и функционал проекта
Деплой проекта: пока без деплоя( 

стартовая страница: можно начать "новый матч" или посмотреть список завершённых матчей (которые загружаются из sql скрипта при старте проекта) 
![img.png](../imagesForGit/image/img.png)


страница нового матча: позволяет добавить игроков в бд которых нет, и начать матч, также есть валидация на ввод имени только из латинских символов
![img_1.png](../imagesForGit/image/img_1.png)

страница текущего матча: функионал подсчёта очков, а также вызова страницы победителя когда кто-то из игроков набирает 3 победных сета
![img_2.png](../imagesForGit/image/img_2.png)

страница с завершёнными матчами: с реализованным поисском по имени и пагинацией страниц
![img_3.png](../imagesForGit/image/img_3.png)
