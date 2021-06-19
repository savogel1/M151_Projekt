package ch.M151.schrittzaehlerchallenge.entity;

import ch.M151.schrittzaehlerchallenge.enums.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity

@Table(name = "user", schema = "public")
@NamedQuery(name = "UserEntity.checkPassword", query = "SELECT u FROM UserEntity u WHERE u.username = :username and u.password = :password")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "daily_step_goal", nullable = true)
    private int dailyStepGoal;

    @Column(name = "user_role", nullable = false)
    private String userRole;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<StepEntity> stepEntities = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private GroupEntity group;
}

