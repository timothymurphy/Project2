package clanmelee.Clan2;
/*
AngryWarriorDecider collects actionPoints from the ActionPointDecider. decideActionPoints is the action it will do.
If it meets an enemy it will attack 1 time. Otherwise, it wil do nothing.
 */
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class AngryWarriorDecider  implements ActionPointDecider {
    private int actionPoints;

    public AngryWarriorDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember self, ClanMember opponent) {
        //Check if clan IDs match
        boolean clanIDsMatch = self.getClanID() == opponent.getClanID();

        //If opponent is in different clans --> fight
        if (!clanIDsMatch) {
            return actionPoints;
        }

        //If opponent is in same clan --> retreat
        else {
            return 0;
        }
    }
}
