package ch.M151.schrittzaehlerchallenge.dto;

import ch.M151.schrittzaehlerchallenge.enums.CompetitionStateEnum;
import lombok.Getter;

import java.io.Serializable;
import java.sql.Date;

@Getter
public class CompetitionDto implements Serializable {

    private final long id;
    private final String name;
    private final Date startdate;
    private final Date enddate;
    private final CompetitionStateEnum state;

    public CompetitionDto(long id, String name, Date startdate, Date enddate, CompetitionStateEnum state) {
        this.id = id;
        this.name = name;
        this.startdate = startdate;
        this.enddate = enddate;
        this.state = state;
    }
}
