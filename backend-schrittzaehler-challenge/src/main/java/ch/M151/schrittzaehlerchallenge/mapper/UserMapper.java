package ch.M151.schrittzaehlerchallenge.mapper;

import ch.M151.schrittzaehlerchallenge.dto.UserDto;
import ch.M151.schrittzaehlerchallenge.entity.UserEntity;
import ch.M151.schrittzaehlerchallenge.enums.UserRoleEnum;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static List<UserDto> mapToMultipleDtos(List<UserEntity> entities) {
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
