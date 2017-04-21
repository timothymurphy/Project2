package clanmelee.ClanSALTnoForgiveness;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Basic warrior.
 */
public class SeamanDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public SeamanDecider() {
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
        if (me.getClanID() == other.getClanID()) {

            // Attack normal, with a bonus if I am full health.
            if (me.getHitPoints() == me.getMaxHitPoints())
                return actionPoints + MemberConstants.ACTION_POINTS_PER_ITERATION_DAMAGE_POINT;

            return actionPoints;
        }

        // To prevent runaway penalty if necessary.
        if (other.getHitPoints() + 1 >= other.getMaxHitPoints()) {
            return 1;
        }

        return 0;
    }
}
