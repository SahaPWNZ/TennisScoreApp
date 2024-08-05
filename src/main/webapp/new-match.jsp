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
            <li><a href="#">Домашняя страница</a></li>
            <li><a href="#">Все матчи</a></li>
        </ul>
    </nav>
</header>

<main>
    <h1 class="page-title">Начало матча</h1>

    <div class="form-container">
        <div class="form-player">
            <h2>Игрок 1</h2>
            <input type="text" placeholder="Введите имя игрока">
        </div>

        <div class="form-player">
            <h2>Игрок 2</h2>
            <input type="text" placeholder="Введите имя игрока">
        </div>
    </div>

    <button class="start-match">Начать матч</button>
</main>

<footer>
    <div class="footer-links">
        <a href="#">
            <img src="logo1.png" alt="Логотип 1">
        </a>
        <a href="#">
            <img src="logo2.png" alt="Логотип 2">
        </a>
    </div>
</footer>
</body>
</html>