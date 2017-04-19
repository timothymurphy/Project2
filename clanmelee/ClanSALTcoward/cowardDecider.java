package clanmelee.ClanSALTcoward;
/*
cowardDecider collects actionPoints from ActionPointDecider.
 */
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class cowardDecider implements ActionPointDecider {
    private int actionPoints;

    public cowardDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (other.getHitPoints()<10)
            return actionPoints;
        return 0;
    }
}
