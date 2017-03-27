package clanmelee;

/**
 * Classes that implement ActionPointDecider can be used to define a ClanMember's strategy
 */
public interface ActionPointDecider {
    /**
     *
     * @param me    the ClanMember doing the deciding
     * @param other the ClanMember that me is engaging with
     * @return      the number of points to attack or heal with. 0 to run away.
     */
    public int decideActionPoints(ClanMember me, ClanMember other);
}
