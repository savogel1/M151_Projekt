package ch.M151.schrittzaehlerchallenge.dto;

import ch.M151.schrittzaehlerchallenge.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class StepDto {
    private long id;
    private int numberOfSteps;
    private Date creationDate;
}
