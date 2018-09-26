import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	private Solution() {
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = Integer.parseInt(scan.nextLine());
		int n2 = Integer.parseInt(scan.nextLine());
		String[] arr1 = scan.nextLine().split(",");
		String[] arr2 = scan.nextLine().split(",");
		Sortedarr array = new Sortedarr(arr1, arr2);
		System.out.println(Arrays.toString(array.result())); 
	}
}
class Sortedarr {
	private String[] arr1;
	private String[] arr2;
	private String[] arr;
	public Sortedarr(String[] arrr1, String[] arrr2) {
		this.arr1 = arrr1;
		this.arr2 = arrr2;
		this.arr = new String[arr1.length + arr2.length];
	}
	public String[] result() {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[j])) {
				arr[k++] = arr[i]; 
			} else {
				arr[k++] = arr[j];
			}
		while (i < arr1.length) {
			arr[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			arr[k++] = arr2[j++];
		}
		}
		return arr;
	}
}