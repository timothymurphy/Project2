package clanmelee.Clan2;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.Clan;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;
import static clanmelee.ClanMember.ClanMemberType.HEALER;

import java.util.ArrayList;

public class Clan2 extends Clan {
    public Clan2(int clanID) {
        super("clanmelee/Clan2", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        int totalHP = hitPoints;
        int unassignedHP = hitPoints;

        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        //Initialize the four types of action point deciders where the simple deciders deliver typical maximum/non-
        //iterative damage while the angry and selfless heal or deal damage more aggressively while taking extra damage
        ActionPointDecider simpleWDecider = new SimpleWarriorDecider(10);
        ActionPointDecider simpleHDecider = new SimpleHealerDecider(10);
        ActionPointDecider angryWDecider = new AngryWarriorDecider(20);
        ActionPointDecider selflessHDecider = new SelflessHealerDecider(20);

        //If the totalHP to be distributed is less than 20, make one warrior
        if (totalHP <= 20) {
            clanMembers.add(new ClanMember(getClanID(), WARRIOR, totalHP, simpleWDecider));
        }

        //If the totalHP to be distributed is between 20 and 400, give each randomly-generated member 1/10 of totalHP
        //until the last member who will receive 1/10 or the remainder
        else if (totalHP > 20 && totalHP <= 400) {
            while (unassignedHP > 0) {
                int nextHpAssignment = totalHP/10;
                if (unassignedHP < totalHP/10) {
                    nextHpAssignment = unassignedHP;
                }

                if (Math.random() > 0.5) {
                    if (Math.random() > 0.5) {
                        clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, simpleWDecider));
                    }

                    else {
                        clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, angryWDecider));
                    }
                }

                else {
                    if (Math.random() > 0.5) {
                        clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, simpleHDecider));
                    }

                    else {
                        clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, selflessHDecider));
                    }
                }

                unassignedHP -= nextHpAssignment;
            }
        }

        //If the totalHP to be distributed is between 400 and 1000, give each randomly-generated member 1/50 of totalHP
        //until the last member, who will receive 1/50 or the remainder
        else if (totalHP > 400 && totalHP < 1000){
            while (unassignedHP > 0) {
                int nextHpAssignment = totalHP/50;
                if (unassignedHP < totalHP/50) {
                    nextHpAssignment = unassignedHP;
                }

                if (Math.random() > 0.5) {
                    if (Math.random() > 0.5) {
                        clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, simpleWDecider));
                    }

                    else {
                        clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, angryWDecider));
                    }
                }

                else {
                    if (Math.random() > 0.5) {
                        clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, simpleHDecider));
                    }

                    else {
                        clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, selflessHDecider));
                    }
                }

                unassignedHP -= nextHpAssignment;
            }
        }

        //If the totalHP to be distributed is greater than 50,000, give each randomly-generated member 1000 of totalHP
        //until the last member who will receive the remainder (less than 1000)
        else if (totalHP > 50000){
            while (unassignedHP > 0) {
                int nextHpAssignment = 1000;
                if (unassignedHP < 1000)
                    nextHpAssignment = unassignedHP;
                if (Math.random() > 0.5) {
                    if (Math.random() > 0.5) {
                        clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, simpleWDecider));
                    } else {
                        clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, angryWDecider));
                    }
                } else {
                    if (Math.random() > 0.5) {
                        clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, simpleHDecider));
                    } else {
                        clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, selflessHDecider));
                    }
                }

                unassignedHP -= nextHpAssignment;
            }
        }

        //Otherwise, give each randomly-generated member 1/100, while checking for the max HP limit, of totalHP
        //until the last member who will receive 1/100 or the remainder
        else {
            while (unassignedHP > 0) {
                int nextHpAssignment = totalHP/100;
                if (totalHP/100 > 1000) {
                    nextHpAssignment = 1000;
                }

                if (unassignedHP < totalHP/100) {
                    nextHpAssignment = unassignedHP;
                }

                if (Math.random() > 0.5) {
                    if (Math.random() > 0.5) {
                        clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, simpleWDecider));
                    }

                    else {
                        clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, angryWDecider));
                    }
                }

                else {
                    if (Math.random() > 0.5) {
                        clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, simpleHDecider));
                    }

                    else {
                        clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, selflessHDecider));
                    }
                }

                unassignedHP -= nextHpAssignment;
            }
        }

        return clanMembers;
    }
}
