package org.bettingtracker.controller;

import jakarta.validation.Valid;
import org.bettingtracker.bet.Bet;
import org.bettingtracker.repository.BetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bets")
public class BetController {

    private final BetRepository betRepository;

    public BetController(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    @GetMapping
    public List<Bet> findAll(@RequestParam(required = false) String sport,
                             @RequestParam(required = false) Boolean won,
                             @RequestParam(required = false) Double minOdds,
                             @RequestParam(required = false) Double maxOdds) {
        return betRepository.filter(sport, won, minOdds, maxOdds);
    }

    @GetMapping("/profit")
    public double getProfitSummary() {
        return betRepository.calculateProfit();
    }

    @GetMapping("/{id}")
    public Bet findById(@PathVariable Integer id) {
        return betRepository.findById(id).orElseThrow(() -> new RuntimeException("Bet not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Bet bet) {
        betRepository.create(bet);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Bet bet, @PathVariable Integer id) {
        betRepository.update(bet, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        betRepository.delete(id);
    }
}
