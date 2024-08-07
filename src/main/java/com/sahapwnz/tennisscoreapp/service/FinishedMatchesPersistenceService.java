package com.sahapwnz.tennisscoreapp.service;

import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;

public class FinishedMatchesPersistenceService {
    private final MatchScoreDTO finishedMatchDTO;

    public FinishedMatchesPersistenceService(MatchScoreDTO finishedMatchDTO) {
        this.finishedMatchDTO = finishedMatchDTO;
    }
    //метод который смотрит какой игрок выиграл и возвращает его с MatchScoreDTO
    //метод который делает из mstchScoreDTO и игрока который выиграл MatchDTO и возвращает его
    //метод который добавляет matchDTO в БД
}
