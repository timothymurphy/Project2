package clanmelee;

import java.util.Collection;
import java.util.Random;

public class Main {
    private static Random rand = new Random();

    private static int wiggle(int original) {
        int amount = rand.nextInt((int) (original * 0.05));
        if (rand.nextDouble() < 0.5)
            return original + amount;
        else
            return original - amount;
    }

    public static void main(String[] args) {
        int[] allBaseHitPoints = {100, 1000, 10000, 100000, 1000000, 10000000};
        Collection<Clan> clans = new ClanFactory().getClans();
        ClanMelee melee = new ClanMelee();
        int round = 1;
        for (int baseHitPoints : allBaseHitPoints) {
            for (int i = 0; i < 5; i++) {
                int hitPoints = wiggle(baseHitPoints);

                System.out.println("Round " + round + ", " + hitPoints
                        + " hit points per clan");
                System.out.println();

                melee.runMelee(clans, hitPoints);

                System.out.println();
                System.out.println("Results after " + round + " rounds:");
                melee.printStats();
                System.out.println();

                ++round;
            }
        }
    }
}
