package clanmelee.ClanSALTzergAddons;
/*
ZergMember simulates the Zerg Character. It has a name and a clanID. It is given 10 ActionPoints. It has 20 HP

 */
import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class ZergMember extends Clan {

    public ZergMember(int clanID) {
        super("Barbarian", clanID);
    }

    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new ZergDecider(10);


        for (int i = 0; i < 10000000; i++)
        {
            clanMembers.add(new ClanMember(getID(),WARRIOR,0,decider));
        }
        /*
        int adjHitPoints = (int)(hitPoints * .30);
        while (adjHitPoints > 0) {
            int nextHP = 20;
            if (adjHitPoints < 20) {
                nextHP = adjHitPoints;
            }

            clanMembers.add(new ClanMember(getID(), WARRIOR, nextHP, decider));

          */
        return clanMembers;
    }
}
