package ch.M151.schrittzaehlerchallenge.dto;

import ch.M151.schrittzaehlerchallenge.enums.UserRoleEnum;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserDto {
    private long id;
    private String username;
    private String email;
    private int dailyStepGoal;
    private UserRoleEnum userRole;

    public UserDto() {}

    public UserDto(
            long id,
            String username,
            String email,
            int dailyStepGoal,
            UserRoleEnum userRole
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.dailyStepGoal = dailyStepGoal;
        this.userRole = userRole;
    }
}
