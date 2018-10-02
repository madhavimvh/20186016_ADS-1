import java.util.Scanner;

import java.util.Arrays;
class Tournament implements Comparable {
	private String team;
	private int wins;
	private int losses;
	private int draws;
	public Tournament(String team, int wins, int losses, int draws) {
		this.team = team;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
	}
	public String getTeam() {
		return team;
	}
	public int getWins() {
		return wins;
	}
	public int getLosses() {
		return losses;
	}
	public int getDraws() {
		return draws;
	}
	public boolean less(Tournament that) {
		return this.compareTo(that) > 0;
	}
	public int compareTo(Object object) {
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
class Selection {
	private Tournament[] tournaments;
	private int size;
	public Selection() {
		tournaments = new Tournament[100];
		size = 0;
	}
	public void addTournament(Tournament t) {
		tournaments[size++] = t;
	}
	public Tournament getTournament(int index) {
		return tournaments[index];
	}
	public void sort() {
		for (int i = 0; i < size; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (tournaments[j].less(tournaments[min])) {
					min = j;
				}	
			}
			exch(tournaments, i, min);
		}
	}
	public void exch(Tournament[] a, int i, int j) {
		Tournament temp = tournaments[i];
		tournaments[i] = tournaments[j];
		tournaments[j] = temp;
	}
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
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Selection sortlist = new Selection();
		while (sc.hasNext()) {
			String[] s = sc.nextLine().split(",");
			sortlist.addTournament(new Tournament(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3])));

	}
	sortlist.sort();
	System.out.println(sortlist);
	}
}
