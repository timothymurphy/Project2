package clanmelee.ClanSALTnoForgiveness;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Arrow-to-the-knee warrior.
 */
public class ScoutDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public ScoutDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /**
     * If an opponent, will return initial action points plus twice the amount of HP it has,
     * effectively killing it and possibly the opponent instantly.
     * If not, run away.
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        if (me.getClanID() != other.getClanID()) {
            return actionPoints + MemberConstants.ACTION_POINTS_PER_ITERATION_DAMAGE_POINT * me.getHitPoints();
        }

        // To prevent runaway penalty if necessary.
        if (other.getHitPoints() == other.getMaxHitPoints()) {
            return 1;
        }

        return 0;
    }
}
