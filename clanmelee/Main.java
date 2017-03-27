package clanmelee;

import java.util.Collection;
import java.util.Random;

public class Main {
    private static Random rand = new Random();

    /**
     * wiggle() takes an int (original) and generates a new integer (amount) between 0 and (original * 0.05).
     * There is a 50/50 chance that amount will be added to, or subtracted from the original amount.
     * wiggle() seems to be a way of giving some random factor to the HitPoints of each clan.
     * @param original - Original hit-points, passed from allBaseHitPoints.
     * @return - Modified hit-points.
     */
    private static int wiggle(int original) {
        int amount = rand.nextInt((int) (original * 0.05));
        if (rand.nextDouble() < 0.5)
            return original + amount;
        else
            return original - amount;
    }

    /**
     * main() calls ClanFactory to make a Collection<Clan>. For each baseHitPoint value
     * in allBaseHitPoints, main() runs a clanMelee 5 times and reports the results.
     * @param args
     */
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
