package ch.M151.schrittzaehlerchallenge.service;

import ch.M151.schrittzaehlerchallenge.dto.CompetitionDto;
import ch.M151.schrittzaehlerchallenge.entity.CompetitionEntity;
import ch.M151.schrittzaehlerchallenge.enums.CompetitionStateEnum;
import ch.M151.schrittzaehlerchallenge.mapper.CompetitionMapper;
import ch.M151.schrittzaehlerchallenge.repo.CompetitionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionService {

    private CompetitionRepo competitionRepo;

    @Autowired
    public CompetitionService(final CompetitionRepo competitionRepo) {
        this.competitionRepo = competitionRepo;
    }

    public CompetitionDto getById(long id) {
        CompetitionEntity entity = competitionRepo.findById(id);
        return CompetitionMapper.mapToDto(entity);
    }
}
