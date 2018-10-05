import java.util.Scanner;

class Quick {
	private static final int CUTOFF = 7;
	private Comparable[] a;
	public Quick(Comparable[] a1) {
		this.a = a1;
	}
	private int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		while(true) {
			while (less(a[++i], a[lo])) {
				if (i == hi) {
					break;
				}
			}
			while (less(a[lo], a[--j])) {
				if (j == 0) {
					break;
				}
			}
			if (i >= j) {
				break;
			} else {
				exch(a, lo, j);
			}
		}
		exch(a, lo, j);
		return j;
	}
	public void exch(final Comparable[] a, final int i, final int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public boolean less(Comparable a, Comparable b) {
    	return (a.compareTo(b)) < 0;
    }
	public void sort(Comparable[] a) {
		if (a.length < CUTOFF) {
			System.out.println("insertionSort called");
			Insertion insertion = new Insertion();
			insertion.sort(a);
		} else {
			sort(a, 0, a.length - 1);
		}
	}
	public void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	public String toString(Comparable[] a) {
		// System.out.println("kk");
		// System.out.println(Arrays.toString(a));
		String s = "[";
		int i = 0;
		for (i = 0; i < a.length - 1; i++) {
			s += a[i] + ", ";
		}
		s += a[i] + "]";
		return s;
	}
}
class Insertion {
	public Insertion() {
	}
	public void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j - 1])) {
					exch(a, j, j - 1);
				} else {
					break;
				}
			}
		}
	}
	public void exch(final Comparable[] a, final int i, final int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public boolean less(Comparable a, Comparable b) {
		return (a.compareTo(b)) < 0;
	}
	public String toString(Comparable[] a) {
		// System.out.println("kk");
		// System.out.println(Arrays.toString(a));
		String s = "[";
		int i = 0;
		for (i = 0; i < a.length - 1; i++) {
			s += a[i] + ", ";
		}
		s += a[i] + "]";
		return s;
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(sc.nextLine());
			String[] str = sc.nextLine().split(" ");
			Quick quick = new Quick(str);
			quick.sort(str);
			System.out.println(quick.toString());
		}


	}
}