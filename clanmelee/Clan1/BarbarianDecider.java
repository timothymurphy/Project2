package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class BarbarianDecider implements ActionPointDecider {
    private int actionPoints;

    public BarbarianDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (!clanIDsMatch) {
            return actionPoints;
        } else {
            return 0;
        }
    }
}
