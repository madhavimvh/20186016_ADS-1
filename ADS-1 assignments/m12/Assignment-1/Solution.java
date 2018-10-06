import java.util.Scanner;
// import java.time.LocalDate;
// import java.time.Period;
// import java.time.format.DateTimeFormatter;
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
     * { var_description }.
     */
    private static final int FIVE = 5;
    /**
     * { var_description }.
     */
    private static final int SIX = 6;
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int n1 = Integer.parseInt(scan.nextLine());
        int un = Integer.parseInt(scan.nextLine());
        int bc = Integer.parseInt(scan.nextLine());
        int sc = Integer.parseInt(scan.nextLine());
        int st = Integer.parseInt(scan.nextLine());
        Insertion sortlist = new Insertion();
        while (scan.hasNext()) {
            String[] s = scan.nextLine().split(",");
            sortlist.addStudent(new Student(s[0], s[1], Integer.parseInt(s[2]),
                Integer.parseInt(s[2 + 1]), Integer.parseInt(s[2 + 2]),
                Integer.parseInt(s[ FIVE]), s[SIX]));
        }
        sortlist.sort();
        System.out.println(sortlist);
        // sortlist.printres(un, bc, sc, st);
        System.out.println(sortlist.printres(un, bc, sc, st));

    }
}
/**
 * Class for student.
 */
class Student {
    /**
     * { var_description }.
     */
    private String name;
    /**
     * { var_description }.
     */
    private String[] date;
    /**
     * { var_description }.
     */
    private int year;
    /**
     * { var_description }.
     */
    private int month;
    /**
     * { var_description }.
     */
    private int day;
    /**
     * { var_description }.
     */
    private int s1;
    /**
     * { var_description }.
     */
    private int s2;
    /**
     * { var_description }.
     */
    private int s3;
    /**
     * { var_description }.
     */
    private int total;
    /**
     * { var_description }.
     */
    private String cat;
    /**
     * Constructs the object.
     *
     * @param      namee   The namee
     * @param      datee   The datee
     * @param      ss1     The ss 1
     * @param      ss2     The ss 2
     * @param      ss3     The ss 3
     * @param      totall  The totall
     * @param      catt    The catt
     */
    Student(final String namee, final String datee,
        final int ss1, final int ss2, final int ss3, final int totall,
        final String catt) {
        this.name = namee;
        this.date = datee.split("-");
        this.year = Integer.parseInt(date[0]);
        this.month = Integer.parseInt(date[1]);
        this.day = Integer.parseInt(date[2]);
        this.s1 = ss1;
        this.s2 = ss2;
        this.s3 = ss3;
        this.total = totall;
        this.cat = catt;
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
     * Gets the year.
     *
     * @return     The year.
     */
    public int getYear() {
        return year;
    }
    /**
     * Gets the month.
     *
     * @return     The month.
     */
    public int getMonth() {
        return month;
    }
    /**
     * Gets the day.
     *
     * @return     The day.
     */
    public int getDay() {
        return day;
    }
    /**
     * Gets the s 1.
     *
     * @return     The s 1.
     */
    public int getS1() {
        return s1;
    }
    /**
     * Gets the s 2.
     *
     * @return     The s 2.
     */
    public int getS2() {
        return s2;
    }
    /**
     * Gets the s 3.
     *
     * @return     The s 3.
     */
    public int getS3() {
        return s3;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public int getTotal() {
        return total;
    }
    /**
     * Gets the cat.
     *
     * @return     The cat.
     */
    public String getCat() {
        return cat;
    }
    // public int dobY(String date) {

    //  LocalDate localdate = LocalDate.now();
    //  LocalDate dob = LocalDate.parse(date,
    //  DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    //  int age = calculateAgeY(localdate, dob);
    //  return age;
    // }
    // public int getAgeY() {
    //  return dobY(date);
    // }
    // public int dobM(String date) {

    //  LocalDate localdate = LocalDate.now();
    //  LocalDate dob = LocalDate.parse(date,
    //  DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    //  int age = calculateAgeM(localdate, dob);
    //  return age;
    // }
    // public int getAgeM() {
    //  return dobM(date);
    // }
    // public int dobD(String date) {

    //  LocalDate localdate = LocalDate.now();
    //  LocalDate dob = LocalDate.parse(date,
    //  DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    //  int age = calculateAgeY(localdate, dob);
    //  return age;
    // }
    // public int getAgeD() {
    //  return dobD(date);
    // }

    /**
     * { function_description }.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(final Student that) {
        return this.compareTo(that) > 0;
    }
    /**
     * { function_description }.
     *
     * @param      object  The object
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Object object) {
        Student that = (Student) object;
        if (this.getTotal() > that.getTotal()) {
            return +1;
        } else if (this.getTotal() < that.getTotal()) {
            return -1;
        }
        if (this.getS3() > that.getS3()) {
            return +1;
        } else if (this.getS3() < that.getS3()) {
            return -1;
        }
        if (this.getS2() > that.getS2()) {
            return +1;
        } else if (this.getS2() < that.getS2()) {
            return -1;
        }
        if (this.getYear() > that.getYear()) {
            return +1;
        } else if (this.getYear() < that.getYear()) {
            return -1;
        }
        if (this.getMonth() > that.getMonth()) {
            return +1;
        } else if (this.getMonth() < that.getMonth()) {
            return -1;
        }
        if (this.getDay() < that.getDay()) {
            return +1;
        } else if (this.getDay() > that.getDay()) {
            return -1;
        }
        return 0;
    }
    // public int calculateAgeY(
    //      LocalDate birthDate,
    //      LocalDate currentDate) {
    // return Period.between(birthDate, currentDate).getYears();
    // }
    // public int calculateAgeM(
    //      LocalDate birthDate,
    //      LocalDate currentDate) {
    // return Period.between(birthDate, currentDate).getMonths();
    // }
    // public int calculateAgeD(
    //      LocalDate birthDate,
    //      LocalDate currentDate) {
    // return Period.between(birthDate, currentDate).getDays();
    // }
}
/**
 * Class for insertion.
 */
class Insertion {
    /**
     * 100 is a magic number.
     */
    private static final int HUN = 100;
    /**
     * studentlist is of type Tournament.
     */
    private Student[] studentlist;
    /**
     * size is of type int.
     */
    private int size;
    /**
     * Time complexity is 1.
     * Constructs the object.
     */
    Insertion() {
        studentlist = new Student[HUN];
        size = 0;
    }
    /**
     * Adds a tournament.
     * Time complexity is 1.
     * @param      t     t is of type Tournament.
     */
    public void addStudent(final Student t) {
        studentlist[size++] = t;
    }
    /**
     * Gets the tournament.
     * Time complexity is 1.
     * @param      index  The index
     *
     * @return     The tournament.
     */
    public Student getStudent(final int index) {
        return studentlist[index];
    }
    /**
     * Time complexity is N.
     * method to sort team ranking.
     */
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
            if (studentlist[j].less(studentlist[j - 1])) {
                exch(studentlist, j, j - 1);
            } else {
                break;
            }
            }
        }
    }
    /**
     * method to swap.
     * Time complexity is N.
     * @param      a     a is of type Tournament.
     * @param      i     i is of type int.
     * @param      j     j is of type int.
     */
    public void exch(final Student[] a, final int i, final int j) {
        Student temp = studentlist[i];
        studentlist[i] = studentlist[j];
        studentlist[j] = temp;
    }

