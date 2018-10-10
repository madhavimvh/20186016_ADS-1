import java.util.Scanner;
/**
 * Class for solution.
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
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(" ");
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
                st.put(arr[i], i);
        }
        while(scan.hasNext()) {
        String[] input = scan.nextLine().split(" ");
        switch (input[0]) {
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
