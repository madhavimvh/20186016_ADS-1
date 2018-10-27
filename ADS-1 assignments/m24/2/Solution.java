import java.util.Scanner;


class Studentdata implements Comparable<Studentdata> {
	private int rollno;
	private String name;
	private double totalmarks;
	Studentdata(int rollnoo, String namee, double totalmarkss) {
		rollno = rollnoo;
		name = namee;
		totalmarks = totalmarkss;
	}
	public String getName() {
		return name;
	}
	public int getRollno() {
		return rollno;
	}
	public double getMarks() {
		return totalmarks;
	}
	// public void query(String roll, int n) {
	// 	if (n == 1) {

	// 	}
	// }
	public int compareTo(Studentdata that) {
		if (this.getMarks() > that.getMarks()) {
			return 1;
		} else if (this.getMarks() < that.getMarks()) {
			return -1;
		}
		//  else if (this.getName().compareTo(that.getName()) > 0){
		// 	return  1;
		// } else if (this.getName().compareTo(that.getName()) < 0) {
		// 	return -1;
		// }
		if (this.getRollno() < that.getRollno()) {
			return 1;
		} else if (this.getRollno() < that.getRollno()) {
			return -1;
		} 
		return 0;
	}

}
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RedBlackBST<Studentdata, Double> st = new RedBlackBST<Studentdata, Double>();
		int inp = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < inp; i++) {
			String[] tokens = scan.nextLine().split(",");
			st.put(new Studentdata(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2])), Double.parseDouble(tokens[2]));

		}
		int intt = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < intt; i++) {
			String[] inpp = scan.nextLine().split(" ");
			if (inpp[0].equals("BE")) {
				for (Studentdata keys : st.keys()) {
					if (keys.getMarks() >= Double.parseDouble(inpp[1]) && keys.getMarks() <= Double.parseDouble(inpp[2])) {
						System.out.println(keys.getName());
					}
				}
			} else if (inpp[0].equals("GE")) {
				// System.out.println("hkjh");
				for (Studentdata keys : st.keys()) {
					// System.out.println(keys);
					if (st.get(keys) >= Double.parseDouble(inpp[1])) {
						System.out.println(keys.getName());
					}
				}
			} else if (inpp[0].equals("LE")) {
				// System.out.println("hkjh");
				for (Studentdata keys : st.keys()) {
					// System.out.println(keys);
					if (st.get(keys) <= Double.parseDouble(inpp[1])) {
						System.out.println(keys.getName());
					}
				}
			}
			// else if (inpp[0].equals("LE")) {

			// 	}
			// } else (inpp[0].equals("GE")) {
			// 	for (int i = inpp[1]; i > 0; i--) {
					
			// 	}
			}
			
		}
	}