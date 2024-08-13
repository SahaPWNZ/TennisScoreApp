package com.sahapwnz.tennisscoreapp.util;

import com.sahapwnz.tennisscoreapp.dto.PlayerRequestDTO;

public class ValidationUtil {
    public static void nameValidation(PlayerRequestDTO playerOne, PlayerRequestDTO playerTwo){
        String nameOne = playerOne.getName();
        String nameTwo = playerTwo.getName();
        if(nameOne.equals(nameTwo)){
            throw new RuntimeException("Same names");
        }
    }
}
