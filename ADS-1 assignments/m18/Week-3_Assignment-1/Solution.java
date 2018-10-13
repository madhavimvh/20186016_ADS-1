import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;


public final class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MinPQ min = new MinPQ();
		MaxPQ max = new MaxPQ();
		int n = Integer.parseInt(scan.nextLine());
		int N = 6 * n;
		while (N > 0) {
		for (int i = 0; i < n; i++) {
			String[] inp = scan.nextLine().split(",");
			min.insert(new Stock(inp[0], Float.parseFloat(inp[1])));
			max.insert(new Stock(inp[0], Float.parseFloat(inp[1])));
			N--;
		}
		String s = "";
		for (int i = 0; i < 5; i++) {
			s += max.delMax() + "\n";
		}
		System.out.println(s);
		String a = "";
		for (int i = 0; i < 5; i++) {
			a += min.delMin() + "\n";
		}
		System.out.println(a);
		}
	}
}
class Stock implements Comparable{
	private String name;
	private float perchange;
	Stock(String namee, float perchangee) {
		this.name = namee;
		this.perchange = perchangee;
	}
	public String getName() {
		return name;
	}
	public float getPerchange() {
		return perchange;
	}
	public int compareTo(final Object object) {
		Stock that = (Stock) object;
		if (this.perchange > that.perchange) {
			return 1;
		} else if (this.perchange < that.perchange) {
			return -1;
		} else if (this.name.charAt(0) > that.name.charAt(0)) {
			return 1;
		} else {
			return -1;
		}
	}
	public String toString() {
		return name + " " + perchange;
	}
}
// class Queries {
// }
