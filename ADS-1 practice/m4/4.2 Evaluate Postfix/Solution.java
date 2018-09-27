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
				System.out.println("jlj" + list.pop());
				System.out.println("kjh" + list.pop());
				x = list.add(list.pop(), list.pop());
				list.push(x);
				break;
				default:
				System.out.println("kjbkj" + arr[i]);
				list.push(Integer.parseInt(arr[i]));
				break;
			}
		}		
		System.out.println(x);
	}
}
class Linkedlist {
	private Node head;
	private class Node {
		private int item;
		private Node next;
		// Node (int item) {
		// 	this.item = item;
		// }
	}
	Linkedlist() {
		this.head = null;
	}
	public void push(int value) {
		// System.out.print("push");
		Node oldhead = head;
		head = new Node();
		head.item = value;
		head.next = oldhead;
	}
	public int pop() {
		if (head != null) {
			int value = head.item;
			head = head.next;
			System.out.println(value);
			return value;
		}
		return '\0';
	}
	public int add(int n, int m) {
		System.out.println(n);
		System.out.println(m);
		System.out.println(n + m);
		return n + m;
	}
	public int mul(int m, int n) {
		System.out.println("sdfh");
		System.out.println(n * m);
		return m * n;
	}
}