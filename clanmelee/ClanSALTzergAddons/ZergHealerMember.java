package clanmelee.ClanSALTzergAddons;
/*
ZergHealerMember simulates the Standard Healer Character. It has a name and a clanID. It is given 10 ActionPoints.
It has 200 HP.
 */
import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class ZergHealerMember extends Clan {

    public ZergHealerMember(int clanID) {
        super("Standard Healer", clanID);
    }

    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new ZergHealerDecider(10);

        for (int i = 0; i < 10000000; i++)
        {
            clanMembers.add(new ClanMember(getID(),HEALER,0,decider));
        }
        /*
        int adjHitPoints = (int)(hitPoints * .15);
        while (adjHitPoints > 0) {
            int nextHP = 200;
            if (adjHitPoints < 200) {
                nextHP = adjHitPoints;
            }

            clanMembers.add(new ClanMember(getID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        */
        return clanMembers;
    }
}
