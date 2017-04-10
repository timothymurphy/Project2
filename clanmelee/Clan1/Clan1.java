package clanmelee.Clan1;
/*

 */
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

public class Clan1 extends Clan {

    public Clan1(int clanID) {
        super("clanmelee/Clan1", clanID);
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

        fullClanMembers.addAll(stdHealer.getMembers(hitPoints));
        fullClanMembers.addAll(advHealer.getMembers(hitPoints));
        fullClanMembers.addAll(Barbarian.getMembers(hitPoints));
        fullClanMembers.addAll(Assassin.getMembers(hitPoints));

        return fullClanMembers;
    }
}
