import java.util.Scanner;
import java.util.Arrays;
/**
 * { item_description }.
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
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        String[] arr1 = new String[n1];
        String[] arr2 = new String[n2];
        if (n1 > 0) {
        arr1 = scan.nextLine().split(",");
        } else {
            scan.nextLine();
        }
        if (n2 > 0) {
        arr2 = scan.nextLine().split(",");
        } else {
            scan.nextLine();
        }
        Sortedarr array = new Sortedarr(arr1, arr2);
        System.out.println(Arrays.toString(array.result()).
            replace("[", "").replace("]", "").replace(" ", ""));
    }
}
/**
 * Class for sortedarr.
 */
class Sortedarr {
    /**
     * { var_description }.
     */
    private String[] arr1;
    /**
     * { var_description }.
     */
    private String[] arr2;
    /**
     * { var_description }.
     */
    private String[] arr;
    /**
     * Constructs the object.
     *
     * @param      arrr1  The arrr 1
     * @param      arrr2  The arrr 2
     */
    Sortedarr(final String[] arrr1, final String[] arrr2) {
        this.arr1 = arrr1;
        this.arr2 = arrr2;
        this.arr = new String[arr1.length + arr2.length];
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String[] result() {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[j])) {
                arr[k++] = arr1[i];
                i++;
            } else {
                arr[k++] = arr2[j];
                j++;
            }
        }
        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }
        return arr;
    }
}