package clanmelee.ClanSALTcoward;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;



/**
 * Created by murphyt on 4/17/17.
 */
public class ClanSALTcoward extends Clan
{
    public ClanSALTcoward(int clanID)
    {
        super("clanmelee/ClanSALTcoward", clanID);
    }
    @Override
    public ArrayList<ClanMember> getMembers(int hitPoints) {
        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();


        coward Zerg = new coward(getID());

        fullClanMembers.addAll(Zerg.getMembers(hitPoints));

        return fullClanMembers;
    }

}
