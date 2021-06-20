package ch.M151.schrittzaehlerchallenge.service;

import ch.M151.schrittzaehlerchallenge.dto.GroupDto;
import ch.M151.schrittzaehlerchallenge.entity.GroupEntity;
import ch.M151.schrittzaehlerchallenge.mapper.GroupMapper;
import ch.M151.schrittzaehlerchallenge.repo.CompetitionRepo;
import ch.M151.schrittzaehlerchallenge.repo.GroupRepo;
import ch.M151.schrittzaehlerchallenge.repo.StepRepo;
import ch.M151.schrittzaehlerchallenge.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GroupService {

    private final GroupRepo groupRepo;
    private final UserRepo userRepo;
    private final StepRepo stepRepo;
    private final CompetitionRepo competitionRepo;

    @Autowired
    public GroupService(final GroupRepo groupRepo, final UserRepo userRepo, final StepRepo stepRepo, final CompetitionRepo competitionRepo) {
        this.groupRepo = groupRepo;
        this.userRepo = userRepo;
        this.stepRepo = stepRepo;
        this.competitionRepo = competitionRepo;
    }

    public List<GroupDto> getAll() {
        final List<GroupEntity> entities = groupRepo.findAll();
        return GroupMapper.mapToMultipleDtos(entities, userRepo, stepRepo);
    }

    @Transactional
    public void addGroup(GroupDto groupDto) {
        GroupEntity groupEntity = GroupMapper.mapToEntity(groupDto, competitionRepo);
        groupRepo.insertGroup(groupEntity);
    }
}
