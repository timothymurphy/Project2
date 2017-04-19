package clanmelee.ClanSALTfightingArtichokes;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import clanmelee.MemberConstants;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

    /**
     * Ed's Clan, the Fighting Artichokes.
     */
    public class ClanSALTfightingArtichokes extends Clan {

        public ClanSALTfightingArtichokes(int id) {
            super("clanmelee/ClanSALTfightingArtichokes", id);
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

            // Vanilla healer
            ActionPointDecider medic = new ArtichokeMedicDecider();

            // Vanilla warrior
            ActionPointDecider sniper = new ArtichokeSniperDecider();

            // Heavy healer
            ActionPointDecider surgeon = new ArtichokeSurgeonDecider();

            // Arrow-to-the-knee warrior
            ActionPointDecider swarmer = new ArtichokeSwarmerDecider();

            // Heavy warrior
            ActionPointDecider tank = new ArtichokeTankDecider();

            // Adds useless Swarmers to knock a few opponents down first iteration.
            if (hitPoints > MemberConstants.HIT_POINT_CAP * 2) {
                for (int i = 0; i < hitPoints / 200; i++, hitPoints--) {
                    members.add(new ClanMember(getID(), WARRIOR, 1, swarmer));
                }
            }

            // If possible, make as many Tanks and Surgeons with HP of cap.
            // Will return without any new if HP is below HP Cap.
            members = split(members, tank, surgeon, MemberConstants.HIT_POINT_CAP,
                    (hitPoints / MemberConstants.HIT_POINT_CAP) * MemberConstants.HIT_POINT_CAP, 1);

            // Remaining HP used to make many Medics and Snipers.
            return split(members, sniper, medic, (hitPoints % MemberConstants.HIT_POINT_CAP) / 5,
                    hitPoints % MemberConstants.HIT_POINT_CAP, 3.5);
        }

        /**
         * Splits up HP between 1 type of WARRIOR and 1 type of HEALER.
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
                                            int nextHPAssignment, int unassignedHP, double healerDetriment) {
            while (unassignedHP > 0) {
                // To prevent too much HP being given.
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
