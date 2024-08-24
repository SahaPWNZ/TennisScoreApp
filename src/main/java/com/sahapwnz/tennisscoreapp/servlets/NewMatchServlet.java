package com.sahapwnz.tennisscoreapp.servlets;

import com.sahapwnz.tennisscoreapp.dao.PlayerDAO;
import com.sahapwnz.tennisscoreapp.dto.PlayerRequestDTO;
import com.sahapwnz.tennisscoreapp.service.OngoingMatchesService;
import com.sahapwnz.tennisscoreapp.util.ValidationUtil;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {
    private final OngoingMatchesService ongoingMatchesService = new OngoingMatchesService();

    @Override
    public void init(ServletConfig config) throws ServletException {
        PlayerDAO playerDAO = new PlayerDAO();
        playerDAO.findById(1L);
    }

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/new-match.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlayerRequestDTO playerOneDTO = PlayerRequestDTO.builder().
                name(req.getParameter("playerOne")).
                build();
        PlayerRequestDTO playerTwoDTO = PlayerRequestDTO.builder().
                name(req.getParameter("playerTwo")).
                build();

        ValidationUtil.namesValidation(playerOneDTO, playerTwoDTO);

        UUID uuid = ongoingMatchesService.addNewMatchScoreDTO(playerOneDTO, playerTwoDTO);
        resp.sendRedirect("/match-score?uuid=" + uuid);
    }
}
