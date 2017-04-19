package clanmelee.ClanSALTsaltGolems;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class SaltMenderDecider implements ActionPointDecider {
    public int decideActionPoints(ClanMember me, ClanMember other) {
        int maxHealAP = 10;
        int maxWarrAP = (((me.getMaxHitPoints() / 2) - 1) * 2) + 10;
        if (me.getClanID() == other.getClanID()) {
            if (other.getType() == ClanMember.ClanMemberType.WARRIOR) {
                return maxWarrAP;
            }
            else {
                return maxHealAP;
            }
        }
        else {
            return 0;
        }
    }
}
