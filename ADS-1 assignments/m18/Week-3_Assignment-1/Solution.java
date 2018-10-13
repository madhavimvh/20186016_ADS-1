import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;


public final class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MinPQ<Stock> min = new MinPQ<Stock>();
		MaxPQ<Stock> max = new MaxPQ<Stock>();
		BST<String, Integer> bstmin = new BST<String, Integer>();
		BST<String, Integer> bstmax = new BST<String, Integer>();
		int n = Integer.parseInt(scan.nextLine());
		int N = 6 * n;
		while (N > 0) {
		for (int i = 0; i < n; i++) {
			String[] inp = scan.nextLine().split(",");
			min.insert(new Stock(inp[0], Float.parseFloat(inp[1])));
			max.insert(new Stock(inp[0], Float.parseFloat(inp[1])));
			N--;
		}
		String s = "";
		for (int i = 0; i < 5; i++) {
			Stock temp = max.delMax();
			s += temp + "\n";
		}
		System.out.println(s);
		String a = "";
		for (int i = 0; i < 5; i++) {
			a += min.delMin() + "\n";
		}
		System.out.println(a);
		}
		// int num = 5;
  //       for (int i = 0; i < num; i++) {
  //           Stock temp = max.delMax();
  //           bstmax.put(temp.getName(), bstmax.get(temp.getName()) + 1 );
  //       }
  //       System.out.println(bstmax);
  //       for (int i = 0; i < num; i++) {
  //               Stock temp = min.delMin();
  //               bstmin.put(temp.getName(), bstmax.get(temp.getName()) + 1);
  //               }
  //               System.out.println(bstmin);
  //           }
	}
}
class Stock implements Comparable{
	private String name;
	private float perchange;
	Stock(String namee, float perchangee) {
		this.name = namee;
		this.perchange = perchangee;
	}
	public String getName() {
		return name;
	}
	public float getPerchange() {
		return perchange;
	}
	public int compareTo(final Object object) {
		Stock that = (Stock) object;
		if (this.perchange > that.perchange) {
			return 1;
		} else if (this.perchange < that.perchange) {
			return -1;
		} else if (this.name.charAt(0) > that.name.charAt(0)) {
			return 1;
		} else {
			return -1;
		}
	}
	public String toString() {
		return name + " " + perchange;
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
    private Node root;
    /**
     * { item_description }.
     */
    private class Node {
        /**
         * { var_description }.
         */
        private Key key;
        /**
         * { item_description }.
         */
        private Value val;
        /**
         * { item_description }.
         */
        private Node left;
        /**
         * { var_description }.
         */
        private Node right;
        /**
         * Constructs the object.
         *
         * @param      keyy  The keyy
         * @param      vall  The vall
         */
        Node(final Key keyy, final Value vall) {
            this.key = keyy;
            this.val = vall;
            left = null;
            right = null;
        }
    }
    /**
     * Initializes an empty symbol table.
     */
    BST() {
        root = null;
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(final Key key) {
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
    public void put(final Key key, final Value val) {
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
    private Node put(final Node x, final Key key, final Value val) {
        if (x == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left  = put(x.left,  key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val   = val;
        }
        return x;
    }
}
// class Queries {
// }
