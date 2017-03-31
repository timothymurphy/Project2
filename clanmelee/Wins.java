package clanmelee;

public class Wins implements Comparable<Wins> {
    private String name;
    private Integer wins;

    public Wins(String name) {
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
    public int compareTo(Wins other) {
        return wins.compareTo(other.getWins()) * -1;
    }
}
