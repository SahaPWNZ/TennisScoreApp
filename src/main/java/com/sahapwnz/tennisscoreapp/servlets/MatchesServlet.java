package com.sahapwnz.tennisscoreapp.servlets;

import com.sahapwnz.tennisscoreapp.service.MatchesPaginationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/matches")
public class MatchesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerName = req.getParameter("filter_by_player_name");
        String pageParam = req.getParameter("page");

        MatchesPaginationService matchesPaginationService = new MatchesPaginationService(playerName, pageParam);

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("playerName", playerName );
        httpSession.setAttribute("matches", matchesPaginationService.getListOfMatches());
        httpSession.setAttribute("pageNumber", matchesPaginationService.getPageNumber());
        httpSession.setAttribute("totalPage", matchesPaginationService.getTotalPageNumber());

        req.getRequestDispatcher("/matches.jsp").forward(req, resp);
    }


}
