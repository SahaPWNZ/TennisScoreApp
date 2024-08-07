package com.sahapwnz.tennisscoreapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchScoreDTO {
private PlayerScoreDTO player1;
private PlayerScoreDTO player2;

public PlayerScoreDTO getPlayerScoreDTOonId(Long id) {
    if (player1.getId().equals(id)) {
        return player1;
    } else if (player2.getId().equals(id)) {
        return player2;
    } else {
        throw new IllegalArgumentException("Player with ID " + id + " not found");
    }
}
public PlayerScoreDTO getOponnentPlayerScoreDTO(PlayerScoreDTO player){
    if(player.getId().equals(player2.getId())){
        return player1;
    }
    else {
        return player2;
    }
}
}
