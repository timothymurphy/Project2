package clanmelee.ClanSALTfightingArtichokes;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Heavy healer.
 */
public class ArtichokeSurgeonDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public ArtichokeSurgeonDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /**
     * Heals members of the clan to their max health.
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        if (me.getClanID() == other.getClanID()) {
            return other.getMaxHitPoints() - other.getHitPoints() - 1;
        }
        return 0;
    }
}
