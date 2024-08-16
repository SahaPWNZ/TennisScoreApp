<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sahapwnz.tennisscoreapp.dto.MatchResponceDTO" %>

<%
    String playerName = (String)session.getAttribute("playerName");
    List<MatchResponceDTO> matches = (List<MatchResponceDTO>) session.getAttribute("matches");
    int pageNumber = (int) session.getAttribute("pageNumber");
    int totalPages = (int) session.getAttribute("totalPage");
    session.invalidate();
%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Сыгранные матчи</title>
    <link rel="stylesheet" href="">
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="main.jsp">Домашняя страница</a></li>
            <li><a href="/new-match">Начать новый матч</a></li>
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
            <th>Победитель</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (MatchResponceDTO match : matches) {
        %>
        <tr>
            <td><%= match.getPlayer1Name() %></td>
            <td><%= match.getPlayer2Name() %></td>
            <td><%= match.getWinnerName() %></td>
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