import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int[] tokens = new int[n];
		while (scan.hasNext()) {
			for (int i = 0; i < n; i++) {
				tokens[i] = Integer.parseInt(scan.nextLine());	
			}
		}
		System.out.println(Arrays.toString(tokens));
	}
}
class Threesum {
	private int[] array;
	private int count;
	public Threesum(int[] array1) {
		this.array = array1;
		this.count = count;
	}
	public int sum() {
		int sum = 0;
		int sum1 = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
			sum = array[i] + array[j];
			sum1 = sum * (-1);	
			}
			if (binarysearch(sum1) != -1) {
				count++;
			}
		}
		return count;
	}
	public int binarysearch(int x) {
		int f= 0; int l = array.length - 1;
		while (f <= l) {
			int mid = f + (l - f)/2;
			if (x < array[mid]) {
				l = mid - 1;
			} else if (x > array[mid]) {
				f = mid + 1;
			} else {
				return mid;
			}
		}
	return -1;
	}
}
