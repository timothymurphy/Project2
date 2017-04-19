package clanmelee.ClanSALTdStaxx;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Created by Devon on 4/18/17.
 */
public class dStaxxArtillery implements ActionPointDecider
{
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public dStaxxArtillery(int actionPoints) {
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

        //if different team attack
        if(me.getClanID() != other.getClanID())
        {
            //Attack with quintuple actionPoints (if my health allows)
            if(me.getHitPoints() > (((5*actionPoints)-actionPoints)/2))
                return 5*actionPoints;
            //Attack with quadruple actionPoints (if my health allows)
            if(me.getHitPoints() > (((4*actionPoints)-actionPoints)/2))
                return 4*actionPoints;
            //Attack with triple actionPoints (if my health allows)
            if(me.getHitPoints() > (((3*actionPoints)-actionPoints)/2))
                return 3*actionPoints;
            //Attack with double actionPoints (if my health allows)
            if(me.getHitPoints() > (((2*actionPoints)-actionPoints)/2))
                return 2*actionPoints;
            //If not enough health, attack with free actionPoints
            else
                return actionPoints;
        }

        // If same team, run.
        else
            return 0;
    }
}
