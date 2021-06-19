package ch.M151.schrittzaehlerchallenge.service;

import ch.M151.schrittzaehlerchallenge.dto.StepDto;
import ch.M151.schrittzaehlerchallenge.dto.UserDto;
import ch.M151.schrittzaehlerchallenge.entity.StepEntity;
import ch.M151.schrittzaehlerchallenge.entity.UserEntity;
import ch.M151.schrittzaehlerchallenge.enums.UserRoleEnum;
import ch.M151.schrittzaehlerchallenge.mapper.StepMapper;
import ch.M151.schrittzaehlerchallenge.repo.StepRepo;
import ch.M151.schrittzaehlerchallenge.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return StepMapper.mapToMultipleDtos(entities);
    }

    @Transactional
    public void addStep(StepDto stepDto) {
        StepEntity stepEntity = StepMapper.mapToEntity(stepDto, userRepo);
        stepRepo.insertStep(stepEntity);
    }
}
