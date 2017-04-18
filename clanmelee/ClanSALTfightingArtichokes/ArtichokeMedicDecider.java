package clanmelee.ClanSALTfightingArtichokes;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Vanilla healer
 */
public class ArtichokeMedicDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public ArtichokeMedicDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /**
     * Fluidly determines how much to heal
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        // If same team, heal.  Else, run.
        if (me.getClanID() == other.getClanID()) {
            // If they are extremely damaged, heal extra.
            if (other.getHitPoints() < me.getHitPoints()) {
                return actionPoints * 3;
            }
            // Heal normal, with a bonus if I am full health.
            if (me.getHitPoints() == me.getMaxHitPoints())
                return actionPoints + MemberConstants.ACTION_POINTS_PER_ITERATION_DAMAGE_POINT;
            return actionPoints;
        }
        return 0;
    }
}
