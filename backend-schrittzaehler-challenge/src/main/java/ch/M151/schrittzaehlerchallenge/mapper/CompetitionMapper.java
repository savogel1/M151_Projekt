package ch.M151.schrittzaehlerchallenge.mapper;

import ch.M151.schrittzaehlerchallenge.dto.CompetitionDto;
import ch.M151.schrittzaehlerchallenge.entity.CompetitionEntity;
import ch.M151.schrittzaehlerchallenge.enums.CompetitionStateEnum;

public class CompetitionMapper {

    public static CompetitionDto mapToDto(CompetitionEntity entity) {
        CompetitionDto competitionDto = new CompetitionDto(
                entity.getId(),
                entity.getName(),
                entity.getStartDate(),
                entity.getEndDate(),
                CompetitionStateEnum.valueOf(entity.getState())
        );
        return competitionDto;
    }
}
