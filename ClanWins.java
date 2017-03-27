package clanmelee;

public class ClanWins implements Comparable<ClanWins> {
    private String name;
    private Integer wins;

    public ClanWins(String name) {
        this.name = name;
        this.wins = 0;
    }

    public void addWin() {
        wins += 1;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    @Override
    public int compareTo(ClanWins other) {
        return wins.compareTo(other.getWins()) * -1;
    }
}
