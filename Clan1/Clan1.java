package clanmelee.Clan1;

import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

public class Clan1 extends Clan {

    public Clan1(int clanID) {
        super("Clan1", clanID);
    }
    /**
     * This class serves as the main factory which brings together all clan member types into a final list.
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        StandardHealerMember stdHealer = new StandardHealerMember(getClanID());
        AdvancedHealerMember advHealer = new AdvancedHealerMember(getClanID());
        BarbarianMember Barbarian = new BarbarianMember(getClanID());
        AssassinMember Assassin = new AssassinMember(getClanID());

        fullClanMembers.addAll(stdHealer.getClanMembers(hitPoints));
        fullClanMembers.addAll(advHealer.getClanMembers(hitPoints));
        fullClanMembers.addAll(Barbarian.getClanMembers(hitPoints));
        fullClanMembers.addAll(Assassin.getClanMembers(hitPoints));

        return fullClanMembers;
    }
}
