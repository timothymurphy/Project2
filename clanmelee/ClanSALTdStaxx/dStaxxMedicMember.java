package clanmelee.ClanSALTdStaxx;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

/**
 * Created by Devon on 4/18/17.
 */
public class dStaxxMedicMember extends Clan {

    public dStaxxMedicMember(int clanID) {
        super("Team dStaxx Medic Healer", clanID);
    }

    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new dStaxxMedic(10);

        int adjHitPoints = (int)(hitPoints * .2);
        while (adjHitPoints > 0) {
            int nextHP = 200;
            if (adjHitPoints < 200) {
                nextHP = adjHitPoints;
            }
            clanMembers.add(new ClanMember(getID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}