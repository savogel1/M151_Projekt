package ch.M151.schrittzaehlerchallenge.repo;

import ch.M151.schrittzaehlerchallenge.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findAll();

    UserEntity findByUsername(Optional<String> username);
    
    UserEntity checkPassword(String username, String password);

    UserEntity findById(long id);

    List<UserEntity> findByGroupId(long id);

}
