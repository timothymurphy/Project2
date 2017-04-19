package clanmelee.ClanSALTdStaxx;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Created by Devon on 4/18/17.
 */
public class dStaxxMedic implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public dStaxxMedic(int actionPoints) {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /**
     * Determines how much to heal.
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that "me" is interacting with
     * @return
     */
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        // If same team, heal otherwise run.

        if (me.getClanID() == other.getClanID()) {
            if (me.getHitPoints() == me.getMaxHitPoints()) {
                return actionPoints;
            }
        }
        return 0;
    }

}
