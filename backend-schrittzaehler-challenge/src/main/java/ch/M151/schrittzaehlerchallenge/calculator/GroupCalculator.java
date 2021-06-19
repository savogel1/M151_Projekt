package ch.M151.schrittzaehlerchallenge.calculator;

import ch.M151.schrittzaehlerchallenge.entity.GroupEntity;
import ch.M151.schrittzaehlerchallenge.entity.StepEntity;
import ch.M151.schrittzaehlerchallenge.entity.UserEntity;
import ch.M151.schrittzaehlerchallenge.repo.GroupRepo;
import ch.M151.schrittzaehlerchallenge.repo.StepRepo;
import ch.M151.schrittzaehlerchallenge.repo.UserRepo;

import java.util.List;
import java.util.Optional;

public class GroupCalculator {
    private GroupEntity group;
    private UserRepo userRepo;
    private StepRepo stepRepo;

    private int totalSteps;
    private int numberOfUsers;

    public GroupCalculator(GroupEntity group, UserRepo userRepo, StepRepo stepRepo) {
        this.group = group;
        this.userRepo = userRepo;
        this.stepRepo = stepRepo;
    }

    public int calculateTotalSteps() {
        resetMembers();
        List<UserEntity> users = userRepo.findByGroupId(group.getId());
        numberOfUsers = users.size();
        for (UserEntity user : users) {
            Optional<Long> userId = Optional.of(user.getId());
            List<StepEntity> steps = stepRepo.findByUserId(userId);
            for (StepEntity step : steps) {
                totalSteps += step.getNumberOfSteps();
            }
        }
        return totalSteps;
    }
    public int calculateAverageSteps() {
        resetMembers();
        int totalSteps = calculateTotalSteps();
        if(totalSteps != 0 || numberOfUsers != 0) {
            return totalSteps / numberOfUsers;
        }
        return 0;
    }

    private void resetMembers() {
        totalSteps = 0;
        numberOfUsers = 0;
    }
}
