<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sahapwnz.tennisscoreapp.entity.Match" %>
<%@ page import="com.sahapwnz.tennisscoreapp.dao.MatchDAO" %>
<%
    String playerName = request.getParameter("filter_by_player_name");
    String pageParam = request.getParameter("page");
    int pageNumber = (pageParam != null) ? Integer.parseInt(pageParam) : 1;

    MatchService matchService = new MatchService();
    List<Match> matches;
    int totalMatches;
    int totalPages;

    if (playerName != null && !playerName.isEmpty()) {
        matches = matchService.getMatchesByPlayerName(playerName, pageNumber);
        totalMatches = matchService.getTotalMatchesByPlayerName(playerName);
    } else {
        matches = matchService.getAllMatches(pageNumber);
        totalMatches = matchService.getTotalMatches();
    }

    totalPages = (int) Math.ceil((double) totalMatches / 10); // Предположим, что на странице 10 матчей
%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Сыгранные матчи</title>
    <link rel="stylesheet" href="styles.css">
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
    <h1>Сыгранные матчи</h1>

    <form action="/matches" method="get">
        <input type="text" name="filter_by_player_name" placeholder="Имя игрока" value="<%= playerName != null ? playerName : "" %>">
        <button type="submit">Искать</button>
    </form>

    <table>
        <thead>
        <tr>
            <th>Игрок 1</th>
            <th>Игрок 2</th>
            <th>Счет</th>
            <th>Дата</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Match match : matches) {
        %>
        <tr>
            <td><%= match.getPlayer1().getName() %></td>
            <td><%= match.getPlayer2().getName() %></td>
            <td><%= match.getScore() %></td>
            <td><%= match.getDate() %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <div class="pagination">
        <%
            if (totalPages > 1) {
                for (int i = 1; i <= totalPages; i++) {
        %>
        <a href="/matches?page=<%= i %>&filter_by_player_name=<%= playerName != null ? playerName : "" %>"><%= i %></a>
        <%
                }
            }
        %>
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