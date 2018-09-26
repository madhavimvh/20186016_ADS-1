import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// Threesum arr = new Threesum();
		int n = Integer.parseInt(scan.nextLine());
		int[] tokens = new int[n];
		while (scan.hasNext()) {
			for (int i = 0; i < n; i++) {
				tokens[i] = Integer.parseInt(scan.nextLine());	
			}
		}
		Threesum x = new Threesum(tokens);
		System.out.println(x.sum());

		// System.out.println(Arrays.toString(tokens));
	}
}
class Threesum {
	private int[] array;
	private int count;
	public Threesum(int[] array1) {
		this.array = array1;
		this.count = 0;
	}
	public int sum() {
		int sum = 0;
		int sum1 = 0;
		Arrays.sort(array);
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length - 1; j++) {
			sum = array[i] + array[j];
			sum1 = sum * (-1);
			if (binarysearch(sum1) > j) {
				count++;
				// System.out.println("df" + count);
			}
			}
		}
		System.out.println(count);
		return count;
	}
	public int binarysearch(int x) {
		int f = 0; int l = array.length - 1;
		while (f <= l) {
			int mid = f + (l - f)/2;
			if (x < array[mid]) {
				l = mid - 1;
			} else if (x > array[mid]) {
				f = mid + 1;
			} else {
				// System.out.println("mid" + mid);
				return mid;
			}
		}
	return -1;
	}
}
