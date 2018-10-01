import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Steque steque = new Steque();
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		while (sc.hasNext()) {
		String[] line = sc.nextLine().split(" ");
		switch(line[0]) {
			case "push":
			steque.push(Integer.parseInt(line[1]));
			System.out.println(steque);
			break;
			case "pop":
			try {
			steque.pop();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			break;
			case "enqueue":
			steque.enqueue(Integer.parseInt(line[1]));
			System.out.println(steque);
			break;
			default:
			steque = new Steque();
			break;
		}
			
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
		// Node(int item, Node nod/e) {
			// this.item = item;
			// this.next = node;
		// }
	}
	Steque() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	public int push(int element) {
		Node newhead = new Node(element);
		newhead.next = head;
		head = newhead;
		size++;
		// System.out.println(head.item);
		return head.item;
	}
	public int pop() throws Exception{
		if (head != null) {
		int data = head.item;
		head = head.next;
		size--;
		return data;	
		} else {
			throw new Exception("Steque is empty.");
		}
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
	public String toString() {
		String s = "";
		if (head == null) {
			return s;
		}
		s = s + head.item;
		Node temp = head.next;
		while (temp != null) {
			s = s + " " + temp.item;
			temp = temp.next;
		}
		return s;

	}

}