package com.sahapwnz.tennisscoreapp.servlets;

import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.service.FinishedMatchesPersistenceService;
import com.sahapwnz.tennisscoreapp.service.MatchScoreCalculationService;
import com.sahapwnz.tennisscoreapp.service.OngoingMatchesService;
import com.sahapwnz.tennisscoreapp.util.MappingUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/match-score")
public class MatchScoreServlet extends HttpServlet {
    private final FinishedMatchesPersistenceService finishedMatchesPersistenceService = new FinishedMatchesPersistenceService();
    private final OngoingMatchesService ongoingMatchesService = new OngoingMatchesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID uuid = UUID.fromString(req.getParameter("uuid"));

        MatchScoreDTO matchScoreDTO = ongoingMatchesService.getMatchScoreDTO(uuid);

        req.setAttribute("match", matchScoreDTO);
        req.setAttribute("uuid", uuid);

        req.getRequestDispatcher("/match-score.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID uuid = UUID.fromString(req.getParameter("uuid"));
        Long id = Long.parseLong(req.getParameter("playerId"));

        MatchScoreDTO matchScoreDTO = ongoingMatchesService.getMatchScoreDTO(uuid);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, id);

        if (finishedMatchesPersistenceService.isMatchFinished(matchScoreDTO)) {

            Match entityMatch = finishedMatchesPersistenceService.persistFinishedMatch(matchScoreDTO);

            HttpSession session = req.getSession();
            session.setAttribute("MatchDTO", MappingUtil.convertMatchToMatchResponse(entityMatch));
            resp.sendRedirect("/winner-page.jsp");

            ongoingMatchesService.removeMatchScoreDTO(uuid);
        } else {
            resp.sendRedirect("/match-score?uuid=" + uuid);
        }
    }
}
