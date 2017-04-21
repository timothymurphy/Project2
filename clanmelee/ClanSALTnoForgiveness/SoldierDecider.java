package clanmelee.ClanSALTnoForgiveness;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Heavy warrior.
 */
public class SoldierDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to 5 times the amount of free action points,
     * dealing twice the normal action points in HP to self.
     */
    public SoldierDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS * 5;
    }

    /**
     * If opponent, deal damage.
     * If not, run away.
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        if (me.getClanID() != other.getClanID()) {
            return Math.min(actionPoints, other.getHitPoints());
        }

        // To prevent runaway penalty if necessary.
        if (other.getHitPoints() == other.getMaxHitPoints()) {
            return 1;
        }

        return 0;
    }
}
