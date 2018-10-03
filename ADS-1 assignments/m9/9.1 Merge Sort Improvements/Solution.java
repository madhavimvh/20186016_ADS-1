import java.util.Scanner;


class Merge {
	private static final int CUTOFF = 7;
	public Merge() {
	}
	private void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				aux[k] = a[j++];
			} else if (j > hi) {
				aux[k] = a[i++];
			} else if (less(aux[j], aux[i])) {
				aux[k] = a[j++];
			} else {
				aux[k] = a[i++];
			}
			assert isSorted(a, lo, hi);
		}
	}
	private boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i-1])) {
            	return false;
            }
        }
        return true;
    }
	public void sort(int[] a, int[] aux, int lo, int hi) {
		if (hi <= lo + CUTOFF - 1) {
			Insertion insertion = new Insertion(a);
			insertion.sort(a);
			return;
		}
			int mid = lo + (hi - lo) / 2;
			sort(aux, a, lo, mid);
			sort(aux, a, mid + 1, hi);
			if (!less(a[mid + 1], a[mid])) {
				return;
			}
			merge(a, aux, lo, mid, hi);
		}
	public void sort(int[] a) {
		int[] aux = new int[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	public boolean less(int a, int b) {
		return (a < b);
	}
}
class Insertion {
	private int[] arr;
	public Insertion(int[] arr1) {
		this.arr = arr1;
	}
	public void sort(int[] a) {
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
	public void exch(final int[] a, final int i, final int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public boolean less(int a, int b) {
		return (a < b);
	}

}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(",");
		int[] tokens = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			tokens[i] = Integer.parseInt(arr[i]);
		}
		Merge merge = new Merge();
		merge.sort(tokens);

	}
}