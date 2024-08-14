package com.sahapwnz.tennisscoreapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MatchResponceDTO {
    private String player1Name;
    private String player2Name;
    private String winnerName;
}
