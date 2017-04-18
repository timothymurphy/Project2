package clanmelee.ClanSALTfightingArtichokes;

/**
 * Created by mathemuse on 4/17/17.
 */

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

public class ArtichokeSwarmerDecider implements ActionPointDecider {
    private int actionPoints;

    public ArtichokeSwarmerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        if (me.getClanID() != other.getClanID()) {
            return actionPoints + MemberConstants.ACTION_POINTS_PER_ITERATION_DAMAGE_POINT * me.getHitPoints();
        }
        return 0;
    }
}
