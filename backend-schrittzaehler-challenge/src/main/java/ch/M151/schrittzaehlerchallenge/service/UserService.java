package ch.M151.schrittzaehlerchallenge.service;

import ch.M151.schrittzaehlerchallenge.dto.UserDto;
import ch.M151.schrittzaehlerchallenge.entity.UserEntity;
import ch.M151.schrittzaehlerchallenge.enums.UserRoleEnum;
import ch.M151.schrittzaehlerchallenge.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(final UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserDto> getAll() {
        final List<UserEntity> entities = userRepo.findAll();
        return mapToMultipleDtos(entities);
    }

    public UserDto getById(long id) {
        UserEntity entity = userRepo.findById(id);
        return mapToDto(entity);
    }

    public void delete(long id) {
        userRepo.deleteById(id);
    }

    public void deleteAll() {
        userRepo.deleteAll();
    }

    private UserDto mapToDto(UserEntity entity) {
        return new UserDto(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getDailyStepGoal(),
                UserRoleEnum.valueOf(entity.getUserRole()),
                new ArrayList<>()
        );
    }

    private List<UserDto> mapToMultipleDtos(List<UserEntity> entities) {
        List<UserDto> users = new ArrayList();
        for (UserEntity entity : entities) {
            UserDto user = new UserDto(
                    entity.getId(),
                    entity.getUsername(),
                    entity.getEmail(),
                    entity.getDailyStepGoal(),
                    UserRoleEnum.valueOf(entity.getUserRole()),
                    new ArrayList<>()
            );
            users.add(user);
        }
        return users;
    }
}
