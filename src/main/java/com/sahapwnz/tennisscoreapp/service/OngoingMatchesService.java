package com.sahapwnz.tennisscoreapp.service;

import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerScoreDTO;

import java.util.HashMap;
import java.util.UUID;

public class OngoingMatchesService {


    protected static final HashMap<UUID, MatchScoreDTO> mapMatchScore = new HashMap<>();


    //принимает 2 пустых ДТО player и добавляет новый матчScore в мапу, нужно проверять есть ли
    //матч с такими игроками в мапе
    public void addNewMatchScoreDTO(PlayerScoreDTO player1, PlayerScoreDTO player2){
    }
    //удаляем матч с мапы
    public void removeMatchScoreDTO(UUID uuid){
    }

    public MatchScoreDTO getMatchScoreDTO(UUID uuid){
return null;
    }
}
