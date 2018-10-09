import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		Median med = new Median(n);
		while (n > 0) {
			double num = Double.parseDouble(scan.nextLine());
			med.add(num);
		}
		System.out.println("khkjh");
		System.out.println(med.getMedian());
	}
}
class Median {
	private MinPQ min;
	private MaxPQ max;
	private int size;
	public Median(int cap) {
		if (cap % 2 == 0) {
			min = new MinPQ(cap/2);
			max = new MaxPQ(cap/2);
		} else {
			min = new MinPQ((cap + 1) / 2);
			max = new MaxPQ((cap + 1) / 2);
		}
		size = 0;
	}
	public void add(double val) {
		if (max.isEmpty()) {
			max.insert(val);
		} else if (max.size() == min.size()) {
			if (val < min.getMinimum()) {
				max.insert(val);
			} else {
				min.insert(val);
				max.insert(min.delMin());
			}
		} else if (max.size() > min.size()) {
			if (val > max.getMaximum()) {
				min.insert(val);
			} else {
				max.insert(val);
				min.insert(max.delMax());
			}
		}
	}
	public double getMedian() {
		if (max.isEmpty()) {
			return 0;
		} else if(max.size() == min.size()) {
			return (max.getMaximum() + min.getMinimum()) / 2.0;
		} else {
			return  max.getMaximum();
		}
	}
}

class MinPQ {
	private double[] minpq;
	private int m;
	public MinPQ(int capacity) {
		minpq = new double[capacity + 1];
		m = 0;
	}
	public boolean isEmpty() {
		return m == 0;
	}
	public void insert(double x) {
		minpq[++m] = x;
		swim(m);
	}
	public int size() {
		return m;
	}
	public void swim(int k) {
		while (k > 1 && greater(k/2, k)) {
			exch(k, k/2);
			k = k/2;
		}
	}
	public void sink(int k) {
 		while ((2 * k) <= m) {
 			int j = 2 * k;
 			if (j < m && greater(j, j + 1)) {
 				if (!greater(k, j)) {
					break; 					
 				} else {
 					exch(k, j);
 					k = j;
 				}
 			}
 		}
 	}
 	public boolean greater(int i, int j) {
 		return i > j;
 	}
 	public void exch(int i, int j) {
		double temp = minpq[i];
		minpq[i] = minpq[j];
		minpq[j] = temp;
 	}
 	public double getMinimum() {
 		return minpq[1];
 	}
 	public double delMin() {
 		double min = minpq[1];
 		exch(1, m--);
 		sink(1);
 		return min;
 	}
}
class MaxPQ {
	private double[] maxpq;
	private int n;

	public MaxPQ(int capacity) {
		maxpq = new double[capacity + 1];
		n = 0;
	}
	public boolean isEmpty() {
		return n == 0;
	}
	public void insert(double x) {
		maxpq[++n] = x;
		swim(n);
	}
	public int size() {
		return n;
	}
	public void swim(int k) {
		while (k > 1 && less(k/2, k)) {
			exch(k, k/2);
			k = k/2;
		}
	}
	public double getMaximum() {
		return maxpq[1];
	}
	public void exch(int i, int j) {
		double temp = maxpq[i];
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
 					exch(k, j);
 					k = j;
 				}
 			}
 		}
 	}
 	public double delMax() {
 		double max = maxpq[1];
 		exch(1, n--);
 		sink(1);
 		return max;
 	}
}