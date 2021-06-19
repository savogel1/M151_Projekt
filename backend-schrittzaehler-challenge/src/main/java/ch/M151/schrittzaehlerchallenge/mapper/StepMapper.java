package ch.M151.schrittzaehlerchallenge.mapper;

import ch.M151.schrittzaehlerchallenge.dto.StepDto;
import ch.M151.schrittzaehlerchallenge.entity.StepEntity;
import ch.M151.schrittzaehlerchallenge.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

public class StepMapper {

    public static List<StepDto> mapToMultipleDtos(List<StepEntity> entities) {
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

    public static StepEntity mapToEntity(StepDto stepDto, UserRepo userRepo) {
        StepEntity stepEntity = new StepEntity();
        stepEntity.setUser(userRepo.findById(stepDto.getUserId()));
        stepEntity.setNumberOfSteps(stepDto.getNumberOfSteps());
        java.sql.Date creationDateSQL = new java.sql.Date(stepDto.getCreationDate().getTime());
        stepEntity.setCreationDate(creationDateSQL);
        return stepEntity;
    }
}
