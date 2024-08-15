package com.sahapwnz.tennisscoreapp.util;

import com.sahapwnz.tennisscoreapp.dto.MatchResponceDTO;
import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerRequestDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerScoreDTO;
import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class MappingUtil {
    private static final ModelMapper MODEL_MAPPER;

    static {
        MODEL_MAPPER = new ModelMapper();
    }

    public static MatchResponceDTO convertMatchToMatchResponse(Match match) {
        MatchResponceDTO matchResponse = MODEL_MAPPER.map(match, MatchResponceDTO.class);
        matchResponse.setPlayer1Name(match.getPlayer1().getName());
        matchResponse.setPlayer2Name(match.getPlayer2().getName());
        matchResponse.setWinnerName(match.getWinnerPlayer().getName());
        return matchResponse;
    }

    public static List<MatchResponceDTO> convertListMatchToMatchResponse(List<Match> matchList) {
        List<MatchResponceDTO> matchesDTO = new ArrayList<>();
        for (Match match : matchList) {
            matchesDTO.add(convertMatchToMatchResponse(match));
        }
        return matchesDTO;
    }
    public static Match convertToEntityMatch(MatchScoreDTO matchScoreDTO) {
        Player player1 = convertToEntityPlayer(matchScoreDTO.getPlayer1());
        Player player2 = convertToEntityPlayer(matchScoreDTO.getPlayer2());

        Player winner;
        if (matchScoreDTO.getPlayer1().getSet() == 2) {
            winner = player1;
        } else {
            winner = player2;
        }

        return Match.builder().player1(player1).player2(player2).winnerPlayer(winner).build();


    }
    public static Player convertToEntityPlayer(PlayerRequestDTO playerRequestDTO){
        return MODEL_MAPPER.map(playerRequestDTO, Player.class);
    }


    public static Player convertToEntityPlayer(PlayerScoreDTO playerScoreDTO) {
        return MODEL_MAPPER.map(playerScoreDTO, Player.class);
    }

    public static PlayerScoreDTO convertToDTO(Player player) {
        return MODEL_MAPPER.map(player, PlayerScoreDTO.class);
    }
}
