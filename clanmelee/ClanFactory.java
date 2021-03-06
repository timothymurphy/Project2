package clanmelee;

import clanmelee.Clan1.Clan1;
import clanmelee.Clan2.Clan2;
import clanmelee.ClanSALT8YourHeart.ClanSalt8YourHeart;
import clanmelee.ClanSALTcoward.ClanSALTcoward;
import clanmelee.ClanSALTdStaxx.ClanSALTdStaxx;
import clanmelee.ClanSALTfightingArtichokes.ClanSALTfightingArtichokes;
import clanmelee.ClanSALTjamesZerkerClan.ClanSALTjamesZerkerClan;
import clanmelee.ClanSALTnoForgiveness.ClanSALTnoForgiveness;
import clanmelee.ClanSALTsaltGolems.ClanSALTsaltGolems;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A collection of clans that may be manipulated to add more for a melee
 */
public class ClanFactory {
    /**
     * Generates and returns a Collection<Clan> containing a Clan1 object and Clan2 object.
     * @return clans - a Collection containing unique clans
     */
    public Collection<Clan> getClans() {
        ArrayList<Clan> clans = new ArrayList<>();

        int clanID = 0;

        clans.add(new Clan1(clanID++));
        clans.add(new Clan2(clanID++));
        clans.add(new ClanSalt8YourHeart(clanID++));
        clans.add(new ClanSALTcoward(clanID++));
        clans.add(new ClanSALTdStaxx(clanID++));
        clans.add(new ClanSALTfightingArtichokes(clanID++));
        clans.add(new ClanSALTjamesZerkerClan(clanID++));
        clans.add(new ClanSALTnoForgiveness(clanID++));
        clans.add(new ClanSALTsaltGolems(clanID++));

        return clans;
    }
}
