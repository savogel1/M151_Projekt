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
    private final long id;
    private final String username;
    private final String email;
    private final int dailyStepGoal;
    private final UserRoleEnum userRole;
    private final List<StepDto> steps;
}
