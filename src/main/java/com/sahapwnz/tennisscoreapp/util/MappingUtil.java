package com.sahapwnz.tennisscoreapp.util;

import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerScoreDTO;
import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;

public class MappingUtil {
    private static final ModelMapper MODEL_MAPPER;

    static {
        MODEL_MAPPER = new ModelMapper();

//        MODEL_MAPPER.typeMap(Player.class, PlayerScoreDTO.class)
//                .addMapping(Player::getId, PlayerScoreDTO::setId);
//
//        MODEL_MAPPER.typeMap(PlayerScoreDTO.class, Player.class)
//                .addMapping(PlayerScoreDTO::getId, Player::setId)
//                .addMapping(PlayerScoreDTO::getName, Player::setName);


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


    public static Player convertToEntityPlayer(PlayerScoreDTO playerScoreDTO) {
        return MODEL_MAPPER.map(playerScoreDTO, Player.class);
    }

    public static PlayerScoreDTO convertToDTO(Player player) {
        return MODEL_MAPPER.map(player, PlayerScoreDTO.class);
    }
}
