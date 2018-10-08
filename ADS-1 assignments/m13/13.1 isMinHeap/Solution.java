
import java.util.Scanner;
/**
 * Class for minheap.
 *
 * @param      <E>   { parameter_description }
 */
class Minheap<E extends Comparable<E>> {
    /**
     * str is of type E.
     */
    private E[] str;
    /**
     * Constructs the object.
     *
     * @param      strr  The strr
     */
    Minheap(final E[] strr) {
        this.str = strr;
    }
    /**
     * method to check whether the array is Minheap or not.
     *
     * @return     returns boolean.
     */
    public boolean checkMinheap() {
        int x = str.length;
        for (int i = 0; i < x / 2; i++) {
            if (!less(str[i], str[(2 * i) + 1]) && !less(str[i], str[(2 * i) + 2])) {
                return false;
            }
        }
        return true;
    }
    /**
     * method to compare two elements.
     *
     * @param      i     i is of type E.
     * @param      j     j is of type E.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(final E i, final E j) {
        return i.compareTo(j) <= 0;
    }
}
/**
 * class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int n = Integer.parseInt(scan.nextLine());
        switch (str) {
            case "String":
            while (n > 0) {
                String[] st = scan.nextLine().split(",");
                Minheap<String> heap = new Minheap<String>(st);
                System.out.println(heap.checkMinheap());
                n--;
            }
            break;
            case "Integer":
            while (n > 0) {
                String[] s = scan.nextLine().split(",");
                Integer[] sr = new Integer[s.length];
                for (int i = 0; i < s.length; i++) {
                    sr[i] = Integer.parseInt(s[i]);
                }
                Minheap<Integer> heap = new Minheap<Integer>(sr);
                System.out.println(heap.checkMinheap());
                n--;
            }
            break;
            case "Double":
            while (n > 0) {
                String[] s = scan.nextLine().split(",");
                Double[] sr = new Double[s.length];
                for (int i = 0; i < s.length; i++) {
                    sr[i] = Double.parseDouble(s[i]);
                }
                Minheap<Double> heap = new Minheap<Double>(sr);
                System.out.println(heap.checkMinheap());
                n--;
            }
            break;
            case "Float":
            while (n > 0) {
                String s = scan.nextLine();
                if (s.equals("")) {
                    System.out.println("false");
                    break;
                } else {
                String[] ss = s.split(",");
                Float[] sr = new Float[ss.length];
                for (int i = 0; i < ss.length; i++) {
                    sr[i] = Float.parseFloat(ss[i]);
                }
                Minheap<Float> heap = new Minheap<Float>(sr);
                System.out.println(heap.checkMinheap());
                n--;
            }
            }
            break;
            default:
            break;
        }
    }
}

