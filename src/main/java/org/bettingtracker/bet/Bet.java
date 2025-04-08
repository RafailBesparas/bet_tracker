package org.bettingtracker.bet;

import java.time.LocalDate;

public record Bet (
            Integer id,
            String sport,
            String team,
            LocalDate date,
            double stake,
            double odds,
            boolean won
) {

}
