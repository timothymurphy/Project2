package clanmelee.ClanSALTdStaxx;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Created by Devon on 4/18/17.
 */
public class dStaxxSoldier implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public dStaxxSoldier(int actionPoints) {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /**
     * Determines how to attack
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        //if different team attack
        if(me.getClanID() != other.getClanID())
        {
            //If other health is 1/3 me health, attack with twice actionPoints (if my health allows)
            if(other.getHitPoints() < (me.getHitPoints()/3) && me.getHitPoints() > (((2*actionPoints)-actionPoints)/2))
                return 2*actionPoints;
            else
                return actionPoints;
        }

        // If same team, run.
        else
            return 0;

    }
}
