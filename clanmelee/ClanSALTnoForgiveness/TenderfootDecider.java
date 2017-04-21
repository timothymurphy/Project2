package clanmelee.ClanSALTnoForgiveness;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Clueless warrior.
 */
public class TenderfootDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to the amount of free action points.
     */
    public TenderfootDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /**
     * If opponent, deal as much damage as possible.
     * If not, run away.
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        // If opponent, attack.  Else, run.
        if (me.getClanID() != other.getClanID()) {

            // Last stand, give everything I got.
            if (me.getHitPoints() == 1) {
                return actionPoints + 2;
            }

            // Fire as much as necessary without dying.
            return Math.min(me.getHitPoints() * 2 + actionPoints - 1, other.getHitPoints());
        }

        // To prevent runaway penalty if necessary.
        if (other.getHitPoints() == other.getMaxHitPoints()) {
            return 1;
        }

        return 0;
    }
}
