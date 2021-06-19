package ch.M151.schrittzaehlerchallenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "group", schema = "public")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "groupname", nullable = false)
    private String groupname;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CompetitionEntity competition;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserEntity> userEntities = new ArrayList<>();
}