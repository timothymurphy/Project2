package clanmelee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Wins {
    private HashMap<Integer, ClanWins> wins = new HashMap<>();
    private int maxNameWidth = 0;

    public int clanCount() {
        return wins.size();
    }

    /**
     * Adds Clan to wins
     * @param clanID
     * @param clanName
     */
    public void addClan(int clanID, String clanName) {
        wins.put(clanID, new ClanWins(clanName));
        if (clanName.length() > maxNameWidth) {
            maxNameWidth = clanName.length();
        }
    }

    /**
     * Adds winner of melee
     * @param victorID
     */
    public void addWin(int victorID) {
        wins.get(victorID).addWin();
    }

    public void print() {
        ArrayList<ClanWins> arrayWins = new ArrayList<>();
        arrayWins.addAll(wins.values());
        Collections.sort(arrayWins);
        String line = "+";
        for (int i = 0; i < maxNameWidth + 6; i++) {
            line += "-";
        }
        line += "+";
        System.out.println(line);
        for (ClanWins clanWins : arrayWins) {
            System.out.println(String.format("| %" + maxNameWidth + "s: %-3s|",
                    clanWins.name, clanWins.victories));
        }
        System.out.println(line);
    }


    private class ClanWins implements Comparable<ClanWins> {
        String name;
        Integer victories;

        ClanWins(String name) {
            this.name = name;
            this.victories = 0;
        }

        void addWin() {
            victories += 1;
        }

        @Override
        public int compareTo(ClanWins other) {
            return victories.compareTo(other.victories) * -1;
        }
    }
}
