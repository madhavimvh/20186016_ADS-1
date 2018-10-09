import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int num = 0;
		int i = 0;
		while (i < n) {
			num = Integer.parseInt(scan.nextLine());
			MaxPQ pq = new MaxPQ(n);
			pq.insert(num);
			i++;
		}
	}
}
class MaxPQ {
	private int[] maxpq;
	private int[] minpq;
	private int n;
	private int m;

	public MaxPQ(int capacity) {
		maxpq = new int[capacity + 1];
		n = 0;
		m = 0;
	}
	public boolean ismaxEmpty() {
		return n == 0;
	}
	public boolean isminEmpty() {
		return m == 0;
	}
	public void insert(int x) {
		maxpq[++n] = x;
		swim(n);
		System.out.println("kjhkj");
		System.out.println(median(n));
	}
	public Double median(int k) {
		System.out.println("ljlj");
		if (k == 1) {
			return Double.parseDouble(String.valueOf(maxpq[1]));
		} else {
		Double min = Double.parseDouble(String.valueOf(maxpq[k]));
		System.out.println("lkj");
		System.out.println(min);
		Double max = Double.parseDouble(String.valueOf(maxpq[1]));
		System.out.println(max);
		Double med = (min + max) / 2.0;
		return med;
	}
	}
	public void swim(int k) {
		while (k > 1 && less(k/2, k)) {
			maxexch(k, k/2);
			k = k/2;
		}
	}
	public void maxexch(int i, int j) {
		int temp = maxpq[i];
		maxpq[i] = maxpq[j];
		maxpq[j] = temp;
 	}
 	public boolean less(int a, int b) {
 		return a < b;
 	}
 	public void sink(int k) {
 		while ((2 * k) <= n) {
 			int j = 2 * k;
 			if (j < n && less(j, j + 1)) {
 				if (!less(k, j)) {
					break; 					
 				} else {
 					maxexch(k, j);
 					k = j;
 				}
 			}
 		}
 	}
 	public int delMax() {
 		int max = maxpq[1];
 		maxexch(1, n--);
 		sink(1);
 		return max;

 	}


}