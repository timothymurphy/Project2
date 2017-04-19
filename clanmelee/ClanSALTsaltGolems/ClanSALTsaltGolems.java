package clanmelee.ClanSALTsaltGolems;

import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

public class ClanSALTsaltGolems extends Clan{
    public ClanSALTsaltGolems(int id) {
        super("clanmelee/ClanSALTsaltGolems", id);
    }
    public ArrayList<ClanMember> getMembers(int hp) {
        ArrayList<ClanMember> members = new ArrayList<>();
        if (hp < 100) {
            members.add(new ClanMember(getID(), ClanMember.ClanMemberType.WARRIOR, hp, new SaltGolemDecider()));
        }
        else if (hp >= 100 && hp < 1000) {
            members.add(new ClanMember(getID(), ClanMember.ClanMemberType.WARRIOR, hp/2, new SaltGolemDecider()));
            members.add(new ClanMember(getID(), ClanMember.ClanMemberType.WARRIOR, hp/2, new SaltGolemDecider()));
            if (hp%2 == 1) {
                members.add(new ClanMember(getID(), ClanMember.ClanMemberType.WARRIOR, 1, new SaltSplicerDecider()));
            }
        }
        else {
            int chars = hp/1000;
            int rem = hp%1000;
            for (int i = 0; i < chars; i++) {
                if (i%4 == 1) {
                    members.add(new ClanMember(getID(), ClanMember.ClanMemberType.HEALER, 500, new SaltMenderDecider()));
                    members.add(new ClanMember(getID(), ClanMember.ClanMemberType.HEALER, 500, new SaltMenderDecider()));
                }
                else {
                    members.add(new ClanMember(getID(), ClanMember.ClanMemberType.WARRIOR, 1000, new SaltGolemDecider()));
                }
            }
            members.add(new ClanMember(getID(), ClanMember.ClanMemberType.HEALER, rem, new SaltSplicerDecider()));
        }
        return members;
    }
}
