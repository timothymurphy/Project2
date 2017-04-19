package clanmelee.ClanSALTzergAddons;
/*
ZergMember simulates the Barbarian Character. It has a name and a clanID. It is given 10 ActionPoints. It has 500 HP

 */
import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class BarbarianMember extends Clan {

    public BarbarianMember(int clanID) {
        super("Barbarian", clanID);
    }

    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new BarbarianDecider(10);

        int adjHitPoints = (int)(hitPoints * .30);
        while (adjHitPoints > 0) {
            int nextHP = 500;
            if (adjHitPoints < 500) {
                nextHP = adjHitPoints;
            }

            clanMembers.add(new ClanMember(getID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
