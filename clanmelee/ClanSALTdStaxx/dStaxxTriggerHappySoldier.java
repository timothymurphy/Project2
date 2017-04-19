package clanmelee.ClanSALTdStaxx;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Created by Devon on 4/18/17.
 */
public class dStaxxTriggerHappySoldier implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public dStaxxTriggerHappySoldier(int actionPoints) {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /**
     * Determines how to attack
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other)
    {

        // If same team, run.

        if (me.getClanID() == other.getClanID())
        {
            return 0;
        }

        //if different team attack with only free actionPoints

        else
            return actionPoints;
    }
}
