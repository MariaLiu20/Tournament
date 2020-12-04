public class Match {
    IContestant team1;
    IContestant team2;
    IResult result;

    public Match (IContestant team1, IContestant team2, IResult result) {
        this.team1 = team1;
        this.team2 = team2;
        this.result = result;
    }

    // returns the contestant that won the match according to the results

    public IContestant winner() {
        if (this.result.isValid())
            return this.result.getWinner();
        else
            return null;
    }
}


