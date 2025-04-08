package org.bettingtracker.repository;

import org.bettingtracker.bet.Bet;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BetRepository {

    //List that contains and tracks the bets
    private final List<Bet> bets = new ArrayList<>();

    // Finds all the bets inside the system
    public List<Bet> findAll(){
        return bets;
    }

    // Find bets using the id
    public Optional<Bet> findById(Integer id) {
        return bets.stream().filter(btrack -> btrack.id().equals(id)).findFirst();
    }

    ///  Basic Crud Functions

    // Create a bet
    public void create(Bet bet) {
        bets.add(bet);
    }

    // Update a current bet based on the ID
    public void update(Bet bet, Integer id) {
        findById(id).ifPresent(existing -> {
            bets.set(bets.indexOf(existing), bet);
        });
    }

    // Delete a bet
    public void delete(Integer id) {
        bets.removeIf(b -> b.id().equals(id));
    }

    public List<Bet> filter(String sport, Boolean won, Double minOdds, Double maxOdds) {
        return bets.stream()
                .filter(b -> sport == null || b.sport().equalsIgnoreCase(sport))
                .filter(b -> won == null || b.won() == won)
                .filter(b -> minOdds == null || b.odds() >= minOdds)
                .filter(b -> maxOdds == null || b.odds() <= maxOdds)
                .collect(Collectors.toList());
    }

    // calculate the profits
    public double calculateProfit() {
        return bets.stream()
                .mapToDouble(bstakes -> bstakes.won() ? (bstakes.stake() * bstakes.odds()) - bstakes.stake() : -bstakes.stake())
                .sum();
    }

}
