
import java.util.Scanner;

class Minheap<E extends Comparable<E>> {
	private E[] str;
	public Minheap(E[] strr) {
		this.str = strr;
	}
	public boolean checkMinheap() {
		for (int i = 0; i < str.length - 1; i++) {
			if (!less(str[i], str[i + 1])) {
				return false;
			}
		}
		return true;
	}
	public boolean less(E i, E j) {
		return i.compareTo(j) < 0;
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String str = scan.nextLine();
		switch(str) {
			case "String":
			while (n > 0) {
				String[] st = scan.nextLine().split(",");
				Minheap<String> heap = new Minheap<String>(st);
				System.out.println(heap.checkMinheap());
			}
			break;
			case "Integer":
			while (n > 0) {
				String[] s = scan.nextLine().split(",");
				Integer[] sr = new Integer[s.length];
				for (int i = 0; i < s.length; i++) {
					sr[i] = Integer.parseInt(s[i]);
				}
				Minheap<Integer> heap = new Minheap<Integer>(sr);
				System.out.println(heap.checkMinheap());
			}
			break;
			case "Double":
 			while (n > 0) {
				String[] s = scan.nextLine().split(",");
				Double[] sr = new Double[s.length];
				for (int i = 0; i < s.length; i++) {
					sr[i] = Double.parseDouble(s[i]);
				}
				Minheap<Double> heap = new Minheap<Double>(sr);
				System.out.println(heap.checkMinheap());
			}
			break;
			case "Float":
			while (n > 0) {
				String[] s = scan.nextLine().split(",");
				Float[] sr = new Float[s.length];
				for (int i = 0; i < s.length; i++) {
					sr[i] = Float.parseFloat(s[i]);
				}
				Minheap<Float> heap = new Minheap<Float>(sr);
				System.out.println(heap.checkMinheap());
			}
			break;
			default:
			break;
		}
	}
}