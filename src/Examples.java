/**
 * @author Maria Liu
 * @author Kevin Dang
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class Examples {

    public Examples() {}

    //EMPTY LINKEDLIST TO TEST EMPTY LISTS IN TEST CASES
    public LinkedList<IContestant> emptiness(){
        LinkedList<IContestant> empty = new LinkedList<>();
        return empty;
    }

    //OBJECTS FOR ROBOTICS COMPETITION
    RoboticsTeam robTeamA = new RoboticsTeam("WPI", "powerful arm", 0);
    RoboticsTeam robTeamB = new RoboticsTeam("UMA", "spinning head", 15);
    RoboticsTeam robTeamC = new RoboticsTeam("MIT", "camera", 21);
    RoboticsTeam robTeamD = new RoboticsTeam("NEU", "hammer", 0);
    RoboticsTeam robTeamE = new RoboticsTeam("UML", "rocket", 0);
    RoboticsTeam robTeamF = new RoboticsTeam("WIT", "detachable leg", 1000);
    RoboticsTeam robTeamG = new RoboticsTeam("UMB", "water dispenser", -50);

    RoboticsResult robResultOne = new RoboticsResult(robTeamA, robTeamB, 10, 5, true, 15, 7, false);
    RoboticsResult robResultTwo = new RoboticsResult(robTeamA, robTeamB, 10, 5, true, 20, 7, false);
    RoboticsResult robResultThree = new RoboticsResult(robTeamA, robTeamB, 10, 8, true, 20, 7, false);
    RoboticsResult robResultFour = new RoboticsResult(robTeamA, robTeamB, 10, 8, true, 15, 7, false);
    RoboticsResult robResultFive = new RoboticsResult(robTeamA, robTeamB, 10, 7, true, 15, 11, false);
    RoboticsResult robResultSix = new RoboticsResult(robTeamA, robTeamB, 100, 7, true, 15, 7, false);
    RoboticsResult robResultSeven = new RoboticsResult(robTeamA, robTeamB, 0, 0, false, 0, 0, false);
    RoboticsResult robResultEight = new RoboticsResult(robTeamA, robTeamC, 0, 1, true, 0, 0, true);
    RoboticsResult robResultNine = new RoboticsResult(robTeamF, robTeamG, 13, 5, false, 12, 3, true);

    Match robMatch1 = new Match(robTeamA, robTeamB, robResultOne);
    Match robMatch2 = new Match(robTeamA, robTeamC, robResultEight);
    Match robMatch3 = new Match(robTeamA, robTeamB, robResultFour);
    Match robMatch4 = new Match(robTeamA, robTeamB, robResultFive);
    Match robMatch5 = new Match(robTeamF, robTeamG, robResultNine);
    Match robMatch6 = new Match(robTeamA, robTeamB, robResultSix);

    public LinkedList lomRobOne(){
        LinkedList<Match> matchOne = new LinkedList<Match>();
        matchOne.add(robMatch1);
        matchOne.add(robMatch5);
        return matchOne;
    }

    public LinkedList lomRobTwo(){
        LinkedList<Match> matchTwo = new LinkedList<Match>();
        matchTwo.add(robMatch4);
        matchTwo.add(robMatch2);
        matchTwo.add(robMatch3);
        matchTwo.add(robMatch6);
        return matchTwo;
    }

    //TEST CASES FOR ROBOTICS COMPETITION

    //checks if results from robotics competition are valid
    @Test
    public void testIsValidRobOne() {
        assertTrue(robResultOne.isValid());
    }
    @Test
    public void testIsValidRobTwo() {
        assertFalse(robResultTwo.isValid()); //returns false because team 2 exceeds 16 points (20)
    }
    @Test
    public void testIsValidRobThree() {
        assertFalse(robResultThree.isValid());  //returns false because team 2 exceeds 16 points and team 1 has 8 tasks
    }
    @Test
    public void testIsValidRobFour() {
        assertFalse(robResultFour.isValid()); //returns false because team 1 has 8 tasks
    }
    @Test
    public void testIsValidRobFive() {
        assertFalse(robResultFive.isValid()); //returns false because team 2 has over 8 tasks
    }
    @Test
    public void testIsValidRobSix() {
        assertFalse(robResultSix.isValid()); //returns false because team 1 exceeds 16 points (100)
    }
    @Test
    public void testIsValidRobSeven() {
        assertTrue(robResultSeven.isValid());
    }

    // checks team's score
    @Test
    public void testGetScore() {
        assertEquals(22.0, robResultOne.getScore(robResultOne.team2points, robResultOne.team2tasks, robResultOne.team2fell), 0);
    }
    @Test
    public void testGetScoreOne() {
        assertEquals(0.0, robResultSeven.getScore(robResultSeven.team1points, robResultSeven.team1tasks, robResultSeven.team1fell), 0); //tests for zero value
    }
    @Test
    public void testGetScoreTwo() {
        assertEquals(102.0, robResultSix.getScore(robResultSix.team1points, robResultSix.team1tasks, robResultSix.team1fell), 0); //tests for triple digit value
    }
    @Test
    public void testGetScoreThree() {
        assertEquals(-5.0, robResultEight.getScore(robResultEight.team2points, robResultEight.team2tasks, robResultEight.team2fell), 0); //tests for negative value
    }
    @Test
    public void testGetScoreFour() {
        assertEquals(26.0, robResultFive.getScore(robResultFive.team2points, robResultFive.team2tasks, robResultFive.team2fell), 0);
    }

    // determines winner
    @Test
    public void testGetRobWinner() {
        assertEquals(robTeamB, robMatch1.winner()); //returns team B because it has 22 points while team A has 10 points after the match
    }
    @Test
    public void testGetRobWinnerOne() {
        assertEquals(robTeamA, robMatch2.winner()); //returns team A because it has -4 points while team C has -5 points
    }
    @Test
    public void testGetRobWinnerTwo() {
        assertNull(robMatch3.winner()); //returns null because the results from the match are invalid for which team one has 8 tasks
    }
    @Test
    public void testGetRobWinnerThree() {
        assertNull(robMatch4.winner());
    }
    @Test
    public void testGetRobWinnerFour() {
        assertEquals(robTeamF, robMatch5.winner());
    }

    // determines whether the contestant can beat the give contestant
    @Test
    public void testExpectToBeatRob() {
        assertTrue(robTeamC.expectToBeat(robTeamA)); // returns true because team c has a larger previous score than team a
    }
    @Test
    public void testExpectToBeatRobOne() {
        assertFalse(robTeamB.expectToBeat(robTeamC)); // returns false because team c has a larger previous score than team b
    }
    @Test
    public void testExpectToBeatRobTwo() {
        assertFalse(robTeamD.expectToBeat(robTeamE)); // returns false because team d and team e has the same previous score
    }
    @Test
    public void testExpectToBeatRobThree() {
        assertTrue(robTeamF.expectToBeat(robTeamA)); // returns true because team f has a higher score than team a [EXTREME CASE]
    }
    @Test
    public void testExpectToBeatRobFour() {
        assertFalse(robTeamG.expectToBeat(robTeamE)); // returns false because team g has a lower score than team e [EXTREME CASE]
    }

    // OBJECTS FOR RUGBY COMPETITION
    RugbyTeam rugTeamA = new RugbyTeam("China", "Yellow", false, 12, 8);
    RugbyTeam rugTeamB = new RugbyTeam("Vietnam", "Red", true, 20, 0);
    RugbyTeam rugTeamC = new RugbyTeam("USA", "white", true, 30, 1);
    RugbyTeam rugTeamD = new RugbyTeam("Germany", "maroon", false, 1, 10);
    RugbyResult rugResultOne = new RugbyResult(rugTeamA, rugTeamB, 95, 120);
    RugbyResult rugResultTwo = new RugbyResult(rugTeamA, rugTeamB, 50, 150);
    RugbyResult rugResultThree = new RugbyResult(rugTeamB, rugTeamC, 200, 10);
    RugbyResult rugResultFour = new RugbyResult(rugTeamB, rugTeamC, 300, 400);
    RugbyResult rugResultFive = new RugbyResult(rugTeamA, rugTeamC, 20, 30);
    RugbyResult rugResultSix = new RugbyResult(rugTeamA, rugTeamC, 50, 30);
    RugbyResult rugResultSeven = new RugbyResult(rugTeamA, rugTeamB, 35, 55);
    RugbyResult rugResultEight = new RugbyResult(rugTeamA, rugTeamB, 70,40);

    Match rugMatch1 = new Match(rugTeamA, rugTeamB, rugResultOne);
    Match rugMatch2 = new Match(rugTeamA, rugTeamB, rugResultTwo);
    Match rugMatch3 = new Match(rugTeamB, rugTeamC, rugResultThree);
    Match rugMatch4 = new Match(rugTeamA, rugTeamC, rugResultFive);
    Match rugMatch5 = new Match(rugTeamA, rugTeamC, rugResultSix);
    Match rugMatch6 = new Match(rugTeamA, rugTeamB, rugResultSeven);
    Match rugMatch7 = new Match(rugTeamA, rugTeamB, rugResultEight);

    public LinkedList lomRugOne() {
        LinkedList<Match> matches1 = new LinkedList<Match>();
        matches1.add(rugMatch1);
        matches1.add(rugMatch6);
        return matches1;
    }

    public LinkedList lomRugTwo() {
        LinkedList<Match> matches2 = new LinkedList<Match>();
        matches2.add(rugMatch5);
        matches2.add(rugMatch7);
        matches2.add(rugMatch1);
        return matches2;
    }

    public LinkedList lomRugThree() {
        LinkedList<Match> matches3 = new LinkedList<Match>();
        matches3.add(rugMatch4);
        matches3.add(rugMatch1);
        matches3.add(rugMatch6);
        matches3.add(rugMatch2);
        return matches3;
    }

    public LinkedList lomRugFour() {
        LinkedList<Match> matches4 = new LinkedList<Match>();
        return matches4;
    }

    // TEST CASES FOR RUGBY COMPETITION

    // checks to see if scores are valid
    @Test
    public void testIsValidRugOne() {
        assertTrue(rugResultOne.isValid());
    }
    @Test
    public void testIsValidRugTwo() {
        assertFalse(rugResultTwo.isValid());
    }
    @Test
    public void testIsValidRugThree() {
        assertFalse(rugResultThree.isValid());
    }
    @Test
    public void testIsValidRugFour() {
        assertFalse(rugResultFour.isValid());
    }
    @Test
    public void testIsValidRugFive() {
        assertTrue(rugResultFive.isValid());
    }

    // determines winner
    @Test
    public void testGetRugWinner(){
        assertEquals(rugTeamB, rugMatch1.winner());
    }
    @Test
    public void testGetRugWinnerOne(){
        assertNull(rugMatch2.winner());
    }
    @Test
    public void testGetRugWinnerTwo() {
        assertNull(rugMatch3.winner());
    }
    @Test
    public void testGetRugWinnerThree() {
        assertEquals(rugTeamC, rugMatch4.winner());
    }
    @Test
    public void testGetRugWinnerFour() {
        assertEquals(rugTeamA, rugMatch5.winner());
    }

    // determines whether the contestant can beat the given contestant
    @Test
    public void testExpectToBeatRug(){
        assertFalse(rugTeamA.expectToBeat(rugTeamB)); // returns false because team B has an intimidation ritual
    }
    @Test
    public void testExpectToBeatRugOne(){
        assertTrue(rugTeamB.expectToBeat(rugTeamA)); // returns true because team B has an intimidation ritual and it has a higher win to loss gap than team A
    }
    @Test
    public void testExpectToBeatRugTwo(){
        assertTrue(rugTeamC.expectToBeat(rugTeamB)); // returns true because team C has a higher win to loss gap than team B
    }
    @Test
    public void testExpectToBeatRugThree() {
        assertFalse(rugTeamA.expectToBeat(rugTeamA)); // returns false because they are the same team
    }
    @Test
    public void testExpectToBeatRugFour() {
        assertFalse(rugTeamD.expectToBeat(rugTeamA)); // returns false because team D has more losses than wins
    }

    public LinkedList lomRugFive(){
        LinkedList<IContestant> contestants = new LinkedList<IContestant>();
        return contestants;

    }

    //OBJECT FOR RUGBY INITIALIZED ROUNDS

    InitRound iRugRound1 = new InitRound(lomRugOne());
    InitRound iRugRound2 = new InitRound(lomRugTwo());
    InitRound iRugRound3 = new InitRound(lomRugThree());
    InitRound iRugRound4 = new InitRound(lomRugFour());
    InitRound iRugRound5 = new InitRound(lomRugFive());

    //tests if contestant is winner in init rugby round
    @Test
    public void testIsRugWinner() {
        assertTrue(iRugRound1.isWinner(rugTeamB));
    }
    @Test
    public void testIsRugWinnerOne(){
        assertTrue(iRugRound2.isWinner(rugTeamB));
    }
    @Test
    public void testIsRugWinnerTwo(){
        assertTrue(iRugRound2.isWinner(rugTeamA));
    }
    @Test
    public void testIsRugWinnerThree(){
        assertFalse(iRugRound2.isWinner(rugTeamC));
    }
    @Test
    public void testIsRugWinnerFour(){
        assertFalse(iRugRound3.isWinner(rugTeamA));
    }

    //tests for the number of winners in rugby round
    @Test
            public void testGetRugNumWinners(){
        assertEquals(3, iRugRound2.getNumWinners());
    }
    @Test
            public void testGetRugNumWinnersOne(){
        assertEquals(2, iRugRound1.getNumWinners());
    }
    @Test
            public void testGetRugNumWinnersTwo(){
        assertEquals(3, iRugRound3.getNumWinners());
    }
    @Test
            public void testGetRugNumWinnersThree(){
        assertEquals(0, iRugRound4.getNumWinners());
    }
    @Test
    public void testGetRobNumWinnersOne() {
        assertEquals(2 , iRobRound1.getNumWinners());
    }
    @Test
    public void testGetRobNumWinnersTwo() {
        assertEquals(1 , iRobRound2.getNumWinners());
    }

    //OBJECTS FOR ROBOTICS INITIALIZED ROUNDS
    InitRound iRobRound1 = new InitRound(lomRobOne());
    InitRound iRobRound2 = new InitRound(lomRobTwo());

    //tests if contestant is winner in init robotics round
    @Test
    public void testIsRobWinner(){
        assertTrue(iRobRound1.isWinner(robTeamB));
    }
    @Test
    public void testIsRobWinnerOne(){
        assertFalse(iRobRound1.isWinner(robTeamA));
    }
    @Test
    public void testIsRobWinnerTwo(){
        assertTrue(iRobRound1.isWinner(robTeamF));
    }
    @Test
    public void testIsRobWinnerThree(){
        assertFalse(iRobRound1.isWinner(robTeamG));
    }
    @Test
    public void testIsRobWinnerFour(){
        assertFalse(iRobRound2.isWinner(robTeamB));
    }
    @Test
    public void testIsRobWinnerFive(){
        assertTrue(iRobRound2.isWinner(robTeamA));
    }

    @Test
    public void testIsRobWinnerSix(){
        assertFalse(iRobRound2.isWinner(robTeamC));
    }

    //LINKEDLIST OF ROBOTICS CONTESTANTS
    public LinkedList locRobOne(){
        LinkedList<IContestant> contestantsOne = new LinkedList<IContestant>();
        contestantsOne.add(robTeamA);
        contestantsOne.add(robTeamB);
        contestantsOne.add(robTeamC);
        contestantsOne.add(robTeamD);
        return contestantsOne;
    }

    public LinkedList locRobTwo(){
        LinkedList<IContestant> contestantTwo = new LinkedList<IContestant>();
        return contestantTwo;
    }

    //LINKED LIST OF RUGBY CONTESTANTS
    public LinkedList locRugOne(){
        LinkedList<IContestant> contestantOne = new LinkedList<IContestant>();
        contestantOne.add(rugTeamA);
        contestantOne.add(rugTeamB);
        contestantOne.add(rugTeamC);
        return contestantOne;
    }

    public LinkedList locRugTwo(){
        LinkedList<IContestant> contestantTwo = new LinkedList<IContestant>();
        return contestantTwo;
    }
    //OBJECTS FOR ROBOTICS ADVANCED ROUND
    AdvancedRound advRobRound1 = new AdvancedRound(lomRobOne(),locRobOne());
    AdvancedRound advRobRound2 = new AdvancedRound(lomRobOne(),locRobTwo());

    //OBJECTS FOR RUGBY ADVANCED ROUND
    AdvancedRound advRugRound1 = new AdvancedRound(lomRugOne(),locRugOne());
    AdvancedRound advRugRound2 = new AdvancedRound(lomRugOne(), locRugTwo());

    @Test
    public void testIsRobWinnerAdv(){
        assertTrue(advRobRound1.isWinner(robTeamA));
    }
    @Test
    public void testIsRobWinnerAdvOne(){
        assertFalse(advRobRound1.isWinner(robTeamE));
    }
    @Test
    public void testIsRobWinnerAdvTwo(){
        assertTrue(advRobRound1.isWinner(robTeamC));
    }
    @Test
    public void testIsRobWinnerAdvThree(){
        assertFalse(advRobRound2.isWinner(robTeamA));
    }
    @Test
    public void testIsRobWinnerAdvFour(){
        assertTrue(advRobRound1.isWinner(robTeamD));
    }
    @Test
    public void testIsRugWinnerAdvFive(){
        assertTrue(advRugRound1.isWinner(rugTeamA));

    }
    @Test
    public void testIsRugWinnerAdvOne(){
        assertTrue(advRugRound1.isWinner(rugTeamB));
    }
    @Test
    public void testIsRugWinnerAdvTwo(){
        assertTrue(advRugRound1.isWinner(rugTeamC));
    }
    @Test
    public void testIsRugWinnerAdvThree(){
        assertFalse(advRugRound1.isWinner(rugTeamD));

    }
    @Test
    public void testIsRugWinnerAdvFour(){
        assertFalse(advRugRound2.isWinner(rugTeamA));
    }

//OBJECT FOR RUGBY ROUNDS
    public LinkedList lorRug(){
        LinkedList<IWinner> rounds = new LinkedList<IWinner>();
        rounds.add(iRugRound1);
        rounds.add(iRugRound2);
        rounds.add(iRugRound3);
        rounds.add(advRugRound1);
        rounds.add(advRugRound2);
        return rounds;
    }
    public LinkedList lorRugOne(){
        LinkedList<IWinner> rounds = new LinkedList<IWinner>();
        rounds.add(iRugRound1);
        rounds.add(advRugRound1);
        rounds.add(iRugRound3);
        rounds.add(advRugRound2);
        return rounds;
    }

    public LinkedList lorRugTwo(){
        LinkedList<IWinner> rounds = new LinkedList<IWinner>();
        rounds.add(iRugRound3);
        return rounds;
    }

    //OBJECT FOR ROBOTICS ROUNDS
    public LinkedList lorRob(){
        LinkedList<IWinner> rounds = new LinkedList<>();
        rounds.add(iRobRound1);
        rounds.add(iRobRound2);
        rounds.add(advRobRound1);
        rounds.add(advRobRound2);
        return rounds;
    }

    public LinkedList lorRobOne(){
        LinkedList<IWinner> rounds = new LinkedList<>();
        rounds.add(iRobRound1);
        rounds.add(advRobRound1);
        rounds.add(advRobRound2);
        return rounds;
    }

    public LinkedList lorRobTwo(){
        LinkedList<IWinner> rounds = new LinkedList<>();
        rounds.add(iRobRound1);
        return rounds;
    }

    public LinkedList lorRobThree(){
        LinkedList<IWinner> rounds = new LinkedList<>();
        return rounds;
    }
    //OBJECT FOR RUGBY TOURNAMENT
    Tournament rugtournamentOne = new Tournament(lorRug());
    Tournament rugtournamentTwo = new Tournament(lorRugOne());
    Tournament rugtournamentThree = new Tournament(lorRugTwo());

    //OBJECT FOR ROBOTICS TOURNAMENT
    Tournament robTournamentOne = new Tournament(lorRob());
    Tournament robTournamentTwo = new Tournament(lorRobOne());
    Tournament robTournamentThree = new Tournament(lorRobTwo());
    Tournament robTournamentFour = new Tournament(lorRobThree());

    //List of Winners
    public LinkedList lowRugOne(){
        LinkedList<IContestant> winners = new LinkedList<IContestant>();
        winners.add(rugTeamC);
        winners.add(rugTeamB);
        winners.add(rugTeamB);
        return winners;
    }

    public LinkedList lowRobOne(){
        LinkedList<IContestant> winners = new LinkedList<IContestant>();
        winners.add(robTeamB);
        winners.add(robTeamF);
        return winners;
    }

    public LinkedList lowRugTwo() {
        LinkedList<IContestant> winners = new LinkedList<IContestant>();
        winners.add(rugTeamB);
        winners.add(rugTeamB);
        return winners;
    }

    public LinkedList lowRobTwo() {
        LinkedList<IContestant> winners = new LinkedList<IContestant>();
        winners.add(robTeamB);
        winners.add(robTeamF);
        return winners;
    }


    @Test
    public void testiRugRound3tMatchWinner() {
        assertEquals(lowRugOne(), iRugRound3.getMatchWinners());
    }
    @Test
    public void testiRobRound1MatchWinner() {
        assertEquals(lowRobOne(), iRobRound1.getMatchWinners());
    }
    @Test
    public void testiRobRound5MatchWinner() {
        assertEquals(emptiness(), iRugRound5.getMatchWinners());
    }
    @Test
    public void testAdvRugRound1MatchWinner() {
        assertEquals(lowRugTwo(), advRugRound1.getMatchWinners());
    }
    @Test
    public void testAdvRobRound1MatchWinner() {
        assertEquals(lowRobTwo(), advRobRound1.getMatchWinners());
    }

//tests for finalWinner RUGBY
    @Test
    public void testIsFinalWinner(){
        assertTrue(rugtournamentOne.finalWinnerIsValid(rugTeamB));
    }

    @Test
    public void testIsFinalRugWinnerOne(){
        assertTrue(rugtournamentTwo.finalWinnerIsValid(rugTeamB));
    }

    @Test
    public void testIsFinalRugWinnerTwo(){
        assertTrue(rugtournamentTwo.finalWinnerIsValid(rugTeamC));
    }

    @Test
    public void testIsFinalRugWinnerThree(){
        assertFalse(rugtournamentOne.finalWinnerIsValid(rugTeamA));
    }

    @Test
    public void testIsFinalRugWinnerFour(){
        assertFalse(rugtournamentOne.finalWinnerIsValid(rugTeamD));
    }

    @Test
    public void testIsFinalRugWinnerFive(){
        assertFalse(rugtournamentThree.finalWinnerIsValid(rugTeamD));
    }

    //tests for final winner ROBOTICS
    @Test
    public void testIsFinalRobWinner(){
        assertTrue(robTournamentOne.finalWinnerIsValid(robTeamA));
    }
    @Test
    public void testIsFinalRobWinnerOne(){
        assertTrue(robTournamentOne.finalWinnerIsValid(robTeamB));
    }
    @Test
    public void testIsFinalRobWinnerTwo(){
        assertFalse(robTournamentOne.finalWinnerIsValid(robTeamG));
    }

    @Test public void testIsFinalRobWinnerThree(){
        assertFalse(robTournamentTwo.finalWinnerIsValid(robTeamA));
    }
    @Test public void testIsFinalRobWinnerFour(){
        assertTrue(robTournamentThree.finalWinnerIsValid(robTeamB));
    }
    @Test public void testIsFinalRobWinnerFive(){
        assertFalse(robTournamentFour.finalWinnerIsValid(robTeamA));
    }
    @Test public void testIsFinalRobWinnerSix(){
        assertTrue(robTournamentThree.finalWinnerIsValid(robTeamF));
    }
    @Test public void testIsFinalRobWinnerSeven(){
        assertFalse(robTournamentThree.finalWinnerIsValid(robTeamG));
    }
}