package ch.M151.schrittzaehlerchallenge.dto;

import ch.M151.schrittzaehlerchallenge.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto implements Serializable {
    private long id;
    private String username;
    private String email;
    private int dailyStepGoal;
    private UserRoleEnum userRole;
    private List<StepDto> steps;
}
