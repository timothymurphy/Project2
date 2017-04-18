package clanmelee.ClanSALTfightingArtichokes;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Heavy healer
 */
public class ArtichokeSurgeonDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public ArtichokeSurgeonDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        if (me.getClanID() == other.getClanID()) {
            if ((other.getMaxHitPoints() - other.getHitPoints()) > actionPoints) {
                return other.getMaxHitPoints() - other.getHitPoints() + 1;
            }
            return actionPoints;
        }
        return 0;
    }
}
