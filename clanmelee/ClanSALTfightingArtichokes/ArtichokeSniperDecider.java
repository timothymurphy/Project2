package clanmelee.ClanSALTfightingArtichokes;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Vanilla warrior.
 */
public class ArtichokeSniperDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public ArtichokeSniperDecider() {
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
        if (me.getClanID() != other.getClanID()) {
            // If they are a healer...
            if (other.getType() == ClanMember.ClanMemberType.HEALER) {
                // If they are stronger than me and they are weakened extremely, deal thrice damage.
                if (other.getHitPoints() > me.getHitPoints() && other.getHitPoints() <= other.getMaxHitPoints() / 3) {
                    return actionPoints * 3;
                }
                // Deal normal AP (plus bonus if me is full health)
                if (me.getHitPoints() == me.getMaxHitPoints()) {
                    return actionPoints + MemberConstants.ACTION_POINTS_PER_ITERATION_DAMAGE_POINT;
                }
                return actionPoints;
            }
            // If they are a warrior, deal action points times reciprocal of opponents health percentage.
            if (other.getHitPoints() == 0 || other.getMaxHitPoints() / other.getHitPoints() == 1) {
                if (me.getHitPoints() == me.getMaxHitPoints()) {
                    return actionPoints + MemberConstants.ACTION_POINTS_PER_ITERATION_DAMAGE_POINT;
                }
                return actionPoints;
            }
            return actionPoints * Math.min(11, other.getMaxHitPoints() / other.getHitPoints());
        }
        return 0;
    }
}
