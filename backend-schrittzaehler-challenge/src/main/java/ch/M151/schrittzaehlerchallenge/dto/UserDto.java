package ch.M151.schrittzaehlerchallenge.dto;

import ch.M151.schrittzaehlerchallenge.enums.UserRoleEnum;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class UserDto implements Serializable {
    private final long id;
    private final String username;
    private final String email;
    private final int dailyStepGoal;
    private final UserRoleEnum userRole;

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

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getDailyStepGoal() {
        return dailyStepGoal;
    }

    public UserRoleEnum getUserRole() {
        return userRole;
    }
}
