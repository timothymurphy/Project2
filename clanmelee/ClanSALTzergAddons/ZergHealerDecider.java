package clanmelee.ClanSALTzergAddons;
/*
ZergHealerDecider collects actionPoints from the ActionPointDecider. decideActionPoints is the action it will do.
If it meets another member, it will heal them, otherwise, it will do nothing.
 */
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class ZergHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public ZergHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (clanIDsMatch) {
            return actionPoints;
        }
        else {
            return 0;
        }
    }
}