import java.util.LinkedList;

/**
 * A tournament is a set of rounds, each of which in turn consists of a set of matches
 */

public class Tournament {

    LinkedList<IWinner> rounds;

    public Tournament(LinkedList<IWinner> rounds) {
        this.rounds = rounds;
    }

    /**
     *
     * @param contestant Takes in a contestant representing the tournament winner
     *                   from either the Rugby and Robotics competition
     * @return whether the given contestant is a valid tournament winner by checking if
     *         they have won at least half of the rounds in the tournament
     */
    public boolean finalWinnerIsValid(IContestant contestant) {
        int wins = 0;
        if(!rounds.isEmpty()){
            for (IWinner w : rounds) {
                if (w.isWinner(contestant) && w != null)
                    wins++;
            }
            return (wins*2 >= rounds.size());
        }
        return false;
        }

}
