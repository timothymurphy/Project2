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

            // Adds reliable Palladins
            for (int i = 0; i < hitPoints; i++) {
                members.add(new ClanMember(getID(), WARRIOR, 0, Palladin));
            }

            // If possible, make as many Tanks and Surgeons with HP of cap.
            // Will return without any new if HP is below HP Cap.
            members = split(members, Golem, Driad, MemberConstants.HIT_POINT_CAP,
                    (hitPoints / MemberConstants.HIT_POINT_CAP) * MemberConstants.HIT_POINT_CAP, 1);

            // Remaining HP used to make many Medics and Snipers.
            return split(members, Grunt, medic, (hitPoints % MemberConstants.HIT_POINT_CAP) / 5,
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
