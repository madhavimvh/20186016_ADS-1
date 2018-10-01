import java.util.Scanner;
// import java.util.LinkedList;
class AddLargeNumbers {
		// public AddLargeNumbers() {
		// 	this.linked = new LinkedList();
		// // }

    public static LinkedList numberToDigits(String number) {
		LinkedList linked = new LinkedList();
    	String[] s = number.split("");
    	for (int i = 0; i < s.length; i++) {
    		linked.push(s[i]);
    	}
    	// System.out.println(linked.display());
    	return linked;
    }

    public static String digitsToNumber(LinkedList list) {
    	String rev = "";
    	String s = "";
    	while (!list.isEmpty()) {
    		s += list.pop();
    	}
    	for (int i = s.length() - 1; i >= 0; i--) {
    		rev += s.charAt(i);
    	}
    	return rev;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    	LinkedList result = new LinkedList();
    	String a = "";
    	int carry = 0;
    	int sum = 0;
    	String sum1 = "";
    	int flag = 0;
    	Stack s1 = new Stack();
    	Stack s2 = new Stack();
    	Stack s3 = new Stack();
    	Stack s4 = new Stack();
    	while (!list1.isEmpty()) {
    		s1.push(Integer.parseInt(list1.pop()));
    	}
    		// System.out.println(s1.pop());
    	while (!s1.isEmpty()) {
    		s3.push(s1.pop());
    	}
    		// System.out.println(s3.pop());
    	while (!list2.isEmpty()) {
    		s2.push(Integer.parseInt(list2.pop()));
    	}
    	while (!s2.isEmpty()) {
    		s4.push(s2.pop());
    	}
    	while(!s3.isEmpty() && !s4.isEmpty()) {
    		a = String.valueOf(s3.pop() + s4.pop());
    		System.out.println(a);
    		if (a.charAt(0) == '1') {
    			System.out.println("kjk");
    			System.out.println(a.charAt(0));
    			sum = Integer.parseInt(String.valueOf(a.charAt(1))) + carry;
    			carry = 1;
    			sum1 += sum;
    			System.out.println("frst");
    			System.out.println(sum1);
    		} else {
    			sum = Integer.parseInt(String.valueOf(a.charAt(1)));
    			sum1 += sum;
    			System.out.println("thrd");
    			System.out.println(sum1);
    		}
    	}
    	result.push(sum1);
    	return result;
    }
    public static int charToInt(char c) {
    	return Integer.parseInt(Character.toString(c));
    }

}
class Node {
        /**
         * declaring item.
         */
        String item;
        /**
         * declaring next.
         */
        Node next;
        Node() {
        	this.item = null;
        	this.next = null;
        }
        Node(String item) {
        	this.item = item;
        	this.next = next;
        }
    }
/**
 * List of linkeds.
 */
class LinkedList {
    /**
     * declaring head.
     */
    Node head;
    int size;
    /**
     * Class for node.
     */
    class Node {
        /**
         * declaring item.
         */
        String item;
        /**
         * declaring next.
         */
        Node next;
        Node() {
        	this.item = null;
        	this.next = null;
        }
        Node(String item) {
        	this.item = item;
        	this.next = next;
        }
    }
    /**
     * Constructs the object.
     */
    LinkedList() {
        this.head = null;
        this.size = 0;
    }
    /**
     * { function_description }.
     *
     * @param      value  The value
     */
    public void push(final String value) {
        Node oldHead = head;
        head = new Node(value);
        head.item = value;
        head.next = oldHead;
        size++;
        // System.out.println(value);
        // System.out.println("lsjdj");
        // System.out.println(head.item);
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String pop() {
        if (head != null) {
            String value = head.item;
            head = head.next;
            size--;
            return value;
        }
        return "\0";
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (head == null);
    }
    public int size() {
    	return size;
    }
    public String to() {
    	String rev = "";
    	String s = "";
    	Node current = head;
    	while (current != null) {
    		s += current.item;
    		current = current.next;
    	}
    	for (int i = s.length() - 1; i >= 0; i--) {
    		rev += s.charAt(i);
    	}
    	return rev;
    }
    // public void printlist(Node head) {
    // 	while (head != null) {
    // 		System.out.println("khkh");
    // 		System.out.print(head.item);
    // 		head = head.next;
    // 	}
    // }
}
class Stack {
    /**
     * declaring head.
     */
    Node head;
    int size;
    /**
     * Class for node.
     */
    class Node {
        /**
         * declaring item.
         */
        int item;
        /**
         * declaring next.
         */
        Node next;
        Node() {
        	this.item = 0;
        	this.next = null;
        }
        Node(int item) {
        	this.item = item;
        	this.next = next;
        }
    }
    /**
     * Constructs the object.
     */
    Stack() {
        this.head = null;
        this.size = 0;
    }
    /**
     * { function_description }.
     *
     * @param      value  The value
     */
    public void push(final int value) {
        Node oldHead = head;
        head = new Node(value);
        head.item = value;
        head.next = oldHead;
        size++;
        // System.out.println(value);
        // System.out.println("lsjdj");
        // System.out.println(head.item);
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int pop() {
        if (head != null) {
            int value = head.item;
            head = head.next;
            size--;
            return value;
        }
        return 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (head == null);
    }
    public int size() {
    	return size;
    }
    public String display() {
    	String rev = "";
    	String s = "";
    	Node current = head;
    	while (current != null) {
    		s += current.item;
    		current = current.next;
    	}
    	for (int i = s.length() - 1; i >= 0; i--) {
    		rev += s.charAt(i);
    	}
    	return rev;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                // System.out.println(pDigits.display());
                // System.out.println(qDigits.display());
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
