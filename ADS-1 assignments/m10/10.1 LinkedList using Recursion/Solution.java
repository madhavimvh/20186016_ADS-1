import java.util.Scanner;


class Node {
        /**
         * value is of type int.
         */
        int value;
        /**
         * next is of type Node.
         */
        Node next;
        /**
         * Constructs the object.
         *
         * @param      v     { parameter_description }
         * @param      node  The node
         */
        Node(final int v, final Node node) {
            this.value = v;
            this.next = node;
        }
        /**
         * Gets the item.
         *
         * @return     The item.
         */
        public int getItem() {
            return this.value;
        }
        /**
         * Sets the item.
         *
         * @param      valuee  The value
         */
        public void setItem(final int valuee) {
            this.value = valuee;
        }
        /**
         * Gets the next.
         *
         * @return     The next.
         */
        public Node getNext() {
            return this.next;
        }
        /**
         * Sets the next.
         *
         * @param      node  The node
         */
        public void setNext(final Node node) {
            this.next = node;
        }
        /**
         * Returns a string representation of the object.
         *
         * @return     String representation of the object.
         */
        public String toString() {
            return value + "";
        }
    }
class LinkedList {
	private Node head;
	private int size;
	public LinkedList() {
		head = null;
		size = 0;
	}
	public void insertAt(int pos, int n) throws Exception {
		if (pos < 0 || pos > size) {
			throw new Exception("Can’t insert at this position");
		} else if (pos == 0) {
			Node oldhead = head;
			head = new Node(n, oldhead);
		} else { 
			Node temp = head;
			for (int i = 0; i < pos - 1; i++) {
				temp = temp.next;
			}
			Node insert = temp.next;
			Node node = new Node(n, insert);
			temp.next = node;
		}
		size++;
	}


	public Node reverse() {
    	Node temp = head;
        Node newHead = null;
        while (temp != null) {
        	if (newHead == null) {
        		newHead = temp.next;
        		newHead.next = temp;
        	} else {
        		Node old = newHead;
        		newHead = temp.next;
        		newHead.next = old;
        	}
        	temp = temp.next;
        }
        return head;

    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");
            Node temp = head;
            if (temp == null) {
            	sb.append("No elements to reverse.");
            	return sb.toString();
            } else {
	            while (temp != null) {
	            sb.append(temp + ", ");
	            temp = temp.getNext();
	            // System.out.println(head.getItem());
	            }
	        	return sb.toString().substring(0, sb.length() - 2);
        	}
        }
    }

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		while (sc.hasNext()) {
		String[] n = sc.nextLine().split(" ");
		switch(n[0]) {
			case "insertAt":
				try {
				list.insertAt(Integer.parseInt(n[1]), Integer.parseInt(n[2]));
				System.out.println(list);
				} catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			break;
			case "reverse":
				System.out.println(list.reverse());
				System.out.println(list);
			break;
		}
	}
	}
}