package clanmelee.ClanSALTzergAddons;
/*
AdvancedHealerDecider collects actionPoints from the ActionPointDecider. decideActionPoints is the action it will do.
If it meets another member who has <50% MaxHitPoints, it will heal them, otherwise, it will do nothing.
 */

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
