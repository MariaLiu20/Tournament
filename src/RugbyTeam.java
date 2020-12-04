public class RugbyTeam implements IContestant {
    String country;
    String jersey;
    boolean ritual;
    int wins;
    int losses;

    RugbyTeam (String country, String jersey, boolean ritual, int wins, int losses) {
        this.country = country;
        this.jersey = jersey;
        this.ritual = ritual;
        this.wins = wins;
        this.losses = losses;
    }

    // returns a boolean indicating whether the contestant would be
    // expected to beat the given/input contestant
    public boolean expectToBeat (RugbyTeam opponent) {
        if (this.ritual && !opponent.ritual)
            return true;
        else if (!this.ritual && opponent.ritual)
            return false;
        else if ((this.ritual && opponent.ritual) || (!this.ritual && !opponent.ritual)) {
            int teamGap = this.wins - this.losses;
            int oppGap = opponent.wins - opponent.losses;
            if (teamGap > oppGap)
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
