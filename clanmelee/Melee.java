
package clanmelee;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Melee {
    AllWins allWins = new AllWins();

    /**
     * Takes a Collection<Clan>, instantiates an ArrayList<ClanMember> that holds
     * the participants of the melee. Instantiates a new Statistics object to keep track
     * of the
     * @param clans
     * @param hitPoints
     */
    public void runMelee(Collection<Clan> clans, int hitPoints) {
        ArrayList<ClanMember> participants = new ArrayList<>();
        int totalClanCount = clans.size();
        String[] clanNames = new String[totalClanCount];
        Statistics statistics = new Statistics(totalClanCount);

        for (Clan clan : clans) {
            int clanID = clan.getID();
            String clanName = clan.getName();
            if (allWins.clanCount() < clans.size()) {
                allWins.addClan(clanID, clanName);
            }
            Collection<ClanMember> members = clan.getMembers(hitPoints);
            if (!validateClan(members, hitPoints, clanID, clan.getName())) {
                continue;
            }
            clanNames[clanID] = clan.getName();
            participants.addAll(members);
            for (ClanMember member : members) {
                statistics.addPlayer(member);
            }
        }

  
        int clanCount = totalClanCount;

        boolean[] previouslyAlive = new boolean[totalClanCount];
        Arrays.fill(previouslyAlive, true);
        int roundCount = 0;

        while (clanCount > 1) {
            Collections.shuffle(participants);
            statistics = new Statistics(totalClanCount);
            boolean[] currentlyAlive = new boolean[totalClanCount];
            Arrays.fill(currentlyAlive, false);
            ArrayList<ClanMember> remaining = new ArrayList<>(participants.size());
            for (int i = 0; i < participants.size() - 1; i += 2) {
                ClanMember p1 = participants.get(i);
                ClanMember p2 = participants.get(i + 1);

                runInteraction(p1, p2);

                if (p1.isAlive()) {
                    statistics.addPlayer(p1);
                    currentlyAlive[p1.getClanID()] = true;
                    remaining.add(p1);
                }
                if (p2.isAlive()) {
                    statistics.addPlayer(p2);
                    currentlyAlive[p2.getClanID()] = true;
                    remaining.add(p2);
                }
            }

            if (participants.size() % 2 == 1) {
                ClanMember lastPlayer = participants.get(participants.size() - 1);
                int lastID = lastPlayer.getClanID();
                lastPlayer.dealIterationDamage(0);
                if (lastPlayer.isAlive()) {
                    statistics.addPlayer(lastPlayer);
                    currentlyAlive[lastID] = true;
                    remaining.add(lastPlayer);
                }
            }

            clanCount = statistics.getCurrentClanCount();

            roundCount += 1;

            for (int i = 0; i < totalClanCount; i++) {
                if (!currentlyAlive[i] && previouslyAlive[i]) {
                    if (clanNames[i] == null) {
                        continue;
                    }
                    System.out.println(clanNames[i] + " eliminated after " +
                            roundCount + " interactions");
                }
            }

            previouslyAlive = currentlyAlive;

            participants = remaining;
        }

        if (clanCount == 0) {
            System.out.println("All were slain after " + roundCount
                    + " interactions!");
        } else {
            int victorID = statistics.getWinner();
            System.out.println(clanNames[victorID] + " emerged victorious after " +
                    roundCount + " interactions!");
            allWins.addWin(victorID);
        }
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
        }
        else {
            if (p2Action > 0 || Math.random() < 0.5) {
                p2.dealDamage(p1Action);
            }
        }
    }

    void printStats() {
        allWins.print();
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
}

