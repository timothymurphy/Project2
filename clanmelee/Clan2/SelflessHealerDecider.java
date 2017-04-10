package clanmelee.Clan2;
/*
SelflessHealerDecider collects actionPoints from the ActionPointDecider. decideActionPoints is the action it will do.
If it meets an teammate it will heal 1 time. Otherwise, it wil do nothing.
 */
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class SelflessHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public SelflessHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember self, ClanMember opponent) {
        //Check if clan IDs match
        boolean clanIDsMatch = self.getClanID() == opponent.getClanID();

        //If opponent is in same clan --> heal
        if (clanIDsMatch) {
            return actionPoints;
        }

        //If opponent is in different clan --> retreat
        else {
            return 0;
        }
    }
}
