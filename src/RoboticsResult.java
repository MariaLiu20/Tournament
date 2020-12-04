public class RoboticsResult implements IResult {
    RoboticsTeam team1;
    RoboticsTeam team2;
    double team1points;
    int team1tasks;
    boolean team1fell;
    double team2points;
    int team2tasks;
    boolean team2fell;

    RoboticsResult (RoboticsTeam team1, RoboticsTeam team2,
                   double team1points, int team1tasks, boolean team1fell,
                   double team2points, int team2tasks, boolean team2fell) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1points = team1points;
        this.team1tasks = team1tasks;
        this.team1fell = team1fell;
        this.team2points = team2points;
        this.team2tasks = team2tasks;
        this.team2fell = team2fell;
    }

    // determines whether the results are expected or reasonable
    public boolean isValid() {
        return (this.team1tasks < 8 && this.team2tasks < 8 &&
                this.team1points <= 16 && this.team2points <= 16);
    }

    // calculates final score
    public double getScore(double points, double tasks, boolean didFall) {
        double sum = points + tasks;
        if (didFall)
            sum -= 5;
        return sum;
    }

    // returns the Robotics Team with the highest score calculated using getScore
    public RoboticsTeam getWinner() {
        if (getScore(team1points, team1tasks, team1fell) > getScore(team2points, team2tasks, team2fell))
            return team1;
        else
            return team2;
    }
}
