package ch.M151.schrittzaehlerchallenge.dto;

import ch.M151.schrittzaehlerchallenge.enums.CompetitionStateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CompetitionDto implements Serializable {
    private final long id;
    private final String name;
    private final Date startdate;
    private final Date enddate;
    private final CompetitionStateEnum state;
}
