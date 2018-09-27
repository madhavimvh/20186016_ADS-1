import java.util.Scanner;
/**
 * class for Solution.
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
        Linkedlist list = new Linkedlist();
        String[] arr = sc.nextLine().split(" ");
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case "*":
                // System.out.println("madddy" + list.pop());
                // System.out.println("bunntj" + list.pop());
                x = list.mul(list.pop(), list.pop());
                list.push(x);
                break;
                case "+":
                // System.out.println("jlj" + list.pop());
                // System.out.println("kjh" + list.pop());
                x = list.add(list.pop(), list.pop());
                list.push(x);
                break;
                default:
                list.push(Integer.parseInt(arr[i]));
                break;
            }
        }
        System.out.println(x);
    }
}
/**
 * Class for linkedlist.
 */
class Linkedlist {
    /**
     * { var_description }.
     */
    private Node head;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * { var_description }.
         */
        private int item;
        /**
         * { var_description }.
         */
        private Node next;
        // Node (int item) {
        //  this.item = item;
        // }
    }
    /**
     * Constructs the object.
     */
    Linkedlist() {
        this.head = null;
    }
    /**
     * { function_description }.
     *
     * @param      value  The value
     */
    public void push(final int value) {
        // System.out.println("kjbkj");
        // System.out.println(value);
        Node oldhead = head;
        head = new Node();
        head.item = value;
        head.next = oldhead;
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
            // System.out.println(value);
            return value;
        }
        return '\0';
    }
    /**
     * { function_description }.
     *
     * @param      n     { parameter_description }
     * @param      m     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int add(final int n, final int m) {
        return n + m;
    }
    /**
     * { function_description }.
     *
     * @param      m     { parameter_description }
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int mul(final int m, final int n) {
        // System.out.println(n * m);
        return m * n;
    }
}