package ch.M151.schrittzaehlerchallenge.mapper;

import ch.M151.schrittzaehlerchallenge.calculator.GroupCalculator;
import ch.M151.schrittzaehlerchallenge.dto.GroupDto;
import ch.M151.schrittzaehlerchallenge.entity.GroupEntity;
import ch.M151.schrittzaehlerchallenge.repo.GroupRepo;
import ch.M151.schrittzaehlerchallenge.repo.StepRepo;
import ch.M151.schrittzaehlerchallenge.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

public class GroupMapper {

    public static List<GroupDto> mapToMultipleDtos(List<GroupEntity> entities, UserRepo userRepo, StepRepo stepRepo) {
        List<GroupDto> groups = new ArrayList();
        for (GroupEntity entity : entities) {
            GroupCalculator calculator = new GroupCalculator(entity, userRepo, stepRepo);
            groups.add(GroupDto.builder()
                    .id(entity.getId())
                    .groupname(entity.getGroupname())
                    .totalSteps(calculator.calculateTotalSteps())
                    .averageSteps(calculator.calculateAverageSteps())
                    .build()
            );
        }
        return groups;
    }
}
