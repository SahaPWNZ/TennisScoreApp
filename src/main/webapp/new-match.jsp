<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Начало матча</title>
    <link rel="stylesheet" href="css/new-matchCSS.css">
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="main.jsp">Домашняя страница</a></li>
            <li><a href="matches.jsp">Все матчи</a></li>
        </ul>
    </nav>
</header>

<main>
    <h1 class="page-title">Начало матча</h1>

    <div class="form-container">
        <form method="post" action="new-match">
            <div class="form-player">
                <h2>Игрок 1</h2>
                <input type="text" placeholder="Введите имя игрока"
                       id="playerOne" name="playerOne">>
            </div>

            <div class="form-player">
                <h2>Игрок 2</h2>
                <input type="text" placeholder="Введите имя игрока"
                       id="playerTwo" name="playerTwo">
            </div>
            <button class="start-match" type="submit">Начать матч</button>
        </form>
    </div>


</main>

<footer>
    <div class="footer-links">
        <a href="https://t.me/sahapwnz">
            <img src="css/resources/free-icon-telegram-2111646.png" width="45px" height="45px" alt="Логотип tg">
        </a>
        <a href="https://github.com/SahaPWNZ">
            <img src="css/resources/free-icon-git-logo-52040.png" width="45px" height="45px" alt="Логотип git">
        </a>
    </div>
</footer>
</body>
</html>