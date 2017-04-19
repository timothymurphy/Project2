package clanmelee.ClanSALTjamesZerkerClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;
/**
 * Created by jamesegallagher on 4/19/17.
 */
public class HealerBerserkerDecider implements ActionPointDecider{
    private int actionPoints;

    public HealerBerserkerDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        if(me.getClanID() == other.getClanID()) {
            if(other.getHitPoints() <= other.getMaxHitPoints()) {
                return actionPoints * 10;
            }
            if(other.getHitPoints() == other.getMaxHitPoints()) {
                return 0;
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
