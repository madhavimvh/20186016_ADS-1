import java.util.Scanner;
/**
 * Class for Solution.
 */
public final class Solutiongenerics {
    /**
     * Constructs the object.
     */
    private Solutiongenerics() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // LinkedList<Integer> intLinkedList = new LinkedList<Integer>();
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
class LinkedList<Matrix> {
    /**
     * declaring head.
     */
    private Node<Matrix> head;
    /**
     * Class for node.
     */
    private class Node<Matrix> {
        /**
         * declaring item.
         */
        private Matrix item;
        /**
         * declaring next.
         */
        private Node<Matrix> next;

        Node() {
            item = (Matrix)new Object();
            next = null;
        }
    }
    /**
     * Constructs the object.
     */
    LinkedList() {
        this.head = null;
    }
    /**
     * { function_description }.
     *
     * @param      value  The value
     */
    public void push(final Matrix value) {
        Node<Matrix> oldHead = head;
        head = new Node();
        head.item = value;
        head.next = oldHead;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Matrix pop() {
        if (head != null) {
            Matrix value = head.item;
            head = head.next;
            return value;
        }
        return null;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
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
    private LinkedList<Character> linked;
    /**
     * Constructs the object.
     *
     * @param      input1  The input 1
     */
    Balanceparens(final String input1) {
        this.input = input1;
        this.linked = new LinkedList<Character>();
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
                } else if (matching(linked.pop(), input.charAt(i))) {
                    return true;
                }
            }
        }
        // if (linked.isEmpty()) {
        //     return true;
        // } else {
        //     return false;
        // }
        return (linked.isEmpty());
    }
    /**
     * { function_description }.
     *
     * @param      char1  The character 1
     * @param      char2  The character 2
     *
     * @return     { description_of_the_return_value }
     */
    public boolean matching(final char char1, final char char2) {
        if (char1 == '(' && char1 == ')') {
            return true;
        } else if (char1 == '[' && char1 == ']') {
            return  true;
        } else if (char1 == '{' && char1 == '}') {
            return true;
        }
        return false;
    }
}
