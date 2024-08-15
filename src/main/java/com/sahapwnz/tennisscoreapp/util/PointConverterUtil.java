package com.sahapwnz.tennisscoreapp.util;

import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerScoreDTO;

public class PointConverterUtil {
    public static String pointConverter(PlayerScoreDTO firstPlayer, PlayerScoreDTO secondPlayer) {
        int pointsFirstPlayer = firstPlayer.getPoint();
        int pointsOpponent = secondPlayer.getPoint();
        if(firstPlayer.getGame()==6 && secondPlayer.getGame()==6){
            return ""+pointsFirstPlayer;
        }
        if (pointsFirstPlayer >=3 && pointsOpponent >=3){
            if(pointsFirstPlayer == pointsOpponent){
                return "40";
            }
            else if (pointsFirstPlayer>pointsOpponent){
                return "advantage";
            }
            else {
                return "40";
            }

        }
        else {
            switch (pointsFirstPlayer){
                case 0: return "0";
                case 1: return "15";
                case 2: return "30";
                case 3: return "40";
                default: return "error";
            }
        }
    }
}
