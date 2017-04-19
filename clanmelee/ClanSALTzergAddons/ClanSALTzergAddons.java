package clanmelee.ClanSALTzergAddons;

import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

public class ClanSALTzergAddons extends Clan {

    public ClanSALTzergAddons(int clanID)
    {
        super("clanmelee/ClanSALTzergAddons", clanID);
    }
    /**
     * This class serves as the main factory which brings together all clan member types into a final list.
     */
    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {
        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        StandardHealerMember stdHealer = new StandardHealerMember(getID());
        AdvancedHealerMember advHealer = new AdvancedHealerMember(getID());
        BarbarianMember Barbarian = new BarbarianMember(getID());
        AssassinMember Assassin = new AssassinMember(getID());

        if (hitPoints>1000)
        {
            ZergMember ZergWarrior = new ZergMember(getID());
            ZergHealerMember ZergHealer = new ZergHealerMember(getID());

            fullClanMembers.addAll(ZergWarrior.getMembers(hitPoints));
            fullClanMembers.addAll(ZergHealer.getMembers(hitPoints));
        }

        fullClanMembers.addAll(stdHealer.getMembers(hitPoints));
        fullClanMembers.addAll(advHealer.getMembers(hitPoints));
        fullClanMembers.addAll(Barbarian.getMembers(hitPoints));
        fullClanMembers.addAll(Assassin.getMembers(hitPoints));


        return fullClanMembers;
    }
}
