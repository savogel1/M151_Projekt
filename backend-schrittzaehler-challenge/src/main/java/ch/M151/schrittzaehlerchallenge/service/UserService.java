package ch.M151.schrittzaehlerchallenge.service;

import ch.M151.schrittzaehlerchallenge.dto.UserDto;
import ch.M151.schrittzaehlerchallenge.entity.UserEntity;
import ch.M151.schrittzaehlerchallenge.enums.UserRoleEnum;
import ch.M151.schrittzaehlerchallenge.mapper.UserMapper;
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
        return UserMapper.mapToMultipleDtos(entities);
    }
}
