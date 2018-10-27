import java.util.Scanner;
/**
 * Class for studentdata.
 */
class Studentdata implements Comparable<Studentdata> {
    /**
     * rollno is of type int.
     */
    private int rollno;
    /**
     * name is of type string.
     */
    private String name;
    /**
     * totalmarks is of type double.
     */
    private double totalmarks;
    /**
     * Constructs the object.
     *
     * @param      rollnoo      The rollnoo
     * @param      namee        The namee
     * @param      totalmarkss  The totalmarkss
     */
    Studentdata(final int rollnoo, final String namee, final double totalmarkss) {
        rollno = rollnoo;
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
     * Gets the rollno.
     *
     * @return     The rollno.
     */
    public int getRollno() {
        return rollno;
    }
    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public double getMarks() {
        return totalmarks;
    }
    /**
     * { function_description }.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }.
     */
    public int compareTo(final Studentdata that) {
        if (this.getMarks() > that.getMarks()) {
            return 1;
        } else if (this.getMarks() < that.getMarks()) {
            return -1;
        }
        //  else if (this.getName().compareTo(that.getName()) > 0){
        //  return  1;
        // } else if (this.getName().compareTo(that.getName()) < 0) {
        //  return -1;
        // }
        if (this.getRollno() > that.getRollno()) {
            return 1;
        } else if (this.getRollno() < that.getRollno()) {
            return -1;
        } 
        return 0;
    }

}
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
        RedBlackBST<Studentdata, Double> st =
        new RedBlackBST<Studentdata, Double>();
        int inp = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < inp; i++) {
            String[] tokens = scan.nextLine().split(",");
            st.put(new Studentdata(Integer.parseInt(tokens[0]), tokens[1],
                Double.parseDouble(tokens[2])),
            Double.parseDouble(tokens[2]));

        }
        int intt = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < intt; i++) {
            String[] inpp = scan.nextLine().split(" ");
            if (inpp[0].equals("BE")) {
                for (Studentdata keys : st.keys()) {
                    if (keys.getMarks() >= Double.parseDouble(inpp[1]) &&
                        keys.getMarks() <= Double.parseDouble(inpp[2])) {
                        System.out.println(keys.getName());
                    }
                }
            } else if (inpp[0].equals("GE")) {
                // System.out.println("hkjh");
                for (Studentdata keys : st.keys()) {
                    // System.out.println(keys);
                    if (st.get(keys) >= Double.parseDouble(inpp[1])) {
                        System.out.println(keys.getName());
                    }
                }
            } else if (inpp[0].equals("LE")) {
                // System.out.println("hkjh");
                for (Studentdata keys : st.keys()) {
                    // System.out.println(keys);
                    if (st.get(keys) <= Double.parseDouble(inpp[1])) {
                        System.out.println(keys.getName());
                    }
                }
            }
            // else if (inpp[0].equals("LE")) {
            //  }
            // } else (inpp[0].equals("GE")) {
            //  for (int i = inpp[1]; i > 0; i--) {
            //  }
            }
        }
    }