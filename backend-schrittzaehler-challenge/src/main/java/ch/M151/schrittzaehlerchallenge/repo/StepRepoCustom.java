package ch.M151.schrittzaehlerchallenge.repo;

import ch.M151.schrittzaehlerchallenge.entity.StepEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepoCustom {

    void insertStep(StepEntity stepEntity);

}
