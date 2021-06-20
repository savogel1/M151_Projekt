package ch.M151.schrittzaehlerchallenge.repo;

import ch.M151.schrittzaehlerchallenge.entity.GroupEntity;
import ch.M151.schrittzaehlerchallenge.entity.StepEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@AllArgsConstructor
@Repository
public class GroupRepoCustomImpl implements GroupRepoCustom {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void insertGroup(GroupEntity groupEntity) {
        entityManager.merge(groupEntity);
    }
}
