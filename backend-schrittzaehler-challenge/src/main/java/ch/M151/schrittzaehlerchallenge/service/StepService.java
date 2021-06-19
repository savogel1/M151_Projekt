package ch.M151.schrittzaehlerchallenge.service;

import ch.M151.schrittzaehlerchallenge.dto.StepDto;
import ch.M151.schrittzaehlerchallenge.dto.UserDto;
import ch.M151.schrittzaehlerchallenge.entity.StepEntity;
import ch.M151.schrittzaehlerchallenge.entity.UserEntity;
import ch.M151.schrittzaehlerchallenge.enums.UserRoleEnum;
import ch.M151.schrittzaehlerchallenge.repo.StepRepo;
import ch.M151.schrittzaehlerchallenge.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StepService {

    private final StepRepo stepRepo;
    private final UserRepo userRepo;

    @Autowired
    public StepService(final StepRepo stepRepo, final UserRepo userRepo) {
        this.stepRepo = stepRepo;
        this.userRepo = userRepo;
    }

    public List<StepDto> getByUsersId(Optional<Long> userId) {
        List<StepEntity> entities = stepRepo.findByUserId(userId);
        return mapToMultipleDtos(entities);
    }

    @Transactional
    public void addStep(StepDto stepDto) {
        StepEntity stepEntity = mapToEntity(stepDto);
        stepRepo.insertStep(stepEntity);
        //stepRepo.save(stepEntity);
    }

    private List<StepDto> mapToMultipleDtos(List<StepEntity> entities) {
        List<StepDto> steps = new ArrayList();
        for (StepEntity entity : entities) {
            steps.add(StepDto.builder()
                    .id(entity.getId())
                    .userId(entity.getUser().getId())
                    .numberOfSteps(entity.getNumberOfSteps())
                    .creationDate(entity.getCreationDate())
                    .build()
            );
        }
        return steps;
    }

    private StepEntity mapToEntity(StepDto stepDto) {
        StepEntity stepEntity = new StepEntity();
        stepEntity.setUser(userRepo.findById(stepDto.getUserId()));
        stepEntity.setNumberOfSteps(stepDto.getNumberOfSteps());
        java.sql.Date creationDateSQL = new java.sql.Date(stepDto.getCreationDate().getTime());
        stepEntity.setCreationDate(creationDateSQL);
        return stepEntity;
    }

    private UserEntity mapToUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setDailyStepGoal(userDto.getDailyStepGoal());
        userEntity.setUserRole(userDto.getUserRole().toString());
        return userEntity;
    }

    private UserDto mapToUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getDailyStepGoal(),
                UserRoleEnum.valueOf(userEntity.getUserRole()),
                mapToMultipleDtos(stepRepo.findByUserId(Optional.of(userEntity.getId())))
        );
        return userDto;
    }
}
