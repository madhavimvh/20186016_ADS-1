import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Dequeue d = new Dequeue();
		// int n = Integer.parseInt(sc.nextLine());
		// while (sc.hasNext()) {
		// 	String[] s = sc.nextLine().split(" ");
		// 	switch(s[0]) {
		// 		case "pushLeft":
		// 		d.addfirst(Integer.parseInt(s[1]));
		// 		break;
		// 		case "pushRight":
		// 		d.addlast(Integer.parseInt(s[1]));
		// 		break;
		// 		case "popRight":
		// 		System.out.println(d.poplast());
		// 		break;
		// 		case "popLeft":
		// 		System.out.println(d.popfirst());
		// 		break;
		// 		default:
		// 		break;
		// 	}

		// }
		d.addlast(4);
		// d.addlast(6);
		System.out.println(d.popfirst());
		System.out.println(d.first);
		System.out.println(d.last);

	}
}

	class Node {
		int item;
		Node next;
	}
class Dequeue {
	Node last;
	Node first;
	int size;

	Dequeue() {
		this.last = null;
		this.first = null;
		this.size = 0;
	}
	public boolean isEmpty() {
		return first == null || last == null;
	}
	public void addfirst(int value) {
		Node oldfirst = first;
		first = new Node();
		first.item = value;
		first.next = null;
		if (isEmpty()) {
			last = first;
		} else {
			oldfirst.next = first;
		}
		size++;
		
	}
	public void addlast(int value) {
		Node oldlast = last;
		last = new Node();
		last.item = value;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
		size++;
	}
	public int popfirst() {
		int item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
			first = null;
		} else {
			last = first;
		}
		return item;
	}
	public int poplast() {
		Node temp = last;
		int item = last.item;
		if (first.next == null && last.next == null) {
			first = null;
			last = null;
			return item;
		} else {
		while (first.next.next == null) {
			temp.next = null;
			last = first;
		}
	}
		return item;
	}
}