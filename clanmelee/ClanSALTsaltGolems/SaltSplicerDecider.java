package clanmelee.ClanSALTsaltGolems;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

/**
 * Created by cFournierg on 4/19/17.
 */
public class SaltSplicerDecider implements ActionPointDecider {
    public int decideActionPoints(ClanMember me, ClanMember other) {
        other.dealDamage(other.getHitPoints());
        return 0;
    }
}
