import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RedBlackBST<Double, Studentdata> st = new RedBlackBST<Double, Studentdata>();
		int inp = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < inp; i++) {
			String[] tokens = scan.nextLine().split(",");
			st.put(Double.parseDouble(tokens[2]), new Studentdata(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2])));

		}
		int intt = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < intt; i++) {
			String[] inpp = scan.nextLine().split(" ");
			if (inpp[0].equals("BE")) {
				for (Double keys : st.keys()) {
					if (keys >= Double.parseDouble(inpp[1]) && keys <= Double.parseDouble(inpp[2])) {
						System.out.println(st.get(keys).getName());
					}
				}
			} else if (inpp[0].equals("GE")) {
				System.out.println("hkjh");
				for (Double keys : st.keys()) {
					System.out.println(keys);
					if (keys >= Double.parseDouble(inpp[1])) {
						System.out.println(st.get(keys).getName());
					}
				}
			} else if (inpp[0].equals("LE")) {
				System.out.println("hkjh");
				for (Double keys : st.keys()) {
					System.out.println(keys);
					if (keys <= Double.parseDouble(inpp[1])) {
						System.out.println(st.get(keys).getName());
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

class Studentdata {
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
	// public String getRollno() {
	// 	return rollno;
	// }
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
		} else {
			return (this.getName().compareTo(that.getName()));
		}
	}

}