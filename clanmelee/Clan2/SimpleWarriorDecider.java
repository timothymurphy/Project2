package clanmelee.Clan2;
/*
SimpleWarriorDecider collects actionPoints from the ActionPointDecider. decideActionPoints is the action it will do.
If it meets an enemy that has 1/2 his HP or less, it will attack 1 time. Otherwise, it wil do nothing.
 */
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class SimpleWarriorDecider implements ActionPointDecider {
        private int actionPoints;

        public SimpleWarriorDecider(int actionPoints) {
            this.actionPoints = actionPoints;
        }

        @Override
        public int decideActionPoints(ClanMember self, ClanMember opponent) {
            //Check if clan IDs match
            boolean clanIDsMatch = self.getClanID() == opponent.getClanID();

            //If opponent is in different clans
            if (!clanIDsMatch) {
                //If self is not close to death and opponent doesn't have an immense health advantage --> attack
                if ((self.getHitPoints()-actionPoints > 0 && self.getHitPoints()*2 >= opponent.getHitPoints())) {
                    return actionPoints;
                }

                //If opponent's health advantage is much larger or if self is close to death --> retreat
                else {
                    return 0;
                }
            }

            //If opponent is in same clan --> retreat
            else {
                return 0;
            }
        }

}
