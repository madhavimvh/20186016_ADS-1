import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Linkedlist list = new Linkedlist();
		String[] arr = sc.nextLine().split(" ");
		int x = 0;
		for (int i = 0; i < arr.length; i++) {
			switch(arr[i]) {
				case "*":
				x = list.mul(list.pop(), list.pop());
				list.push(x);
				break;
				case "+":
				x = list.add(list.pop(), list.pop());
				list.push(x);
				break;
				default:
				list.push(Integer.parseInt(arr[i]));
				break;
			}
			System.out.println(x);
		}		
	}
}
class Linkedlist {
	private Node head;
	private class Node {
		private int item;
		private Node next;
	}
	Linkedlist() {
		this.head = null;
	}
	public void push(int value) {
		Node oldhead = head;
		head = new Node();
		head.item = value;
	}
	public int pop() {
		if (head != null) {
			int value = head.item;
			head = head.next;
			return value;
		}
		return '\0';
	}
	public int add(int n, int m) {
		System.out.println(n + m);
		return n + m;
	}
	public int mul(int m, int n) {
		System.out.println(n * m);
		return m * n;
	}
}