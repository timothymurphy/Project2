package clanmelee;

import java.util.Collection;

/**
 * A factory that produces ClanMember objects for one particular clan
 */
public abstract class Clan {
    private final String clanName;
    private final int clanID;

    /**
     * Constructor
     *
     * @param clanName name of the clan
     * @param clanID   the clan's unique ID
     */
    public Clan(String clanName, int clanID) {
        this.clanName = clanName;
        this.clanID = clanID;
    }

    /**
     * get the ID passed to the constructor
     */
    public int getClanID() {
        return clanID;
    }

    /**
     * get the name passed to the constructor
     */
    public String getClanName() {
        return clanName;
    }

    /**
     * Concrete clans implement this factory method to produce clan members
     *
     * @param hitPoints the number of hit points to be distributed amongst all the clan members
     * @return the clan's members
     */
    public abstract Collection<ClanMember> getClanMembers(int hitPoints);
}
