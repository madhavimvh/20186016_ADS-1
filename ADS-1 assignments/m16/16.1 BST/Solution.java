import java.util.Scanner;
/**
 * Class for book information.
 */
class BookInfo implements Comparable {
    /**
     * name is of type String.
     */
    private String name;
    /**
     * author is of type String.
     */
    private String author;
    /**
     * price is of type float
     */
    private float price;
    /**
     * Constructs the object.
     *
     * @param      namee    The namee
     * @param      authorr  The authorr
     * @param      pricee   The pricee
     */
    BookInfo(final String namee, final String authorr, final float pricee) {
        this.name = namee;
        this.author = authorr;
        this.price = pricee;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * compareTo method
     *
     * @param      object  The object
     *
     * @return     returns int.
     */
    public int compareTo(final Object object) {
        BookInfo that = (BookInfo) object;
        return this.name.compareTo(that.name);
    }
}
/**
 * Class for bst.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BST<Key extends Comparable<Key>, Value> {
    /**
     * { var_description }.
     */
    private Node root;             // root of BST
    private class Node {
        private BookInfo key;           // sorted by key
        private Value val;         // associated data
        private Node left;
        private Node right;
        /**
         * Constructs the object.
         *
         * @param      keyy  The keyy
         * @param      vall  The vall
         */
        public Node(final BookInfo keyy, final Value vall) {
            this.key = keyy;
            this.val = vall;
            left = null;
            right = null;
        }
    }
    /**
     * Initializes an empty symbol table.
     */
    public BST() {
        root = null;
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(final BookInfo key) {
        Node s = root;
        while (s != null) {
            int cmp = key.compareTo(s.key);
            if (cmp < 0) {
                s = s.left;
            } else if (cmp > 0) {
                s = s.right;
            } else if (cmp == 0) {
                return s.val;
            }
        }
        return null;
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final BookInfo key, final Value val) {
        root = put(root, key, val);
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     */
    private Node put(final Node x, final BookInfo key, final Value val) {
        if (x == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left  = put(x.left,  key, val);
        }
        else if (cmp > 0) {
            x.right = put(x.right, key, val);
        }
        else {
            x.val   = val;
        }
        return x;
    }
}
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
        Scanner scan = new Scanner(System.in);
        BST<String, Integer> bst = new BST<String, Integer>();
        while (scan.hasNext()) {
            String[] arr = scan.nextLine().split(",");
            switch (arr[0]) {
                case "put":
                BookInfo str = new BookInfo(arr[1], arr[2], Float.parseFloat(arr[2 + 1]));
                bst.put(str, Integer.parseInt(arr[2 + 2]));
                break;
                case "get":
                str = new BookInfo(arr[1], arr[2], Float.parseFloat(arr[2 + 1]));
                if (bst.get(str) == null) {
                    System.out.println("null");
                } else {
                    System.out.println(bst.get(str));
                }
                break;
                default:
                break;
            }
        }
    }
}
