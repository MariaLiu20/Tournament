import java.util.LinkedList;

/**
 * AbsRound is an abstract class that holds fields and method implementations common to both InitRound
 * and AdvancedRound
 */

public abstract class AbsRound implements IWinner {

    LinkedList<Match> matches;    //all matches played in this round

    public AbsRound(LinkedList<Match> matches) {
        this.matches = matches;
    }

    /**
     * @return a LinkedList of all of the contestants that won each match in each round
     * If the match results are invalid, no contestant is added to the list
     */
    public LinkedList<IContestant> getMatchWinners() {
        LinkedList<IContestant> winners = new LinkedList<IContestant>();
        if(!matches.isEmpty()){
            for (Match m : matches)
                if(m.winner() != null) {
                    winners.add(m.winner());
                }
        }
        return winners;
    }

    /**
     * @return Returns the number of winners in the round
     */
    public int getNumWinners() {
        return this.getMatchWinners().size();
    }

    /**
     * @param contestant Takes in a contestant from either the Rugby or Robotics competition
     * @return whether or not the given contestant is a winner
     */
    public boolean isWinner(IContestant contestant) {
        return false;
    }
}
