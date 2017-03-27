package clanmelee;

import clanmelee.Clan1.Clan1;
import clanmelee.Clan2.Clan2;

import java.util.ArrayList;
import java.util.Collection;

public class ClanFactory {
    public Collection<Clan> getClans() {
        ArrayList<Clan> clans = new ArrayList<>();

        int clanID = 0;

        clans.add(new Clan1(clanID++));
        clans.add(new Clan2(clanID++));


        return clans;
    }
}
