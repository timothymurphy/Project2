package clanmelee.ClanSALTdStaxx;

import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;


/**
 * Created by Devon on 4/18/17.
 */
public class ClanSALTdStaxx extends Clan
{
    public ClanSALTdStaxx(int id) {
        super("clanmelee/ClanSALTdStaxx", id);
    }

    /**
     * Creates Clan of dStaxx of all members
     * @param hitPoints the number of hit points to be distributed amongst all the clan members
     * @return all members to participate in the melee
     */
    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {

        ArrayList<ClanMember> allMembers = new ArrayList<>();

        dStaxxMedicMember medic = new dStaxxMedicMember(getID());

        dStaxxSoldierMember soldier = new dStaxxSoldierMember(getID());

        dStaxxTriggerHappySoldierMember triggerHappySoldier = new dStaxxTriggerHappySoldierMember(getID());

        dStaxxArtilleryMember artillery = new dStaxxArtilleryMember(getID());

        allMembers.addAll(medic.getMembers(hitPoints));
        allMembers.addAll(artillery.getMembers(hitPoints));
        allMembers.addAll(soldier.getMembers(hitPoints));
        allMembers.addAll(triggerHappySoldier.getMembers(hitPoints));

        return allMembers;

    }
}
