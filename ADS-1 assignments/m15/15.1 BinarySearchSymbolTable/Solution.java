import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Iterator;
class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty queue.
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) {
        	throw new NoSuchElementException("Queue underflow");
        }
        return first.item;
    }

    /**
     * Adds the item to this queue.
     *
     * @param  item the item to add
     */
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
        	first = last;
        }
        else {
        	oldlast.next = last;
        }
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) {
        	throw new NoSuchElementException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
        last = null;
        }  // to avoid loitering
        return item;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    } 

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() { 
        	return current != null;
        }
        public void remove() { 
        	throw new UnsupportedOperationException();  
        }
        public Item next() {
            if (!hasNext()) {
            	throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}
class BinarySearchST<Key extends Comparable<Key>, Value> {
	private static final int INIT_CAPACITY = 2;
	private Key[] keys;
    private Value[] vals;
    private int n = 0;
    /**
     * Initializes an empty symbol table.
     */
    public BinarySearchST() {
        this(INIT_CAPACITY);
    }
    /**
     * Initializes an empty symbol table with the specified initial capacity.
     * @param capacity the maximum capacity
     */
    public BinarySearchST(int capacity) { 
        keys = (Key[]) new Comparable[capacity]; 
        vals = (Value[]) new Object[capacity]; 
    }   
    // resize the underlying arrays
    private void resize(int capacity) {
        assert capacity >= n;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }
    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }


    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) {
        	throw new IllegalArgumentException("argument to contains() is null");
        } else {
        	return get(key) != null;
        }
    }

    /**
     * Returns the value associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) {
        	throw new IllegalArgumentException("argument to get() is null");
        }
        if (isEmpty()) {
        	return null;
        }
        int i = rank(key); 
        if (i < n && keys[i].compareTo(key) == 0) {
        	return vals[i];
        } else {
        	return null;
        }
    } 

    /**
     * Returns the number of keys in this symbol table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public int rank(Key key) {
        if (key == null) {
        	throw new IllegalArgumentException("argument to rank() is null"); 
		} else {
        int lo = 0, hi = n-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) {
            	hi = mid - 1;
            }
            else if (cmp > 0) {
            	lo = mid + 1;
            } else {
            	return mid;
            	} 
        }
        return lo;
    }
    }
    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
    	// System.out.println(key);
    	// System.out.println(val);
        if (key == null) {
        	throw new IllegalArgumentException("first argument to put() is null");
        	}
        if (val == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        // key is already in table
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        // insert new key-value pair
        if (n == keys.length) {
        	resize(2*keys.length);
        }
        for (int j = n; j > i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
        assert check();
    } 
    /**
     * Removes the specified key and associated value from this symbol table
     * (if the key is in the symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) {
        	throw new IllegalArgumentException("argument to delete() is null");
        }
        if (isEmpty()) {
        	return;
        }
        // compute rank
        int i = rank(key);
        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < n-1; j++) {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        n--;
        keys[n] = null;  // to avoid loitering
        vals[n] = null;
        // resize if 1/4 full
        if (n > 0 && n == keys.length/4) {
        	resize(keys.length/2);
        }
        assert check();
    }

    /**
     * Removes the smallest key and associated value from this symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin() {
        if (isEmpty()) {
        	throw new NoSuchElementException("Symbol table underflow error");
        }
        delete(min());
    }

    /**
     * Removes the largest key and associated value from this symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMax() {
        if (isEmpty()) {
        	throw new NoSuchElementException("Symbol table underflow error");
        }
        delete(max());
    }


   /***************************************************************************
    *  Ordered symbol table methods.
    ***************************************************************************/

   /**
     * Returns the smallest key in this symbol table.
     *
     * @return the smallest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    public Key min() {
        if (isEmpty()) {
        	throw new NoSuchElementException("called min() with empty symbol table");
        }
        return keys[0]; 
    }

    /**
     * Returns the largest key in this symbol table.
     *
     * @return the largest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    public Key max() {
        if (isEmpty()) {
        	throw new NoSuchElementException("called max() with empty symbol table");
        }
        return keys[n-1];
    }

    /**
     * Return the kth smallest key in this symbol table.
     *
     * @param  k the order statistic
     * @return the {@code k}th smallest key in this symbol table
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        return keys[k];
    }

    /**
     * Returns the largest key in this symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in this symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if (key == null) {
        	throw new IllegalArgumentException("argument to floor() is null");
        }
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
        	return keys[i];
        }
        if (i == 0) {
        	return null;
        } else {
        	return keys[i-1];
        }
    }

    /**
     * Returns the smallest key in this symbol table greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in this symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key ceiling(Key key) {
        if (key == null) {
        	throw new IllegalArgumentException("argument to ceiling() is null");
        }
        int i = rank(key);
        if (i == n) {
        	return null;
        } else {
        	return keys[i];
        }
    }

    /**
     * Returns the number of keys in this symbol table in the specified range.
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return the number of keys in this symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public int size(Key lo, Key hi) {
        if (lo == null) {
        	throw new IllegalArgumentException("first argument to size() is null");
        }
        if (hi == null) {
        	throw new IllegalArgumentException("second argument to size() is null");
        }
        if (lo.compareTo(hi) > 0) {
        	return 0;
        }
        if (contains(hi)) {
        	return rank(hi) - rank(lo) + 1;
        } else {
        	return rank(hi) - rank(lo);
        }
    }

    /**
     * Returns all keys in this symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    /**
     * Returns all keys in this symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return all keys in this symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) {
        	throw new IllegalArgumentException("first argument to keys() is null");
        }
        if (hi == null) {
        	throw new IllegalArgumentException("second argument to keys() is null");
        }
        Queue<Key> queue = new Queue<Key>();
        if (lo.compareTo(hi) > 0) {
        	return queue;
        }
        for (int i = rank(lo); i < rank(hi); i++) 
            queue.enqueue(keys[i]);
	        if (contains(hi)) {
	        	queue.enqueue(keys[rank(hi)]);
	        }
        return queue; 
    }
    public String toString() {
    	String s = "";
    	for (int i = 0; i < size(); i++) {
    		s += keys[i] + " " + vals[i] + "\n";
    	}
    	return s;
    }



   /***************************************************************************
    *  Check internal invariants.
    ***************************************************************************/

    private boolean check() {
        return isSorted() && rankCheck();
    }

    // are the items in the array in ascending order?
    private boolean isSorted() {
        for (int i = 1; i < size(); i++) {
            if (keys[i].compareTo(keys[i-1]) < 0) {
            	return false;
            }
        }
        return true;
    }

    // check that rank(select(i)) = i
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) {
            	return false;
            }
        }
        for (int i = 0; i < size(); i++) {
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) {
            	return false;
            }
        }
        return true;
    }
}

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] arr = scan.nextLine().split(" ");
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
				st.put(arr[i], i);
		}
		while (scan.hasNext()) {
		String[] input = scan.nextLine().split(" ");
		switch(input[0]) {
			case "max":
			System.out.println(st.max());
			break;
			case "floor":
			System.out.println(st.floor(input[1]));
			break;
			case "rank":
			System.out.println(st.rank(input[1]));
			break;
			case "deleteMin":
			st.deleteMin();
			break;
			case "contains":
			System.out.println(st.contains(input[1]));
			break;
			case "keys":
			System.out.println(st.toString());
			break;
			case "get":
			System.out.println(st.get(input[1]));
			break;
			default:
			break;
		}
	}

	}
}
