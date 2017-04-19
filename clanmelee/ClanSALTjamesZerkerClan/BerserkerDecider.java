package clanmelee.ClanSALTjamesZerkerClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

/**
 * Created by jamesegallagher on 4/19/17.
 */
public class BerserkerDecider implements ActionPointDecider {
    private int actionPoints;

    public BerserkerDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /** We are gonna do a lot of damage **/
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        if(me.getClanID() != other.getClanID()) {
            return actionPoints*10;

        }
        else {
            return 0;
        }
    }
}
