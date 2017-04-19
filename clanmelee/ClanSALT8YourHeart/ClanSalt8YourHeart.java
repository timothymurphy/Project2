package clanmelee.ClanSALT8YourHeart;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;
import java.util.ArrayList;
import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by manahax on 4/18/17.
 */
public class ClanSalt8YourHeart extends Clan {
    /**
     * Manasseh's Clan, the 8 Your Heart.
     */
    public ClanSalt8YourHeart(int id) {
        super("clanmelee/ClanSALT8YourHeart", id);
    }

    /**
     * Creates Clan of 8 Your Hearts by gathering members.
     *
     * @param hitPoints the number of hit points to be distributed amongst all the clan members
     * @return all members to participate in the melee
     */
    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {

        ArrayList<ClanMember> members = new ArrayList<>();

        // Action points are determined based on MeleeConstants,
        // hence no parameters.

        // Normal healer
        ActionPointDecider medic = new HeartMedicDecider();

        // Normal warrior
        ActionPointDecider Grunt = new HeartGruntDecider();

        // Heavy healer
        ActionPointDecider Driad = new HeartDriadDecider();

        // Preserved warrior
        ActionPointDecider Palladin = new HeartPallyDecider();

        // Heavy warrior
        ActionPointDecider Golem = new HeartGolemDecider();

        // Adds 5 reliable Palladins
        for (int i = 0; i < 5; i++) {
            members.add(new ClanMember(getID(), WARRIOR, (hitPoints / 5) / 5, Palladin));
        }
        for (int i = 0; i < 5; i++) {
            members.add(new ClanMember(getID(), WARRIOR, (hitPoints / 5) / 5, Golem));
        }
        for (int i = 0; i < 5; i++) {
            members.add(new ClanMember(getID(), WARRIOR, (hitPoints / 5) / 5, Grunt));
        }
        for (int i = 0; i < 5; i++) {
            members.add(new ClanMember(getID(), HEALER, (hitPoints / 5) / 5, Driad));
        }
        for (int i = 0; i < 5; i++) {
            members.add(new ClanMember(getID(), HEALER, (hitPoints / 5) / 5, medic));
        }
        return members;
    }
}