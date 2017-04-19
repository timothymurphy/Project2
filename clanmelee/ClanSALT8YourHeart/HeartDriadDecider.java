package clanmelee.ClanSALT8YourHeart;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;
import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;
/**
 * Created by manahax on 4/18/17.
 */
public class HeartDriadDecider implements ActionPointDecider{
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public HeartDriadDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /**
     * Heals members of the clan to their max health.
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */
    public int decideActionPoints(ClanMember me, ClanMember other) {

        if (me.getClanID() == other.getClanID()) {
            return other.getMaxHitPoints() - other.getHitPoints() - 1;
        }
        return 0;
    }
}
