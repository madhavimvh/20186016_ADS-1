import java.util.Scanner;
class Percolation {
	private WeightedQuickUnionUF wtarr;
	private boolean[] arr;
	private int n;
	private int top;
	private int bottom;
	private int size;
	private int opensize;
	// create n-by-n grid, with all sites blocked
  	public Percolation(int n) {
  		this.n = n;
  		this.opensize = 0;
  		this.size = n * n;
  		this.top = size;
  		this.bottom = size + 1;
  		this.arr = new boolean[size];
  		this.wtarr = new WeightedQuickUnionUF(size + 2);
  		for (int i = 0; i < n; i++) {
  			wtarr.union(top, i);
  			wtarr.union(bottom, size - i - 1);
  		}

  	}
  	public int IndexOf(int i, int j) {
  		return n * (i - 1) + (j - 1);
  	}
  	public void connectOpensites(int row, int col) {
  		if (arr[col] && !wtarr.connected(row, col)) {
  			wtarr.union(row, col);
  		}
  	}
  	// open site (row, col) if it is not open already
   	public void open(int row, int col) {
   		int index = IndexOf(row, col);
   		arr[index] = true;
   		int bottomrow = index + n;
   		int toprow = index - n;
   		opensize++;
   		if (n == 1) {
   			wtarr.union(top, index);
   			wtarr.union(bottom, index);
   		}
   		if (bottomrow < size) {
   			connectOpensites(index, bottomrow);
   		}
   		if (toprow > 0) {
   			connectOpensites(index, toprow);
   		}
   		if (col == 1) {
   			if (col != n) {
   				connectOpensites(index, index + 1);
   			}
   			return;
   		}
   		if (col == n) {
   			connectOpensites(index, index - 1);
   			return;
   		}
   		connectOpensites(index, index + 1);
   		connectOpensites(index, index - 1);
   	}
   	// is site (row, col) open?   
   	public boolean isOpen(int row, int col) {
   		return arr[IndexOf(row, col)];
   	}
   	// is site (row, col) full? 
   	// public boolean isFull(int row, int col) {
   	// }
   	// number of open sites 
   	public     int numberOfOpenSites() {
   		return opensize;
   	}
   	// does the system percolate?      
   	public boolean percolates() {
   		return wtarr.connected(top, bottom);
   	}             
}

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		Percolation perc = new Percolation(n);
		while(scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			perc.open(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
				System.out.println(perc.percolates() && perc.numberOfOpenSites() != 0);
	}
}
// You can implement the above API to solve the problem