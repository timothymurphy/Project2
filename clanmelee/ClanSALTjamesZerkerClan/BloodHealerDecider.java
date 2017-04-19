package clanmelee.ClanSALTjamesZerkerClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;
/**
 * Created by jamesegallagher on 4/19/17.
 */
public class BloodHealerDecider implements ActionPointDecider{
    private int actionPoints;

    public BloodHealerDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        if(me.getClanID() == other.getClanID()) {
            actionPoints = (other.getMaxHitPoints() - other.getHitPoints()) + 10;
            return actionPoints;

        }
        else {
            return 0;
        }
    }
}