package ch.M151.schrittzaehlerchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class StepDto {
    private long id;
    private long userId;
    private int numberOfSteps;
    private Date creationDate;
}
