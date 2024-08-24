package com.sahapwnz.tennisscoreapp.service;

import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerRequestDTO;
import com.sahapwnz.tennisscoreapp.entity.Player;
import com.sahapwnz.tennisscoreapp.util.MappingUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class OngoingMatchesService {


    public static final HashMap<UUID, MatchScoreDTO> mapMatchScore = new HashMap<>();

    public UUID addNewMatchScoreDTO(PlayerRequestDTO player1DTO, PlayerRequestDTO player2DTO) {
        Player player1 = PlayerPersistenceService.findOrSave(player1DTO);
        Player player2 = PlayerPersistenceService.findOrSave(player2DTO);

        MatchScoreDTO matchScoreDTO = MatchScoreDTO.builder().
                player1(MappingUtil.convertToDTO(player1)).
                player2(MappingUtil.convertToDTO(player2)).
                build();
        MatchScoreDTO reverseMatchScoreDTO = MatchScoreDTO.builder().
                player1(MappingUtil.convertToDTO(player2)).
                player2(MappingUtil.convertToDTO(player1)).
                build();

        Optional<UUID> keyOfMatch = mapMatchScore.entrySet().stream().
                filter(entry -> entry.getValue().equals(matchScoreDTO) || entry.getValue().equals(reverseMatchScoreDTO))
                .map(Map.Entry::getKey)
                .findFirst();

        if (keyOfMatch.isPresent()) {
            return keyOfMatch.get();
        } else {
            UUID uuid = UUID.randomUUID();
            mapMatchScore.put(uuid, matchScoreDTO);
            return uuid;
        }
    }

    public void removeMatchScoreDTO(UUID uuid) {
        mapMatchScore.remove(uuid);
        System.out.println("Матч с таким UUID удалён " + uuid);
    }

    public MatchScoreDTO getMatchScoreDTO(UUID uuid) {
        return mapMatchScore.get(uuid);
    }
}
