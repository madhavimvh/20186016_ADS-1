import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Linkedlist list = new Linkedlist();
		String[] arr = sc.nextLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			switch(arr[i]) {
				case "*":
				list.mul(list.pop(), list.pop());
				break;
				case "+":
				list.add(list.pop(), list.pop());
				break;
				default:
				list.push(Integer.parseInt(arr[i]));
				break;

			}
		}		
	}
}
class Linkedlist {
	private Node head;
	private class Node {
		private char item;
		private Node next;
	}
	Linkedlist() {
		this.head = null;
	}
	public void push(char value) {
		Node oldhead = head;
		head = new Node();
		head.item = value;
	}
	public char pop() {
		if (head != null) {
			char value = head.item;
			head = head.next;
			return value;
		}
		return '\0';
	}
	public int add(int n, int m) {
		return n + m;
	}
	public int mul(int m, int n) {
		return m * n;
	}
}