package clanmelee.ClanSALT8YourHeart;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;
import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;
/**
 * Created by manahax on 4/18/17.
 */
public class HeartMedicDecider implements ActionPointDecider{
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public HeartMedicDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /**
     * Fluidly determines how much to heal.
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */

    public int decideActionPoints(ClanMember me, ClanMember other) {

        // If same team, heal.  Else, run.
        if (me.getClanID() == other.getClanID()) {
            // If they are extremely damaged, heal extra.
            if (other.getHitPoints() < me.getHitPoints()) {
                return actionPoints * 3;
            }
            // Heal normal, with a bonus if I am full health.
            if (me.getHitPoints() == me.getMaxHitPoints())
                return actionPoints + MemberConstants.ACTION_POINTS_PER_ITERATION_DAMAGE_POINT;
            return actionPoints;
        }
        return 0;
    }
}
