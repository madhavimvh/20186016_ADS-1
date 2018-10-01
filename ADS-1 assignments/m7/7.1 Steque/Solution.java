import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
        /**
         * value is of type int.
         */
        private int value;
        /**
         * next is of type Node.
         */
        private Node next;
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
/**
 * Class for steque.
 */
class Steque {
    /**
     * head is of type Node.
     */
    private Node head;
    /**
     * tail is of type Node.
     */
    private Node tail;
    /**
     * size is of type int.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Steque() {
        head = null;
        tail = null;
        size = 0;
    }
    /**
     * add an element into stack.
     *
     * @param      element  The element
     */
    public void push(final int element) {
        Node oldhead = head;
        head = new Node(element, oldhead);
        if (oldhead == null) {
            tail = head;
        }
        size++;
        // System.out.println(element);
        // System.out.println(head.getItem());
    }
    /**
     * returns nothing and removes an element f from the stack.
     */
    public void pop() {
        if (head != null && tail != null) {
            if (head.getNext() == null && tail.getNext() == null) {
                head = null;
                tail = head;
                size--;
            } else if (head != null) {
                head = head.getNext();
                size--;
            }
        }
    }
    /**
     * add an element at the end of stack.
     *
     * @param      element  The element
     */
    public void enqueue(final int element) {
        if (tail != null) {
            Node oldtail = tail;
            tail = new Node(element, null);
            oldtail.setNext(tail);
        } else if (head == null && tail == null) {
            head = new Node(element, null);
            tail = head;
        }
        size++;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        if (size == 0) {
            sb.append("Steque is empty.");
            return sb.toString();
        } else {
            Node temp = head;
            while (temp != null) {
            sb.append(temp + ", ");
            temp = temp.getNext();
            // System.out.println(head.getItem());
            }
        return sb.toString().substring(0, sb.length() - 2);
        }
    }
}
/**
 * class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n > 0) {
        Steque steque = new Steque();
        while (sc.hasNext()) {
        String[] line = sc.nextLine().split(" ");
        switch (line[0]) {
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
            System.out.println();
            break;
        }
        n--;
        }
    }
}
}