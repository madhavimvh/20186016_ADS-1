import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Steque steque = new Steque();
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		switch(line[0]) {
			case "push":
			steque.push(Integer.parseInt(line[1]));
			break;
			case "pop":
			steque.pop();
			break;
			case "enqueue":
			steque.enqueue(Integer.parseInt(line[1]));
			break;
			default:
			break;
		}
	}
}
class Steque {
	Node head;
	Node tail;
	int size;
	class Node {
		int item;
		Node next;
		Node() {
		}
		Node(int item) {
			this.item = item;
			this.next = null;
		}
		Node(int item, Node node) {
			this.item = item;
			this.next = node;
		}
	}
	Steque() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	public void push(int element) {
		Node newhead = new Node();
		newhead.next = head;
		head = newhead;
		size++;
	}
	public int pop() {
		int data = head.item;
		head = head.next;
		size--;
		return data;
	}
	public void enqueue(int element) {
		Node newhead = new Node(element);
		if (isEmpty()) {
			head = newhead;
			tail = head;
			tail.next = null;
			size++;
			return;
		}
		Node oldtail = tail;
		tail = newhead;
		oldtail.next = tail;
		tail.next = null;
		size++;
	}

}