package com.sahapwnz.tennisscoreapp.service;

import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerScoreDTO;

public class MatchScoreCalculationService {
    private static void clearPlayersPoints(PlayerScoreDTO player1, PlayerScoreDTO player2) {
        player1.setPoint(0);
        player2.setPoint(0);
    }

    private static void clearPlayersGames(PlayerScoreDTO player1, PlayerScoreDTO player2) {
        player1.setGame(0);
        player2.setGame(0);
    }

    public static void winOnePoint(MatchScoreDTO matchScoreDTO, Long id) {
        PlayerScoreDTO playerWinner = matchScoreDTO.getPlayerScoreDTOonId(id);
        playerWinner.wonPoint();
        checkGame(playerWinner, matchScoreDTO.getOponnentPlayerScoreDTO(playerWinner));
    }


    private static void checkGame(PlayerScoreDTO playerWinner, PlayerScoreDTO opponent) {
        if (playerWinner.getGame() == 6 && opponent.getGame() == 6) {

            playTieBreak(playerWinner, opponent);

        } else if (playerWinner.getPoint() >= 4 && opponent.getPoint() >= 3) {
            if (playerWinner.getPoint() - opponent.getPoint() == 2) {

                playerWinner.wonGame();
                clearPlayersPoints(playerWinner, opponent);
                checkSet(playerWinner, opponent);
            }
        } else if (playerWinner.getPoint() == 4 && opponent.getPoint() < 3) {

            playerWinner.wonGame();
            clearPlayersPoints(playerWinner, opponent);
            checkSet(playerWinner, opponent);
        }
    }

    private static void checkSet(PlayerScoreDTO playerWinner, PlayerScoreDTO opponent) {
        if (playerWinner.getGame() == 6 && opponent.getGame() <= 4 ||
                playerWinner.getGame() == 7 && opponent.getGame() <= 5) {
            playerWinner.wonSet();
            clearPlayersPoints(playerWinner, opponent);
            clearPlayersGames(playerWinner, opponent);
            checkWinnerMatch(playerWinner);
        }
    }

    private static void playTieBreak(PlayerScoreDTO playerWinner, PlayerScoreDTO opponent) {
        if (playerWinner.getPoint() >= 7 && (playerWinner.getPoint() - opponent.getPoint()) >= 2) {
            playerWinner.wonSet();
            clearPlayersPoints(playerWinner, opponent);
            clearPlayersGames(playerWinner, opponent);
            checkWinnerMatch(playerWinner);
        }
    }

    private static void checkWinnerMatch(PlayerScoreDTO playerWinner) {
        if (playerWinner.getSet() == 2) {
            System.out.println("Игрок с id: " + playerWinner.getId() + " ПОбедил");//вызов метода о завершении матча
        }
    }

}

