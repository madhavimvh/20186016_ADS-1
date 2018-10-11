import java.util.Scanner;
class BookInfo implements Comparable {
	private String name;
	private String author;
	private float price;
	BookInfo(final String namee, final String authorr, final float pricee) {
		this.name = namee;
		this.author = authorr;
		this.price = pricee;
	}
	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public int compareTo(final Object object) {
		BookInfo that = (BookInfo) object;
		return this.name.compareTo(that.name);
	}
}
class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private BookInfo key;           // sorted by key
        private Value val;         // associated data
        private Node left;
        private Node right;  // left and right subtrees

        public Node(BookInfo keyy, Value vall) {
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
    public void put(BookInfo key, Value val) {
        root = put(root, key, val);
    }
    private Node put(Node x, BookInfo key, Value val) {
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
public class Solution {
	public static void main(String[] args) {
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