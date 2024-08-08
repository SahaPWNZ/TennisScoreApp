package com.sahapwnz.tennisscoreapp.service;

import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerScoreDTO;

public class FinishedMatchesPersistenceService {
    private final MatchScoreDTO finishedMatchDTO;

    public FinishedMatchesPersistenceService(MatchScoreDTO finishedMatchDTO) {
        this.finishedMatchDTO = finishedMatchDTO;
    }
    public void persistFinishedMatch(){
        //метод по маппингу из matchDTO -> в матчМодель

    }
    public PlayerScoreDTO getWinnerPlayerDTO(){
        if (finishedMatchDTO.getPlayer1().getSet() ==2){
            return finishedMatchDTO.getPlayer1();
        }
        else{
            return finishedMatchDTO.getPlayer2();
        }
    }
    //метод который смотрит какой игрок выиграл и возвращает его с MatchScoreDTO
    //метод который делает из mstchScoreDTO и игрока который выиграл MatchDTO и возвращает его
    //метод который добавляет matchDTO в БД
}
