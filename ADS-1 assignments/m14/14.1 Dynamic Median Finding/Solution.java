import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		MinPQ<Float> minarr = new MinPQ<Float>(n);
		MaxPQ<Float> maxarr = new MaxPQ<Float>(n);
		Float median = 0.0f;
		for (int i = 0; i < n; i++) {
			Float val = scan.nextFloat();
			if (val > median) {
				minarr.insert(val);
			} else {
				maxarr.insert(val);
			}
			if (minarr.size() - maxarr.size() > 1) {
				maxarr.insert(minarr.delMin());
			}
			if (maxarr.size() - minarr.size() > 1) {
				minarr.insert(maxarr.delMax());
			}
			if (minarr.size() == maxarr.size()) {
				median = (minarr.min() + maxarr.max()) / 2;
				System.out.println(median);
			}
			if (maxarr.size() > minarr.size()) {
				median = maxarr.max();
				System.out.println(median);
			}
			if (minarr.size() > maxarr.size()) {
				median = minarr.min();
				System.out.println(median);
			}
		}
	}
}
// class MinPQ {
// 	private double[] minpq;
// 	private int m;
// 	public MinPQ(int capacity) {
// 		minpq = new double[capacity + 1];
// 		m = 0;
// 	}
// 	public boolean isEmpty() {
// 		return m == 0;
// 	}
// 	public void insert(double x) {
// 		minpq[++m] = x;
// 		swim(m);
// 	}
// 	public int size() {
// 		return m;
// 	}
// 	public void swim(int k) {
// 		while (k > 1 && greater(k/2, k)) {
// 			exch(k, k/2);
// 			k = k/2;
// 		}
// 	}
// 	public void sink(int k) {
//  		while ((2 * k) <= m) {
//  			int j = 2 * k;
//  			if (j < m && greater(j, j + 1)) {
//  				if (!greater(k, j)) {
// 					break; 					
//  				} else {
//  					exch(k, j);
//  					k = j;
//  				}
//  			}
//  		}
//  	}
//  	public boolean greater(int i, int j) {
//  		return i > j;
//  	}
//  	public void exch(int i, int j) {
// 		double temp = minpq[i];
// 		minpq[i] = minpq[j];
// 		minpq[j] = temp;
//  	}
//  	public double getMinimum() {
//  		return minpq[1];
//  	}
//  	public double delMin() {
//  		double min = minpq[1];
//  		exch(1, m--);
//  		sink(1);
//  		return min;
//  	}
// }
// class MaxPQ {
// 	private double[] maxpq;
// 	private int n;

// 	public MaxPQ(int capacity) {
// 		maxpq = new double[capacity + 1];
// 		n = 0;
// 	}
// 	public boolean isEmpty() {
// 		return n == 0;
// 	}
// 	public void insert(double x) {
// 		maxpq[++n] = x;
// 		swim(n);
// 	}
// 	public int size() {
// 		return n;
// 	}
// 	public void swim(int k) {
// 		while (k > 1 && less(k/2, k)) {
// 			exch(k, k/2);
// 			k = k/2;
// 		}
// 	}
// 	public double max() {
// 		return maxpq[1];
// 	}
// 	public void exch(int i, int j) {
// 		double temp = maxpq[i];
// 		maxpq[i] = maxpq[j];
// 		maxpq[j] = temp;
//  	}
//  	public boolean less(int a, int b) {
//  		return a < b;
//  	}
//  	public void sink(int k) {
//  		while ((2 * k) <= n) {
//  			int j = 2 * k;
//  			if (j < n && less(j, j + 1)) {
//  				if (!less(k, j)) {
// 					break; 					
//  				} else {
//  					exch(k, j);
//  					k = j;
//  				}
//  			}
//  		}
//  	}
//  	public double delMax() {
//  		double max = maxpq[1];
//  		exch(1, n--);
//  		sink(1);
//  		return max;
//  	}
// }