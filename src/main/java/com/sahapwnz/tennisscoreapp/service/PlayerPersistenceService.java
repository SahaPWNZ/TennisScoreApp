package com.sahapwnz.tennisscoreapp.service;

import com.sahapwnz.tennisscoreapp.dao.PlayerDAO;
import com.sahapwnz.tennisscoreapp.dto.PlayerRequestDTO;
import com.sahapwnz.tennisscoreapp.entity.Player;
import com.sahapwnz.tennisscoreapp.util.MappingUtil;

import java.util.Optional;

public class PlayerPersistenceService {
    private static final PlayerDAO playerDAO = new PlayerDAO();
    public static Player findOrSave(PlayerRequestDTO playerDTO) {
        Optional<Player> optionalPlayer = playerDAO.findByName(playerDTO.getName());
        if (optionalPlayer.equals(Optional.empty())){
            return playerDAO.save(MappingUtil.convertToEntityPlayer(playerDTO));
        }
        else {
            return optionalPlayer.get();
        }
    }
}
