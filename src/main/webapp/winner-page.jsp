<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.sahapwnz.tennisscoreapp.dto.MatchResponceDTO" %>

<%
    MatchResponceDTO matchDTO = (MatchResponceDTO) session.getAttribute("MatchDTO");
    session.invalidate();
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Матч Завершён</title>
    <link rel="stylesheet" href="css/winner-page.css">
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="main.jsp">Домашняя страница</a></li>
            <li><a href="matches">Все матчи</a></li>
        </ul>
    </nav>
</header>

<main>
    <div class="match-info">
        <h1>Матч Завершён</h1>
        <p>Игрок 1: <strong><%= matchDTO.getPlayer1Name() %>
        </strong></p>
        <p>Игрок 2: <strong><%= matchDTO.getPlayer2Name() %>
        </strong></p>
        <p class="winner-name">Победитель: <strong><%= matchDTO.getWinnerName() %>
        </strong></p>
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