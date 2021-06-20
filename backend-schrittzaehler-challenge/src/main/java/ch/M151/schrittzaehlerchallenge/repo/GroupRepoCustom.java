package ch.M151.schrittzaehlerchallenge.repo;

import ch.M151.schrittzaehlerchallenge.entity.GroupEntity;
import ch.M151.schrittzaehlerchallenge.entity.StepEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepoCustom {

    void insertGroup(GroupEntity groupEntity);

}
