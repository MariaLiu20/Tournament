public class RugbyResult implements IResult {
    RugbyTeam team1;
    RugbyTeam team2;
    double team1points;
    double team2points;

    RugbyResult (RugbyTeam team1, RugbyTeam team2, double team1points, double team2points) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1points = team1points;
        this.team2points = team2points;
    }

    // determines whether the results are expected or reasonable
    public boolean isValid() {
        return (this.team1points < 150 && this.team2points < 150);
    }

    // returns the Rugby team with more points
    public RugbyTeam getWinner() {
        if (team1points > team2points)
            return team1;
        else
            return team2;
    }
}
