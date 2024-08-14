package com.sahapwnz.tennisscoreapp.service;

import com.sahapwnz.tennisscoreapp.dao.MatchDAO;
import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerScoreDTO;
import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.util.MappingUtil;

public class FinishedMatchesPersistenceService {

    public Match persistFinishedMatch(MatchScoreDTO matchScoreDTO) {
        MatchDAO matchDAO = new MatchDAO();
        Match finifhedMatch = MappingUtil.convertToEntityMatch(matchScoreDTO);
        return matchDAO.save(finifhedMatch)      ;
    }

    public boolean isMatchFinished(MatchScoreDTO matchDTO) {
        return matchDTO.getPlayer1().getSet() == 2 || matchDTO.getPlayer2().getSet() == 2;
    }

    public PlayerScoreDTO getWinnerPlayerDTO(MatchScoreDTO finishedMatchDTO) {
        if (finishedMatchDTO.getPlayer1().getSet() == 2) {
            return finishedMatchDTO.getPlayer1();
        } else {
            return finishedMatchDTO.getPlayer2();
        }
    }
    //метод который смотрит какой игрок выиграл и возвращает его с MatchScoreDTO
    //метод который делает из mstchScoreDTO и игрока который выиграл MatchDTO и возвращает его
    //метод который добавляет matchDTO в БД
}
