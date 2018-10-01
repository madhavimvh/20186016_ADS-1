import java.util.Scanner;
class Node {
		int item;
		Node next;
		Node(int item) {
			item = item;
			next = null;
		}
		Node(int item, Node node) {
			item = item;
			next = node;
		}
		public int getItem() {
			return item;
		}
		public void setItem(int value) {
			item = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node node) {
			next = node;
		}
	}
class Steque {
	Node head;
	Node tail;
	int size;
	
	public Steque() {
		head = null;
		tail = null;
		size = 0;
	}
	public void push(int element) {
		Node oldhead = head;
		head = new Node(element, oldhead);
		if (oldhead == null) {
			head = tail;
		}
		size++;
	}
	public void pop() {
		if (head != null && tail != null) {
			if (head.getNext() == null && tail.getNext() == null) {
				head = tail = null;
				size--;
			} else {
				head = head.getNext();
				size--;
			}
		}
		
	}
	public void enqueue(int element) {
		if (head != null && tail != null) {
			Node oldtail = tail;
			tail = new Node(element, null);
			oldtail.setNext(tail);
		} else if (head == null && tail == null) {
			head = tail = new Node(element, null);
		}
		
	}
	public String toString() {
		StringBuffer sb = new StringBuffer("");
		if (size == 0) {
			sb.append("Steque is empty.");
			return sb.toString();
		} else {
			Node temp = head;
			while (temp != null) {
			sb.append(temp + ", ");
			head = head.getNext();
			}
		}
		return sb.toString().substring(0, sb.length() - 2);
	}

}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		while (n > 0) {
		Steque steque = new Steque();
		while (sc.hasNext()) {
		String[] line = sc.nextLine().split(" ");
		switch(line[0]) {
			case "push":
			steque.push(Integer.parseInt(line[1]));
			System.out.println(steque);
			break;
			case "pop":
			steque.pop();
			System.out.println(steque);
			break;
			case "enqueue":
			steque.enqueue(Integer.parseInt(line[1]));
			System.out.println(steque);
			break;
			default:
			steque = new Steque();
			break;
		}
		n--;
		}
	}
}
}