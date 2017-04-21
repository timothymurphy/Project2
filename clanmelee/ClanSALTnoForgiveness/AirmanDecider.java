package clanmelee.ClanSALTnoForgiveness;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Calculated warrior.
 */
public class AirmanDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public AirmanDecider() {
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

            // If other health is 1/3 my health, attack with twice actionPoints (if my health allows)
            if(other.getHitPoints() < me.getHitPoints() / 3 && me.getHitPoints() > actionPoints * .5) {
                return 2 * actionPoints;
            }

            // Attack normal, with a bonus if I am full health.
            if (me.getHitPoints() == me.getMaxHitPoints())
                return actionPoints + MemberConstants.ACTION_POINTS_PER_ITERATION_DAMAGE_POINT;
            return actionPoints;
        }
        // To prevent runaway penalty if necessary.
        if (other.getHitPoints() == other.getMaxHitPoints()) {
            return 1;
        }

        return 0;
    }
}
