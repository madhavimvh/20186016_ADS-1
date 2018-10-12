import java.util.Scanner;
/**
 * cubesum class.
 */
public final class CubeSum implements Comparable<CubeSum> {
    /**
     * 100 is magic number.
     */
    private static final int HUN = 600;
    /**
     * sum is of tyo
     */
    private final int sum;
    /**
     * { var_description }.
     */
    private final int i;
    /**
     * { var_description }.
     */
    private final int j;
    /**
     * Constructs the object.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public CubeSum(final int i, final int j) {
        this.sum = i*i*i + j*j*j;
        this.i = i;
        this.j = j;
    }
    /**
     * { function_description }.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int n = HUN;
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int temp = -1;
        int count = 0;
        // int n = Integer.parseInt(arg[0]);
        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }
        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if (temp == s.sum) {
                count++;
            } else {
                count = 0;
            }
            if (count == M - 1) {
                N--;
                if (N == 0) {
                    System.out.println(s.sum);
                    break;
                }
            }
            temp = s.sum;
            if (s.j < n)
                pq.insert(new CubeSum(s.i, s.j + 1));
        }
    }
}
