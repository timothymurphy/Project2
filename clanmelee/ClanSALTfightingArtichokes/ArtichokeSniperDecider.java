package clanmelee.ClanSALTfightingArtichokes;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Created by mathemuse on 4/10/17.
 */
public class ArtichokeSniperDecider implements ActionPointDecider {
    private int actionPoints;

    public ArtichokeSniperDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        if (me.getClanID() != other.getClanID()) {
            if (other.getType() == ClanMember.ClanMemberType.HEALER) {
                if (other.getHitPoints() > me.getHitPoints() && other.getHitPoints() <= other.getMaxHitPoints() / 3) {
                    return actionPoints * 3;
                }
                if (me.getHitPoints() == me.getMaxHitPoints()) {
                    return actionPoints + MemberConstants.ACTION_POINTS_PER_ITERATION_DAMAGE_POINT;
                }
                return actionPoints;
            }
            if (other.getHitPoints() == 0 || other.getMaxHitPoints() / other.getHitPoints() == 1) {
                return actionPoints + MemberConstants.ACTION_POINTS_PER_ITERATION_DAMAGE_POINT;
            }
            return actionPoints * Math.min(11, other.getMaxHitPoints() / other.getHitPoints());
        }
        return 0;
    }
}
