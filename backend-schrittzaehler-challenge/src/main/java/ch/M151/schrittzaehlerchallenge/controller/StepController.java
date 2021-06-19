package ch.M151.schrittzaehlerchallenge.controller;

import ch.M151.schrittzaehlerchallenge.dto.StepDto;
import ch.M151.schrittzaehlerchallenge.service.StepService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/step")
public class StepController {

    private StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @GetMapping("/by-user/{id}")
    public ResponseEntity getByUsersId(@PathVariable Optional<Long> id) {
        try {
            return ResponseEntity.ok(this.stepService.getByUsersId(id));
        } catch (Exception e) {
            return ResponseEntity.status(405).body(e.getMessage());
        }
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addStep(@RequestBody final StepDto stepDto){
        try {
            stepService.addStep(stepDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}