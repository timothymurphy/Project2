package clanmelee.ClanSALTzergAddons;
/*
AssassinDecider collects actionPoints from the ActionPointDecider. decideActionPoints is the action it will do.
If it meets an enemy warrior who has <33% hp remaining, it will attack 3 times, otherwise, it will attack 1 time. If it
meets an enemy healer, it will attack 2 times.
 */

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class AssassinDecider implements ActionPointDecider {
    private int actionPoints;

    public AssassinDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (!clanIDsMatch && other.getType() == WARRIOR) {
            if (other.getHitPoints() <= (other.getMaxHitPoints() / 3)) {
                return actionPoints * 3;
            }
            else {
                return actionPoints;
            }
        }

        if (!clanIDsMatch && other.getType() == HEALER) {
            return actionPoints * 2;
        }
        return  0;
    }
}
