import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BST bst = new BST();
		while(scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			switch(tokens[0]) {
				case "put":
				bst.put(new Key(tokens[1], tokens[2], Float.parseFloat(tokens[3])), tokens[4]);
				break;
				case "get":
				System.out.println(bst.get(new Key(tokens[1], tokens[2], Float.parseFloat(tokens[3]))));
				break;
				case "max":
				System.out.println(bst.max());
				break;
				case "min":
				System.out.println(bst.min());
				break;
				case "select":
				System.out.println(bst.select(Integer.parseInt(tokens[1])));
				break;
				case "floor":
				System.out.println(bst.floor(new Key(tokens[1], tokens[2], Float.parseFloat(tokens[3]))));
				break;
				case "ceiling":
				System.out.println(bst.ceiling(new Key(tokens[1], tokens[2], Float.parseFloat(tokens[3]))));
				break;
			}
		}
	}
}
class Key implements Comparable {
	private String name;
	private String author;
	private float price;
	Key (String namee, String authorr, float pricee) {
		this.name = namee;
		this.author = authorr;
		this.price = pricee;
	}
	public int compareTo(final Object object) {
		Key that = (Key) object;
		return this.name.compareTo(that.name);
	}
	public String toString() {
		return name + ", " + author + ", " + price;
	}
}


    