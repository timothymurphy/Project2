package clanmelee.ClanSALTnoForgiveness;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Basic healer.
 */
public class NurseDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public NurseDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /**
     * Fluidly determines how much to heal.
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        // If same team, heal.  Else, run.
        if (me.getClanID() == other.getClanID()) {

            // Heal normal, with a bonus if I am full health.
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
