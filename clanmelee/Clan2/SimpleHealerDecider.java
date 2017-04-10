package clanmelee.Clan2;
/*
SimpleHealerDecider collects actionPoints from the ActionPointDecider. decideActionPoints is the action it will do.
If it meets an teammate that has less than 80% HP it will heal 1 time. Otherwise, it wil do nothing.
 */
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class SimpleHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public SimpleHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember self, ClanMember opponent) {
        //Check if clan IDs match
        boolean clanIDsMatch = self.getClanID() == opponent.getClanID();

        //If opponent is in same clan
        if (clanIDsMatch) {
            //If the teammate is significantly damaged --> heal
            if (opponent.getHitPoints() <= (0.8 * opponent.getMaxHitPoints())) {
                return actionPoints;
            }

            //If the teammate is mostly undamaged or different clan--> retreat
            else {
                return 0;
            }
        }

        //If opponent is in different clan --> retreat
        else {
            return 0;
        }
    }
}