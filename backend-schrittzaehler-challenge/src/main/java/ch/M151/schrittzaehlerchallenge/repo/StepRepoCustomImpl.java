package ch.M151.schrittzaehlerchallenge.repo;

import ch.M151.schrittzaehlerchallenge.dto.StepDto;
import ch.M151.schrittzaehlerchallenge.entity.StepEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class StepRepoCustomImpl implements StepRepoCustom {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void insertStep(StepEntity stepEntity) {
        //StepEntity stepEntity = new StepEntity();
        //stepEntity.setUsers().setId(usersId);
        //stepEntity.setNumberOfSteps(numberOfSteps);
        //java.sql.Date creationDateSQL = new java.sql.Date(creationDate.getTime());
        //stepEntity.setCreationDate(creationDateSQL);
        entityManager.merge(stepEntity);
    }
}
