package clanmelee.ClanSALT8YourHeart;
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by manahax on 4/18/17.
 */
public class HeartPallyDecider implements ActionPointDecider{
    private int actionPoints;

    /**
     * Sets action points to amount of free action points.
     */
    public HeartPallyDecider() {
        this.actionPoints = MemberConstants.FREE_ACTION_POINTS;
    }

    /**
     * If a warrior, will return initial action points if it has more or even HP with opponent.
     * If my health is below 1/4, will kamekaze on the field
     * If a Healer, will attack normally
     * Otherwise run away
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return
     */
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        if (me.getClanID() != other.getClanID()) {
            if (other.getType() == WARRIOR) {
                if (me.getHitPoints() >= other.getHitPoints())
                    return actionPoints;
                if (me.getHitPoints() <= (me.getMaxHitPoints() / 4))
                    return actionPoints + MemberConstants.ACTION_POINTS_PER_ITERATION_DAMAGE_POINT * me.getHitPoints();
            }
            if (other.getType()== HEALER){
                return actionPoints;
            }
        }
        return 0;
    }
}
