package clanmelee;

import java.util.Collection;

/**
 * A factory that produces ClanMember objects for one particular clan
 */
public abstract class Clan {
    private final String name;
    private final int id;

    /**
     * Constructor. Gives the clan a Name and an ID.
     *
     * @param name name of the clan
     * @param id   the clan's unique ID
     */
    public Clan(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Gets the ID of the Clan
     */
    public int getID() {
        return id;
    }

    /**
     * Gets the name of the Clan
     */
    public String getName() {
        return name;
    }

    /**
     * Clan's implement this factory method to produce clan members
     *
     * @param hitPoints the number of hit points to be distributed amongst all the clan members
     * @return the clan's members
     */
    public abstract Collection<ClanMember> getMembers(int hitPoints);
}
