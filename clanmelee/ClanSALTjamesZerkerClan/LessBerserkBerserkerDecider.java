package clanmelee.ClanSALTjamesZerkerClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Created by jamesegallagher on 4/19/17.
 */
public class LessBerserkBerserkerDecider implements ActionPointDecider {
    private int actionPoints;

    public LessBerserkBerserkerDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /** We are gonna do a lot of damage **/
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        if(me.getClanID() != other.getClanID()) {
            if(me.getHitPoints() == me.getMaxHitPoints()) {
                return actionPoints;
            }
            if(me.getHitPoints() >= me.getMaxHitPoints()/2) {
                return actionPoints * 5;
            }
            if(me.getHitPoints() <= me.getHitPoints()/2) {
                return actionPoints * 10;
            }
            else {
                return actionPoints;
            }

        }
        else {
            return 0;
        }
    }
}