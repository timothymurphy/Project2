
package clanmelee;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Melee {
    private Wins wins;
    private Collection<Clan> clans;
    private ArrayList<ClanMember> participants = new ArrayList<>();
    private int totalClanCount;
    private int currentClanCount;
    private String[] clanNames;
    private Statistics statistics;

    public Melee(Wins wins, Collection<Clan> clans) {
        this.wins = wins;
        this.clans = clans;
        totalClanCount = clans.size();
        currentClanCount = totalClanCount;
        clanNames = new String[totalClanCount];
        statistics = new Statistics(totalClanCount);

        for (Clan clan : clans) {
            if (wins.clanCount() < clans.size()) {
                wins.addClan(clan.getID(), clan.getName());
            }
        }
    }

    public void runRound(int hitPoints) {

        addParticipants(hitPoints);

        boolean[] previouslyAlive = new boolean[totalClanCount];
        Arrays.fill(previouslyAlive, true);

        int turnCount;
        for (turnCount = 1; currentClanCount > 1; turnCount++) {
            Collections.shuffle(participants);
            statistics = new Statistics(totalClanCount);

            boolean[] currentlyAlive = runTurn();

            for (int i = 0; i < totalClanCount; i++) {
                if (!currentlyAlive[i] && previouslyAlive[i] && clanNames[i] != null) {
                    System.out.println(clanNames[i] + " eliminated after " +
                            turnCount + " interactions");
                }
            }
            previouslyAlive = currentlyAlive;
        }
        checkWinners(currentClanCount, --turnCount);
    }

    private void addParticipants(int hitPoints) {
        for (Clan clan : clans) {
            Collection<ClanMember> members = clan.getMembers(hitPoints);
            if (validateClan(members, hitPoints, clan.getID(), clan.getName())) {
                clanNames[clan.getID()] = clan.getName();
                participants.addAll(members);
                for (ClanMember member : members) {
                    statistics.addPlayer(member);
                }
            }
        }
    }

    private boolean validateClan(Collection<ClanMember> members, int hitPoints,
                                 int clanID, String clanName) {

        int hitPointSum = 0;
        for (ClanMember cm : members) {
            if (cm.getClanID() != clanID) {
                System.out.println(clanName + " does not have consistent clan IDs!!");
                System.out.println(clanName + " DISQUALIFIED!!");
                return false;
            }
            hitPointSum += cm.getMaxHitPoints();
        }
        if (hitPointSum > hitPoints) {
            System.out.println(clanName + " has " + hitPointSum +
                    " hit points when only " + hitPoints + " are allowed!!");
            System.out.println(clanName + " DISQUALIFIED!!");
            return false;
        }
        return true;
    }

    private boolean[] runTurn() {

        for (int i = 0; i < participants.size() - 1; i += 2) {
            ClanMember p1 = participants.get(i);
            ClanMember p2 = participants.get(i + 1);
            runInteraction(p1, p2);
        }

        if (participants.size() % 2 == 1) {
            runLastInteraction(participants.get(participants.size() - 1));
        }

        ArrayList<ClanMember> remaining = getRemaining();
        boolean[] currentlyAlive = getCurrentlyAlive(remaining);

        currentClanCount = statistics.getCurrentClanCount();
        participants = remaining;

        return currentlyAlive;
    }

    private void runInteraction(ClanMember p1, ClanMember p2) {
        int p1Action = p1.getActionPoints(p2);
        int p2Action = p2.getActionPoints(p1);

        applyAction(p1, p1Action, p2, p2Action);
        applyAction(p2, p2Action, p1, p1Action);
    }

    private void applyAction(ClanMember p1, int p1Action,
                                  ClanMember p2, int p2Action) {
        if (p1.getType() == HEALER) {
            p2.heal(p1Action);
        } else if (p2Action > 0 || Math.random() < 0.5) {
            p2.dealDamage(p1Action);
        }
    }

    private void runLastInteraction(ClanMember p) {
        p.dealIterationDamage(0);
    }

    private ArrayList<ClanMember> getRemaining() {
        ArrayList<ClanMember> remaining = new ArrayList<>(participants.size());

        for (ClanMember cm : participants) {
            if (cm.isAlive()) {
                statistics.addPlayer(cm);
                remaining.add(cm);
            }
        }

        return remaining;
    }

    private boolean[] getCurrentlyAlive(ArrayList<ClanMember> remaining) {

        boolean[] currentlyAlive = new boolean[totalClanCount];
        Arrays.fill(currentlyAlive, false);

        for (ClanMember cm : remaining) {
            currentlyAlive[cm.getClanID()] = true;
        }

        return currentlyAlive;
    }

    private void checkWinners(int clanCount, int turnCount) {
        if (clanCount == 0) {
            System.out.println("All were slain after " + turnCount
                    + " interactions!");
        } else {
            int victorID = statistics.getWinner();
            System.out.println(clanNames[victorID] + " emerged victorious after " +
                    turnCount + " interactions!");
            wins.addWin(victorID);
        }
    }

    void printStats() {
        wins.print();
    }
}

