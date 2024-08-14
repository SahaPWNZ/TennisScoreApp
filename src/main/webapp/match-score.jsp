<%@ page import="com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    MatchScoreDTO match = (MatchScoreDTO) request.getAttribute("match");
%>
<%!
    String pointConverterForFirst(MatchScoreDTO match){
        int pointsFirstPlayer = match.getPlayer1().getPoint();
        int pointsOpponent = match.getPlayer2().getPoint();
        if(match.getPlayer1().getGame()==6 && match.getPlayer2().getGame()==6){
            return ""+pointsFirstPlayer;
        }
        if (pointsFirstPlayer >=3 && pointsOpponent >=3){
            if(pointsFirstPlayer == pointsOpponent){
                return "40";
            }
            else if (pointsFirstPlayer>pointsOpponent){
                return "advantage";
            }
            else {
                return "40";
            }

        }
       else {
           switch (pointsFirstPlayer){
               case 0: return "0";
               case 1: return "15";
               case 2: return "30";
               case 3: return "40";
               default: return "error";
           }
        }
    }
    String pointConverterForSecond(MatchScoreDTO match){
        int pointsFirstPlayer = match.getPlayer2().getPoint();
        int pointsOpponent = match.getPlayer1().getPoint();
        if(match.getPlayer1().getGame()==6 && match.getPlayer2().getGame()==6){
            return ""+pointsFirstPlayer;
        }
        if (pointsFirstPlayer >=3 && pointsOpponent >=3){
            if(pointsFirstPlayer == pointsOpponent){
                return "40";
            }
            else if (pointsFirstPlayer>pointsOpponent){
                return "advantage";
            }
            else {
                return "40";
            }

        }
        else {
            switch (pointsFirstPlayer){
                case 0: return "0";
                case 1: return "15";
                case 2: return "30";
                case 3: return "40";
                default: return "error";
            }
        }
    }
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
                <td>Сеты </td>
                <td><span class="score">${match.player1.set}</span></td>
                <td><span class="score">${match.player2.set}</span></td>
            </tr>
            <tr>
                <td>Геймы </td>
                <td><span class="score">${match.player1.game}</span></td>
                <td><span class="score">${match.player2.game}</span></td>
            </tr>
            <tr>
                <td>Очки</td>
                <td><span class="score"><%= pointConverterForFirst(match) %></span></td>
                <td><span class="score"><%= pointConverterForSecond(match) %></span></td>
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