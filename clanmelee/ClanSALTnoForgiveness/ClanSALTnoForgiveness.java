package clanmelee.ClanSALTnoForgiveness;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * No forgiveness.  No mercy.
 */
public class ClanSALTnoForgiveness extends Clan {

    // Calculated warrior
    private ActionPointDecider airman;

    // Smart warrior
    private ActionPointDecider armsman;

    // Advanced healer
    private ActionPointDecider aide;

    // Heavy healer
    private ActionPointDecider doctor;

    // Basic healer
    private ActionPointDecider nurse;

    // Arrow-to-the-knee warrior
    private ActionPointDecider scout;

    // Basic warrior
    private ActionPointDecider seaman;

    // Advanced warrior
    private ActionPointDecider sharpshooter;

    // Heavy warrior
    private ActionPointDecider soldier;

    // Clueless warrior
    private ActionPointDecider tenderfoot;

    public ClanSALTnoForgiveness(int id) {
        super("clanmelee/ClanSALTnoForgiveness", id);
        airman = new AirmanDecider();
        armsman = new ArmsmanDecider();
        aide = new AideDecider();
        doctor = new DoctorDecider();
        nurse = new NurseDecider();
        scout = new ScoutDecider();
        seaman = new SeamanDecider();
        sharpshooter = new SharpshooterDecider();
        soldier = new SoldierDecider();
        tenderfoot = new TenderfootDecider();
    }

    /**
     * Creates Clan of Fighting Artichokes by gathering members.
     * @param hitPoints the number of hit points to be distributed amongst all the clan members
     * @return all members to participate in the melee
     */
    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {

        ArrayList<ClanMember> members = new ArrayList<>();

        // Action points are determined based on MeleeConstants,
        // hence no parameters.

        // If low enough just make one warrior.
        if (hitPoints < MemberConstants.HIT_POINT_CAP / 10) {

            members.add(new ClanMember(getID(), WARRIOR, hitPoints, tenderfoot));
        }
        // If still low enough make two.
        else if (hitPoints < MemberConstants.HIT_POINT_CAP / 5) {

            members.add(new ClanMember(getID(), WARRIOR, hitPoints / 2, tenderfoot));
            members.add(new ClanMember(getID(), WARRIOR, hitPoints - hitPoints / 2, tenderfoot));
        }
        // Until a viable point, make a small squad.
        else if (hitPoints < MemberConstants.HIT_POINT_CAP * 2) {
            int hp = hitPoints * 2 / 11;

            members.add(new ClanMember(getID(), HEALER, hp, nurse));

            hp = (hitPoints - hp) / 3;

            members.add(new ClanMember(getID(), WARRIOR, hp, armsman));
            members.add(new ClanMember(getID(), WARRIOR, hp, airman));
            members.add(new ClanMember(getID(), WARRIOR, hp, seaman));
        }
        // Adds useless Swarmers to knock a few opponents down first iteration.
        else {
            for (int i = 0; i < hitPoints / 200; i++, hitPoints--) {
                members.add(new ClanMember(getID(), WARRIOR, 1, scout));
            }
            // Make as many Tanks and Surgeons with HP of cap.
            members.addAll(split(soldier, doctor, MemberConstants.HIT_POINT_CAP,
                    (hitPoints / MemberConstants.HIT_POINT_CAP) * MemberConstants.HIT_POINT_CAP, 1));

            // Remaining HP used to make many Medics and Snipers.
            members.addAll(split(sharpshooter, aide, MemberConstants.HIT_POINT_CAP / 10,
                    hitPoints % MemberConstants.HIT_POINT_CAP, 3.5));
        }

        return members;
    }

    /**
     * Splits up HP between 1 type of WARRIOR and 1 type of HEALER.
     * @param warrior WARRIOR type
     * @param healer HEALER type
     * @param nextHPAssignment how much HP per WARRIOR
     * @param unassignedHP total HP to give out
     * @param healerDetriment what fraction of WARRIOR HP HEALERS get
     * @return members
     */
    private ArrayList<ClanMember> split(ActionPointDecider warrior, ActionPointDecider healer,
                                        int nextHPAssignment, int unassignedHP, double healerDetriment) {
        ArrayList<ClanMember> members = new ArrayList<>();

        while (unassignedHP > 0) {
            // To prevent too much HP being given, or 0 HP given.
            if (unassignedHP < nextHPAssignment) {
                nextHPAssignment = unassignedHP;
            }

            if (Math.random() < 0.5) {
                members.add(new ClanMember(getID(), WARRIOR, nextHPAssignment, warrior));
                unassignedHP -= nextHPAssignment;
            } else {
                members.add(new ClanMember(getID(), HEALER, (int)(nextHPAssignment / healerDetriment), healer));
                unassignedHP -= nextHPAssignment / healerDetriment;
            }
        }
        return members;
    }
}
