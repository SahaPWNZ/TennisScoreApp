package com.sahapwnz.tennisscoreapp.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchScoreDTO that = (MatchScoreDTO) o;
        return Objects.equals(player1.getName(), that.player1.getName()) && Objects.equals(player2.getName(), that.player2.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(player1.getName(), player2.getName());
    }
}
