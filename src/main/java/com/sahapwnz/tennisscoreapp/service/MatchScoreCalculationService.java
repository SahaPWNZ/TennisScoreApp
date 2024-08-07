package com.sahapwnz.tennisscoreapp.service;

import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerScoreDTO;

public class MatchScoreCalculationService {
    private void clearPlayersPoints(PlayerScoreDTO player1, PlayerScoreDTO player2) {
        player1.setPoint(0);
        player2.setPoint(0);
    }

    private void clearPlayersGames(PlayerScoreDTO player1, PlayerScoreDTO player2) {
        player1.setGame(0);
        player2.setGame(0);
    }

    public void winOnePoint(MatchScoreDTO matchScoreDTO, Long id) {
        PlayerScoreDTO playerWinner = matchScoreDTO.getPlayerScoreDTOonId(id);
        playerWinner.wonPoint();
        checkGame(playerWinner, matchScoreDTO.getOponnentPlayerScoreDTO(playerWinner));
    }


    private void checkGame(PlayerScoreDTO playerWinner, PlayerScoreDTO opponent) {
        if (playerWinner.getGame() == 6 && opponent.getGame() == 6) {

            playTieBreak(playerWinner, opponent);

        } else if (playerWinner.getPoint() >= 4 && opponent.getPoint() >= 4) {
            if (playerWinner.getPoint() - opponent.getPoint() == 2) {

                playerWinner.wonGame();
                clearPlayersPoints(playerWinner, opponent);
                checkSet(playerWinner, opponent);
            }
        } else if (playerWinner.getPoint() == 4 && opponent.getPoint() < 3) {

            playerWinner.wonGame();
            clearPlayersPoints(playerWinner, opponent);
            checkSet(playerWinner, opponent);
//
        }
    }

    private void checkSet(PlayerScoreDTO playerWinner, PlayerScoreDTO opponent) {
        if (playerWinner.getGame() == 6 && opponent.getGame() <= 4) {
            playerWinner.wonSet();
            clearPlayersPoints(playerWinner, opponent);
            clearPlayersGames(playerWinner, opponent);
            checkWinnerMatch(playerWinner);
        }
    }

    private void playTieBreak(PlayerScoreDTO playerWinner, PlayerScoreDTO opponent) {
        if (playerWinner.getPoint() >= 6 && (playerWinner.getPoint() - opponent.getPoint()) >= 2) {
            playerWinner.wonSet();
            clearPlayersPoints(playerWinner, opponent);
            clearPlayersGames(playerWinner, opponent);
            checkWinnerMatch(playerWinner);
        }
        else {
            playerWinner.wonGame();
            clearPlayersPoints(playerWinner, opponent);
        }
    }

    private void checkWinnerMatch(PlayerScoreDTO playerWinner) {
        if (playerWinner.getSet() == 2) {
            System.out.println("Игрок с id: " + playerWinner.getId() + " ПОбедил");//вызов метода о завершении матча
        }
    }

}

