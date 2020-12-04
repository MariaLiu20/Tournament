import java.util.LinkedList;

/**
 * Advanced rounds occur later in the tournament and involve contestants who advanced from earlier
 * matches in the tournament (such as quarterfinals, semi-finals, an finals in the World Cup)
 */

public class AdvancedRound extends AbsRound {

    LinkedList<IContestant> contestants;   //list of winners from prev round

    public AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> contestants) {
        super(matches);
        this.contestants = contestants;
    }

    /**
     * @param contestant Takes in a team from either the Robotics and Rugby competition
     * @return whether the given team was one of the winners from the previous round
     *          by comparing the given contestant with list of contestants Advanced Round contains
     */
    public boolean isWinner(IContestant contestant) {
        for (IContestant c : contestants) {
            if(c.equals(contestant)){
                return true;
            }
        }
        return false;
    }
}