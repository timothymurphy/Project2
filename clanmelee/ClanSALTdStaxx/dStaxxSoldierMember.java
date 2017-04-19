package clanmelee.ClanSALTdStaxx;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by Devon on 4/18/17.
 */
public class dStaxxSoldierMember extends Clan {
    public dStaxxSoldierMember(int clanID) {
        super("Team dStaxx Artillery", clanID);
    }

    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new dStaxxMedic(10);

        for (int i = 0; i < 150000; i++) {
            clanMembers.add(new ClanMember(getID(),WARRIOR,0,decider));
        }
        return clanMembers;
    }
}