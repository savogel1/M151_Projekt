package ch.M151.schrittzaehlerchallenge.service;

import ch.M151.schrittzaehlerchallenge.dto.StepDto;
import ch.M151.schrittzaehlerchallenge.entity.StepEntity;
import ch.M151.schrittzaehlerchallenge.repo.StepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StepService {

    private final StepRepo stepRepo;

    @Autowired
    public StepService(final StepRepo stepRepo) {
        this.stepRepo = stepRepo;
    }

    public List<StepDto> getByUsersId(Optional<Long> userId) {
        List<StepEntity> entities = stepRepo.findByUsersId(userId);
        return mapToMultipleDtos(entities);
    }

    public List<StepDto> getAll() {
        final List<StepEntity> entities = stepRepo.findAll();
        return mapToMultipleDtos(entities);
    }

    private StepDto mapToDto(StepEntity entity) {
        return StepDto.builder()
                .id(entity.getId())
                .numberOfSteps(entity.getNumberOfSteps())
                .creationDate(entity.getCreationDate())
                .build();
    }

    private List<StepDto> mapToMultipleDtos(List<StepEntity> entities) {
        List<StepDto> steps = new ArrayList();
        for (StepEntity entity : entities) {
            steps.add(StepDto.builder()
                    .id(entity.getId())
                    .numberOfSteps(entity.getNumberOfSteps())
                    .creationDate(entity.getCreationDate())
                    .build()
            );
        }
        return steps;
    }
}
