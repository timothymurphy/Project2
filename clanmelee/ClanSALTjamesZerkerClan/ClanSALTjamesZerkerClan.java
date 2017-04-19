package clanmelee.ClanSALTjamesZerkerClan;
/*

 */
import clanmelee.Clan;
import clanmelee.ClanMember;
import clanmelee.ClanSALTjamesZerkerClan.BerserkerDecider;
import clanmelee.ClanSALTjamesZerkerClan.BloodHealerDecider;
import clanmelee.ClanSALTjamesZerkerClan.HealerBerserkerDecider;
import clanmelee.ClanSALTjamesZerkerClan.LessBerserkBerserkerDecider;

import java.util.ArrayList;
/**
 * Created by jamesegallagher on 4/19/17.
 */
public class ClanSALTjamesZerkerClan extends Clan {
    public ClanSALTjamesZerkerClan(int clanID) {
        super("clanmelee/ClanSALTjamesZerkerClan", clanID);}


        @Override
        public ArrayList<ClanMember> getMembers(int hitPoints) {
            ArrayList<ClanMember> fullClanMembers = new ArrayList<ClanMember>();

            BerserkerDecider warrior1 = new BerserkerDecider();
            BloodHealerDecider healer1 = new BloodHealerDecider();
            HealerBerserkerDecider healer2 = new HealerBerserkerDecider();
            LessBerserkBerserkerDecider warrior2 = new LessBerserkBerserkerDecider();


            return fullClanMembers;
        }
    }