    /**
     * { function_description }.
     *
     * @param      un    { parameter_description }
     * @param      bc    { parameter_description }
     * @param      sc    The screen
     * @param      st    { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String printres(final int un, final int bc, final int sc,
        final int st) {
        String s = "";
        for (int i = 0; i < un; i++) {
            s += studentlist[i].getName() + ","
            + studentlist[i].getTotal() + ","
            + studentlist[i].getCat() + "\n";

        }
        // int count = 0;
        // if (bc > 0) {
        //  for (int i = un; i < size; i++) {
        //      if (studentlist[i].getCat().equals("BC")) {
        //          s += studentlist[i].getName() + ","
        //          + studentlist[i].getTotal()
        //          + "," + studentlist[i].getCat() + "\n";
        //          count++;
        //          if (count == bc) {
        //              count = 0;
        //              if (studentlist[i].getCat().equals("SC")) {
        //                  s += studentlist[i].getName() + ","
        //                  + studentlist[i].getTotal()
        //                  + "," + studentlist[i].getCat() + "\n";
        //                  count++;
        //                  if (count == sc) {
        //                      if (studentlist[i].getCat().equals("ST")) {
        //                          s += studentlist[i].getName() + ","
        //                          + studentlist[i].getTotal()
        //                          + "," + studentlist[i].getCat() + "\n";
        //                          count++;
        //                          if (count == st) {
        //                              return;
        //                          }
        //                      }
        //                  }
        //              }
        //          }
        //      }
        //  }
        // }
        int count = 0;
        if (bc > 0) {
        for (int i = un; i < size; i++) {
            if (studentlist[i].getCat().equals("BC")) {
                s += studentlist[i].getName() + "," + studentlist[i].getTotal()
                + "," + studentlist[i].getCat() + "\n";
                count++;
                if (count == bc) {
                break;
            }
            }
        }
        }
        if (st  > 0) {
        count = 0;
        for (int i = (un + bc + 1); i < size; i++) {
            if (studentlist[i].getCat().equals("ST")) {
                s += studentlist[i].getName() + "," + studentlist[i].getTotal()
                + "," + studentlist[i].getCat() + "\n";
                count++;
                if (count == st) {
                break;
            }
            }
        }
        }
        if (sc > 0) {
        count = 0;
        for (int i = (un + bc + st + 1); i < size; i++) {
            if (studentlist[i].getCat().equals("SC")) {
                s += studentlist[i].getName() + "," + studentlist[i].getTotal()
                + "," + studentlist[i].getCat() + "\n";
                count++;
                if (count == sc) {
                break;
            }
            }
        }
    }
    return s;

    }
    /**
     * Returns a string representation of the object.
     * Time complexity is 1.
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        int i = 0;
        for (i = 0; i < size; i++) {
        s += studentlist[i].getName() + "," + studentlist[i].getTotal()
        + "," + studentlist[i].getCat() + "\n";
        }
        return s;
    }
}

