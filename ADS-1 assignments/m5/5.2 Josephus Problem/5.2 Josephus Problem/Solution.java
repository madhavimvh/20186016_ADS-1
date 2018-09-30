import java.util.Scanner;
/**
 * class solution.
 */
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        while (n != 0) {
            String[] tokens = scan.nextLine().split(" ");
            int size = Integer.parseInt(tokens[0]);
            int[] new1 = new int[size];
            int temp = Integer.parseInt(tokens[1]);
            for (int i = 0; i < size; i++) {
                new1[i] = i;
            }
            //System.out.println(Arrays.toString(new1));
            int count = size, i = 1, index = 0;
            String s = "";
            while (count != 0) {
                if (new1[index % size] != -1) {
                    if (i == temp) {
                        s += new1[index % size] + " ";
                        new1[index % size] = -1;
                        count--;
                        i = 1;
                        index++;
                    } else {
                        index++;
                        i++;
                    }
                } else {
                    index++;
                }

            }
            s = s.substring(0, s.length() - 1);
            System.out.println(s);
            n--;
        }
    }
}

