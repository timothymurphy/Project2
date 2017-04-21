package clanmelee.ClanSALTnoForgiveness;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Smart warrior.
 */
public class ArmsmanDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public ArmsmanDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /**
     * Determines how much damage to deal fluidly.
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        // If opponent, attack.  Else, run.
        if(me.getClanID() != other.getClanID()) {

            // Attack with quintuple actionPoints (if my health allows)
            if (me.getHitPoints() > (actionPoints * 2)) {
                return 5 * actionPoints;
            }
            // Attack with quadruple actionPoints (if my health allows)
            if (me.getHitPoints() > (actionPoints * 1.5)) {
                return 4 * actionPoints;
            }
            // Attack with triple actionPoints (if my health allows)
            if (me.getHitPoints() > (actionPoints)) {
                return 3 * actionPoints;
            }
            // Attack with double actionPoints (if my health allows)
            if (me.getHitPoints() > (actionPoints * .5)) {
                return 2 * actionPoints;
            }
            // If not enough health, attack with free actionPoints
            return actionPoints;
        }

        // To prevent runaway penalty if necessary.
        if (other.getHitPoints() == other.getMaxHitPoints()) {
            return 1;
        }

        return 0;
    }
}
