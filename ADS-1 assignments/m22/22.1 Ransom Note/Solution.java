import java.util.Scanner;
// import java.lang.Iterable;
// import java.util.Iterator;
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
        SeparateChainingHashST<String, Integer> hash = new SeparateChainingHashST<String, Integer>();
        String intg = scan.nextLine();
        String[] arr = scan.nextLine().split(" ");
        for(int i = 0; i < arr.length; i++) {
            if (hash.contains(arr[i])) {
                hash.put(arr[i], hash.get(arr[i]) + 1); 
            } else {
                hash.put(arr[i], 1);
            }
        }
        String[] tobeSearched = scan.nextLine().split(" ");
        for (int i = 0; i < tobeSearched.length; i++) {
            if (hash.contains(tobeSearched[i]) ) {
                if(hash.get(tobeSearched[i]) == 0) {
                    System.out.print("No");
                    return;
                } else {
                    hash.put(tobeSearched[i], hash.get(tobeSearched[i]) - 1);
                }
            } else {
                System.out.print("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
