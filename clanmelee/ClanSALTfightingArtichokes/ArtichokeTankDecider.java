package clanmelee.ClanSALTfightingArtichokes;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

/**
 * Created by mathemuse on 4/10/17.
 */
public class ArtichokeTankDecider implements ActionPointDecider {
    private int actionPoints;

    public ArtichokeTankDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        if (me.getClanID() != other.getClanID()) {
            return actionPoints * 5;
        }
        return 0;
    }
}
