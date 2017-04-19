package clanmelee.ClanSALT8YourHeart;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;
import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;
/**
 * Created by manahax on 4/18/17.
 */
public class HeartGolemDecider implements ActionPointDecider{
    private int actionPoints;

    /**
     * Sets action points to 5 times the amount of free action points,
     * dealing twice the normal action points in HP to self.
     */
    public HeartGolemDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS * 5;
    }

    /**
     * If opponent, deal damage.
     * If not, run away.
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */
    public int decideActionPoints(ClanMember me, ClanMember other) {

        if (me.getClanID() != other.getClanID()) {
            return actionPoints;
        }
        return 0;
    }
}
