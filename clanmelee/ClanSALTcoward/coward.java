package clanmelee.ClanSALTcoward;
/*
coward simulates the Zerg Character. It has a name and a clanID. It is given 10 ActionPoints. It has 20 HP

 */
import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class coward extends Clan {

    public coward(int clanID) {
        super("Barbarian", clanID);
    }

    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new cowardDecider(10);

        for (int i = 0; i < hitPoints; i++)
        {
            clanMembers.add(new ClanMember(getID(),WARRIOR,1,decider));
        }

        return clanMembers;
    }
}
