package clanmelee.ClanSALTsaltGolems;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class SaltGolemDecider implements ActionPointDecider {
    public int decideActionPoints(ClanMember me, ClanMember other) {
        int maxHealAP = (((me.getHitPoints() / 2) - 1) * 2) + 11;
        int maxWarrAP = ((me.getMaxHitPoints() / 2 - 1) * 2) + 10;

        if (me.getClanID() == other.getClanID()) {
            return 0;
        }
        else {
            if (other.getType() == ClanMember.ClanMemberType.HEALER) {
                if (other.getHitPoints() < maxHealAP) {
                    return other.getHitPoints();
                }
                else {
                    return maxHealAP;
                }
            }
            else {
                if (other.getHitPoints() < maxWarrAP) {
                    return other.getHitPoints();
                }
                else {
                    return maxWarrAP;
                }
            }
        }
    }
}
