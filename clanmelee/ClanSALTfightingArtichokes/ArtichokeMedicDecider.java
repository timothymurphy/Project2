package clanmelee.ClanSALTfightingArtichokes;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Created by mathemuse on 4/10/17.
 */
public class ArtichokeMedicDecider implements ActionPointDecider {
    private int actionPoints;

    public ArtichokeMedicDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        if (me.getClanID() == other.getClanID()) {
            if (other.getHitPoints() < me.getHitPoints()) {
                return actionPoints * 3;
            }
            if (me.getHitPoints() == me.getMaxHitPoints())
                return actionPoints + MemberConstants.ACTION_POINTS_PER_ITERATION_DAMAGE_POINT;
            return actionPoints;
        }
        return 0;
    }
}
