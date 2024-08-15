<%@ page import="com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO" %>
<%@ page import="com.sahapwnz.tennisscoreapp.util.PointConverterUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    MatchScoreDTO match = (MatchScoreDTO) request.getAttribute("match");
%>

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
            <li><a href="main.jsp">Домашняя страница</a></li>
            <li><a href="matches.jsp">Все матчи</a></li>
        </ul>
    </nav>
</header>

<main>
    <div class="match-table">
        <table>
            <thead>
            <tr>
                <th></th>
                <th>Игрок 1: ${match.player1.name}</th>
                <th>Игрок 2: ${match.player2.name}</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Сеты</td>
                <td><span class="score">${match.player1.set}</span></td>
                <td><span class="score">${match.player2.set}</span></td>
            </tr>
            <tr>
                <td>Геймы</td>
                <td><span class="score">${match.player1.game}</span></td>
                <td><span class="score">${match.player2.game}</span></td>
            </tr>
            <tr>
                <td>Очки</td>
                <td><span class="score"><%= PointConverterUtil.pointConverter(match.getPlayer1(), match.getPlayer2()) %></span>
                </td>
                <td><span class="score"><%= PointConverterUtil.pointConverter(match.getPlayer2(), match.getPlayer1()) %></span>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="score-buttons">
        <form action="match-score?uuid=${uuid}" method="post">
            <input type="hidden" name="playerId" value="${match.player1.id}">
            <button class="add-point-player1" type="submit">Добавить очко Игроку 1</button>
        </form>
        <form action="match-score?uuid=${uuid}" method="post">
            <input type="hidden" name="playerId" value="${match.player2.id}">
            <button class="add-point-player2" type="submit">Добавить очко Игроку 2</button>
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