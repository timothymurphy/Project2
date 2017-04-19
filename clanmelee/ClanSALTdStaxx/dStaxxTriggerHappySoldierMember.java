package clanmelee.ClanSALTdStaxx;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by Devon on 4/18/17.
 */
public class dStaxxTriggerHappySoldierMember extends Clan {
    public dStaxxTriggerHappySoldierMember(int clanID) {
        super("Team dStaxx Artillery", clanID);
    }

    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new dStaxxMedic(10);

        int adjHitPoints = (int)(hitPoints * .20);
        while (adjHitPoints > 0) {
            int nextHP = 300;
            if (adjHitPoints < 300) {
                nextHP = adjHitPoints;
            }
            clanMembers.add(new ClanMember(getID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}