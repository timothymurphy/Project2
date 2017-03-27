package clanmelee.Clan1;

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
