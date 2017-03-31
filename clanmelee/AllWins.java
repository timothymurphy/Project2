package clanmelee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AllWins {
    private HashMap<Integer, Wins> clansWins = new HashMap<>();
    private int maxNameWidth = 0;

    public int clanCount() {
        return clansWins.size();
    }

    public void addClan(int clanID, String clanName) {
        clansWins.put(clanID, new Wins(clanName));
        if (clanName.length() > maxNameWidth) {
            maxNameWidth = clanName.length();
        }
    }

    public void addWin(int victorID) {
        clansWins.get(victorID).addWin();
    }

    public void print() {
        ArrayList<Wins> arrayWins = new ArrayList<>();
        arrayWins.addAll(clansWins.values());
        Collections.sort(arrayWins);
        String line = "+";
        for (int i = 0; i < maxNameWidth + 6; i++) {
            line += "-";
        }
        line += "+";
        System.out.println(line);
        for (Wins wins : arrayWins) {
            System.out.println(String.format("| %" + maxNameWidth + "s: %-3s|",
                    wins.getName(), wins.getWins()));
        }
        System.out.println(line);
    }
}
