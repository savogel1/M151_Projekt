package ch.M151.schrittzaehlerchallenge.repo;

import ch.M151.schrittzaehlerchallenge.entity.CompetitionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepo extends CrudRepository<CompetitionEntity, Long> {
    CompetitionEntity findById(long id);
}
