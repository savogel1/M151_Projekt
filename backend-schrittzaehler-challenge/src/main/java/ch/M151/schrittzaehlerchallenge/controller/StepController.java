package ch.M151.schrittzaehlerchallenge.controller;

import ch.M151.schrittzaehlerchallenge.service.StepService;
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
}