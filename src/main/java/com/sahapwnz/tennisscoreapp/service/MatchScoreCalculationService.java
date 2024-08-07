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
        PlayerScoreDTO playerWithPointDTO = matchScoreDTO.getPlayerScoreDTOonId(id);
        playerWithPointDTO.wonPoint();
        checkWonGame(playerWithPointDTO, matchScoreDTO.getOponnentPlayerScoreDTO(playerWithPointDTO));
    }


    public void checkWonGame(PlayerScoreDTO playerWithPointDTO, PlayerScoreDTO player2DTO) {
        if (playerWithPointDTO.getGame() == 6 && player2DTO.getGame() == 6) {

            playTieBreak(playerWithPointDTO, player2DTO);

        } else if (playerWithPointDTO.getPoint() >= 4 && player2DTO.getPoint() >= 4) {
            if (playerWithPointDTO.getPoint() - player2DTO.getPoint() == 2) {

                playerWithPointDTO.wonGame();
                clearPlayersPoints(playerWithPointDTO, player2DTO);
                checkWonSet(playerWithPointDTO, player2DTO);
            }
        } else if (playerWithPointDTO.getPoint() == 4 && player2DTO.getPoint() < 3) {

            playerWithPointDTO.wonGame();
            clearPlayersPoints(playerWithPointDTO, player2DTO);
            checkWonSet(playerWithPointDTO, player2DTO);
//
        }
    }

    public void checkWonSet(PlayerScoreDTO playerWithPointDTO, PlayerScoreDTO player2DTO) {
        if (playerWithPointDTO.getGame() == 6 && player2DTO.getGame() <= 4) {
            playerWithPointDTO.wonSet();
            clearPlayersPoints(playerWithPointDTO, player2DTO);
            clearPlayersGames(playerWithPointDTO, player2DTO);
//            checkWonMatch(matchScoreDTO.getPlayer1());
        }
    }

    public void playTieBreak(PlayerScoreDTO playerWithPointDTO, PlayerScoreDTO player2DTO) {
        if (playerWithPointDTO.getPoint() >= 6 && (playerWithPointDTO.getPoint() - player2DTO.getPoint()) >= 2) {
            playerWithPointDTO.wonSet();
            clearPlayersPoints(playerWithPointDTO, player2DTO);
            clearPlayersGames(playerWithPointDTO, player2DTO);
            //            checkWonMatch(matchScoreDTO.getPlayer1());
        }
    }
//
//    public void checkWonMatch(PlayerScoreDTO playerScoreDTO) {
//        if (playerScoreDTO.getSet() == 2) {
//            System.out.println("Игрок с id: " + playerScoreDTO.getId() + " ПОбедил");//вызов метода о завершении матча
//        }
//    }
//    public void winOneGame(PlayerScoreDTO){
//
//    }
}

