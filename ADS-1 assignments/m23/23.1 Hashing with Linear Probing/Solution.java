import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
		Scanner scan = new Scanner(System.in);
		String intg = scan.nextLine();
		String[] arr = scan.nextLine().split(" ");
		switch(arr[0]) {
			case "put":
			st.put(arr[1], Integer.parseInt(arr[2]));
			break;
			case "display":
			System.out.println(st.display());
			break;
			case "delete":
			st.delete(arr[1]);
			break;
			case "get":
			System.out.println(st.get(arr[1]));
			break;
			default:
			break;
		}
	}
}