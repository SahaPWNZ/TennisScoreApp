package com.sahapwnz.tennisscoreapp.util;

import com.sahapwnz.tennisscoreapp.dto.PlayerRequestDTO;
import com.sahapwnz.tennisscoreapp.exceptions.InvalidParameterException;

import java.util.regex.Pattern;

public class ValidationUtil {
    public static void namesValidation(PlayerRequestDTO playerOne, PlayerRequestDTO playerTwo){
        String nameOne = playerOne.getName();
        String nameTwo = playerTwo.getName();
        isValidName(nameOne);
        isValidName(nameTwo);
        if(nameOne.equals(nameTwo)){
            throw new InvalidParameterException("Same players names");
        }
    }
    private static void isValidName(String name){
        if (name.isEmpty()) {
            throw new InvalidParameterException("Name - empty");
        }
        if(!Pattern.matches("[a-zA-Z]+", name)){
            throw new InvalidParameterException("The name must be made up of letters only");
        }

    }
}
