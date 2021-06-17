package ch.M151.schrittzaehlerchallenge.entity;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Entity
@Table(name = "competition")
public class CompetitionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_date", nullable = true)
    private Date startDate;

    @Column(name = "end_date", nullable = true)
    private Date endDate;

    @Column(name = "state", nullable = false)
    private String state;

}
