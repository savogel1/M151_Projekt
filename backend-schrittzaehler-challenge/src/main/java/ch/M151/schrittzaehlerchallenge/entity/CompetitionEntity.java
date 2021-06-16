package ch.M151.schrittzaehlerchallenge.entity;

import ch.M151.schrittzaehlerchallenge.enums.CompetitionStateEnum;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "competition")
public class CompetitionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "start_date", nullable = true)
    private Date startDate;

    @Column(name = "end_date", nullable = true)
    private Date endDate;

    @Column(name = "state", nullable = false)
    private CompetitionStateEnum state;

}
