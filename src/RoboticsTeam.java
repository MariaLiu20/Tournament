public class RoboticsTeam implements IContestant {
    String school;
    String feat;
    int prevScore;

    RoboticsTeam (String school, String feat, int prevScore) {
        this.school = school;
        this.feat = feat;
        this.prevScore = prevScore;
    }

    // returns a boolean indicating whether the contestant would be
    // expected to beat the given/input contestant
    public boolean expectToBeat (RoboticsTeam opponent) {
        if (this.prevScore > opponent.prevScore)
            return true;
        else
            return false;
    }
}
