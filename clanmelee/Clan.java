package clanmelee;

import java.util.Collection;

/**
 * A factory that produces ClanMember objects for one particular clan
 */
public abstract class Clan {
    private final String clanName;
    private final int clanID;

    /**
     * Constructor. Gives the clan a Name and an ID.
     *
     * @param clanName name of the clan
     * @param clanID   the clan's unique ID
     */
    public Clan(String clanName, int clanID) {
        this.clanName = clanName;
        this.clanID = clanID;
    }

    /**
     * Gets the ID of the Clan
     */
    public int getID() {
        return clanID;
    }

    /**
     * Gets the name of the Clan
     */
    public String getName() {
        return clanName;
    }

    /**
     * Clan's implement this factory method to produce clan members
     *
     * @param hitPoints the number of hit points to be distributed amongst all the clan members
     * @return the clan's members
     */
    public abstract Collection<ClanMember> getMembers(int hitPoints);
}
