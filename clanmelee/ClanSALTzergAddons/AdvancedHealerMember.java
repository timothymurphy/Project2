package clanmelee.ClanSALTzergAddons;
/*
AdvancedHealerMember simulates the Advanced Healer Character. It has a name and a clanID. It is given 20 ActionPoints.
It has 600 HP.
 */
import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class AdvancedHealerMember extends Clan{

    public AdvancedHealerMember(int clanID) {
        super("Advanced Healer", clanID);
    }

    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new AdvancedHealerDecider(20);

        int adjHitPoints = (int)(hitPoints * .15);
        while (adjHitPoints > 0) {
            int nextHP = 600;
            if (adjHitPoints < 600) {
                nextHP = adjHitPoints;
            }

            clanMembers.add(new ClanMember(getID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
