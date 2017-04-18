package clanmelee.ClanSALTfightingArtichokes;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

/**
 * Created by mathemuse on 4/12/17.
 */
public class ArtichokeSurgeonDecider implements ActionPointDecider {
    private int actionPoints;

    public ArtichokeSurgeonDecider(int actionPoints) {
        this.actionPoints = actionPoints;
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
