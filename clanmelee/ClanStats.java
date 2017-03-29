package clanmelee;


/**
 *
 */
public class ClanStats {
    private final int totalClanCount;
    private int[] hitPoints;
    private int[] playerCounts;
    private int[] warriorCounts;
    private int[] healerCounts;

    public ClanStats(int clanCount) {
        this.totalClanCount = clanCount;
        this.hitPoints = new int[clanCount];
        this.playerCounts = new int[clanCount];
        this.warriorCounts = new int[clanCount];
        this.healerCounts = new int[clanCount];
    }

    public void addPlayer(ClanMember p) {
        int clanID = p.getClanID();
        hitPoints[clanID] += p.getHitPoints();
        playerCounts[clanID] += 1;
        if (p.getType() == ClanMember.ClanMemberType.HEALER)
            healerCounts[clanID] += 1;
        else if (p.getType() == ClanMember.ClanMemberType.WARRIOR)
            warriorCounts[clanID] += 1;
    }

    public int getHitPoints(int clanID) {
        return hitPoints[clanID];
    }

    public int getPlayerCount(int clanID) {
        return playerCounts[clanID];
    }

    public int getWarriorCount(int clanID) {
        return warriorCounts[clanID];
    }

    public int getHealerCount(int clanID) {
        return healerCounts[clanID];
    }

    public int getClanCount() {
        int clanCount = 0;
        for (int i = 0; i < totalClanCount; i++) {
            if (playerCounts[i] != 0) {
                clanCount += 1;
            }
        }
        return clanCount;
    }

    public int getWinner() {
        int max = 0;
        int maxID = 0;

        for (int i = 0; i < totalClanCount; i++) {
            if (hitPoints[i] > max) {
                max = hitPoints[i];
                maxID = i;
            }
        }

        return maxID;
    }
}
