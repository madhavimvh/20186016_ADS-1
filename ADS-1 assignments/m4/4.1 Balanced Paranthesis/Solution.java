import java.util.Scanner;
/**
 * Class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        while (sc.hasNext()) {
            String input = sc.nextLine();
        Balanceparens paren = new Balanceparens(input);
            if (paren.checkbraces()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
/**
 * List of linkeds.
 */
class LinkedList {
    /**
     * declaring head.
     */
    private Node head;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * declaring item.
         */
        private char item;
        /**
         * declaring next.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    public LinkedList() {
        this.head = null;
    }
    /**
     * { function_description }.
     *
     * @param      value  The value
     */
    public void push(final char value) {
        Node oldHead = head;
        head = new Node();
        head.item = value;
        head.next = oldHead;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
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
/**
 * Class for balanceparens.
 */
class Balanceparens {
    /**
     * declaring input.
     */
    private String input;
    /**
     * declaring linked.
     */
    private LinkedList linked;
    /**
     * Constructs the object.
     *
     * @param      input1  The input 1
     */
    public Balanceparens(final String input1) {
        this.input = input1;
        this.linked = new LinkedList();
    }
    /**
     * checkbraces method.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean checkbraces() {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '{'
                || input.charAt(i) == '[') {
                linked.push(input.charAt(i));
            }
            if (input.charAt(i) == ')' || input.charAt(i) == '}'
                || input.charAt(i) == ']') {
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
    public boolean matching(final char char1, final char char2) {
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