import java.util.Scanner;
/**
 * Class for tournament.
 */
class Tournament implements Comparable {
    /**
     * team is of type String.
     */
    private String team;
    /**
     * wins is of type int.
     */
    private int wins;
    /**
     * losses is of type int.
     */
    private int losses;
    /**
     * draws is of type int.
     */
    private int draws;
    /**
     * Constructs the object.
     *
     * @param      team    The team
     * @param      wins    The wins
     * @param      losses  The losses
     * @param      draws   The draws
     */
    public Tournament(final String team, final int wins, final int losses, final int draws) {
        this.team = team;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
    }
    /**
     * Gets the team.
     *
     * @return     The team.
     */
    public String getTeam() {
        return team;
    }
    /**
     * Gets the wins.
     *
     * @return     The wins.
     */
    public int getWins() {
        return wins;
    }
    /**
     * Gets the losses.
     *
     * @return     The losses.
     */
    public int getLosses() {
        return losses;
    }
    /**
     * Gets the draws.
     *
     * @return     The draws.
     */
    public int getDraws() {
        return draws;
    }
    /**
     * method to return boolean
     *
     * @param      that  The that
     *
     * @return     returns boolean.
     */
    public boolean less(final Tournament that) {
        return this.compareTo(that) > 0;
    }
    /**
     * method to compare and return an int.
     *
     * @param      object  The object
     *
     * @return     returns an int.
     */
    public int compareTo(final Object object) {
        Tournament that = (Tournament) object;
        if (this.getWins() > that.getWins()) {
            return +1;
        } else if (this.getWins() < that.getWins()) {
            return -1;
        }
        if (this.getLosses() > that.getLosses()) {
            return -1;
        } else if (this.getLosses() < that.getLosses()) {
            // System.out.println("lsj");
            return +1;
        }
        if (this.getDraws() > that.getDraws()) {
            return +1;
        } else if (this.getDraws() < that.getDraws()) {
            return -1;
        }
        return 0;
    }
}
/**
 * Class for insertion.
 */
class Insertion {
    /**
     * tournaments is of type Tournament.
     */
    private Tournament[] tournaments;
    /**
     * size is of type int.
     */
    private int size;
    /**
     * Constructs the object.
     */
    public Insertion() {
        tournaments = new Tournament[100];
        size = 0;
    }
    /**
     * Adds a tournament.
     *
     * @param      t     t is of type Tournament.
     */
    public void addTournament(final Tournament t) {
        tournaments[size++] = t;
    }
    /**
     * Gets the tournament.
     *
     * @param      index  The index
     *
     * @return     The tournament.
     */
    public Tournament getTournament(final int index) {
        return tournaments[index];
    }
    /**
     * method to sort team ranking.
     */
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
            if (tournaments[j].less(tournaments[j - 1])) {
                exch(tournaments, j, j-1);
            } else {
                break;
            }
            }
        }
    }
    /**
     * method to swap.
     *
     * @param      a     a is of type Tournament.
     * @param      i     i is of type int.
     * @param      j     j is of type int.
     */
    public void exch(final Tournament[] a, final int i, final int j) {
        Tournament temp = tournaments[i];
        tournaments[i] = tournaments[j];
        tournaments[j] = temp;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
        s += tournaments[i].getTeam() + ",";
        }
        s += tournaments[i].getTeam();
        return s;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Insertion sortlist = new Insertion();
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(",");
            sortlist.addTournament(new Tournament(s[0],
                Integer.parseInt(s[1]), Integer.parseInt(s[2]),
                Integer.parseInt(s[3])));
    }
    sortlist.sort();
    System.out.println(sortlist);
    }
}
