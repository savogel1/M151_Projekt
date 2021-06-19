package ch.M151.schrittzaehlerchallenge.service;

import ch.M151.schrittzaehlerchallenge.dto.LoginRequest;
import ch.M151.schrittzaehlerchallenge.dto.UserDto;
import ch.M151.schrittzaehlerchallenge.entity.UserEntity;
import ch.M151.schrittzaehlerchallenge.enums.UserRoleEnum;
import ch.M151.schrittzaehlerchallenge.mapper.UserMapper;
import ch.M151.schrittzaehlerchallenge.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(final UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserDto> getAll() {
        final List<UserEntity> entities = userRepo.findAll();
        return UserMapper.mapToMultipleDtos(entities);
    }

    public UserDto getUser(Optional<String> username) {
        final UserEntity entity = userRepo.findByUsername(username);
        return mapToDto(entity);
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

    public UserDto login(LoginRequest loginRequest) {
        UserEntity entity = userRepo.checkPassword(loginRequest.getUsername(), loginRequest.getPassword());
        return mapToDto(entity);
    }
}
