package clanmelee.ClanSALTzergAddons;
/*
ZergDecider collects actionPoints from ActionPointDecider.
 */
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class ZergDecider implements ActionPointDecider {
    private int actionPoints;

    public ZergDecider(int actionPoints) {
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
