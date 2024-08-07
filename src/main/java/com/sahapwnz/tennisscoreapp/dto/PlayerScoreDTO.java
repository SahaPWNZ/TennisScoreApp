package com.sahapwnz.tennisscoreapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerScoreDTO {
    private Long id;
    private int point = 0;
    private int game = 0;
    private int set = 0;

    public PlayerScoreDTO(Long id) {
        this.id = id;
    }

    public void wonPoint(){
        point++;
    }
    public void wonGame(){
        game++;
    }
    public void wonSet(){
        set++;
    }
}
