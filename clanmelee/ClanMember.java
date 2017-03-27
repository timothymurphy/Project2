package clanmelee;

import static clanmelee.ClanMeleeConstants.*;

/**
 * All clan members are of this class. Each clan member's strategy is defined
 * by its ActionPointDecider
 */
public class ClanMember {
    // Each clan member must be either a warrior or a healer
    public enum ClanMemberType {WARRIOR, HEALER};

    private final int clanID;
    private final ClanMemberType type;

    // Each clan member starts off with hitPoints == maxHitPoints. Attack
    // damage decreases hitPoints. Iteration damage decreases both hitPoints
    // and maxHitPoints.
    private int maxHitPoints;
    private int hitPoints;

    // The decider decides whether to act or to run away, and how many points
    // to attack or heal with.
    private ActionPointDecider decider;

    /**
     * Constructor
     *
     * @param clanID     the member's clan's unique clan ID
     * @param type       ClanMemberType.WARRIOR or ClanMemberType.HEALER
     * @param hitPoints  initial number of hit points
     * @param decider    implements the clan member's strategy
     */
    public ClanMember(int clanID, ClanMemberType type, int hitPoints,
                      ActionPointDecider decider) {
        this.clanID = clanID;
        this.type = type;
        this.decider = decider;

        // Respect the limit on an individual clan member's hit points
        if (hitPoints > HIT_POINT_CAP)
            this.maxHitPoints = HIT_POINT_CAP;
        else
            this.maxHitPoints = hitPoints;

        this.hitPoints = this.maxHitPoints;
    }

    /**  Get the clan ID passed to the constructor  */
    public int getClanID() {
        return clanID;
    }

    /**  Get the clan member type passed to the contructor  */
    public ClanMemberType getType() {
        return type;
    }

    /**  Get the clan member's current number of hit points  */
    public int getHitPoints() {
        return hitPoints;
    }

    /**  Get the clan member's maximum number of hit points  */
    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    /**
     * Public way to get action points. Ensures no more than the max allowed
     * action points are returned.
     *
     * @param other the clan member that this clan member is up against
     * @return      the number of points to attack or heal with. 0 to run away.
     */
    public int getActionPoints(ClanMember other) { // Don't call this
        int actionPoints = decider.decideActionPoints(this, other);

        // the most action points this clan member can afford in hit points
        int maxActionPoints = hitPoints * ACTION_POINTS_PER_ITERATION_DAMAGE_POINT
                + FREE_ACTION_POINTS;

        if (actionPoints > maxActionPoints)
            actionPoints = maxActionPoints;

        dealIterationDamage(actionPoints);

        return actionPoints;
    }

    /**
     * Self-inflict the action point damage and decrease max hit points by 1
     *
     * @param actionPoints number of action points dealt this iteration
     */
    public void dealIterationDamage(int actionPoints) {
        if (actionPoints > FREE_ACTION_POINTS) {
            int damage = (actionPoints - FREE_ACTION_POINTS - 1)
                    / ACTION_POINTS_PER_ITERATION_DAMAGE_POINT + 1;
            dealDamage(damage);
        }

        maxHitPoints -= 1;
        if (hitPoints > maxHitPoints)
            hitPoints = maxHitPoints;
    }

    /**
     * Heal the clan member by a certain number of points. The clan member's
     * hit points will not exceed the maximum hit point limit
     *
     * @param healPoints number of points to heal by
     */
    public void heal(int healPoints) {
        hitPoints += healPoints;
        if (hitPoints > maxHitPoints)
            hitPoints = maxHitPoints;
    }

    /**
     * Decrease the clan member's hit points by a certain number of points. Will
     * not decrease the number of hit points below 0
     *
     * @param damagePoints number of points of damage
     */
    public void dealDamage(int damagePoints) {
        hitPoints -= damagePoints;
        if (hitPoints < 0)
            hitPoints = 0;
    }

    /**
     * @return true if the clan member has more than 0 hit points, false otherwise
     */
    public boolean isAlive() {
        return hitPoints != 0;
    }
}
