package ch.M151.schrittzaehlerchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GroupDto {
    private long id;
    private String groupname;
    private int totalSteps;
    private int averageSteps;
}
