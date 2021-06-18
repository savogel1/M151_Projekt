package ch.M151.schrittzaehlerchallenge.controller;

import ch.M151.schrittzaehlerchallenge.dto.CompetitionDto;
import ch.M151.schrittzaehlerchallenge.service.CompetitionService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CompetitionController {

    private CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("competition/{id}")
    public CompetitionDto get(@PathVariable long id) {
        return competitionService.getById(id);
    }

    @GetMapping("competition/user/{userId}")
    public String getCompetitionOfUser(@PathVariable long userId) {
        return "Is not implemented yet.";
    }
}
