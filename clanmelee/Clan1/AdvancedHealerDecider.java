package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class AdvancedHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public AdvancedHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (clanIDsMatch && other.getHitPoints() < (other.getMaxHitPoints() / 2)) {
            return actionPoints;
        } else {
            return 0;
        }
    }
}
