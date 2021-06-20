package ch.M151.schrittzaehlerchallenge.controller;

import ch.M151.schrittzaehlerchallenge.dto.GroupDto;
import ch.M151.schrittzaehlerchallenge.service.GroupService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/group")
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/")
    public List<GroupDto> getAll() {
        return groupService.getAll();
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addGroup(@RequestBody final GroupDto groupDto){
        try {
            groupService.addGroup(groupDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
