import java.util.LinkedList;

/**
 * Initial rounds occur at the beginning of the tournament
 */

public class InitRound extends AbsRound {


    public InitRound(LinkedList<Match> matches) {
        super(matches);
    }

    /**
     * @param contestant Takes in a contestant from either the Rugby or Robotics competition
     * @return Returns whether the given contestant is a winner from either one of the matches in the round
     *         by checking if the contestant's results is valid and if the given contestant goes with the winners from
     *         either of the following matches
     */
    public boolean isWinner(IContestant contestant) {
        for(Match m : matches) {
            if(m.winner() != null && m.winner().equals(contestant))
                return true;
        }
        return false;
    }

}
