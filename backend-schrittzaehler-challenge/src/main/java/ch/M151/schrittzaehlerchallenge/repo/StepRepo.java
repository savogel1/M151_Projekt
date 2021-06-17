package ch.M151.schrittzaehlerchallenge.repo;

import ch.M151.schrittzaehlerchallenge.entity.StepEntity;
import ch.M151.schrittzaehlerchallenge.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StepRepo extends CrudRepository<StepEntity, Long> {

    List<StepEntity> findByUsersId(Optional<Long> usersId);

}
