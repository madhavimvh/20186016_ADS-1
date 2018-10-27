import java.util.Scanner;
/**
 * Solution class.
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
        LinearProbingHashST<Integer, Studentdata> st =
        new LinearProbingHashST<Integer, Studentdata>();
        Scanner scan = new Scanner(System.in);
        int inp = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < inp; i++) {
            String[] tokens = scan.nextLine().split(",");
            st.put(Integer.parseInt(tokens[0]),
                new Studentdata(tokens[1], Double.parseDouble(tokens[2])));

        }
        int inpp = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < inpp; i++) {
            String[] tokenss = scan.nextLine().split(" ");
            // st.query(tokenss[1], Integer.parseInt(tokenss[2]));
            if (Integer.parseInt(tokenss[2]) == 1) {
                if (st.contains(Integer.parseInt(tokenss[1]))) {
                    System.out.println(st.get(
                        Integer.parseInt(tokenss[1])).getName());
                } else {
                    System.out.println("Student doesn't exists...");
                }
            } else if (Integer.parseInt(tokenss[2]) == 2) {
                if (st.contains(Integer.parseInt(tokenss[1]))) {
                    System.out.println(st.get(
                        Integer.parseInt(tokenss[1])).getMarks());
                } else {
                    System.out.println("Student doesn't exists...");
                }
            }
        }
    }
}
/**
 * Class for studentdata.
 */
class Studentdata {
    /**
     * { var_description }.
     */
    private String name;
    /**
     * { var_description }.
     */
    private double totalmarks;
    /**
     * Constructs the object.
     *
     * @param      namee        The namee
     * @param      totalmarkss  The totalmarkss
     */
    Studentdata(final String namee, final double totalmarkss) {
        // rollno = rollnoo;
        name = namee;
        totalmarks = totalmarkss;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public double getMarks() {
        return totalmarks;
    }
    // public void query(String roll, int n) {
    //  if (n == 1) {
    //  }
    // }
}

