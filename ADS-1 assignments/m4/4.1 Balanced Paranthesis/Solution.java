import java.util.Scanner;

public class Solution {
	private Solution() {
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		while (sc.hasNext()) {
			String input = sc.nextLine();
		Balanceparens paren = new Balanceparens(input);
			// System.out.println(input);
			if (paren.checkbraces()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
class LinkedList {
	private Node head;
	private class Node {
		private char item;
		private Node next;
	}
	public LinkedList() {
		this.head = null;
	}
	public void push(char value) {
		Node oldHead = head;
		head = new Node();
		head.item = value;
		head.next = oldHead;
	}
	public char pop() {
		if (head != null) {
			char value = head.item;
			head = head.next;
			return value;
		}
		return '\0';
	}
	public boolean isEmpty() {
		return (head == null);
	}
}
class Balanceparens {
	private String input;
	private LinkedList linked;
	public Balanceparens(String input1) {
		this.input = input1;
		this.linked = new LinkedList();
	}
	public boolean checkbraces() {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
				linked.push(input.charAt(i));
			}
			if (input.charAt(i) == ')' || input.charAt(i) == '}' || input.charAt(i) == ']') {
				if (linked.isEmpty()) {
					return false;
				} else if(matching(linked.pop(), input.charAt(i))) {
					return true;
				}
			}
		}
		if (linked.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean matching(char char1, char char2) {
		if (char1 == '(' && char1 == ')') {
			return true;
		} else if (char1 == '[' && char1 == ']') {
			return  true;
		} else if (char1 == '{' && char1 == '}') {
			return true;
		} else {
			return false;
		}
	}
}