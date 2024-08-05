package com.sahapwnz.tennisscoreapp;

import java.io.*;

import com.sahapwnz.tennisscoreapp.dao.MatchDAO;
import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import com.sahapwnz.tennisscoreapp.util.HibernateUtil;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebServlet(name = "main", value = "/main")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var matchDAO = new MatchDAO();
        for (Match match : matchDAO.findAll()) {
            System.out.println("Match ID: " + match.getId());
            System.out.println("Player1: " + match.getPlayer1());
            System.out.println("Player1: " + match.getPlayer2());
            System.out.println("-----------------------");
        }
        response.sendRedirect("/TennisScoreApp_war_exploded/main.jsp");
    }
}