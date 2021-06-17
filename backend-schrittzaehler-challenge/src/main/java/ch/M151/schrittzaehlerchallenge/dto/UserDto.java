package ch.M151.schrittzaehlerchallenge.dto;

import ch.M151.schrittzaehlerchallenge.enums.UserRoleEnum;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Getter
public class UserDto implements Serializable {
    private final long id;
    private final String username;
    private final String email;
    private final int dailyStepGoal;
    private final UserRoleEnum userRole;
    private final List<StepDto> steps;

    public UserDto(
            long id,
            String username,
            String email,
            int dailyStepGoal,
            UserRoleEnum userRole,
            List<StepDto> steps
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.dailyStepGoal = dailyStepGoal;
        this.userRole = userRole;
        this.steps = steps;
    }
}
