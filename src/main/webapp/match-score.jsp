<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Матч</title>
    <link rel="stylesheet" href="css/match-score.css">
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
    <div class="match-table">
        <table>
            <thead>
            <tr>
                <th></th>
                <th>Игрок 1</th>
                <th>Игрок 2</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Сет 1</td>
                <td><span class="score">0</span></td>
                <td><span class="score">0</span></td>
            </tr>
            <tr>
                <td>Гейм 1</td>
                <td><span class="score">0</span></td>
                <td><span class="score">0</span></td>
            </tr>
            <tr>
                <td>Счёт</td>
                <td><span class="score">0</span></td>
                <td><span class="score">0</span></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="score-buttons">
        <button class="add-point-player1">Добавить очко Игроку 1</button>
        <button class="add-point-player2">Добавить очко Игроку 2</button>
    </div>
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