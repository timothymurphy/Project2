package clanmelee.ClanSALTfightingArtichokes;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by mathemuse on 4/12/17.
 */

/**
 * Ed's Clan, the Fighting Artichokes.
 */
public class ClanSALTfightingArtichokes extends Clan {

    public ClanSALTfightingArtichokes(int id) {
        super("clanmelee/ClanSALTfightingArtichokes", id);
    }

    /**
     * Creates Clan of Fighting Artichokes by gathering members.
     *
     * @param hitPoints the number of hit points to be distributed amongst all the clan members
     * @return all members to participate in the melee
     */
    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {

        ArrayList<ClanMember> members = new ArrayList<>();

        // Vanilla healer
        ActionPointDecider medic =
                new ArtichokeMedicDecider(MemberConstants.FREE_ACTION_POINTS);

        // Vanilla warrior
        ActionPointDecider sniper =
                new ArtichokeSniperDecider(MemberConstants.FREE_ACTION_POINTS);

        // Selfless healer
        ActionPointDecider surgeon =
                new ArtichokeSurgeonDecider(MemberConstants.FREE_ACTION_POINTS);

        // Arrow-to-the-knee warrior
        ActionPointDecider swarmer =
                new ArtichokeSwarmerDecider(MemberConstants.FREE_ACTION_POINTS);

        // Heavy warrior
        ActionPointDecider tank =
                new ArtichokeTankDecider(MemberConstants.FREE_ACTION_POINTS);

        // Adds useless Swarmers to knock a few opponents down first iteration.
        for (int i = 0; i < hitPoints; i++) {
            members.add(new ClanMember(getID(), WARRIOR, 0, swarmer));
        }

        // If possible, make some Tanks and Surgeons with HP of cap.
        // Will return without any new if HP is below HP Cap.
        members = split(members, tank, surgeon, MemberConstants.HIT_POINT_CAP,
                (hitPoints / MemberConstants.HIT_POINT_CAP) * MemberConstants.HIT_POINT_CAP, 1);

        // Shortens the HP to be assigned.
        int nextHpAssignment = (hitPoints % MemberConstants.HIT_POINT_CAP) / 5;

        // Remaining HP used to make Medics and Snipers.
        return split(members, sniper, medic, nextHpAssignment,
                hitPoints % MemberConstants.HIT_POINT_CAP, 4);
    }

    /**
     * Splits up HP between 1 type of WARRIOR and 1 type of HEALER.
     *
     * @param members starting member list
     * @param warrior WARRIOR type
     * @param healer HEALER type
     * @param nextHPAssignment how much HP per WARRIOR
     * @param unassignedHP total HP to give out
     * @param healerDetriment what fraction of WARRIOR HP HEALERS get
     * @return updated members
     */
    private ArrayList<ClanMember> split(ArrayList<ClanMember> members,
                                        ActionPointDecider warrior, ActionPointDecider healer,
                                        int nextHPAssignment, int unassignedHP, int healerDetriment) {
        while (unassignedHP > 0) {
            if (unassignedHP < nextHPAssignment) {
                nextHPAssignment = unassignedHP;
            }
            if (Math.random() < 0.5) {
                members.add(new ClanMember(getID(), WARRIOR, nextHPAssignment, warrior));
                unassignedHP -= nextHPAssignment;
            } else {
                members.add(new ClanMember(getID(), HEALER, nextHPAssignment / healerDetriment, healer));
                unassignedHP -= nextHPAssignment / healerDetriment;
            }
        }
        return members;
    }
}
